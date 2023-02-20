package io.redit.samples.benchmark.elasticsearch14671;

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
    private static final int HTTP_PORT = 9200;
    private static final String dir = "elasticsearch-1.3.0";
    public static String getElasticsearchHomeDir(){
        return "/elasticsearch/" + dir;
    }

    public static Deployment getDeployment() {
        String workDir = System.getProperty("user.dir");
        String compressedPath = workDir + "/../../../Archive/Elasticsearch/Elasticsearch-14671/" + dir + ".tar.gz";

        Deployment.Builder builder = Deployment.builder("sample-elasticsearch")
                .withService("elasticsearch")
                .applicationPath(compressedPath,  "/elasticsearch",  PathAttr.COMPRESSED)
                .dockerImageName("mengpo1106/elasticsearch").dockerFileAddress("docker/Dockerfile", true)
                .libraryPath(getElasticsearchHomeDir() + "/lib/*.jar")
                .logDirectory("/var/log/elasticsearch")
                .serviceType(ServiceType.JAVA).and();

        builder.withService("server", "elasticsearch").tcpPort(HTTP_PORT).and()
                .nodeInstances(numOfServers, "server", "server", true)
                .node("server1")
                .applicationPath("conf/server1/elasticsearch.yml",  getElasticsearchHomeDir() + "/config/elasticsearch.yml").and()
                .node("server2")
                .applicationPath("conf/server2/elasticsearch.yml",   getElasticsearchHomeDir() + "/config/elasticsearch.yml").and()
                .node("server3")
                .applicationPath("conf/server3/elasticsearch.yml",  getElasticsearchHomeDir() + "/config/elasticsearch.yml").and();

        builder.node("server1").and().testCaseEvents("E1", "E2", "E3", "E4", "E5", "E6", "E7", "X1", "X2", "X3")
                .runSequence("E1 * E2 * E3 * E4 * E5 * X1 * E6 * X2 * X3 * E7");
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
        RWs.add(new FileReader("conf/server1/elasticsearch.yml"));
        for (int i = 1; i <= numOfServers; i++) {
            RWs.add(new FileWriter("conf/server" + i + "/elasticsearch.yml", true));
        }
        return RWs;
    }
}
