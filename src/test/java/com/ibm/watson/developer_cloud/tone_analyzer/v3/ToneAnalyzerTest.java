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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

/**
 * Tone Analyzer unit test
 */
public class ToneAnalyzerTest extends WatsonServiceUnitTest {
  
  private static final String VERSION_DATE = "version";
  private static final String TEXT = "text";
  private static final String FIXTURE = "src/test/resources/tone_analyzer/tone.json";
  private final static String TONE_PATH = "/v3/tone";

  /** The service. */
  private ToneAnalyzer service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_02_11);
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

  }

  /**
   * Test get tone.
   * 
   * @throws FileNotFoundException
   */
  @Test
  public void testGetTone() throws FileNotFoundException {
    final String text = "I know the times are difficult! Our sales have been "
        + "disappointing for the past three quarters for our data analytics "
        + "product suite. We have a competitive data analytics product "
        + "suite in the industry. But we need to do our job selling it! ";

    ToneAnalysis response =
        loadFixture(FIXTURE, ToneAnalysis.class);

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, text);

    mockServer
      .when(request()
          .withMethod(POST)
          .withPath(TONE_PATH)
          .withQueryStringParameter(VERSION_DATE, ToneAnalyzer.VERSION_DATE_2016_02_11)
          .withBody(contentJson.toString()))
      .respond(response()
          .withHeader(HttpHeaders.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
          .withBody(response.toString()));

    // Call the service and compare the result
    Assert.assertEquals(response, service.getTone(text));
  }

  /**
   * Test tone with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetToneWithNull() {
    service.getTone(null);
  }

}
