/*
 * (C) Copyright IBM Corp. 2019, 2021.
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
package com.ibm.watson.tone_analyzer.v3;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.tone_analyzer.v3.model.ToneInput;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.tone_analyzer.v3.model.Utterance;
import com.ibm.watson.tone_analyzer.v3.model.UtteranceAnalyses;
import com.ibm.watson.tone_analyzer.v3.utils.TestUtilities;
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

/** Unit test class for the ToneAnalyzer service. */
public class ToneAnalyzerTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ToneAnalyzer toneAnalyzerService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    toneAnalyzerService = new ToneAnalyzer(version, serviceName, authenticator);
    String url = server.url("/").toString();
    toneAnalyzerService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new ToneAnalyzer(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(toneAnalyzerService.getVersion(), "testString");
  }

  @Test
  public void testToneWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_tone\": {\"tones\": [{\"score\": 5, \"tone_id\": \"toneId\", \"tone_name\": \"toneName\"}], \"tone_categories\": [{\"tones\": [{\"score\": 5, \"tone_id\": \"toneId\", \"tone_name\": \"toneName\"}], \"category_id\": \"categoryId\", \"category_name\": \"categoryName\"}], \"warning\": \"warning\"}, \"sentences_tone\": [{\"sentence_id\": 10, \"text\": \"text\", \"tones\": [{\"score\": 5, \"tone_id\": \"toneId\", \"tone_name\": \"toneName\"}], \"tone_categories\": [{\"tones\": [{\"score\": 5, \"tone_id\": \"toneId\", \"tone_name\": \"toneName\"}], \"category_id\": \"categoryId\", \"category_name\": \"categoryName\"}], \"input_from\": 9, \"input_to\": 7}]}";
    String tonePath = "/v3/tone";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ToneInput model
    ToneInput toneInputModel = new ToneInput.Builder().text("testString").build();

    // Construct an instance of the ToneOptions model
    ToneOptions toneOptionsModel =
        new ToneOptions.Builder()
            .toneInput(toneInputModel)
            .sentences(true)
            .tones(new java.util.ArrayList<String>(java.util.Arrays.asList("emotion")))
            .contentLanguage("en")
            .acceptLanguage("en")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ToneAnalysis> response = toneAnalyzerService.tone(toneOptionsModel).execute();
    assertNotNull(response);
    ToneAnalysis responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("sentences")), Boolean.valueOf(true));
    assertEquals(
        query.get("tones"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("emotion")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, tonePath);
  }

  // Test the tone operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testToneNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    toneAnalyzerService.tone(null).execute();
  }

  @Test
  public void testToneChatWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"utterances_tone\": [{\"utterance_id\": 11, \"utterance_text\": \"utteranceText\", \"tones\": [{\"score\": 5, \"tone_id\": \"excited\", \"tone_name\": \"toneName\"}], \"error\": \"error\"}], \"warning\": \"warning\"}";
    String toneChatPath = "/v3/tone_chat";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Utterance model
    Utterance utteranceModel =
        new Utterance.Builder().text("testString").user("testString").build();

    // Construct an instance of the ToneChatOptions model
    ToneChatOptions toneChatOptionsModel =
        new ToneChatOptions.Builder()
            .utterances(new java.util.ArrayList<Utterance>(java.util.Arrays.asList(utteranceModel)))
            .contentLanguage("en")
            .acceptLanguage("en")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<UtteranceAnalyses> response =
        toneAnalyzerService.toneChat(toneChatOptionsModel).execute();
    assertNotNull(response);
    UtteranceAnalyses responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, toneChatPath);
  }

  // Test the toneChat operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testToneChatNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    toneAnalyzerService.toneChat(null).execute();
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
    toneAnalyzerService = null;
  }
}
