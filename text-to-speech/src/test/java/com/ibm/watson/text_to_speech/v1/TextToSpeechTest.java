/*
 * (C) Copyright IBM Corp. 2019, 2022.
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
package com.ibm.watson.text_to_speech.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.text_to_speech.v1.model.AddCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CustomModel;
import com.ibm.watson.text_to_speech.v1.model.CustomModels;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomPromptsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListSpeakerModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoicesOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.Prompt;
import com.ibm.watson.text_to_speech.v1.model.PromptMetadata;
import com.ibm.watson.text_to_speech.v1.model.Prompts;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.text_to_speech.v1.model.SpeakerCustomModels;
import com.ibm.watson.text_to_speech.v1.model.SpeakerModel;
import com.ibm.watson.text_to_speech.v1.model.Speakers;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.model.Word;
import com.ibm.watson.text_to_speech.v1.model.Words;
import com.ibm.watson.text_to_speech.v1.utils.TestUtilities;
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

/** Unit test class for the TextToSpeech service. */
public class TextToSpeechTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected TextToSpeech textToSpeechService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new TextToSpeech(serviceName, null);
  }

  // Test the listVoices operation with a valid options model parameter
  @Test
  public void testListVoicesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"voices\": [{\"url\": \"url\", \"gender\": \"gender\", \"name\": \"name\", \"language\": \"language\", \"description\": \"description\", \"customizable\": true, \"supported_features\": {\"custom_pronunciation\": false, \"voice_transformation\": false}, \"customization\": {\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}], \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}}]}";
    String listVoicesPath = "/v1/voices";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListVoicesOptions model
    ListVoicesOptions listVoicesOptionsModel = new ListVoicesOptions();

    // Invoke listVoices() with a valid options model and verify the result
    Response<Voices> response = textToSpeechService.listVoices(listVoicesOptionsModel).execute();
    assertNotNull(response);
    Voices responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listVoicesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listVoices operation with and without retries enabled
  @Test
  public void testListVoicesWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testListVoicesWOptions();

    textToSpeechService.disableRetries();
    testListVoicesWOptions();
  }

  // Test the getVoice operation with a valid options model parameter
  @Test
  public void testGetVoiceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"url\": \"url\", \"gender\": \"gender\", \"name\": \"name\", \"language\": \"language\", \"description\": \"description\", \"customizable\": true, \"supported_features\": {\"custom_pronunciation\": false, \"voice_transformation\": false}, \"customization\": {\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}], \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}}";
    String getVoicePath = "/v1/voices/ar-AR_OmarVoice";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetVoiceOptions model
    GetVoiceOptions getVoiceOptionsModel =
        new GetVoiceOptions.Builder()
            .voice("ar-AR_OmarVoice")
            .customizationId("testString")
            .build();

    // Invoke getVoice() with a valid options model and verify the result
    Response<Voice> response = textToSpeechService.getVoice(getVoiceOptionsModel).execute();
    assertNotNull(response);
    Voice responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVoicePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("customization_id"), "testString");
  }

  // Test the getVoice operation with and without retries enabled
  @Test
  public void testGetVoiceWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testGetVoiceWOptions();

    textToSpeechService.disableRetries();
    testGetVoiceWOptions();
  }

  // Test the getVoice operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVoiceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getVoice(null).execute();
  }

  // Test the synthesize operation with a valid options model parameter
  @Test
  public void testSynthesizeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String synthesizePath = "/v1/synthesize";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "audio/basic")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the SynthesizeOptions model
    SynthesizeOptions synthesizeOptionsModel =
        new SynthesizeOptions.Builder()
            .text("testString")
            .accept("audio/ogg;codecs=opus")
            .voice("en-US_MichaelV3Voice")
            .customizationId("testString")
            .build();

    // Invoke synthesize() with a valid options model and verify the result
    Response<InputStream> response =
        textToSpeechService.synthesize(synthesizeOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);
    responseObj.close();

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, synthesizePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("voice"), "en-US_MichaelV3Voice");
    assertEquals(query.get("customization_id"), "testString");
  }

  // Test the synthesize operation with and without retries enabled
  @Test
  public void testSynthesizeWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testSynthesizeWOptions();

    textToSpeechService.disableRetries();
    testSynthesizeWOptions();
  }

  // Test the synthesize operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSynthesizeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.synthesize(null).execute();
  }

  // Test the getPronunciation operation with a valid options model parameter
  @Test
  public void testGetPronunciationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"pronunciation\": \"pronunciation\"}";
    String getPronunciationPath = "/v1/pronunciation";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetPronunciationOptions model
    GetPronunciationOptions getPronunciationOptionsModel =
        new GetPronunciationOptions.Builder()
            .text("testString")
            .voice("en-US_MichaelV3Voice")
            .format("ipa")
            .customizationId("testString")
            .build();

    // Invoke getPronunciation() with a valid options model and verify the result
    Response<Pronunciation> response =
        textToSpeechService.getPronunciation(getPronunciationOptionsModel).execute();
    assertNotNull(response);
    Pronunciation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPronunciationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("text"), "testString");
    assertEquals(query.get("voice"), "en-US_MichaelV3Voice");
    assertEquals(query.get("format"), "ipa");
    assertEquals(query.get("customization_id"), "testString");
  }

  // Test the getPronunciation operation with and without retries enabled
  @Test
  public void testGetPronunciationWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testGetPronunciationWOptions();

    textToSpeechService.disableRetries();
    testGetPronunciationWOptions();
  }

  // Test the getPronunciation operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPronunciationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getPronunciation(null).execute();
  }

  // Test the createCustomModel operation with a valid options model parameter
  @Test
  public void testCreateCustomModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}], \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}";
    String createCustomModelPath = "/v1/customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateCustomModelOptions model
    CreateCustomModelOptions createCustomModelOptionsModel =
        new CreateCustomModelOptions.Builder()
            .name("testString")
            .language("en-US")
            .description("testString")
            .build();

    // Invoke createCustomModel() with a valid options model and verify the result
    Response<CustomModel> response =
        textToSpeechService.createCustomModel(createCustomModelOptionsModel).execute();
    assertNotNull(response);
    CustomModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCustomModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createCustomModel operation with and without retries enabled
  @Test
  public void testCreateCustomModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testCreateCustomModelWOptions();

    textToSpeechService.disableRetries();
    testCreateCustomModelWOptions();
  }

  // Test the createCustomModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.createCustomModel(null).execute();
  }

  // Test the listCustomModels operation with a valid options model parameter
  @Test
  public void testListCustomModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}], \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}]}";
    String listCustomModelsPath = "/v1/customizations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCustomModelsOptions model
    ListCustomModelsOptions listCustomModelsOptionsModel =
        new ListCustomModelsOptions.Builder().language("ar-MS").build();

    // Invoke listCustomModels() with a valid options model and verify the result
    Response<CustomModels> response =
        textToSpeechService.listCustomModels(listCustomModelsOptionsModel).execute();
    assertNotNull(response);
    CustomModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCustomModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("language"), "ar-MS");
  }

  // Test the listCustomModels operation with and without retries enabled
  @Test
  public void testListCustomModelsWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testListCustomModelsWOptions();

    textToSpeechService.disableRetries();
    testListCustomModelsWOptions();
  }

  // Test the updateCustomModel operation with a valid options model parameter
  @Test
  public void testUpdateCustomModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateCustomModelPath = "/v1/customizations/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the Word model
    Word wordModel =
        new Word.Builder()
            .word("testString")
            .translation("testString")
            .partOfSpeech("Dosi")
            .build();

    // Construct an instance of the UpdateCustomModelOptions model
    UpdateCustomModelOptions updateCustomModelOptionsModel =
        new UpdateCustomModelOptions.Builder()
            .customizationId("testString")
            .name("testString")
            .description("testString")
            .words(new java.util.ArrayList<Word>(java.util.Arrays.asList(wordModel)))
            .build();

    // Invoke updateCustomModel() with a valid options model and verify the result
    Response<Void> response =
        textToSpeechService.updateCustomModel(updateCustomModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCustomModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateCustomModel operation with and without retries enabled
  @Test
  public void testUpdateCustomModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testUpdateCustomModelWOptions();

    textToSpeechService.disableRetries();
    testUpdateCustomModelWOptions();
  }

  // Test the updateCustomModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCustomModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.updateCustomModel(null).execute();
  }

  // Test the getCustomModel operation with a valid options model parameter
  @Test
  public void testGetCustomModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}], \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}";
    String getCustomModelPath = "/v1/customizations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCustomModelOptions model
    GetCustomModelOptions getCustomModelOptionsModel =
        new GetCustomModelOptions.Builder().customizationId("testString").build();

    // Invoke getCustomModel() with a valid options model and verify the result
    Response<CustomModel> response =
        textToSpeechService.getCustomModel(getCustomModelOptionsModel).execute();
    assertNotNull(response);
    CustomModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCustomModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCustomModel operation with and without retries enabled
  @Test
  public void testGetCustomModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testGetCustomModelWOptions();

    textToSpeechService.disableRetries();
    testGetCustomModelWOptions();
  }

  // Test the getCustomModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCustomModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getCustomModel(null).execute();
  }

  // Test the deleteCustomModel operation with a valid options model parameter
  @Test
  public void testDeleteCustomModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCustomModelPath = "/v1/customizations/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomModelOptions model
    DeleteCustomModelOptions deleteCustomModelOptionsModel =
        new DeleteCustomModelOptions.Builder().customizationId("testString").build();

    // Invoke deleteCustomModel() with a valid options model and verify the result
    Response<Void> response =
        textToSpeechService.deleteCustomModel(deleteCustomModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteCustomModel operation with and without retries enabled
  @Test
  public void testDeleteCustomModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testDeleteCustomModelWOptions();

    textToSpeechService.disableRetries();
    testDeleteCustomModelWOptions();
  }

  // Test the deleteCustomModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.deleteCustomModel(null).execute();
  }

  // Test the addWords operation with a valid options model parameter
  @Test
  public void testAddWordsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addWordsPath = "/v1/customizations/testString/words";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the Word model
    Word wordModel =
        new Word.Builder()
            .word("testString")
            .translation("testString")
            .partOfSpeech("Dosi")
            .build();

    // Construct an instance of the AddWordsOptions model
    AddWordsOptions addWordsOptionsModel =
        new AddWordsOptions.Builder()
            .customizationId("testString")
            .words(new java.util.ArrayList<Word>(java.util.Arrays.asList(wordModel)))
            .build();

    // Invoke addWords() with a valid options model and verify the result
    Response<Void> response = textToSpeechService.addWords(addWordsOptionsModel).execute();
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
    textToSpeechService.enableRetries(4, 30);
    testAddWordsWOptions();

    textToSpeechService.disableRetries();
    testAddWordsWOptions();
  }

  // Test the addWords operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.addWords(null).execute();
  }

  // Test the listWords operation with a valid options model parameter
  @Test
  public void testListWordsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}";
    String listWordsPath = "/v1/customizations/testString/words";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListWordsOptions model
    ListWordsOptions listWordsOptionsModel =
        new ListWordsOptions.Builder().customizationId("testString").build();

    // Invoke listWords() with a valid options model and verify the result
    Response<Words> response = textToSpeechService.listWords(listWordsOptionsModel).execute();
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listWords operation with and without retries enabled
  @Test
  public void testListWordsWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testListWordsWOptions();

    textToSpeechService.disableRetries();
    testListWordsWOptions();
  }

  // Test the listWords operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListWordsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.listWords(null).execute();
  }

  // Test the addWord operation with a valid options model parameter
  @Test
  public void testAddWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String addWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the AddWordOptions model
    AddWordOptions addWordOptionsModel =
        new AddWordOptions.Builder()
            .customizationId("testString")
            .word("testString")
            .translation("testString")
            .partOfSpeech("Dosi")
            .build();

    // Invoke addWord() with a valid options model and verify the result
    Response<Void> response = textToSpeechService.addWord(addWordOptionsModel).execute();
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
    textToSpeechService.enableRetries(4, 30);
    testAddWordWOptions();

    textToSpeechService.disableRetries();
    testAddWordWOptions();
  }

  // Test the addWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.addWord(null).execute();
  }

  // Test the getWord operation with a valid options model parameter
  @Test
  public void testGetWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}";
    String getWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetWordOptions model
    GetWordOptions getWordOptionsModel =
        new GetWordOptions.Builder().customizationId("testString").word("testString").build();

    // Invoke getWord() with a valid options model and verify the result
    Response<Translation> response = textToSpeechService.getWord(getWordOptionsModel).execute();
    assertNotNull(response);
    Translation responseObj = response.getResult();
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
    textToSpeechService.enableRetries(4, 30);
    testGetWordWOptions();

    textToSpeechService.disableRetries();
    testGetWordWOptions();
  }

  // Test the getWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getWord(null).execute();
  }

  // Test the deleteWord operation with a valid options model parameter
  @Test
  public void testDeleteWordWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteWordPath = "/v1/customizations/testString/words/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteWordOptions model
    DeleteWordOptions deleteWordOptionsModel =
        new DeleteWordOptions.Builder().customizationId("testString").word("testString").build();

    // Invoke deleteWord() with a valid options model and verify the result
    Response<Void> response = textToSpeechService.deleteWord(deleteWordOptionsModel).execute();
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
    textToSpeechService.enableRetries(4, 30);
    testDeleteWordWOptions();

    textToSpeechService.disableRetries();
    testDeleteWordWOptions();
  }

  // Test the deleteWord operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteWordNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.deleteWord(null).execute();
  }

  // Test the listCustomPrompts operation with a valid options model parameter
  @Test
  public void testListCustomPromptsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}]}";
    String listCustomPromptsPath = "/v1/customizations/testString/prompts";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCustomPromptsOptions model
    ListCustomPromptsOptions listCustomPromptsOptionsModel =
        new ListCustomPromptsOptions.Builder().customizationId("testString").build();

    // Invoke listCustomPrompts() with a valid options model and verify the result
    Response<Prompts> response =
        textToSpeechService.listCustomPrompts(listCustomPromptsOptionsModel).execute();
    assertNotNull(response);
    Prompts responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCustomPromptsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listCustomPrompts operation with and without retries enabled
  @Test
  public void testListCustomPromptsWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testListCustomPromptsWOptions();

    textToSpeechService.disableRetries();
    testListCustomPromptsWOptions();
  }

  // Test the listCustomPrompts operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCustomPromptsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.listCustomPrompts(null).execute();
  }

  // Test the addCustomPrompt operation with a valid options model parameter
  @Test
  public void testAddCustomPromptWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}";
    String addCustomPromptPath = "/v1/customizations/testString/prompts/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the PromptMetadata model
    PromptMetadata promptMetadataModel =
        new PromptMetadata.Builder().promptText("testString").speakerId("testString").build();

    // Construct an instance of the AddCustomPromptOptions model
    AddCustomPromptOptions addCustomPromptOptionsModel =
        new AddCustomPromptOptions.Builder()
            .customizationId("testString")
            .promptId("testString")
            .metadata(promptMetadataModel)
            .file(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke addCustomPrompt() with a valid options model and verify the result
    Response<Prompt> response =
        textToSpeechService.addCustomPrompt(addCustomPromptOptionsModel).execute();
    assertNotNull(response);
    Prompt responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addCustomPromptPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addCustomPrompt operation with and without retries enabled
  @Test
  public void testAddCustomPromptWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testAddCustomPromptWOptions();

    textToSpeechService.disableRetries();
    testAddCustomPromptWOptions();
  }

  // Test the addCustomPrompt operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCustomPromptNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.addCustomPrompt(null).execute();
  }

  // Test the getCustomPrompt operation with a valid options model parameter
  @Test
  public void testGetCustomPromptWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\", \"speaker_id\": \"speakerId\"}";
    String getCustomPromptPath = "/v1/customizations/testString/prompts/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCustomPromptOptions model
    GetCustomPromptOptions getCustomPromptOptionsModel =
        new GetCustomPromptOptions.Builder()
            .customizationId("testString")
            .promptId("testString")
            .build();

    // Invoke getCustomPrompt() with a valid options model and verify the result
    Response<Prompt> response =
        textToSpeechService.getCustomPrompt(getCustomPromptOptionsModel).execute();
    assertNotNull(response);
    Prompt responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCustomPromptPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCustomPrompt operation with and without retries enabled
  @Test
  public void testGetCustomPromptWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testGetCustomPromptWOptions();

    textToSpeechService.disableRetries();
    testGetCustomPromptWOptions();
  }

  // Test the getCustomPrompt operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCustomPromptNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getCustomPrompt(null).execute();
  }

  // Test the deleteCustomPrompt operation with a valid options model parameter
  @Test
  public void testDeleteCustomPromptWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCustomPromptPath = "/v1/customizations/testString/prompts/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteCustomPromptOptions model
    DeleteCustomPromptOptions deleteCustomPromptOptionsModel =
        new DeleteCustomPromptOptions.Builder()
            .customizationId("testString")
            .promptId("testString")
            .build();

    // Invoke deleteCustomPrompt() with a valid options model and verify the result
    Response<Void> response =
        textToSpeechService.deleteCustomPrompt(deleteCustomPromptOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCustomPromptPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteCustomPrompt operation with and without retries enabled
  @Test
  public void testDeleteCustomPromptWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testDeleteCustomPromptWOptions();

    textToSpeechService.disableRetries();
    testDeleteCustomPromptWOptions();
  }

  // Test the deleteCustomPrompt operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomPromptNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.deleteCustomPrompt(null).execute();
  }

  // Test the listSpeakerModels operation with a valid options model parameter
  @Test
  public void testListSpeakerModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"speakers\": [{\"speaker_id\": \"speakerId\", \"name\": \"name\"}]}";
    String listSpeakerModelsPath = "/v1/speakers";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListSpeakerModelsOptions model
    ListSpeakerModelsOptions listSpeakerModelsOptionsModel = new ListSpeakerModelsOptions();

    // Invoke listSpeakerModels() with a valid options model and verify the result
    Response<Speakers> response =
        textToSpeechService.listSpeakerModels(listSpeakerModelsOptionsModel).execute();
    assertNotNull(response);
    Speakers responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSpeakerModelsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listSpeakerModels operation with and without retries enabled
  @Test
  public void testListSpeakerModelsWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testListSpeakerModelsWOptions();

    textToSpeechService.disableRetries();
    testListSpeakerModelsWOptions();
  }

  // Test the createSpeakerModel operation with a valid options model parameter
  @Test
  public void testCreateSpeakerModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"speaker_id\": \"speakerId\"}";
    String createSpeakerModelPath = "/v1/speakers";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateSpeakerModelOptions model
    CreateSpeakerModelOptions createSpeakerModelOptionsModel =
        new CreateSpeakerModelOptions.Builder()
            .speakerName("testString")
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke createSpeakerModel() with a valid options model and verify the result
    Response<SpeakerModel> response =
        textToSpeechService.createSpeakerModel(createSpeakerModelOptionsModel).execute();
    assertNotNull(response);
    SpeakerModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSpeakerModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("speaker_name"), "testString");
  }

  // Test the createSpeakerModel operation with and without retries enabled
  @Test
  public void testCreateSpeakerModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testCreateSpeakerModelWOptions();

    textToSpeechService.disableRetries();
    testCreateSpeakerModelWOptions();
  }

  // Test the createSpeakerModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSpeakerModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.createSpeakerModel(null).execute();
  }

  // Test the getSpeakerModel operation with a valid options model parameter
  @Test
  public void testGetSpeakerModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"prompts\": [{\"prompt\": \"prompt\", \"prompt_id\": \"promptId\", \"status\": \"status\", \"error\": \"error\"}]}]}";
    String getSpeakerModelPath = "/v1/speakers/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetSpeakerModelOptions model
    GetSpeakerModelOptions getSpeakerModelOptionsModel =
        new GetSpeakerModelOptions.Builder().speakerId("testString").build();

    // Invoke getSpeakerModel() with a valid options model and verify the result
    Response<SpeakerCustomModels> response =
        textToSpeechService.getSpeakerModel(getSpeakerModelOptionsModel).execute();
    assertNotNull(response);
    SpeakerCustomModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSpeakerModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSpeakerModel operation with and without retries enabled
  @Test
  public void testGetSpeakerModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testGetSpeakerModelWOptions();

    textToSpeechService.disableRetries();
    testGetSpeakerModelWOptions();
  }

  // Test the getSpeakerModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSpeakerModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.getSpeakerModel(null).execute();
  }

  // Test the deleteSpeakerModel operation with a valid options model parameter
  @Test
  public void testDeleteSpeakerModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSpeakerModelPath = "/v1/speakers/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteSpeakerModelOptions model
    DeleteSpeakerModelOptions deleteSpeakerModelOptionsModel =
        new DeleteSpeakerModelOptions.Builder().speakerId("testString").build();

    // Invoke deleteSpeakerModel() with a valid options model and verify the result
    Response<Void> response =
        textToSpeechService.deleteSpeakerModel(deleteSpeakerModelOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSpeakerModelPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteSpeakerModel operation with and without retries enabled
  @Test
  public void testDeleteSpeakerModelWRetries() throws Throwable {
    textToSpeechService.enableRetries(4, 30);
    testDeleteSpeakerModelWOptions();

    textToSpeechService.disableRetries();
    testDeleteSpeakerModelWOptions();
  }

  // Test the deleteSpeakerModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSpeakerModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.deleteSpeakerModel(null).execute();
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
        textToSpeechService.deleteUserData(deleteUserDataOptionsModel).execute();
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
    textToSpeechService.enableRetries(4, 30);
    testDeleteUserDataWOptions();

    textToSpeechService.disableRetries();
    testDeleteUserDataWOptions();
  }

  // Test the deleteUserData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    textToSpeechService.deleteUserData(null).execute();
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
    textToSpeechService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();
    textToSpeechService = new TextToSpeech(serviceName, authenticator);
    String url = server.url("/").toString();
    textToSpeechService.setServiceUrl(url);
  }
}
