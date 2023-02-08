package io.redit.samples.cassandra13464;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.helpers.CassandraHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    private static ReditRunner runner;
    private static CassandraHelper helper;
    private static Cluster cluster;
    private static Session session;

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new CassandraHelper(runner, ReditHelper.getCassandraHomeDir(), logger, ReditHelper.getFileRW(), ReditHelper.numOfServers);
        String seedsIp = runner.runtime().ip("server1");
        helper.addCassandraYamlFile(seedsIp);
        helper.makeCassandraDirs();

        logger.info("wait for Cassandra ...");
        helper.startServer(1);
        Thread.sleep(5000);
        helper.startServer(2);
        Thread.sleep(10000);
        helper.checkNetStatus(2);
        helper.checkStatus(1);
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            session.close();
            cluster.close();
            runner.stop();
        }
    }

    @Test
    public void testCreateMVWithSpecificTokenRange() throws RuntimeEngineException, InterruptedException, TimeoutException {
        runner.runtime().enforceOrder("E1", () -> {
            createTableAndInsert();
        });

        runner.runtime().enforceOrder("E2", () -> {
            createMaterializedView();
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }

    private static void createTableAndInsert(){
        try {
            cluster = Cluster.builder().addContactPoint(runner.runtime().ip("server1")).build();
            session = cluster.connect();

            String createKeySpaceCQL = "CREATE KEYSPACE if not exists test WITH replication={'class':'SimpleStrategy','replication_factor':3}";
            session.execute(createKeySpaceCQL);

            String createTableCQL = "CREATE TABLE if not exists test.test(id text PRIMARY KEY , value1 text , value2 text, value3 text)";
            session.execute(createTableCQL);

            String insertCQL1 = "INSERT INTO test.test (id, value1 , value2, value3 ) VALUES ('aaa', 'aaa', 'aaa' ,'aaa')";
            String insertCQL2 = "INSERT INTO test.test (id, value1 , value2, value3 ) VALUES ('bbb', 'bbb', 'bbb' ,'bbb')";
            session.execute(insertCQL1);
            session.execute(insertCQL2);

            String queryCQL1 = "SELECT token(id),id,value1 FROM test.test";
            ResultSet rs = session.execute(queryCQL1);
            List<Row> dataList = rs.all();
            for (Row row : dataList) {
                System.out.println(row.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createMaterializedView(){
        String createMaterializedViewCQL1 = "CREATE MATERIALIZED VIEW test.test_view AS SELECT value1, id FROM test.test WHERE id IS NOT NULL AND value1 IS NOT NULL AND TOKEN(id) > -9223372036854775808 AND TOKEN(id) < -3074457345618258603 PRIMARY KEY(value1, id) WITH CLUSTERING ORDER BY (id ASC)";
        session.execute(createMaterializedViewCQL1);
    }
}
