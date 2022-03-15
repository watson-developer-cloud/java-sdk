/*
 * (C) Copyright IBM Corp. 2022.
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
import com.ibm.watson.assistant.v2.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v2.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v2.model.BulkClassifyUtterance;
import com.ibm.watson.assistant.v2.model.CaptureGroup;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v2.model.ListLogsOptions;
import com.ibm.watson.assistant.v2.model.LogCollection;
import com.ibm.watson.assistant.v2.model.MessageContext;
import com.ibm.watson.assistant.v2.model.MessageContextGlobal;
import com.ibm.watson.assistant.v2.model.MessageContextGlobalStateless;
import com.ibm.watson.assistant.v2.model.MessageContextGlobalSystem;
import com.ibm.watson.assistant.v2.model.MessageContextSkill;
import com.ibm.watson.assistant.v2.model.MessageContextSkillSystem;
import com.ibm.watson.assistant.v2.model.MessageContextStateless;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageInputAttachment;
import com.ibm.watson.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.assistant.v2.model.MessageInputOptionsSpelling;
import com.ibm.watson.assistant.v2.model.MessageInputOptionsStateless;
import com.ibm.watson.assistant.v2.model.MessageInputStateless;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.MessageResponseStateless;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;
import com.ibm.watson.assistant.v2.model.RuntimeEntity;
import com.ibm.watson.assistant.v2.model.RuntimeEntityAlternative;
import com.ibm.watson.assistant.v2.model.RuntimeEntityInterpretation;
import com.ibm.watson.assistant.v2.model.RuntimeEntityRole;
import com.ibm.watson.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.assistant.v2.model.SessionResponse;
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

    // Construct an instance of the CreateSessionOptions model
    CreateSessionOptions createSessionOptionsModel =
        new CreateSessionOptions.Builder().assistantId("testString").build();

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
        "{\"output\": {\"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"options\": {\"restart\": false, \"alternate_intents\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}}}], \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\"}, \"user_defined\": {\"mapKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"mapKey\": {\"user_defined\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"system\": {\"state\": \"state\"}}}, \"integrations\": {\"mapKey\": \"anyValue\"}}, \"user_id\": \"userId\"}";
    String messagePath = "/v2/assistants/testString/sessions/testString/message";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RuntimeIntent model
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder().intent("testString").confidence(Double.valueOf("72.5")).build();

    // Construct an instance of the CaptureGroup model
    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
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
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(
                new java.util.ArrayList<CaptureGroup>(java.util.Arrays.asList(captureGroupModel)))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(
                new java.util.ArrayList<RuntimeEntityAlternative>(
                    java.util.Arrays.asList(runtimeEntityAlternativeModel)))
            .role(runtimeEntityRoleModel)
            .build();

    // Construct an instance of the MessageInputAttachment model
    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();

    // Construct an instance of the MessageInputOptionsSpelling model
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();

    // Construct an instance of the MessageInputOptions model
    MessageInputOptions messageInputOptionsModel =
        new MessageInputOptions.Builder()
            .restart(false)
            .alternateIntents(false)
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
            .intents(
                new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)))
            .entities(
                new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)))
            .suggestionId("testString")
            .attachments(
                new java.util.ArrayList<MessageInputAttachment>(
                    java.util.Arrays.asList(messageInputAttachmentModel)))
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

    // Construct an instance of the MessageContextSkill model
    MessageContextSkill messageContextSkillModel =
        new MessageContextSkill.Builder()
            .userDefined(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", TestUtilities.createMockMap());
                  }
                })
            .system(messageContextSkillSystemModel)
            .build();

    // Construct an instance of the MessageContext model
    MessageContext messageContextModel =
        new MessageContext.Builder()
            .global(messageContextGlobalModel)
            .skills(
                new java.util.HashMap<String, MessageContextSkill>() {
                  {
                    put("foo", messageContextSkillModel);
                  }
                })
            .integrations(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
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
    Response<MessageResponse> response = assistantService.message(messageOptionsModel).execute();
    assertNotNull(response);
    MessageResponse responseObj = response.getResult();
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
        "{\"output\": {\"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"options\": {\"restart\": false, \"alternate_intents\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}}}], \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\"}, \"user_defined\": {\"mapKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"mapKey\": {\"user_defined\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"system\": {\"state\": \"state\"}}}, \"integrations\": {\"mapKey\": \"anyValue\"}}, \"user_id\": \"userId\"}";
    String messageStatelessPath = "/v2/assistants/testString/message";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the RuntimeIntent model
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder().intent("testString").confidence(Double.valueOf("72.5")).build();

    // Construct an instance of the CaptureGroup model
    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
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
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(
                new java.util.ArrayList<CaptureGroup>(java.util.Arrays.asList(captureGroupModel)))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(
                new java.util.ArrayList<RuntimeEntityAlternative>(
                    java.util.Arrays.asList(runtimeEntityAlternativeModel)))
            .role(runtimeEntityRoleModel)
            .build();

    // Construct an instance of the MessageInputAttachment model
    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();

    // Construct an instance of the MessageInputOptionsSpelling model
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();

    // Construct an instance of the MessageInputOptionsStateless model
    MessageInputOptionsStateless messageInputOptionsStatelessModel =
        new MessageInputOptionsStateless.Builder()
            .restart(false)
            .alternateIntents(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .build();

    // Construct an instance of the MessageInputStateless model
    MessageInputStateless messageInputStatelessModel =
        new MessageInputStateless.Builder()
            .messageType("text")
            .text("testString")
            .intents(
                new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)))
            .entities(
                new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)))
            .suggestionId("testString")
            .attachments(
                new java.util.ArrayList<MessageInputAttachment>(
                    java.util.Arrays.asList(messageInputAttachmentModel)))
            .options(messageInputOptionsStatelessModel)
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

    // Construct an instance of the MessageContextGlobalStateless model
    MessageContextGlobalStateless messageContextGlobalStatelessModel =
        new MessageContextGlobalStateless.Builder()
            .system(messageContextGlobalSystemModel)
            .sessionId("testString")
            .build();

    // Construct an instance of the MessageContextSkillSystem model
    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();

    // Construct an instance of the MessageContextSkill model
    MessageContextSkill messageContextSkillModel =
        new MessageContextSkill.Builder()
            .userDefined(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", TestUtilities.createMockMap());
                  }
                })
            .system(messageContextSkillSystemModel)
            .build();

    // Construct an instance of the MessageContextStateless model
    MessageContextStateless messageContextStatelessModel =
        new MessageContextStateless.Builder()
            .global(messageContextGlobalStatelessModel)
            .skills(
                new java.util.HashMap<String, MessageContextSkill>() {
                  {
                    put("foo", messageContextSkillModel);
                  }
                })
            .integrations(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .build();

    // Construct an instance of the MessageStatelessOptions model
    MessageStatelessOptions messageStatelessOptionsModel =
        new MessageStatelessOptions.Builder()
            .assistantId("testString")
            .input(messageInputStatelessModel)
            .context(messageContextStatelessModel)
            .userId("testString")
            .build();

    // Invoke messageStateless() with a valid options model and verify the result
    Response<MessageResponseStateless> response =
        assistantService.messageStateless(messageStatelessOptionsModel).execute();
    assertNotNull(response);
    MessageResponseStateless responseObj = response.getResult();
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
        "{\"output\": [{\"input\": {\"text\": \"text\"}, \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}]}]}";
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
            .input(
                new java.util.ArrayList<BulkClassifyUtterance>(
                    java.util.Arrays.asList(bulkClassifyUtteranceModel)))
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
        "{\"logs\": [{\"log_id\": \"logId\", \"request\": {\"input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"options\": {\"restart\": false, \"alternate_intents\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"mapKey\": {\"user_defined\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"system\": {\"state\": \"state\"}}}, \"integrations\": {\"mapKey\": \"anyValue\"}}, \"user_id\": \"userId\"}, \"response\": {\"output\": {\"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"message_type\": \"text\", \"text\": \"text\", \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"suggestion_id\": \"suggestionId\", \"attachments\": [{\"url\": \"url\", \"media_type\": \"mediaType\"}], \"options\": {\"restart\": false, \"alternate_intents\": false, \"spelling\": {\"suggestions\": false, \"auto_correct\": false}, \"debug\": false, \"return_context\": false, \"export\": false}}}}], \"channels\": [{\"channel\": \"channel\"}]}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"debug\": {\"nodes_visited\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"message\": \"message\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"branch_exited\": true, \"branch_exited_reason\": \"completed\"}, \"user_defined\": {\"mapKey\": \"anyValue\"}, \"spelling\": {\"text\": \"text\", \"original_text\": \"originalText\", \"suggested_text\": \"suggestedText\"}}, \"context\": {\"global\": {\"system\": {\"timezone\": \"timezone\", \"user_id\": \"userId\", \"turn_count\": 9, \"locale\": \"en-us\", \"reference_time\": \"referenceTime\", \"session_start_time\": \"sessionStartTime\", \"state\": \"state\", \"skip_user_input\": false}, \"session_id\": \"sessionId\"}, \"skills\": {\"mapKey\": {\"user_defined\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"system\": {\"state\": \"state\"}}}, \"integrations\": {\"mapKey\": \"anyValue\"}}, \"user_id\": \"userId\"}, \"assistant_id\": \"assistantId\", \"session_id\": \"sessionId\", \"skill_id\": \"skillId\", \"snapshot\": \"snapshot\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"language\": \"language\", \"customer_id\": \"customerId\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
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
            .pageLimit(Long.valueOf("26"))
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
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
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
