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

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockserver.model.Header;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.TestUtils;

import io.netty.handler.codec.http.HttpHeaders;

/**
 * The Class SpeechToTextTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class SpeechToTextTest extends WatsonServiceUnitTest {

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private final static String CREATE_DELETE_SESSIONS_PATH = "/v1/sessions";
  private final static String GET_MODELS_PATH = "/v1/models";
  private final static String RECOGNIZE_PATH = "/v1/recognize";
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


    service = new SpeechToText();
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);


    session = loadFixture("src/test/resources/speech_to_text/session.json", SpeechSession.class);
  }

  /**
   * Test create and delete session.
   */
  @Test
  public void testCreateAndDeleteSession() {
    mockServer.when(request().withMethod(POST).withPath(CREATE_DELETE_SESSIONS_PATH)).

    respond(
        response().withHeaders(APPLICATION_JSON, new Header("set-cookie", "test-cookie")).withBody(
            GSON.toJson(session)));

    final SpeechSession response = service.createSession().execute();
    Assert.assertNotNull(response);
    Assert.assertEquals(session, response);

    mockServer.when(
        request().withMethod("DELETE").withPath(
            CREATE_DELETE_SESSIONS_PATH + "/" + response.getSessionId())

    ).respond(response().withStatusCode(204));
    service.deleteSession(response).execute();
  }

  /**
   * Test delete session with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteSessionWithNull() {
    service.deleteSession(null).execute();
  }


  /**
   * Test PCM without rate
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPcmWithoutRate() {
    new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_RAW).build();
  }
  
  /**
   * Test PCM with rate
   */
  @Test
  public void testPcmWithRate() {
    new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_RAW + "; rate=44000").build();
  }
  
  /**
   * Test get model.
   */
  @Test
  public void testGetModel() {

    final SpeechModel speechModel = new SpeechModel("not-a-real-Model");
    speechModel.setRate(8000);

    mockServer.when(request().withPath(GET_MODELS_PATH + "/" + speechModel.getName())).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GSON.toJson(speechModel)));


    SpeechModel model = service.getModel("not-a-real-Model").execute();
    Assert.assertNotNull(model);
    Assert.assertEquals(model, speechModel);

    model = service.getModel(speechModel.getName()).execute();
    Assert.assertNotNull(model);
    Assert.assertEquals(model, speechModel);

    try {
      TestUtils.assertNoExceptionsOnGetters(model);
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Test get models.
   */
  @Test
  public void testGetModels() {

    final List<SpeechModel> speechModels = new ArrayList<SpeechModel>();

    final SpeechModel speechModel = new SpeechModel("not-a-real-Model");
    speechModel.setRate(8000);

    final SpeechModel speechModel1 = new SpeechModel("not-a-real-Model1");
    speechModel1.setRate(1600);

    final SpeechModel speechModel2 = new SpeechModel("not-a-real-Model2");
    speechModel2.setRate(8000);

    speechModels.add(speechModel);
    speechModels.add(speechModel1);
    speechModels.add(speechModel2);

    final Map<String, Object> response = new HashMap<String, Object>();
    response.put("models", speechModels);
    
    mockServer.when(request().withPath(GET_MODELS_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GSON.toJson(response)));
    final List<SpeechModel> models = service.getModels().execute();
    Assert.assertNotNull(models);
    Assert.assertFalse(models.isEmpty());
    Assert.assertEquals(models, response.get("models"));
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
   */
  @Test
  public void testRecognize() throws URISyntaxException {

    final SpeechResults speechResults = new SpeechResults();
    speechResults.setResultIndex(0);
    final Transcript transcript = new Transcript();
    transcript.setFinal(true);
    final SpeechAlternative speechAlternative = new SpeechAlternative();
    speechAlternative
        .setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");
    final List<SpeechAlternative> speechAlternatives = new ArrayList<SpeechAlternative>();
    speechAlternatives.add(speechAlternative);

    transcript.setAlternatives(speechAlternatives);
    final List<Transcript> transcripts = new ArrayList<Transcript>();
    transcripts.add(transcript);
    speechResults.setResults(transcripts);

    final File audio = new File("src/test/resources/speech_to_text/sample1.wav");

    mockServer.when(
        request().withMethod(POST).withPath(RECOGNIZE_PATH)
            .withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.AUDIO_WAV)))

    .respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GSON.toJson(speechResults)));
    final SpeechResults result = service.recognize(audio).execute();
    Assert.assertNotNull(result);
    Assert.assertEquals(result, speechResults);
  }

  /**
   * Test recognize -missing audio file, generate IllegalArgumentException.
   * 
   * @throws URISyntaxException the URI syntax exception
   */
  @Test
  public void testRecognizeMissingAudioFile() throws URISyntaxException {

    final SpeechResults speechResults = new SpeechResults();
    speechResults.setResultIndex(0);

    final Transcript transcript = new Transcript();
    transcript.setFinal(true);

    final SpeechAlternative speechAlternative = new SpeechAlternative();
    speechAlternative
        .setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");

    final List<SpeechAlternative> speechAlternatives = new ArrayList<SpeechAlternative>();
    speechAlternatives.add(speechAlternative);

    transcript.setAlternatives(speechAlternatives);
    final List<Transcript> transcripts = new ArrayList<Transcript>();
    transcripts.add(transcript);
    speechResults.setResults(transcripts);

    // File audio = new File("src/test/resources/sample1.wav");

    mockServer.when(
        request().withMethod("POST").withPath(RECOGNIZE_PATH)
            .withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.AUDIO_WAV)))
        .respond(
            response().withHeader(APPLICATION_JSON).withBody(
                GSON.toJson(speechResults)));

    boolean didItHappen = false;
    try {
      service.recognize(null).execute();
    } catch (final IllegalArgumentException e) {
      didItHappen = true;
    }
    Assert.assertTrue("Check that 'IllegalArgumentException' is thrown.", didItHappen);
  }
}
