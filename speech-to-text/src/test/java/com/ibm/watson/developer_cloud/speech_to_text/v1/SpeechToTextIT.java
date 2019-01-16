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

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AcousticModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AcousticModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddGrammarOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AudioListing;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.AudioResources;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CheckJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpora;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus.Status;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.CreateLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteGrammarOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteJobOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.DeleteUserDataOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetAcousticModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetCorpusOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetGrammarOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetLanguageModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetModelOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.GetWordOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Grammar;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Grammars;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.KeywordResult;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.LanguageModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.LanguageModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListAudioOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListCorporaOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListGrammarsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.ListWordsOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJob;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognitionJobs;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModels;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResult;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.WordAlternativeResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Words;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Speech to text Integration tests.
 */
@RunWith(RetryRunner.class)
public class SpeechToTextIT extends WatsonServiceTest {

  private static final String EN_BROADBAND16K = "en-US_BroadbandModel";
  private static final String SPEECH_RESOURCE = "src/test/resources/speech_to_text/%s";
  private static final String SAMPLE_WAV = String.format(SPEECH_RESOURCE, "sample1.wav");
  private static final String TWO_SPEAKERS_WAV = String.format(SPEECH_RESOURCE, "twospeakers.wav");
  private static final String SAMPLE_WAV_WITH_PAUSE = String.format(SPEECH_RESOURCE, "sound-with-pause.wav");
  private static final String WAV_ARCHIVE = String.format(SPEECH_RESOURCE, "sample-wav-archive.zip");
  private static final String SAMPLE_GRAMMAR = String.format(SPEECH_RESOURCE, "confirm.abnf");
  private static final Logger LOG = Logger.getLogger(SpeechToTextIT.class.getName());

  private CountDownLatch lock = new CountDownLatch(1);
  private SpeechToText service;
  private SpeechRecognitionResults asyncResults;
  private Boolean inactivityTimeoutOccurred;
  private String customizationId;
  private String acousticCustomizationId;

  /** The expected exception. */
  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    this.customizationId = getProperty("speech_to_text.customization_id");
    this.acousticCustomizationId = getProperty("speech_to_text.acoustic_customization_id");

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
   * Test get model.
   */
  @Test
  public void testGetModel() {
    GetModelOptions getOptions = new GetModelOptions.Builder()
        .modelId(EN_BROADBAND16K)
        .build();
    SpeechModel model = service.getModel(getOptions).execute();
    assertNotNull(model);
    assertNotNull(model.getName());
    assertNotNull(model.getLanguage());
    assertNotNull(model.getRate());
    assertNotNull(model.getUrl());
    assertNotNull(model.getDescription());
    assertNotNull(model.getSupportedFeatures().isCustomLanguageModel());
    assertNotNull(model.getSupportedFeatures().isSpeakerLabels());
  }

  /**
   * Test list models.
   */
  @Test
  public void testListModels() {
    SpeechModels models = service.listModels().execute();
    assertNotNull(models);
    assertTrue(!models.getModels().isEmpty());
  }

  /**
   * Test recognize audio file.
   */
  @Test
  public void testRecognizeFileString() throws FileNotFoundException {
    Long maxAlternatives = 3L;
    Float wordAlternativesThreshold = 0.8f;
    File audio = new File(SAMPLE_WAV);
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
        .maxAlternatives(maxAlternatives)
        .wordAlternativesThreshold(wordAlternativesThreshold)
        .smartFormatting(true)
        .build();
    SpeechRecognitionResults results = service.recognize(options).execute();

    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
    assertTrue(results.getResults().get(0).getAlternatives().size() <= maxAlternatives);
    List<WordAlternativeResults> wordAlternatives = results.getResults().get(0).getWordAlternatives();
    for (WordAlternativeResults alternativeResults : wordAlternatives) {
      assertTrue(alternativeResults.getAlternatives().get(0).getConfidence() >= wordAlternativesThreshold);
    }
  }

  /**
   * Test recognize multiple speakers.
   */
  @Test
  public void testRecognizeMultipleSpeakers() throws FileNotFoundException {
    File audio = new File(TWO_SPEAKERS_WAV);
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .speakerLabels(true)
        .model(RecognizeOptions.Model.EN_US_NARROWBANDMODEL)
        .contentType(HttpMediaType.AUDIO_WAV)
        .build();

    SpeechRecognitionResults results = service.recognize(options).execute();
    assertNotNull(results.getSpeakerLabels());
    assertTrue(results.getSpeakerLabels().size() > 0);
  }

