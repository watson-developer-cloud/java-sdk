/*
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Rankers;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterSizeResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterStats;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusters;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrConfigs;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Retrieve and Rank unit test.
 */
public class RetrieveAndRankTest extends WatsonServiceUnitTest {

  private static final String RESOURCE_PATH = "src/test/resources/retrieve_and_rank/";
  private static final String FIXTURE1 = RESOURCE_PATH + "ranker_status.json";
  private static final String FIXTURE2 = RESOURCE_PATH + "ranker_list.json";
  private static final String FIXTURE3 = RESOURCE_PATH + "ranker_results.json";
  private static final String FIXTURE4 = RESOURCE_PATH + "resize.json";
  private static final String FIXTURE5 = RESOURCE_PATH + "cluster_create.json";
  private static final String FIXTURE6 = RESOURCE_PATH + "cluster_configs.json";
  private static final String FIXTURE7 = RESOURCE_PATH + "clusters.json";
  private static final String FIXTURE8 = RESOURCE_PATH + "cluster_stats.json";

  private static final String SOLR_URL = "/v1/solr_clusters";
  private static final String SOLRID_URL = SOLR_URL + "/ANY_CLUSTER_ID";
  private static final String SOLRRESIZE_URL = SOLRID_URL + "/cluster_size";
  private static final String SOLRCONFIG_URL = SOLRID_URL + "/config";
  private static final String SOLRSTATS_URL = SOLRID_URL + "/stats";
  private static final String SOLRCONFIGNAME_URL = SOLRCONFIG_URL + "/ANY_CONFIG_NAME";

  private static final String RANKERS_URL = "/v1/rankers";
  private static final String RANKID_URL = RANKERS_URL + "/ANY_RANKER_ID";
  private static final String RANK_URL = RANKID_URL + "/rank";

  private static final String ANY_RANKER_ID = "ANY_RANKER_ID";
  private static final String ANY_RANKER_NAME = "ANY_RANKER_NAME";
  private static final String ANY_CLUSTER_ID = "ANY_CLUSTER_ID";
  private static final String ANY_CLUSTER_NAME = "ANY_CLUSTER_NAME";
  private static final String ANY_CONFIG_NAME = "ANY_CONFIG_NAME";

