/*
 * (C) Copyright IBM Corp. 2024.
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

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.watson.speech_to_text.v1.model.AcousticModel;
import com.ibm.watson.speech_to_text.v1.model.AcousticModels;
import com.ibm.watson.speech_to_text.v1.model.AddAudioOptions;
import com.ibm.watson.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.AddGrammarOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.AudioListing;
import com.ibm.watson.speech_to_text.v1.model.AudioResources;
import com.ibm.watson.speech_to_text.v1.model.CheckJobOptions;
import com.ibm.watson.speech_to_text.v1.model.CheckJobsOptions;
import com.ibm.watson.speech_to_text.v1.model.Corpora;
import com.ibm.watson.speech_to_text.v1.model.Corpus;
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
import com.ibm.watson.speech_to_text.v1.model.ListModelsOptions;
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
import com.ibm.watson.speech_to_text.v1.model.TrainingResponse;
import com.ibm.watson.speech_to_text.v1.model.UnregisterCallbackOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeAcousticModelOptions;
import com.ibm.watson.speech_to_text.v1.model.UpgradeLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.Word;
import com.ibm.watson.speech_to_text.v1.model.Words;
import com.ibm.watson.speech_to_text.v1.utils.TestUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Unit test class for the SpeechToText service. */
public class SpeechToTextTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected SpeechToText speechToTextService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new SpeechToText(serviceName, null);
  }

  // Test the listModels operation with a valid options model parameter
  @Test
  public void testListModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"name\": \"name\", \"language\": \"language\", \"rate\": 4, \"url\": \"url\", \"supported_features\": {\"custom_language_model\": false, \"custom_acoustic_model\": false, \"speaker_labels\": false, \"low_latency\": true}, \"description\": \"description\"}]}";
    String listModelsPath = "/v1/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel = new ListModelsOptions();

    // Invoke listModels() with a valid options model and verify the result
    Response<SpeechModels> response =
        speechToTextService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    SpeechModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listModelsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listModels operation with and without retries enabled
  @Test
  public void testListModelsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListModelsWOptions();

    speechToTextService.disableRetries();
    testListModelsWOptions();
  }

  // Test the getModel operation with a valid options model parameter
  @Test
  public void testGetModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"language\": \"language\", \"rate\": 4, \"url\": \"url\", \"supported_features\": {\"custom_language_model\": false, \"custom_acoustic_model\": false, \"speaker_labels\": false, \"low_latency\": true}, \"description\": \"description\"}";
    String getModelPath = "/v1/models/ar-MS_BroadbandModel";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetModelOptions model
    GetModelOptions getModelOptionsModel =
        new GetModelOptions.Builder().modelId("ar-MS_BroadbandModel").build();

    // Invoke getModel() with a valid options model and verify the result
    Response<SpeechModel> response = speechToTextService.getModel(getModelOptionsModel).execute();
    assertNotNull(response);
    SpeechModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getModel operation with and without retries enabled
  @Test
  public void testGetModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetModelWOptions();

    speechToTextService.disableRetries();
    testGetModelWOptions();
  }

  // Test the getModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getModel(null).execute();
  }

  // Test the recognize operation with a valid options model parameter
  @Test
  public void testRecognizeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [[\"timestamps\"]], \"word_confidence\": [[\"wordConfidence\"]]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}";
    String recognizePath = "/v1/recognize";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RecognizeOptions model
    RecognizeOptions recognizeOptionsModel =
        new RecognizeOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("en-US_BroadbandModel")
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("30"))
            .keywords(java.util.Arrays.asList("testString"))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("1"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(false)
            .timestamps(false)
            .profanityFilter(true)
            .smartFormatting(false)
            .smartFormattingVersion(false)
            .speakerLabels(false)
            .grammarName("testString")
            .redaction(false)
            .audioMetrics(false)
            .endOfPhraseSilenceTime(Double.valueOf("0.8"))
            .splitTranscriptAtPhraseEnd(false)
            .speechDetectorSensitivity(Float.valueOf("0.5"))
            .backgroundAudioSuppression(Float.valueOf("0.0"))
            .lowLatency(false)
            .characterInsertionBias(Float.valueOf("0.0"))
            .build();

    // Invoke recognize() with a valid options model and verify the result
    Response<SpeechRecognitionResults> response =
        speechToTextService.recognize(recognizeOptionsModel).execute();
    assertNotNull(response);
    SpeechRecognitionResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, recognizePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("model"), "en-US_BroadbandModel");
    assertEquals(query.get("language_customization_id"), "testString");
    assertEquals(query.get("acoustic_customization_id"), "testString");
    assertEquals(query.get("base_model_version"), "testString");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    assertEquals(Long.valueOf(query.get("inactivity_timeout")), Long.valueOf("30"));
    assertEquals(
        query.get("keywords"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Float.valueOf(query.get("keywords_threshold")), Float.valueOf("36.0"));
    assertEquals(Long.valueOf(query.get("max_alternatives")), Long.valueOf("1"));
    assertEquals(Float.valueOf(query.get("word_alternatives_threshold")), Float.valueOf("36.0"));
    assertEquals(Boolean.valueOf(query.get("word_confidence")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("timestamps")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("profanity_filter")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("smart_formatting")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("smart_formatting_version")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("speaker_labels")), Boolean.valueOf(false));
    assertEquals(query.get("grammar_name"), "testString");
    assertEquals(Boolean.valueOf(query.get("redaction")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("audio_metrics")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("end_of_phrase_silence_time")), Double.valueOf("0.8"));
    assertEquals(
        Boolean.valueOf(query.get("split_transcript_at_phrase_end")), Boolean.valueOf(false));
    assertEquals(Float.valueOf(query.get("speech_detector_sensitivity")), Float.valueOf("0.5"));
    assertEquals(Float.valueOf(query.get("background_audio_suppression")), Float.valueOf("0.0"));
    assertEquals(Boolean.valueOf(query.get("low_latency")), Boolean.valueOf(false));
    assertEquals(Float.valueOf(query.get("character_insertion_bias")), Float.valueOf("0.0"));
  }

  // Test the recognize operation with and without retries enabled
  @Test
  public void testRecognizeWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testRecognizeWOptions();

    speechToTextService.disableRetries();
    testRecognizeWOptions();
  }

  // Test the recognize operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRecognizeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.recognize(null).execute();
  }

  // Test the registerCallback operation with a valid options model parameter
  @Test
  public void testRegisterCallbackWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"created\", \"url\": \"url\"}";
    String registerCallbackPath = "/v1/register_callback";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RegisterCallbackOptions model
    RegisterCallbackOptions registerCallbackOptionsModel =
        new RegisterCallbackOptions.Builder()
            .callbackUrl("testString")
            .userSecret("testString")
            .build();

    // Invoke registerCallback() with a valid options model and verify the result
    Response<RegisterStatus> response =
        speechToTextService.registerCallback(registerCallbackOptionsModel).execute();
    assertNotNull(response);
    RegisterStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, registerCallbackPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("callback_url"), "testString");
    assertEquals(query.get("user_secret"), "testString");
  }

  // Test the registerCallback operation with and without retries enabled
  @Test
  public void testRegisterCallbackWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testRegisterCallbackWOptions();

    speechToTextService.disableRetries();
    testRegisterCallbackWOptions();
  }

  // Test the registerCallback operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRegisterCallbackNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.registerCallback(null).execute();
  }

  // Test the unregisterCallback operation with a valid options model parameter
  @Test
  public void testUnregisterCallbackWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String unregisterCallbackPath = "/v1/unregister_callback";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the UnregisterCallbackOptions model
    UnregisterCallbackOptions unregisterCallbackOptionsModel =
        new UnregisterCallbackOptions.Builder().callbackUrl("testString").build();

    // Invoke unregisterCallback() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.unregisterCallback(unregisterCallbackOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unregisterCallbackPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("callback_url"), "testString");
  }

  // Test the unregisterCallback operation with and without retries enabled
  @Test
  public void testUnregisterCallbackWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testUnregisterCallbackWOptions();

    speechToTextService.disableRetries();
    testUnregisterCallbackWOptions();
  }

  // Test the unregisterCallback operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnregisterCallbackNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.unregisterCallback(null).execute();
  }

  // Test the createJob operation with a valid options model parameter
  @Test
  public void testCreateJobWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [[\"timestamps\"]], \"word_confidence\": [[\"wordConfidence\"]]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}";
    String createJobPath = "/v1/recognitions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateJobOptions model
    CreateJobOptions createJobOptionsModel =
        new CreateJobOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("en-US_BroadbandModel")
            .callbackUrl("testString")
            .events("recognitions.started")
            .userToken("testString")
            .resultsTtl(Long.valueOf("26"))
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("30"))
            .keywords(java.util.Arrays.asList("testString"))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("1"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(false)
            .timestamps(false)
            .profanityFilter(true)
            .smartFormatting(false)
            .smartFormattingVersion(false)
            .speakerLabels(false)
            .grammarName("testString")
            .redaction(false)
            .processingMetrics(false)
            .processingMetricsInterval(Float.valueOf("1.0"))
            .audioMetrics(false)
            .endOfPhraseSilenceTime(Double.valueOf("0.8"))
            .splitTranscriptAtPhraseEnd(false)
            .speechDetectorSensitivity(Float.valueOf("0.5"))
            .backgroundAudioSuppression(Float.valueOf("0.0"))
            .lowLatency(false)
            .characterInsertionBias(Float.valueOf("0.0"))
            .build();

    // Invoke createJob() with a valid options model and verify the result
    Response<RecognitionJob> response =
        speechToTextService.createJob(createJobOptionsModel).execute();
    assertNotNull(response);
    RecognitionJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createJobPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("model"), "en-US_BroadbandModel");
    assertEquals(query.get("callback_url"), "testString");
    assertEquals(query.get("events"), "recognitions.started");
    assertEquals(query.get("user_token"), "testString");
    assertEquals(Long.valueOf(query.get("results_ttl")), Long.valueOf("26"));
    assertEquals(query.get("language_customization_id"), "testString");
    assertEquals(query.get("acoustic_customization_id"), "testString");
    assertEquals(query.get("base_model_version"), "testString");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    assertEquals(Long.valueOf(query.get("inactivity_timeout")), Long.valueOf("30"));
    assertEquals(
        query.get("keywords"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Float.valueOf(query.get("keywords_threshold")), Float.valueOf("36.0"));
    assertEquals(Long.valueOf(query.get("max_alternatives")), Long.valueOf("1"));
    assertEquals(Float.valueOf(query.get("word_alternatives_threshold")), Float.valueOf("36.0"));
    assertEquals(Boolean.valueOf(query.get("word_confidence")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("timestamps")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("profanity_filter")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("smart_formatting")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("smart_formatting_version")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("speaker_labels")), Boolean.valueOf(false));
    assertEquals(query.get("grammar_name"), "testString");
    assertEquals(Boolean.valueOf(query.get("redaction")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("processing_metrics")), Boolean.valueOf(false));
    assertEquals(Float.valueOf(query.get("processing_metrics_interval")), Float.valueOf("1.0"));
    assertEquals(Boolean.valueOf(query.get("audio_metrics")), Boolean.valueOf(false));
    assertEquals(Double.valueOf(query.get("end_of_phrase_silence_time")), Double.valueOf("0.8"));
    assertEquals(
        Boolean.valueOf(query.get("split_transcript_at_phrase_end")), Boolean.valueOf(false));
    assertEquals(Float.valueOf(query.get("speech_detector_sensitivity")), Float.valueOf("0.5"));
    assertEquals(Float.valueOf(query.get("background_audio_suppression")), Float.valueOf("0.0"));
    assertEquals(Boolean.valueOf(query.get("low_latency")), Boolean.valueOf(false));
    assertEquals(Float.valueOf(query.get("character_insertion_bias")), Float.valueOf("0.0"));
  }

  // Test the createJob operation with and without retries enabled
  @Test
  public void testCreateJobWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testCreateJobWOptions();

    speechToTextService.disableRetries();
    testCreateJobWOptions();
  }

  // Test the createJob operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateJobNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.createJob(null).execute();
  }

  // Test the checkJobs operation with a valid options model parameter
  @Test
  public void testCheckJobsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"recognitions\": [{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [[\"timestamps\"]], \"word_confidence\": [[\"wordConfidence\"]]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}]}";
    String checkJobsPath = "/v1/recognitions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CheckJobsOptions model
    CheckJobsOptions checkJobsOptionsModel = new CheckJobsOptions();

    // Invoke checkJobs() with a valid options model and verify the result
    Response<RecognitionJobs> response =
        speechToTextService.checkJobs(checkJobsOptionsModel).execute();
    assertNotNull(response);
    RecognitionJobs responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkJobsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the checkJobs operation with and without retries enabled
  @Test
  public void testCheckJobsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testCheckJobsWOptions();

    speechToTextService.disableRetries();
    testCheckJobsWOptions();
  }

  // Test the checkJob operation with a valid options model parameter
  @Test
  public void testCheckJobWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [[\"timestamps\"]], \"word_confidence\": [[\"wordConfidence\"]]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}";
    String checkJobPath = "/v1/recognitions/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CheckJobOptions model
    CheckJobOptions checkJobOptionsModel = new CheckJobOptions.Builder().id("testString").build();

    // Invoke checkJob() with a valid options model and verify the result
    Response<RecognitionJob> response =
        speechToTextService.checkJob(checkJobOptionsModel).execute();
    assertNotNull(response);
    RecognitionJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkJobPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the checkJob operation with and without retries enabled
  @Test
  public void testCheckJobWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testCheckJobWOptions();

    speechToTextService.disableRetries();
    testCheckJobWOptions();
  }

  // Test the checkJob operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCheckJobNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.checkJob(null).execute();
  }

  // Test the deleteJob operation with a valid options model parameter
  @Test
  public void testDeleteJobWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteJobPath = "/v1/recognitions/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteJobOptions model
    DeleteJobOptions deleteJobOptionsModel =
        new DeleteJobOptions.Builder().id("testString").build();

    // Invoke deleteJob() with a valid options model and verify the result
    Response<Void> response = speechToTextService.deleteJob(deleteJobOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteJobPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteJob operation with and without retries enabled
  @Test
  public void testDeleteJobWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteJobWOptions();

    speechToTextService.disableRetries();
    testDeleteJobWOptions();
  }

  // Test the deleteJob operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteJobNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteJob(null).execute();
  }

  // Test the createLanguageModel operation with a valid options model parameter
  @Test
  public void testCreateLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}";
    String createLanguageModelPath = "/v1/customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateLanguageModelOptions model
    CreateLanguageModelOptions createLanguageModelOptionsModel =
        new CreateLanguageModelOptions.Builder()
            .name("testString")
            .baseModelName("ar-MS_Telephony")
            .dialect("testString")
            .description("testString")
            .build();

    // Invoke createLanguageModel() with a valid options model and verify the result
    Response<LanguageModel> response =
        speechToTextService.createLanguageModel(createLanguageModelOptionsModel).execute();
    assertNotNull(response);
    LanguageModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createLanguageModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createLanguageModel operation with and without retries enabled
  @Test
  public void testCreateLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testCreateLanguageModelWOptions();

    speechToTextService.disableRetries();
    testCreateLanguageModelWOptions();
  }

  // Test the createLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.createLanguageModel(null).execute();
  }

  // Test the listLanguageModels operation with a valid options model parameter
  @Test
  public void testListLanguageModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}]}";
    String listLanguageModelsPath = "/v1/customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListLanguageModelsOptions model
    ListLanguageModelsOptions listLanguageModelsOptionsModel =
        new ListLanguageModelsOptions.Builder().language("ar-MS").build();

    // Invoke listLanguageModels() with a valid options model and verify the result
    Response<LanguageModels> response =
        speechToTextService.listLanguageModels(listLanguageModelsOptionsModel).execute();
    assertNotNull(response);
    LanguageModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLanguageModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("language"), "ar-MS");
  }

  // Test the listLanguageModels operation with and without retries enabled
  @Test
  public void testListLanguageModelsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListLanguageModelsWOptions();

    speechToTextService.disableRetries();
    testListLanguageModelsWOptions();
  }

  // Test the getLanguageModel operation with a valid options model parameter
  @Test
  public void testGetLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}";
    String getLanguageModelPath = "/v1/customizations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetLanguageModelOptions model
    GetLanguageModelOptions getLanguageModelOptionsModel =
        new GetLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke getLanguageModel() with a valid options model and verify the result
    Response<LanguageModel> response =
        speechToTextService.getLanguageModel(getLanguageModelOptionsModel).execute();
    assertNotNull(response);
    LanguageModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLanguageModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getLanguageModel operation with and without retries enabled
  @Test
  public void testGetLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetLanguageModelWOptions();

    speechToTextService.disableRetries();
    testGetLanguageModelWOptions();
  }

  // Test the getLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getLanguageModel(null).execute();
  }

  // Test the deleteLanguageModel operation with a valid options model parameter
  @Test
  public void testDeleteLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteLanguageModelPath = "/v1/customizations/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteLanguageModelOptions model
    DeleteLanguageModelOptions deleteLanguageModelOptionsModel =
        new DeleteLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke deleteLanguageModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.deleteLanguageModel(deleteLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLanguageModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteLanguageModel operation with and without retries enabled
  @Test
  public void testDeleteLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteLanguageModelWOptions();

    speechToTextService.disableRetries();
    testDeleteLanguageModelWOptions();
  }

  // Test the deleteLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteLanguageModel(null).execute();
  }

  // Test the trainLanguageModel operation with a valid options model parameter
  @Test
  public void testTrainLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"warnings\": [{\"code\": \"invalid_audio_files\", \"message\": \"message\"}]}";
    String trainLanguageModelPath = "/v1/customizations/testString/train";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the TrainLanguageModelOptions model
    TrainLanguageModelOptions trainLanguageModelOptionsModel =
        new TrainLanguageModelOptions.Builder()
            .customizationId("testString")
            .wordTypeToAdd("all")
            .customizationWeight(Double.valueOf("72.5"))
            .strict(true)
            .force(false)
            .build();

    // Invoke trainLanguageModel() with a valid options model and verify the result
    Response<TrainingResponse> response =
        speechToTextService.trainLanguageModel(trainLanguageModelOptionsModel).execute();
    assertNotNull(response);
    TrainingResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, trainLanguageModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("word_type_to_add"), "all");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    assertEquals(Boolean.valueOf(query.get("strict")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(false));
  }

  // Test the trainLanguageModel operation with and without retries enabled
  @Test
  public void testTrainLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testTrainLanguageModelWOptions();

    speechToTextService.disableRetries();
    testTrainLanguageModelWOptions();
  }

  // Test the trainLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.trainLanguageModel(null).execute();
  }

  // Test the resetLanguageModel operation with a valid options model parameter
  @Test
  public void testResetLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String resetLanguageModelPath = "/v1/customizations/testString/reset";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the ResetLanguageModelOptions model
    ResetLanguageModelOptions resetLanguageModelOptionsModel =
        new ResetLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke resetLanguageModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.resetLanguageModel(resetLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resetLanguageModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the resetLanguageModel operation with and without retries enabled
  @Test
  public void testResetLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testResetLanguageModelWOptions();

    speechToTextService.disableRetries();
    testResetLanguageModelWOptions();
  }

  // Test the resetLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResetLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.resetLanguageModel(null).execute();
  }

  // Test the upgradeLanguageModel operation with a valid options model parameter
  @Test
  public void testUpgradeLanguageModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String upgradeLanguageModelPath = "/v1/customizations/testString/upgrade_model";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the UpgradeLanguageModelOptions model
    UpgradeLanguageModelOptions upgradeLanguageModelOptionsModel =
        new UpgradeLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke upgradeLanguageModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.upgradeLanguageModel(upgradeLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, upgradeLanguageModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the upgradeLanguageModel operation with and without retries enabled
  @Test
  public void testUpgradeLanguageModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testUpgradeLanguageModelWOptions();

    speechToTextService.disableRetries();
    testUpgradeLanguageModelWOptions();
  }

  // Test the upgradeLanguageModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpgradeLanguageModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.upgradeLanguageModel(null).execute();
  }

  // Test the listCorpora operation with a valid options model parameter
  @Test
  public void testListCorporaWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"corpora\": [{\"name\": \"name\", \"total_words\": 10, \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}]}";
    String listCorporaPath = "/v1/customizations/testString/corpora";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCorporaOptions model
    ListCorporaOptions listCorporaOptionsModel =
        new ListCorporaOptions.Builder().customizationId("testString").build();

    // Invoke listCorpora() with a valid options model and verify the result
    Response<Corpora> response = speechToTextService.listCorpora(listCorporaOptionsModel).execute();
    assertNotNull(response);
    Corpora responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCorporaPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listCorpora operation with and without retries enabled
  @Test
  public void testListCorporaWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListCorporaWOptions();

    speechToTextService.disableRetries();
    testListCorporaWOptions();
  }

  // Test the listCorpora operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCorporaNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.listCorpora(null).execute();
  }

  // Test the addCorpus operation with a valid options model parameter
  @Test
  public void testAddCorpusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addCorpusPath = "/v1/customizations/testString/corpora/testString";
    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    // Construct an instance of the AddCorpusOptions model
    AddCorpusOptions addCorpusOptionsModel =
        new AddCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .corpusFile(TestUtilities.createMockStream("This is a mock file."))
            .allowOverwrite(false)
            .build();

    // Invoke addCorpus() with a valid options model and verify the result
    Response<Void> response = speechToTextService.addCorpus(addCorpusOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addCorpusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(false));
  }

  // Test the addCorpus operation with and without retries enabled
  @Test
  public void testAddCorpusWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testAddCorpusWOptions();

    speechToTextService.disableRetries();
    testAddCorpusWOptions();
  }

  // Test the addCorpus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCorpusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.addCorpus(null).execute();
  }

  // Test the getCorpus operation with a valid options model parameter
  @Test
  public void testGetCorpusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"total_words\": 10, \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}";
    String getCorpusPath = "/v1/customizations/testString/corpora/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCorpusOptions model
    GetCorpusOptions getCorpusOptionsModel =
        new GetCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .build();

    // Invoke getCorpus() with a valid options model and verify the result
    Response<Corpus> response = speechToTextService.getCorpus(getCorpusOptionsModel).execute();
    assertNotNull(response);
    Corpus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCorpusPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCorpus operation with and without retries enabled
  @Test
  public void testGetCorpusWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetCorpusWOptions();

    speechToTextService.disableRetries();
    testGetCorpusWOptions();
  }

  // Test the getCorpus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCorpusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getCorpus(null).execute();
  }

  // Test the deleteCorpus operation with a valid options model parameter
  @Test
  public void testDeleteCorpusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCorpusPath = "/v1/customizations/testString/corpora/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteCorpusOptions model
    DeleteCorpusOptions deleteCorpusOptionsModel =
        new DeleteCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .build();

    // Invoke deleteCorpus() with a valid options model and verify the result
    Response<Void> response = speechToTextService.deleteCorpus(deleteCorpusOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCorpusPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteCorpus operation with and without retries enabled
  @Test
  public void testDeleteCorpusWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteCorpusWOptions();

    speechToTextService.disableRetries();
    testDeleteCorpusWOptions();
  }

  // Test the deleteCorpus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCorpusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteCorpus(null).execute();
  }

  // Test the listWords operation with a valid options model parameter
  @Test
  public void testListWordsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"words\": [{\"word\": \"word\", \"mapping_only\": [\"mappingOnly\"], \"sounds_like\": [\"soundsLike\"], \"display_as\": \"displayAs\", \"count\": 5, \"source\": [\"source\"], \"error\": [{\"element\": \"element\"}]}]}";
    String listWordsPath = "/v1/customizations/testString/words";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListWordsOptions model
    ListWordsOptions listWordsOptionsModel =
        new ListWordsOptions.Builder()
            .customizationId("testString")
            .wordType("all")
            .sort("alphabetical")
            .build();

    // Invoke listWords() with a valid options model and verify the result
    Response<Words> response = speechToTextService.listWords(listWordsOptionsModel).execute();
    assertNotNull(response);
    Words responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listWordsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("word_type"), "all");
    assertEquals(query.get("sort"), "alphabetical");
  }

  // Test the listWords operation with and without retries enabled
  @Test
  public void testListWordsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListWordsWOptions();

    speechToTextService.disableRetries();
    testListWordsWOptions();
  }

  // Test the listWords operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListWordsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.listWords(null).execute();
  }

  // Test the addWords operation with a valid options model parameter
  @Test
  public void testAddWordsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addWordsPath = "/v1/customizations/testString/words";
    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    // Construct an instance of the CustomWord model
    CustomWord customWordModel =
        new CustomWord.Builder()
            .word("testString")
            .mappingOnly(java.util.Arrays.asList("testString"))
            .soundsLike(java.util.Arrays.asList("testString"))
            .displayAs("testString")
            .build();

    // Construct an instance of the AddWordsOptions model
    AddWordsOptions addWordsOptionsModel =
        new AddWordsOptions.Builder()
            .customizationId("testString")
            .words(java.util.Arrays.asList(customWordModel))
            .build();

    // Invoke addWords() with a valid options model and verify the result
    Response<Void> response = speechToTextService.addWords(addWordsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWordsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addWords operation with and without retries enabled
  @Test
  public void testAddWordsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testAddWordsWOptions();

    speechToTextService.disableRetries();
    testAddWordsWOptions();
  }

  // Test the addWords operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.addWords(null).execute();
  }

  // Test the addWord operation with a valid options model parameter
  @Test
  public void testAddWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    // Construct an instance of the AddWordOptions model
    AddWordOptions addWordOptionsModel =
        new AddWordOptions.Builder()
            .customizationId("testString")
            .wordName("testString")
            .word("testString")
            .mappingOnly(java.util.Arrays.asList("testString"))
            .soundsLike(java.util.Arrays.asList("testString"))
            .displayAs("testString")
            .build();

    // Invoke addWord() with a valid options model and verify the result
    Response<Void> response = speechToTextService.addWord(addWordOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWordPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addWord operation with and without retries enabled
  @Test
  public void testAddWordWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testAddWordWOptions();

    speechToTextService.disableRetries();
    testAddWordWOptions();
  }

  // Test the addWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.addWord(null).execute();
  }

  // Test the getWord operation with a valid options model parameter
  @Test
  public void testGetWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"word\": \"word\", \"mapping_only\": [\"mappingOnly\"], \"sounds_like\": [\"soundsLike\"], \"display_as\": \"displayAs\", \"count\": 5, \"source\": [\"source\"], \"error\": [{\"element\": \"element\"}]}";
    String getWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetWordOptions model
    GetWordOptions getWordOptionsModel =
        new GetWordOptions.Builder().customizationId("testString").wordName("testString").build();

    // Invoke getWord() with a valid options model and verify the result
    Response<Word> response = speechToTextService.getWord(getWordOptionsModel).execute();
    assertNotNull(response);
    Word responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getWordPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getWord operation with and without retries enabled
  @Test
  public void testGetWordWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetWordWOptions();

    speechToTextService.disableRetries();
    testGetWordWOptions();
  }

  // Test the getWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getWord(null).execute();
  }

  // Test the deleteWord operation with a valid options model parameter
  @Test
  public void testDeleteWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteWordOptions model
    DeleteWordOptions deleteWordOptionsModel =
        new DeleteWordOptions.Builder()
            .customizationId("testString")
            .wordName("testString")
            .build();

    // Invoke deleteWord() with a valid options model and verify the result
    Response<Void> response = speechToTextService.deleteWord(deleteWordOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteWordPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteWord operation with and without retries enabled
  @Test
  public void testDeleteWordWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteWordWOptions();

    speechToTextService.disableRetries();
    testDeleteWordWOptions();
  }

  // Test the deleteWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteWord(null).execute();
  }

  // Test the listGrammars operation with a valid options model parameter
  @Test
  public void testListGrammarsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"grammars\": [{\"name\": \"name\", \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}]}";
    String listGrammarsPath = "/v1/customizations/testString/grammars";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListGrammarsOptions model
    ListGrammarsOptions listGrammarsOptionsModel =
        new ListGrammarsOptions.Builder().customizationId("testString").build();

    // Invoke listGrammars() with a valid options model and verify the result
    Response<Grammars> response =
        speechToTextService.listGrammars(listGrammarsOptionsModel).execute();
    assertNotNull(response);
    Grammars responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listGrammarsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listGrammars operation with and without retries enabled
  @Test
  public void testListGrammarsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListGrammarsWOptions();

    speechToTextService.disableRetries();
    testListGrammarsWOptions();
  }

  // Test the listGrammars operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListGrammarsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.listGrammars(null).execute();
  }

  // Test the addGrammar operation with a valid options model parameter
  @Test
  public void testAddGrammarWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addGrammarPath = "/v1/customizations/testString/grammars/testString";
    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    // Construct an instance of the AddGrammarOptions model
    AddGrammarOptions addGrammarOptionsModel =
        new AddGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .grammarFile(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/srgs")
            .allowOverwrite(false)
            .build();

    // Invoke addGrammar() with a valid options model and verify the result
    Response<Void> response = speechToTextService.addGrammar(addGrammarOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addGrammarPath);
    // Verify header parameters
    assertEquals(request.getHeader("Content-Type"), "application/srgs");
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(false));
  }

  // Test the addGrammar operation with and without retries enabled
  @Test
  public void testAddGrammarWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testAddGrammarWOptions();

    speechToTextService.disableRetries();
    testAddGrammarWOptions();
  }

  // Test the addGrammar operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddGrammarNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.addGrammar(null).execute();
  }

  // Test the getGrammar operation with a valid options model parameter
  @Test
  public void testGetGrammarWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}";
    String getGrammarPath = "/v1/customizations/testString/grammars/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetGrammarOptions model
    GetGrammarOptions getGrammarOptionsModel =
        new GetGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .build();

    // Invoke getGrammar() with a valid options model and verify the result
    Response<Grammar> response = speechToTextService.getGrammar(getGrammarOptionsModel).execute();
    assertNotNull(response);
    Grammar responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGrammarPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getGrammar operation with and without retries enabled
  @Test
  public void testGetGrammarWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetGrammarWOptions();

    speechToTextService.disableRetries();
    testGetGrammarWOptions();
  }

  // Test the getGrammar operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGrammarNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getGrammar(null).execute();
  }

  // Test the deleteGrammar operation with a valid options model parameter
  @Test
  public void testDeleteGrammarWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteGrammarPath = "/v1/customizations/testString/grammars/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteGrammarOptions model
    DeleteGrammarOptions deleteGrammarOptionsModel =
        new DeleteGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .build();

    // Invoke deleteGrammar() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.deleteGrammar(deleteGrammarOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteGrammarPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteGrammar operation with and without retries enabled
  @Test
  public void testDeleteGrammarWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteGrammarWOptions();

    speechToTextService.disableRetries();
    testDeleteGrammarWOptions();
  }

  // Test the deleteGrammar operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteGrammarNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteGrammar(null).execute();
  }

  // Test the createAcousticModel operation with a valid options model parameter
  @Test
  public void testCreateAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}";
    String createAcousticModelPath = "/v1/acoustic_customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateAcousticModelOptions model
    CreateAcousticModelOptions createAcousticModelOptionsModel =
        new CreateAcousticModelOptions.Builder()
            .name("testString")
            .baseModelName("ar-MS_BroadbandModel")
            .description("testString")
            .build();

    // Invoke createAcousticModel() with a valid options model and verify the result
    Response<AcousticModel> response =
        speechToTextService.createAcousticModel(createAcousticModelOptionsModel).execute();
    assertNotNull(response);
    AcousticModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAcousticModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAcousticModel operation with and without retries enabled
  @Test
  public void testCreateAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testCreateAcousticModelWOptions();

    speechToTextService.disableRetries();
    testCreateAcousticModelWOptions();
  }

  // Test the createAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.createAcousticModel(null).execute();
  }

  // Test the listAcousticModels operation with a valid options model parameter
  @Test
  public void testListAcousticModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}]}";
    String listAcousticModelsPath = "/v1/acoustic_customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListAcousticModelsOptions model
    ListAcousticModelsOptions listAcousticModelsOptionsModel =
        new ListAcousticModelsOptions.Builder().language("ar-MS").build();

    // Invoke listAcousticModels() with a valid options model and verify the result
    Response<AcousticModels> response =
        speechToTextService.listAcousticModels(listAcousticModelsOptionsModel).execute();
    assertNotNull(response);
    AcousticModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAcousticModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("language"), "ar-MS");
  }

  // Test the listAcousticModels operation with and without retries enabled
  @Test
  public void testListAcousticModelsWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListAcousticModelsWOptions();

    speechToTextService.disableRetries();
    testListAcousticModelsWOptions();
  }

  // Test the getAcousticModel operation with a valid options model parameter
  @Test
  public void testGetAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}";
    String getAcousticModelPath = "/v1/acoustic_customizations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetAcousticModelOptions model
    GetAcousticModelOptions getAcousticModelOptionsModel =
        new GetAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke getAcousticModel() with a valid options model and verify the result
    Response<AcousticModel> response =
        speechToTextService.getAcousticModel(getAcousticModelOptionsModel).execute();
    assertNotNull(response);
    AcousticModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAcousticModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAcousticModel operation with and without retries enabled
  @Test
  public void testGetAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetAcousticModelWOptions();

    speechToTextService.disableRetries();
    testGetAcousticModelWOptions();
  }

  // Test the getAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getAcousticModel(null).execute();
  }

  // Test the deleteAcousticModel operation with a valid options model parameter
  @Test
  public void testDeleteAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAcousticModelPath = "/v1/acoustic_customizations/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteAcousticModelOptions model
    DeleteAcousticModelOptions deleteAcousticModelOptionsModel =
        new DeleteAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke deleteAcousticModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.deleteAcousticModel(deleteAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAcousticModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAcousticModel operation with and without retries enabled
  @Test
  public void testDeleteAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteAcousticModelWOptions();

    speechToTextService.disableRetries();
    testDeleteAcousticModelWOptions();
  }

  // Test the deleteAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteAcousticModel(null).execute();
  }

  // Test the trainAcousticModel operation with a valid options model parameter
  @Test
  public void testTrainAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"warnings\": [{\"code\": \"invalid_audio_files\", \"message\": \"message\"}]}";
    String trainAcousticModelPath = "/v1/acoustic_customizations/testString/train";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the TrainAcousticModelOptions model
    TrainAcousticModelOptions trainAcousticModelOptionsModel =
        new TrainAcousticModelOptions.Builder()
            .customizationId("testString")
            .customLanguageModelId("testString")
            .strict(true)
            .build();

    // Invoke trainAcousticModel() with a valid options model and verify the result
    Response<TrainingResponse> response =
        speechToTextService.trainAcousticModel(trainAcousticModelOptionsModel).execute();
    assertNotNull(response);
    TrainingResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, trainAcousticModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("custom_language_model_id"), "testString");
    assertEquals(Boolean.valueOf(query.get("strict")), Boolean.valueOf(true));
  }

  // Test the trainAcousticModel operation with and without retries enabled
  @Test
  public void testTrainAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testTrainAcousticModelWOptions();

    speechToTextService.disableRetries();
    testTrainAcousticModelWOptions();
  }

  // Test the trainAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.trainAcousticModel(null).execute();
  }

  // Test the resetAcousticModel operation with a valid options model parameter
  @Test
  public void testResetAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String resetAcousticModelPath = "/v1/acoustic_customizations/testString/reset";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the ResetAcousticModelOptions model
    ResetAcousticModelOptions resetAcousticModelOptionsModel =
        new ResetAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke resetAcousticModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.resetAcousticModel(resetAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resetAcousticModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the resetAcousticModel operation with and without retries enabled
  @Test
  public void testResetAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testResetAcousticModelWOptions();

    speechToTextService.disableRetries();
    testResetAcousticModelWOptions();
  }

  // Test the resetAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResetAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.resetAcousticModel(null).execute();
  }

  // Test the upgradeAcousticModel operation with a valid options model parameter
  @Test
  public void testUpgradeAcousticModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String upgradeAcousticModelPath = "/v1/acoustic_customizations/testString/upgrade_model";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the UpgradeAcousticModelOptions model
    UpgradeAcousticModelOptions upgradeAcousticModelOptionsModel =
        new UpgradeAcousticModelOptions.Builder()
            .customizationId("testString")
            .customLanguageModelId("testString")
            .force(false)
            .build();

    // Invoke upgradeAcousticModel() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.upgradeAcousticModel(upgradeAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, upgradeAcousticModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("custom_language_model_id"), "testString");
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(false));
  }

  // Test the upgradeAcousticModel operation with and without retries enabled
  @Test
  public void testUpgradeAcousticModelWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testUpgradeAcousticModelWOptions();

    speechToTextService.disableRetries();
    testUpgradeAcousticModelWOptions();
  }

  // Test the upgradeAcousticModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpgradeAcousticModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.upgradeAcousticModel(null).execute();
  }

  // Test the listAudio operation with a valid options model parameter
  @Test
  public void testListAudioWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"total_minutes_of_audio\": 19, \"audio\": [{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}]}";
    String listAudioPath = "/v1/acoustic_customizations/testString/audio";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListAudioOptions model
    ListAudioOptions listAudioOptionsModel =
        new ListAudioOptions.Builder().customizationId("testString").build();

    // Invoke listAudio() with a valid options model and verify the result
    Response<AudioResources> response =
        speechToTextService.listAudio(listAudioOptionsModel).execute();
    assertNotNull(response);
    AudioResources responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAudioPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listAudio operation with and without retries enabled
  @Test
  public void testListAudioWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testListAudioWOptions();

    speechToTextService.disableRetries();
    testListAudioWOptions();
  }

  // Test the listAudio operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAudioNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.listAudio(null).execute();
  }

  // Test the addAudio operation with a valid options model parameter
  @Test
  public void testAddAudioWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addAudioPath = "/v1/acoustic_customizations/testString/audio/testString";
    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    // Construct an instance of the AddAudioOptions model
    AddAudioOptions addAudioOptionsModel =
        new AddAudioOptions.Builder()
            .customizationId("testString")
            .audioName("testString")
            .audioResource(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/zip")
            .containedContentType("audio/alaw")
            .allowOverwrite(false)
            .build();

    // Invoke addAudio() with a valid options model and verify the result
    Response<Void> response = speechToTextService.addAudio(addAudioOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addAudioPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(false));
  }

  // Test the addAudio operation with and without retries enabled
  @Test
  public void testAddAudioWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testAddAudioWOptions();

    speechToTextService.disableRetries();
    testAddAudioWOptions();
  }

  // Test the addAudio operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddAudioNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.addAudio(null).execute();
  }

  // Test the getAudio operation with a valid options model parameter
  @Test
  public void testGetAudioWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\", \"container\": {\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}, \"audio\": [{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}]}";
    String getAudioPath = "/v1/acoustic_customizations/testString/audio/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetAudioOptions model
    GetAudioOptions getAudioOptionsModel =
        new GetAudioOptions.Builder().customizationId("testString").audioName("testString").build();

    // Invoke getAudio() with a valid options model and verify the result
    Response<AudioListing> response = speechToTextService.getAudio(getAudioOptionsModel).execute();
    assertNotNull(response);
    AudioListing responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAudioPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAudio operation with and without retries enabled
  @Test
  public void testGetAudioWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testGetAudioWOptions();

    speechToTextService.disableRetries();
    testGetAudioWOptions();
  }

  // Test the getAudio operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAudioNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.getAudio(null).execute();
  }

  // Test the deleteAudio operation with a valid options model parameter
  @Test
  public void testDeleteAudioWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAudioPath = "/v1/acoustic_customizations/testString/audio/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteAudioOptions model
    DeleteAudioOptions deleteAudioOptionsModel =
        new DeleteAudioOptions.Builder()
            .customizationId("testString")
            .audioName("testString")
            .build();

    // Invoke deleteAudio() with a valid options model and verify the result
    Response<Void> response = speechToTextService.deleteAudio(deleteAudioOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAudioPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAudio operation with and without retries enabled
  @Test
  public void testDeleteAudioWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteAudioWOptions();

    speechToTextService.disableRetries();
    testDeleteAudioWOptions();
  }

  // Test the deleteAudio operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAudioNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteAudio(null).execute();
  }

  // Test the deleteUserData operation with a valid options model parameter
  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke deleteUserData() with a valid options model and verify the result
    Response<Void> response =
        speechToTextService.deleteUserData(deleteUserDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteUserDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("customer_id"), "testString");
  }

  // Test the deleteUserData operation with and without retries enabled
  @Test
  public void testDeleteUserDataWRetries() throws Throwable {
    speechToTextService.enableRetries(4, 30);
    testDeleteUserDataWOptions();

    speechToTextService.disableRetries();
    testDeleteUserDataWOptions();
  }

  // Test the deleteUserData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    speechToTextService.deleteUserData(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    speechToTextService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();
    speechToTextService = new SpeechToText(serviceName, authenticator);
    String url = server.url("/").toString();
    speechToTextService.setServiceUrl(url);
  }
}
