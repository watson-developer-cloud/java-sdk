/*
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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Customization;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Customization.WordTypeToAdd;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word.Sort;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word.Type;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.WordData;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.TestUtils;

import okhttp3.WebSocket;
import okhttp3.internal.ws.WebSocketRecorder;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.ByteString;

/**
 * The Class SpeechToTextTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class SpeechToTextTest extends WatsonServiceUnitTest {

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();

  private static final String PATH_CORPORA = "/v1/customizations/%s/corpora";
  private static final String PATH_CORPUS = "/v1/customizations/%s/corpora/%s";
  private static final String PATH_CUSTOMIZATION = "/v1/customizations/%s";
  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_MODELS = "/v1/models";
  private static final String PATH_RECOGNITION = "/v1/recognitions/%s";
  private static final String PATH_RECOGNITIONS = "/v1/recognitions";
  private static final String PATH_RECOGNIZE = "/v1/recognize";
  private static final String PATH_RESET = "/v1/customizations/%s/reset";
  private static final String PATH_SESSION = "/v1/sessions/%s";
  private static final String PATH_SESSIONS = "/v1/sessions";
  private static final String PATH_TRAIN = "/v1/customizations/%s/train";
  private static final String PATH_WORDS = "/v1/customizations/%s/words";
  private static final String PATH_WORD = "/v1/customizations/%s/words/%s";

  private static final File SAMPLE_WAV = new File("src/test/resources/speech_to_text/sample1.wav");
  private static final File SAMPLE_WEBM = new File("src/test/resources/speech_to_text/sample1.webm");

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
    server.enqueue(new MockResponse().setBody(session.toString()).addHeader("set-cookie", "test-cookie"));

    final SpeechSession response = service.createSession().execute();
    RecordedRequest request = server.takeRequest();

    assertNotNull(response);
    assertEquals(session, response);
    assertEquals("POST", request.getMethod());
    assertEquals(PATH_SESSIONS, request.getPath());

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteSession(response).execute();
    request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_SESSION, response.getSessionId()), request.getPath());
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

    final MockResponse mockResponse =
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(speechModel));

    server.enqueue(mockResponse);
    SpeechModel model = service.getModel("not-a-real-Model").execute();
    RecordedRequest request = server.takeRequest();

    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(PATH_MODELS + "/" + speechModel.getName(), request.getPath());

    server.enqueue(mockResponse);
    model = service.getModel(speechModel.getName()).execute();
    request = server.takeRequest();

    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(PATH_MODELS + "/" + speechModel.getName(), request.getPath());

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

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(response)));

    final List<SpeechModel> models = service.getModels().execute();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(models);
    assertFalse(models.isEmpty());
    assertEquals(models, response.get("models"));
    assertEquals(PATH_MODELS, request.getPath());
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
    speechAlternative.setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");

    final List<SpeechAlternative> speechAlternatives = ImmutableList.of(speechAlternative);
    transcript.setAlternatives(speechAlternatives);

    final List<Transcript> transcripts = ImmutableList.of(transcript);
    speechResults.setResults(transcripts);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(speechResults)));

    final SpeechResults result = service.recognize(SAMPLE_WAV).execute();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(result);
    assertEquals(result, speechResults);
    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE, request.getPath());
    assertEquals(HttpMediaType.AUDIO_WAV, request.getHeader(CONTENT_TYPE));
  }

  /**
   * Test recognize WebM for WebM audio format.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWebM() throws URISyntaxException, InterruptedException {

    final SpeechResults speechResults = new SpeechResults();
    speechResults.setResultIndex(0);
    final Transcript transcript = new Transcript();
    transcript.setFinal(true);
    final SpeechAlternative speechAlternative = new SpeechAlternative();
    speechAlternative.setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");

    final List<SpeechAlternative> speechAlternatives = ImmutableList.of(speechAlternative);
    transcript.setAlternatives(speechAlternatives);

    final List<Transcript> transcripts = ImmutableList.of(transcript);
    speechResults.setResults(transcripts);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(speechResults)));

    final SpeechResults result = service.recognize(SAMPLE_WEBM).execute();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(result);
    assertEquals(result, speechResults);
    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE, request.getPath());
    assertEquals(HttpMediaType.AUDIO_WEBM, request.getHeader(CONTENT_TYPE));
  }

  /**
   * Test diarization.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testRecognizeWithSpeakerLabels() throws URISyntaxException, InterruptedException, FileNotFoundException {
    FileInputStream jsonFile = new FileInputStream("src/test/resources/speech_to_text/diarization.json");
    String diarizationStr = getStringFromInputStream(jsonFile);
    JsonObject diarization = new JsonParser().parse(diarizationStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(diarizationStr));

    RecognizeOptions options = new RecognizeOptions.Builder()
        .speakerLabels(true)
        .build();

    SpeechResults result = service.recognize(SAMPLE_WAV, options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?speaker_labels=true", request.getPath());
    assertEquals(diarization, GSON.toJsonTree(result));
  }

  /**
   * Test recognize with customization.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWithCustomization() throws FileNotFoundException, InterruptedException {
    String id = "foo";
    String recString =
        getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/recognition.json"));
    JsonObject recognition = new JsonParser().parse(recString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(recString));

    RecognizeOptions options = new RecognizeOptions.Builder().customizationId(id).build();
    SpeechResults result = service.recognize(SAMPLE_WAV, options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?customization_id=" + id, request.getPath());
    assertEquals(recognition, GSON.toJsonTree(result));
  }

    /**
   * Test recognize with customization weight.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWithCustomizationWeight() throws FileNotFoundException, InterruptedException {
    String id = "foo";
    String recString =
        getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/recognition.json"));
    JsonObject recognition = new JsonParser().parse(recString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(recString));

    RecognizeOptions options = new RecognizeOptions.Builder().customizationId(id).customizationWeight(0.5).build();
    SpeechResults result = service.recognize(SAMPLE_WAV, options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PATH_RECOGNIZE + "?customization_id=" + id + "&customization_weight=0.5", request.getPath());
    assertEquals(recognition, GSON.toJsonTree(result));
  }

  /**
   * Test recognize -missing audio file, generate IllegalArgumentException.
   *
   * @throws URISyntaxException the URI syntax exception
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

  /**
   * Test delete recognition job.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteRecognitionJob() throws InterruptedException {
    String id = "foo";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.deleteRecognitionJob(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_RECOGNITION, id), request.getPath());
  }

  /**
   * Test create recognition job.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateRecognitionJob() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    RecognitionJob job = loadFixture("src/test/resources/speech_to_text/job.json", RecognitionJob.class);

    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(job))
    );

    RecognitionJob result = service.getRecognitionJob(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_RECOGNITION, id), request.getPath());
    assertEquals(result.toString(), job.toString());
  }

  /**
   * Test get recognition job.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetRecognitionJob() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    RecognitionJob job = loadFixture("src/test/resources/speech_to_text/job.json", RecognitionJob.class);

    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(job))
    );

    RecognitionJob result = service.getRecognitionJob(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_RECOGNITION, id), request.getPath());
    assertEquals(result.toString(), job.toString());
  }

  /**
   * Test get recognition jobs.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetRecognitionJobs() throws InterruptedException, FileNotFoundException {
    String jobsAsString = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/jobs.json"));
    JsonObject jobsAsJson = new JsonParser().parse(jobsAsString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(jobsAsString));

    List<RecognitionJob> result = service.getRecognitionJobs().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(PATH_RECOGNITIONS, request.getPath());
    assertEquals(jobsAsJson.get("recognitions"), GSON.toJsonTree(result));
  }

  /**
   * Test get customizations.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetCustomizations() throws InterruptedException, FileNotFoundException {
    String customizationsAsString =
        getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/customizations.json"));
    JsonObject customizations = new JsonParser().parse(customizationsAsString).getAsJsonObject();

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(customizationsAsString));

    List<Customization> result = service.getCustomizations("en-us").execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(PATH_CUSTOMIZATIONS + "?language=en-us", request.getPath());
    assertEquals(customizations.get("customizations").getAsJsonArray().size(), result.size());
    assertEquals(customizations.get("customizations"), GSON.toJsonTree(result));
  }

  /**
   * Test get customization.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetCustomization() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    Customization customization =
        loadFixture("src/test/resources/speech_to_text/customization.json", Customization.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(customization)));

    Customization result = service.getCustomization(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_CUSTOMIZATION, id), request.getPath());
    assertEquals(result.toString(), customization.toString());
  }

  /**
   * Test create customization.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateCustomization() throws InterruptedException, FileNotFoundException {
    Customization customization =
        loadFixture("src/test/resources/speech_to_text/customization.json", Customization.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(customization)));

    Customization result = service
        .createCustomization(customization.getName(), SpeechModel.EN_GB_BROADBANDMODEL, customization.getDescription())
        .execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_CUSTOMIZATIONS, request.getPath());
    assertEquals(result.toString(), customization.toString());
  }

  /**
   * Test delete customization.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteCustomization() throws InterruptedException {
    String id = "foo";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.deleteCustomization(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_CUSTOMIZATION, id), request.getPath());
  }

  /**
   * Test train customization.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testTrainCustomization() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    service.trainCustomization(id, WordTypeToAdd.ALL).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_TRAIN, id) + "?word_type_to_add=all", request.getPath());
  }

  /**
   * Test reset customization.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testResetCustomization() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    service.resetCustomization(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_RESET, id), request.getPath());
  }


  /**
   * Test get corpora.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetCorpora() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corporaAsString =
        getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/corpora.json"));
    JsonObject corpora = new JsonParser().parse(corporaAsString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(corporaAsString));

    List<Corpus> result = service.getCorpora(id).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_CORPORA, id), request.getPath());
    assertEquals(corpora.get("corpora"), GSON.toJsonTree(result));
  }

  /**
   * Test get corpus.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetCorpus() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corpus = "cName";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.getCorpus(id, corpus).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpus), request.getPath());
  }

  /**
   * Test delete corpus.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testDeleteCorpus() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corpus = "cName";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.deleteCorpus(id, corpus).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpus), request.getPath());
  }

  /**
   * Test add corpus.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testAddCorpus() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corpusName = "cName";
    File corpusFile = new File("src/test/resources/speech_to_text/corpus-text.txt");

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.addCorpus(id, corpusName, corpusFile, true).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpusName) + "?allow_overwrite=true", request.getPath());
    assertEquals(corpusFile.length(), request.getBodySize());
  }

  /**
   * Test get words.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetWords() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    List<WordData> result = service.getWords(id, null).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id), request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result));
  }

  /**
   * Test get words with word type all.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetWordsType() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    List<WordData> result = service.getWords(id, Type.ALL).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?word_type=all", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result));
  }

  /**
   * Test get words with sort order alphabetical.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetWordsSort() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    List<WordData> result = service.getWords(id, null, Sort.ALPHA).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?sort=alphabetical", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result));
  }

  /**
   * Test get words with word type all and sort order alphabetical.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetWordsTypeSort() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    List<WordData> result = service.getWords(id, Type.ALL, Sort.ALPHA).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?word_type=all&sort=alphabetical", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result));
  }

  /**
   * Test get word.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetWord() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordName = "bar";

    String wordAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/word.json"));
    JsonObject word = new JsonParser().parse(wordAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordAsStr));

    Word result = service.getWord(id, wordName).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORD, id, wordName), request.getPath());
    assertEquals(word, GSON.toJsonTree(result));
  }

  /**
   * Test delete word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWord() throws InterruptedException {
    String id = "foo";
    String wordName = "bar";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.deleteWord(id, wordName).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_WORD, id, wordName), request.getPath());
  }



  /**
   * Test add words.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testAddWords() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    Word newWord = loadFixture("src/test/resources/speech_to_text/word.json", Word.class);
    Map<String, Object> wordsAsMap = new HashMap<String, Object>();
    wordsAsMap.put("words", new Word[] {newWord});
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.addWords(id, newWord).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id), request.getPath());
    assertEquals(GSON.toJson(wordsAsMap), request.getBody().readUtf8());
  }

  /**
   * Test add word.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testAddWord() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    Word newWord = loadFixture("src/test/resources/speech_to_text/word.json", Word.class);
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.addWord(id, newWord).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("PUT", request.getMethod());
    assertEquals(String.format(PATH_WORD, id, newWord.getWord()), request.getPath());
    assertEquals(GSON.toJson(newWord), request.getBody().readUtf8());
  }

  @Test
  public void testClosingInputStreamClosesWebSocket() throws Exception {
    TestRecognizeCallback callback = new TestRecognizeCallback();
    WebSocketRecorder webSocketRecorder = new WebSocketRecorder("server");
    RecognizeOptions options = new RecognizeOptions.Builder()
            .contentType(HttpMediaType.AUDIO_RAW + "; rate=44000").build();
    PipedOutputStream outputStream = new PipedOutputStream();
    InputStream inputStream = new PipedInputStream(outputStream);

    server.enqueue(new MockResponse().withWebSocketUpgrade(webSocketRecorder));

    service.recognizeUsingWebSocket(inputStream, options, callback);

    WebSocket serverSocket = webSocketRecorder.assertOpen();
    serverSocket.send("{\"state\": {}}");

    outputStream.write(ByteString.encodeUtf8("test").toByteArray());
    outputStream.close();

    webSocketRecorder.assertTextMessage("{\"content-type\":\"audio/l16; rate=44000\",\"action\":\"start\"}");
    webSocketRecorder.assertBinaryMessage(ByteString.encodeUtf8("test"));
    webSocketRecorder.assertTextMessage("{\"action\":\"stop\"}");
    webSocketRecorder.assertExhausted();

    serverSocket.close(1000, null);

    callback.assertConnected();
    callback.assertDisconnected();
    callback.assertNoErrors();
    callback.assertOnTranscriptionComplete();
  }

  private static class TestRecognizeCallback implements RecognizeCallback {

    private final BlockingQueue<SpeechResults> speechResults = new LinkedBlockingQueue<>();

    private final BlockingQueue<Exception> errors = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onDisconnectedCalls = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onConnectedCalls = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onTranscriptionCompleteCalls = new LinkedBlockingQueue<>();

    @Override
    public void onTranscription(SpeechResults speechResults) {
      this.speechResults.add(speechResults);
    }

    @Override
    public void onConnected() {
      this.onConnectedCalls.add(new Object());
    }

    @Override
    public void onError(Exception e) {
      this.errors.add(e);
    }

    @Override
    public void onDisconnected() {
      this.onDisconnectedCalls.add(new Object());
    }

    void assertOnTranscriptionComplete() {
      if (this.onTranscriptionCompleteCalls.size() == 1) {
        throw new AssertionError("There were " + this.errors.size() + " calls to onTranscriptionComplete");
      }
    }

    void assertConnected() {
      try {
        Object connectedEvent = this.onConnectedCalls.poll(10, TimeUnit.SECONDS);
        if (connectedEvent == null) {
          throw new AssertionError("Timed out waiting for connect.");
        }
      } catch (InterruptedException e) {
        throw new AssertionError(e);
      }
    }

    void assertDisconnected() {
      try {
        Object disconnectedEvent = this.onDisconnectedCalls.poll(10, TimeUnit.SECONDS);
        if (disconnectedEvent == null) {
          throw new AssertionError("Timed out waiting for disconnect.");
        }
      } catch (InterruptedException e) {
        throw new AssertionError(e);
      }
    }

    void assertNoErrors() {
      if (this.errors.size() > 0) {
        throw new AssertionError("There were " + this.errors.size() + " errors");
      }
    }

    @Override
    public void onInactivityTimeout(RuntimeException runtimeException) { }

    @Override
    public void onListening() { }

    @Override
    public void onTranscriptionComplete() {
      this.onTranscriptionCompleteCalls.add(new Object());

    }
  }
}
