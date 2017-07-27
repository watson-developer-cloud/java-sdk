/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterSizeResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterStats;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.util.RetryRunner;

/**
 * The Class RetrieveAndRankIT.
 */
@RunWith(RetryRunner.class)
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

  /** The expected exception. */
  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("retrieve_and_rank.username");
    String password = getProperty("retrieve_and_rank.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new RetrieveAndRank();
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("retrieve_and_rank.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    rankerId = getProperty("retrieve_and_rank.ranker_id");
    clusterId = getProperty("retrieve_and_rank.cluster_id");
  }

  /**
   * Test delete all rankers.
   */
  @Ignore
  @Test
  public void testDeleteAllRankers() {
    List<Ranker> rankers = service.getRankers().execute().getRankers();
    for (Ranker ranker : rankers) {
      if (!ranker.getId().equals(rankerId)) {
        service.deleteRanker(ranker.getId()).execute();
      }
    }
  }

  /**
   * Test create ranker and rank results.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  @Ignore
  public void testCreateRankerAndRankResults() throws InterruptedException, IOException {
    final File trainingFile = new File(RESOURCE_PATH + "ranker_train.csv");
    final File testFile = new File(RESOURCE_PATH + "ranker_test.csv");
    final int numToRank = 5;

    final Ranker ranker = service.createRanker(RANKER_NAME, trainingFile).execute();
    try {
      assertEquals(RANKER_NAME, ranker.getName());
      for (int x = 0; (x < 30)
          && (service.getRankerStatus(ranker.getId()).execute().getStatus() != Ranker.Status.AVAILABLE); x++) {
        Thread.sleep(10000);
      }
      assertEquals(Ranker.Status.AVAILABLE, service.getRankerStatus(ranker.getId()).execute().getStatus());

      Ranking ranking = service.rank(ranker.getId(), testFile, numToRank).execute();
      assertTrue(!ranking.getAnswers().isEmpty());

      final FileInputStream testInputStream = new FileInputStream(testFile);
      try {
        ranking = service.rank(ranker.getId(), testInputStream, numToRank).execute();
        assertTrue(!ranking.getAnswers().isEmpty());
      } finally {
        testInputStream.close();
      }
    } finally {
      service.deleteRanker(ranker.getId()).execute();
    }

  }

  @Test
  public void testRankResults() throws IOException {
    final File testFile = new File(RESOURCE_PATH + "ranker_test.csv");
    final int numToRank = 5;

    Ranking ranking = service.rank(rankerId, testFile, numToRank).execute();
    assertTrue(!ranking.getAnswers().isEmpty());

    final FileInputStream testInputStream = new FileInputStream(testFile);
    try {
      ranking = service.rank(rankerId, testInputStream, numToRank).execute();
      assertTrue(!ranking.getAnswers().isEmpty());
    } finally {
      testInputStream.close();
    }
  }

  /**
   * Test create and delete solr cluster.
   */
  @Test
  @Ignore
  public void testCreateAndDeleteSolrCluster() {
    final SolrCluster solrCluster = service.createSolrCluster().execute();
    final SolrCluster expectedSolrCluster = new SolrCluster(solrCluster.getId(), CREATED_CLUSTER_DEFAULT_NAME,
        CREATED_CLUSTER_SIZE_FREE, Status.NOT_AVAILABLE);
    try {
      assertTrue(service.getSolrClusters().execute().getSolrClusters().contains(expectedSolrCluster));
    } finally {
      service.deleteSolrCluster(solrCluster.getId()).execute();
      assertFalse(service.getSolrClusters().execute().getSolrClusters().contains(expectedSolrCluster));
    }
  }

  /**
   * Test create and delete solr cluster with options.
   */
  @Test
  public void testCreateAndDeleteSolrClusterWithOptions() {
    final SolrClusterOptions options = new SolrClusterOptions(CREATED_CLUSTER_NAME, CREATED_CLUSTER_SIZE_ONE);
    final SolrCluster solrCluster = service.createSolrCluster(options).execute();
    final SolrCluster expectedSolrCluster = new SolrCluster(solrCluster.getId(), CREATED_CLUSTER_NAME,
        CREATED_CLUSTER_SIZE_ONE.toString(), Status.NOT_AVAILABLE);
    try {
      assertTrue(service.getSolrClusters().execute().getSolrClusters().contains(expectedSolrCluster));
    } finally {
      service.deleteSolrCluster(solrCluster.getId()).execute();
      assertFalse(service.getSolrClusters().execute().getSolrClusters().contains(expectedSolrCluster));
    }
  }

  /**
   * Test get rankers.
   */
  @Test
  public void testGetRankers() {
    final Rankers rankers = service.getRankers().execute();
    assertNotNull(rankers);
    assertNotNull(rankers.getRankers());

    // #324: Rankers may be empty, because of other tests interfering.
    // The build should not fail here, because this is out of our control.
    Assume.assumeFalse(rankers.getRankers().isEmpty());
  }

  /**
   * Test get ranker status.
   */
  @Test
  public void testGetRankerStatus() {
    final Ranker ranker;

    try {
      ranker = service.getRankerStatus(rankerId).execute();
    } catch (NotFoundException e) {
      // #324: Rankers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }

    assertNotNull(ranker);
    assertNotNull(ranker.getCreated());
    assertNotNull(ranker.getName());
    assertNotNull(ranker.getStatus());
    assertNotNull(ranker.getStatusDescription());
    assertNotNull(ranker.getUrl());
    assertEquals(rankerId, ranker.getId());
  }

  /**
   * Test get solr cluster.
   */
  @Test
  @Ignore
  public void testGetSolrCluster() {
    final SolrCluster cluster = service.getSolrCluster(clusterId).execute();
    assertNotNull(cluster);
    assertNotNull(cluster.getSize());
    assertNotNull(cluster.getName());
    assertNotNull(cluster.getStatus());
    assertEquals(clusterId, cluster.getId());
  }

  /**
   * Preserves error messages.
   */
  @Test
  public void preservesErrorMessages() {
    final String malformedClusterId = "BAD CLUSTER ID";
    expectedException.expect(BadRequestException.class);
    expectedException.expectMessage(malformedClusterId);
    expectedException.expectMessage("malformed");
    service.getSolrCluster(malformedClusterId).execute();
  }

  /**
   * Test get solr cluster configuration.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetSolrClusterConfiguration() throws IOException {
    try {
      final File configDir = new File(RESOURCE_PATH + "config_dir");
      service.uploadSolrClusterConfigurationDirectory(clusterId, CONFIG_NAME, configDir).execute();

      InputStream configStream = null;
      try {
        configStream = service.getSolrClusterConfiguration(clusterId, CONFIG_NAME).execute();
        assertNotNull(configStream);
      } finally {
        if (configStream != null) {
          configStream.close();
        }
      }
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME).execute();
    }
  }

  /**
   * Test get solr clusters.
   */
  @Test
  public void testGetSolrClusters() {
    final List<SolrCluster> clusters = service.getSolrClusters().execute().getSolrClusters();
    assertNotNull(clusters);
    assertTrue(!clusters.isEmpty());
  }

  /**
   * Test getting a Solr cluster's stats.
   */
  @Test
  public void testGetSolrClusterStats() {
    final SolrClusterStats stats = service.getSolrClusterStats(clusterId).execute();
    assertNotNull(stats);
    assertTrue(stats.getDiskUsage().getUsedBytes() > 0);
    assertTrue(stats.getMemoryUsage().getUsedBytes() > 0);
  }

  /**
   * Test get solr url.
   */
  @Test
  public void testGetSolrUrl() {
    final String solrUrl = service.getSolrUrl(clusterId);
    final String expectedUrl = service.getEndPoint() + "/v1/solr_clusters/" + clusterId + "/solr";
    assertEquals(expectedUrl, solrUrl);
  }

  /**
   * Test upload and delete solr cluster configuration directory.
   */
  @Test
  public void testUploadAndDeleteSolrClusterConfigurationDirectory() {
    try {
      final File configDir = new File(RESOURCE_PATH + "config_dir");
      service.uploadSolrClusterConfigurationDirectory(clusterId, CONFIG_NAME, configDir).execute();

      assertTrue(service.getSolrClusterConfigurations(clusterId).execute().getSolrConfigs().contains(CONFIG_NAME));
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME).execute();
      assertFalse(service.getSolrClusterConfigurations(clusterId).execute().getSolrConfigs().contains(CONFIG_NAME));
    }
  }

  /**
   * Test upload and delete solr cluster configuration zip.
   */
  @Test
  public void testUploadAndDeleteSolrClusterConfigurationZip() {
    try {
      final File configZip = new File(RESOURCE_PATH + "config.zip");
      service.uploadSolrClusterConfigurationZip(clusterId, CONFIG_NAME, configZip).execute();

      assertTrue(service.getSolrClusterConfigurations(clusterId).execute().getSolrConfigs().contains(CONFIG_NAME));
    } finally {
      service.deleteSolrClusterConfiguration(clusterId, CONFIG_NAME).execute();
      assertFalse(service.getSolrClusterConfigurations(clusterId).execute().getSolrConfigs().contains(CONFIG_NAME));
    }
  }

  /**
   * Test solr cluster resize.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  @Ignore
  public void testSolrClusterResize() throws InterruptedException {
    SolrClusterSizeResponse resizeRequestResponse = service.resizeSolrCluster(clusterId, 2).execute();
    assertTrue(resizeRequestResponse.geClusterId().equals(clusterId));
    assertTrue(resizeRequestResponse.getCurrentSize().equals(CREATED_CLUSTER_SIZE_ONE));
    assertTrue(resizeRequestResponse.getTargetSize().equals(2));
    try {
      for (int x = 0; (x < 60) && (resizeRequestResponse.getCurrentSize() != 2); x++) {
        Thread.sleep(10000);
        resizeRequestResponse = service.getSolrClusterResizeStatus(clusterId).execute();
      }
      assertTrue(resizeRequestResponse.geClusterId().equals(clusterId));
      assertTrue(resizeRequestResponse.getCurrentSize().equals(2));
      assertNull(resizeRequestResponse.getTargetSize());
    } finally {
      service.deleteSolrCluster(clusterId).execute();
    }
  }
}
