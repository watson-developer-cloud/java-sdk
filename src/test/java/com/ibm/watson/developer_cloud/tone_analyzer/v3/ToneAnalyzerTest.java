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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Tone Analyzer unit test.
 */
public class ToneAnalyzerTest extends WatsonServiceUnitTest {

  private static final String VERSION_DATE = "version";
  private static final String FIXTURE = "src/test/resources/tone_analyzer/tone.json";
  private final static String TONE_PATH = "/v3/tone";
  private static final String EMPTY = "";

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
    service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

  }

  /**
   * Test tone with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetToneWithNull() {
    service.getTone(null, null);
  }


  @Test
  public void testGetTones() throws InterruptedException, IOException {
    String text = "I know the times are difficult! Our sales have been "
        + "disappointing for the past three quarters for our data analytics "
        + "product suite. We have a competitive data analytics product "
        + "suite in the industry. But we need to do our job selling it! ";

    MockWebServer server = new MockWebServer();

    ToneAnalysis mockResponse = loadFixture(FIXTURE, ToneAnalysis.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    server.start();

    ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setApiKey(EMPTY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    ToneAnalysis serviceResponse = service.getTone(text, null).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(TONE_PATH, "?", VERSION_DATE, "=", ToneAnalyzer.VERSION_DATE_2016_05_19);
    assertEquals(path, request.getPath());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(serviceResponse, mockResponse);
    assertEquals(HttpMediaType.APPLICATION_JSON, request.getHeader(HttpHeaders.ACCEPT));

    // second request
    serviceResponse = service.getTone(text, new ToneOptions.Builder().html(true).build()).execute();
    request = server.takeRequest();
    assertEquals(path, request.getPath());
    assertTrue(request.getHeader(HttpHeaders.CONTENT_TYPE).startsWith(HttpMediaType.TEXT_HTML));

    // third request
    ToneOptions options = new ToneOptions.Builder().html(true).addTone(Tone.EMOTION).addTone(Tone.LANGUAGE).addTone(Tone.SOCIAL).build();
    serviceResponse = service.getTone(text, options).execute();
    request = server.takeRequest();
    path = path + "&tones=emotion%2Clanguage%2Csocial";
    assertEquals(path, request.getPath());


    // Shut down the server.
    server.shutdown();
  }
}
