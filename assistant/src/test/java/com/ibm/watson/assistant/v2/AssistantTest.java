/*
 * (C) Copyright IBM Corp. 2019, 2024.
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
package com.ibm.watson.assistant.v2;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.model.AssistantCollection;
import com.ibm.watson.assistant.v2.model.AssistantData;
import com.ibm.watson.assistant.v2.model.AssistantState;
import com.ibm.watson.assistant.v2.model.BaseEnvironmentOrchestration;
import com.ibm.watson.assistant.v2.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v2.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v2.model.BulkClassifyUtterance;
import com.ibm.watson.assistant.v2.model.CaptureGroup;
import com.ibm.watson.assistant.v2.model.CreateAssistantOptions;
import com.ibm.watson.assistant.v2.model.CreateReleaseOptions;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteAssistantOptions;
import com.ibm.watson.assistant.v2.model.DeleteReleaseOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v2.model.DeployReleaseOptions;
import com.ibm.watson.assistant.v2.model.Environment;
import com.ibm.watson.assistant.v2.model.EnvironmentCollection;
import com.ibm.watson.assistant.v2.model.EnvironmentSkill;
import com.ibm.watson.assistant.v2.model.ExportSkillsOptions;
import com.ibm.watson.assistant.v2.model.GetEnvironmentOptions;
import com.ibm.watson.assistant.v2.model.GetReleaseOptions;
import com.ibm.watson.assistant.v2.model.GetSkillOptions;
import com.ibm.watson.assistant.v2.model.ImportSkillsOptions;
import com.ibm.watson.assistant.v2.model.ImportSkillsStatusOptions;
import com.ibm.watson.assistant.v2.model.ListAssistantsOptions;
import com.ibm.watson.assistant.v2.model.ListEnvironmentsOptions;
import com.ibm.watson.assistant.v2.model.ListLogsOptions;
import com.ibm.watson.assistant.v2.model.ListReleasesOptions;
import com.ibm.watson.assistant.v2.model.LogCollection;
import com.ibm.watson.assistant.v2.model.MessageContext;
import com.ibm.watson.assistant.v2.model.MessageContextActionSkill;
import com.ibm.watson.assistant.v2.model.MessageContextDialogSkill;
import com.ibm.watson.assistant.v2.model.MessageContextGlobal;
import com.ibm.watson.assistant.v2.model.MessageContextGlobalSystem;
import com.ibm.watson.assistant.v2.model.MessageContextSkillSystem;
import com.ibm.watson.assistant.v2.model.MessageContextSkills;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageInputAttachment;
import com.ibm.watson.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.assistant.v2.model.MessageInputOptionsSpelling;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;
import com.ibm.watson.assistant.v2.model.Release;
import com.ibm.watson.assistant.v2.model.ReleaseCollection;
import com.ibm.watson.assistant.v2.model.RequestAnalytics;
import com.ibm.watson.assistant.v2.model.RuntimeEntity;
import com.ibm.watson.assistant.v2.model.RuntimeEntityAlternative;
import com.ibm.watson.assistant.v2.model.RuntimeEntityInterpretation;
import com.ibm.watson.assistant.v2.model.RuntimeEntityRole;
import com.ibm.watson.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.assistant.v2.model.SearchSettings;
import com.ibm.watson.assistant.v2.model.SearchSettingsDiscovery;
import com.ibm.watson.assistant.v2.model.SearchSettingsDiscoveryAuthentication;
import com.ibm.watson.assistant.v2.model.SearchSettingsMessages;
import com.ibm.watson.assistant.v2.model.SearchSettingsSchemaMapping;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.assistant.v2.model.Skill;
import com.ibm.watson.assistant.v2.model.SkillImport;
import com.ibm.watson.assistant.v2.model.SkillsAsyncRequestStatus;
import com.ibm.watson.assistant.v2.model.SkillsExport;
import com.ibm.watson.assistant.v2.model.StatefulMessageResponse;
import com.ibm.watson.assistant.v2.model.StatelessMessageContext;
import com.ibm.watson.assistant.v2.model.StatelessMessageContextGlobal;
import com.ibm.watson.assistant.v2.model.StatelessMessageContextSkills;
import com.ibm.watson.assistant.v2.model.StatelessMessageContextSkillsActionsSkill;
import com.ibm.watson.assistant.v2.model.StatelessMessageInput;
import com.ibm.watson.assistant.v2.model.StatelessMessageInputOptions;
import com.ibm.watson.assistant.v2.model.StatelessMessageResponse;
import com.ibm.watson.assistant.v2.model.UpdateEnvironmentOptions;
import com.ibm.watson.assistant.v2.model.UpdateSkillOptions;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
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

/** Unit test class for the Assistant service. */
public class AssistantTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Assistant assistantService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // Set mock values for global params
    String version = "testString";
    new Assistant(version, serviceName, null);
  }

  // Test the getter for the version global parameter
  @Test
  public void testGetVersion() throws Throwable {
    assertEquals(assistantService.getVersion(), "testString");
  }

  // Test the createAssistant operation with a valid options model parameter
  @Test
  public void testCreateAssistantWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"assistant_id\": \"assistantId\", \"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"assistant_skills\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\"}], \"assistant_environments\": [{\"name\": \"name\", \"environment_id\": \"environmentId\", \"environment\": \"draft\"}]}";
    String createAssistantPath = "/v2/assistants";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateAssistantOptions model
    CreateAssistantOptions createAssistantOptionsModel =
        new CreateAssistantOptions.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .build();

    // Invoke createAssistant() with a valid options model and verify the result
    Response<AssistantData> response =
        assistantService.createAssistant(createAssistantOptionsModel).execute();
    assertNotNull(response);
    AssistantData responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAssistantPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createAssistant operation with and without retries enabled
  @Test
  public void testCreateAssistantWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateAssistantWOptions();

    assistantService.disableRetries();
    testCreateAssistantWOptions();
  }

  // Test the listAssistants operation with a valid options model parameter
  @Test
  public void testListAssistantsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"assistants\": [{\"assistant_id\": \"assistantId\", \"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"assistant_skills\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\"}], \"assistant_environments\": [{\"name\": \"name\", \"environment_id\": \"environmentId\", \"environment\": \"draft\"}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listAssistantsPath = "/v2/assistants";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListAssistantsOptions model
    ListAssistantsOptions listAssistantsOptionsModel =
        new ListAssistantsOptions.Builder()
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("name")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listAssistants() with a valid options model and verify the result
    Response<AssistantCollection> response =
        assistantService.listAssistants(listAssistantsOptionsModel).execute();
    assertNotNull(response);
    AssistantCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAssistantsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "name");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listAssistants operation with and without retries enabled
  @Test
  public void testListAssistantsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListAssistantsWOptions();

    assistantService.disableRetries();
    testListAssistantsWOptions();
  }

  // Test the deleteAssistant operation with a valid options model parameter
  @Test
  public void testDeleteAssistantWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAssistantPath = "/v2/assistants/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteAssistantOptions model
    DeleteAssistantOptions deleteAssistantOptionsModel =
        new DeleteAssistantOptions.Builder().assistantId("testString").build();

    // Invoke deleteAssistant() with a valid options model and verify the result
    Response<Void> response =
        assistantService.deleteAssistant(deleteAssistantOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAssistantPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteAssistant operation with and without retries enabled
  @Test
  public void testDeleteAssistantWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteAssistantWOptions();

    assistantService.disableRetries();
    testDeleteAssistantWOptions();
  }

  // Test the deleteAssistant operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAssistantNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteAssistant(null).execute();
  }

  // Test the createSession operation with a valid options model parameter
  @Test
  public void testCreateSessionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"session_id\": \"sessionId\"}";
    String createSessionPath = "/v2/assistants/testString/sessions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the RequestAnalytics model
    RequestAnalytics requestAnalyticsModel =
        new RequestAnalytics.Builder()
            .browser("testString")
            .device("testString")
            .pageUrl("testString")
            .build();

    // Construct an instance of the CreateSessionOptions model
    CreateSessionOptions createSessionOptionsModel =
        new CreateSessionOptions.Builder()
            .assistantId("testString")
            .analytics(requestAnalyticsModel)
            .build();

    // Invoke createSession() with a valid options model and verify the result
    Response<SessionResponse> response =
        assistantService.createSession(createSessionOptionsModel).execute();
    assertNotNull(response);
    SessionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSessionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createSession operation with and without retries enabled
  @Test
  public void testCreateSessionWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateSessionWOptions();

    assistantService.disableRetries();
    testCreateSessionWOptions();
  }

  // Test the createSession operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSessionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createSession(null).execute();
  }

  // Test the deleteSession operation with a valid options model parameter
  @Test
  public void testDeleteSessionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSessionPath = "/v2/assistants/testString/sessions/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteSessionOptions model
    DeleteSessionOptions deleteSessionOptionsModel =
        new DeleteSessionOptions.Builder()
            .assistantId("testString")
            .sessionId("testString")
            .build();

    // Invoke deleteSession() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteSession(deleteSessionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSessionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteSession operation with and without retries enabled
  @Test
  public void testDeleteSessionWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteSessionWOptions();

    assistantService.disableRetries();
    testDeleteSessionWOptions();
  }

  // Test the deleteSession operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSessionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteSession(null).execute();
  }

  // Test the message operation with a valid options model parameter
  @Test
  public void testMessageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"output\": {\"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\", \"turn_events\": [{\"event\": \"action_visited\", \"source\": {\"type\": \"action\", \"action\": \"action\", \"action_title\": \"actionTitle\", \"condition\": \"condition\"}, \"action_start_time\": \"actionStartTime\", \"condition_type\": \"user_defined\", \"reason\": \"intent\", \"result_variable\": \"resultVariable\"}]}, \"user_defined\": {\"anyKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"main skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}}, \"actions skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}, \"action_variables\": {\"anyKey\": \"anyValue\"}, \"skill_variables\": {\"anyKey\": \"anyValue\"}}}, \"integrations\": {\"anyKey\": \"anyValue\"}}, \"user_id\": \"userId\", \"masked_output\": {\"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\", \"turn_events\": [{\"event\": \"action_visited\", \"source\": {\"type\": \"action\", \"action\": \"action\", \"action_title\": \"actionTitle\", \"condition\": \"condition\"}, \"action_start_time\": \"actionStartTime\", \"condition_type\": \"user_defined\", \"reason\": \"intent\", \"result_variable\": \"resultVariable\"}]}, \"user_defined\": {\"anyKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"masked_input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"analytics\": {\"browser\": \"browser\", \"device\": \"device\", \"pageUrl\": \"pageUrl\"}, \"options\": {\"restart\": false, \"alternate_intents\": false, \"async_callout\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}}";
    String messagePath = "/v2/assistants/testString/sessions/testString/message";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RuntimeIntent model
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder()
            .intent("testString")
            .confidence(Double.valueOf("72.5"))
            .skill("testString")
            .build();

    // Construct an instance of the CaptureGroup model
    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the RuntimeEntityInterpretation model
    RuntimeEntityInterpretation runtimeEntityInterpretationModel =
        new RuntimeEntityInterpretation.Builder()
            .calendarType("testString")
            .datetimeLink("testString")
            .festival("testString")
            .granularity("day")
            .rangeLink("testString")
            .rangeModifier("testString")
            .relativeDay(Double.valueOf("72.5"))
            .relativeMonth(Double.valueOf("72.5"))
            .relativeWeek(Double.valueOf("72.5"))
            .relativeWeekend(Double.valueOf("72.5"))
            .relativeYear(Double.valueOf("72.5"))
            .specificDay(Double.valueOf("72.5"))
            .specificDayOfWeek("testString")
            .specificMonth(Double.valueOf("72.5"))
            .specificQuarter(Double.valueOf("72.5"))
            .specificYear(Double.valueOf("72.5"))
            .numericValue(Double.valueOf("72.5"))
            .subtype("testString")
            .partOfDay("testString")
            .relativeHour(Double.valueOf("72.5"))
            .relativeMinute(Double.valueOf("72.5"))
            .relativeSecond(Double.valueOf("72.5"))
            .specificHour(Double.valueOf("72.5"))
            .specificMinute(Double.valueOf("72.5"))
            .specificSecond(Double.valueOf("72.5"))
            .timezone("testString")
            .build();

    // Construct an instance of the RuntimeEntityAlternative model
    RuntimeEntityAlternative runtimeEntityAlternativeModel =
        new RuntimeEntityAlternative.Builder()
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .build();

    // Construct an instance of the RuntimeEntityRole model
    RuntimeEntityRole runtimeEntityRoleModel =
        new RuntimeEntityRole.Builder().type("date_from").build();

    // Construct an instance of the RuntimeEntity model
    RuntimeEntity runtimeEntityModel =
        new RuntimeEntity.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(java.util.Arrays.asList(captureGroupModel))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(java.util.Arrays.asList(runtimeEntityAlternativeModel))
            .role(runtimeEntityRoleModel)
            .skill("testString")
            .build();

    // Construct an instance of the MessageInputAttachment model
    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();

    // Construct an instance of the RequestAnalytics model
    RequestAnalytics requestAnalyticsModel =
        new RequestAnalytics.Builder()
            .browser("testString")
            .device("testString")
            .pageUrl("testString")
            .build();

    // Construct an instance of the MessageInputOptionsSpelling model
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();

    // Construct an instance of the MessageInputOptions model
    MessageInputOptions messageInputOptionsModel =
        new MessageInputOptions.Builder()
            .restart(false)
            .alternateIntents(false)
            .asyncCallout(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .returnContext(false)
            .export(false)
            .build();

    // Construct an instance of the MessageInput model
    MessageInput messageInputModel =
        new MessageInput.Builder()
            .messageType("text")
            .text("testString")
            .intents(java.util.Arrays.asList(runtimeIntentModel))
            .entities(java.util.Arrays.asList(runtimeEntityModel))
            .suggestionId("testString")
            .attachments(java.util.Arrays.asList(messageInputAttachmentModel))
            .analytics(requestAnalyticsModel)
            .options(messageInputOptionsModel)
            .build();

    // Construct an instance of the MessageContextGlobalSystem model
    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("testString")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .skipUserInput(true)
            .build();

    // Construct an instance of the MessageContextGlobal model
    MessageContextGlobal messageContextGlobalModel =
        new MessageContextGlobal.Builder().system(messageContextGlobalSystemModel).build();

    // Construct an instance of the MessageContextSkillSystem model
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();

    // Construct an instance of the MessageContextDialogSkill model
    MessageContextDialogSkill messageContextDialogSkillModel =
        new MessageContextDialogSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();

    // Construct an instance of the MessageContextActionSkill model
    MessageContextActionSkill messageContextActionSkillModel =
        new MessageContextActionSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();

    // Construct an instance of the MessageContextSkills model
    MessageContextSkills messageContextSkillsModel =
        new MessageContextSkills.Builder()
            .mainSkill(messageContextDialogSkillModel)
            .actionsSkill(messageContextActionSkillModel)
            .build();

    // Construct an instance of the MessageContext model
    MessageContext messageContextModel =
        new MessageContext.Builder()
            .global(messageContextGlobalModel)
            .skills(messageContextSkillsModel)
            .integrations(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();

    // Construct an instance of the MessageOptions model
    MessageOptions messageOptionsModel =
        new MessageOptions.Builder()
            .assistantId("testString")
            .sessionId("testString")
            .input(messageInputModel)
            .context(messageContextModel)
            .userId("testString")
            .build();

    // Invoke message() with a valid options model and verify the result
    Response<StatefulMessageResponse> response =
        assistantService.message(messageOptionsModel).execute();
    assertNotNull(response);
    StatefulMessageResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, messagePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the message operation with and without retries enabled
  @Test
  public void testMessageWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testMessageWOptions();

    assistantService.disableRetries();
    testMessageWOptions();
  }

  // Test the message operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMessageNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.message(null).execute();
  }

  // Test the messageStateless operation with a valid options model parameter
  @Test
  public void testMessageStatelessWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"output\": {\"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\", \"turn_events\": [{\"event\": \"action_visited\", \"source\": {\"type\": \"action\", \"action\": \"action\", \"action_title\": \"actionTitle\", \"condition\": \"condition\"}, \"action_start_time\": \"actionStartTime\", \"condition_type\": \"user_defined\", \"reason\": \"intent\", \"result_variable\": \"resultVariable\"}]}, \"user_defined\": {\"anyKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"main skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}}, \"actions skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}, \"action_variables\": {\"anyKey\": \"anyValue\"}, \"skill_variables\": {\"anyKey\": \"anyValue\"}, \"private_action_variables\": {\"anyKey\": \"anyValue\"}, \"private_skill_variables\": {\"anyKey\": \"anyValue\"}}}, \"integrations\": {\"anyKey\": \"anyValue\"}}, \"masked_output\": {\"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\", \"turn_events\": [{\"event\": \"action_visited\", \"source\": {\"type\": \"action\", \"action\": \"action\", \"action_title\": \"actionTitle\", \"condition\": \"condition\"}, \"action_start_time\": \"actionStartTime\", \"condition_type\": \"user_defined\", \"reason\": \"intent\", \"result_variable\": \"resultVariable\"}]}, \"user_defined\": {\"anyKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"masked_input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"analytics\": {\"browser\": \"browser\", \"device\": \"device\", \"pageUrl\": \"pageUrl\"}, \"options\": {\"restart\": false, \"alternate_intents\": false, \"async_callout\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}, \"user_id\": \"userId\"}";
    String messageStatelessPath = "/v2/assistants/testString/message";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RuntimeIntent model
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder()
            .intent("testString")
            .confidence(Double.valueOf("72.5"))
            .skill("testString")
            .build();

    // Construct an instance of the CaptureGroup model
    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the RuntimeEntityInterpretation model
    RuntimeEntityInterpretation runtimeEntityInterpretationModel =
        new RuntimeEntityInterpretation.Builder()
            .calendarType("testString")
            .datetimeLink("testString")
            .festival("testString")
            .granularity("day")
            .rangeLink("testString")
            .rangeModifier("testString")
            .relativeDay(Double.valueOf("72.5"))
            .relativeMonth(Double.valueOf("72.5"))
            .relativeWeek(Double.valueOf("72.5"))
            .relativeWeekend(Double.valueOf("72.5"))
            .relativeYear(Double.valueOf("72.5"))
            .specificDay(Double.valueOf("72.5"))
            .specificDayOfWeek("testString")
            .specificMonth(Double.valueOf("72.5"))
            .specificQuarter(Double.valueOf("72.5"))
            .specificYear(Double.valueOf("72.5"))
            .numericValue(Double.valueOf("72.5"))
            .subtype("testString")
            .partOfDay("testString")
            .relativeHour(Double.valueOf("72.5"))
            .relativeMinute(Double.valueOf("72.5"))
            .relativeSecond(Double.valueOf("72.5"))
            .specificHour(Double.valueOf("72.5"))
            .specificMinute(Double.valueOf("72.5"))
            .specificSecond(Double.valueOf("72.5"))
            .timezone("testString")
            .build();

    // Construct an instance of the RuntimeEntityAlternative model
    RuntimeEntityAlternative runtimeEntityAlternativeModel =
        new RuntimeEntityAlternative.Builder()
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .build();

    // Construct an instance of the RuntimeEntityRole model
    RuntimeEntityRole runtimeEntityRoleModel =
        new RuntimeEntityRole.Builder().type("date_from").build();

    // Construct an instance of the RuntimeEntity model
    RuntimeEntity runtimeEntityModel =
        new RuntimeEntity.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(java.util.Arrays.asList(captureGroupModel))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(java.util.Arrays.asList(runtimeEntityAlternativeModel))
            .role(runtimeEntityRoleModel)
            .skill("testString")
            .build();

    // Construct an instance of the MessageInputAttachment model
    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();

    // Construct an instance of the RequestAnalytics model
    RequestAnalytics requestAnalyticsModel =
        new RequestAnalytics.Builder()
            .browser("testString")
            .device("testString")
            .pageUrl("testString")
            .build();

    // Construct an instance of the MessageInputOptionsSpelling model
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();

    // Construct an instance of the StatelessMessageInputOptions model
    StatelessMessageInputOptions statelessMessageInputOptionsModel =
        new StatelessMessageInputOptions.Builder()
            .restart(false)
            .alternateIntents(false)
            .asyncCallout(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .build();

    // Construct an instance of the StatelessMessageInput model
    StatelessMessageInput statelessMessageInputModel =
        new StatelessMessageInput.Builder()
            .messageType("text")
            .text("testString")
            .intents(java.util.Arrays.asList(runtimeIntentModel))
            .entities(java.util.Arrays.asList(runtimeEntityModel))
            .suggestionId("testString")
            .attachments(java.util.Arrays.asList(messageInputAttachmentModel))
            .analytics(requestAnalyticsModel)
            .options(statelessMessageInputOptionsModel)
            .build();

    // Construct an instance of the MessageContextGlobalSystem model
    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("testString")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .skipUserInput(true)
            .build();

    // Construct an instance of the StatelessMessageContextGlobal model
    StatelessMessageContextGlobal statelessMessageContextGlobalModel =
        new StatelessMessageContextGlobal.Builder()
            .system(messageContextGlobalSystemModel)
            .sessionId("testString")
            .build();

    // Construct an instance of the MessageContextSkillSystem model
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();

    // Construct an instance of the MessageContextDialogSkill model
    MessageContextDialogSkill messageContextDialogSkillModel =
        new MessageContextDialogSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();

    // Construct an instance of the StatelessMessageContextSkillsActionsSkill model
    StatelessMessageContextSkillsActionsSkill statelessMessageContextSkillsActionsSkillModel =
        new StatelessMessageContextSkillsActionsSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateActionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateSkillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();

    // Construct an instance of the StatelessMessageContextSkills model
    StatelessMessageContextSkills statelessMessageContextSkillsModel =
        new StatelessMessageContextSkills.Builder()
            .mainSkill(messageContextDialogSkillModel)
            .actionsSkill(statelessMessageContextSkillsActionsSkillModel)
            .build();

    // Construct an instance of the StatelessMessageContext model
    StatelessMessageContext statelessMessageContextModel =
        new StatelessMessageContext.Builder()
            .global(statelessMessageContextGlobalModel)
            .skills(statelessMessageContextSkillsModel)
            .integrations(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();

    // Construct an instance of the MessageStatelessOptions model
    MessageStatelessOptions messageStatelessOptionsModel =
        new MessageStatelessOptions.Builder()
            .assistantId("testString")
            .input(statelessMessageInputModel)
            .context(statelessMessageContextModel)
            .userId("testString")
            .build();

    // Invoke messageStateless() with a valid options model and verify the result
    Response<StatelessMessageResponse> response =
        assistantService.messageStateless(messageStatelessOptionsModel).execute();
    assertNotNull(response);
    StatelessMessageResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, messageStatelessPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the messageStateless operation with and without retries enabled
  @Test
  public void testMessageStatelessWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testMessageStatelessWOptions();

    assistantService.disableRetries();
    testMessageStatelessWOptions();
  }

  // Test the messageStateless operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMessageStatelessNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.messageStateless(null).execute();
  }

  // Test the bulkClassify operation with a valid options model parameter
  @Test
  public void testBulkClassifyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"output\": [{\"input\": {\"text\": \"text\"}, \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}]}]}";
    String bulkClassifyPath = "/v2/skills/testString/workspace/bulk_classify";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the BulkClassifyUtterance model
    BulkClassifyUtterance bulkClassifyUtteranceModel =
        new BulkClassifyUtterance.Builder().text("testString").build();

    // Construct an instance of the BulkClassifyOptions model
    BulkClassifyOptions bulkClassifyOptionsModel =
        new BulkClassifyOptions.Builder()
            .skillId("testString")
            .input(java.util.Arrays.asList(bulkClassifyUtteranceModel))
            .build();

    // Invoke bulkClassify() with a valid options model and verify the result
    Response<BulkClassifyResponse> response =
        assistantService.bulkClassify(bulkClassifyOptionsModel).execute();
    assertNotNull(response);
    BulkClassifyResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, bulkClassifyPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the bulkClassify operation with and without retries enabled
  @Test
  public void testBulkClassifyWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testBulkClassifyWOptions();

    assistantService.disableRetries();
    testBulkClassifyWOptions();
  }

  // Test the bulkClassify operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBulkClassifyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.bulkClassify(null).execute();
  }

  // Test the listLogs operation with a valid options model parameter
  @Test
  public void testListLogsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"logs\": [{\"log_id\": \"logId\", \"request\": {\"input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"analytics\": {\"browser\": \"browser\", \"device\": \"device\", \"pageUrl\": \"pageUrl\"}, \"options\": {\"restart\": false, \"alternate_intents\": false, \"async_callout\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"main skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}}, \"actions skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}, \"action_variables\": {\"anyKey\": \"anyValue\"}, \"skill_variables\": {\"anyKey\": \"anyValue\"}}}, \"integrations\": {\"anyKey\": \"anyValue\"}}, \"user_id\": \"userId\"}, \"response\": {\"output\": {\"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10, \"skill\": \"skill\"}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}, \"skill\": \"skill\"}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\", \"turn_events\": [{\"event\": \"action_visited\", \"source\": {\"type\": \"action\", \"action\": \"action\", \"action_title\": \"actionTitle\", \"condition\": \"condition\"}, \"action_start_time\": \"actionStartTime\", \"condition_type\": \"user_defined\", \"reason\": \"intent\", \"result_variable\": \"resultVariable\"}]}, \"user_defined\": {\"anyKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"main skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}}, \"actions skill\": {\"user_defined\": {\"anyKey\": \"anyValue\"}, \"system\": {\"state\": \"state\"}, \"action_variables\": {\"anyKey\": \"anyValue\"}, \"skill_variables\": {\"anyKey\": \"anyValue\"}}}, \"integrations\": {\"anyKey\": \"anyValue\"}}, \"user_id\": \"userId\"}, \"assistant_id\": \"assistantId\", \"session_id\": \"sessionId\", \"skill_id\": \"skillId\", \"snapshot\": \"snapshot\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"language\": \"language\", \"customer_id\": \"customerId\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
    String listLogsPath = "/v2/assistants/testString/logs";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListLogsOptions model
    ListLogsOptions listLogsOptionsModel =
        new ListLogsOptions.Builder()
            .assistantId("testString")
            .sort("testString")
            .filter("testString")
            .pageLimit(Long.valueOf("100"))
            .cursor("testString")
            .build();

    // Invoke listLogs() with a valid options model and verify the result
    Response<LogCollection> response = assistantService.listLogs(listLogsOptionsModel).execute();
    assertNotNull(response);
    LogCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLogsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(query.get("cursor"), "testString");
  }

  // Test the listLogs operation with and without retries enabled
  @Test
  public void testListLogsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListLogsWOptions();

    assistantService.disableRetries();
    testListLogsWOptions();
  }

  // Test the listLogs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListLogsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listLogs(null).execute();
  }

  // Test the deleteUserData operation with a valid options model parameter
  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteUserDataPath = "/v2/user_data";
    server.enqueue(new MockResponse().setResponseCode(202).setBody(mockResponseBody));

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke deleteUserData() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteUserData(deleteUserDataOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("customer_id"), "testString");
  }

  // Test the deleteUserData operation with and without retries enabled
  @Test
  public void testDeleteUserDataWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteUserDataWOptions();

    assistantService.disableRetries();
    testDeleteUserDataWOptions();
  }

  // Test the deleteUserData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteUserData(null).execute();
  }

  // Test the listEnvironments operation with a valid options model parameter
  @Test
  public void testListEnvironmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environments\": [{\"name\": \"name\", \"description\": \"description\", \"assistant_id\": \"assistantId\", \"environment_id\": \"environmentId\", \"environment\": \"environment\", \"release_reference\": {\"release\": \"release\"}, \"orchestration\": {\"search_skill_fallback\": false}, \"session_timeout\": 10, \"integration_references\": [{\"integration_id\": \"integrationId\", \"type\": \"type\"}], \"skill_references\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"disabled\": true, \"snapshot\": \"snapshot\", \"skill_reference\": \"skillReference\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listEnvironmentsPath = "/v2/assistants/testString/environments";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListEnvironmentsOptions model
    ListEnvironmentsOptions listEnvironmentsOptionsModel =
        new ListEnvironmentsOptions.Builder()
            .assistantId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("name")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listEnvironments() with a valid options model and verify the result
    Response<EnvironmentCollection> response =
        assistantService.listEnvironments(listEnvironmentsOptionsModel).execute();
    assertNotNull(response);
    EnvironmentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnvironmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "name");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listEnvironments operation with and without retries enabled
  @Test
  public void testListEnvironmentsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListEnvironmentsWOptions();

    assistantService.disableRetries();
    testListEnvironmentsWOptions();
  }

  // Test the listEnvironments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEnvironmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listEnvironments(null).execute();
  }

  // Test the getEnvironment operation with a valid options model parameter
  @Test
  public void testGetEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"assistant_id\": \"assistantId\", \"environment_id\": \"environmentId\", \"environment\": \"environment\", \"release_reference\": {\"release\": \"release\"}, \"orchestration\": {\"search_skill_fallback\": false}, \"session_timeout\": 10, \"integration_references\": [{\"integration_id\": \"integrationId\", \"type\": \"type\"}], \"skill_references\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"disabled\": true, \"snapshot\": \"snapshot\", \"skill_reference\": \"skillReference\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getEnvironmentPath = "/v2/assistants/testString/environments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetEnvironmentOptions model
    GetEnvironmentOptions getEnvironmentOptionsModel =
        new GetEnvironmentOptions.Builder()
            .assistantId("testString")
            .environmentId("testString")
            .includeAudit(false)
            .build();

    // Invoke getEnvironment() with a valid options model and verify the result
    Response<Environment> response =
        assistantService.getEnvironment(getEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getEnvironment operation with and without retries enabled
  @Test
  public void testGetEnvironmentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetEnvironmentWOptions();

    assistantService.disableRetries();
    testGetEnvironmentWOptions();
  }

  // Test the getEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getEnvironment(null).execute();
  }

  // Test the updateEnvironment operation with a valid options model parameter
  @Test
  public void testUpdateEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"assistant_id\": \"assistantId\", \"environment_id\": \"environmentId\", \"environment\": \"environment\", \"release_reference\": {\"release\": \"release\"}, \"orchestration\": {\"search_skill_fallback\": false}, \"session_timeout\": 10, \"integration_references\": [{\"integration_id\": \"integrationId\", \"type\": \"type\"}], \"skill_references\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"disabled\": true, \"snapshot\": \"snapshot\", \"skill_reference\": \"skillReference\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateEnvironmentPath = "/v2/assistants/testString/environments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the BaseEnvironmentOrchestration model
    BaseEnvironmentOrchestration baseEnvironmentOrchestrationModel =
        new BaseEnvironmentOrchestration.Builder().searchSkillFallback(true).build();

    // Construct an instance of the EnvironmentSkill model
    EnvironmentSkill environmentSkillModel =
        new EnvironmentSkill.Builder()
            .skillId("testString")
            .type("dialog")
            .disabled(true)
            .snapshot("testString")
            .skillReference("testString")
            .build();

    // Construct an instance of the UpdateEnvironmentOptions model
    UpdateEnvironmentOptions updateEnvironmentOptionsModel =
        new UpdateEnvironmentOptions.Builder()
            .assistantId("testString")
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .orchestration(baseEnvironmentOrchestrationModel)
            .sessionTimeout(Long.valueOf("10"))
            .skillReferences(java.util.Arrays.asList(environmentSkillModel))
            .build();

    // Invoke updateEnvironment() with a valid options model and verify the result
    Response<Environment> response =
        assistantService.updateEnvironment(updateEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateEnvironment operation with and without retries enabled
  @Test
  public void testUpdateEnvironmentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateEnvironmentWOptions();

    assistantService.disableRetries();
    testUpdateEnvironmentWOptions();
  }

  // Test the updateEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateEnvironment(null).execute();
  }

  // Test the createRelease operation with a valid options model parameter
  @Test
  public void testCreateReleaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"release\": \"release\", \"description\": \"description\", \"environment_references\": [{\"name\": \"name\", \"environment_id\": \"environmentId\", \"environment\": \"draft\"}], \"content\": {\"skills\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"snapshot\": \"snapshot\"}]}, \"status\": \"Available\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createReleasePath = "/v2/assistants/testString/releases";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateReleaseOptions model
    CreateReleaseOptions createReleaseOptionsModel =
        new CreateReleaseOptions.Builder()
            .assistantId("testString")
            .description("testString")
            .build();

    // Invoke createRelease() with a valid options model and verify the result
    Response<Release> response =
        assistantService.createRelease(createReleaseOptionsModel).execute();
    assertNotNull(response);
    Release responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createReleasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createRelease operation with and without retries enabled
  @Test
  public void testCreateReleaseWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateReleaseWOptions();

    assistantService.disableRetries();
    testCreateReleaseWOptions();
  }

  // Test the createRelease operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateReleaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createRelease(null).execute();
  }

  // Test the listReleases operation with a valid options model parameter
  @Test
  public void testListReleasesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"releases\": [{\"release\": \"release\", \"description\": \"description\", \"environment_references\": [{\"name\": \"name\", \"environment_id\": \"environmentId\", \"environment\": \"draft\"}], \"content\": {\"skills\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"snapshot\": \"snapshot\"}]}, \"status\": \"Available\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listReleasesPath = "/v2/assistants/testString/releases";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListReleasesOptions model
    ListReleasesOptions listReleasesOptionsModel =
        new ListReleasesOptions.Builder()
            .assistantId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("name")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listReleases() with a valid options model and verify the result
    Response<ReleaseCollection> response =
        assistantService.listReleases(listReleasesOptionsModel).execute();
    assertNotNull(response);
    ReleaseCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReleasesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "name");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listReleases operation with and without retries enabled
  @Test
  public void testListReleasesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListReleasesWOptions();

    assistantService.disableRetries();
    testListReleasesWOptions();
  }

  // Test the listReleases operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListReleasesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listReleases(null).execute();
  }

  // Test the getRelease operation with a valid options model parameter
  @Test
  public void testGetReleaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"release\": \"release\", \"description\": \"description\", \"environment_references\": [{\"name\": \"name\", \"environment_id\": \"environmentId\", \"environment\": \"draft\"}], \"content\": {\"skills\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"snapshot\": \"snapshot\"}]}, \"status\": \"Available\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getReleasePath = "/v2/assistants/testString/releases/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetReleaseOptions model
    GetReleaseOptions getReleaseOptionsModel =
        new GetReleaseOptions.Builder()
            .assistantId("testString")
            .release("testString")
            .includeAudit(false)
            .build();

    // Invoke getRelease() with a valid options model and verify the result
    Response<Release> response = assistantService.getRelease(getReleaseOptionsModel).execute();
    assertNotNull(response);
    Release responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReleasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getRelease operation with and without retries enabled
  @Test
  public void testGetReleaseWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetReleaseWOptions();

    assistantService.disableRetries();
    testGetReleaseWOptions();
  }

  // Test the getRelease operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReleaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getRelease(null).execute();
  }

  // Test the deleteRelease operation with a valid options model parameter
  @Test
  public void testDeleteReleaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteReleasePath = "/v2/assistants/testString/releases/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteReleaseOptions model
    DeleteReleaseOptions deleteReleaseOptionsModel =
        new DeleteReleaseOptions.Builder().assistantId("testString").release("testString").build();

    // Invoke deleteRelease() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteRelease(deleteReleaseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteReleasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteRelease operation with and without retries enabled
  @Test
  public void testDeleteReleaseWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteReleaseWOptions();

    assistantService.disableRetries();
    testDeleteReleaseWOptions();
  }

  // Test the deleteRelease operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteReleaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteRelease(null).execute();
  }

  // Test the deployRelease operation with a valid options model parameter
  @Test
  public void testDeployReleaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"assistant_id\": \"assistantId\", \"environment_id\": \"environmentId\", \"environment\": \"environment\", \"release_reference\": {\"release\": \"release\"}, \"orchestration\": {\"search_skill_fallback\": false}, \"session_timeout\": 10, \"integration_references\": [{\"integration_id\": \"integrationId\", \"type\": \"type\"}], \"skill_references\": [{\"skill_id\": \"skillId\", \"type\": \"dialog\", \"disabled\": true, \"snapshot\": \"snapshot\", \"skill_reference\": \"skillReference\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String deployReleasePath = "/v2/assistants/testString/releases/testString/deploy";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeployReleaseOptions model
    DeployReleaseOptions deployReleaseOptionsModel =
        new DeployReleaseOptions.Builder()
            .assistantId("testString")
            .release("testString")
            .environmentId("testString")
            .includeAudit(false)
            .build();

    // Invoke deployRelease() with a valid options model and verify the result
    Response<Environment> response =
        assistantService.deployRelease(deployReleaseOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deployReleasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the deployRelease operation with and without retries enabled
  @Test
  public void testDeployReleaseWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeployReleaseWOptions();

    assistantService.disableRetries();
    testDeployReleaseWOptions();
  }

  // Test the deployRelease operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeployReleaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deployRelease(null).execute();
  }

  // Test the getSkill operation with a valid options model parameter
  @Test
  public void testGetSkillWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"workspace\": {\"anyKey\": \"anyValue\"}, \"skill_id\": \"skillId\", \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"status_description\": \"statusDescription\", \"dialog_settings\": {\"anyKey\": \"anyValue\"}, \"assistant_id\": \"assistantId\", \"workspace_id\": \"workspaceId\", \"environment_id\": \"environmentId\", \"valid\": false, \"next_snapshot_version\": \"nextSnapshotVersion\", \"search_settings\": {\"discovery\": {\"instance_id\": \"instanceId\", \"project_id\": \"projectId\", \"url\": \"url\", \"max_primary_results\": 10000, \"max_total_results\": 10000, \"confidence_threshold\": 0.0, \"highlight\": false, \"find_answers\": false, \"authentication\": {\"basic\": \"basic\", \"bearer\": \"bearer\"}}, \"messages\": {\"success\": \"success\", \"error\": \"error\", \"no_result\": \"noResult\"}, \"schema_mapping\": {\"url\": \"url\", \"body\": \"body\", \"title\": \"title\"}}, \"warnings\": [{\"code\": \"code\", \"path\": \"path\", \"message\": \"message\"}], \"language\": \"language\", \"type\": \"action\"}";
    String getSkillPath = "/v2/assistants/testString/skills/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetSkillOptions model
    GetSkillOptions getSkillOptionsModel =
        new GetSkillOptions.Builder().assistantId("testString").skillId("testString").build();

    // Invoke getSkill() with a valid options model and verify the result
    Response<Skill> response = assistantService.getSkill(getSkillOptionsModel).execute();
    assertNotNull(response);
    Skill responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSkillPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getSkill operation with and without retries enabled
  @Test
  public void testGetSkillWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetSkillWOptions();

    assistantService.disableRetries();
    testGetSkillWOptions();
  }

  // Test the getSkill operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSkillNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getSkill(null).execute();
  }

  // Test the updateSkill operation with a valid options model parameter
  @Test
  public void testUpdateSkillWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"workspace\": {\"anyKey\": \"anyValue\"}, \"skill_id\": \"skillId\", \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"status_description\": \"statusDescription\", \"dialog_settings\": {\"anyKey\": \"anyValue\"}, \"assistant_id\": \"assistantId\", \"workspace_id\": \"workspaceId\", \"environment_id\": \"environmentId\", \"valid\": false, \"next_snapshot_version\": \"nextSnapshotVersion\", \"search_settings\": {\"discovery\": {\"instance_id\": \"instanceId\", \"project_id\": \"projectId\", \"url\": \"url\", \"max_primary_results\": 10000, \"max_total_results\": 10000, \"confidence_threshold\": 0.0, \"highlight\": false, \"find_answers\": false, \"authentication\": {\"basic\": \"basic\", \"bearer\": \"bearer\"}}, \"messages\": {\"success\": \"success\", \"error\": \"error\", \"no_result\": \"noResult\"}, \"schema_mapping\": {\"url\": \"url\", \"body\": \"body\", \"title\": \"title\"}}, \"warnings\": [{\"code\": \"code\", \"path\": \"path\", \"message\": \"message\"}], \"language\": \"language\", \"type\": \"action\"}";
    String updateSkillPath = "/v2/assistants/testString/skills/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the SearchSettingsDiscoveryAuthentication model
    SearchSettingsDiscoveryAuthentication searchSettingsDiscoveryAuthenticationModel =
        new SearchSettingsDiscoveryAuthentication.Builder()
            .basic("testString")
            .bearer("testString")
            .build();

    // Construct an instance of the SearchSettingsDiscovery model
    SearchSettingsDiscovery searchSettingsDiscoveryModel =
        new SearchSettingsDiscovery.Builder()
            .instanceId("testString")
            .projectId("testString")
            .url("testString")
            .maxPrimaryResults(Long.valueOf("10000"))
            .maxTotalResults(Long.valueOf("10000"))
            .confidenceThreshold(Double.valueOf("0.0"))
            .highlight(true)
            .findAnswers(true)
            .authentication(searchSettingsDiscoveryAuthenticationModel)
            .build();

    // Construct an instance of the SearchSettingsMessages model
    SearchSettingsMessages searchSettingsMessagesModel =
        new SearchSettingsMessages.Builder()
            .success("testString")
            .error("testString")
            .noResult("testString")
            .build();

    // Construct an instance of the SearchSettingsSchemaMapping model
    SearchSettingsSchemaMapping searchSettingsSchemaMappingModel =
        new SearchSettingsSchemaMapping.Builder()
            .url("testString")
            .body("testString")
            .title("testString")
            .build();

    // Construct an instance of the SearchSettings model
    SearchSettings searchSettingsModel =
        new SearchSettings.Builder()
            .discovery(searchSettingsDiscoveryModel)
            .messages(searchSettingsMessagesModel)
            .schemaMapping(searchSettingsSchemaMappingModel)
            .build();

    // Construct an instance of the UpdateSkillOptions model
    UpdateSkillOptions updateSkillOptionsModel =
        new UpdateSkillOptions.Builder()
            .assistantId("testString")
            .skillId("testString")
            .name("testString")
            .description("testString")
            .workspace(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .dialogSettings(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .searchSettings(searchSettingsModel)
            .build();

    // Invoke updateSkill() with a valid options model and verify the result
    Response<Skill> response = assistantService.updateSkill(updateSkillOptionsModel).execute();
    assertNotNull(response);
    Skill responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSkillPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateSkill operation with and without retries enabled
  @Test
  public void testUpdateSkillWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateSkillWOptions();

    assistantService.disableRetries();
    testUpdateSkillWOptions();
  }

  // Test the updateSkill operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSkillNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateSkill(null).execute();
  }

  // Test the exportSkills operation with a valid options model parameter
  @Test
  public void testExportSkillsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"assistant_skills\": [{\"name\": \"name\", \"description\": \"description\", \"workspace\": {\"anyKey\": \"anyValue\"}, \"skill_id\": \"skillId\", \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"status_description\": \"statusDescription\", \"dialog_settings\": {\"anyKey\": \"anyValue\"}, \"assistant_id\": \"assistantId\", \"workspace_id\": \"workspaceId\", \"environment_id\": \"environmentId\", \"valid\": false, \"next_snapshot_version\": \"nextSnapshotVersion\", \"search_settings\": {\"discovery\": {\"instance_id\": \"instanceId\", \"project_id\": \"projectId\", \"url\": \"url\", \"max_primary_results\": 10000, \"max_total_results\": 10000, \"confidence_threshold\": 0.0, \"highlight\": false, \"find_answers\": false, \"authentication\": {\"basic\": \"basic\", \"bearer\": \"bearer\"}}, \"messages\": {\"success\": \"success\", \"error\": \"error\", \"no_result\": \"noResult\"}, \"schema_mapping\": {\"url\": \"url\", \"body\": \"body\", \"title\": \"title\"}}, \"warnings\": [{\"code\": \"code\", \"path\": \"path\", \"message\": \"message\"}], \"language\": \"language\", \"type\": \"action\"}], \"assistant_state\": {\"action_disabled\": true, \"dialog_disabled\": true}}";
    String exportSkillsPath = "/v2/assistants/testString/skills_export";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ExportSkillsOptions model
    ExportSkillsOptions exportSkillsOptionsModel =
        new ExportSkillsOptions.Builder().assistantId("testString").includeAudit(false).build();

    // Invoke exportSkills() with a valid options model and verify the result
    Response<SkillsExport> response =
        assistantService.exportSkills(exportSkillsOptionsModel).execute();
    assertNotNull(response);
    SkillsExport responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, exportSkillsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the exportSkills operation with and without retries enabled
  @Test
  public void testExportSkillsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testExportSkillsWOptions();

    assistantService.disableRetries();
    testExportSkillsWOptions();
  }

  // Test the exportSkills operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testExportSkillsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.exportSkills(null).execute();
  }

  // Test the importSkills operation with a valid options model parameter
  @Test
  public void testImportSkillsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"assistant_id\": \"assistantId\", \"status\": \"Available\", \"status_description\": \"statusDescription\", \"status_errors\": [{\"message\": \"message\"}]}";
    String importSkillsPath = "/v2/assistants/testString/skills_import";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the SearchSettingsDiscoveryAuthentication model
    SearchSettingsDiscoveryAuthentication searchSettingsDiscoveryAuthenticationModel =
        new SearchSettingsDiscoveryAuthentication.Builder()
            .basic("testString")
            .bearer("testString")
            .build();

    // Construct an instance of the SearchSettingsDiscovery model
    SearchSettingsDiscovery searchSettingsDiscoveryModel =
        new SearchSettingsDiscovery.Builder()
            .instanceId("testString")
            .projectId("testString")
            .url("testString")
            .maxPrimaryResults(Long.valueOf("10000"))
            .maxTotalResults(Long.valueOf("10000"))
            .confidenceThreshold(Double.valueOf("0.0"))
            .highlight(true)
            .findAnswers(true)
            .authentication(searchSettingsDiscoveryAuthenticationModel)
            .build();

    // Construct an instance of the SearchSettingsMessages model
    SearchSettingsMessages searchSettingsMessagesModel =
        new SearchSettingsMessages.Builder()
            .success("testString")
            .error("testString")
            .noResult("testString")
            .build();

    // Construct an instance of the SearchSettingsSchemaMapping model
    SearchSettingsSchemaMapping searchSettingsSchemaMappingModel =
        new SearchSettingsSchemaMapping.Builder()
            .url("testString")
            .body("testString")
            .title("testString")
            .build();

    // Construct an instance of the SearchSettings model
    SearchSettings searchSettingsModel =
        new SearchSettings.Builder()
            .discovery(searchSettingsDiscoveryModel)
            .messages(searchSettingsMessagesModel)
            .schemaMapping(searchSettingsSchemaMappingModel)
            .build();

    // Construct an instance of the SkillImport model
    SkillImport skillImportModel =
        new SkillImport.Builder()
            .name("testString")
            .description("testString")
            .workspace(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .dialogSettings(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .searchSettings(searchSettingsModel)
            .language("testString")
            .type("action")
            .build();

    // Construct an instance of the AssistantState model
    AssistantState assistantStateModel =
        new AssistantState.Builder().actionDisabled(true).dialogDisabled(true).build();

    // Construct an instance of the ImportSkillsOptions model
    ImportSkillsOptions importSkillsOptionsModel =
        new ImportSkillsOptions.Builder()
            .assistantId("testString")
            .assistantSkills(java.util.Arrays.asList(skillImportModel))
            .assistantState(assistantStateModel)
            .includeAudit(false)
            .build();

    // Invoke importSkills() with a valid options model and verify the result
    Response<SkillsAsyncRequestStatus> response =
        assistantService.importSkills(importSkillsOptionsModel).execute();
    assertNotNull(response);
    SkillsAsyncRequestStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importSkillsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the importSkills operation with and without retries enabled
  @Test
  public void testImportSkillsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testImportSkillsWOptions();

    assistantService.disableRetries();
    testImportSkillsWOptions();
  }

  // Test the importSkills operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportSkillsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.importSkills(null).execute();
  }

  // Test the importSkillsStatus operation with a valid options model parameter
  @Test
  public void testImportSkillsStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"assistant_id\": \"assistantId\", \"status\": \"Available\", \"status_description\": \"statusDescription\", \"status_errors\": [{\"message\": \"message\"}]}";
    String importSkillsStatusPath = "/v2/assistants/testString/skills_import/status";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ImportSkillsStatusOptions model
    ImportSkillsStatusOptions importSkillsStatusOptionsModel =
        new ImportSkillsStatusOptions.Builder().assistantId("testString").build();

    // Invoke importSkillsStatus() with a valid options model and verify the result
    Response<SkillsAsyncRequestStatus> response =
        assistantService.importSkillsStatus(importSkillsStatusOptionsModel).execute();
    assertNotNull(response);
    SkillsAsyncRequestStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importSkillsStatusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the importSkillsStatus operation with and without retries enabled
  @Test
  public void testImportSkillsStatusWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testImportSkillsStatusWOptions();

    assistantService.disableRetries();
    testImportSkillsStatusWOptions();
  }

  // Test the importSkillsStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportSkillsStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.importSkillsStatus(null).execute();
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
    assistantService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();
    assistantService = new Assistant(version, serviceName, authenticator);
    String url = server.url("/").toString();
    assistantService.setServiceUrl(url);
  }
}
