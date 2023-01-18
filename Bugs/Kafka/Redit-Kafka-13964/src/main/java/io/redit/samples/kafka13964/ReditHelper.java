package io.redit.samples.kafka13964;

import io.redit.ReditRunner;
import io.redit.dsl.entities.Deployment;
import io.redit.dsl.entities.PathAttr;
import io.redit.dsl.entities.ServiceType;
import io.redit.exceptions.RuntimeEngineException;

public class ReditHelper {
    public static int numOfServers = 3;
    public static final String kafkaDir = "kafka_2.13-3.2.0";
    public static String getKafkaHomeDir(){
        return "/kafka/" + kafkaDir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String kafkaCompressedPath = workDir + "/../../../Archive/Kafka/Kafka-13964/" + kafkaDir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-kafka")
                .withService("kafka")
                .applicationPath(kafkaCompressedPath, "/kafka",  PathAttr.COMPRESSED)
                .dockerImageName("mengpo1106/kafka").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getKafkaHomeDir() + "/libs/*.jar")
                .logDirectory(getKafkaHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "kafka").and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1")
                .applicationPath("conf/server1/server.properties", getKafkaHomeDir() + "/config/server.properties").and()
                .node("server2")
                .applicationPath("conf/server2/server.properties", getKafkaHomeDir() + "/config/server.properties").and()
                .node("server3")
                .applicationPath("conf/server3/server.properties", getKafkaHomeDir() + "/config/server.properties").and();

        builder.node("server1").and().testCaseEvents("E1").runSequence("E1");
        return builder.build();
    }

    public static void startNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
        for (int index = 1; index <= numOfServers; index++) {
            runner.runtime().startNode("server" + index);
            Thread.sleep(1000);
        }
    }
}
