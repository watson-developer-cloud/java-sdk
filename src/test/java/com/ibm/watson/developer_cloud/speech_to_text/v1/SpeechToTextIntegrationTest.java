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
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;

public class SpeechToTextIntegrationTest extends WatsonServiceTest {

  private static final String EN_BROADBAND16K = "en-US_BroadbandModel";
  private SpeechToText service;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new SpeechToText();
    service.setUsernameAndPassword(getValidProperty("speech_to_text.username"),
        getValidProperty("speech_to_text.password"));
    service.setEndPoint(getValidProperty("speech_to_text.url"));
  }

  @Test
  public void testCreateSession() {
    final SpeechSession session = service.createSession();
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  @Test
  public void testCreateSessionSpeechModel() {
    final SpeechSession session = service.createSession(SpeechModel.EN_BROADBAND16K);
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  @Test
  public void testCreateSessionString() {
    final SpeechSession session = service.createSession(EN_BROADBAND16K);
    try {
      assertNotNull(session);
      assertNotNull(session.getSessionId());
    } finally {
      service.deleteSession(session);
    }
  }

  @Test
  public void testGetModel() {
    final SpeechModel model = service.getModel(EN_BROADBAND16K);
    assertNotNull(model);
    assertNotNull(model.getName());
    assertNotNull(model.getRate());
  }

  @Test
  public void testGetModels() {
    final List<SpeechModel> models = service.getModels();
    assertNotNull(models);
    assertTrue(!models.isEmpty());
  }

  @Test
  public void testGetRecognizeStatus() {
    final SpeechSession session = service.createSession(SpeechModel.EN_BROADBAND16K);
    final SessionStatus status = service.getRecognizeStatus(session);
    try {
      assertNotNull(status);
      assertNotNull(status.getModel());
      assertNotNull(status.getState());
    } finally {
      service.deleteSession(session);
    }
  }

  @Test
  public void testRecognizeFileString() {
    final File audio = new File("src/test/resources/sample1.wav");
    final String contentType = HttpMediaType.AUDIO_WAV;
    final SpeechResults results = service.recognize(audio, contentType);
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
  }

  @Test
  public void testRecognizeFileStringRecognizeOptions() {
    final File audio = new File("src/test/resources/sample1.wav");
    final String contentType = HttpMediaType.AUDIO_WAV;
    final RecognizeOptions options = new RecognizeOptions();
    options.continuous(true).model(EN_BROADBAND16K);
    final SpeechResults results = service.recognize(audio, contentType, options);
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
  }

}
