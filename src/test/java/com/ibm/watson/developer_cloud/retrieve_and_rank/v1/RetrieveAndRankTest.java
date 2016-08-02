/*
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

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterSizeResponse;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Retrieve and Rank unit test.
 */
public class RetrieveAndRankTest extends WatsonServiceUnitTest {

  private static final String FIXTURE = "src/test/resources/retrieve_and_rank/resize.json";
  private static final String ANY_CLUSTER_ID = "ANY_CLUSTER_ID";
  private static final Object RESIZE_PATH = "/v1/solr_clusters/ANY_CLUSTER_ID/cluster_size";

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
   * Test cluster resize.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClusterResize() throws FileNotFoundException, InterruptedException {
    SolrClusterSizeResponse mockResponse = loadFixture(FIXTURE, SolrClusterSizeResponse.class);
    server.enqueue(jsonResponse(mockResponse));
    SolrClusterSizeResponse serviceResponse =
        service.resizeSolrCluster(ANY_CLUSTER_ID, 2).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(RESIZE_PATH, request.getPath());
    assertEquals("PUT", request.getMethod());
    assertEquals("{\"cluster_size\":2}", request.getBody().readUtf8());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(mockResponse, serviceResponse);
    assertEquals(request.getHeader(HttpHeaders.ACCEPT), HttpMediaType.APPLICATION_JSON);
  }
}
