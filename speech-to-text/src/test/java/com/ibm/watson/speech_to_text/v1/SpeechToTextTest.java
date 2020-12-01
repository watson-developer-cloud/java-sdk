/*
 * (C) Copyright IBM Corp. 2020.
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

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();

    speechToTextService = new SpeechToText(serviceName, authenticator);
    String url = server.url("/").toString();
    speechToTextService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new SpeechToText(serviceName, null);
  }

  @Test
  public void testListModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"name\": \"name\", \"language\": \"language\", \"rate\": 4, \"url\": \"url\", \"supported_features\": {\"custom_language_model\": false, \"speaker_labels\": false}, \"description\": \"description\"}]}";
    String listModelsPath = "/v1/models";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel = new ListModelsOptions();

    // Invoke operation with valid options model (positive test)
    Response<SpeechModels> response =
        speechToTextService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    SpeechModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listModelsPath);
  }

  @Test
  public void testGetModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"language\": \"language\", \"rate\": 4, \"url\": \"url\", \"supported_features\": {\"custom_language_model\": false, \"speaker_labels\": false}, \"description\": \"description\"}";
    String getModelPath = "/v1/models/ar-AR_BroadbandModel";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetModelOptions model
    GetModelOptions getModelOptionsModel =
        new GetModelOptions.Builder().modelId("ar-AR_BroadbandModel").build();

    // Invoke operation with valid options model (positive test)
    Response<SpeechModel> response = speechToTextService.getModel(getModelOptionsModel).execute();
    assertNotNull(response);
    SpeechModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getModelPath);
  }

  // Test the getModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getModel(null).execute();
  }

  @Test
  public void testRecognizeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [\"timestamps\"], \"word_confidence\": [\"wordConfidence\"]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}";
    String recognizePath = "/v1/recognize";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RecognizeOptions model
    RecognizeOptions recognizeOptionsModel =
        new RecognizeOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("ar-AR_BroadbandModel")
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("26"))
            .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("26"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(true)
            .timestamps(true)
            .profanityFilter(true)
            .smartFormatting(true)
            .speakerLabels(true)
            .customizationId("testString")
            .grammarName("testString")
            .redaction(true)
            .audioMetrics(true)
            .endOfPhraseSilenceTime(Double.valueOf("72.5"))
            .splitTranscriptAtPhraseEnd(true)
            .speechDetectorSensitivity(Float.valueOf("36.0"))
            .backgroundAudioSuppression(Float.valueOf("36.0"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<SpeechRecognitionResults> response =
        speechToTextService.recognize(recognizeOptionsModel).execute();
    assertNotNull(response);
    SpeechRecognitionResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("model"), "ar-AR_BroadbandModel");
    assertEquals(query.get("language_customization_id"), "testString");
    assertEquals(query.get("acoustic_customization_id"), "testString");
    assertEquals(query.get("base_model_version"), "testString");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    assertEquals(Long.valueOf(query.get("inactivity_timeout")), Long.valueOf("26"));
    assertEquals(
        query.get("keywords"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Float.valueOf(query.get("keywords_threshold")), Float.valueOf("36.0"));
    assertEquals(Long.valueOf(query.get("max_alternatives")), Long.valueOf("26"));
    assertEquals(Float.valueOf(query.get("word_alternatives_threshold")), Float.valueOf("36.0"));
    assertEquals(Boolean.valueOf(query.get("word_confidence")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("timestamps")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("profanity_filter")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("smart_formatting")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("speaker_labels")), Boolean.valueOf(true));
    assertEquals(query.get("customization_id"), "testString");
    assertEquals(query.get("grammar_name"), "testString");
    assertEquals(Boolean.valueOf(query.get("redaction")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("audio_metrics")), Boolean.valueOf(true));
    assertEquals(Double.valueOf(query.get("end_of_phrase_silence_time")), Double.valueOf("72.5"));
    assertEquals(
        Boolean.valueOf(query.get("split_transcript_at_phrase_end")), Boolean.valueOf(true));
    assertEquals(Float.valueOf(query.get("speech_detector_sensitivity")), Float.valueOf("36.0"));
    assertEquals(Float.valueOf(query.get("background_audio_suppression")), Float.valueOf("36.0"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, recognizePath);
  }

  // Test the recognize operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRecognizeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.recognize(null).execute();
  }

  @Test
  public void testRegisterCallbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"created\", \"url\": \"url\"}";
    String registerCallbackPath = "/v1/register_callback";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RegisterCallbackOptions model
    RegisterCallbackOptions registerCallbackOptionsModel =
        new RegisterCallbackOptions.Builder()
            .callbackUrl("testString")
            .userSecret("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<RegisterStatus> response =
        speechToTextService.registerCallback(registerCallbackOptionsModel).execute();
    assertNotNull(response);
    RegisterStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("callback_url"), "testString");
    assertEquals(query.get("user_secret"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, registerCallbackPath);
  }

  // Test the registerCallback operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRegisterCallbackNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.registerCallback(null).execute();
  }

  @Test
  public void testUnregisterCallbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String unregisterCallbackPath = "/v1/unregister_callback";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnregisterCallbackOptions model
    UnregisterCallbackOptions unregisterCallbackOptionsModel =
        new UnregisterCallbackOptions.Builder().callbackUrl("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.unregisterCallback(unregisterCallbackOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("callback_url"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unregisterCallbackPath);
  }

  // Test the unregisterCallback operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnregisterCallbackNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.unregisterCallback(null).execute();
  }

  @Test
  public void testCreateJobWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [\"timestamps\"], \"word_confidence\": [\"wordConfidence\"]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}";
    String createJobPath = "/v1/recognitions";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateJobOptions model
    CreateJobOptions createJobOptionsModel =
        new CreateJobOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("ar-AR_BroadbandModel")
            .callbackUrl("testString")
            .events("recognitions.started")
            .userToken("testString")
            .resultsTtl(Long.valueOf("26"))
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("26"))
            .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("26"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(true)
            .timestamps(true)
            .profanityFilter(true)
            .smartFormatting(true)
            .speakerLabels(true)
            .customizationId("testString")
            .grammarName("testString")
            .redaction(true)
            .processingMetrics(true)
            .processingMetricsInterval(Float.valueOf("36.0"))
            .audioMetrics(true)
            .endOfPhraseSilenceTime(Double.valueOf("72.5"))
            .splitTranscriptAtPhraseEnd(true)
            .speechDetectorSensitivity(Float.valueOf("36.0"))
            .backgroundAudioSuppression(Float.valueOf("36.0"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<RecognitionJob> response =
        speechToTextService.createJob(createJobOptionsModel).execute();
    assertNotNull(response);
    RecognitionJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("model"), "ar-AR_BroadbandModel");
    assertEquals(query.get("callback_url"), "testString");
    assertEquals(query.get("events"), "recognitions.started");
    assertEquals(query.get("user_token"), "testString");
    assertEquals(Long.valueOf(query.get("results_ttl")), Long.valueOf("26"));
    assertEquals(query.get("language_customization_id"), "testString");
    assertEquals(query.get("acoustic_customization_id"), "testString");
    assertEquals(query.get("base_model_version"), "testString");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    assertEquals(Long.valueOf(query.get("inactivity_timeout")), Long.valueOf("26"));
    assertEquals(
        query.get("keywords"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Float.valueOf(query.get("keywords_threshold")), Float.valueOf("36.0"));
    assertEquals(Long.valueOf(query.get("max_alternatives")), Long.valueOf("26"));
    assertEquals(Float.valueOf(query.get("word_alternatives_threshold")), Float.valueOf("36.0"));
    assertEquals(Boolean.valueOf(query.get("word_confidence")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("timestamps")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("profanity_filter")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("smart_formatting")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("speaker_labels")), Boolean.valueOf(true));
    assertEquals(query.get("customization_id"), "testString");
    assertEquals(query.get("grammar_name"), "testString");
    assertEquals(Boolean.valueOf(query.get("redaction")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("processing_metrics")), Boolean.valueOf(true));
    assertEquals(Float.valueOf(query.get("processing_metrics_interval")), Float.valueOf("36.0"));
    assertEquals(Boolean.valueOf(query.get("audio_metrics")), Boolean.valueOf(true));
    assertEquals(Double.valueOf(query.get("end_of_phrase_silence_time")), Double.valueOf("72.5"));
    assertEquals(
        Boolean.valueOf(query.get("split_transcript_at_phrase_end")), Boolean.valueOf(true));
    assertEquals(Float.valueOf(query.get("speech_detector_sensitivity")), Float.valueOf("36.0"));
    assertEquals(Float.valueOf(query.get("background_audio_suppression")), Float.valueOf("36.0"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createJobPath);
  }

  // Test the createJob operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateJobNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.createJob(null).execute();
  }

  @Test
  public void testCheckJobsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"recognitions\": [{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [\"timestamps\"], \"word_confidence\": [\"wordConfidence\"]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}]}";
    String checkJobsPath = "/v1/recognitions";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CheckJobsOptions model
    CheckJobsOptions checkJobsOptionsModel = new CheckJobsOptions();

    // Invoke operation with valid options model (positive test)
    Response<RecognitionJobs> response =
        speechToTextService.checkJobs(checkJobsOptionsModel).execute();
    assertNotNull(response);
    RecognitionJobs responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkJobsPath);
  }

  @Test
  public void testCheckJobWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"id\": \"id\", \"status\": \"waiting\", \"created\": \"created\", \"updated\": \"updated\", \"url\": \"url\", \"user_token\": \"userToken\", \"results\": [{\"results\": [{\"final\": true, \"alternatives\": [{\"transcript\": \"transcript\", \"confidence\": 0, \"timestamps\": [\"timestamps\"], \"word_confidence\": [\"wordConfidence\"]}], \"keywords_result\": {\"mapKey\": [{\"normalized_text\": \"normalizedText\", \"start_time\": 9, \"end_time\": 7, \"confidence\": 0}]}, \"word_alternatives\": [{\"start_time\": 9, \"end_time\": 7, \"alternatives\": [{\"confidence\": 0, \"word\": \"word\"}]}], \"end_of_utterance\": \"end_of_data\"}], \"result_index\": 11, \"speaker_labels\": [{\"from\": 4, \"to\": 2, \"speaker\": 7, \"confidence\": 10, \"final\": true}], \"processing_metrics\": {\"processed_audio\": {\"received\": 8, \"seen_by_engine\": 12, \"transcription\": 13, \"speaker_labels\": 13}, \"wall_clock_since_first_byte_received\": 31, \"periodic\": true}, \"audio_metrics\": {\"sampling_interval\": 16, \"accumulated\": {\"final\": true, \"end_time\": 7, \"signal_to_noise_ratio\": 18, \"speech_ratio\": 11, \"high_frequency_loss\": 17, \"direct_current_offset\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"clipping_rate\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}], \"non_speech_level\": [{\"begin\": 5, \"end\": 3, \"count\": 5}]}}, \"warnings\": [\"warnings\"]}], \"warnings\": [\"warnings\"]}";
    String checkJobPath = "/v1/recognitions/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CheckJobOptions model
    CheckJobOptions checkJobOptionsModel = new CheckJobOptions.Builder().id("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<RecognitionJob> response =
        speechToTextService.checkJob(checkJobOptionsModel).execute();
    assertNotNull(response);
    RecognitionJob responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, checkJobPath);
  }

  // Test the checkJob operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCheckJobNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.checkJob(null).execute();
  }

  @Test
  public void testDeleteJobWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteJobPath = "/v1/recognitions/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteJobOptions model
    DeleteJobOptions deleteJobOptionsModel =
        new DeleteJobOptions.Builder().id("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.deleteJob(deleteJobOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteJobPath);
  }

  // Test the deleteJob operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteJobNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteJob(null).execute();
  }

  @Test
  public void testCreateLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}";
    String createLanguageModelPath = "/v1/customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateLanguageModelOptions model
    CreateLanguageModelOptions createLanguageModelOptionsModel =
        new CreateLanguageModelOptions.Builder()
            .name("testString")
            .baseModelName("de-DE_BroadbandModel")
            .dialect("testString")
            .description("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<LanguageModel> response =
        speechToTextService.createLanguageModel(createLanguageModelOptionsModel).execute();
    assertNotNull(response);
    LanguageModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createLanguageModelPath);
  }

  // Test the createLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.createLanguageModel(null).execute();
  }

  @Test
  public void testListLanguageModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}]}";
    String listLanguageModelsPath = "/v1/customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListLanguageModelsOptions model
    ListLanguageModelsOptions listLanguageModelsOptionsModel =
        new ListLanguageModelsOptions.Builder().language("ar-AR").build();

    // Invoke operation with valid options model (positive test)
    Response<LanguageModels> response =
        speechToTextService.listLanguageModels(listLanguageModelsOptionsModel).execute();
    assertNotNull(response);
    LanguageModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("language"), "ar-AR");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLanguageModelsPath);
  }

  @Test
  public void testGetLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"dialect\": \"dialect\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"error\": \"error\", \"warnings\": \"warnings\"}";
    String getLanguageModelPath = "/v1/customizations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLanguageModelOptions model
    GetLanguageModelOptions getLanguageModelOptionsModel =
        new GetLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<LanguageModel> response =
        speechToTextService.getLanguageModel(getLanguageModelOptionsModel).execute();
    assertNotNull(response);
    LanguageModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLanguageModelPath);
  }

  // Test the getLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getLanguageModel(null).execute();
  }

  @Test
  public void testDeleteLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteLanguageModelPath = "/v1/customizations/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteLanguageModelOptions model
    DeleteLanguageModelOptions deleteLanguageModelOptionsModel =
        new DeleteLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.deleteLanguageModel(deleteLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLanguageModelPath);
  }

  // Test the deleteLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteLanguageModel(null).execute();
  }

  @Test
  public void testTrainLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"warnings\": [{\"code\": \"invalid_audio_files\", \"message\": \"message\"}]}";
    String trainLanguageModelPath = "/v1/customizations/testString/train";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TrainLanguageModelOptions model
    TrainLanguageModelOptions trainLanguageModelOptionsModel =
        new TrainLanguageModelOptions.Builder()
            .customizationId("testString")
            .wordTypeToAdd("all")
            .customizationWeight(Double.valueOf("72.5"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingResponse> response =
        speechToTextService.trainLanguageModel(trainLanguageModelOptionsModel).execute();
    assertNotNull(response);
    TrainingResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("word_type_to_add"), "all");
    assertEquals(Double.valueOf(query.get("customization_weight")), Double.valueOf("72.5"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, trainLanguageModelPath);
  }

  // Test the trainLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.trainLanguageModel(null).execute();
  }

  @Test
  public void testResetLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String resetLanguageModelPath = "/v1/customizations/testString/reset";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResetLanguageModelOptions model
    ResetLanguageModelOptions resetLanguageModelOptionsModel =
        new ResetLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.resetLanguageModel(resetLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resetLanguageModelPath);
  }

  // Test the resetLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResetLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.resetLanguageModel(null).execute();
  }

  @Test
  public void testUpgradeLanguageModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String upgradeLanguageModelPath = "/v1/customizations/testString/upgrade_model";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpgradeLanguageModelOptions model
    UpgradeLanguageModelOptions upgradeLanguageModelOptionsModel =
        new UpgradeLanguageModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.upgradeLanguageModel(upgradeLanguageModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, upgradeLanguageModelPath);
  }

  // Test the upgradeLanguageModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpgradeLanguageModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.upgradeLanguageModel(null).execute();
  }

  @Test
  public void testListCorporaWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"corpora\": [{\"name\": \"name\", \"total_words\": 10, \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}]}";
    String listCorporaPath = "/v1/customizations/testString/corpora";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCorporaOptions model
    ListCorporaOptions listCorporaOptionsModel =
        new ListCorporaOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Corpora> response = speechToTextService.listCorpora(listCorporaOptionsModel).execute();
    assertNotNull(response);
    Corpora responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCorporaPath);
  }

  // Test the listCorpora operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCorporaNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.listCorpora(null).execute();
  }

  @Test
  public void testAddCorpusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addCorpusPath = "/v1/customizations/testString/corpora/testString";

    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddCorpusOptions model
    AddCorpusOptions addCorpusOptionsModel =
        new AddCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .corpusFile(TestUtilities.createMockStream("This is a mock file."))
            .allowOverwrite(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.addCorpus(addCorpusOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addCorpusPath);
  }

  // Test the addCorpus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCorpusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.addCorpus(null).execute();
  }

  @Test
  public void testGetCorpusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"total_words\": 10, \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}";
    String getCorpusPath = "/v1/customizations/testString/corpora/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCorpusOptions model
    GetCorpusOptions getCorpusOptionsModel =
        new GetCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Corpus> response = speechToTextService.getCorpus(getCorpusOptionsModel).execute();
    assertNotNull(response);
    Corpus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCorpusPath);
  }

  // Test the getCorpus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCorpusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getCorpus(null).execute();
  }

  @Test
  public void testDeleteCorpusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCorpusPath = "/v1/customizations/testString/corpora/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCorpusOptions model
    DeleteCorpusOptions deleteCorpusOptionsModel =
        new DeleteCorpusOptions.Builder()
            .customizationId("testString")
            .corpusName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.deleteCorpus(deleteCorpusOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCorpusPath);
  }

  // Test the deleteCorpus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCorpusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteCorpus(null).execute();
  }

  @Test
  public void testListWordsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"words\": [{\"word\": \"word\", \"sounds_like\": [\"soundsLike\"], \"display_as\": \"displayAs\", \"count\": 5, \"source\": [\"source\"], \"error\": [{\"element\": \"element\"}]}]}";
    String listWordsPath = "/v1/customizations/testString/words";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListWordsOptions model
    ListWordsOptions listWordsOptionsModel =
        new ListWordsOptions.Builder()
            .customizationId("testString")
            .wordType("all")
            .sort("alphabetical")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Words> response = speechToTextService.listWords(listWordsOptionsModel).execute();
    assertNotNull(response);
    Words responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("word_type"), "all");
    assertEquals(query.get("sort"), "alphabetical");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listWordsPath);
  }

  // Test the listWords operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListWordsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.listWords(null).execute();
  }

  @Test
  public void testAddWordsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addWordsPath = "/v1/customizations/testString/words";

    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CustomWord model
    CustomWord customWordModel =
        new CustomWord.Builder()
            .word("testString")
            .soundsLike(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .displayAs("testString")
            .build();

    // Construct an instance of the AddWordsOptions model
    AddWordsOptions addWordsOptionsModel =
        new AddWordsOptions.Builder()
            .customizationId("testString")
            .words(new java.util.ArrayList<CustomWord>(java.util.Arrays.asList(customWordModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.addWords(addWordsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWordsPath);
  }

  // Test the addWords operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.addWords(null).execute();
  }

  @Test
  public void testAddWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddWordOptions model
    AddWordOptions addWordOptionsModel =
        new AddWordOptions.Builder()
            .customizationId("testString")
            .wordName("testString")
            .word("testString")
            .soundsLike(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .displayAs("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.addWord(addWordOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWordPath);
  }

  // Test the addWord operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.addWord(null).execute();
  }

  @Test
  public void testGetWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"word\": \"word\", \"sounds_like\": [\"soundsLike\"], \"display_as\": \"displayAs\", \"count\": 5, \"source\": [\"source\"], \"error\": [{\"element\": \"element\"}]}";
    String getWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetWordOptions model
    GetWordOptions getWordOptionsModel =
        new GetWordOptions.Builder().customizationId("testString").wordName("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Word> response = speechToTextService.getWord(getWordOptionsModel).execute();
    assertNotNull(response);
    Word responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getWordPath);
  }

  // Test the getWord operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetWordNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getWord(null).execute();
  }

  @Test
  public void testDeleteWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteWordOptions model
    DeleteWordOptions deleteWordOptionsModel =
        new DeleteWordOptions.Builder()
            .customizationId("testString")
            .wordName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.deleteWord(deleteWordOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteWordPath);
  }

  // Test the deleteWord operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteWordNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteWord(null).execute();
  }

  @Test
  public void testListGrammarsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"grammars\": [{\"name\": \"name\", \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}]}";
    String listGrammarsPath = "/v1/customizations/testString/grammars";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListGrammarsOptions model
    ListGrammarsOptions listGrammarsOptionsModel =
        new ListGrammarsOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Grammars> response =
        speechToTextService.listGrammars(listGrammarsOptionsModel).execute();
    assertNotNull(response);
    Grammars responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listGrammarsPath);
  }

  // Test the listGrammars operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListGrammarsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.listGrammars(null).execute();
  }

  @Test
  public void testAddGrammarWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addGrammarPath = "/v1/customizations/testString/grammars/testString";

    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddGrammarOptions model
    AddGrammarOptions addGrammarOptionsModel =
        new AddGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .grammarFile(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/srgs")
            .allowOverwrite(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.addGrammar(addGrammarOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("Content-Type"), "application/srgs");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addGrammarPath);
  }

  // Test the addGrammar operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddGrammarNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.addGrammar(null).execute();
  }

  @Test
  public void testGetGrammarWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"out_of_vocabulary_words\": 20, \"status\": \"analyzed\", \"error\": \"error\"}";
    String getGrammarPath = "/v1/customizations/testString/grammars/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetGrammarOptions model
    GetGrammarOptions getGrammarOptionsModel =
        new GetGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Grammar> response = speechToTextService.getGrammar(getGrammarOptionsModel).execute();
    assertNotNull(response);
    Grammar responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGrammarPath);
  }

  // Test the getGrammar operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGrammarNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getGrammar(null).execute();
  }

  @Test
  public void testDeleteGrammarWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteGrammarPath = "/v1/customizations/testString/grammars/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteGrammarOptions model
    DeleteGrammarOptions deleteGrammarOptionsModel =
        new DeleteGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.deleteGrammar(deleteGrammarOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteGrammarPath);
  }

  // Test the deleteGrammar operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteGrammarNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteGrammar(null).execute();
  }

  @Test
  public void testCreateAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}";
    String createAcousticModelPath = "/v1/acoustic_customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateAcousticModelOptions model
    CreateAcousticModelOptions createAcousticModelOptionsModel =
        new CreateAcousticModelOptions.Builder()
            .name("testString")
            .baseModelName("ar-AR_BroadbandModel")
            .description("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<AcousticModel> response =
        speechToTextService.createAcousticModel(createAcousticModelOptionsModel).execute();
    assertNotNull(response);
    AcousticModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAcousticModelPath);
  }

  // Test the createAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.createAcousticModel(null).execute();
  }

  @Test
  public void testListAcousticModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}]}";
    String listAcousticModelsPath = "/v1/acoustic_customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAcousticModelsOptions model
    ListAcousticModelsOptions listAcousticModelsOptionsModel =
        new ListAcousticModelsOptions.Builder().language("ar-AR").build();

    // Invoke operation with valid options model (positive test)
    Response<AcousticModels> response =
        speechToTextService.listAcousticModels(listAcousticModelsOptionsModel).execute();
    assertNotNull(response);
    AcousticModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("language"), "ar-AR");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAcousticModelsPath);
  }

  @Test
  public void testGetAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"created\": \"created\", \"updated\": \"updated\", \"language\": \"language\", \"versions\": [\"versions\"], \"owner\": \"owner\", \"name\": \"name\", \"description\": \"description\", \"base_model_name\": \"baseModelName\", \"status\": \"pending\", \"progress\": 8, \"warnings\": \"warnings\"}";
    String getAcousticModelPath = "/v1/acoustic_customizations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAcousticModelOptions model
    GetAcousticModelOptions getAcousticModelOptionsModel =
        new GetAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<AcousticModel> response =
        speechToTextService.getAcousticModel(getAcousticModelOptionsModel).execute();
    assertNotNull(response);
    AcousticModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAcousticModelPath);
  }

  // Test the getAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getAcousticModel(null).execute();
  }

  @Test
  public void testDeleteAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteAcousticModelPath = "/v1/acoustic_customizations/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAcousticModelOptions model
    DeleteAcousticModelOptions deleteAcousticModelOptionsModel =
        new DeleteAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.deleteAcousticModel(deleteAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAcousticModelPath);
  }

  // Test the deleteAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteAcousticModel(null).execute();
  }

  @Test
  public void testTrainAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"warnings\": [{\"code\": \"invalid_audio_files\", \"message\": \"message\"}]}";
    String trainAcousticModelPath = "/v1/acoustic_customizations/testString/train";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TrainAcousticModelOptions model
    TrainAcousticModelOptions trainAcousticModelOptionsModel =
        new TrainAcousticModelOptions.Builder()
            .customizationId("testString")
            .customLanguageModelId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingResponse> response =
        speechToTextService.trainAcousticModel(trainAcousticModelOptionsModel).execute();
    assertNotNull(response);
    TrainingResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("custom_language_model_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, trainAcousticModelPath);
  }

  // Test the trainAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.trainAcousticModel(null).execute();
  }

  @Test
  public void testResetAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String resetAcousticModelPath = "/v1/acoustic_customizations/testString/reset";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResetAcousticModelOptions model
    ResetAcousticModelOptions resetAcousticModelOptionsModel =
        new ResetAcousticModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.resetAcousticModel(resetAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resetAcousticModelPath);
  }

  // Test the resetAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResetAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.resetAcousticModel(null).execute();
  }

  @Test
  public void testUpgradeAcousticModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String upgradeAcousticModelPath = "/v1/acoustic_customizations/testString/upgrade_model";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpgradeAcousticModelOptions model
    UpgradeAcousticModelOptions upgradeAcousticModelOptionsModel =
        new UpgradeAcousticModelOptions.Builder()
            .customizationId("testString")
            .customLanguageModelId("testString")
            .force(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.upgradeAcousticModel(upgradeAcousticModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("custom_language_model_id"), "testString");
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, upgradeAcousticModelPath);
  }

  // Test the upgradeAcousticModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpgradeAcousticModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.upgradeAcousticModel(null).execute();
  }

  @Test
  public void testListAudioWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"total_minutes_of_audio\": 19, \"audio\": [{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}]}";
    String listAudioPath = "/v1/acoustic_customizations/testString/audio";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAudioOptions model
    ListAudioOptions listAudioOptionsModel =
        new ListAudioOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<AudioResources> response =
        speechToTextService.listAudio(listAudioOptionsModel).execute();
    assertNotNull(response);
    AudioResources responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAudioPath);
  }

  // Test the listAudio operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAudioNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.listAudio(null).execute();
  }

  @Test
  public void testAddAudioWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addAudioPath = "/v1/acoustic_customizations/testString/audio/testString";

    server.enqueue(new MockResponse().setResponseCode(201).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddAudioOptions model
    AddAudioOptions addAudioOptionsModel =
        new AddAudioOptions.Builder()
            .customizationId("testString")
            .audioName("testString")
            .audioResource(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/zip")
            .containedContentType("audio/alaw")
            .allowOverwrite(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.addAudio(addAudioOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("allow_overwrite")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addAudioPath);
  }

  // Test the addAudio operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddAudioNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.addAudio(null).execute();
  }

  @Test
  public void testGetAudioWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\", \"container\": {\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}, \"audio\": [{\"duration\": 8, \"name\": \"name\", \"details\": {\"type\": \"audio\", \"codec\": \"codec\", \"frequency\": 9, \"compression\": \"zip\"}, \"status\": \"ok\"}]}";
    String getAudioPath = "/v1/acoustic_customizations/testString/audio/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAudioOptions model
    GetAudioOptions getAudioOptionsModel =
        new GetAudioOptions.Builder().customizationId("testString").audioName("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<AudioListing> response = speechToTextService.getAudio(getAudioOptionsModel).execute();
    assertNotNull(response);
    AudioListing responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAudioPath);
  }

  // Test the getAudio operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAudioNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.getAudio(null).execute();
  }

  @Test
  public void testDeleteAudioWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteAudioPath = "/v1/acoustic_customizations/testString/audio/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAudioOptions model
    DeleteAudioOptions deleteAudioOptionsModel =
        new DeleteAudioOptions.Builder()
            .customizationId("testString")
            .audioName("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = speechToTextService.deleteAudio(deleteAudioOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAudioPath);
  }

  // Test the deleteAudio operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAudioNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteAudio(null).execute();
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        speechToTextService.deleteUserData(deleteUserDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("customer_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteUserDataPath);
  }

  // Test the deleteUserData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    speechToTextService.deleteUserData(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
      server = new MockWebServer();
      // register handler
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    speechToTextService = null;
  }
}
