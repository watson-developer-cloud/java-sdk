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

package com.ibm.watson.assistant.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.model.*;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
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

  @Test
  public void testUpdateDialogNodeNullableWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateDialogNodeNullablePath = "/v1/workspaces/testString/dialog_nodes/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    // model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(
                new java.util.ArrayList<DialogNodeOutputGeneric>(
                    java.util.Arrays.asList(dialogNodeOutputGenericModel)))
            .integrations(
                new java.util.HashMap<String, Map<String, Object>>() {
                  {
                    put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
                  }
                })
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                new java.util.HashMap<String, Map<String, Object>>() {
                  {
                    put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
                  }
                })
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the UpdateDialogNode model
    UpdateDialogNode updateDialogNodeModel =
        new UpdateDialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(
                new java.util.ArrayList<DialogNodeAction>(
                    java.util.Arrays.asList(dialogNodeActionModel)))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(true)
            .build();
    Map<String, Object> updateDialogNodeModelAsPatch = updateDialogNodeModel.asPatch();

    // Construct an instance of the UpdateDialogNodeNullableOptions model
    UpdateDialogNodeNullableOptions updateDialogNodeNullableOptionsModel =
        new UpdateDialogNodeNullableOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .body(updateDialogNodeModelAsPatch)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DialogNode> response =
        assistantService.updateDialogNodeNullable(updateDialogNodeNullableOptionsModel).execute();
    assertNotNull(response);
    DialogNode responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateDialogNodeNullablePath);
  }

  // Test the updateDialogNodeNullable operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDialogNodeNullableNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateDialogNodeNullable(null).execute();
  }

  // Test the message operation with a valid options model parameter
  @Test
  public void testMessageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": false, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"anyKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}";
    String messagePath = "/v1/workspaces/testString/message";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the MessageInput model
    MessageInput messageInputModel =
        new MessageInput.Builder()
            .text("testString")
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .add("foo", "testString")
            .build();

    // Construct an instance of the RuntimeIntent model
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder().intent("testString").confidence(Double.valueOf("72.5")).build();

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
            .build();

    // Construct an instance of the MessageContextMetadata model
    MessageContextMetadata messageContextMetadataModel =
        new MessageContextMetadata.Builder().deployment("testString").userId("testString").build();

    // Construct an instance of the Context model
    Context contextModel =
        new Context.Builder()
            .conversationId("testString")
            .system(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .metadata(messageContextMetadataModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeVisitedDetails model
    DialogNodeVisitedDetails dialogNodeVisitedDetailsModel =
        new DialogNodeVisitedDetails.Builder()
            .dialogNode("testString")
            .title("testString")
            .conditions("testString")
            .build();

    // Construct an instance of the LogMessageSource model
    LogMessageSource logMessageSourceModel =
        new LogMessageSource.Builder().type("dialog_node").dialogNode("testString").build();

    // Construct an instance of the LogMessage model
    LogMessage logMessageModel =
        new LogMessage.Builder()
            .level("info")
            .msg("testString")
            .code("testString")
            .source(logMessageSourceModel)
            .build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the RuntimeResponseGenericRuntimeResponseTypeText model
    RuntimeResponseGenericRuntimeResponseTypeText runtimeResponseGenericModel =
        new RuntimeResponseGenericRuntimeResponseTypeText.Builder()
            .responseType("text")
            .text("testString")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the OutputData model
    OutputData outputDataModel =
        new OutputData.Builder()
            .nodesVisited(java.util.Arrays.asList("testString"))
            .nodesVisitedDetails(java.util.Arrays.asList(dialogNodeVisitedDetailsModel))
            .logMessages(java.util.Arrays.asList(logMessageModel))
            .generic(java.util.Arrays.asList(runtimeResponseGenericModel))
            .add("foo", "testString")
            .build();

    // Construct an instance of the MessageOptions model
    MessageOptions messageOptionsModel =
        new MessageOptions.Builder()
            .workspaceId("testString")
            .input(messageInputModel)
            .intents(java.util.Arrays.asList(runtimeIntentModel))
            .entities(java.util.Arrays.asList(runtimeEntityModel))
            .alternateIntents(false)
            .context(contextModel)
            .output(outputDataModel)
            .userId("testString")
            .nodesVisitedDetails(false)
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
    assertEquals(Boolean.valueOf(query.get("nodes_visited_details")), Boolean.valueOf(false));
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

  // Test the bulkClassify operation with a valid options model parameter
  @Test
  public void testBulkClassifyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"output\": [{\"input\": {\"text\": \"text\"}, \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}]}]}";
    String bulkClassifyPath = "/v1/workspaces/testString/bulk_classify";
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
            .workspaceId("testString")
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

  // Test the listWorkspaces operation with a valid options model parameter
  @Test
  public void testListWorkspacesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"workspaces\": [{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listWorkspacesPath = "/v1/workspaces";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListWorkspacesOptions model
    ListWorkspacesOptions listWorkspacesOptionsModel =
        new ListWorkspacesOptions.Builder()
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("name")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listWorkspaces() with a valid options model and verify the result
    Response<WorkspaceCollection> response =
        assistantService.listWorkspaces(listWorkspacesOptionsModel).execute();
    assertNotNull(response);
    WorkspaceCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listWorkspacesPath);
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

  // Test the listWorkspaces operation with and without retries enabled
  @Test
  public void testListWorkspacesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListWorkspacesWOptions();

    assistantService.disableRetries();
    testListWorkspacesWOptions();
  }

  // Test the createWorkspace operation with a valid options model parameter
  @Test
  public void testCreateWorkspaceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String createWorkspacePath = "/v1/workspaces";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the DialogNode model
    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();

    // Construct an instance of the Counterexample model
    Counterexample counterexampleModel = new Counterexample.Builder().text("testString").build();

    // Construct an instance of the WorkspaceSystemSettingsTooling model
    WorkspaceSystemSettingsTooling workspaceSystemSettingsToolingModel =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();

    // Construct an instance of the WorkspaceSystemSettingsDisambiguation model
    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(false)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsNlp model
    WorkspaceSystemSettingsNlp workspaceSystemSettingsNlpModel =
        new WorkspaceSystemSettingsNlp.Builder().model("testString").build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .nlp(workspaceSystemSettingsNlpModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(java.util.Arrays.asList(webhookHeaderModel))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();

    // Construct an instance of the CreateWorkspaceOptions model
    CreateWorkspaceOptions createWorkspaceOptionsModel =
        new CreateWorkspaceOptions.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(java.util.Arrays.asList(dialogNodeModel))
            .counterexamples(java.util.Arrays.asList(counterexampleModel))
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .learningOptOut(false)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(java.util.Arrays.asList(webhookModel))
            .intents(java.util.Arrays.asList(createIntentModel))
            .entities(java.util.Arrays.asList(createEntityModel))
            .includeAudit(false)
            .build();

    // Invoke createWorkspace() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.createWorkspace(createWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createWorkspacePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createWorkspace operation with and without retries enabled
  @Test
  public void testCreateWorkspaceWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateWorkspaceWOptions();

    assistantService.disableRetries();
    testCreateWorkspaceWOptions();
  }

  // Test the getWorkspace operation with a valid options model parameter
  @Test
  public void testGetWorkspaceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String getWorkspacePath = "/v1/workspaces/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetWorkspaceOptions model
    GetWorkspaceOptions getWorkspaceOptionsModel =
        new GetWorkspaceOptions.Builder()
            .workspaceId("testString")
            .export(false)
            .includeAudit(false)
            .sort("stable")
            .build();

    // Invoke getWorkspace() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.getWorkspace(getWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getWorkspacePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "stable");
  }

  // Test the getWorkspace operation with and without retries enabled
  @Test
  public void testGetWorkspaceWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetWorkspaceWOptions();

    assistantService.disableRetries();
    testGetWorkspaceWOptions();
  }

  // Test the getWorkspace operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetWorkspaceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getWorkspace(null).execute();
  }

  // Test the updateWorkspace operation with a valid options model parameter
  @Test
  public void testUpdateWorkspaceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String updateWorkspacePath = "/v1/workspaces/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the DialogNode model
    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();

    // Construct an instance of the Counterexample model
    Counterexample counterexampleModel = new Counterexample.Builder().text("testString").build();

    // Construct an instance of the WorkspaceSystemSettingsTooling model
    WorkspaceSystemSettingsTooling workspaceSystemSettingsToolingModel =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();

    // Construct an instance of the WorkspaceSystemSettingsDisambiguation model
    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(false)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsNlp model
    WorkspaceSystemSettingsNlp workspaceSystemSettingsNlpModel =
        new WorkspaceSystemSettingsNlp.Builder().model("testString").build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .nlp(workspaceSystemSettingsNlpModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(java.util.Arrays.asList(webhookHeaderModel))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();

    // Construct an instance of the UpdateWorkspaceOptions model
    UpdateWorkspaceOptions updateWorkspaceOptionsModel =
        new UpdateWorkspaceOptions.Builder()
            .workspaceId("testString")
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(java.util.Arrays.asList(dialogNodeModel))
            .counterexamples(java.util.Arrays.asList(counterexampleModel))
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .learningOptOut(false)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(java.util.Arrays.asList(webhookModel))
            .intents(java.util.Arrays.asList(createIntentModel))
            .entities(java.util.Arrays.asList(createEntityModel))
            .append(false)
            .includeAudit(false)
            .build();

    // Invoke updateWorkspace() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.updateWorkspace(updateWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateWorkspacePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateWorkspace operation with and without retries enabled
  @Test
  public void testUpdateWorkspaceWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateWorkspaceWOptions();

    assistantService.disableRetries();
    testUpdateWorkspaceWOptions();
  }

  // Test the updateWorkspace operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateWorkspaceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateWorkspace(null).execute();
  }

  // Test the deleteWorkspace operation with a valid options model parameter
  @Test
  public void testDeleteWorkspaceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteWorkspacePath = "/v1/workspaces/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteWorkspaceOptions model
    DeleteWorkspaceOptions deleteWorkspaceOptionsModel =
        new DeleteWorkspaceOptions.Builder().workspaceId("testString").build();

    // Invoke deleteWorkspace() with a valid options model and verify the result
    Response<Void> response =
        assistantService.deleteWorkspace(deleteWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteWorkspacePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteWorkspace operation with and without retries enabled
  @Test
  public void testDeleteWorkspaceWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteWorkspaceWOptions();

    assistantService.disableRetries();
    testDeleteWorkspaceWOptions();
  }

  // Test the deleteWorkspace operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteWorkspaceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteWorkspace(null).execute();
  }

  // Test the createWorkspaceAsync operation with a valid options model parameter
  @Test
  public void testCreateWorkspaceAsyncWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String createWorkspaceAsyncPath = "/v1/workspaces_async";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the DialogNode model
    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();

    // Construct an instance of the Counterexample model
    Counterexample counterexampleModel = new Counterexample.Builder().text("testString").build();

    // Construct an instance of the WorkspaceSystemSettingsTooling model
    WorkspaceSystemSettingsTooling workspaceSystemSettingsToolingModel =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();

    // Construct an instance of the WorkspaceSystemSettingsDisambiguation model
    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(false)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsNlp model
    WorkspaceSystemSettingsNlp workspaceSystemSettingsNlpModel =
        new WorkspaceSystemSettingsNlp.Builder().model("testString").build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .nlp(workspaceSystemSettingsNlpModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(java.util.Arrays.asList(webhookHeaderModel))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();

    // Construct an instance of the CreateWorkspaceAsyncOptions model
    CreateWorkspaceAsyncOptions createWorkspaceAsyncOptionsModel =
        new CreateWorkspaceAsyncOptions.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(java.util.Arrays.asList(dialogNodeModel))
            .counterexamples(java.util.Arrays.asList(counterexampleModel))
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .learningOptOut(false)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(java.util.Arrays.asList(webhookModel))
            .intents(java.util.Arrays.asList(createIntentModel))
            .entities(java.util.Arrays.asList(createEntityModel))
            .build();

    // Invoke createWorkspaceAsync() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.createWorkspaceAsync(createWorkspaceAsyncOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createWorkspaceAsyncPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createWorkspaceAsync operation with and without retries enabled
  @Test
  public void testCreateWorkspaceAsyncWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateWorkspaceAsyncWOptions();

    assistantService.disableRetries();
    testCreateWorkspaceAsyncWOptions();
  }

  // Test the updateWorkspaceAsync operation with a valid options model parameter
  @Test
  public void testUpdateWorkspaceAsyncWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String updateWorkspaceAsyncPath = "/v1/workspaces_async/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the DialogNode model
    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();

    // Construct an instance of the Counterexample model
    Counterexample counterexampleModel = new Counterexample.Builder().text("testString").build();

    // Construct an instance of the WorkspaceSystemSettingsTooling model
    WorkspaceSystemSettingsTooling workspaceSystemSettingsToolingModel =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();

    // Construct an instance of the WorkspaceSystemSettingsDisambiguation model
    WorkspaceSystemSettingsDisambiguation workspaceSystemSettingsDisambiguationModel =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .prompt("testString")
            .noneOfTheAbovePrompt("testString")
            .enabled(false)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(false).build();

    // Construct an instance of the WorkspaceSystemSettingsNlp model
    WorkspaceSystemSettingsNlp workspaceSystemSettingsNlpModel =
        new WorkspaceSystemSettingsNlp.Builder().model("testString").build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .spellingSuggestions(false)
            .spellingAutoCorrect(false)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .nlp(workspaceSystemSettingsNlpModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(java.util.Arrays.asList(webhookHeaderModel))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();

    // Construct an instance of the UpdateWorkspaceAsyncOptions model
    UpdateWorkspaceAsyncOptions updateWorkspaceAsyncOptionsModel =
        new UpdateWorkspaceAsyncOptions.Builder()
            .workspaceId("testString")
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(java.util.Arrays.asList(dialogNodeModel))
            .counterexamples(java.util.Arrays.asList(counterexampleModel))
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .learningOptOut(false)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(java.util.Arrays.asList(webhookModel))
            .intents(java.util.Arrays.asList(createIntentModel))
            .entities(java.util.Arrays.asList(createEntityModel))
            .append(false)
            .build();

    // Invoke updateWorkspaceAsync() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.updateWorkspaceAsync(updateWorkspaceAsyncOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateWorkspaceAsyncPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(false));
  }

  // Test the updateWorkspaceAsync operation with and without retries enabled
  @Test
  public void testUpdateWorkspaceAsyncWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateWorkspaceAsyncWOptions();

    assistantService.disableRetries();
    testUpdateWorkspaceAsyncWOptions();
  }

  // Test the updateWorkspaceAsync operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateWorkspaceAsyncNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateWorkspaceAsync(null).execute();
  }

  // Test the exportWorkspaceAsync operation with a valid options model parameter
  @Test
  public void testExportWorkspaceAsyncWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"learning_opt_out\": false, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"anyKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}, \"nlp\": {\"model\": \"model\"}}, \"status\": \"Available\", \"status_errors\": [{\"message\": \"message\"}], \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"counts\": {\"intent\": 6, \"entity\": 6, \"node\": 4}}";
    String exportWorkspaceAsyncPath = "/v1/workspaces_async/testString/export";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ExportWorkspaceAsyncOptions model
    ExportWorkspaceAsyncOptions exportWorkspaceAsyncOptionsModel =
        new ExportWorkspaceAsyncOptions.Builder()
            .workspaceId("testString")
            .includeAudit(false)
            .sort("stable")
            .verbose(false)
            .build();

    // Invoke exportWorkspaceAsync() with a valid options model and verify the result
    Response<Workspace> response =
        assistantService.exportWorkspaceAsync(exportWorkspaceAsyncOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, exportWorkspaceAsyncPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "stable");
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(false));
  }

  // Test the exportWorkspaceAsync operation with and without retries enabled
  @Test
  public void testExportWorkspaceAsyncWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testExportWorkspaceAsyncWOptions();

    assistantService.disableRetries();
    testExportWorkspaceAsyncWOptions();
  }

  // Test the exportWorkspaceAsync operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testExportWorkspaceAsyncNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.exportWorkspaceAsync(null).execute();
  }

  // Test the listIntents operation with a valid options model parameter
  @Test
  public void testListIntentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listIntentsPath = "/v1/workspaces/testString/intents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListIntentsOptions model
    ListIntentsOptions listIntentsOptionsModel =
        new ListIntentsOptions.Builder()
            .workspaceId("testString")
            .export(false)
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("intent")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listIntents() with a valid options model and verify the result
    Response<IntentCollection> response =
        assistantService.listIntents(listIntentsOptionsModel).execute();
    assertNotNull(response);
    IntentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listIntentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "intent");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listIntents operation with and without retries enabled
  @Test
  public void testListIntentsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListIntentsWOptions();

    assistantService.disableRetries();
    testListIntentsWOptions();
  }

  // Test the listIntents operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListIntentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listIntents(null).execute();
  }

  // Test the createIntent operation with a valid options model parameter
  @Test
  public void testCreateIntentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String createIntentPath = "/v1/workspaces/testString/intents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the CreateIntentOptions model
    CreateIntentOptions createIntentOptionsModel =
        new CreateIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .description("testString")
            .examples(java.util.Arrays.asList(exampleModel))
            .includeAudit(false)
            .build();

    // Invoke createIntent() with a valid options model and verify the result
    Response<Intent> response = assistantService.createIntent(createIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createIntentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createIntent operation with and without retries enabled
  @Test
  public void testCreateIntentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateIntentWOptions();

    assistantService.disableRetries();
    testCreateIntentWOptions();
  }

  // Test the createIntent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateIntentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createIntent(null).execute();
  }

  // Test the getIntent operation with a valid options model parameter
  @Test
  public void testGetIntentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getIntentPath = "/v1/workspaces/testString/intents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetIntentOptions model
    GetIntentOptions getIntentOptionsModel =
        new GetIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .export(false)
            .includeAudit(false)
            .build();

    // Invoke getIntent() with a valid options model and verify the result
    Response<Intent> response = assistantService.getIntent(getIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getIntentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getIntent operation with and without retries enabled
  @Test
  public void testGetIntentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetIntentWOptions();

    assistantService.disableRetries();
    testGetIntentWOptions();
  }

  // Test the getIntent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetIntentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getIntent(null).execute();
  }

  // Test the updateIntent operation with a valid options model parameter
  @Test
  public void testUpdateIntentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String updateIntentPath = "/v1/workspaces/testString/intents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .build();

    // Construct an instance of the UpdateIntentOptions model
    UpdateIntentOptions updateIntentOptionsModel =
        new UpdateIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .newIntent("testString")
            .newDescription("testString")
            .newExamples(java.util.Arrays.asList(exampleModel))
            .append(false)
            .includeAudit(false)
            .build();

    // Invoke updateIntent() with a valid options model and verify the result
    Response<Intent> response = assistantService.updateIntent(updateIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateIntentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateIntent operation with and without retries enabled
  @Test
  public void testUpdateIntentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateIntentWOptions();

    assistantService.disableRetries();
    testUpdateIntentWOptions();
  }

  // Test the updateIntent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateIntentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateIntent(null).execute();
  }

  // Test the deleteIntent operation with a valid options model parameter
  @Test
  public void testDeleteIntentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteIntentPath = "/v1/workspaces/testString/intents/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteIntentOptions model
    DeleteIntentOptions deleteIntentOptionsModel =
        new DeleteIntentOptions.Builder().workspaceId("testString").intent("testString").build();

    // Invoke deleteIntent() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteIntent(deleteIntentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteIntentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteIntent operation with and without retries enabled
  @Test
  public void testDeleteIntentWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteIntentWOptions();

    assistantService.disableRetries();
    testDeleteIntentWOptions();
  }

  // Test the deleteIntent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteIntentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteIntent(null).execute();
  }

  // Test the listExamples operation with a valid options model parameter
  @Test
  public void testListExamplesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listExamplesPath = "/v1/workspaces/testString/intents/testString/examples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListExamplesOptions model
    ListExamplesOptions listExamplesOptionsModel =
        new ListExamplesOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("text")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listExamples() with a valid options model and verify the result
    Response<ExampleCollection> response =
        assistantService.listExamples(listExamplesOptionsModel).execute();
    assertNotNull(response);
    ExampleCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listExamplesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "text");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listExamples operation with and without retries enabled
  @Test
  public void testListExamplesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListExamplesWOptions();

    assistantService.disableRetries();
    testListExamplesWOptions();
  }

  // Test the listExamples operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListExamplesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listExamples(null).execute();
  }

  // Test the createExample operation with a valid options model parameter
  @Test
  public void testCreateExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createExamplePath = "/v1/workspaces/testString/intents/testString/examples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the CreateExampleOptions model
    CreateExampleOptions createExampleOptionsModel =
        new CreateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .mentions(java.util.Arrays.asList(mentionModel))
            .includeAudit(false)
            .build();

    // Invoke createExample() with a valid options model and verify the result
    Response<Example> response =
        assistantService.createExample(createExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createExample operation with and without retries enabled
  @Test
  public void testCreateExampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateExampleWOptions();

    assistantService.disableRetries();
    testCreateExampleWOptions();
  }

  // Test the createExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createExample(null).execute();
  }

  // Test the getExample operation with a valid options model parameter
  @Test
  public void testGetExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetExampleOptions model
    GetExampleOptions getExampleOptionsModel =
        new GetExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .includeAudit(false)
            .build();

    // Invoke getExample() with a valid options model and verify the result
    Response<Example> response = assistantService.getExample(getExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getExample operation with and without retries enabled
  @Test
  public void testGetExampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetExampleWOptions();

    assistantService.disableRetries();
    testGetExampleWOptions();
  }

  // Test the getExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getExample(null).execute();
  }

  // Test the updateExample operation with a valid options model parameter
  @Test
  public void testUpdateExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();

    // Construct an instance of the UpdateExampleOptions model
    UpdateExampleOptions updateExampleOptionsModel =
        new UpdateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .newText("testString")
            .newMentions(java.util.Arrays.asList(mentionModel))
            .includeAudit(false)
            .build();

    // Invoke updateExample() with a valid options model and verify the result
    Response<Example> response =
        assistantService.updateExample(updateExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateExample operation with and without retries enabled
  @Test
  public void testUpdateExampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateExampleWOptions();

    assistantService.disableRetries();
    testUpdateExampleWOptions();
  }

  // Test the updateExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateExample(null).execute();
  }

  // Test the deleteExample operation with a valid options model parameter
  @Test
  public void testDeleteExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteExampleOptions model
    DeleteExampleOptions deleteExampleOptionsModel =
        new DeleteExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .build();

    // Invoke deleteExample() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteExample(deleteExampleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteExample operation with and without retries enabled
  @Test
  public void testDeleteExampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteExampleWOptions();

    assistantService.disableRetries();
    testDeleteExampleWOptions();
  }

  // Test the deleteExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteExample(null).execute();
  }

  // Test the listCounterexamples operation with a valid options model parameter
  @Test
  public void testListCounterexamplesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listCounterexamplesPath = "/v1/workspaces/testString/counterexamples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCounterexamplesOptions model
    ListCounterexamplesOptions listCounterexamplesOptionsModel =
        new ListCounterexamplesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("text")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listCounterexamples() with a valid options model and verify the result
    Response<CounterexampleCollection> response =
        assistantService.listCounterexamples(listCounterexamplesOptionsModel).execute();
    assertNotNull(response);
    CounterexampleCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCounterexamplesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "text");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listCounterexamples operation with and without retries enabled
  @Test
  public void testListCounterexamplesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListCounterexamplesWOptions();

    assistantService.disableRetries();
    testListCounterexamplesWOptions();
  }

  // Test the listCounterexamples operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCounterexamplesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listCounterexamples(null).execute();
  }

  // Test the createCounterexample operation with a valid options model parameter
  @Test
  public void testCreateCounterexampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createCounterexamplePath = "/v1/workspaces/testString/counterexamples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateCounterexampleOptions model
    CreateCounterexampleOptions createCounterexampleOptionsModel =
        new CreateCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .includeAudit(false)
            .build();

    // Invoke createCounterexample() with a valid options model and verify the result
    Response<Counterexample> response =
        assistantService.createCounterexample(createCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCounterexamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createCounterexample operation with and without retries enabled
  @Test
  public void testCreateCounterexampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateCounterexampleWOptions();

    assistantService.disableRetries();
    testCreateCounterexampleWOptions();
  }

  // Test the createCounterexample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCounterexampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createCounterexample(null).execute();
  }

  // Test the getCounterexample operation with a valid options model parameter
  @Test
  public void testGetCounterexampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCounterexampleOptions model
    GetCounterexampleOptions getCounterexampleOptionsModel =
        new GetCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .includeAudit(false)
            .build();

    // Invoke getCounterexample() with a valid options model and verify the result
    Response<Counterexample> response =
        assistantService.getCounterexample(getCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCounterexamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getCounterexample operation with and without retries enabled
  @Test
  public void testGetCounterexampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetCounterexampleWOptions();

    assistantService.disableRetries();
    testGetCounterexampleWOptions();
  }

  // Test the getCounterexample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCounterexampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getCounterexample(null).execute();
  }

  // Test the updateCounterexample operation with a valid options model parameter
  @Test
  public void testUpdateCounterexampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateCounterexampleOptions model
    UpdateCounterexampleOptions updateCounterexampleOptionsModel =
        new UpdateCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .newText("testString")
            .includeAudit(false)
            .build();

    // Invoke updateCounterexample() with a valid options model and verify the result
    Response<Counterexample> response =
        assistantService.updateCounterexample(updateCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCounterexamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateCounterexample operation with and without retries enabled
  @Test
  public void testUpdateCounterexampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateCounterexampleWOptions();

    assistantService.disableRetries();
    testUpdateCounterexampleWOptions();
  }

  // Test the updateCounterexample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCounterexampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateCounterexample(null).execute();
  }

  // Test the deleteCounterexample operation with a valid options model parameter
  @Test
  public void testDeleteCounterexampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteCounterexampleOptions model
    DeleteCounterexampleOptions deleteCounterexampleOptionsModel =
        new DeleteCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .build();

    // Invoke deleteCounterexample() with a valid options model and verify the result
    Response<Void> response =
        assistantService.deleteCounterexample(deleteCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCounterexamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteCounterexample operation with and without retries enabled
  @Test
  public void testDeleteCounterexampleWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteCounterexampleWOptions();

    assistantService.disableRetries();
    testDeleteCounterexampleWOptions();
  }

  // Test the deleteCounterexample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCounterexampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteCounterexample(null).execute();
  }

  // Test the listEntities operation with a valid options model parameter
  @Test
  public void testListEntitiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listEntitiesPath = "/v1/workspaces/testString/entities";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListEntitiesOptions model
    ListEntitiesOptions listEntitiesOptionsModel =
        new ListEntitiesOptions.Builder()
            .workspaceId("testString")
            .export(false)
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("entity")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listEntities() with a valid options model and verify the result
    Response<EntityCollection> response =
        assistantService.listEntities(listEntitiesOptionsModel).execute();
    assertNotNull(response);
    EntityCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEntitiesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "entity");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listEntities operation with and without retries enabled
  @Test
  public void testListEntitiesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListEntitiesWOptions();

    assistantService.disableRetries();
    testListEntitiesWOptions();
  }

  // Test the listEntities operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEntitiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listEntities(null).execute();
  }

  // Test the createEntity operation with a valid options model parameter
  @Test
  public void testCreateEntityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String createEntityPath = "/v1/workspaces/testString/entities";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateEntityOptions model
    CreateEntityOptions createEntityOptionsModel =
        new CreateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .description("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .includeAudit(false)
            .build();

    // Invoke createEntity() with a valid options model and verify the result
    Response<Entity> response = assistantService.createEntity(createEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEntityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createEntity operation with and without retries enabled
  @Test
  public void testCreateEntityWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateEntityWOptions();

    assistantService.disableRetries();
    testCreateEntityWOptions();
  }

  // Test the createEntity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEntityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createEntity(null).execute();
  }

  // Test the getEntity operation with a valid options model parameter
  @Test
  public void testGetEntityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getEntityPath = "/v1/workspaces/testString/entities/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetEntityOptions model
    GetEntityOptions getEntityOptionsModel =
        new GetEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(false)
            .includeAudit(false)
            .build();

    // Invoke getEntity() with a valid options model and verify the result
    Response<Entity> response = assistantService.getEntity(getEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEntityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getEntity operation with and without retries enabled
  @Test
  public void testGetEntityWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetEntityWOptions();

    assistantService.disableRetries();
    testGetEntityWOptions();
  }

  // Test the getEntity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEntityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getEntity(null).execute();
  }

  // Test the updateEntity operation with a valid options model parameter
  @Test
  public void testUpdateEntityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String updateEntityPath = "/v1/workspaces/testString/entities/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the UpdateEntityOptions model
    UpdateEntityOptions updateEntityOptionsModel =
        new UpdateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .newEntity("testString")
            .newDescription("testString")
            .newMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .newFuzzyMatch(true)
            .newValues(java.util.Arrays.asList(createValueModel))
            .append(false)
            .includeAudit(false)
            .build();

    // Invoke updateEntity() with a valid options model and verify the result
    Response<Entity> response = assistantService.updateEntity(updateEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEntityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateEntity operation with and without retries enabled
  @Test
  public void testUpdateEntityWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateEntityWOptions();

    assistantService.disableRetries();
    testUpdateEntityWOptions();
  }

  // Test the updateEntity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEntityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateEntity(null).execute();
  }

  // Test the deleteEntity operation with a valid options model parameter
  @Test
  public void testDeleteEntityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteEntityPath = "/v1/workspaces/testString/entities/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteEntityOptions model
    DeleteEntityOptions deleteEntityOptionsModel =
        new DeleteEntityOptions.Builder().workspaceId("testString").entity("testString").build();

    // Invoke deleteEntity() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteEntity(deleteEntityOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteEntityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteEntity operation with and without retries enabled
  @Test
  public void testDeleteEntityWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteEntityWOptions();

    assistantService.disableRetries();
    testDeleteEntityWOptions();
  }

  // Test the deleteEntity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEntityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteEntity(null).execute();
  }

  // Test the listMentions operation with a valid options model parameter
  @Test
  public void testListMentionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"examples\": [{\"text\": \"text\", \"intent\": \"intent\", \"location\": [8]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listMentionsPath = "/v1/workspaces/testString/entities/testString/mentions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListMentionsOptions model
    ListMentionsOptions listMentionsOptionsModel =
        new ListMentionsOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(false)
            .includeAudit(false)
            .build();

    // Invoke listMentions() with a valid options model and verify the result
    Response<EntityMentionCollection> response =
        assistantService.listMentions(listMentionsOptionsModel).execute();
    assertNotNull(response);
    EntityMentionCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listMentionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listMentions operation with and without retries enabled
  @Test
  public void testListMentionsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListMentionsWOptions();

    assistantService.disableRetries();
    testListMentionsWOptions();
  }

  // Test the listMentions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListMentionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listMentions(null).execute();
  }

  // Test the listValues operation with a valid options model parameter
  @Test
  public void testListValuesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"values\": [{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listValuesPath = "/v1/workspaces/testString/entities/testString/values";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListValuesOptions model
    ListValuesOptions listValuesOptionsModel =
        new ListValuesOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(false)
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("value")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listValues() with a valid options model and verify the result
    Response<ValueCollection> response =
        assistantService.listValues(listValuesOptionsModel).execute();
    assertNotNull(response);
    ValueCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listValuesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "value");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listValues operation with and without retries enabled
  @Test
  public void testListValuesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListValuesWOptions();

    assistantService.disableRetries();
    testListValuesWOptions();
  }

  // Test the listValues operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListValuesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listValues(null).execute();
  }

  // Test the createValue operation with a valid options model parameter
  @Test
  public void testCreateValueWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createValuePath = "/v1/workspaces/testString/entities/testString/values";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateValueOptions model
    CreateValueOptions createValueOptionsModel =
        new CreateValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .includeAudit(false)
            .build();

    // Invoke createValue() with a valid options model and verify the result
    Response<Value> response = assistantService.createValue(createValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createValuePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createValue operation with and without retries enabled
  @Test
  public void testCreateValueWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateValueWOptions();

    assistantService.disableRetries();
    testCreateValueWOptions();
  }

  // Test the createValue operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateValueNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createValue(null).execute();
  }

  // Test the getValue operation with a valid options model parameter
  @Test
  public void testGetValueWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getValuePath = "/v1/workspaces/testString/entities/testString/values/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetValueOptions model
    GetValueOptions getValueOptionsModel =
        new GetValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .export(false)
            .includeAudit(false)
            .build();

    // Invoke getValue() with a valid options model and verify the result
    Response<Value> response = assistantService.getValue(getValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getValuePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getValue operation with and without retries enabled
  @Test
  public void testGetValueWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetValueWOptions();

    assistantService.disableRetries();
    testGetValueWOptions();
  }

  // Test the getValue operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetValueNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getValue(null).execute();
  }

  // Test the updateValue operation with a valid options model parameter
  @Test
  public void testUpdateValueWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateValuePath = "/v1/workspaces/testString/entities/testString/values/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateValueOptions model
    UpdateValueOptions updateValueOptionsModel =
        new UpdateValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .newValue("testString")
            .newMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .newType("synonyms")
            .newSynonyms(java.util.Arrays.asList("testString"))
            .newPatterns(java.util.Arrays.asList("testString"))
            .append(false)
            .includeAudit(false)
            .build();

    // Invoke updateValue() with a valid options model and verify the result
    Response<Value> response = assistantService.updateValue(updateValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateValuePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateValue operation with and without retries enabled
  @Test
  public void testUpdateValueWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateValueWOptions();

    assistantService.disableRetries();
    testUpdateValueWOptions();
  }

  // Test the updateValue operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateValueNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateValue(null).execute();
  }

  // Test the deleteValue operation with a valid options model parameter
  @Test
  public void testDeleteValueWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteValuePath = "/v1/workspaces/testString/entities/testString/values/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteValueOptions model
    DeleteValueOptions deleteValueOptionsModel =
        new DeleteValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .build();

    // Invoke deleteValue() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteValue(deleteValueOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteValuePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteValue operation with and without retries enabled
  @Test
  public void testDeleteValueWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteValueWOptions();

    assistantService.disableRetries();
    testDeleteValueWOptions();
  }

  // Test the deleteValue operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteValueNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteValue(null).execute();
  }

  // Test the listSynonyms operation with a valid options model parameter
  @Test
  public void testListSynonymsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"synonyms\": [{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listSynonymsPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListSynonymsOptions model
    ListSynonymsOptions listSynonymsOptionsModel =
        new ListSynonymsOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("synonym")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listSynonyms() with a valid options model and verify the result
    Response<SynonymCollection> response =
        assistantService.listSynonyms(listSynonymsOptionsModel).execute();
    assertNotNull(response);
    SynonymCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSynonymsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "synonym");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listSynonyms operation with and without retries enabled
  @Test
  public void testListSynonymsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListSynonymsWOptions();

    assistantService.disableRetries();
    testListSynonymsWOptions();
  }

  // Test the listSynonyms operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSynonymsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listSynonyms(null).execute();
  }

  // Test the createSynonym operation with a valid options model parameter
  @Test
  public void testCreateSynonymWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateSynonymOptions model
    CreateSynonymOptions createSynonymOptionsModel =
        new CreateSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .includeAudit(false)
            .build();

    // Invoke createSynonym() with a valid options model and verify the result
    Response<Synonym> response =
        assistantService.createSynonym(createSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSynonymPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createSynonym operation with and without retries enabled
  @Test
  public void testCreateSynonymWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateSynonymWOptions();

    assistantService.disableRetries();
    testCreateSynonymWOptions();
  }

  // Test the createSynonym operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSynonymNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createSynonym(null).execute();
  }

  // Test the getSynonym operation with a valid options model parameter
  @Test
  public void testGetSynonymWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetSynonymOptions model
    GetSynonymOptions getSynonymOptionsModel =
        new GetSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .includeAudit(false)
            .build();

    // Invoke getSynonym() with a valid options model and verify the result
    Response<Synonym> response = assistantService.getSynonym(getSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSynonymPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getSynonym operation with and without retries enabled
  @Test
  public void testGetSynonymWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetSynonymWOptions();

    assistantService.disableRetries();
    testGetSynonymWOptions();
  }

  // Test the getSynonym operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSynonymNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getSynonym(null).execute();
  }

  // Test the updateSynonym operation with a valid options model parameter
  @Test
  public void testUpdateSynonymWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateSynonymOptions model
    UpdateSynonymOptions updateSynonymOptionsModel =
        new UpdateSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .newSynonym("testString")
            .includeAudit(false)
            .build();

    // Invoke updateSynonym() with a valid options model and verify the result
    Response<Synonym> response =
        assistantService.updateSynonym(updateSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSynonymPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateSynonym operation with and without retries enabled
  @Test
  public void testUpdateSynonymWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateSynonymWOptions();

    assistantService.disableRetries();
    testUpdateSynonymWOptions();
  }

  // Test the updateSynonym operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSynonymNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateSynonym(null).execute();
  }

  // Test the deleteSynonym operation with a valid options model parameter
  @Test
  public void testDeleteSynonymWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteSynonymOptions model
    DeleteSynonymOptions deleteSynonymOptionsModel =
        new DeleteSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .build();

    // Invoke deleteSynonym() with a valid options model and verify the result
    Response<Void> response = assistantService.deleteSynonym(deleteSynonymOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSynonymPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteSynonym operation with and without retries enabled
  @Test
  public void testDeleteSynonymWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteSynonymWOptions();

    assistantService.disableRetries();
    testDeleteSynonymWOptions();
  }

  // Test the deleteSynonym operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSynonymNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteSynonym(null).execute();
  }

  // Test the listDialogNodes operation with a valid options model parameter
  @Test
  public void testListDialogNodesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listDialogNodesPath = "/v1/workspaces/testString/dialog_nodes";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListDialogNodesOptions model
    ListDialogNodesOptions listDialogNodesOptionsModel =
        new ListDialogNodesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("dialog_node")
            .cursor("testString")
            .includeAudit(false)
            .build();

    // Invoke listDialogNodes() with a valid options model and verify the result
    Response<DialogNodeCollection> response =
        assistantService.listDialogNodes(listDialogNodesOptionsModel).execute();
    assertNotNull(response);
    DialogNodeCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDialogNodesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "dialog_node");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the listDialogNodes operation with and without retries enabled
  @Test
  public void testListDialogNodesWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListDialogNodesWOptions();

    assistantService.disableRetries();
    testListDialogNodesWOptions();
  }

  // Test the listDialogNodes operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDialogNodesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listDialogNodes(null).execute();
  }

  // Test the createDialogNode operation with a valid options model parameter
  @Test
  public void testCreateDialogNodeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createDialogNodePath = "/v1/workspaces/testString/dialog_nodes";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the CreateDialogNodeOptions model
    CreateDialogNodeOptions createDialogNodeOptionsModel =
        new CreateDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .includeAudit(false)
            .build();

    // Invoke createDialogNode() with a valid options model and verify the result
    Response<DialogNode> response =
        assistantService.createDialogNode(createDialogNodeOptionsModel).execute();
    assertNotNull(response);
    DialogNode responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createDialogNodePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the createDialogNode operation with and without retries enabled
  @Test
  public void testCreateDialogNodeWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testCreateDialogNodeWOptions();

    assistantService.disableRetries();
    testCreateDialogNodeWOptions();
  }

  // Test the createDialogNode operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDialogNodeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.createDialogNode(null).execute();
  }

  // Test the getDialogNode operation with a valid options model parameter
  @Test
  public void testGetDialogNodeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDialogNodeOptions model
    GetDialogNodeOptions getDialogNodeOptionsModel =
        new GetDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .includeAudit(false)
            .build();

    // Invoke getDialogNode() with a valid options model and verify the result
    Response<DialogNode> response =
        assistantService.getDialogNode(getDialogNodeOptionsModel).execute();
    assertNotNull(response);
    DialogNode responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDialogNodePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the getDialogNode operation with and without retries enabled
  @Test
  public void testGetDialogNodeWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testGetDialogNodeWOptions();

    assistantService.disableRetries();
    testGetDialogNodeWOptions();
  }

  // Test the getDialogNode operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDialogNodeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.getDialogNode(null).execute();
  }

  // Test the updateDialogNode operation with a valid options model parameter
  @Test
  public void testUpdateDialogNodeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"text\", \"values\": [{\"text\": \"text\"}], \"selection_policy\": \"sequential\", \"delimiter\": \"\n\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": true}}, \"context\": {\"integrations\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}}, \"metadata\": {\"anyKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": false, \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DialogNodeOutputTextValuesElement model
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();

    // Construct an instance of the DialogNodeOutputModifiers model
    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    // Construct an instance of the DialogNodeOutput model
    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeContext model
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();

    // Construct an instance of the DialogNodeNextStep model
    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();

    // Construct an instance of the DialogNodeAction model
    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();

    // Construct an instance of the UpdateDialogNodeOptions model
    UpdateDialogNodeOptions updateDialogNodeOptionsModel =
        new UpdateDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .newDialogNode("testString")
            .newDescription("testString")
            .newConditions("testString")
            .newParent("testString")
            .newPreviousSibling("testString")
            .newOutput(dialogNodeOutputModel)
            .newContext(dialogNodeContextModel)
            .newMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .newNextStep(dialogNodeNextStepModel)
            .newTitle("testString")
            .newType("standard")
            .newEventName("focus")
            .newVariable("testString")
            .newActions(java.util.Arrays.asList(dialogNodeActionModel))
            .newDigressIn("not_available")
            .newDigressOut("allow_returning")
            .newDigressOutSlots("not_allowed")
            .newUserLabel("testString")
            .newDisambiguationOptOut(false)
            .includeAudit(false)
            .build();

    // Invoke updateDialogNode() with a valid options model and verify the result
    Response<DialogNode> response =
        assistantService.updateDialogNode(updateDialogNodeOptionsModel).execute();
    assertNotNull(response);
    DialogNode responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateDialogNodePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(false));
  }

  // Test the updateDialogNode operation with and without retries enabled
  @Test
  public void testUpdateDialogNodeWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testUpdateDialogNodeWOptions();

    assistantService.disableRetries();
    testUpdateDialogNodeWOptions();
  }

  // Test the updateDialogNode operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDialogNodeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.updateDialogNode(null).execute();
  }

  // Test the deleteDialogNode operation with a valid options model parameter
  @Test
  public void testDeleteDialogNodeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteDialogNodeOptions model
    DeleteDialogNodeOptions deleteDialogNodeOptionsModel =
        new DeleteDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .build();

    // Invoke deleteDialogNode() with a valid options model and verify the result
    Response<Void> response =
        assistantService.deleteDialogNode(deleteDialogNodeOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDialogNodePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteDialogNode operation with and without retries enabled
  @Test
  public void testDeleteDialogNodeWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testDeleteDialogNodeWOptions();

    assistantService.disableRetries();
    testDeleteDialogNodeWOptions();
  }

  // Test the deleteDialogNode operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDialogNodeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.deleteDialogNode(null).execute();
  }

  // Test the listLogs operation with a valid options model parameter
  @Test
  public void testListLogsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"logs\": [{\"request\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": false, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"anyKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"response\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": false, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"anyKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"log_id\": \"logId\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"workspace_id\": \"workspaceId\", \"language\": \"language\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
    String listLogsPath = "/v1/workspaces/testString/logs";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListLogsOptions model
    ListLogsOptions listLogsOptionsModel =
        new ListLogsOptions.Builder()
            .workspaceId("testString")
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

  // Test the listAllLogs operation with a valid options model parameter
  @Test
  public void testListAllLogsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"logs\": [{\"request\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": false, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"anyKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"response\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": false, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"anyKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"generic\": [{\"response_type\": \"text\", \"text\": \"text\", \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"log_id\": \"logId\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"workspace_id\": \"workspaceId\", \"language\": \"language\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
    String listAllLogsPath = "/v1/logs";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListAllLogsOptions model
    ListAllLogsOptions listAllLogsOptionsModel =
        new ListAllLogsOptions.Builder()
            .filter("testString")
            .sort("testString")
            .pageLimit(Long.valueOf("100"))
            .cursor("testString")
            .build();

    // Invoke listAllLogs() with a valid options model and verify the result
    Response<LogCollection> response =
        assistantService.listAllLogs(listAllLogsOptionsModel).execute();
    assertNotNull(response);
    LogCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAllLogsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(query.get("cursor"), "testString");
  }

  // Test the listAllLogs operation with and without retries enabled
  @Test
  public void testListAllLogsWRetries() throws Throwable {
    assistantService.enableRetries(4, 30);
    testListAllLogsWOptions();

    assistantService.disableRetries();
    testListAllLogsWOptions();
  }

  // Test the listAllLogs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAllLogsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    assistantService.listAllLogs(null).execute();
  }

  // Test the deleteUserData operation with a valid options model parameter
  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";
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
