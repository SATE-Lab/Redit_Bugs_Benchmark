package io.redit.samples.cassandra13669;

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
    public static final int RPC_PORT = 9160;
    public static final String dir = "apache-cassandra-3.11.3";
    public static String getCassandraHomeDir(){
        return "/cassandra/" + dir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String compressedPath = workDir + "/../../../Archive/Cassandra/Cassandra-13669/" + dir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-cassandra")
                .withService("cassandra")
                .applicationPath(compressedPath, "/cassandra",  PathAttr.COMPRESSED)
                .dockerImageName("mengpo1106/cassandra").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getCassandraHomeDir() + "/lib/*.jar")
                .logDirectory(getCassandraHomeDir() + "/logs")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "cassandra").tcpPort(RPC_PORT).and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1").applicationPath("conf/server1/cassandra.yaml", getCassandraHomeDir() + "/conf/cassandra.yaml").and()
                .node("server2").applicationPath("conf/server2/cassandra.yaml", getCassandraHomeDir() + "/conf/cassandra.yaml").and();

        builder.node("server1").and().testCaseEvents("E1", "E2", "X1").runSequence("E1 * X1 * E2");
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
        RWs.add(new FileReader("conf/server1/cassandra.yaml"));
        for (int i = 1; i <= numOfServers; i++) {
            RWs.add(new FileWriter("conf/server" + i + "/cassandra.yaml", true));
        }
        return RWs;
    }
}
