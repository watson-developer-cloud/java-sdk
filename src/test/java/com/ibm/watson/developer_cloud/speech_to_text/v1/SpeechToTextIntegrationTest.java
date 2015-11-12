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

  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new SpeechToText();
    service.setUsernameAndPassword(prop.getProperty("speech_to_text.username"),
        prop.getProperty("speech_to_text.password"));
    service.setEndPoint(prop.getProperty("speech_to_text.url"));
  }

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

  @Test
  public void testGetModel() {
    SpeechModel model = service.getModel(EN_BROADBAND16K);
    assertNotNull(model);
    assertNotNull(model.getName());
    assertNotNull(model.getRate());
  }

  @Test
  public void testGetModels() {
    List<SpeechModel> models = service.getModels();
    assertNotNull(models);
    assertTrue(!models.isEmpty());
  }

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

  @Test
  public void testRecognizeFileString() {
    File audio = new File("src/test/resources/sample1.wav");
    String contentType = HttpMediaType.AUDIO_WAV;
    SpeechResults results = service.recognize(audio, contentType);
    System.out.println(results);
  }

  @Test
  public void testRecognizeFileStringRecognizeOptions() {
    File audio = new File("src/test/resources/sample1.wav");
    String contentType = HttpMediaType.AUDIO_WAV;
    RecognizeOptions options = new RecognizeOptions();
    options.continuous(true).model(EN_BROADBAND16K);

    SpeechResults results = service.recognize(audio, contentType);
    System.out.println(results);
  }

}
