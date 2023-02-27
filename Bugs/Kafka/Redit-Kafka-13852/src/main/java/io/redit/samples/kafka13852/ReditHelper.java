package io.redit.samples.kafka13852;

import io.redit.ReditRunner;
import io.redit.dsl.entities.Deployment;
import io.redit.dsl.entities.PathAttr;
import io.redit.dsl.entities.ServiceType;
import io.redit.exceptions.RuntimeEngineException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReditHelper {
    public static int numOfServers = 3;
    public static final String zookeeperDir = "apache-zookeeper-3.7.1-bin";
    public static final String kafkaDir = "kafka_2.13-3.2.0";
    public static String getZookeeperHomeDir(){
        return "/zookeeper/" + zookeeperDir;
    }
    public static String getKafkaHomeDir(){
        return "/kafka/" + kafkaDir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String zookeeperCompressedPath = workDir + "/../../../Archive/Zookeeper/Original/" + zookeeperDir + ".tar.gz";
        String kafkaCompressedPath = workDir + "/../../../Archive/Kafka/Kafka-13852/" + kafkaDir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-kafka")
                .withService("kafka")
                .applicationPath(zookeeperCompressedPath, "/zookeeper",  PathAttr.COMPRESSED)
                .applicationPath("conf/zoo.cfg", getZookeeperHomeDir() + "/conf/zoo.cfg")
                .applicationPath(kafkaCompressedPath, "/kafka",  PathAttr.COMPRESSED)
                .dockerImageName("mengpo1106/redit").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getZookeeperHomeDir() + "/lib/*.jar")
                .libraryPath(getKafkaHomeDir() + "/libs/*.jar")
                .logDirectory(getZookeeperHomeDir() + "/logs")
                .logDirectory(getKafkaHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "kafka").and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1")
                .applicationPath("conf/server1/myid", getZookeeperHomeDir() + "/zkdata/myid")
                .applicationPath("conf/server1/server.properties", getKafkaHomeDir() + "/config/server.properties").and()
                .node("server2")
                .applicationPath("conf/server2/myid", getZookeeperHomeDir() + "/zkdata/myid")
                .applicationPath("conf/server2/server.properties", getKafkaHomeDir() + "/config/server.properties").and()
                .node("server3")
                .applicationPath("conf/server3/myid", getZookeeperHomeDir() + "/zkdata/myid")
                .applicationPath("conf/server3/server.properties", getKafkaHomeDir() + "/config/server.properties").and();

        builder.node("server1").and().testCaseEvents("E1", "E2", "E3", "E4", "E5").runSequence("E1 * E2 * E3 * E4 * E5");
        return builder.build();
    }

    public static void startNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
        for (int index = 1; index <= numOfServers; index++) {
            runner.runtime().startNode("server" + index);
            Thread.sleep(1000);
        }
    }

    public static ArrayList<Object> getZookeeperFileRW() throws IOException {
        ArrayList<Object> RWs = new ArrayList<>();
        RWs.add(new FileReader("conf/zoo.cfg"));
        RWs.add(new FileWriter("conf/zoo.cfg", true));
        return RWs;
    }

    public static ArrayList<Object> getKafkaFileRW() throws IOException {
        ArrayList<Object> RWs = new ArrayList<>();
        RWs.add(new FileReader("conf/server1/server.properties"));
        for (int i = 1; i <= numOfServers; i++) {
            RWs.add(new FileWriter("conf/server" + i + "/server.properties", true));
        }
        return RWs;
    }
}
