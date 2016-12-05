/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word.Type;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.WordData;
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
  private static final File TWO_SPEAKERS_WAV = new File("src/test/resources/speech_to_text/twospeakers.wav");

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
   * Test recognize.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWithSpeakerLabels() throws URISyntaxException, InterruptedException {

    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true)
            .speakerLabels(true).model("en-US_NarrowbandModel")
            .contentType(HttpMediaType.AUDIO_WAV).build();

    // begin - remove when the speaker labeling is released
    String URL = "https://stream-s.watsonplatform.net/speech-to-text/api";
    service.setUsernameAndPassword("c9122908-2741-4610-93b9-f33a731ba920", "74jxojn8LV9i");
    service.setEndPoint(URL);
    // end - remove when the speaker labeling is released

    final SpeechResults result = service.recognize(TWO_SPEAKERS_WAV, options).execute();
    assertNotNull(result.getSpeakerLabels());
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

    server
        .enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(job)));

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

    server
        .enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(job)));

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
        .createCustomization(customization.getName(), SpeechModel.EN_UK_BROADBANDMODEL, customization.getDescription())
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
   * Test add text to corpus.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testAddTextToCorpus() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corpus = "cName";
    File trainingData = new File("src/test/resources/speech_to_text/corpus-text.txt");

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    service.addTextToCustomizationCorpus(id, corpus, true, trainingData).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpus) + "?allow_override=true", request.getPath());
    assertEquals(trainingData.length(), request.getBodySize());
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

    List<WordData> result = service.getWords(id, Type.ALL).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?word_type=all", request.getPath());
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

}