  /**
   * Test recognize file string recognize options.
   */
  @Test
  public void testRecognizeFileStringRecognizeOptions() throws FileNotFoundException {
    File audio = new File(SAMPLE_WAV);
    String contentType = HttpMediaType.AUDIO_WAV;
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .timestamps(true)
        .wordConfidence(true)
        .model(EN_BROADBAND16K)
        .contentType(contentType)
        .profanityFilter(false)
        .build();
    SpeechRecognitionResults results = service.recognize(options).execute();
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTranscript());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getTimestamps());
    assertNotNull(results.getResults().get(0).getAlternatives().get(0).getWordConfidence());
  }

  /**
   * Test keyword recognition.
   */
  @Test
  public void testRecognizeKeywords() throws FileNotFoundException {
    final String keyword1 = "rain";
    final String keyword2 = "tornadoes";
    final File audio = new File(SAMPLE_WAV);

    final RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .contentType(HttpMediaType.AUDIO_WAV)
        .model(RecognizeOptions.Model.EN_US_NARROWBANDMODEL)
        .inactivityTimeout(500)
        .keywords(Arrays.asList(keyword1, keyword2))
        .keywordsThreshold(0.5f)
        .build();

    final SpeechRecognitionResults results = service.recognize(options).execute();
    final SpeechRecognitionResult transcript = results.getResults().get(0);

    assertEquals(2, transcript.getKeywordsResult().size());
    assertTrue(transcript.getKeywordsResult().containsKey(keyword1));
    assertTrue(transcript.getKeywordsResult().containsKey(keyword2));

    final KeywordResult result1 = transcript.getKeywordsResult().get(keyword1).get(0);
    assertEquals(keyword1, result1.getNormalizedText());
    assertEquals(0.9, result1.getConfidence(), 0.1);
    assertEquals(5.58, result1.getStartTime(), 1.0);
    assertEquals(6.14, result1.getEndTime(), 1.0);

    final KeywordResult result2 = transcript.getKeywordsResult().get(keyword2).get(0);
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
    FileInputStream audio = new FileInputStream(SAMPLE_WAV);
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .inactivityTimeout(40)
        .timestamps(true)
        .maxAlternatives(2)
        .wordAlternativesThreshold(0.5f)
        .model(EN_BROADBAND16K)
        .contentType(HttpMediaType.AUDIO_WAV)
        .interimResults(true)
        .build();

    service.recognizeUsingWebSocket(options, new BaseRecognizeCallback() {

      @Override
      public void onConnected() {
        LOG.info("onConnected()");
      }

      @Override
      public void onDisconnected() {
        LOG.info("onDisconnected()");
      }

      @Override
      public void onTranscriptionComplete() {
        LOG.info("onTranscriptionComplete()");
        lock.countDown();
      }

      @Override
      public void onError(Exception e) {
        e.printStackTrace();
        lock.countDown();
      }

      @Override
      public void onTranscription(SpeechRecognitionResults speechResults) {
        if (speechResults != null && speechResults.getResults().get(0).isFinalResults()) {
          asyncResults = speechResults;
        }
      }

    });

    lock.await(2, TimeUnit.MINUTES);
    assertNotNull(asyncResults);

    List<WordAlternativeResults> wordAlternatives = asyncResults.getResults().get(asyncResults.getResultIndex()
        .intValue()).getWordAlternatives();
    assertTrue(wordAlternatives != null && !wordAlternatives.isEmpty());
    assertNotNull(wordAlternatives.get(0).getAlternatives());
  }

  /**
   * Test the inactivity timeout parameter for WebSockets.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testInactivityTimeoutWithWebSocket() throws FileNotFoundException, InterruptedException {
    FileInputStream audio = new FileInputStream(SAMPLE_WAV_WITH_PAUSE);
    RecognizeOptions options = new RecognizeOptions.Builder()
        .audio(audio)
        .inactivityTimeout(3)
        .timestamps(true)
        .maxAlternatives(2)
        .wordAlternativesThreshold(0.5f)
        .model(EN_BROADBAND16K)
        .contentType(HttpMediaType.AUDIO_WAV)
        .build();

    service.recognizeUsingWebSocket(options, new BaseRecognizeCallback() {

      @Override
      public void onDisconnected() {
        lock.countDown();
      }

      @Override
      public void onError(Exception e) {
        e.printStackTrace();
        lock.countDown();
      }

      @Override
      public void onInactivityTimeout(RuntimeException runtimeException) {
        inactivityTimeoutOccurred = true;
      }
    });

    lock.await(2, TimeUnit.MINUTES);
    assertTrue(inactivityTimeoutOccurred);
  }

  /**
   * Test create job.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateJob() throws InterruptedException, FileNotFoundException {
    File audio = new File(SAMPLE_WAV);
    Long maxAlternatives = 3L;
    Float wordAlternativesThreshold = 0.5f;
    CreateJobOptions createOptions = new CreateJobOptions.Builder()
        .audio(audio)
        .contentType(CreateJobOptions.ContentType.AUDIO_WAV)
        .maxAlternatives(maxAlternatives)
        .wordAlternativesThreshold(wordAlternativesThreshold)
        .build();
    RecognitionJob job = service.createJob(createOptions).execute();
    try {
      assertNotNull(job.getId());
      CheckJobOptions checkOptions = new CheckJobOptions.Builder()
          .id(job.getId())
          .build();
      for (int x = 0; x < 30 && !job.getStatus().equals(RecognitionJob.Status.COMPLETED); x++) {
        Thread.sleep(3000);
        job = service.checkJob(checkOptions).execute();
      }
      job = service.checkJob(checkOptions).execute();
      assertEquals(RecognitionJob.Status.COMPLETED, job.getStatus());

      assertNotNull(job.getResults());
      assertTrue(job.getResults().get(0).getResults().get(0).getAlternatives().size() <= maxAlternatives);
      List<WordAlternativeResults> wordAlternatives = job.getResults().get(0).getResults().get(0).getWordAlternatives();
      for (WordAlternativeResults alternativeResults : wordAlternatives) {
        assertTrue(alternativeResults.getAlternatives().get(0).getConfidence() >= wordAlternativesThreshold);
      }

    } finally {
      DeleteJobOptions deleteOptions = new DeleteJobOptions.Builder()
          .id(job.getId())
          .build();
      service.deleteJob(deleteOptions).execute();
    }
  }

  /**
   * Test create job with a warning message.
   *
   * This test is currently being ignored as it has a very long runtime and causes Travis to timeout.
   * The ignore annotation can be removed to test this locally.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Ignore
  @Test
  public void testCreateJobWarning() throws InterruptedException, FileNotFoundException {
    File audio = new File(SAMPLE_WAV);
    CreateJobOptions createOptions = new CreateJobOptions.Builder()
        .audio(audio)
        .contentType(CreateJobOptions.ContentType.AUDIO_WAV)
        .userToken("job")
        .build();
    RecognitionJob job = service.createJob(createOptions).execute();
    try {
      assertNotNull(job.getId());
      assertNotNull(job.getWarnings());
      CheckJobOptions checkOptions = new CheckJobOptions.Builder()
          .id(job.getId())
          .build();
      for (int x = 0; x < 30 && job.getStatus() != RecognitionJob.Status.COMPLETED; x++) {
        Thread.sleep(3000);
        job = service.checkJob(checkOptions).execute();
      }
      job = service.checkJob(checkOptions).execute();
      assertEquals(RecognitionJob.Status.COMPLETED, job.getStatus());
      assertNotNull(job.getResults());
    } finally {
      DeleteJobOptions deleteOptions = new DeleteJobOptions.Builder()
          .id(job.getId())
          .build();
      service.deleteJob(deleteOptions).execute();
    }
  }

  /**
   * Test check job with wrong id.
   *
   */
  @Test
  public void testCheckJobWithWrongId() {
    expectedException.expect(NotFoundException.class);
    expectedException.expectMessage("job not found");
    CheckJobOptions checkOptions = new CheckJobOptions.Builder()
        .id("foo")
        .build();
    service.checkJob(checkOptions).execute();
  }

  /**
   * Test check jobs.
   *
   * Ignoring while the endpoint is broken.
   */
  @Ignore
  @Test
  public void testCheckJobs() {
    RecognitionJobs jobs = service.checkJobs().execute();
    assertNotNull(jobs);
  }

  /**
   * Test list language models.
   */
  @Test
  public void testListLanguageModels() {
    LanguageModels models = service.listLanguageModels().execute();
    assertNotNull(models);
    assertTrue(!models.getCustomizations().isEmpty());
  }

  /**
   * Test list corpora.
   *
   */
  @Test
  @Ignore
  public void testListCorpora() {
    ListCorporaOptions listOptions = new ListCorporaOptions.Builder()
        .customizationId(customizationId)
        .build();
    Corpora result = service.listCorpora(listOptions).execute();
    assertNotNull(result);
  }

  /**
   * Test get corpus.
   *
   */
  @Test
  @Ignore
  public void testGetCorpus() {
    GetCorpusOptions getOptions = new GetCorpusOptions.Builder()
        .corpusName("foo3")
        .customizationId(customizationId)
        .build();
    Corpus result = service.getCorpus(getOptions).execute();
    assertNotNull(result);
  }

  /**
   * Test add corpus with expected failure.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddCorpusFail() {
    AddCorpusOptions addOptions = new AddCorpusOptions.Builder()
        .corpusName("foo3")
        .customizationId(customizationId)
        .build();
    service.addCorpus(addOptions).execute();
  }

  /**
   * Test list words with just a customization ID.
   */
  @Test
  @Ignore
  public void testListWordsCustomizationId() {
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customizationId)
        .build();
    Words result = service.listWords(listOptions).execute();
    assertNotNull(result);
    assertTrue(!result.getWords().isEmpty());
  }

  /**
   * Test list words with a customization ID and word type.
   */
  @Test
  @Ignore
  public void testListWordsIdAndType() {
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customizationId)
        .wordType(ListWordsOptions.WordType.CORPORA)
        .build();
    Words result = service.listWords(listOptions).execute();
    assertNotNull(result);
    assertTrue(!result.getWords().isEmpty());
  }

  /**
   * Test list words with type all.
   */
  @Test
  @Ignore
  public void testListWordsTypeAll() {
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customizationId)
        .wordType(ListWordsOptions.WordType.ALL)
        .build();
    Words result = service.listWords(listOptions).execute();
    assertNotNull(result);
    assertTrue(!result.getWords().isEmpty());
  }

  /**
   * Test list words with alphabetical sort.
   */
  @Test
  @Ignore
  public void testGetWordsThreeSort() {
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customizationId)
        .sort(ListWordsOptions.Sort.ALPHABETICAL)
        .build();
    Words result = service.listWords(listOptions).execute();
    assertNotNull(result);
    assertTrue(!result.getWords().isEmpty());
  }

  /**
   * Test list words with type all and count sort.
   */
  @Test
  @Ignore
  public void testGetWordsThreeTypeSort() {
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customizationId)
        .wordType(ListWordsOptions.WordType.ALL)
        .sort(ListWordsOptions.Sort.COUNT)
        .build();
    Words result = service.listWords(listOptions).execute();
    assertNotNull(result);
    assertTrue(!result.getWords().isEmpty());
  }

  /**
   * Test get word.
   */
  public void testGetWord() {
    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(customizationId)
        .wordName("string")
        .build();
    Word result = service.getWord(getOptions).execute();
    assertNotNull(result);
  }

  /**
   * Test create language model.
   *
   * Takes a long time to the point of timing out on Travis sometimes, so we'll just run locally.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  @Ignore
  public void testCreateLanguageModel() throws InterruptedException, FileNotFoundException {
    CreateLanguageModelOptions createOptions = new CreateLanguageModelOptions.Builder()
        .name("java-sdk-temporary")
        .baseModelName(EN_BROADBAND16K)
        .description("Temporary custom model for testing the Java SDK")
        .build();
    LanguageModel myModel = service.createLanguageModel(createOptions).execute();
    String id = myModel.getCustomizationId();

    try {
      // Add a corpus file to the model
      AddCorpusOptions addOptions = new AddCorpusOptions.Builder()
          .customizationId(id)
          .corpusName("corpus-1")
          .corpusFile(new File(String.format(SPEECH_RESOURCE, "corpus1.txt")))
          .allowOverwrite(false)
          .build();
      service.addCorpus(addOptions).execute();

      // Get corpus status
      GetCorpusOptions getOptions = new GetCorpusOptions.Builder()
          .customizationId(id)
          .corpusName("corpus-1")
          .build();
      for (int x = 0; x < 30 && !service.getCorpus(getOptions).execute().getStatus().equals(Status.ANALYZED); x++) {
        Thread.sleep(5000);
      }

      assertTrue(service.getCorpus(getOptions).execute().getStatus().equals(Status.ANALYZED));

      // Add the corpus file to the model again and allow overwrite
      AddCorpusOptions addOptionsWithOverwrite = new AddCorpusOptions.Builder()
          .customizationId(id)
          .corpusName("corpus-1")
          .corpusFile(new File(String.format(SPEECH_RESOURCE, "corpus1.txt")))
          .allowOverwrite(true)
          .build();
      service.addCorpus(addOptionsWithOverwrite).execute();

      // Get corpus status
      for (int x = 0; x < 30 && !service.getCorpus(getOptions).execute().getStatus().equals(Status.ANALYZED); x++) {
        Thread.sleep(5000);
      }

      assertTrue(service.getCorpus(getOptions).execute().getStatus().equals(Status.ANALYZED));

      // Get corpora
      ListCorporaOptions listCorporaOptions = new ListCorporaOptions.Builder()
          .customizationId(id)
          .build();
      Corpora corpora = service.listCorpora(listCorporaOptions).execute();

      assertNotNull(corpora);
      assertTrue(corpora.getCorpora().size() == 1);

      // Now add some user words to the custom model
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("IEEE")
          .word("IEEE")
          .displayAs("IEEE")
          .addSoundsLike("I. triple E.")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("hhonors")
          .word("hhonors")
          .displayAs("IEEE")
          .addSoundsLike("H. honors")
          .addSoundsLike("Hilton honors")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("aaa")
          .word("aaa")
          .displayAs("aaa")
          .addSoundsLike("aaa")
          .addSoundsLike("bbb")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("bbb")
          .word("bbb")
          .addSoundsLike("aaa")
          .addSoundsLike("bbb")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("ccc")
          .word("ccc")
          .displayAs("ccc")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("ddd")
          .word("ddd")
          .build()).execute();
      service.addWord(new AddWordOptions.Builder()
          .customizationId(id)
          .wordName("eee")
          .word("eee")
          .build()).execute();

      // Display all words in the words resource (coming from OOVs from the corpus add and the new words just added)
      ListWordsOptions listWordsOptions = new ListWordsOptions.Builder()
          .customizationId(id)
          .wordType(ListWordsOptions.WordType.ALL)
          .build();
      Words words = service.listWords(listWordsOptions).execute();
      assertNotNull(words);

    } finally {
      DeleteLanguageModelOptions deleteOptions = new DeleteLanguageModelOptions.Builder()
          .customizationId(id)
          .build();
      service.deleteLanguageModel(deleteOptions).execute();
    }
  }

  /**
   * Test create acoustic model.
   */
  @Test
  public void testCreateAcousticModel() {
    String name = "java-sdk-temporary";
    String description = "Temporary custom model for testing the Java SDK";
    CreateAcousticModelOptions createOptions = new CreateAcousticModelOptions.Builder()
        .name(name)
        .baseModelName(EN_BROADBAND16K)
        .description(description)
        .build();
    AcousticModel myModel = service.createAcousticModel(createOptions).execute();
    String id = myModel.getCustomizationId();

    try {
      GetAcousticModelOptions getOptions = new GetAcousticModelOptions.Builder()
          .customizationId(id)
          .build();
      AcousticModel model = service.getAcousticModel(getOptions).execute();

      assertNotNull(model);
      assertEquals(name, model.getName());
      assertEquals(EN_BROADBAND16K, model.getBaseModelName());
      assertEquals(description, model.getDescription());
    } finally {
      DeleteAcousticModelOptions deleteOptions = new DeleteAcousticModelOptions.Builder()
          .customizationId(id)
          .build();
      service.deleteAcousticModel(deleteOptions).execute();
    }
  }

  /**
   * Test list acoustic models.
   */
  @Test
  public void testListAcousticModels() {
    AcousticModels models = service.listAcousticModels().execute();
    assertNotNull(models);
  }

  /**
   * Test get audio.
   *
   * This test is currently being ignored as it has a very long runtime and causes Travis to timeout.
   * The ignore annotation can be removed to test this locally.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Ignore
  @Test
  public void testGetAudio() throws InterruptedException, FileNotFoundException {
    String audioName = "sample";
    AddAudioOptions addOptions = new AddAudioOptions.Builder()
        .audioResource(new File(SAMPLE_WAV))
        .contentType(AddAudioOptions.ContentType.AUDIO_WAV)
        .audioName(audioName)
        .customizationId(acousticCustomizationId)
        .allowOverwrite(true)
        .build();
    service.addAudio(addOptions).execute();

    try {
      GetAudioOptions getOptions = new GetAudioOptions.Builder()
          .customizationId(acousticCustomizationId)
          .audioName(audioName)
          .build();
      AudioListing audio = service.getAudio(getOptions).execute();

      assertNotNull(audio);
      assertEquals(audioName, audio.getName());
    } finally {
      DeleteAudioOptions deleteAudioOptions = new DeleteAudioOptions.Builder()
          .customizationId(acousticCustomizationId)
          .audioName(audioName)
          .build();
      service.deleteAudio(deleteAudioOptions).execute();
    }
  }

  /**
   * Test list audio.
   */
  @Test
  public void testListAudio() {
    ListAudioOptions listOptions = new ListAudioOptions.Builder()
        .customizationId(acousticCustomizationId)
        .build();
    AudioResources resources = service.listAudio(listOptions).execute();

    assertNotNull(resources);
  }

  /**
   * Test add audio with an archive file.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testAddAudioArchive() throws FileNotFoundException, InterruptedException {
    String audioName = "test-archive";
    File audio = new File(WAV_ARCHIVE);
    Thread.sleep(5000);
    AddAudioOptions addOptions = new AddAudioOptions.Builder()
        .customizationId(acousticCustomizationId)
        .audioName(audioName)
        .contentType(AddAudioOptions.ContentType.APPLICATION_ZIP)
        .containedContentType(AddAudioOptions.ContainedContentType.AUDIO_WAV)
        .audioResource(audio)
        .allowOverwrite(true)
        .build();
    service.addAudio(addOptions).execute();

    try {
      GetAudioOptions getOptions = new GetAudioOptions.Builder()
          .customizationId(acousticCustomizationId)
          .audioName(audioName)
          .build();
      AudioListing listing = service.getAudio(getOptions).execute();

      assertNotNull(listing);
      assertEquals(audioName, listing.getContainer().getName());
    } finally {
      DeleteAudioOptions deleteAudioOptions = new DeleteAudioOptions.Builder()
          .customizationId(acousticCustomizationId)
          .audioName(audioName)
          .build();
      service.deleteAudio(deleteAudioOptions).execute();
    }
  }

  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
          .customerId(customerId)
          .build();
      service.deleteUserData(deleteOptions);
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  @Test
  public void testGrammarOperations() throws FileNotFoundException, InterruptedException {
    while (!isCustomizationReady(customizationId)) {
      Thread.sleep(5000);
    }

    String grammarName = "java-sdk-test-grammar";

    AddGrammarOptions addGrammarOptions = new AddGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarFile(new FileInputStream(SAMPLE_GRAMMAR))
        .grammarName(grammarName)
        .contentType(AddGrammarOptions.ContentType.APPLICATION_SRGS)
        .allowOverwrite(true)
        .build();
    service.addGrammar(addGrammarOptions).execute();

    ListGrammarsOptions listGrammarsOptions = new ListGrammarsOptions.Builder()
        .customizationId(customizationId)
        .build();
    Grammars listGrammarsResponse = service.listGrammars(listGrammarsOptions).execute();
    assertNotNull(listGrammarsResponse);
    boolean found = false;
    for (Grammar g : listGrammarsResponse.getGrammars()) {
      if (g.getName().equals(grammarName)) {
        found = true;
        break;
      }
    }
    assertTrue(found);

    GetGrammarOptions getGrammarOptions = new GetGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();
    Grammar getGrammarResponse = service.getGrammar(getGrammarOptions).execute();
    assertNotNull(getGrammarResponse);
    assertEquals(grammarName, getGrammarResponse.getName());

    while (!isCustomizationReady(customizationId)) {
      Thread.sleep(5000);
    }

    DeleteGrammarOptions deleteGrammarOptions = new DeleteGrammarOptions.Builder()
        .customizationId(customizationId)
        .grammarName(grammarName)
        .build();
    service.deleteGrammar(deleteGrammarOptions).execute();
  }

  private boolean isCustomizationReady(String customizationId) {
    GetLanguageModelOptions getLanguageModelOptions = new GetLanguageModelOptions.Builder()
        .customizationId(customizationId)
        .build();
    LanguageModel model = service.getLanguageModel(getLanguageModelOptions).execute();
    return model.getStatus().equals(LanguageModel.Status.READY)
        || model.getStatus().equals(LanguageModel.Status.AVAILABLE);
  }
}
