/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.service.BadRequestException;

public class RetrieveAndRankIT extends WatsonServiceTest {

  private static final Integer CREATED_CLUSTER_SIZE_ONE = 1;
  private static final String CREATED_CLUSTER_SIZE_FREE = "";
  private static final String CREATED_CLUSTER_DEFAULT_NAME = "";
  private static final String CREATED_CLUSTER_NAME = "itest-cluster";
  private static final String CONFIG_NAME = "itest-config";
  private static final String RANKER_NAME = "itest-ranker";
  private static final String RESOURCE_PATH = "src/test/resources/retrieve_and_rank/";

  private RetrieveAndRank service;
  private String rankerId;
  private String clusterId;

  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new RetrieveAndRank();
    service.setUsernameAndPassword(getValidProperty("retrieve_and_rank.username"),
        getValidProperty("retrieve_and_rank.password"));
    service.setEndPoint(getValidProperty("retrieve_and_rank.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    rankerId = getValidProperty("retrieve_and_rank.ranker_id");
    clusterId = getValidProperty("retrieve_and_rank.cluster_id");
  }

  @Test
  @Ignore
  public void testCreateRankerAndRankResults() throws InterruptedException {
    final File trainingFile = new File(RESOURCE_PATH + "ranker_train.csv");
    final File testFile = new File(RESOURCE_PATH + "ranker_test.csv");
    final int numToRank = 5;

    final Ranker ranker = service.createRanker(RANKER_NAME, trainingFile);
    try {
      assertEquals(RANKER_NAME, ranker.getName());
      for (int x = 0; x < 20
          && service.getRankerStatus(ranker.getId()).getStatus() != Ranker.Status.AVAILABLE; x++) {
        Thread.sleep(10000);
      }
      assertEquals(Ranker.Status.AVAILABLE, service.getRankerStatus(ranker.getId()).getStatus());

      final Ranking ranking = service.rank(ranker.getId(), testFile, numToRank);
      assertTrue(!ranking.getAnswers().isEmpty());
    } finally {
      service.deleteRanker(ranker.getId());
    }

  }

  @Test
  @Ignore
  public void testCreateAndDeleteSolrCluster() {
    final SolrCluster solrCluster = service.createSolrCluster();
    final SolrCluster expectedSolrCluster =
        new SolrCluster(solrCluster.getId(), CREATED_CLUSTER_DEFAULT_NAME,
            CREATED_CLUSTER_SIZE_FREE, Status.NOT_AVAILABLE);
    try {
      assertTrue(service.getSolrClusters().getSolrClusters().contains(expectedSolrCluster));
    } finally {
      service.deleteSolrCluster(solrCluster.getId());
      assertFalse(service.getSolrClusters().getSolrClusters().contains(expectedSolrCluster));
    }
  }

  @Test
  public void testCreateAndDeleteSolrClusterWithOptions() {
    final SolrClusterOptions options =
        new SolrClusterOptions(CREATED_CLUSTER_NAME, CREATED_CLUSTER_SIZE_ONE);
    final SolrCluster solrCluster = service.createSolrCluster(options);
    final SolrCluster expectedSolrCluster =
        new SolrCluster(solrCluster.getId(), CREATED_CLUSTER_NAME,
            CREATED_CLUSTER_SIZE_ONE.toString(), Status.NOT_AVAILABLE);
    try {
      assertTrue(service.getSolrClusters().getSolrClusters().contains(expectedSolrCluster));
    } finally {
      service.deleteSolrCluster(solrCluster.getId());
      assertFalse(service.getSolrClusters().getSolrClusters().contains(expectedSolrCluster));
    }
  }

  @Test
  public void testGetRankers() {
    final Rankers rankers = service.getRankers();
    assertNotNull(rankers);
    assertNotNull(rankers.getRankers());
    assertTrue(!rankers.getRankers().isEmpty());
  }

  @Test
  public void testGetRankerStatus() {
    final Ranker ranker = service.getRankerStatus(rankerId);
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
    final SolrCluster cluster = service.getSolrCluster(clusterId);
    assertNotNull(cluster);
    assertNotNull(cluster.getSize());
    assertNotNull(cluster.getName());
    assertNotNull(cluster.getStatus());
    assertEquals(clusterId, cluster.getId());
  }

  @Test
  public void preservesErrorMessages() {
    final String malformedClusterId = "BAD CLUSTER ID";
    expectedException.expect(BadRequestException.class);
    expectedException.expectMessage(malformedClusterId);
    expectedException.expectMessage("malformed");
    service.getSolrCluster(malformedClusterId);
  }

  @Test
  public void testGetSolrClusterConfiguration() throws IOException {
    try {
      final File configDir = new File(RESOURCE_PATH + "config_dir");
      service.uploadSolrClusterConfigurationDirectory(clusterId, CONFIG_NAME, configDir);

      InputStream configStream = null;
      try {
        configStream = service.getSolrClusterConfiguration(clusterId, CONFIG_NAME);
        assertNotNull(configStream);
      } finally {
        if (configStream != null) {
          configStream.close();
        }
      }
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME);
    }
  }

  @Test
  public void testGetSolrClusters() {
    final SolrClusterList clusters = service.getSolrClusters();
    assertNotNull(clusters);
    assertNotNull(clusters.getSolrClusters());
    assertTrue(!clusters.getSolrClusters().isEmpty());
  }

  @Test
  public void testGetSolrUrl() {
    final String solrUrl = service.getSolrUrl(clusterId);
    final String expectedUrl = service.getEndPoint() + "/v1/solr_clusters/" + clusterId + "/solr";
    assertEquals(expectedUrl, solrUrl);
  }

  @Test
  public void testUploadAndDeleteSolrClusterConfigurationDirectory() {
    try {
      final File configDir = new File(RESOURCE_PATH + "config_dir");
      service.uploadSolrClusterConfigurationDirectory(clusterId, CONFIG_NAME, configDir);

      assertTrue(service.getSolrClusterConfigurations(clusterId).contains(CONFIG_NAME));
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME);
      assertFalse(service.getSolrClusterConfigurations(clusterId).contains(CONFIG_NAME));
    }
  }

  @Test
  public void testUploadAndDeleteSolrClusterConfigurationZip() {
    try {
      final File configZip = new File(RESOURCE_PATH + "config.zip");
      service.uploadSolrClusterConfigurationZip(clusterId, CONFIG_NAME, configZip);

      assertTrue(service.getSolrClusterConfigurations(clusterId).contains(CONFIG_NAME));
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME);
      assertFalse(service.getSolrClusterConfigurations(clusterId).contains(CONFIG_NAME));
    }
  }

}
