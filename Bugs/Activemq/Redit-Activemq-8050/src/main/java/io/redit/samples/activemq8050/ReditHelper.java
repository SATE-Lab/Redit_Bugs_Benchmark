package io.redit.samples.activemq8050;

import io.redit.ReditRunner;
import io.redit.dsl.entities.Deployment;
import io.redit.dsl.entities.PathAttr;
import io.redit.dsl.entities.ServiceType;
import io.redit.exceptions.RuntimeEngineException;

public class ReditHelper {
    public static int numOfServers = 2;
    public static final String dir = "activemq-5.15.9";
    public static String getRocketmq1HomeDir(){
        return "/activemq/" + dir + "/mq1";
    }
    public static String getRocketmq2HomeDir(){
        return "/activemq/" + dir + "/mq2";
    }
    public static String getRocketmq3HomeDir(){
        return "/activemq/" + dir + "/mq3";
    }
    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String compressedPath = workDir + "/../../../Archive/Activemq/Original/" + dir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-activemq")
                .withService("activemq")
                .applicationPath(compressedPath, "/activemq",  PathAttr.COMPRESSED)
                .applicationPath("conf/jetty.xml", getRocketmq1HomeDir() + "/conf/jetty.xml")
                .applicationPath("conf/jetty.xml", getRocketmq2HomeDir() + "/conf/jetty.xml")
                .applicationPath("conf/jetty.xml", getRocketmq3HomeDir() + "/conf/jetty.xml")
                .dockerImageName("mengpo1106/redit").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getRocketmq1HomeDir() + "/lib/*.jar")
                .libraryPath(getRocketmq2HomeDir() + "/lib/*.jar")
                .libraryPath(getRocketmq3HomeDir() + "/lib/*.jar")
                .logDirectory(getRocketmq1HomeDir() + "/data")
                .logDirectory(getRocketmq2HomeDir() + "/data")
                .logDirectory(getRocketmq3HomeDir() + "/data")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "activemq").and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1").applicationPath("conf/server1/mq1/activemq.xml", getRocketmq1HomeDir() + "/conf/activemq.xml").and()
                .node("server1").applicationPath("conf/server1/mq2/activemq.xml", getRocketmq2HomeDir() + "/conf/activemq.xml").and()
                .node("server1").applicationPath("conf/server1/mq3/activemq.xml", getRocketmq3HomeDir() + "/conf/activemq.xml").and()
                .node("server2").applicationPath("conf/server2/mq1/activemq.xml", getRocketmq1HomeDir() + "/conf/activemq.xml").and()
                .node("server2").applicationPath("conf/server2/mq2/activemq.xml", getRocketmq2HomeDir() + "/conf/activemq.xml").and()
                .node("server2").applicationPath("conf/server2/mq3/activemq.xml", getRocketmq3HomeDir() + "/conf/activemq.xml").and();

        builder.node("server1").and().testCaseEvents("E1", "E2", "E3", "E4", "X1").runSequence("E1 * E2 * E3 * X1 * E4");
        return builder.build();
    }

    public static void startNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
        for (int index = 1; index <= numOfServers; index++) {
            runner.runtime().startNode("server" + index);
            Thread.sleep(1000);
        }
    }
}
