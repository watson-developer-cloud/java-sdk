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
package com.ibm.watson.text_to_speech.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CustomModel;
import com.ibm.watson.text_to_speech.v1.model.CustomModels;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoicesOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
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

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();

    textToSpeechService = new TextToSpeech(serviceName, authenticator);
    String url = server.url("/").toString();
    textToSpeechService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new TextToSpeech(serviceName, null);
  }

  @Test
  public void testListVoicesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"voices\": [{\"url\": \"url\", \"gender\": \"gender\", \"name\": \"name\", \"language\": \"language\", \"description\": \"description\", \"customizable\": true, \"supported_features\": {\"custom_pronunciation\": false, \"voice_transformation\": false}, \"customization\": {\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}}]}";
    String listVoicesPath = "/v1/voices";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListVoicesOptions model
    ListVoicesOptions listVoicesOptionsModel = new ListVoicesOptions();

    // Invoke operation with valid options model (positive test)
    Response<Voices> response = textToSpeechService.listVoices(listVoicesOptionsModel).execute();
    assertNotNull(response);
    Voices responseObj = response.getResult();
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
    assertEquals(parsedPath, listVoicesPath);
  }

  @Test
  public void testGetVoiceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"url\": \"url\", \"gender\": \"gender\", \"name\": \"name\", \"language\": \"language\", \"description\": \"description\", \"customizable\": true, \"supported_features\": {\"custom_pronunciation\": false, \"voice_transformation\": false}, \"customization\": {\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}}";
    String getVoicePath = "/v1/voices/ar-AR_OmarVoice";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVoiceOptions model
    GetVoiceOptions getVoiceOptionsModel =
        new GetVoiceOptions.Builder()
            .voice("ar-AR_OmarVoice")
            .customizationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Voice> response = textToSpeechService.getVoice(getVoiceOptionsModel).execute();
    assertNotNull(response);
    Voice responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("customization_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVoicePath);
  }

  // Test the getVoice operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVoiceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.getVoice(null).execute();
  }

  @Test
  public void testSynthesizeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String synthesizePath = "/v1/synthesize";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "audio/basic")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SynthesizeOptions model
    SynthesizeOptions synthesizeOptionsModel =
        new SynthesizeOptions.Builder()
            .text("testString")
            .accept("audio/basic")
            .voice("ar-AR_OmarVoice")
            .customizationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        textToSpeechService.synthesize(synthesizeOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("voice"), "ar-AR_OmarVoice");
    assertEquals(query.get("customization_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, synthesizePath);
  }

  // Test the synthesize operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSynthesizeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.synthesize(null).execute();
  }

  @Test
  public void testGetPronunciationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"pronunciation\": \"pronunciation\"}";
    String getPronunciationPath = "/v1/pronunciation";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPronunciationOptions model
    GetPronunciationOptions getPronunciationOptionsModel =
        new GetPronunciationOptions.Builder()
            .text("testString")
            .voice("ar-AR_OmarVoice")
            .format("ibm")
            .customizationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Pronunciation> response =
        textToSpeechService.getPronunciation(getPronunciationOptionsModel).execute();
    assertNotNull(response);
    Pronunciation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("text"), "testString");
    assertEquals(query.get("voice"), "ar-AR_OmarVoice");
    assertEquals(query.get("format"), "ibm");
    assertEquals(query.get("customization_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPronunciationPath);
  }

  // Test the getPronunciation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPronunciationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.getPronunciation(null).execute();
  }

  @Test
  public void testCreateCustomModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}";
    String createCustomModelPath = "/v1/customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateCustomModelOptions model
    CreateCustomModelOptions createCustomModelOptionsModel =
        new CreateCustomModelOptions.Builder()
            .name("testString")
            .language("de-DE")
            .description("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CustomModel> response =
        textToSpeechService.createCustomModel(createCustomModelOptionsModel).execute();
    assertNotNull(response);
    CustomModel responseObj = response.getResult();
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
    assertEquals(parsedPath, createCustomModelPath);
  }

  // Test the createCustomModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.createCustomModel(null).execute();
  }

  @Test
  public void testListCustomModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customizations\": [{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}]}";
    String listCustomModelsPath = "/v1/customizations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCustomModelsOptions model
    ListCustomModelsOptions listCustomModelsOptionsModel =
        new ListCustomModelsOptions.Builder().language("de-DE").build();

    // Invoke operation with valid options model (positive test)
    Response<CustomModels> response =
        textToSpeechService.listCustomModels(listCustomModelsOptionsModel).execute();
    assertNotNull(response);
    CustomModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("language"), "de-DE");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCustomModelsPath);
  }

  @Test
  public void testUpdateCustomModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateCustomModelPath = "/v1/customizations/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        textToSpeechService.updateCustomModel(updateCustomModelOptionsModel).execute();
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
    assertEquals(parsedPath, updateCustomModelPath);
  }

  // Test the updateCustomModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCustomModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.updateCustomModel(null).execute();
  }

  @Test
  public void testGetCustomModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"customization_id\": \"customizationId\", \"name\": \"name\", \"language\": \"language\", \"owner\": \"owner\", \"created\": \"created\", \"last_modified\": \"lastModified\", \"description\": \"description\", \"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}";
    String getCustomModelPath = "/v1/customizations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCustomModelOptions model
    GetCustomModelOptions getCustomModelOptionsModel =
        new GetCustomModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<CustomModel> response =
        textToSpeechService.getCustomModel(getCustomModelOptionsModel).execute();
    assertNotNull(response);
    CustomModel responseObj = response.getResult();
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
    assertEquals(parsedPath, getCustomModelPath);
  }

  // Test the getCustomModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCustomModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.getCustomModel(null).execute();
  }

  @Test
  public void testDeleteCustomModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCustomModelPath = "/v1/customizations/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCustomModelOptions model
    DeleteCustomModelOptions deleteCustomModelOptionsModel =
        new DeleteCustomModelOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        textToSpeechService.deleteCustomModel(deleteCustomModelOptionsModel).execute();
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
    assertEquals(parsedPath, deleteCustomModelPath);
  }

  // Test the deleteCustomModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCustomModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.deleteCustomModel(null).execute();
  }

  @Test
  public void testAddWordsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addWordsPath = "/v1/customizations/testString/words";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<Void> response = textToSpeechService.addWords(addWordsOptionsModel).execute();
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
    textToSpeechService.addWords(null).execute();
  }

  @Test
  public void testListWordsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"words\": [{\"word\": \"word\", \"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}]}";
    String listWordsPath = "/v1/customizations/testString/words";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListWordsOptions model
    ListWordsOptions listWordsOptionsModel =
        new ListWordsOptions.Builder().customizationId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Words> response = textToSpeechService.listWords(listWordsOptionsModel).execute();
    assertNotNull(response);
    Words responseObj = response.getResult();
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
    assertEquals(parsedPath, listWordsPath);
  }

  // Test the listWords operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListWordsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    textToSpeechService.listWords(null).execute();
  }

  @Test
  public void testAddWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String addWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddWordOptions model
    AddWordOptions addWordOptionsModel =
        new AddWordOptions.Builder()
            .customizationId("testString")
            .word("testString")
            .translation("testString")
            .partOfSpeech("Dosi")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = textToSpeechService.addWord(addWordOptionsModel).execute();
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
    textToSpeechService.addWord(null).execute();
  }

  @Test
  public void testGetWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"translation\": \"translation\", \"part_of_speech\": \"Dosi\"}";
    String getWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetWordOptions model
    GetWordOptions getWordOptionsModel =
        new GetWordOptions.Builder().customizationId("testString").word("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Translation> response = textToSpeechService.getWord(getWordOptionsModel).execute();
    assertNotNull(response);
    Translation responseObj = response.getResult();
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
    textToSpeechService.getWord(null).execute();
  }

  @Test
  public void testDeleteWordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteWordPath = "/v1/customizations/testString/words/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteWordOptions model
    DeleteWordOptions deleteWordOptionsModel =
        new DeleteWordOptions.Builder().customizationId("testString").word("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = textToSpeechService.deleteWord(deleteWordOptionsModel).execute();
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
    textToSpeechService.deleteWord(null).execute();
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
        textToSpeechService.deleteUserData(deleteUserDataOptionsModel).execute();
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
    textToSpeechService.deleteUserData(null).execute();
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
    textToSpeechService = null;
  }
}
