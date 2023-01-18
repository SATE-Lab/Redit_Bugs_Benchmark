package io.redit.helpers;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import org.slf4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class CassandraHelper {
    private final ReditRunner runner;
    private final String homeDir;
    private final Logger logger;
    private final ArrayList<Object> RWs;
    private final int numOfServers;

    public CassandraHelper(ReditRunner runner, String homeDir, Logger logger, ArrayList<Object> RWs, int numOfServers) {
        this.runner = runner;
        this.homeDir = homeDir;
        this.logger = logger;
        this.RWs = RWs;
        this.numOfServers = numOfServers;
    }

    public void startServer(int serverId) {
        String command = "cd " + homeDir + " && bin/cassandra -R ";
        logger.info("server" + serverId + " startServer...");
        new Thread(() -> {
            try {
                runner.runtime().runCommandInNode("server" + serverId, command);
            } catch (RuntimeEngineException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void checkNetStatus(int serverId) throws RuntimeEngineException {
        String command = "cd " + homeDir + " && bin/nodetool netstats ";
        CommandResults commandResult = runner.runtime().runCommandInNode("server" + serverId, command);
        printResult(commandResult);
    }

    public void checkStatus(int serverId) throws RuntimeEngineException {
        String command = "cd " + homeDir + " && bin/nodetool status ";
        CommandResults commandResult = runner.runtime().runCommandInNode("server" + serverId, command);
        printResult(commandResult);
    }

    public void makeCassandraDirs() throws RuntimeEngineException {
        for(int i = 1; i <= numOfServers; i++){
            String command = "mkdir /opt/cassandra && cd /opt/cassandra && mkdir data_file_directories commitlog_directory saved_caches_directory";
            runner.runtime().runCommandInNode("server" + i, command);
        }
    }

    public void addCassandraYamlFile(String seedsIp) throws IOException {
        boolean addConf = false;
        BufferedReader in = new BufferedReader((FileReader) RWs.get(0));
        String str;
        while ((str = in.readLine()) != null) {
            if (str.startsWith("listen_address")){
                addConf = true;
            }
        }
        in.close();
        if (addConf){
            logger.info("cassandra.yaml is already configured !!!");
        }
        else {
            for (int i = 1; i <= numOfServers; i++){
                BufferedWriter out = new BufferedWriter((FileWriter) RWs.get(i));
                String seeds = "      - seeds: \"" + seedsIp + "\"\n";
                String listen_address = "listen_address: " + runner.runtime().ip("server" + i) + "\n";
                String rpc_address = "rpc_address: " + runner.runtime().ip("server" + i) + "\n";
                out.write(seeds);
                out.write(listen_address);
                out.write(rpc_address);
                out.close();
                logger.info("add config to cassandra.yaml !!!");
            }
        }
    }

    public void printResult(CommandResults commandResults){
        logger.info(commandResults.nodeName() + ": " + commandResults.command());
        if (commandResults.stdOut() != null){
            logger.info(commandResults.stdOut());
        }
        logger.warn(commandResults.stdErr());
    }
}
