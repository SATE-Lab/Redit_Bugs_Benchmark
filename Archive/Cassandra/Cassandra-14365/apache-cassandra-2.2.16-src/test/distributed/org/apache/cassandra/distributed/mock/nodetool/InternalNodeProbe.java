/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.distributed.mock.nodetool;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Multimap;

import org.apache.cassandra.db.ColumnFamilyStoreMBean;
import org.apache.cassandra.db.HintedHandOffManager;
import org.apache.cassandra.db.Keyspace;
import org.apache.cassandra.db.compaction.CompactionManager;
import org.apache.cassandra.gms.FailureDetector;
import org.apache.cassandra.gms.FailureDetectorMBean;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.locator.EndpointSnitchInfo;
import org.apache.cassandra.locator.EndpointSnitchInfoMBean;
import org.apache.cassandra.metrics.CassandraMetricsRegistry;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.CacheService;
import org.apache.cassandra.service.CacheServiceMBean;
import org.apache.cassandra.service.GCInspector;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.streaming.StreamManager;
import org.apache.cassandra.tools.NodeProbe;

public class InternalNodeProbe extends NodeProbe
{
    public InternalNodeProbe() throws IOException
    {
        super("", 0);
    }

    protected void connect()
    {
        // note that we are not connecting via JMX for testing
        mbeanServerConn = null;
        jmxc = null;

        ssProxy = StorageService.instance;
        msProxy = MessagingService.instance();
        streamProxy = StreamManager.instance;
        compactionProxy = CompactionManager.instance;
        fdProxy = (FailureDetectorMBean) FailureDetector.instance;
        cacheService = CacheService.instance;
        spProxy = StorageProxy.instance;
        hhProxy = HintedHandOffManager.instance;
        gcProxy = new GCInspector();
        gossProxy = Gossiper.instance;
        memProxy = ManagementFactory.getMemoryMXBean();
        runtimeProxy = ManagementFactory.getRuntimeMXBean();
    }

    @Override
    public void close()
    {
        // nothing to close. no-op
    }

    @Override
    // overrides all the methods referenced mbeanServerConn/jmxc in super
    public EndpointSnitchInfoMBean getEndpointSnitchInfoProxy()
    {
        return new EndpointSnitchInfo();
    }

    @Override
    public CacheServiceMBean getCacheServiceMBean()
    {
        return cacheService;
    }

    @Override
    public ColumnFamilyStoreMBean getCfsProxy(String ks, String cf)
    {
        return Keyspace.open(ks).getColumnFamilyStore(cf);
    }

    @Override
    // The below methods are only used by the commands (i.e. Info, TableHistogram, TableStats, etc.) that display informations. Not useful for dtest, so disable it.
    public Object getCacheMetric(String cacheType, String metricName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Map.Entry<String, ColumnFamilyStoreMBean>> getColumnFamilyStoreMBeanProxies()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Multimap<String, String> getThreadPools()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getThreadPoolMetric(String pathName, String poolName, String metricName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getColumnFamilyMetric(String ks, String cf, String metricName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public CassandraMetricsRegistry.JmxTimerMBean getProxyMetric(String scope)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getCompactionMetric(String metricName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getStorageMetric(String metricName)
    {
        throw new UnsupportedOperationException();
    }
}