  private RetrieveAndRank service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.RetrieveAndRankTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new RetrieveAndRank();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test cluster create.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterCreate1() throws FileNotFoundException, InterruptedException {
    SolrCluster mockResponse = loadFixture(FIXTURE5, SolrCluster.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrCluster serviceResponse = service.createSolrCluster().execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLR_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster create with options.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterCreate2() throws FileNotFoundException, InterruptedException {
    final SolrClusterOptions options = new SolrClusterOptions(ANY_CLUSTER_NAME, 3);

    SolrCluster mockResponse = loadFixture(FIXTURE5, SolrCluster.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrCluster serviceResponse = service.createSolrCluster(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLR_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("{\"cluster_name\":\"ANY_CLUSTER_NAME\",\"cluster_size\":\"3\"}", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster create with bad options. Size of the cluster to create. Ranges from 1 to 7. BUG 421?
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterCreate3() throws FileNotFoundException, InterruptedException {
    final SolrClusterOptions options = new SolrClusterOptions(null, 5);

    SolrCluster mockResponse = loadFixture(FIXTURE5, SolrCluster.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrCluster serviceResponse = service.createSolrCluster(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLR_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("{\"cluster_size\":\"5\"}", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster delete.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterDelete() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse("{ }"));
    service.deleteSolrCluster(ANY_CLUSTER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRID_URL, request.getPath());
    assertEquals("DELETE", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster configuration delete.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterConfigDelete() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse("{ }"));
    service.deleteSolrClusterConfiguration(ANY_CLUSTER_ID, ANY_CONFIG_NAME).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRCONFIGNAME_URL, request.getPath());
    assertEquals("DELETE", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterGet() throws FileNotFoundException, InterruptedException {
    SolrCluster mockResponse = loadFixture(FIXTURE5, SolrCluster.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrCluster serviceResponse = service.getSolrCluster(ANY_CLUSTER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRID_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster configuration retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterConfigGet() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse("{ }"));
    InputStream serviceResponse = service.getSolrClusterConfiguration(ANY_CLUSTER_ID, ANY_CONFIG_NAME).execute();
    RecordedRequest request = server.takeRequest();

    assertNotNull(serviceResponse);
    assertEquals(SOLRCONFIGNAME_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_ZIP);
  }

  /**
   * Test clusters retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClustersGet() throws FileNotFoundException, InterruptedException {
    SolrClusters mockResponse = loadFixture(FIXTURE7, SolrClusters.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrClusters serviceResponse = service.getSolrClusters().execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLR_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster stats retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterStatsGet() throws FileNotFoundException, InterruptedException {
    SolrClusterStats mockResponse = loadFixture(FIXTURE8, SolrClusterStats.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrClusterStats serviceResponse = service.getSolrClusterStats(ANY_CLUSTER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRSTATS_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster configurations retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterConfigsGet() throws FileNotFoundException, InterruptedException {
    SolrConfigs mockResponse = loadFixture(FIXTURE6, SolrConfigs.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrConfigs serviceResponse = service.getSolrClusterConfigurations(ANY_CLUSTER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRCONFIG_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test solr URL retrieve.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSolrUrlGet() throws FileNotFoundException, InterruptedException {
    String serviceResponse = service.getSolrUrl(ANY_CLUSTER_ID);
    assertTrue(serviceResponse.endsWith("/solr"));
  }

  /**
   * Test upload Cluster Configuration Zip.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUploadClusterConfigZip() throws FileNotFoundException, InterruptedException {
    final File configZip = new File(RESOURCE_PATH + "config.zip");
    server.enqueue(jsonResponse("{ }"));
    service.uploadSolrClusterConfigurationZip(ANY_CLUSTER_ID, ANY_CONFIG_NAME, configZip).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRCONFIGNAME_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test upload Cluster Configuration.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUploadClusterConfig() throws FileNotFoundException, InterruptedException {
    final File configDir = new File(RESOURCE_PATH + "config_dir");
    server.enqueue(jsonResponse("{ }"));
    service.uploadSolrClusterConfigurationDirectory(ANY_CLUSTER_ID, ANY_CONFIG_NAME, configDir).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRCONFIGNAME_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster resize.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterResize() throws FileNotFoundException, InterruptedException {
    SolrClusterSizeResponse mockResponse = loadFixture(FIXTURE4, SolrClusterSizeResponse.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrClusterSizeResponse serviceResponse = service.resizeSolrCluster(ANY_CLUSTER_ID, 2).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRRESIZE_URL, request.getPath());
    assertEquals("PUT", request.getMethod());
    assertEquals("{\"cluster_size\":2}", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test cluster resize status.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterResizeStatus() throws FileNotFoundException, InterruptedException {
    SolrClusterSizeResponse mockResponse = loadFixture(FIXTURE4, SolrClusterSizeResponse.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrClusterSizeResponse serviceResponse = service.getSolrClusterResizeStatus(ANY_CLUSTER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SOLRRESIZE_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker status.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerStatus() throws FileNotFoundException, InterruptedException {
    Ranker mockResponse = loadFixture(FIXTURE1, Ranker.class);
    server.enqueue(jsonResponse(mockResponse));
    Ranker serviceResponse = service.getRankerStatus(ANY_RANKER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANKID_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker list.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerList() throws FileNotFoundException, InterruptedException {
    Rankers mockResponse = loadFixture(FIXTURE2, Rankers.class);
    server.enqueue(jsonResponse(mockResponse));
    Rankers serviceResponse = service.getRankers().execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANKERS_URL, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker delete.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerDelete() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse("{ }"));
    service.deleteRanker(ANY_RANKER_ID).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANKID_URL, request.getPath());
    assertEquals("DELETE", request.getMethod());
    assertEquals("", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker train.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerTrain1() throws FileNotFoundException, InterruptedException {
    final File trainingFile = new File(RESOURCE_PATH + "ranker_train.csv");

    Ranker mockResponse = loadFixture(FIXTURE1, Ranker.class);
    server.enqueue(jsonResponse(mockResponse));
    Ranker serviceResponse = service.createRanker(ANY_RANKER_NAME, trainingFile).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANKERS_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker train with null ranker name.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerTrain2() throws FileNotFoundException, InterruptedException {
    final File trainingFile = new File(RESOURCE_PATH + "ranker_train.csv");

    Ranker mockResponse = loadFixture(FIXTURE1, Ranker.class);
    server.enqueue(jsonResponse(mockResponse));
    Ranker serviceResponse = service.createRanker(null, trainingFile).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANKERS_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker rank.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerRank1() throws FileNotFoundException, InterruptedException {
    final File rankFile = new File(RESOURCE_PATH + "ranker_test.csv");
    final int numToRank = 5;

    Ranking mockResponse = loadFixture(FIXTURE3, Ranking.class);
    server.enqueue(jsonResponse(mockResponse));
    Ranking serviceResponse = service.rank(ANY_RANKER_ID, rankFile, numToRank).execute();
    RecordedRequest request = server.takeRequest();

    String body = request.getBody().readUtf8();
    assertEquals(RANK_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertTrue(body.contains("Content-Disposition: form-data; name=\"answers\""));
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Test ranker rank with InputStream.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRankerRank2() throws FileNotFoundException, InterruptedException {
    final File rankFile = new File(RESOURCE_PATH + "ranker_test.csv");
    final int numToRank = 5;
    final FileInputStream testInputStream = new FileInputStream(rankFile);

    Ranking mockResponse = loadFixture(FIXTURE3, Ranking.class);
    server.enqueue(jsonResponse(mockResponse));
    Ranking serviceResponse = service.rank(ANY_RANKER_ID, testInputStream, numToRank).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RANK_URL, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }

  // Negative test cases start here
  /**
   * Negative - Test ranker status with null.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerStatusNg() throws FileNotFoundException, InterruptedException {
    service.getRankerStatus(null).execute();
  }

  /**
   * Negative - Test ranker delete with empty ranker id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerDeleteNg() throws FileNotFoundException, InterruptedException {
    service.deleteRanker("").execute();
  }

  /**
   * Negative - Test ranker train with null file.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerTrainNg1() throws FileNotFoundException, InterruptedException {
    service.createRanker(ANY_RANKER_NAME, null).execute();
  }

  /**
   * Negative - Test ranker train with bad file.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerTrainNg2() throws FileNotFoundException, InterruptedException {
    final File trainingFile = new File(RESOURCE_PATH + "bad_ranker_train.csv");

    service.createRanker(ANY_RANKER_NAME, trainingFile).execute();
  }

  /**
   * Negative - Test ranker rank with empty ranker id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerRank1Ng() throws FileNotFoundException, InterruptedException {
    final File rankFile = new File(RESOURCE_PATH + "ranker_test.csv");

    service.rank(null, rankFile, 0).execute();
  }

  /**
   * Negative - Test ranker rank with null file name.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerRank2Ng() throws FileNotFoundException, InterruptedException {
    final File rankFile = null;

    service.rank(ANY_RANKER_ID, rankFile, 0).execute();
  }

  /**
   * Negative - Test ranker rank with null InputStream.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRankerRank3Ng() throws FileNotFoundException, InterruptedException {
    final FileInputStream testInputStream = null;

    service.rank(ANY_RANKER_ID, testInputStream, 0).execute();
  }

  /**
   * Negative - Test cluster delete with empty cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterDeleteNg() throws FileNotFoundException, InterruptedException {
    service.deleteSolrCluster("").execute();
  }

  /**
   * Negative - Test cluster config delete with null config name.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterConfigDelete1Ng() throws FileNotFoundException, InterruptedException {
    service.deleteSolrClusterConfiguration(ANY_CLUSTER_ID, null).execute();
  }

  /**
   * Negative - Test cluster config delete with empty cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterConfigDelete2Ng() throws FileNotFoundException, InterruptedException {
    service.deleteSolrClusterConfiguration("", ANY_CONFIG_NAME).execute();
  }

  /**
   * Negative - Test cluster retrieve with empty cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterGetNg() throws FileNotFoundException, InterruptedException {
    service.getSolrCluster(null).execute();
  }

  /**
   * Negative - Test cluster config retrieve with null config name.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterConfigGet1Ng() throws FileNotFoundException, InterruptedException {
    service.getSolrClusterConfiguration(ANY_CLUSTER_ID, null).execute();
  }

  /**
   * Negative - Test cluster config retrieve with empty cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterConfigGet2Ng() throws FileNotFoundException, InterruptedException {
    service.getSolrClusterConfiguration("", ANY_CONFIG_NAME).execute();
  }

  /**
   * Negative - Test cluster configs retrieve with null cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterConfigsGetNg() throws FileNotFoundException, InterruptedException {
    service.getSolrClusterConfigurations(null).execute();
  }

  /**
   * Negative - Test cluster stats retrieve with null cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterStatsGetNg() throws FileNotFoundException, InterruptedException {
    service.getSolrClusterStats(null).execute();
  }

  /**
   * Negative - Test Upload Cluster Config with null directory.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigNg1() throws FileNotFoundException, InterruptedException {
    service.uploadSolrClusterConfigurationDirectory(ANY_CLUSTER_ID, ANY_CONFIG_NAME, null).execute();
  }

  /**
   * Negative - Test Upload Cluster Config with null config name. BUG?
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigWithConfigNameNull() throws FileNotFoundException, InterruptedException {
    final File configDir = new File(RESOURCE_PATH + "config_dir");
    service.uploadSolrClusterConfigurationDirectory(ANY_CLUSTER_ID, null, configDir).execute();
  }

  /**
   * Negative - Test Upload Cluster Config with null cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigWithClusterIdNull() throws FileNotFoundException, InterruptedException {
    final File configDir = new File(RESOURCE_PATH + "config_dir");
    service.uploadSolrClusterConfigurationDirectory(null, ANY_CONFIG_NAME, configDir).execute();
  }

  /**
   * Negative - Test Upload Cluster Zip with null directory. BUG?
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigZipNg1() throws FileNotFoundException, InterruptedException {
    service.uploadSolrClusterConfigurationZip(ANY_CLUSTER_ID, ANY_CONFIG_NAME, null).execute();
  }

  /**
   * Negative - Test Upload Cluster Zip with null config name.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigZipNg2() throws FileNotFoundException, InterruptedException {
    final File configZip = new File(RESOURCE_PATH + "config.zip");
    service.uploadSolrClusterConfigurationZip(ANY_CLUSTER_ID, null, configZip).execute();
  }

  /**
   * Negative - Test Upload Cluster Zip with null cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUploadClusterConfigZipNg3() throws FileNotFoundException, InterruptedException {
    final File configZip = new File(RESOURCE_PATH + "config.zip");
    service.uploadSolrClusterConfigurationZip(null, ANY_CONFIG_NAME, configZip).execute();
  }

  /**
   * Negative - Test Resize Cluster with negative size. The permitted range is one (1) to 14 units. BUG?
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterResizeNg1() throws FileNotFoundException, InterruptedException {
    service.resizeSolrCluster(ANY_CLUSTER_ID, -10).execute();
  }

  /**
   * Negative - Test Resize Cluster with null cluster id.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testClusterResizeNg2() throws FileNotFoundException, InterruptedException {
    service.resizeSolrCluster(null, 5).execute();
  }

}
