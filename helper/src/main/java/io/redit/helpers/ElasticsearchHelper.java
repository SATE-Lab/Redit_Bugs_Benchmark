package io.redit.helpers;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import org.slf4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class ElasticsearchHelper {
    private final ReditRunner runner;
    private final String homeDir;
    private final Logger logger;
    private final ArrayList<Object> RWs;
    private final int numOfServers;
    private static String ElasticsearchYmlConf = "discovery.seed_hosts: [";
    private static String YmlConf1_230 = "discovery.zen.ping.unicast.hosts: [";
    private static String YmlConf2_230 = "network.publish_host: ";

    public ElasticsearchHelper(ReditRunner runner, String homeDir, Logger logger, ArrayList<Object> RWs, int numOfServers) {
        this.runner = runner;
        this.homeDir = homeDir;
        this.logger = logger;
        this.RWs = RWs;
        this.numOfServers = numOfServers;
        getYmlConf();
    }

    public void startServers() throws InterruptedException, RuntimeEngineException {
        for (int i = 1; i <= numOfServers; i++) {
            startServer(i);
            Thread.sleep(5000);
        }
    }

    public void startServer(int serverId) throws RuntimeEngineException, InterruptedException {
        // 要求该版本可在root帐户下运行
        logger.info("server" + serverId + " startServer...");
        String command = homeDir + "/bin/elasticsearch -d";
        printResult(runner.runtime().runCommandInNode("server" + serverId, command));
    }

    public void startServers_230() throws InterruptedException, RuntimeEngineException {
        for (int i = 1; i <= numOfServers; i++) {
            startServer_230(i);
        }
    }

    public void startServer_230(int serverId) throws RuntimeEngineException, InterruptedException {
        logger.info("server" + serverId + " startServer...");
        printResult(runner.runtime().runCommandInNode("server" + serverId, "useradd test && chown -R test /elasticsearch && chown -R test /var"));
        Thread.sleep(500);
        String command = "runuser -m test -c '" + homeDir + "/bin/elasticsearch -d'";
        printResult(runner.runtime().runCommandInNode("server" + serverId, command));
        Thread.sleep(4000);
    }

    private void getYmlConf() {
        for (int i = 1; i <= numOfServers; i++) {
            ElasticsearchYmlConf += "\"" + runner.runtime().ip("server" + (i)) + ":9300\"";
            YmlConf1_230 += "\"" + runner.runtime().ip("server" + (i)) + ":9300\"";
            if (i < numOfServers) {
                ElasticsearchYmlConf += ", ";
                YmlConf1_230 += ", ";
            }
        }
        ElasticsearchYmlConf += "]";
        YmlConf1_230  += "]";
    }

    public void addElasticsearchYmlFile() throws IOException {
        boolean addConf = false;
        BufferedReader in = new BufferedReader((Reader) RWs.get(0));
        String str;
        while ((str = in.readLine()) != null) {
            if (str.startsWith("discovery.seed_hosts")) {
                addConf = true;
            }
        }
        in.close();
        if (addConf) {
            logger.info("elasticsearch.yml is already configured !!!");
        } else {
            for (int i = 1; i <= numOfServers; i++) {
                BufferedWriter out = new BufferedWriter((Writer) RWs.get(i));
                out.write(ElasticsearchYmlConf);
                out.close();
                logger.info("add config to elasticsearch.yml !!!");
            }
        }
    }

    public void addElasticsearchYmlFile_230() throws IOException {
        boolean addConf = false;
        BufferedReader in = new BufferedReader((Reader) RWs.get(0));
        String str;
        while ((str = in.readLine()) != null) {
            if (str.startsWith("discovery.zen.ping.unicast.hosts")) {
                addConf = true;
            }
        }
        in.close();
        if (addConf) {
            logger.info("elasticsearch.yml is already configured !!!");
        } else {
            for (int i = 1; i <= numOfServers; i++) {
                BufferedWriter out = new BufferedWriter((Writer) RWs.get(i));
                out.write(YmlConf2_230 + runner.runtime().ip("server" + i) + "\n");
                out.write(YmlConf1_230);
                out.close();
                logger.info("add config to elasticsearch.yml !!!");
            }
        }
    }

    public void checkJps() throws RuntimeEngineException {
        for (int i = 1; i <= numOfServers; i++) {
            CommandResults commandResults = runner.runtime().runCommandInNode("server" + i, "jps");
            printResult(commandResults);
        }
    }

    public void checkElasticsearchStatus() throws RuntimeEngineException {
        String cmd = "curl -X GET http://localhost:9200/?pretty";
        for (int i = 1; i <= numOfServers; i++) {
            printResult(runner.runtime().runCommandInNode("server" + i, cmd));
        }
    }

    public void checkOneServerStatusManyTimes(int serverId) throws RuntimeEngineException, InterruptedException {
        String cmd = "curl -X GET http://localhost:9200/?pretty";
        for(int i = 0; i < 10; i++){
            printResult(runner.runtime().runCommandInNode("server" + serverId, cmd));
            Thread.sleep(3000);
        }
    }

    public void printResult(CommandResults commandResults) {
        logger.info(commandResults.nodeName() + ": " + commandResults.command());
        if (commandResults.stdOut() != null && commandResults.stdOut().length() != 0) {
            logger.info(commandResults.stdOut());
        } else {
            logger.warn(commandResults.stdErr());
        }
    }
}
