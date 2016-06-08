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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.TestUtils;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * The Class SpeechToTextTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class SpeechToTextTest extends WatsonServiceUnitTest {

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private final static String CREATE_DELETE_SESSIONS_PATH = "/v1/sessions";
  private final static String GET_MODELS_PATH = "/v1/models";
  private final static String RECOGNIZE_PATH = "/v1/recognize";
  private final static File SAMPLE_WAV = new File("src/test/resources/speech_to_text/sample1.wav");

  private SpeechToText service;
  private SpeechSession session;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    session = loadFixture("src/test/resources/speech_to_text/session.json", SpeechSession.class);

    service = new SpeechToText();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test create and delete session.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateAndDeleteSession() throws InterruptedException {
    server.enqueue(new MockResponse()
        .setBody(session.toString())
        .addHeader("set-cookie", "test-cookie"));

    final SpeechSession response = service.createSession().execute();
    RecordedRequest request = server.takeRequest();
    
    assertNotNull(response);
    assertEquals(session, response);
    assertEquals("POST", request.getMethod());
    assertEquals(CREATE_DELETE_SESSIONS_PATH, request.getPath());

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteSession(response).execute();
    request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(CREATE_DELETE_SESSIONS_PATH + "/" + response.getSessionId(), request.getPath());
  }

  /**
   * Test delete session with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteSessionWithNull() {
    service.deleteSession(null).execute();
  }

  /**
   * Test PCM without rate.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPcmWithoutRate() {
    new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_RAW).build();
  }

  /**
   * Test PCM with rate.
   */
  @Test
  public void testPcmWithRate() {
    new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_RAW + "; rate=44000").build();
  }

  /**
   * Test get model.
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetModel() throws Exception {
    final SpeechModel speechModel = new SpeechModel("not-a-real-Model");
    speechModel.setRate(8000);

    final MockResponse mockResponse = new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(speechModel));

    server.enqueue(mockResponse);
    SpeechModel model = service.getModel("not-a-real-Model").execute();
    RecordedRequest request = server.takeRequest();
    
    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(GET_MODELS_PATH + "/" + speechModel.getName(), request.getPath());

    server.enqueue(mockResponse);
    model = service.getModel(speechModel.getName()).execute();
    request = server.takeRequest();
    
    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(GET_MODELS_PATH + "/" + speechModel.getName(), request.getPath());

    TestUtils.assertNoExceptionsOnGetters(model);
  }

  /**
   * Test get models.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetModels() throws InterruptedException {
    final SpeechModel speechModel = new SpeechModel("not-a-real-Model");
    speechModel.setRate(8000);

    final SpeechModel speechModel1 = new SpeechModel("not-a-real-Model1");
    speechModel1.setRate(1600);

    final SpeechModel speechModel2 = new SpeechModel("not-a-real-Model2");
    speechModel2.setRate(8000);

    final List<SpeechModel> speechModels = ImmutableList.of(speechModel, speechModel1, speechModel2);
    final Map<String, ?> response = ImmutableMap.of("models", speechModels);

    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(response)));

    final List<SpeechModel> models = service.getModels().execute();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(models);
    assertFalse(models.isEmpty());
    assertEquals(models, response.get("models"));
    assertEquals(GET_MODELS_PATH, request.getPath());
  }

  /**
   * Test get model with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetModelWithNull() {
    final String model = null;
    service.getModel(model).execute();
  }

  /**
   * Test recognize.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognize() throws URISyntaxException, InterruptedException {

    final SpeechResults speechResults = new SpeechResults();
    speechResults.setResultIndex(0);
    final Transcript transcript = new Transcript();
    transcript.setFinal(true);
    final SpeechAlternative speechAlternative = new SpeechAlternative();
    speechAlternative
        .setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");

    final List<SpeechAlternative> speechAlternatives = ImmutableList.of(speechAlternative);
    transcript.setAlternatives(speechAlternatives);

    final List<Transcript> transcripts = ImmutableList.of(transcript);
    speechResults.setResults(transcripts);

    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(speechResults)));

    final SpeechResults result = service.recognize(SAMPLE_WAV).execute();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(result);
    assertEquals(result, speechResults);
    assertEquals("POST", request.getMethod());
    assertEquals(RECOGNIZE_PATH, request.getPath());
    assertEquals(HttpMediaType.AUDIO_WAV, request.getHeader(CONTENT_TYPE));
  }

  /**
   * Test recognize -missing audio file, generate IllegalArgumentException.
   *
   * @throws URISyntaxException           the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeMissingAudioFile() throws URISyntaxException, InterruptedException {
    final File audio = new File("sample-not-existing.wav");

    try {
      service.recognize(audio).execute();
      fail("No IllegalArgumentException was thrown");
    } catch (final IllegalArgumentException e) {
      // success
    }

    assertEquals(0, server.getRequestCount());
  }

  /**
   * Test MediaTypeUtils class.
   */
  @Test
  public void testMediaTypeUtils() {
    assertEquals(HttpMediaType.AUDIO_WAV, MediaTypeUtils.getMediaTypeFromFile(new File("test.wav")));
    assertEquals(HttpMediaType.AUDIO_OGG, MediaTypeUtils.getMediaTypeFromFile(new File("test.OGG")));
    assertNull(MediaTypeUtils.getMediaTypeFromFile(new File("invalid.png")));
    assertNull(MediaTypeUtils.getMediaTypeFromFile(new File("invalidwav")));
    assertNull(MediaTypeUtils.getMediaTypeFromFile(null));

    assertTrue(MediaTypeUtils.isValidMediaType("audio/wav"));
    assertFalse(MediaTypeUtils.isValidMediaType("image/png"));
    assertFalse(MediaTypeUtils.isValidMediaType(null));
  }
}
