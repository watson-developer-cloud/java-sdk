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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechWordAlternatives;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

/**
 * The Class SpeechToTextIT.
 */
public class SpeechToTextIT extends WatsonServiceTest {

  private static String EN_BROADBAND16K = "en-US_BroadbandModel";
  private CountDownLatch lock = new CountDownLatch(1);
  private SpeechToText service;
  private SpeechResults asyncResults;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    
    String username = getProperty("speech_to_text.username");
    String password = getProperty("speech_to_text.password");
    
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        username == null || username.equals(PLACEHOLDER));

    service = new SpeechToText();
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("speech_to_text.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test create session.
   */
  @Test
  public void testCreateSession() {
    SpeechSession session = service.createSession().execute();
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session).execute();
    }
  }

  /**
   * Test create session speech model.
   */
  @Test
  public void testCreateSessionSpeechModel() {
    SpeechSession session = service.createSession(SpeechModel.EN_US_BROADBANDMODEL).execute();
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session).execute();
    }
  }

  /**
   * Test create session string.
   */
  @Test
  public void testCreateSessionString() {
    SpeechSession session = service.createSession(EN_BROADBAND16K).execute();
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session).execute();
    }
  }

  /**
   * Test get model.
   */
  @Test
  public void testGetModel() {
    SpeechModel model = service.getModel(EN_BROADBAND16K).execute();
    assertNotNull(model);
    assertNotNull(model.getName());
    assertNotNull(model.getRate());
    assertNotNull(model.getDescription());
  }

  /**
   * Test get models.
   */
  @Test
  public void testGetModels() {
    List<SpeechModel> models = service.getModels().execute();
    assertNotNull(models);
    assertTrue(!models.isEmpty());
  }

  /**
   * Test get recognize status.
   */
  @Test
  public void testGetRecognizeStatus() {
    SpeechSession session = service.createSession(SpeechModel.EN_US_BROADBANDMODEL).execute();
    SpeechSessionStatus status = service.getRecognizeStatus(session).execute();
    try {
      assertNotNull(status);
      assertNotNull(status.getModel());
      assertNotNull(status.getState());
    } finally {
      service.deleteSession(session).execute();
    }
  }

  /**
   * Test recognize audio file.
   */
  @Test
  public void testRecognizeFileString() {
    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    SpeechResults results = service.recognize(audio).execute();
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
  }

  /**
   * Test recognize file string recognize options.
   */
  @Test
  public void testRecognizeFileStringRecognizeOptions() {
    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    String contentType = HttpMediaType.AUDIO_WAV;
    RecognizeOptions options = new RecognizeOptions.Builder()
      .continuous(true)
      .timestamps(true)
      .wordConfidence(true)
      .model(EN_BROADBAND16K)
      .contentType(contentType)
      .profanityFilter(false)
      .build();
    SpeechResults results = service.recognize(audio, options).execute();
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTimestamps());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getWordConfidences());
  }

  /**
   * Test keyword recognition.
   */
  @Test
  public void testRecognizeKeywords() {
    final String keyword1 = "rain";
    final String keyword2 = "tornadoes";

    final RecognizeOptions options = new RecognizeOptions.Builder()
        .contentType("audio/wav")
        .model(SpeechModel.EN_US_BROADBANDMODEL.getName())
        .continuous(true)
        .inactivityTimeout(500)
        .keywords(new String[] { keyword1, keyword2 })
        .keywordsThreshold(0.7)
        .build();

    final File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    final SpeechResults results = service.recognize(audio, options).execute();
    final Transcript transcript = results.getResults().get(0);

    assertEquals(2, transcript.getKeywordsResult().size());
    assertTrue(transcript.getKeywordsResult().containsKey(keyword1));
    assertTrue(transcript.getKeywordsResult().containsKey(keyword2));

    assertEquals(1, transcript.getKeywordsResult().get(keyword1).size());
    assertEquals(1, transcript.getKeywordsResult().get(keyword2).size());

    final KeywordsResult result1 = transcript.getKeywordsResult().get(keyword1).get(0);
    assertEquals(keyword1, result1.getNormalizedText());
    assertEquals(0.9, result1.getConfidence(), 0.1);
    assertEquals(5.58, result1.getStartTime(), 1.0);
    assertEquals(6.14, result1.getEndTime(), 1.0);

    final KeywordsResult result2 = transcript.getKeywordsResult().get(keyword2).get(0);
    assertEquals(keyword2, result2.getNormalizedText());
    assertEquals(0.9, result2.getConfidence(), 0.1);
    assertEquals(4.42, result2.getStartTime(), 1.0);
    assertEquals(5.04, result2.getEndTime(), 1.0);
  }

  /**
   * Test recognize webSocket.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWebSocket() throws FileNotFoundException, InterruptedException {
    RecognizeOptions options = new RecognizeOptions.Builder()
        .continuous(true)
        .interimResults(true)
        .inactivityTimeout(40)
        .timestamps(true)
        .maxAlternatives(2)
        .wordAlternativesThreshold(0.5)
        .model(EN_BROADBAND16K)
        .contentType(HttpMediaType.AUDIO_WAV).build();
    FileInputStream audio = new FileInputStream("src/test/resources/speech_to_text/sample1.wav");
    
    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {

      @Override
      public void onConnected() {
        System.out.println("onConnected()");
      }

      @Override
      public void onDisconnected() {
        System.out.println("onDisconnected()");
        lock.countDown();
      }

      @Override
      public void onError(Exception e) {
        e.printStackTrace();
        lock.countDown();
      }

      @Override
      public void onTranscription(SpeechResults speechResults) {
        if (speechResults != null && speechResults.isFinal()) {
          asyncResults = speechResults;
        }
      }

    });

    lock.await(2, TimeUnit.MINUTES);
    assertNotNull(asyncResults);
    
    List<SpeechWordAlternatives> wordAlternatives = asyncResults.getResults().get(asyncResults.getResultIndex()).getWordAlternatives();
    assertTrue(wordAlternatives != null && !wordAlternatives.isEmpty());
    assertNotNull(wordAlternatives.get(0).getAlternatives());
  }


}
