package io.redit.samples.hdfs13998;

import io.redit.ReditRunner;
import io.redit.dsl.entities.Deployment;
import io.redit.dsl.entities.PathAttr;
import io.redit.dsl.entities.ServiceType;
import io.redit.exceptions.RuntimeEngineException;

import java.io.File;

public class ReditHelper {
    private static final int NN_HTTP_PORT = 50070;
    private static final int NN_RPC_PORT = 8020;
    public static int numOfServers = 3;
    private static int numOfNNs = 3;
    private static int numOfDNs = 3;
    private static int numOfJNs = 3;
    public static final String dir = "hadoop-3.1.2";
    public static String getHadoopHomeDir() { return "/hadoop/" + dir; }

    public static Deployment getDeployment(){
        String workDir = System.getProperty("user.dir");
        String compressedPath = workDir + "/../../../Archive/Hadoop/Original/" + dir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-hdfs-13998")
                .withService("hadoop-base")
                .applicationPath(compressedPath, "/hadoop",  PathAttr.COMPRESSED)
                .applicationPath("conf/hdfs-site.xml", getHadoopHomeDir() + "/etc/hadoop/hdfs-site.xml")
                .applicationPath("conf/core-site.xml", getHadoopHomeDir() + "/etc/hadoop/core-site.xml")
                .dockerImageName("mengpo1106/hadoop").dockerFileAddress("docker/Dockerfile", true)
                .environmentVariable("HADOOP_HOME", getHadoopHomeDir()).environmentVariable("HADOOP_HEAPSIZE_MAX", "1g")
                .libraryPath(getHadoopHomeDir() + "/share/hadoop/**/*.jar")
                .libraryPath(getHadoopHomeDir() + "/share/hadoop/**/*.java")
                .logDirectory(getHadoopHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        addRuntimeLibsToDeployment(builder, getHadoopHomeDir());

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

        addInstrumentablePath(builder, "/share/hadoop/hdfs/hadoop-hdfs-3.1.2.jar");

        return builder.build();
    }

    //Add the runtime library to the deployment
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

    public static void startNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
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
}
