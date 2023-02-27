package io.redit.samples.rocketmq189;

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
    public static int numOfServers = 2;
    private static final int HTTP_PORT = 9876;
    private static final String dir = "rocketmq-4.0.0-incubating";
    public static String getRocketmqHomeDir(){
        return "/rocketmq/" + dir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String compressedPath = workDir + "/../../../Archive/Rocketmq/Rocketmq-189/" + dir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-rocketmq")
                .withService("rocketmq")
                .applicationPath(compressedPath, "/rocketmq",  PathAttr.COMPRESSED)
                .dockerImageName("mengpo1106/redit").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getRocketmqHomeDir() + "/lib/*.jar")
                .logDirectory(getRocketmqHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "rocketmq").tcpPort(HTTP_PORT).and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1").applicationPath("conf/broker-a.properties", getRocketmqHomeDir() + "/conf/2m-2s-async/broker-a.properties").and()
                .node("server1").applicationPath("conf/broker-b-s.properties", getRocketmqHomeDir() + "/conf/2m-2s-async/broker-b-s.properties").and()
                .node("server2").applicationPath("conf/broker-b.properties", getRocketmqHomeDir() + "/conf/2m-2s-async/broker-b.properties").and()
                .node("server2").applicationPath("conf/broker-a-s.properties", getRocketmqHomeDir() + "/conf/2m-2s-async/broker-a-s.properties").and();

        builder.node("server1").and().testCaseEvents("E1", "E2").runSequence("E1 * E2");
        return builder.build();
    }

    public static void startNodes(ReditRunner runner) throws RuntimeEngineException, InterruptedException {
        for (int index = 1; index <= numOfServers; index++) {
            runner.runtime().startNode("server" + index);
            Thread.sleep(1000);
        }
    }

    public static ArrayList<Object> getFileRW() throws IOException {
        ArrayList<Object> RWs = new ArrayList<>();
        RWs.add(new FileReader("conf/broker-a.properties"));
        String[] writer_list = {"a", "a-s", "b", "b-s"};
        for (String name: writer_list) {
            RWs.add(new FileWriter("conf/broker-" + name + ".properties", true));
        }
        return RWs;
    }
}
