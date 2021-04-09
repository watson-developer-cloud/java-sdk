/*
 * (C) Copyright IBM Corp. 2021.
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
import com.ibm.watson.assistant.v1.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v1.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v1.model.BulkClassifyUtterance;
import com.ibm.watson.assistant.v1.model.CaptureGroup;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.Counterexample;
import com.ibm.watson.assistant.v1.model.CounterexampleCollection;
import com.ibm.watson.assistant.v1.model.CreateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.CreateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.CreateEntity;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateExampleOptions;
import com.ibm.watson.assistant.v1.model.CreateIntent;
import com.ibm.watson.assistant.v1.model.CreateIntentOptions;
import com.ibm.watson.assistant.v1.model.CreateSynonymOptions;
import com.ibm.watson.assistant.v1.model.CreateValue;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DeleteCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.DeleteEntityOptions;
import com.ibm.watson.assistant.v1.model.DeleteExampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteIntentOptions;
import com.ibm.watson.assistant.v1.model.DeleteSynonymOptions;
import com.ibm.watson.assistant.v1.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v1.model.DeleteValueOptions;
import com.ibm.watson.assistant.v1.model.DeleteWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DialogNode;
import com.ibm.watson.assistant.v1.model.DialogNodeAction;
import com.ibm.watson.assistant.v1.model.DialogNodeCollection;
import com.ibm.watson.assistant.v1.model.DialogNodeContext;
import com.ibm.watson.assistant.v1.model.DialogNodeNextStep;
import com.ibm.watson.assistant.v1.model.DialogNodeOutput;
import com.ibm.watson.assistant.v1.model.DialogNodeOutputGeneric;
import com.ibm.watson.assistant.v1.model.DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill;
import com.ibm.watson.assistant.v1.model.DialogNodeOutputModifiers;
import com.ibm.watson.assistant.v1.model.DialogNodeOutputOptionsElement;
import com.ibm.watson.assistant.v1.model.DialogNodeOutputOptionsElementValue;
import com.ibm.watson.assistant.v1.model.DialogNodeVisitedDetails;
import com.ibm.watson.assistant.v1.model.Entity;
import com.ibm.watson.assistant.v1.model.EntityCollection;
import com.ibm.watson.assistant.v1.model.EntityMentionCollection;
import com.ibm.watson.assistant.v1.model.Example;
import com.ibm.watson.assistant.v1.model.ExampleCollection;
import com.ibm.watson.assistant.v1.model.GetCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.GetDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.GetEntityOptions;
import com.ibm.watson.assistant.v1.model.GetExampleOptions;
import com.ibm.watson.assistant.v1.model.GetIntentOptions;
import com.ibm.watson.assistant.v1.model.GetSynonymOptions;
import com.ibm.watson.assistant.v1.model.GetValueOptions;
import com.ibm.watson.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Intent;
import com.ibm.watson.assistant.v1.model.IntentCollection;
import com.ibm.watson.assistant.v1.model.ListAllLogsOptions;
import com.ibm.watson.assistant.v1.model.ListCounterexamplesOptions;
import com.ibm.watson.assistant.v1.model.ListDialogNodesOptions;
import com.ibm.watson.assistant.v1.model.ListEntitiesOptions;
import com.ibm.watson.assistant.v1.model.ListExamplesOptions;
import com.ibm.watson.assistant.v1.model.ListIntentsOptions;
import com.ibm.watson.assistant.v1.model.ListLogsOptions;
import com.ibm.watson.assistant.v1.model.ListMentionsOptions;
import com.ibm.watson.assistant.v1.model.ListSynonymsOptions;
import com.ibm.watson.assistant.v1.model.ListValuesOptions;
import com.ibm.watson.assistant.v1.model.ListWorkspacesOptions;
import com.ibm.watson.assistant.v1.model.LogCollection;
import com.ibm.watson.assistant.v1.model.LogMessage;
import com.ibm.watson.assistant.v1.model.LogMessageSource;
import com.ibm.watson.assistant.v1.model.Mention;
import com.ibm.watson.assistant.v1.model.MessageContextMetadata;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.OutputData;
import com.ibm.watson.assistant.v1.model.ResponseGenericChannel;
import com.ibm.watson.assistant.v1.model.RuntimeEntity;
import com.ibm.watson.assistant.v1.model.RuntimeEntityAlternative;
import com.ibm.watson.assistant.v1.model.RuntimeEntityInterpretation;
import com.ibm.watson.assistant.v1.model.RuntimeEntityRole;
import com.ibm.watson.assistant.v1.model.RuntimeIntent;
import com.ibm.watson.assistant.v1.model.RuntimeResponseGeneric;
import com.ibm.watson.assistant.v1.model.RuntimeResponseGenericRuntimeResponseTypeOption;
import com.ibm.watson.assistant.v1.model.Synonym;
import com.ibm.watson.assistant.v1.model.SynonymCollection;
import com.ibm.watson.assistant.v1.model.UpdateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.UpdateEntityOptions;
import com.ibm.watson.assistant.v1.model.UpdateExampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateIntentOptions;
import com.ibm.watson.assistant.v1.model.UpdateSynonymOptions;
import com.ibm.watson.assistant.v1.model.UpdateValueOptions;
import com.ibm.watson.assistant.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Value;
import com.ibm.watson.assistant.v1.model.ValueCollection;
import com.ibm.watson.assistant.v1.model.Webhook;
import com.ibm.watson.assistant.v1.model.WebhookHeader;
import com.ibm.watson.assistant.v1.model.Workspace;
import com.ibm.watson.assistant.v1.model.WorkspaceCollection;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettings;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsDisambiguation;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsOffTopic;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsSystemEntities;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsTooling;
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

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    assistantService = new Assistant(version, serviceName, authenticator);
    String url = server.url("/").toString();
    assistantService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new Assistant(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(assistantService.getVersion(), "testString");
  }

  @Test
  public void testMessageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": true, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"mapKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"text\": [\"text\"], \"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}]}}], \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}";
    String messagePath = "/v1/workspaces/testString/message";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the MessageInput model
    MessageInput messageInputModel =
        new MessageInput.Builder()
            .text("testString")
            .spellingSuggestions(true)
            .spellingAutoCorrect(true)
            .add("foo", "testString")
            .build();

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
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .groups(
                new java.util.ArrayList<CaptureGroup>(java.util.Arrays.asList(captureGroupModel)))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(
                new java.util.ArrayList<RuntimeEntityAlternative>(
                    java.util.Arrays.asList(runtimeEntityAlternativeModel)))
            .role(runtimeEntityRoleModel)
            .build();

    // Construct an instance of the MessageContextMetadata model
    MessageContextMetadata messageContextMetadataModel =
        new MessageContextMetadata.Builder().deployment("testString").userId("testString").build();

    // Construct an instance of the Context model
    Context contextModel =
        new Context.Builder()
            .conversationId("testString")
            .system(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
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

    // Construct an instance of the DialogNodeOutputOptionsElementValue model
    DialogNodeOutputOptionsElementValue dialogNodeOutputOptionsElementValueModel =
        new DialogNodeOutputOptionsElementValue.Builder()
            .input(messageInputModel)
            .intents(
                new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)))
            .entities(
                new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)))
            .build();

    // Construct an instance of the DialogNodeOutputOptionsElement model
    DialogNodeOutputOptionsElement dialogNodeOutputOptionsElementModel =
        new DialogNodeOutputOptionsElement.Builder()
            .label("testString")
            .value(dialogNodeOutputOptionsElementValueModel)
            .build();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the RuntimeResponseGenericRuntimeResponseTypeOption model
    RuntimeResponseGenericRuntimeResponseTypeOption runtimeResponseGenericModel =
        new RuntimeResponseGenericRuntimeResponseTypeOption.Builder()
            .responseType("option")
            .title("testString")
            .description("testString")
            .preference("dropdown")
            .options(
                new java.util.ArrayList<DialogNodeOutputOptionsElement>(
                    java.util.Arrays.asList(dialogNodeOutputOptionsElementModel)))
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
            .build();

    // Construct an instance of the OutputData model
    OutputData outputDataModel =
        new OutputData.Builder()
            .nodesVisited(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .nodesVisitedDetails(
                new java.util.ArrayList<DialogNodeVisitedDetails>(
                    java.util.Arrays.asList(dialogNodeVisitedDetailsModel)))
            .logMessages(
                new java.util.ArrayList<LogMessage>(java.util.Arrays.asList(logMessageModel)))
            .text(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .generic(
                new java.util.ArrayList<RuntimeResponseGeneric>(
                    java.util.Arrays.asList(runtimeResponseGenericModel)))
            .add("foo", "testString")
            .build();

    // Construct an instance of the MessageOptions model
    MessageOptions messageOptionsModel =
        new MessageOptions.Builder()
            .workspaceId("testString")
            .input(messageInputModel)
            .intents(
                new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)))
            .entities(
                new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)))
            .alternateIntents(true)
            .context(contextModel)
            .output(outputDataModel)
            .userId("testString")
            .nodesVisitedDetails(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<MessageResponse> response = assistantService.message(messageOptionsModel).execute();
    assertNotNull(response);
    MessageResponse responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("nodes_visited_details")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, messagePath);
  }

  // Test the message operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMessageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.message(null).execute();
  }

  @Test
  public void testBulkClassifyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"output\": [{\"input\": {\"text\": \"text\"}, \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}]}]}";
    String bulkClassifyPath = "/v1/workspaces/testString/bulk_classify";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BulkClassifyUtterance model
    BulkClassifyUtterance bulkClassifyUtteranceModel =
        new BulkClassifyUtterance.Builder().text("testString").build();

    // Construct an instance of the BulkClassifyOptions model
    BulkClassifyOptions bulkClassifyOptionsModel =
        new BulkClassifyOptions.Builder()
            .workspaceId("testString")
            .input(
                new java.util.ArrayList<BulkClassifyUtterance>(
                    java.util.Arrays.asList(bulkClassifyUtteranceModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<BulkClassifyResponse> response =
        assistantService.bulkClassify(bulkClassifyOptionsModel).execute();
    assertNotNull(response);
    BulkClassifyResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, bulkClassifyPath);
  }

  // Test the bulkClassify operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBulkClassifyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.bulkClassify(null).execute();
  }

  @Test
  public void testListWorkspacesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"workspaces\": [{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"learning_opt_out\": true, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"mapKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}}, \"status\": \"Non Existent\", \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listWorkspacesPath = "/v1/workspaces";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListWorkspacesOptions model
    ListWorkspacesOptions listWorkspacesOptionsModel =
        new ListWorkspacesOptions.Builder()
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("name")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<WorkspaceCollection> response =
        assistantService.listWorkspaces(listWorkspacesOptionsModel).execute();
    assertNotNull(response);
    WorkspaceCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "name");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listWorkspacesPath);
  }

  @Test
  public void testCreateWorkspaceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"learning_opt_out\": true, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"mapKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}}, \"status\": \"Non Existent\", \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}";
    String createWorkspacePath = "/v1/workspaces";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    // model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
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
            .enabled(true)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(true).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(true).build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .spellingSuggestions(true)
            .spellingAutoCorrect(true)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(
                new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .build();

    // Construct an instance of the CreateWorkspaceOptions model
    CreateWorkspaceOptions createWorkspaceOptionsModel =
        new CreateWorkspaceOptions.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(
                new java.util.ArrayList<DialogNode>(java.util.Arrays.asList(dialogNodeModel)))
            .counterexamples(
                new java.util.ArrayList<Counterexample>(
                    java.util.Arrays.asList(counterexampleModel)))
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .learningOptOut(true)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(new java.util.ArrayList<Webhook>(java.util.Arrays.asList(webhookModel)))
            .intents(
                new java.util.ArrayList<CreateIntent>(java.util.Arrays.asList(createIntentModel)))
            .entities(
                new java.util.ArrayList<CreateEntity>(java.util.Arrays.asList(createEntityModel)))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Workspace> response =
        assistantService.createWorkspace(createWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
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
    assertEquals(parsedPath, createWorkspacePath);
  }

  @Test
  public void testGetWorkspaceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"learning_opt_out\": true, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"mapKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}}, \"status\": \"Non Existent\", \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}";
    String getWorkspacePath = "/v1/workspaces/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetWorkspaceOptions model
    GetWorkspaceOptions getWorkspaceOptionsModel =
        new GetWorkspaceOptions.Builder()
            .workspaceId("testString")
            .export(true)
            .includeAudit(true)
            .sort("stable")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Workspace> response =
        assistantService.getWorkspace(getWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "stable");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getWorkspacePath);
  }

  // Test the getWorkspace operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetWorkspaceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getWorkspace(null).execute();
  }

  @Test
  public void testUpdateWorkspaceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"description\": \"description\", \"language\": \"language\", \"workspace_id\": \"workspaceId\", \"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"learning_opt_out\": true, \"system_settings\": {\"tooling\": {\"store_generic_responses\": false}, \"disambiguation\": {\"prompt\": \"prompt\", \"none_of_the_above_prompt\": \"noneOfTheAbovePrompt\", \"enabled\": false, \"sensitivity\": \"auto\", \"randomize\": false, \"max_suggestions\": 1, \"suggestion_text_policy\": \"suggestionTextPolicy\"}, \"human_agent_assist\": {\"mapKey\": \"anyValue\"}, \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"system_entities\": {\"enabled\": false}, \"off_topic\": {\"enabled\": false}}, \"status\": \"Non Existent\", \"webhooks\": [{\"url\": \"url\", \"name\": \"name\", \"headers\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}";
    String updateWorkspacePath = "/v1/workspaces/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    // model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
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
            .enabled(true)
            .sensitivity("auto")
            .randomize(true)
            .maxSuggestions(Long.valueOf("1"))
            .suggestionTextPolicy("testString")
            .build();

    // Construct an instance of the WorkspaceSystemSettingsSystemEntities model
    WorkspaceSystemSettingsSystemEntities workspaceSystemSettingsSystemEntitiesModel =
        new WorkspaceSystemSettingsSystemEntities.Builder().enabled(true).build();

    // Construct an instance of the WorkspaceSystemSettingsOffTopic model
    WorkspaceSystemSettingsOffTopic workspaceSystemSettingsOffTopicModel =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(true).build();

    // Construct an instance of the WorkspaceSystemSettings model
    WorkspaceSystemSettings workspaceSystemSettingsModel =
        new WorkspaceSystemSettings.Builder()
            .tooling(workspaceSystemSettingsToolingModel)
            .disambiguation(workspaceSystemSettingsDisambiguationModel)
            .humanAgentAssist(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .spellingSuggestions(true)
            .spellingAutoCorrect(true)
            .systemEntities(workspaceSystemSettingsSystemEntitiesModel)
            .offTopic(workspaceSystemSettingsOffTopicModel)
            .build();

    // Construct an instance of the WebhookHeader model
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();

    // Construct an instance of the Webhook model
    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(
                new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)))
            .build();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .build();

    // Construct an instance of the CreateIntent model
    CreateIntent createIntentModel =
        new CreateIntent.Builder()
            .intent("testString")
            .description("testString")
            .examples(new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)))
            .build();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateEntity model
    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .build();

    // Construct an instance of the UpdateWorkspaceOptions model
    UpdateWorkspaceOptions updateWorkspaceOptionsModel =
        new UpdateWorkspaceOptions.Builder()
            .workspaceId("testString")
            .name("testString")
            .description("testString")
            .language("testString")
            .dialogNodes(
                new java.util.ArrayList<DialogNode>(java.util.Arrays.asList(dialogNodeModel)))
            .counterexamples(
                new java.util.ArrayList<Counterexample>(
                    java.util.Arrays.asList(counterexampleModel)))
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .learningOptOut(true)
            .systemSettings(workspaceSystemSettingsModel)
            .webhooks(new java.util.ArrayList<Webhook>(java.util.Arrays.asList(webhookModel)))
            .intents(
                new java.util.ArrayList<CreateIntent>(java.util.Arrays.asList(createIntentModel)))
            .entities(
                new java.util.ArrayList<CreateEntity>(java.util.Arrays.asList(createEntityModel)))
            .append(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Workspace> response =
        assistantService.updateWorkspace(updateWorkspaceOptionsModel).execute();
    assertNotNull(response);
    Workspace responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateWorkspacePath);
  }

  // Test the updateWorkspace operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateWorkspaceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateWorkspace(null).execute();
  }

  @Test
  public void testDeleteWorkspaceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteWorkspacePath = "/v1/workspaces/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteWorkspaceOptions model
    DeleteWorkspaceOptions deleteWorkspaceOptionsModel =
        new DeleteWorkspaceOptions.Builder().workspaceId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        assistantService.deleteWorkspace(deleteWorkspaceOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteWorkspacePath);
  }

  // Test the deleteWorkspace operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteWorkspaceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteWorkspace(null).execute();
  }

  @Test
  public void testListIntentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"intents\": [{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listIntentsPath = "/v1/workspaces/testString/intents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListIntentsOptions model
    ListIntentsOptions listIntentsOptionsModel =
        new ListIntentsOptions.Builder()
            .workspaceId("testString")
            .export(true)
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("intent")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<IntentCollection> response =
        assistantService.listIntents(listIntentsOptionsModel).execute();
    assertNotNull(response);
    IntentCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "intent");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listIntentsPath);
  }

  // Test the listIntents operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListIntentsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listIntents(null).execute();
  }

  @Test
  public void testCreateIntentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String createIntentPath = "/v1/workspaces/testString/intents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .build();

    // Construct an instance of the CreateIntentOptions model
    CreateIntentOptions createIntentOptionsModel =
        new CreateIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .description("testString")
            .examples(new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Intent> response = assistantService.createIntent(createIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
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
    assertEquals(parsedPath, createIntentPath);
  }

  // Test the createIntent operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateIntentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createIntent(null).execute();
  }

  @Test
  public void testGetIntentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String getIntentPath = "/v1/workspaces/testString/intents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetIntentOptions model
    GetIntentOptions getIntentOptionsModel =
        new GetIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .export(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Intent> response = assistantService.getIntent(getIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getIntentPath);
  }

  // Test the getIntent operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetIntentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getIntent(null).execute();
  }

  @Test
  public void testUpdateIntentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"intent\": \"intent\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String updateIntentPath = "/v1/workspaces/testString/intents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the Example model
    Example exampleModel =
        new Example.Builder()
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .build();

    // Construct an instance of the UpdateIntentOptions model
    UpdateIntentOptions updateIntentOptionsModel =
        new UpdateIntentOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .newIntent("testString")
            .newDescription("testString")
            .newExamples(new java.util.ArrayList<Example>(java.util.Arrays.asList(exampleModel)))
            .append(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Intent> response = assistantService.updateIntent(updateIntentOptionsModel).execute();
    assertNotNull(response);
    Intent responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateIntentPath);
  }

  // Test the updateIntent operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateIntentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateIntent(null).execute();
  }

  @Test
  public void testDeleteIntentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteIntentPath = "/v1/workspaces/testString/intents/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteIntentOptions model
    DeleteIntentOptions deleteIntentOptionsModel =
        new DeleteIntentOptions.Builder().workspaceId("testString").intent("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteIntent(deleteIntentOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteIntentPath);
  }

  // Test the deleteIntent operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteIntentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteIntent(null).execute();
  }

  @Test
  public void testListExamplesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"examples\": [{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listExamplesPath = "/v1/workspaces/testString/intents/testString/examples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListExamplesOptions model
    ListExamplesOptions listExamplesOptionsModel =
        new ListExamplesOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("text")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ExampleCollection> response =
        assistantService.listExamples(listExamplesOptionsModel).execute();
    assertNotNull(response);
    ExampleCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "text");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listExamplesPath);
  }

  // Test the listExamples operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListExamplesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listExamples(null).execute();
  }

  @Test
  public void testCreateExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String createExamplePath = "/v1/workspaces/testString/intents/testString/examples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the CreateExampleOptions model
    CreateExampleOptions createExampleOptionsModel =
        new CreateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .mentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Example> response =
        assistantService.createExample(createExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
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
    assertEquals(parsedPath, createExamplePath);
  }

  // Test the createExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createExample(null).execute();
  }

  @Test
  public void testGetExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String getExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetExampleOptions model
    GetExampleOptions getExampleOptionsModel =
        new GetExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Example> response = assistantService.getExample(getExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getExamplePath);
  }

  // Test the getExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getExample(null).execute();
  }

  @Test
  public void testUpdateExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"mentions\": [{\"entity\": \"entity\", \"location\": [8]}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Mention model
    Mention mentionModel =
        new Mention.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();

    // Construct an instance of the UpdateExampleOptions model
    UpdateExampleOptions updateExampleOptionsModel =
        new UpdateExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .newText("testString")
            .newMentions(new java.util.ArrayList<Mention>(java.util.Arrays.asList(mentionModel)))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Example> response =
        assistantService.updateExample(updateExampleOptionsModel).execute();
    assertNotNull(response);
    Example responseObj = response.getResult();
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
    assertEquals(parsedPath, updateExamplePath);
  }

  // Test the updateExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateExample(null).execute();
  }

  @Test
  public void testDeleteExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteExamplePath = "/v1/workspaces/testString/intents/testString/examples/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteExampleOptions model
    DeleteExampleOptions deleteExampleOptionsModel =
        new DeleteExampleOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .text("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteExample(deleteExampleOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteExamplePath);
  }

  // Test the deleteExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteExample(null).execute();
  }

  @Test
  public void testListCounterexamplesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"counterexamples\": [{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listCounterexamplesPath = "/v1/workspaces/testString/counterexamples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCounterexamplesOptions model
    ListCounterexamplesOptions listCounterexamplesOptionsModel =
        new ListCounterexamplesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("text")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CounterexampleCollection> response =
        assistantService.listCounterexamples(listCounterexamplesOptionsModel).execute();
    assertNotNull(response);
    CounterexampleCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "text");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCounterexamplesPath);
  }

  // Test the listCounterexamples operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCounterexamplesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listCounterexamples(null).execute();
  }

  @Test
  public void testCreateCounterexampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String createCounterexamplePath = "/v1/workspaces/testString/counterexamples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateCounterexampleOptions model
    CreateCounterexampleOptions createCounterexampleOptionsModel =
        new CreateCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Counterexample> response =
        assistantService.createCounterexample(createCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
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
    assertEquals(parsedPath, createCounterexamplePath);
  }

  // Test the createCounterexample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCounterexampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createCounterexample(null).execute();
  }

  @Test
  public void testGetCounterexampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String getCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCounterexampleOptions model
    GetCounterexampleOptions getCounterexampleOptionsModel =
        new GetCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Counterexample> response =
        assistantService.getCounterexample(getCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCounterexamplePath);
  }

  // Test the getCounterexample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCounterexampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getCounterexample(null).execute();
  }

  @Test
  public void testUpdateCounterexampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"text\": \"text\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateCounterexampleOptions model
    UpdateCounterexampleOptions updateCounterexampleOptionsModel =
        new UpdateCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .newText("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Counterexample> response =
        assistantService.updateCounterexample(updateCounterexampleOptionsModel).execute();
    assertNotNull(response);
    Counterexample responseObj = response.getResult();
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
    assertEquals(parsedPath, updateCounterexamplePath);
  }

  // Test the updateCounterexample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCounterexampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateCounterexample(null).execute();
  }

  @Test
  public void testDeleteCounterexampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCounterexamplePath = "/v1/workspaces/testString/counterexamples/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCounterexampleOptions model
    DeleteCounterexampleOptions deleteCounterexampleOptionsModel =
        new DeleteCounterexampleOptions.Builder()
            .workspaceId("testString")
            .text("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        assistantService.deleteCounterexample(deleteCounterexampleOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCounterexamplePath);
  }

  // Test the deleteCounterexample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCounterexampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteCounterexample(null).execute();
  }

  @Test
  public void testListEntitiesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"entities\": [{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listEntitiesPath = "/v1/workspaces/testString/entities";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListEntitiesOptions model
    ListEntitiesOptions listEntitiesOptionsModel =
        new ListEntitiesOptions.Builder()
            .workspaceId("testString")
            .export(true)
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("entity")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<EntityCollection> response =
        assistantService.listEntities(listEntitiesOptionsModel).execute();
    assertNotNull(response);
    EntityCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "entity");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEntitiesPath);
  }

  // Test the listEntities operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEntitiesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listEntities(null).execute();
  }

  @Test
  public void testCreateEntityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String createEntityPath = "/v1/workspaces/testString/entities";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateEntityOptions model
    CreateEntityOptions createEntityOptionsModel =
        new CreateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Entity> response = assistantService.createEntity(createEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
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
    assertEquals(parsedPath, createEntityPath);
  }

  // Test the createEntity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEntityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createEntity(null).execute();
  }

  @Test
  public void testGetEntityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String getEntityPath = "/v1/workspaces/testString/entities/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetEntityOptions model
    GetEntityOptions getEntityOptionsModel =
        new GetEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Entity> response = assistantService.getEntity(getEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEntityPath);
  }

  // Test the getEntity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEntityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getEntity(null).execute();
  }

  @Test
  public void testUpdateEntityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"entity\": \"entity\", \"description\": \"description\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"fuzzy_match\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String updateEntityPath = "/v1/workspaces/testString/entities/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateValue model
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the UpdateEntityOptions model
    UpdateEntityOptions updateEntityOptionsModel =
        new UpdateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .newEntity("testString")
            .newDescription("testString")
            .newMetadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .newFuzzyMatch(true)
            .newValues(
                new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .append(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Entity> response = assistantService.updateEntity(updateEntityOptionsModel).execute();
    assertNotNull(response);
    Entity responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEntityPath);
  }

  // Test the updateEntity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEntityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateEntity(null).execute();
  }

  @Test
  public void testDeleteEntityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteEntityPath = "/v1/workspaces/testString/entities/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteEntityOptions model
    DeleteEntityOptions deleteEntityOptionsModel =
        new DeleteEntityOptions.Builder().workspaceId("testString").entity("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteEntity(deleteEntityOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteEntityPath);
  }

  // Test the deleteEntity operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEntityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteEntity(null).execute();
  }

  @Test
  public void testListMentionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"examples\": [{\"text\": \"text\", \"intent\": \"intent\", \"location\": [8]}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listMentionsPath = "/v1/workspaces/testString/entities/testString/mentions";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListMentionsOptions model
    ListMentionsOptions listMentionsOptionsModel =
        new ListMentionsOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<EntityMentionCollection> response =
        assistantService.listMentions(listMentionsOptionsModel).execute();
    assertNotNull(response);
    EntityMentionCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listMentionsPath);
  }

  // Test the listMentions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListMentionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listMentions(null).execute();
  }

  @Test
  public void testListValuesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"values\": [{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listValuesPath = "/v1/workspaces/testString/entities/testString/values";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListValuesOptions model
    ListValuesOptions listValuesOptionsModel =
        new ListValuesOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .export(true)
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("value")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ValueCollection> response =
        assistantService.listValues(listValuesOptionsModel).execute();
    assertNotNull(response);
    ValueCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "value");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listValuesPath);
  }

  // Test the listValues operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListValuesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listValues(null).execute();
  }

  @Test
  public void testCreateValueWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String createValuePath = "/v1/workspaces/testString/entities/testString/values";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateValueOptions model
    CreateValueOptions createValueOptionsModel =
        new CreateValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Value> response = assistantService.createValue(createValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
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
    assertEquals(parsedPath, createValuePath);
  }

  // Test the createValue operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateValueNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createValue(null).execute();
  }

  @Test
  public void testGetValueWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String getValuePath = "/v1/workspaces/testString/entities/testString/values/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetValueOptions model
    GetValueOptions getValueOptionsModel =
        new GetValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .export(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Value> response = assistantService.getValue(getValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("export")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getValuePath);
  }

  // Test the getValue operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetValueNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getValue(null).execute();
  }

  @Test
  public void testUpdateValueWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"value\": \"value\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"type\": \"synonyms\", \"synonyms\": [\"synonym\"], \"patterns\": [\"pattern\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateValuePath = "/v1/workspaces/testString/entities/testString/values/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateValueOptions model
    UpdateValueOptions updateValueOptionsModel =
        new UpdateValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .newValue("testString")
            .newMetadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .newType("synonyms")
            .newSynonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .newPatterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .append(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Value> response = assistantService.updateValue(updateValueOptionsModel).execute();
    assertNotNull(response);
    Value responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("append")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateValuePath);
  }

  // Test the updateValue operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateValueNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateValue(null).execute();
  }

  @Test
  public void testDeleteValueWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteValuePath = "/v1/workspaces/testString/entities/testString/values/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteValueOptions model
    DeleteValueOptions deleteValueOptionsModel =
        new DeleteValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteValue(deleteValueOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteValuePath);
  }

  // Test the deleteValue operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteValueNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteValue(null).execute();
  }

  @Test
  public void testListSynonymsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"synonyms\": [{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listSynonymsPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListSynonymsOptions model
    ListSynonymsOptions listSynonymsOptionsModel =
        new ListSynonymsOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("synonym")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<SynonymCollection> response =
        assistantService.listSynonyms(listSynonymsOptionsModel).execute();
    assertNotNull(response);
    SynonymCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "synonym");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSynonymsPath);
  }

  // Test the listSynonyms operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSynonymsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listSynonyms(null).execute();
  }

  @Test
  public void testCreateSynonymWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String createSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateSynonymOptions model
    CreateSynonymOptions createSynonymOptionsModel =
        new CreateSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Synonym> response =
        assistantService.createSynonym(createSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
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
    assertEquals(parsedPath, createSynonymPath);
  }

  // Test the createSynonym operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSynonymNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createSynonym(null).execute();
  }

  @Test
  public void testGetSynonymWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String getSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSynonymOptions model
    GetSynonymOptions getSynonymOptionsModel =
        new GetSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Synonym> response = assistantService.getSynonym(getSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSynonymPath);
  }

  // Test the getSynonym operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSynonymNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getSynonym(null).execute();
  }

  @Test
  public void testUpdateSynonymWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"synonym\": \"synonym\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateSynonymOptions model
    UpdateSynonymOptions updateSynonymOptionsModel =
        new UpdateSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .newSynonym("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Synonym> response =
        assistantService.updateSynonym(updateSynonymOptionsModel).execute();
    assertNotNull(response);
    Synonym responseObj = response.getResult();
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
    assertEquals(parsedPath, updateSynonymPath);
  }

  // Test the updateSynonym operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSynonymNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateSynonym(null).execute();
  }

  @Test
  public void testDeleteSynonymWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteSynonymPath =
        "/v1/workspaces/testString/entities/testString/values/testString/synonyms/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteSynonymOptions model
    DeleteSynonymOptions deleteSynonymOptionsModel =
        new DeleteSynonymOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .synonym("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteSynonym(deleteSynonymOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSynonymPath);
  }

  // Test the deleteSynonym operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSynonymNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteSynonym(null).execute();
  }

  @Test
  public void testListDialogNodesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"dialog_nodes\": [{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}], \"pagination\": {\"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5, \"matched\": 7, \"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\"}}";
    String listDialogNodesPath = "/v1/workspaces/testString/dialog_nodes";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListDialogNodesOptions model
    ListDialogNodesOptions listDialogNodesOptionsModel =
        new ListDialogNodesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("26"))
            .includeCount(true)
            .sort("dialog_node")
            .cursor("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DialogNodeCollection> response =
        assistantService.listDialogNodes(listDialogNodesOptionsModel).execute();
    assertNotNull(response);
    DialogNodeCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("include_count")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "dialog_node");
    assertEquals(query.get("cursor"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDialogNodesPath);
  }

  // Test the listDialogNodes operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDialogNodesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listDialogNodes(null).execute();
  }

  @Test
  public void testCreateDialogNodeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String createDialogNodePath = "/v1/workspaces/testString/dialog_nodes";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    // model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
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
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DialogNode> response =
        assistantService.createDialogNode(createDialogNodeOptionsModel).execute();
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
    assertEquals(parsedPath, createDialogNodePath);
  }

  // Test the createDialogNode operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDialogNodeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.createDialogNode(null).execute();
  }

  @Test
  public void testGetDialogNodeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String getDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDialogNodeOptions model
    GetDialogNodeOptions getDialogNodeOptionsModel =
        new GetDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DialogNode> response =
        assistantService.getDialogNode(getDialogNodeOptionsModel).execute();
    assertNotNull(response);
    DialogNode responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_audit")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDialogNodePath);
  }

  // Test the getDialogNode operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDialogNodeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.getDialogNode(null).execute();
  }

  @Test
  public void testUpdateDialogNodeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"dialog_node\": \"dialogNode\", \"description\": \"description\", \"conditions\": \"conditions\", \"parent\": \"parent\", \"previous_sibling\": \"previousSibling\", \"output\": {\"generic\": [{\"response_type\": \"search_skill\", \"query\": \"query\", \"query_type\": \"natural_language\", \"filter\": \"filter\", \"discovery_version\": \"discoveryVersion\", \"channels\": [{\"channel\": \"chat\"}]}], \"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}, \"modifiers\": {\"overwrite\": false}}, \"context\": {\"integrations\": {\"mapKey\": {\"mapKey\": \"anyValue\"}}}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"next_step\": {\"behavior\": \"get_user_input\", \"dialog_node\": \"dialogNode\", \"selector\": \"condition\"}, \"title\": \"title\", \"type\": \"standard\", \"event_name\": \"focus\", \"variable\": \"variable\", \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"digress_in\": \"not_available\", \"digress_out\": \"allow_returning\", \"digress_out_slots\": \"not_allowed\", \"user_label\": \"userLabel\", \"disambiguation_opt_out\": true, \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}";
    String updateDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResponseGenericChannel model
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();

    // Construct an instance of the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    // model
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
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
            .newMetadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .newNextStep(dialogNodeNextStepModel)
            .newTitle("testString")
            .newType("standard")
            .newEventName("focus")
            .newVariable("testString")
            .newActions(
                new java.util.ArrayList<DialogNodeAction>(
                    java.util.Arrays.asList(dialogNodeActionModel)))
            .newDigressIn("not_available")
            .newDigressOut("allow_returning")
            .newDigressOutSlots("not_allowed")
            .newUserLabel("testString")
            .newDisambiguationOptOut(true)
            .includeAudit(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DialogNode> response =
        assistantService.updateDialogNode(updateDialogNodeOptionsModel).execute();
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
    assertEquals(parsedPath, updateDialogNodePath);
  }

  // Test the updateDialogNode operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDialogNodeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.updateDialogNode(null).execute();
  }

  @Test
  public void testDeleteDialogNodeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteDialogNodePath = "/v1/workspaces/testString/dialog_nodes/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDialogNodeOptions model
    DeleteDialogNodeOptions deleteDialogNodeOptionsModel =
        new DeleteDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        assistantService.deleteDialogNode(deleteDialogNodeOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDialogNodePath);
  }

  // Test the deleteDialogNode operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDialogNodeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.deleteDialogNode(null).execute();
  }

  @Test
  public void testListLogsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"logs\": [{\"request\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": true, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"mapKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"text\": [\"text\"], \"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}]}}], \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"response\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": true, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"mapKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"text\": [\"text\"], \"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}]}}], \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"log_id\": \"logId\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"workspace_id\": \"workspaceId\", \"language\": \"language\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
    String listLogsPath = "/v1/workspaces/testString/logs";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListLogsOptions model
    ListLogsOptions listLogsOptionsModel =
        new ListLogsOptions.Builder()
            .workspaceId("testString")
            .sort("testString")
            .filter("testString")
            .pageLimit(Long.valueOf("26"))
            .cursor("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<LogCollection> response = assistantService.listLogs(listLogsOptionsModel).execute();
    assertNotNull(response);
    LogCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(query.get("cursor"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLogsPath);
  }

  // Test the listLogs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListLogsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listLogs(null).execute();
  }

  @Test
  public void testListAllLogsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"logs\": [{\"request\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": true, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"mapKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"text\": [\"text\"], \"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}]}}], \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"response\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}], \"alternate_intents\": true, \"context\": {\"conversation_id\": \"conversationId\", \"system\": {\"mapKey\": \"anyValue\"}, \"metadata\": {\"deployment\": \"deployment\", \"user_id\": \"userId\"}}, \"output\": {\"nodes_visited\": [\"nodesVisited\"], \"nodes_visited_details\": [{\"dialog_node\": \"dialogNode\", \"title\": \"title\", \"conditions\": \"conditions\"}], \"log_messages\": [{\"level\": \"info\", \"msg\": \"msg\", \"code\": \"code\", \"source\": {\"type\": \"dialog_node\", \"dialog_node\": \"dialogNode\"}}], \"text\": [\"text\"], \"generic\": [{\"response_type\": \"option\", \"title\": \"title\", \"description\": \"description\", \"preference\": \"dropdown\", \"options\": [{\"label\": \"label\", \"value\": {\"input\": {\"text\": \"text\", \"spelling_suggestions\": false, \"spelling_auto_correct\": false, \"suggested_text\": \"suggestedText\", \"original_text\": \"originalText\"}, \"intents\": [{\"intent\": \"intent\", \"confidence\": 10}], \"entities\": [{\"entity\": \"entity\", \"location\": [8], \"value\": \"value\", \"confidence\": 10, \"metadata\": {\"mapKey\": \"anyValue\"}, \"groups\": [{\"group\": \"group\", \"location\": [8]}], \"interpretation\": {\"calendar_type\": \"calendarType\", \"datetime_link\": \"datetimeLink\", \"festival\": \"festival\", \"granularity\": \"day\", \"range_link\": \"rangeLink\", \"range_modifier\": \"rangeModifier\", \"relative_day\": 11, \"relative_month\": 13, \"relative_week\": 12, \"relative_weekend\": 15, \"relative_year\": 12, \"specific_day\": 11, \"specific_day_of_week\": \"specificDayOfWeek\", \"specific_month\": 13, \"specific_quarter\": 15, \"specific_year\": 12, \"numeric_value\": 12, \"subtype\": \"subtype\", \"part_of_day\": \"partOfDay\", \"relative_hour\": 12, \"relative_minute\": 14, \"relative_second\": 14, \"specific_hour\": 12, \"specific_minute\": 14, \"specific_second\": 14, \"timezone\": \"timezone\"}, \"alternatives\": [{\"value\": \"value\", \"confidence\": 10}], \"role\": {\"type\": \"date_from\"}}]}}], \"channels\": [{\"channel\": \"chat\"}]}]}, \"actions\": [{\"name\": \"name\", \"type\": \"client\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"result_variable\": \"resultVariable\", \"credentials\": \"credentials\"}], \"user_id\": \"userId\"}, \"log_id\": \"logId\", \"request_timestamp\": \"requestTimestamp\", \"response_timestamp\": \"responseTimestamp\", \"workspace_id\": \"workspaceId\", \"language\": \"language\"}], \"pagination\": {\"next_url\": \"nextUrl\", \"matched\": 7, \"next_cursor\": \"nextCursor\"}}";
    String listAllLogsPath = "/v1/logs";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAllLogsOptions model
    ListAllLogsOptions listAllLogsOptionsModel =
        new ListAllLogsOptions.Builder()
            .filter("testString")
            .sort("testString")
            .pageLimit(Long.valueOf("26"))
            .cursor("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<LogCollection> response =
        assistantService.listAllLogs(listAllLogsOptionsModel).execute();
    assertNotNull(response);
    LogCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("26"));
    assertEquals(query.get("cursor"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAllLogsPath);
  }

  // Test the listAllLogs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAllLogsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    assistantService.listAllLogs(null).execute();
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";

    server.enqueue(new MockResponse().setResponseCode(202).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = assistantService.deleteUserData(deleteUserDataOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
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
    assistantService.deleteUserData(null).execute();
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
    assistantService = null;
  }
}
