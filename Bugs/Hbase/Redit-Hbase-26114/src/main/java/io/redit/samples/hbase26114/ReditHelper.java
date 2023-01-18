package io.redit.samples.hbase26114;

import io.redit.ReditRunner;
import io.redit.dsl.entities.Deployment;
import io.redit.dsl.entities.PathAttr;
import io.redit.dsl.entities.ServiceType;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReditHelper {
    private static final int NN_HTTP_PORT = 50070;
    private static final int NN_RPC_PORT = 8020;
    public static int numOfServers = 3;
    private static int numOfNNs = 3;
    private static int numOfDNs = 3;
    private static int numOfJNs = 3;
    public static final String hadoopDir = "hadoop-3.1.2";
    public static final String zookeeperDir = "apache-zookeeper-3.7.1-bin";
    public static final String hbaseDir = "hbase-2.2.2";
    public static String getHadoopHomeDir(){
        return "/hadoop/" + hadoopDir;
    }
    public static String getZookeeperHomeDir(){
        return "/zookeeper/" + zookeeperDir;
    }
    public static String getHbaseHomeDir(){
        return "/hbase/" + hbaseDir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String hadoopCompressedPath = workDir + "/../../../Archive/Hadoop/Original/" + hadoopDir + ".tar.gz";
        String zookeeperCompressedPath = workDir + "/../../../Archive/Zookeeper/Original/" + zookeeperDir + ".tar.gz";
        String hbaseCompressedPath = workDir + "/../../../Archive/Hbase/Hbase-26114/" + hbaseDir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-hbase")
                .withService("hadoop-base")
                .applicationPath(hadoopCompressedPath, "/hadoop",  PathAttr.COMPRESSED)
                .applicationPath("conf/hdfs-site.xml", getHadoopHomeDir() + "/etc/hadoop/hdfs-site.xml")
                .applicationPath("conf/core-site.xml", getHadoopHomeDir() + "/etc/hadoop/core-site.xml")
                .dockerImageName("mengpo1106/hadoop").dockerFileAddress("docker/Dockerfile", true)
                .environmentVariable("HADOOP_HOME", getHadoopHomeDir()).environmentVariable("HADOOP_HEAPSIZE_MAX", "1g")
                .libraryPath(getHadoopHomeDir() + "/share/hadoop/**/*.jar")
                .libraryPath(getHadoopHomeDir() + "/share/hadoop/**/*.java")
                .logDirectory(getHadoopHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("hbase")
                .applicationPath(zookeeperCompressedPath, "/zookeeper",  PathAttr.COMPRESSED)
                .applicationPath("conf/zoo.cfg", getZookeeperHomeDir() + "/conf/zoo.cfg")
                .applicationPath(hbaseCompressedPath, "/hbase",  PathAttr.COMPRESSED)
                .applicationPath("conf/hbase-env.sh", getHbaseHomeDir() + "/conf/hbase-env.sh")
                .applicationPath("conf/hbase-site.xml", getHbaseHomeDir() + "/conf/hbase-site.xml")
                .applicationPath("conf/regionservers", getHbaseHomeDir() + "/conf/regionservers")
                .applicationPath("conf/hdfs-site.xml", getHbaseHomeDir() + "/conf/hdfs-site.xml")
                .applicationPath("conf/core-site.xml", getHbaseHomeDir() + "/conf/core-site.xml")
                .dockerImageName("mengpo1106/hbase").dockerFileAddress("docker/Dockerfile", true)
                .environmentVariable("HBASE_HOME", getHbaseHomeDir())
                .libraryPath(getZookeeperHomeDir() + "/lib/*.jar")
                .libraryPath(getHbaseHomeDir() + "/lib/*.jar")
                .logDirectory(getZookeeperHomeDir() + "/logs")
                .logDirectory(getHbaseHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("nn", "hadoop-base").tcpPort(NN_HTTP_PORT, NN_RPC_PORT)
                .initCommand(getHadoopHomeDir() + "/bin/hdfs namenode -bootstrapStandby")
                .startCommand(getHadoopHomeDir() + "/bin/hdfs --daemon start namenode")
                .stopCommand(getHadoopHomeDir() + "/bin/hdfs --daemon stop namenode").and()
                .nodeInstances(numOfNNs, "nn", "nn", true)
                .withService("dn", "hadoop-base")
                .startCommand(getHadoopHomeDir() + "/bin/hdfs --daemon start datanode")
                .stopCommand(getHadoopHomeDir() + "/bin/hdfs --daemon stop datanode").and()
                .nodeInstances(numOfDNs, "dn", "dn", true)
                .withService("jn", "hadoop-base")
                .startCommand(getHadoopHomeDir() + "/bin/hdfs --daemon start journalnode")
                .stopCommand(getHadoopHomeDir() + "/bin/hdfs --daemon stop journalnode").and()
                .nodeInstances(numOfJNs, "jn", "jn", false);

        builder.node("nn1").initCommand(getHadoopHomeDir() + "/bin/hdfs namenode -format").and();
        addRuntimeLibsToDeployment(builder, getHadoopHomeDir());
        addInstrumentablePath(builder, "/share/hadoop/hdfs/hadoop-hdfs-3.1.2.jar");

        builder.withService("server", "hbase").and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1")
                .applicationPath("conf/server1/myid", getZookeeperHomeDir() + "/zkdata/myid").and()
                .node("server2")
                .applicationPath("conf/server2/myid", getZookeeperHomeDir() + "/zkdata/myid").and()
                .node("server3")
                .applicationPath("conf/server3/myid", getZookeeperHomeDir() + "/zkdata/myid").and();

        return builder.build();
    }

    public static void startHdfsNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
        if (numOfNNs > 1) {
            // wait for journal nodes to come up
            Thread.sleep(5000);
        }
        runner.runtime().startNode("nn1");
        Thread.sleep(5000);
        if (numOfNNs > 1) {
            for (int nnIndex = 2; nnIndex <= numOfNNs; nnIndex++) {
                runner.runtime().startNode("nn" + nnIndex);
            }
        }
        for (String node : runner.runtime().nodeNames())
            if (node.startsWith("dn")) runner.runtime().startNode(node);
    }

    public static void startServerNodes(ReditRunner runner) throws RuntimeEngineException {
        for (int index = 1; index <= numOfServers; index++) {
            runner.runtime().startNode("server" + index);
        }
    }

    public static ArrayList<Object> getZookeeperFileRW() throws IOException {
        ArrayList<Object> RWs = new ArrayList<>();
        RWs.add(new FileReader("conf/zoo.cfg"));
        RWs.add(new FileWriter("conf/zoo.cfg", true));
        return RWs;
    }

    public static ArrayList<Object> getHbaseFileRW() throws IOException {
        ArrayList<Object> RWs = new ArrayList<>();
        RWs.add(new FileReader("conf/regionservers"));
        RWs.add(new FileWriter("conf/regionservers", true));
        return RWs;
    }

    private static void addRuntimeLibsToDeployment(Deployment.Builder builder, String hadoopHome) {
        for (String cpItem: System.getProperty("java.class.path").split(":")) {
            if (cpItem.contains("aspectjrt") || cpItem.contains("reditrt")) {
                String fileName = new File(cpItem).getName();
                builder.service("hadoop-base")
                        .applicationPath(cpItem, hadoopHome + "/share/hadoop/common/" + fileName, PathAttr.LIBRARY).and();
            }
        }
    }

    public static void addInstrumentablePath(Deployment.Builder builder, String path) {
        String[] services = {"hadoop-base", "nn", "dn", "jn"};
        for (String service: services) {
            builder.service(service).instrumentablePath(getHadoopHomeDir() + path).and();
        }
    }
}
