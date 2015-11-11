package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterList;

public class RetrieveAndRankIntegrationTest extends WatsonServiceTest {

  private RetrieveAndRank service;
  private String rankerId;
  private String clusterId;
  private String configName;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new RetrieveAndRank();
    service.setUsernameAndPassword(prop.getProperty("retrieve_and_rank.username"),
        prop.getProperty("retrieve_and_rank.password"));
    service.setEndPoint(prop.getProperty("retrieve_and_rank.url"));
    rankerId = prop.getProperty("retrieve_and_rank.ranker_id");
    clusterId = prop.getProperty("retrieve_and_rank.cluster_id");
    configName = prop.getProperty("retrieve_and_rank.config_name");
  }

  @Test
  public void testCreateRanker() {
    fail("Not yet implemented");
  }

  @Test
  public void testCreateSolrCluster() {
    fail("Not yet implemented");
  }

  @Test
  public void testCreateSolrClusterSolrClusterOptions() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteRanker() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteSolrCluster() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteSolrClusterConfiguration() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetRankers() {
    Rankers rankers = service.getRankers();
    assertNotNull(rankers);
    assertNotNull(rankers.getRankers());
    assertTrue(!rankers.getRankers().isEmpty());
  }

  @Test
  public void testGetRankerStatus() {
    Ranker ranker = service.getRankerStatus(rankerId);
    assertNotNull(ranker);
    assertNotNull(ranker.getCreated());
    assertNotNull(ranker.getName());
    assertNotNull(ranker.getStatus());
    assertNotNull(ranker.getStatusDescription());
    assertNotNull(ranker.getUrl());
    assertEquals(rankerId, ranker.getId());
  }

  @Test
  public void testGetSolrCluster() {
    SolrCluster cluster = service.getSolrCluster(clusterId);
    assertNotNull(cluster);
    assertNotNull(cluster.getSize());
    assertNotNull(cluster.getName());
    assertNotNull(cluster.getStatus());
    assertEquals(clusterId, cluster.getId());
  }

  @Test
  public void testGetSolrClusterConfiguration() {
    File config = service.getSolrClusterConfiguration(clusterId, configName);
    assertNotNull(config);
    assertTrue(config.exists());
  }

  @Test
  public void testGetSolrClusterConfigurations() {
    List<String> configs = service.getSolrClusterConfigurations(clusterId);
    assertNotNull(configs);
    assertTrue(!configs.isEmpty());
  }

  @Test
  public void testGetSolrClusters() {
    SolrClusterList clusters = service.getSolrClusters();
    assertNotNull(clusters);
    assertNotNull(clusters.getSolrClusters());
    assertTrue(!clusters.getSolrClusters().isEmpty());
  }

  @Test
  public void testRank() {
    fail("Not yet implemented");
  }

  @Test
  public void testUploadSolrClusterConfigurationDirectory() {
    fail("Not yet implemented");
  }

  @Test
  public void testUploadSolrClusterConfigurationZip() {
    fail("Not yet implemented");
  }

}
