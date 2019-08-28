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
package com.ibm.watson.speech_to_text.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.watson.common.TestUtils;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.speech_to_text.v1.model.AcousticModel;
import com.ibm.watson.speech_to_text.v1.model.AcousticModels;
import com.ibm.watson.speech_to_text.v1.model.AddAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.AddGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.AudioListing;
import com.ibm.watson.speech_to_text.v1.model.AudioResource;
import com.ibm.watson.speech_to_text.v1.model.AudioResources;
import com.ibm.watson.speech_to_text.v1.model.CheckJobOptions;
import com.ibm.watson.speech_to_text.v1.model.Corpora;
import com.ibm.watson.speech_to_text.v1.model.CreateAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.CreateJobOptions;
import com.ibm.watson.speech_to_text.v1.model.CreateLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.CustomWord;
import com.ibm.watson.speech_to_text.v1.model.DeleteAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteJobOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteUserDataOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteWordOptions;
import com.ibm.watson.speech_to_text.v1.model.GetAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.GetCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.GetGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.GetLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetWordOptions;
import com.ibm.watson.speech_to_text.v1.model.Grammar;
import com.ibm.watson.speech_to_text.v1.model.Grammars;
import com.ibm.watson.speech_to_text.v1.model.LanguageModel;
import com.ibm.watson.speech_to_text.v1.model.LanguageModels;
import com.ibm.watson.speech_to_text.v1.model.ListAcousticModelsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.ListCorporaOptions;
import com.ibm.watson.speech_to_text.v1.model.ListGrammarsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListLanguageModelsOptions;
import com.ibm.watson.speech_to_text.v1.model.ListWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.speech_to_text.v1.model.RecognitionJobs;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.RegisterCallbackOptions;
import com.ibm.watson.speech_to_text.v1.model.RegisterStatus;
import com.ibm.watson.speech_to_text.v1.model.ResetAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.ResetLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.speech_to_text.v1.model.SpeechModels;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.speech_to_text.v1.model.TrainAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.TrainLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.UnregisterCallbackOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.Word;
import com.ibm.watson.speech_to_text.v1.model.Words;
import com.ibm.watson.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.speech_to_text.v1.websocket.RecognizeCallback;
import okhttp3.WebSocket;
import okhttp3.internal.ws.WebSocketRecorder;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
  private static final String PATH_ACOUSTIC_CUSTOMIZATION = "/v1/acoustic_customizations/%s";
  private static final String PATH_ACOUSTIC_CUSTOMIZATIONS = "/v1/acoustic_customizations";
  private static final String PATH_MODELS = "/v1/models";
  private static final String PATH_RECOGNITION = "/v1/recognitions/%s";
  private static final String PATH_RECOGNITIONS = "/v1/recognitions";
  private static final String PATH_RECOGNIZE = "/v1/recognize";
  private static final String PATH_ACOUSTIC_RESET = "/v1/acoustic_customizations/%s/reset";
  private static final String PATH_RESET = "/v1/customizations/%s/reset";
  private static final String PATH_ACOUSTIC_TRAIN = "/v1/acoustic_customizations/%s/train";
  private static final String PATH_TRAIN = "/v1/customizations/%s/train";
  private static final String PATH_WORDS = "/v1/customizations/%s/words";
  private static final String PATH_WORD = "/v1/customizations/%s/words/%s";
  private static final String PATH_ACOUSTIC_UPGRADE = "/v1/acoustic_customizations/%s/upgrade_model";
  private static final String PATH_UPGRADE = "/v1/customizations/%s/upgrade_model";
  private static final String PATH_ALL_AUDIO = "/v1/acoustic_customizations/%s/audio";
  private static final String PATH_SPECIFIC_AUDIO = "/v1/acoustic_customizations/%s/audio/%s";
  private static final String REGISTER_CALLBACK = "/v1/register_callback?callback_url=%s&user_secret=%s";
  private static final String UNREGISTER_CALLBACK = "/v1/unregister_callback?callback_url=%s";

  private static final File SAMPLE_WAV = new File("src/test/resources/speech_to_text/sample1.wav");
  private static final File SAMPLE_WEBM = new File("src/test/resources/speech_to_text/sample1.webm");

  private static final String UPDATED = "2019-10-11T19:16:58.547Z";

  private SpeechModel speechModel;
  private SpeechModels speechModels;
  private SpeechRecognitionResults recognitionResults;
  private Grammars grammars;
  private Grammar grammar;

  private SpeechToText service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new SpeechToText(new NoAuthAuthenticator());
    service.setEndPoint(getMockWebServerUrl());

    speechModel = loadFixture("src/test/resources/speech_to_text/speech-model.json", SpeechModel.class);
    speechModels = loadFixture("src/test/resources/speech_to_text/speech-models.json", SpeechModels.class);
    recognitionResults = loadFixture("src/test/resources/speech_to_text/recognition-results.json",
        SpeechRecognitionResults.class);
    grammars = loadFixture("src/test/resources/speech_to_text/grammar_list.json", Grammars.class);
    grammar = loadFixture("src/test/resources/speech_to_text/grammar.json", Grammar.class);
  }

  // --- MODELS ---

  @Test
  public void testDeleteUserDataOptionsBuilder() {
    String customerId = "customerId";

    DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
        .customerId(customerId)
        .build();

    assertEquals(deleteOptions.customerId(), customerId);
  }

  @Test
  public void testAddGrammarOptions() throws FileNotFoundException {
    String customizationId = "id";
    String grammarName = "grammar_name";
    InputStream grammarFile = new FileInputStream(SAMPLE_WAV);

    AddGrammarOptions addGrammarOptions = new AddGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .grammarFile(grammarFile)
        .contentType(AddGrammarOptions.ContentType.APPLICATION_SRGS)
        .allowOverwrite(true)
        .build();

    assertEquals(customizationId, addGrammarOptions.customizationId());
    assertEquals(grammarName, addGrammarOptions.grammarName());
    assertEquals(grammarFile, addGrammarOptions.grammarFile());
    assertEquals(AddGrammarOptions.ContentType.APPLICATION_SRGS, addGrammarOptions.contentType());
    assertTrue(addGrammarOptions.allowOverwrite());
  }

  @Test
  public void testListGrammarsOptions() {
    String customizationId = "id";

    ListGrammarsOptions listGrammarsOptions = new ListGrammarsOptions.Builder()
        .customizationId(customizationId)
        .build();

    assertEquals(customizationId, listGrammarsOptions.customizationId());
  }

  @Test
  public void testGetGrammarOptions() {
    String customizationId = "id";
    String grammarName = "grammar_name";

    GetGrammarOptions getGrammarOptions = new GetGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();

    assertEquals(customizationId, getGrammarOptions.customizationId());
    assertEquals(grammarName, getGrammarOptions.grammarName());
  }

  @Test
  public void testDeleteGrammarOptions() {
    String customizationId = "id";
    String grammarName = "grammar_name";

    DeleteGrammarOptions deleteGrammarOptions = new DeleteGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();

    assertEquals(customizationId, deleteGrammarOptions.customizationId());
    assertEquals(grammarName, deleteGrammarOptions.grammarName());
  }

  // --- METHODS ---

  /**
   * Test get model.
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetModel() throws Exception {
    final MockResponse mockResponse = new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(speechModel));

    server.enqueue(mockResponse);
    GetModelOptions getOptionsString = new GetModelOptions.Builder()
        .modelId("not-a-real-Model")
        .build();
    SpeechModel model = service.getModel(getOptionsString).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(GET, request.getMethod());

    server.enqueue(mockResponse);
    GetModelOptions getOptionsGetter = new GetModelOptions.Builder()
        .modelId("not-a-real-Model")
        .build();
    model = service.getModel(getOptionsGetter).execute().getResult();
    request = server.takeRequest();

    assertNotNull(model);
    assertEquals(model, speechModel);
    assertEquals(GET, request.getMethod());

    TestUtils.assertNoExceptionsOnGetters(model);
  }

  /**
   * Test get models.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetModels() throws InterruptedException {
    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(speechModels)));

    final SpeechModels models = service.listModels().execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(models);
    assertFalse(models.getModels().isEmpty());
    assertEquals(models.getModels(), speechModels.getModels());
    assertEquals(PATH_MODELS, request.getPath());
  }

  /**
   * Test get model with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetModelWithNull() {
    service.getModel(null).execute().getResult();
  }

  /**
   * Test recognize.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognize() throws URISyntaxException, InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(recognitionResults)));

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WAV)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .audioMetrics(true)
        .build();
    final SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(result);
    assertEquals(result, recognitionResults);
    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?audio_metrics=true", request.getPath());
    assertEquals(HttpMediaType.AUDIO_WAV, request.getHeader(CONTENT_TYPE));
    assertEquals(recognitionResults.getAudioMetrics().getSamplingInterval(),
        result.getAudioMetrics().getSamplingInterval());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().isXfinal(),
        result.getAudioMetrics().getAccumulated().isXfinal());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getEndTime(),
        result.getAudioMetrics().getAccumulated().getEndTime());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getSpeechRatio(),
        result.getAudioMetrics().getAccumulated().getSpeechRatio());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getHighFrequencyLoss(),
        result.getAudioMetrics().getAccumulated().getHighFrequencyLoss());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getSignalToNoiseRatio(),
        result.getAudioMetrics().getAccumulated().getSignalToNoiseRatio());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getBegin(),
        result.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getBegin());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getEnd(),
        result.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getEnd());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getCount(),
        result.getAudioMetrics().getAccumulated().getDirectCurrentOffset().get(0).getCount());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getClippingRate().get(0).getBegin(),
        result.getAudioMetrics().getAccumulated().getClippingRate().get(0).getBegin());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getClippingRate().get(0).getEnd(),
        result.getAudioMetrics().getAccumulated().getClippingRate().get(0).getEnd());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getClippingRate().get(0).getCount(),
        result.getAudioMetrics().getAccumulated().getClippingRate().get(0).getCount());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getBegin(),
        result.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getBegin());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getEnd(),
        result.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getEnd());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getCount(),
        result.getAudioMetrics().getAccumulated().getSpeechLevel().get(0).getCount());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getBegin(),
        result.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getBegin());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getEnd(),
        result.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getEnd());
    assertEquals(recognitionResults.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getCount(),
        result.getAudioMetrics().getAccumulated().getNonSpeechLevel().get(0).getCount());
  }

  /**
   * Test recognize WebM for WebM audio format.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWebM() throws URISyntaxException, InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(recognitionResults)));

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WEBM)
        .contentType(RecognizeOptions.ContentType.AUDIO_WEBM)
        .build();
    final SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertNotNull(result);
    assertEquals(result, recognitionResults);
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

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WAV)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .speakerLabels(true)
        .build();
    SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?speaker_labels=true", request.getPath());
    assertEquals(diarization.toString(), GSON.toJsonTree(result).toString());
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
    String version = "version";
    String recString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/recognition.json"));
    JsonObject recognition = new JsonParser().parse(recString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(recString));

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WAV)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .languageCustomizationId(id)
        .baseModelVersion(version)
        .build();
    SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?language_customization_id=" + id + "&base_model_version=" + version, request
        .getPath());
    assertEquals(recognition, GSON.toJsonTree(result));
  }

  /**
   * Test recognize with acoustic customization.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeWithAcousticCustomization() throws FileNotFoundException, InterruptedException {
    String id = "foo";
    String version = "version";
    String recString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/recognition.json"));
    JsonObject recognition = new JsonParser().parse(recString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(recString));

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WAV)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .acousticCustomizationId(id)
        .baseModelVersion(version)
        .build();
    SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNIZE + "?acoustic_customization_id=" + id + "&base_model_version=" + version,
        request.getPath());
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
    String recString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/recognition.json"));
    JsonObject recognition = new JsonParser().parse(recString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(recString));

    RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
        .audio(SAMPLE_WAV)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .languageCustomizationId(id)
        .customizationWeight(0.5)
        .build();
    SpeechRecognitionResults result = service.recognize(recognizeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PATH_RECOGNIZE + "?language_customization_id=" + id + "&customization_weight=0.5", request.getPath());
    assertEquals(recognition, GSON.toJsonTree(result));
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

  @Test
  public void testCreateJob() throws InterruptedException, FileNotFoundException {
    String callbackUrl = "callback";
    String events = CreateJobOptions.Events.RECOGNITIONS_STARTED;
    String userToken = "token";
    Long resultsTtl = 5L;
    File audio = SAMPLE_WAV;
    String contentType = CreateJobOptions.ContentType.AUDIO_WAV;
    String model = CreateJobOptions.Model.EN_US_BROADBANDMODEL;
    String customizationId = "customizationId";
    Double customizationWeight = 5d;
    String version = "version";
    Long inactivityTimeout = 20L;
    List<String> keywords = Arrays.asList("keyword1", "keyword2");
    Float keywordsThreshold = 5f;
    Boolean wordConfidence = true;
    Boolean timestamps = true;
    Boolean profanityFilter = true;
    Boolean smartFormatting = true;
    Boolean speakerLabels = true;

    RecognitionJob job = loadFixture("src/test/resources/speech_to_text/job.json", RecognitionJob.class);
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(job)));

    CreateJobOptions createOptions = new CreateJobOptions.Builder()
        .callbackUrl(callbackUrl)
        .events(events)
        .userToken(userToken)
        .resultsTtl(resultsTtl)
        .audio(audio)
        .contentType(contentType)
        .model(model)
        .languageCustomizationId(customizationId)
        .customizationWeight(customizationWeight)
        .baseModelVersion(version)
        .inactivityTimeout(inactivityTimeout)
        .keywords(keywords)
        .keywordsThreshold(keywordsThreshold)
        .wordConfidence(wordConfidence)
        .timestamps(timestamps)
        .profanityFilter(profanityFilter)
        .smartFormatting(smartFormatting)
        .speakerLabels(speakerLabels)
        .build();
    service.createJob(createOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_RECOGNITIONS
        + "?model=" + model
        + "&callback_url=" + callbackUrl
        + "&events=" + events
        + "&user_token=" + userToken
        + "&results_ttl=" + resultsTtl
        + "&language_customization_id=" + customizationId
        + "&base_model_version=" + version
        + "&customization_weight=" + customizationWeight
        + "&inactivity_timeout=" + inactivityTimeout
        + "&keywords=" + RequestUtils.encode(StringUtils.join(keywords, ','))
        + "&keywords_threshold=" + keywordsThreshold
        + "&word_confidence=" + wordConfidence
        + "&timestamps=" + timestamps
        + "&profanity_filter=" + profanityFilter
        + "&smart_formatting=" + smartFormatting
        + "&speaker_labels=" + speakerLabels,
        request.getPath());
  }

  /**
   * Test delete job.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteJob() throws InterruptedException {
    String id = "foo";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    DeleteJobOptions deleteOptions = new DeleteJobOptions.Builder()
        .id(id)
        .build();
    service.deleteJob(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_RECOGNITION, id), request.getPath());
  }

  /**
   * Test check job.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCheckJob() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    RecognitionJob job = loadFixture("src/test/resources/speech_to_text/job.json", RecognitionJob.class);

    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(job)));

    CheckJobOptions checkOptions = new CheckJobOptions.Builder()
        .id(id)
        .build();
    RecognitionJob result = service.checkJob(checkOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_RECOGNITION, id), request.getPath());
    assertEquals(result.toString(), job.toString());
  }

  /**
   * Test check jobs.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCheckJobs() throws InterruptedException, FileNotFoundException {
    String jobsAsString = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/jobs.json"));
    JsonObject jobsAsJson = new JsonParser().parse(jobsAsString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(jobsAsString));

    RecognitionJobs result = service.checkJobs().execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(PATH_RECOGNITIONS, request.getPath());
    assertEquals(jobsAsJson.get("recognitions"), GSON.toJsonTree(result.getRecognitions()));
  }

  /**
   * Test list language models.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListLanguageModels() throws InterruptedException, FileNotFoundException {
    String customizationsAsString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/customizations.json"));
    JsonObject customizations = new JsonParser().parse(customizationsAsString).getAsJsonObject();

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(customizationsAsString));

    ListLanguageModelsOptions listOptions = new ListLanguageModelsOptions.Builder()
        .language("en-us")
        .build();
    LanguageModels result = service.listLanguageModels(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(PATH_CUSTOMIZATIONS + "?language=en-us", request.getPath());
    assertEquals(customizations.get("customizations").getAsJsonArray().size(), result.getCustomizations().size());
    assertEquals(customizations.get("customizations"), GSON.toJsonTree(result.getCustomizations()));
  }

  /**
   * Test get language model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetLanguageModel() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    LanguageModel model = loadFixture("src/test/resources/speech_to_text/customization.json", LanguageModel.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(model)));

    GetLanguageModelOptions getOptions = new GetLanguageModelOptions.Builder()
        .customizationId(id)
        .build();
    LanguageModel result = service.getLanguageModel(getOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_CUSTOMIZATION, id), request.getPath());
    assertEquals(result.toString(), model.toString());
    assertEquals(UPDATED, result.getUpdated());
  }

  /**
   * Test create language model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateLanguageModel() throws InterruptedException, FileNotFoundException {
    LanguageModel model = loadFixture("src/test/resources/speech_to_text/customization.json", LanguageModel.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(model)));

    CreateLanguageModelOptions createOptions = new CreateLanguageModelOptions.Builder()
        .name(model.getName())
        .baseModelName("en-GB_BroadbandModel")
        .description(model.getDescription())
        .build();
    LanguageModel result = service.createLanguageModel(createOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_CUSTOMIZATIONS, request.getPath());
    assertEquals(result.toString(), model.toString());
  }

  /**
   * Test delete language model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteLanguageModel() throws InterruptedException {
    String id = "foo";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    DeleteLanguageModelOptions deleteOptions = new DeleteLanguageModelOptions.Builder()
        .customizationId(id)
        .build();
    service.deleteLanguageModel(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_CUSTOMIZATION, id), request.getPath());
  }

  /**
   * Test train language model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testTrainLanguageModel() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    TrainLanguageModelOptions trainOptions = new TrainLanguageModelOptions.Builder()
        .customizationId(id)
        .wordTypeToAdd(TrainLanguageModelOptions.WordTypeToAdd.ALL)
        .customizationWeight(0.5)
        .build();
    service.trainLanguageModel(trainOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_TRAIN, id) + "?word_type_to_add=all&customization_weight=" + 0.5,
        request.getPath());
  }

  /**
   * Test reset language model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testResetLanguageModel() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    ResetLanguageModelOptions resetOptions = new ResetLanguageModelOptions.Builder()
        .customizationId(id)
        .build();
    service.resetLanguageModel(resetOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_RESET, id), request.getPath());
  }

  /**
   * Test upgrade language model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpgradeLanguageModel() throws InterruptedException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    UpgradeLanguageModelOptions upgradeOptions = new UpgradeLanguageModelOptions.Builder()
        .customizationId(id)
        .build();
    service.upgradeLanguageModel(upgradeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_UPGRADE, id), request.getPath());
  }

  /**
   * Test list corpora.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListCorpora() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String corporaAsString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/corpora.json"));
    JsonObject corpora = new JsonParser().parse(corporaAsString).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(corporaAsString));

    ListCorporaOptions listOptions = new ListCorporaOptions.Builder()
        .customizationId(id)
        .build();
    Corpora result = service.listCorpora(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_CORPORA, id), request.getPath());
    assertEquals(corpora.get("corpora"), GSON.toJsonTree(result.getCorpora()));
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

    GetCorpusOptions getOptions = new GetCorpusOptions.Builder()
        .customizationId(id)
        .corpusName(corpus)
        .build();
    service.getCorpus(getOptions).execute().getResult();
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

    DeleteCorpusOptions deleteOptions = new DeleteCorpusOptions.Builder()
        .customizationId(id)
        .corpusName(corpus)
        .build();
    service.deleteCorpus(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpus), request.getPath());
  }

  /**
   * Test add corpus.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException the IO exception
   */
  @Test
  public void testAddCorpus() throws InterruptedException, IOException {
    String id = "foo";
    String corpusName = "cName";
    File corpusFile = new File("src/test/resources/speech_to_text/corpus-text.txt");
    String corpusFileText = new String(Files.readAllBytes(Paths.get(corpusFile.toURI())));

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    AddCorpusOptions addOptions = new AddCorpusOptions.Builder()
        .customizationId(id)
        .corpusName(corpusName)
        .corpusFile(corpusFile)
        .allowOverwrite(true)
        .build();
    service.addCorpus(addOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_CORPUS, id, corpusName) + "?allow_overwrite=true", request.getPath());
    assertTrue(request.getBody().readUtf8().contains(corpusFileText));
  }

  /**
   * Test list words.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListWords() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(id)
        .build();
    Words result = service.listWords(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id), request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result.getWords()));
  }

  /**
   * Test list words with word type all.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListWordsType() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(id)
        .wordType(ListWordsOptions.WordType.ALL)
        .build();
    Words result = service.listWords(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?word_type=all", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result.getWords()));
  }

  /**
   * Test list words with sort order alphabetical.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListWordsSort() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(id)
        .sort(ListWordsOptions.Sort.ALPHABETICAL)
        .build();
    Words result = service.listWords(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?sort=alphabetical", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result.getWords()));
  }

  /**
   * Test list words with word type all and sort order alphabetical.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListWordsTypeSort() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String wordsAsStr = getStringFromInputStream(new FileInputStream("src/test/resources/speech_to_text/words.json"));
    JsonObject words = new JsonParser().parse(wordsAsStr).getAsJsonObject();

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(wordsAsStr));

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(id)
        .sort(ListWordsOptions.Sort.ALPHABETICAL)
        .wordType(ListWordsOptions.WordType.ALL)
        .build();
    Words result = service.listWords(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id) + "?word_type=all&sort=alphabetical", request.getPath());
    assertEquals(words.get("words"), GSON.toJsonTree(result.getWords()));
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

    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(id)
        .wordName(wordName)
        .build();
    Word result = service.getWord(getOptions).execute().getResult();
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

    DeleteWordOptions deleteOptions = new DeleteWordOptions.Builder()
        .customizationId(id)
        .wordName(wordName)
        .build();
    service.deleteWord(deleteOptions).execute();
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
    wordsAsMap.put("words", new Word[] { newWord });
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    CustomWord word = new CustomWord.Builder()
        .word(newWord.getWord())
        .displayAs(newWord.getDisplayAs())
        .soundsLike(newWord.getSoundsLike())
        .build();

    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(id)
        .addWords(word)
        .build();
    service.addWords(addOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_WORDS, id), request.getPath());
    Gson testGsonNoNulls = new Gson();
    assertEquals(testGsonNoNulls.toJson(wordsAsMap), request.getBody().readUtf8());
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

    AddWordOptions addOptions = new AddWordOptions.Builder()
        .wordName(newWord.getWord())
        .customizationId(id)
        .word(newWord.getWord())
        .displayAs(newWord.getDisplayAs())
        .soundsLike(newWord.getSoundsLike())
        .build();
    service.addWord(addOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("PUT", request.getMethod());
    assertEquals(String.format(PATH_WORD, id, newWord.getWord()), request.getPath());
    Gson testGsonNoNulls = new Gson();
    assertEquals(testGsonNoNulls.toJson(newWord), request.getBody().readUtf8());
  }

  /**
   * Test create acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateAcousticModel() throws InterruptedException, FileNotFoundException {
    AcousticModel model = loadFixture("src/test/resources/speech_to_text/acoustic-model.json", AcousticModel.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(model)));

    CreateAcousticModelOptions createOptions = new CreateAcousticModelOptions.Builder()
        .name(model.getName())
        .baseModelName(model.getBaseModelName())
        .description(model.getDescription())
        .build();
    AcousticModel result = service.createAcousticModel(createOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(PATH_ACOUSTIC_CUSTOMIZATIONS, request.getPath());
    assertEquals(result.toString(), model.toString());
  }

  /**
   * Test list acoustic models.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testListAcousticModels() throws InterruptedException, FileNotFoundException {
    String acousticModelsAsString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/acoustic-models.json"));
    JsonObject acousticModels = new JsonParser().parse(acousticModelsAsString).getAsJsonObject();

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(acousticModelsAsString));

    ListAcousticModelsOptions listOptions = new ListAcousticModelsOptions.Builder()
        .language("en-us")
        .build();
    AcousticModels result = service.listAcousticModels(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(PATH_ACOUSTIC_CUSTOMIZATIONS + "?language=en-us", request.getPath());
    assertEquals(acousticModels.get("customizations").getAsJsonArray().size(), result.getCustomizations().size());
    assertEquals(acousticModels.get("customizations"), GSON.toJsonTree(result.getCustomizations()));
  }

  /**
   * Test get acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testGetAcousticModel() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    AcousticModel model = loadFixture("src/test/resources/speech_to_text/acoustic-model.json", AcousticModel.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(model)));

    GetAcousticModelOptions getOptions = new GetAcousticModelOptions.Builder()
        .customizationId(id)
        .build();
    AcousticModel result = service.getAcousticModel(getOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_ACOUSTIC_CUSTOMIZATION, id), request.getPath());
    assertEquals(result.toString(), model.toString());
    assertEquals(UPDATED, result.getUpdated());
  }

  /**
   * Test delete acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteAcousticModel() throws InterruptedException {
    String id = "foo";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    DeleteAcousticModelOptions deleteOptions = new DeleteAcousticModelOptions.Builder()
        .customizationId(id)
        .build();
    service.deleteAcousticModel(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_ACOUSTIC_CUSTOMIZATION, id), request.getPath());
  }

  /**
   * Test train acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testTrainAcousticModel() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";
    String languageModelId = "bar";

    TrainAcousticModelOptions trainOptions = new TrainAcousticModelOptions.Builder()
        .customizationId(id)
        .customLanguageModelId(languageModelId)
        .build();
    service.trainAcousticModel(trainOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_ACOUSTIC_TRAIN, id) + "?custom_language_model_id=bar",
        request.getPath());
  }

  /**
   * Test reset acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testResetAcousticModel() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";

    ResetAcousticModelOptions resetOptions = new ResetAcousticModelOptions.Builder()
        .customizationId(id)
        .build();
    service.resetAcousticModel(resetOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_ACOUSTIC_RESET, id), request.getPath());
  }

  /**
   * Test upgrade acoustic model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpgradeAcousticModel() throws InterruptedException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";
    String languageModelId = "modelId";

    UpgradeAcousticModelOptions upgradeOptions = new UpgradeAcousticModelOptions.Builder()
        .customizationId(id)
        .customLanguageModelId(languageModelId)
        .force(true)
        .build();
    upgradeOptions = upgradeOptions.newBuilder().build();
    service.upgradeAcousticModel(upgradeOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_ACOUSTIC_UPGRADE, id)
            + "?custom_language_model_id="
            + languageModelId
            + "&force=true",
        request.getPath());
  }

  @Test
  public void testAddAudio() throws InterruptedException, FileNotFoundException {
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));
    String id = "foo";
    String audioName = "test_file";

    AddAudioOptions addOptions = new AddAudioOptions.Builder()
        .customizationId(id)
        .audioResource(SAMPLE_WAV)
        .contentType(AddAudioOptions.ContentType.AUDIO_WAV)
        .audioName(audioName)
        .allowOverwrite(true)
        .build();
    service.addAudio(addOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(String.format(PATH_SPECIFIC_AUDIO, id, audioName) + "?allow_overwrite=true",
        request.getPath());
  }

  @Test
  public void testListAudio() throws FileNotFoundException, InterruptedException {
    String resourcesAsString = getStringFromInputStream(new FileInputStream(
        "src/test/resources/speech_to_text/audio-resources.json"));
    JsonObject audioResources = new JsonParser().parse(resourcesAsString).getAsJsonObject();
    String id = "foo";

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(resourcesAsString));

    ListAudioOptions listOptions = new ListAudioOptions.Builder()
        .customizationId(id)
        .build();
    AudioResources result = service.listAudio(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_ALL_AUDIO, id), request.getPath());
    assertEquals(audioResources.get("audio").getAsJsonArray().size(), result.getAudio().size());
    assertEquals(audioResources.get("audio"), GSON.toJsonTree(result.getAudio()));
  }

  @Test
  public void testGetAudio() throws InterruptedException, FileNotFoundException {
    String id = "foo";
    String audioName = "audio1";
    AudioResource audio = loadFixture("src/test/resources/speech_to_text/audio-resource.json", AudioResource.class);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(audio)));

    GetAudioOptions getOptions = new GetAudioOptions.Builder()
        .customizationId(id)
        .audioName(audioName)
        .build();
    AudioListing result = service.getAudio(getOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(String.format(PATH_SPECIFIC_AUDIO, id, audioName), request.getPath());
    assertEquals(audio.getDetails(), result.getDetails());
    assertEquals(audio.getDuration(), result.getDuration());
    assertEquals(audio.getName(), result.getName());
    assertEquals(audio.getStatus(), result.getStatus());
  }

  @Test
  public void testDeleteAudio() throws InterruptedException {
    String id = "foo";
    String audioName = "audio1";

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    DeleteAudioOptions deleteOptions = new DeleteAudioOptions.Builder()
        .customizationId(id)
        .audioName(audioName)
        .build();
    service.deleteAudio(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
    assertEquals(String.format(PATH_SPECIFIC_AUDIO, id, audioName), request.getPath());
  }

  @Test
  public void testRegisterCallback() throws FileNotFoundException, InterruptedException {
    String callbackUrl = "http://testurl.com";
    String secret = "secret";
    RegisterStatus registerStatus = loadFixture("src/test/resources/speech_to_text/register-status.json",
        RegisterStatus.class);

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(registerStatus)));

    RegisterCallbackOptions registerOptions = new RegisterCallbackOptions.Builder()
        .callbackUrl(callbackUrl)
        .userSecret(secret)
        .build();
    RegisterStatus result = service.registerCallback(registerOptions).execute().getResult();
    final RecordedRequest registerRequest = server.takeRequest();

    assertEquals("POST", registerRequest.getMethod());
    assertEquals(String.format(REGISTER_CALLBACK, RequestUtils.encode(callbackUrl), RequestUtils.encode(secret)),
        registerRequest.getPath());
    assertEquals(RegisterStatus.Status.CREATED, result.getStatus());
    assertEquals(callbackUrl, result.getUrl());
  }

  @Test
  public void testUnregisterCallback() throws InterruptedException {
    String callbackUrl = "http://testurl.com";
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody("{}"));

    UnregisterCallbackOptions unregisterOptions = new UnregisterCallbackOptions.Builder()
        .callbackUrl(callbackUrl)
        .build();
    service.unregisterCallback(unregisterOptions).execute().getResult();
    final RecordedRequest unregisterRequest = server.takeRequest();

    assertEquals("POST", unregisterRequest.getMethod());
    assertEquals(String.format(UNREGISTER_CALLBACK, RequestUtils.encode(callbackUrl)), unregisterRequest.getPath());
  }

  @Test
  public void testClosingInputStreamClosesWebSocket() throws Exception {
    TestRecognizeCallback callback = new TestRecognizeCallback();
    WebSocketRecorder webSocketRecorder = new WebSocketRecorder("server");
    PipedOutputStream outputStream = new PipedOutputStream();
    InputStream inputStream = new PipedInputStream(outputStream);

    server.enqueue(new MockResponse().withWebSocketUpgrade(webSocketRecorder));

    String customizationId = "id";
    String version = "version";
    Double customizationWeight = 0.1;
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(inputStream)
        .contentType(HttpMediaType.createAudioRaw(44000))
        .customizationId(customizationId)
        .baseModelVersion(version)
        .customizationWeight(customizationWeight)
        .build();
    service.recognizeUsingWebSocket(options, callback);

    WebSocket serverSocket = webSocketRecorder.assertOpen();
    serverSocket.send("{\"state\": {}}");

    outputStream.write(ByteString.encodeUtf8("test").toByteArray());
    outputStream.close();

    webSocketRecorder.assertTextMessage("{\"content-type\":\"audio/l16; rate=44000\"," +
        "\"customization_weight\":0.1,\"action\":\"start\"}");
    webSocketRecorder.assertBinaryMessage(ByteString.encodeUtf8("test"));
    webSocketRecorder.assertTextMessage("{\"action\":\"stop\"}");
    webSocketRecorder.assertExhausted();

    serverSocket.close(1000, null);

    callback.assertConnected();
    callback.assertDisconnected();
    callback.assertNoErrors();
    callback.assertOnTranscriptionComplete();
  }

  @Test
  public void testAddGrammar() throws FileNotFoundException, InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    String customizationId = "id";
    String grammarName = "grammar_name";
    InputStream grammarFile = new FileInputStream(SAMPLE_WAV);

    AddGrammarOptions addGrammarOptions = new AddGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .grammarFile(grammarFile)
        .contentType(AddGrammarOptions.ContentType.APPLICATION_SRGS)
        .build();
    service.addGrammar(addGrammarOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(POST, request.getMethod());
  }

  @Test
  public void testListGrammars() throws InterruptedException {
    server.enqueue(jsonResponse(grammars));

    String customizationId = "id";

    ListGrammarsOptions listGrammarsOptions = new ListGrammarsOptions.Builder()
        .customizationId(customizationId)
        .build();
    Grammars response = service.listGrammars(listGrammarsOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(grammars, response);
  }

  @Test
  public void testGetGrammar() throws InterruptedException {
    server.enqueue(jsonResponse(grammar));

    String customizationId = "id";
    String grammarName = "grammar_name";

    GetGrammarOptions getGrammarOptions = new GetGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();
    Grammar response = service.getGrammar(getGrammarOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(grammar, response);
  }

  @Test
  public void testDeleteGrammar() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    String customizationId = "id";
    String grammarName = "grammar_name";

    DeleteGrammarOptions deleteGrammarOptions = new DeleteGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();
    service.deleteGrammar(deleteGrammarOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE, request.getMethod());
  }

  // --- HELPERS ---

  private static class TestRecognizeCallback implements RecognizeCallback {

    private final BlockingQueue<SpeechRecognitionResults> speechResults = new LinkedBlockingQueue<>();

    private final BlockingQueue<Exception> errors = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onDisconnectedCalls = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onConnectedCalls = new LinkedBlockingQueue<>();

    private final BlockingQueue<Object> onTranscriptionCompleteCalls = new LinkedBlockingQueue<>();

    @Override
    public void onTranscription(SpeechRecognitionResults speechResults) {
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

    private void assertOnTranscriptionComplete() {
      if (this.onTranscriptionCompleteCalls.size() == 1) {
        throw new AssertionError("There were " + this.errors.size() + " calls to onTranscriptionComplete");
      }
    }

    private void assertConnected() {
      try {
        Object connectedEvent = this.onConnectedCalls.poll(10, TimeUnit.SECONDS);
        if (connectedEvent == null) {
          throw new AssertionError("Timed out waiting for connect.");
        }
      } catch (InterruptedException e) {
        throw new AssertionError(e);
      }
    }

    private void assertDisconnected() {
      try {
        Object disconnectedEvent = this.onDisconnectedCalls.poll(10, TimeUnit.SECONDS);
        if (disconnectedEvent == null) {
          throw new AssertionError("Timed out waiting for disconnect.");
        }
      } catch (InterruptedException e) {
        throw new AssertionError(e);
      }
    }

    private void assertNoErrors() {
      if (this.errors.size() > 0) {
        throw new AssertionError("There were " + this.errors.size() + " errors");
      }
    }

    @Override
    public void onInactivityTimeout(RuntimeException runtimeException) {
    }

    @Override
    public void onListening() {
    }

    @Override
    public void onTranscriptionComplete() {
      this.onTranscriptionCompleteCalls.add(new Object());

    }
  }
}
