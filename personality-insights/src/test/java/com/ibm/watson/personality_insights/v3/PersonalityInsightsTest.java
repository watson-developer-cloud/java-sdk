/*
 * (C) Copyright IBM Corp. 2016, 2021.
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
package com.ibm.watson.personality_insights.v3;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.personality_insights.v3.model.Content;
import com.ibm.watson.personality_insights.v3.model.ContentItem;
import com.ibm.watson.personality_insights.v3.model.Profile;
import com.ibm.watson.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.personality_insights.v3.utils.TestUtilities;
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

/** Unit test class for the PersonalityInsights service. */
public class PersonalityInsightsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PersonalityInsights personalityInsightsService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    personalityInsightsService = new PersonalityInsights(version, serviceName, authenticator);
    String url = server.url("/").toString();
    personalityInsightsService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new PersonalityInsights(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(personalityInsightsService.getVersion(), "testString");
  }

  @Test
  public void testProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"processed_language\": \"ar\", \"word_count\": 9, \"word_count_message\": \"wordCountMessage\", \"personality\": [{\"trait_id\": \"traitId\", \"name\": \"name\", \"category\": \"personality\", \"percentile\": 10, \"raw_score\": 8, \"significant\": false}], \"needs\": [{\"trait_id\": \"traitId\", \"name\": \"name\", \"category\": \"personality\", \"percentile\": 10, \"raw_score\": 8, \"significant\": false}], \"values\": [{\"trait_id\": \"traitId\", \"name\": \"name\", \"category\": \"personality\", \"percentile\": 10, \"raw_score\": 8, \"significant\": false}], \"behavior\": [{\"trait_id\": \"traitId\", \"name\": \"name\", \"category\": \"category\", \"percentage\": 10}], \"consumption_preferences\": [{\"consumption_preference_category_id\": \"consumptionPreferenceCategoryId\", \"name\": \"name\", \"consumption_preferences\": [{\"consumption_preference_id\": \"consumptionPreferenceId\", \"name\": \"name\", \"score\": 0.0}]}], \"warnings\": [{\"warning_id\": \"WORD_COUNT_MESSAGE\", \"message\": \"message\"}]}";
    String profilePath = "/v3/profile";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ContentItem model
    ContentItem contentItemModel =
        new ContentItem.Builder()
            .content("testString")
            .id("testString")
            .created(Long.valueOf("26"))
            .updated(Long.valueOf("26"))
            .contenttype("text/plain")
            .language("en")
            .parentid("testString")
            .reply(false)
            .forward(false)
            .build();

    // Construct an instance of the Content model
    Content contentModel =
        new Content.Builder()
            .contentItems(
                new java.util.ArrayList<ContentItem>(java.util.Arrays.asList(contentItemModel)))
            .build();

    // Construct an instance of the ProfileOptions model
    ProfileOptions profileOptionsModel =
        new ProfileOptions.Builder()
            .content(contentModel)
            .contentLanguage("en")
            .acceptLanguage("en")
            .rawScores(false)
            .csvHeaders(false)
            .consumptionPreferences(false)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Profile> response = personalityInsightsService.profile(profileOptionsModel).execute();
    assertNotNull(response);
    Profile responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("raw_scores")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("csv_headers")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("consumption_preferences")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, profilePath);
  }

  // Test the profile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    personalityInsightsService.profile(null).execute();
  }

  @Test
  public void testProfileAsCsvWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "\"operationResponse\"";
    String profileAsCsvPath = "/v3/profile";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "text/csv")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ContentItem model
    ContentItem contentItemModel =
        new ContentItem.Builder()
            .content("testString")
            .id("testString")
            .created(Long.valueOf("26"))
            .updated(Long.valueOf("26"))
            .contenttype("text/plain")
            .language("en")
            .parentid("testString")
            .reply(false)
            .forward(false)
            .build();

    // Construct an instance of the Content model
    Content contentModel =
        new Content.Builder()
            .contentItems(
                new java.util.ArrayList<ContentItem>(java.util.Arrays.asList(contentItemModel)))
            .build();

    // Construct an instance of the ProfileOptions model
    ProfileOptions profileOptionsModel =
        new ProfileOptions.Builder()
            .content(contentModel)
            .contentLanguage("en")
            .acceptLanguage("en")
            .rawScores(false)
            .csvHeaders(false)
            .consumptionPreferences(false)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        personalityInsightsService.profileAsCsv(profileOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("raw_scores")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("csv_headers")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("consumption_preferences")), Boolean.valueOf(false));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, profileAsCsvPath);
  }

  // Test the profileAsCsv operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testProfileAsCsvNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    personalityInsightsService.profileAsCsv(null).execute();
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
    personalityInsightsService = null;
  }
}
