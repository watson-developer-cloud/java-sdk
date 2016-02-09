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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeDelegate;

/**
 * The Class SpeechToTextIT.
 */
public class SpeechToTextIT extends WatsonServiceTest {

  private static String EN_BROADBAND16K = "en-US_BroadbandModel";
  private SpeechResults asyncResults;

  private CountDownLatch lock = new CountDownLatch(1);

  private SpeechToText service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new SpeechToText();
    service.setUsernameAndPassword(getValidProperty("speech_to_text.username"),
        getValidProperty("speech_to_text.password"));
    service.setEndPoint(getValidProperty("speech_to_text.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test create session.
   */
  @Test
  public void testCreateSession() {
    SpeechSession session = service.createSession();
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  /**
   * Test create session speech model.
   */
  @Test
  public void testCreateSessionSpeechModel() {
    SpeechSession session = service.createSession(SpeechModel.EN_BROADBAND16K);
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  /**
   * Test create session string.
   */
  @Test
  public void testCreateSessionString() {
    SpeechSession session = service.createSession(EN_BROADBAND16K);
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  /**
   * Test get model.
   */
  @Test
  public void testGetModel() {
    SpeechModel model = service.getModel(EN_BROADBAND16K);
    assertNotNull(model);
    assertNotNull(model.getName());
    assertNotNull(model.getRate());
  }

  /**
   * Test get models.
   */
  @Test
  public void testGetModels() {
    List<SpeechModel> models = service.getModels();
    assertNotNull(models);
    assertTrue(!models.isEmpty());
  }

  /**
   * Test get recognize status.
   */
  @Test
  public void testGetRecognizeStatus() {
    SpeechSession session = service.createSession(SpeechModel.EN_BROADBAND16K);
    SessionStatus status = service.getRecognizeStatus(session);
    try {
      assertNotNull(status);
      assertNotNull(status.getModel());
      assertNotNull(status.getState());
    } finally {
      service.deleteSession(session);
    }
  }

  /**
   * Test recognize audio file
   */
  @Test
  public void testRecognizeFileString() {
    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    SpeechResults results = service.recognize(audio);
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
  }

  /**
   * Test recognize file string recognize options.
   */
  @Test
  public void testRecognizeFileStringRecognizeOptions() {
    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    String contentType = HttpMediaType.AUDIO_WAV;
    RecognizeOptions options = new RecognizeOptions();
    options.continuous(true).timestamps(true).wordConfidence(true).model(EN_BROADBAND16K)
        .contentType(contentType);
    SpeechResults results = service.recognize(audio, options);
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTimestamps());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getWordConfidences());
  }

  /**
   * Test recognize webSocket
   * 
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException
   */
  @Test
  public void testRecognizeWebSocket() throws FileNotFoundException, InterruptedException {
    RecognizeOptions options = new RecognizeOptions();
    options.continuous(true).interimResults(true);
    options.inactivityTimeout(40).timestamps(true).maxAlternatives(2);
    options.model(EN_BROADBAND16K).contentType(HttpMediaType.AUDIO_WAV);

    service.recognizeUsingWebSockets(new FileInputStream(
        "src/test/resources/speech_to_text/sample1.wav"), options, new BaseRecognizeDelegate() {

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
      public void onMessage(SpeechResults speechResults) {
        if (speechResults != null && speechResults.isFinal()) {
          asyncResults = speechResults;
          //System.out.println(speechResults);
        }
      }

    });

    lock.await(20000, TimeUnit.MILLISECONDS);
    assertNotNull(asyncResults);
  }

}
