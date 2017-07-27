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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtteranceAnalyses;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Utterance;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Tone Analyzer unit test.
 */
public class ToneAnalyzerTest extends WatsonServiceUnitTest {

  private static final String VERSION_DATE = "version";
  private static final String FIXTURE = "src/test/resources/tone_analyzer/tone.json";
  private static final String CHAT_FIXTURE = "src/test/resources/tone_analyzer/tone_chat.json";
  private static final String TONE_PATH = "/v3/tone";
  private static final String CHAT_TONE_PATH = "/v3/tone_chat";

  /** The service. */
  private ToneAnalyzer service;
  private static final String VERSION_DATE_2016_05_19 = "2016-05-19";

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ToneAnalyzer(VERSION_DATE_2016_05_19);
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());

  }

  /**
   * Test README.
   */
  @Test
  public void testReadme() throws InterruptedException, IOException {

//    final String VERSION_DATE = "2016-05-19";
    ToneAnalyzer service = new ToneAnalyzer(VERSION_DATE);
    service.setUsernameAndPassword("<username>", "<password>");

    service.setEndPoint(getMockWebServerUrl()); // exclude
    ToneAnalysis mockResponse = loadFixture(FIXTURE, ToneAnalysis.class); // exclude
    server.enqueue(jsonResponse(mockResponse)); // exclude

    String text =
        "I know the times are difficult! Our sales have been "
            + "disappointing for the past three quarters for our data analytics "
            + "product suite. We have a competitive data analytics product "
            + "suite in the industry. But we need to do our job selling it! "
            + "We need to acknowledge and fix our sales challenges. "
            + "We can’t blame the economy for our lack of execution! "
            + "We are missing critical sales opportunities. "
            + "Our product is in no way inferior to the competitor products. "
            + "Our clients are hungry for analytical tools to improve their "
            + "business outcomes. Economy has nothing to do with it.";

    // Call the service and get the tone
    ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
    ToneAnalysis tone = service.tone(toneOptions).execute();
    System.out.println(tone);
  }

  /**
   * Test tone with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testtoneWithNull() {
    service.tone(null);
  }


  /**
   * Test get tones.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testtones() throws InterruptedException, IOException {
    String text = "I know the times are difficult! Our sales have been "
        + "disappointing for the past three quarters for our data analytics "
        + "product suite. We have a competitive data analytics product "
        + "suite in the industry. But we need to do our job selling it! ";

    ToneAnalysis mockResponse = loadFixture(FIXTURE, ToneAnalysis.class);
    server.enqueue(jsonResponse(mockResponse));
    server.enqueue(jsonResponse(mockResponse));
    server.enqueue(jsonResponse(mockResponse));

    // execute request
    ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
    ToneAnalysis serviceResponse = service.tone(toneOptions).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(TONE_PATH, "?", VERSION_DATE, "=", VERSION_DATE_2016_05_19);
    assertEquals(path, request.getPath());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(serviceResponse, mockResponse);
    assertEquals(HttpMediaType.APPLICATION_JSON, request.getHeader(HttpHeaders.ACCEPT));

    // second request
    serviceResponse = service.tone(new ToneOptions.Builder().html(text).build()).execute();
    request = server.takeRequest();
    assertEquals(path, request.getPath());
    assertTrue(request.getHeader(HttpHeaders.CONTENT_TYPE).startsWith(HttpMediaType.TEXT_HTML));

    // third request
    ToneOptions toneOptions1 = new ToneOptions.Builder()
        .html(text)
        .addTone(ToneOptions.Tone.EMOTION)
        .addTone(ToneOptions.Tone.LANGUAGE)
        .addTone(ToneOptions.Tone.SOCIAL)
        .build();
    serviceResponse = service.tone(toneOptions1).execute();
    request = server.takeRequest();
    path = path + "&tones=emotion,language,social";
    assertEquals(path, request.getPath());
  }

  /**
   * Test to get Chat tones.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetChatTones() throws IOException, InterruptedException {

    String[] users = { "customer", "agent", "customer", "agent" };

    String[] texts = {
            "My charger isn't working.",
            "Thanks for reaching out. Can you give me some more detail about the issue?",
            "I put my charger in my tablet to charge it up last night and it keeps saying it isn't"
            + " charging. The charging icon comes on, but it stays on even when I take the charger out. "
            + "Which is ridiculous, it's brand new.",
            "I'm sorry you're having issues with charging. What kind of charger are you using?"
            };

    List<Utterance> utterances = new ArrayList<>();
    for (int i = 0; i < texts.length; i++) {
      Utterance utterance = new Utterance.Builder()
          .text(texts[i])
          .user(users[i])
          .build();
      utterances.add(utterance);
    }

    ToneChatOptions toneChatOptions = new ToneChatOptions.Builder()
        .utterances(utterances)
        .build();

    UtteranceAnalyses mockResponse = loadFixture(CHAT_FIXTURE, UtteranceAnalyses.class);
    server.enqueue(jsonResponse(mockResponse));
    server.enqueue(jsonResponse(mockResponse));
    server.enqueue(jsonResponse(mockResponse));

    // execute request
    UtteranceAnalyses serviceResponse = service.toneChat(toneChatOptions).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(CHAT_TONE_PATH, "?", VERSION_DATE, "=", VERSION_DATE_2016_05_19);
    assertEquals(path, request.getPath());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(serviceResponse, mockResponse);
    assertEquals(HttpMediaType.APPLICATION_JSON, request.getHeader(HttpHeaders.ACCEPT));
  }
}
