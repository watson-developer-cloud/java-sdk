/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.Counterexample;
import com.ibm.watson.assistant.v1.model.CreateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.CreateEntity;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateExampleOptions;
import com.ibm.watson.assistant.v1.model.CreateIntent;
import com.ibm.watson.assistant.v1.model.CreateIntentOptions;
import com.ibm.watson.assistant.v1.model.CreateValue;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v1.model.DialogNode;
import com.ibm.watson.assistant.v1.model.DialogNodeAction;
import com.ibm.watson.assistant.v1.model.Example;
import com.ibm.watson.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.ListAllLogsOptions;
import com.ibm.watson.assistant.v1.model.ListMentionsOptions;
import com.ibm.watson.assistant.v1.model.Mention;
import com.ibm.watson.assistant.v1.model.MessageContextMetadata;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageRequest;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.OutputData;
import com.ibm.watson.assistant.v1.model.RuntimeEntity;
import com.ibm.watson.assistant.v1.model.RuntimeIntent;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.UpdateEntityOptions;
import com.ibm.watson.assistant.v1.model.UpdateExampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateIntentOptions;
import com.ibm.watson.assistant.v1.model.UpdateValueOptions;
import com.ibm.watson.assistant.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Webhook;
import com.ibm.watson.assistant.v1.model.WebhookHeader;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettings;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsDisambiguation;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsOffTopic;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsTooling;
import com.ibm.watson.common.WatsonServiceUnitTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

/** Unit tests for the {@link Assistant}. */
public class AssistantTest extends WatsonServiceUnitTest {
  private static final String VERSION_DATE = "2019-02-28";
  private static final String INTENT = "turn_on";
  private static final Double CONFIDENCE = 0.0;
  private static final String ENTITY = "genre";
  private static final String VALUE = "jazz";
  private static final String NONE_OF_THE_ABOVE_PROMPT = "none of the above";
  private static final String PROMPT = "prompt";
  private static final List<Long> LOCATION = Arrays.asList(1L, 2L);
  private static final String TEXT = "text";
  private static final String NAME = "name";
  private static final String CREDENTIALS = "credentials";
  private static final String RESULT_VARIABLE = "result_variable";
  private static final String WEBHOOK_HEADER_NAME = "Webhook-Header";
  private static final String WEBHOOK_HEADER_VALUE = "webhook_value";
  private static final String WEBHOOK_NAME = "webhook_name";
  private static final String WEBHOOK_URL = "webhook_url";
  private static final Long MAX_SUGGESTIONS = 100L;
  private static final String SUGGESTION_TEXT_POLICY = "suggestion_text_policy";

  private Assistant service;
  private static final String FIXTURE = "src/test/resources/assistant/assistant.json";
  private static final String WORKSPACE_ID = "123";
  private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID + "/message";
  private static final String VERSION = "version";

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new Assistant(VERSION_DATE, new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());
  }

  /** Negative - Test constructor with null version date. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new Assistant(null, new NoAuthAuthenticator());
  }

  /** Negative - Test constructor with empty version date. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new Assistant("", new NoAuthAuthenticator());
  }

  /** Negative - Test assistant with null options. */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithNullOptions() {
    service.message(null).execute().getResult();
  }

  /** Negative - Test assistant with null workspaceId. */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithNullWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder().build();
    service.message(options).execute().getResult();
  }

  /** Negative - Test assistant with empty workspaceId. */
  @Test(expected = IllegalArgumentException.class)
  public void testAssistantWithEmptyWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder("").build();
    service.message(options).execute().getResult();
  }

  /**
   * Test send message.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessage() throws IOException, InterruptedException {
    String text = "I would love to hear some jazz music.";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageInput input = new MessageInput();
    input.setText(text);
    RuntimeIntent intent =
        new RuntimeIntent.Builder().intent(INTENT).confidence(CONFIDENCE).build();
    RuntimeEntity entity =
        new RuntimeEntity.Builder().entity(ENTITY).value(VALUE).location(LOCATION).build();
    MessageOptions options =
        new MessageOptions.Builder(WORKSPACE_ID)
            .input(input)
            .addIntent(intent)
            .addEntity(entity)
            .alternateIntents(true)
            .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", VERSION_DATE);
    assertEquals(path, request.getPath());
    assertArrayEquals(
        new String[] {"Great choice! Playing some jazz for you."},
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(serviceResponse.getActions());
    assertNotNull(serviceResponse.getActions().get(0).name());
    assertNotNull(serviceResponse.getActions().get(0).credentials());
    assertNotNull(serviceResponse.getActions().get(0).type());
    assertNotNull(serviceResponse.getActions().get(0).parameters());
    assertNotNull(serviceResponse.getActions().get(0).resultVariable());
    assertNotNull(serviceResponse.getOutput().getLogMessages());
    assertNotNull(serviceResponse.getOutput().getNodesVisited());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).dialogNode());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).title());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).conditions());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).conditions());
  }

  /**
   * Test send message. use some different MessageOptions options like context and other public
   * methods
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessageWithAlternateIntents() throws IOException, InterruptedException {
    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageContextMetadata metadata = new MessageContextMetadata.Builder().build();
    Context contextTemp = new Context();
    contextTemp.put("name", "Myname");
    contextTemp.setMetadata(metadata);
    MessageInput inputTemp = new MessageInput();
    inputTemp.setText("My text");

    assertEquals("Myname", contextTemp.get("name"));
    assertEquals(metadata, contextTemp.getMetadata());

    MessageOptions options =
        new MessageOptions.Builder(WORKSPACE_ID)
            .input(inputTemp)
            .alternateIntents(false)
            .context(contextTemp)
            .entities(null)
            .intents(null)
            .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", VERSION_DATE);
    assertEquals(path, request.getPath());
    assertArrayEquals(
        new String[] {"Great choice! Playing some jazz for you."},
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
  }

  @Test
  public void testSendMessageWithMessageRequest()
      throws FileNotFoundException, InterruptedException {
    String text = "I would love to hear some jazz music.";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    MessageInput input = new MessageInput();
    input.setText(text);
    RuntimeIntent intent =
        new RuntimeIntent.Builder().intent(INTENT).confidence(CONFIDENCE).build();
    RuntimeEntity entity =
        new RuntimeEntity.Builder().entity(ENTITY).value(VALUE).location(LOCATION).build();
    Context context = new Context();
    OutputData outputData = new OutputData();

    MessageRequest messageRequest =
        new MessageRequest.Builder()
            .input(input)
            .intents(Collections.singletonList(intent))
            .entities(Collections.singletonList(entity))
            .alternateIntents(true)
            .context(context)
            .output(outputData)
            .build();

    assertEquals(input, messageRequest.input());
    assertEquals(intent, messageRequest.intents().get(0));
    assertEquals(entity, messageRequest.entities().get(0));
    assertEquals(context, messageRequest.context());
    assertEquals(outputData, messageRequest.output());

    MessageOptions options =
        new MessageOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .messageRequest(messageRequest)
            .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", VERSION_DATE);
    assertEquals(path, request.getPath());
    assertArrayEquals(
        new String[] {"Great choice! Playing some jazz for you."},
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(serviceResponse.getActions());
    assertNotNull(serviceResponse.getActions().get(0).name());
    assertNotNull(serviceResponse.getActions().get(0).credentials());
    assertNotNull(serviceResponse.getActions().get(0).type());
    assertNotNull(serviceResponse.getActions().get(0).parameters());
    assertNotNull(serviceResponse.getActions().get(0).resultVariable());
    assertNotNull(serviceResponse.getOutput().getLogMessages());
    assertNotNull(serviceResponse.getOutput().getNodesVisited());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).dialogNode());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).title());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).conditions());
    assertNotNull(serviceResponse.getOutput().getNodesVisitedDetails().get(0).conditions());
  }

  /**
   * Negative - Test message with null workspace id.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithNullWorkspaceId() throws InterruptedException {
    String text = "I'd like to get insurance to for my home";

    MessageInput input = new MessageInput();
    input.setText(text);
    MessageOptions options =
        new MessageOptions.Builder().input(input).alternateIntents(true).build();

    service.message(options).execute().getResult();
  }

  /** Test CreateWorkspace builder. */
  @Test
  public void testCreateWorkspaceBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";
    String userLabel = "user_label";

    // intents
    CreateIntent testIntent0 = new CreateIntent.Builder("testIntent0").build();
    CreateIntent testIntent1 = new CreateIntent.Builder("testIntent1").build();

    // entities
    CreateEntity testEntity0 = new CreateEntity.Builder("testEntity0").build();
    CreateEntity testEntity1 = new CreateEntity.Builder("testEntity1").build();

    // counterexamples
    Counterexample testCounterexample0 = new Counterexample.Builder("testCounterexample0").build();
    Counterexample testCounterexample1 = new Counterexample.Builder("testCounterexample1").build();

    // dialognodes
    DialogNode testDialogNode0 = new DialogNode.Builder("dialogNode0").userLabel(userLabel).build();
    DialogNode testDialogNode1 = new DialogNode.Builder("dialogNode1").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .enabled(true)
            .noneOfTheAbovePrompt(NONE_OF_THE_ABOVE_PROMPT)
            .prompt(PROMPT)
            .sensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH)
            .randomize(true)
            .maxSuggestions(MAX_SUGGESTIONS)
            .suggestionTextPolicy(SUGGESTION_TEXT_POLICY)
            .build();
    WorkspaceSystemSettingsTooling tooling =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();
    Map<String, Object> humanAgentAssist = new HashMap<>();
    humanAgentAssist.put("help", "ok");
    WorkspaceSystemSettingsOffTopic offTopic =
        new WorkspaceSystemSettingsOffTopic.Builder().enabled(true).build();
    WorkspaceSystemSettings systemSettings =
        new WorkspaceSystemSettings.Builder()
            .disambiguation(disambiguation)
            .tooling(tooling)
            .humanAgentAssist(humanAgentAssist)
            .offTopic(offTopic)
            .build();

    WebhookHeader webhookHeader =
        new WebhookHeader.Builder().name(WEBHOOK_HEADER_NAME).value(WEBHOOK_HEADER_VALUE).build();
    List<WebhookHeader> webhookHeaderList = new ArrayList<>();
    webhookHeaderList.add(webhookHeader);
    Webhook webhook =
        new Webhook.Builder()
            .name(WEBHOOK_NAME)
            .url(WEBHOOK_URL)
            .headers(webhookHeaderList)
            .addHeaders(webhookHeader)
            .build();
    List<Webhook> webhookList = new ArrayList<>();
    webhookList.add(webhook);

    CreateWorkspaceOptions createOptions =
        new CreateWorkspaceOptions.Builder()
            .name(workspaceName)
            .description(workspaceDescription)
            .language(workspaceLanguage)
            .addIntent(testIntent0)
            .addIntent(testIntent1)
            .addEntity(testEntity0)
            .addEntity(testEntity1)
            .addCounterexample(testCounterexample0)
            .addCounterexample(testCounterexample1)
            .addDialogNode(testDialogNode0)
            .addDialogNode(testDialogNode1)
            .metadata(workspaceMetadata)
            .systemSettings(systemSettings)
            .webhooks(webhookList)
            .addWebhooks(webhook)
            .build();

    assertEquals(createOptions.name(), workspaceName);
    assertEquals(createOptions.description(), workspaceDescription);
    assertEquals(createOptions.language(), workspaceLanguage);
    assertNotNull(createOptions.intents());
    assertEquals(createOptions.intents().size(), 2);
    assertEquals(createOptions.intents().get(0), testIntent0);
    assertEquals(createOptions.intents().get(1), testIntent1);
    assertNotNull(createOptions.entities());
    assertEquals(createOptions.entities().size(), 2);
    assertEquals(createOptions.entities().get(0), testEntity0);
    assertEquals(createOptions.entities().get(1), testEntity1);
    assertNotNull(createOptions.counterexamples());
    assertEquals(createOptions.counterexamples().size(), 2);
    assertEquals(createOptions.counterexamples().get(0), testCounterexample0);
    assertEquals(createOptions.counterexamples().get(1), testCounterexample1);
    assertNotNull(createOptions.dialogNodes());
    assertEquals(createOptions.dialogNodes().size(), 2);
    assertEquals(createOptions.dialogNodes().get(0), testDialogNode0);
    assertEquals(createOptions.dialogNodes().get(0).userLabel(), userLabel);
    assertEquals(createOptions.dialogNodes().get(1), testDialogNode1);
    assertNotNull(createOptions.systemSettings());
    assertEquals(
        createOptions.systemSettings().disambiguation().noneOfTheAbovePrompt(),
        disambiguation.noneOfTheAbovePrompt());
    assertEquals(createOptions.systemSettings().disambiguation().prompt(), disambiguation.prompt());
    assertEquals(
        createOptions.systemSettings().disambiguation().sensitivity(),
        disambiguation.sensitivity());
    assertEquals(
        createOptions.systemSettings().disambiguation().enabled(), disambiguation.enabled());
    assertTrue(createOptions.systemSettings().disambiguation().randomize());
    assertEquals(MAX_SUGGESTIONS, createOptions.systemSettings().disambiguation().maxSuggestions());
    assertEquals(
        SUGGESTION_TEXT_POLICY,
        createOptions.systemSettings().disambiguation().suggestionTextPolicy());
    assertEquals(
        createOptions.systemSettings().tooling().storeGenericResponses(),
        tooling.storeGenericResponses());
    assertEquals(createOptions.systemSettings().humanAgentAssist(), humanAgentAssist);
    assertTrue(createOptions.systemSettings().offTopic().enabled());

    assertEquals(2, createOptions.webhooks().size());
    assertEquals(webhook, createOptions.webhooks().get(0));
    assertEquals(WEBHOOK_NAME, createOptions.webhooks().get(0).name());
    assertEquals(WEBHOOK_URL, createOptions.webhooks().get(0).url());
    assertEquals(2, createOptions.webhooks().get(0).headers().size());
    assertEquals(webhookHeader, createOptions.webhooks().get(0).headers().get(0));
    assertEquals(WEBHOOK_HEADER_NAME, createOptions.webhooks().get(0).headers().get(0).name());
    assertEquals(WEBHOOK_HEADER_VALUE, createOptions.webhooks().get(0).headers().get(0).value());

    CreateWorkspaceOptions.Builder builder = createOptions.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    Counterexample testCounterexample2 = new Counterexample.Builder("testCounterexample2").build();
    DialogNode testDialogNode2 = new DialogNode.Builder("dialogNode2").build();

    builder.intents(Collections.singletonList(testIntent2));
    builder.entities(Collections.singletonList(testEntity2));
    builder.counterexamples(Collections.singletonList(testCounterexample2));
    builder.dialogNodes(Collections.singletonList(testDialogNode2));

    CreateWorkspaceOptions options2 = builder.build();

    assertNotNull(options2.intents());
    assertEquals(options2.intents().size(), 1);
    assertEquals(options2.intents().get(0), testIntent2);
    assertNotNull(options2.entities());
    assertEquals(options2.entities().size(), 1);
    assertEquals(options2.entities().get(0), testEntity2);
    assertNotNull(options2.counterexamples());
    assertEquals(options2.counterexamples().size(), 1);
    assertEquals(options2.counterexamples().get(0), testCounterexample2);
    assertNotNull(options2.dialogNodes());
    assertEquals(options2.dialogNodes().size(), 1);
    assertEquals(options2.dialogNodes().get(0), testDialogNode2);
  }

  /** Test UpdateWorkspaceOptions builder. */
  @Test
  public void testUpdateWorkspaceOptionsBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // intents
    CreateIntent testIntent = new CreateIntent.Builder("testIntent").build();

    // entities
    CreateEntity testEntity = new CreateEntity.Builder("testEntity").build();

    // counterexamples
    Counterexample testCounterexample = new Counterexample.Builder("testCounterexample").build();

    // dialognodes
    DialogNode testDialogNode = new DialogNode.Builder("dialogNode").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .enabled(true)
            .noneOfTheAbovePrompt(NONE_OF_THE_ABOVE_PROMPT)
            .prompt(PROMPT)
            .sensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH)
            .randomize(true)
            .maxSuggestions(MAX_SUGGESTIONS)
            .build();
    WorkspaceSystemSettingsTooling tooling =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();
    Map<String, Object> humanAgentAssist = new HashMap<>();
    humanAgentAssist.put("help", "ok");
    WorkspaceSystemSettings systemSettings =
        new WorkspaceSystemSettings.Builder()
            .disambiguation(disambiguation)
            .tooling(tooling)
            .humanAgentAssist(humanAgentAssist)
            .build();

    WebhookHeader webhookHeader =
        new WebhookHeader.Builder().name(WEBHOOK_HEADER_NAME).value(WEBHOOK_HEADER_VALUE).build();
    List<WebhookHeader> webhookHeaderList = new ArrayList<>();
    webhookHeaderList.add(webhookHeader);
    Webhook webhook =
        new Webhook.Builder()
            .name(WEBHOOK_NAME)
            .url(WEBHOOK_URL)
            .headers(webhookHeaderList)
            .addHeaders(webhookHeader)
            .build();
    List<Webhook> webhookList = new ArrayList<>();
    webhookList.add(webhook);

    UpdateWorkspaceOptions.Builder builder = new UpdateWorkspaceOptions.Builder(WORKSPACE_ID);
    builder.name(workspaceName);
    builder.description(workspaceDescription);
    builder.language(workspaceLanguage);
    builder.addIntent(testIntent);
    builder.addEntity(testEntity);
    builder.addCounterexample(testCounterexample);
    builder.addDialogNode(testDialogNode);
    builder.metadata(workspaceMetadata);
    builder.systemSettings(systemSettings);
    builder.webhooks(webhookList);
    builder.addWebhooks(webhook);

    UpdateWorkspaceOptions options = builder.build();

    assertEquals(options.name(), workspaceName);
    assertEquals(options.description(), workspaceDescription);
    assertEquals(options.language(), workspaceLanguage);
    assertNotNull(options.intents());
    assertEquals(options.intents().size(), 1);
    assertEquals(options.intents().get(0), testIntent);
    assertNotNull(options.entities());
    assertEquals(options.entities().size(), 1);
    assertEquals(options.entities().get(0), testEntity);
    assertNotNull(options.counterexamples());
    assertEquals(options.counterexamples().size(), 1);
    assertEquals(options.counterexamples().get(0), testCounterexample);
    assertNotNull(options.dialogNodes());
    assertEquals(options.dialogNodes().size(), 1);
    assertEquals(options.dialogNodes().get(0), testDialogNode);
    assertNotNull(options.metadata());
    assertEquals(options.metadata(), workspaceMetadata);
    assertNotNull(options.systemSettings());
    assertEquals(
        options.systemSettings().disambiguation().noneOfTheAbovePrompt(),
        disambiguation.noneOfTheAbovePrompt());
    assertEquals(
        options.systemSettings().disambiguation().sensitivity(), disambiguation.sensitivity());
    assertEquals(options.systemSettings().disambiguation().prompt(), disambiguation.prompt());
    assertEquals(options.systemSettings().disambiguation().enabled(), disambiguation.enabled());
    assertTrue(options.systemSettings().disambiguation().randomize());
    assertEquals(MAX_SUGGESTIONS, options.systemSettings().disambiguation().maxSuggestions());
    assertEquals(
        options.systemSettings().tooling().storeGenericResponses(),
        tooling.storeGenericResponses());
    assertEquals(options.systemSettings().humanAgentAssist(), humanAgentAssist);
    assertEquals(2, options.webhooks().size());
    assertEquals(webhook, options.webhooks().get(0));
    assertEquals(WEBHOOK_NAME, options.webhooks().get(0).name());
    assertEquals(WEBHOOK_URL, options.webhooks().get(0).url());
    assertEquals(2, options.webhooks().get(0).headers().size());
    assertEquals(webhookHeader, options.webhooks().get(0).headers().get(0));
    assertEquals(WEBHOOK_HEADER_NAME, options.webhooks().get(0).headers().get(0).name());
    assertEquals(WEBHOOK_HEADER_VALUE, options.webhooks().get(0).headers().get(0).value());

    UpdateWorkspaceOptions.Builder builder2 = options.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    Counterexample testCounterexample2 = new Counterexample.Builder("testCounterexample2").build();
    DialogNode testDialogNode2 = new DialogNode.Builder("dialogNode2").build();

    builder2.intents(new ArrayList<CreateIntent>());
    builder2.addIntent(testIntent2);
    builder2.entities(new ArrayList<CreateEntity>());
    builder2.addEntity(testEntity2);
    builder2.counterexamples(new ArrayList<Counterexample>());
    builder2.addCounterexample(testCounterexample2);
    builder2.dialogNodes(new ArrayList<DialogNode>());
    builder2.addDialogNode(testDialogNode2);

    UpdateWorkspaceOptions options2 = builder2.build();

    assertNotNull(options2.intents());
    assertEquals(options2.intents().size(), 1);
    assertEquals(options2.intents().get(0), testIntent2);
    assertNotNull(options2.entities());
    assertEquals(options2.entities().size(), 1);
    assertEquals(options2.entities().get(0), testEntity2);
    assertNotNull(options2.counterexamples());
    assertEquals(options2.counterexamples().size(), 1);
    assertEquals(options2.counterexamples().get(0), testCounterexample2);
    assertNotNull(options2.dialogNodes());
    assertEquals(options2.dialogNodes().size(), 1);
    assertEquals(options2.dialogNodes().get(0), testDialogNode2);
  }

  @Test
  public void testGetWorkspaceOptionsBuilder() {
    String workspaceId = "workspace_id";
    String sort = GetWorkspaceOptions.Sort.STABLE;

    GetWorkspaceOptions getWorkspaceOptions =
        new GetWorkspaceOptions.Builder()
            .workspaceId(workspaceId)
            .export(true)
            .includeAudit(true)
            .sort(sort)
            .build();
    getWorkspaceOptions = getWorkspaceOptions.newBuilder().build();

    assertEquals(workspaceId, getWorkspaceOptions.workspaceId());
    assertTrue(getWorkspaceOptions.export());
    assertTrue(getWorkspaceOptions.includeAudit());
    assertEquals(sort, getWorkspaceOptions.sort());
  }

  @Test
  public void testCreateExampleOptionsBuilder() {
    Mention mentions1 = new Mention.Builder().entity(ENTITY).location(LOCATION).build();
    List<Mention> mentionsList = new ArrayList<>();
    mentionsList.add(mentions1);
    Mention mentions2 = new Mention.Builder().entity(ENTITY).location(LOCATION).build();

    CreateExampleOptions createExampleOptions =
        new CreateExampleOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .mentions(mentionsList)
            .addMentions(mentions2)
            .text(TEXT)
            .intent(INTENT)
            .build();

    mentionsList.add(mentions2);

    assertEquals(createExampleOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createExampleOptions.mentions(), mentionsList);
    assertEquals(createExampleOptions.text(), TEXT);
    assertEquals(createExampleOptions.intent(), INTENT);
  }

  @Test
  public void testUpdateExampleOptionsBuilder() {
    Mention mentions1 = new Mention.Builder().entity(ENTITY).location(LOCATION).build();
    List<Mention> mentionsList = new ArrayList<>();
    mentionsList.add(mentions1);
    Mention mentions2 = new Mention.Builder().entity(ENTITY).location(LOCATION).build();

    UpdateExampleOptions updateExampleOptions =
        new UpdateExampleOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .intent(INTENT)
            .text(TEXT)
            .newMentions(mentionsList)
            .newText(TEXT)
            .build();

    mentionsList.add(mentions2);

    assertEquals(updateExampleOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateExampleOptions.newMentions(), mentionsList);
    assertEquals(updateExampleOptions.newText(), TEXT);
    assertEquals(updateExampleOptions.intent(), INTENT);
    assertEquals(updateExampleOptions.text(), TEXT);
  }

  /** Test CreateIntentOptions builder. */
  @Test
  public void testCreateIntentOptionsBuilder() {
    String intent = "anIntent";
    Example intentExample0 = new Example.Builder().text("intentExample0").build();
    Example intentExample1 = new Example.Builder().text("intentExample1").build();

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .intent(intent)
            .addExample(intentExample0)
            .addExample(intentExample1)
            .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.intent(), intent);
    assertEquals(createOptions.examples().size(), 2);
    assertEquals(createOptions.examples().get(0), intentExample0);
    assertEquals(createOptions.examples().get(1), intentExample1);

    CreateIntentOptions.Builder builder = createOptions.newBuilder();

    Example intentExample2 = new Example.Builder().text("intentExample2").build();
    builder.examples(Collections.singletonList(intentExample2));

    CreateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.examples().size(), 1);
    assertEquals(options2.examples().get(0), intentExample2);
  }

  /** Test UpdateIntentOptions builder. */
  @Test
  public void testUpdateIntentOptionsBuilder() {
    String intent = "anIntent";
    String newIntent = "renamedIntent";
    Example intentExample0 = new Example.Builder().text("intentExample0").build();
    Example intentExample1 = new Example.Builder().text("intentExample1").build();

    UpdateIntentOptions updateOptions =
        new UpdateIntentOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .intent(intent)
            .newIntent(newIntent)
            .addExample(intentExample0)
            .addExample(intentExample1)
            .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.intent(), intent);
    assertEquals(updateOptions.newIntent(), newIntent);
    assertEquals(updateOptions.newExamples().size(), 2);
    assertEquals(updateOptions.newExamples().get(0), intentExample0);
    assertEquals(updateOptions.newExamples().get(1), intentExample1);

    UpdateIntentOptions.Builder builder = updateOptions.newBuilder();

    Example intentExample2 = new Example.Builder().text("intentExample2").build();
    builder.newExamples(Collections.singletonList(intentExample2));

    UpdateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.newIntent(), newIntent);
    assertEquals(options2.newExamples().size(), 1);
    assertEquals(options2.newExamples().get(0), intentExample2);
  }

  /** Test CreateEntityOptions builder. */
  @Test
  public void testCreateEntityOptionsBuilder() {
    String entity = "anEntity";
    CreateValue entityValue0 =
        new CreateValue.Builder().value("entityValue0").addPattern("pattern0").build();
    CreateValue entityValue1 =
        new CreateValue.Builder().value("entityValue1").addPattern("pattern1").build();

    CreateEntityOptions createOptions =
        new CreateEntityOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .entity(entity)
            .addValues(entityValue0)
            .addValues(entityValue1)
            .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.values().size(), 2);
    assertEquals(createOptions.values().get(0), entityValue0);
    assertEquals(createOptions.values().get(1), entityValue1);

    CreateEntityOptions.Builder builder = createOptions.newBuilder();

    CreateValue entityValue2 =
        new CreateValue.Builder().value("entityValue2").addPattern("pattern2").build();
    builder.values(Collections.singletonList(entityValue2));

    CreateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.values().size(), 1);
    assertEquals(options2.values().get(0), entityValue2);
  }

  /** Test UpdateEntityOptions builder. */
  @Test
  public void testUpdateEntityOptionsBuilder() {
    String entity = "anEntity";
    String newEntity = "renamedEntity";
    CreateValue entityValue0 =
        new CreateValue.Builder().value("entityValue0").addPattern("pattern0").build();
    CreateValue entityValue1 =
        new CreateValue.Builder().value("entityValue1").addPattern("pattern1").build();

    UpdateEntityOptions updateOptions =
        new UpdateEntityOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .entity(entity)
            .newEntity(newEntity)
            .addValue(entityValue0)
            .addValue(entityValue1)
            .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newEntity(), newEntity);
    assertEquals(updateOptions.newValues().size(), 2);
    assertEquals(updateOptions.newValues().get(0), entityValue0);
    assertEquals(updateOptions.newValues().get(1), entityValue1);

    UpdateEntityOptions.Builder builder = updateOptions.newBuilder();

    CreateValue entityValue2 =
        new CreateValue.Builder().value("entityValue2").addPattern("pattern2").build();
    builder.newValues(Collections.singletonList(entityValue2));

    UpdateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newEntity(), newEntity);
    assertEquals(options2.newValues().size(), 1);
    assertEquals(options2.newValues().get(0), entityValue2);
  }

  /** Test CreateValueOptions builder. */
  @Test
  public void testCreateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";
    String valuePattern0 = "valuePattern0";
    String valuePattern1 = "valuePattern1";
    String valueType = "patterns";

    CreateValueOptions createOptions =
        new CreateValueOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .entity(entity)
            .value(value)
            .addSynonym(valueSynonym0)
            .addSynonym(valueSynonym1)
            .addPattern(valuePattern0)
            .addPattern(valuePattern1)
            .type(valueType)
            .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.value(), value);
    assertEquals(createOptions.synonyms().size(), 2);
    assertEquals(createOptions.synonyms().get(0), valueSynonym0);
    assertEquals(createOptions.synonyms().get(1), valueSynonym1);
    assertEquals(createOptions.patterns().size(), 2);
    assertEquals(createOptions.patterns().get(0), valuePattern0);
    assertEquals(createOptions.patterns().get(1), valuePattern1);
    assertEquals(createOptions.type(), valueType);

    CreateValueOptions.Builder builder = createOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    String valuePattern2 = "valuePattern2";
    builder.synonyms(Collections.singletonList(valueSynonym2));
    builder.patterns(Collections.singletonList(valuePattern2));

    CreateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.value(), value);
    assertEquals(options2.synonyms().size(), 1);
    assertEquals(options2.synonyms().get(0), valueSynonym2);
    assertEquals(options2.patterns().size(), 1);
    assertEquals(options2.patterns().get(0), valuePattern2);
  }

  /** Test UpdateValueOptions builder. */
  @Test
  public void testUpdateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String newValue = "renamedValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";

    UpdateValueOptions updateOptions =
        new UpdateValueOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .entity(entity)
            .value(value)
            .newValue(newValue)
            .addSynonym(valueSynonym0)
            .addSynonym(valueSynonym1)
            .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newValue(), newValue);
    assertEquals(updateOptions.newSynonyms().size(), 2);
    assertEquals(updateOptions.newSynonyms().get(0), valueSynonym0);
    assertEquals(updateOptions.newSynonyms().get(1), valueSynonym1);

    UpdateValueOptions.Builder builder = updateOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    builder.newSynonyms(Collections.singletonList(valueSynonym2));

    UpdateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newValue(), newValue);
    assertEquals(options2.newSynonyms().size(), 1);
    assertEquals(options2.newSynonyms().get(0), valueSynonym2);
  }

  /** Test CreateDialogNodeOptions builder. */
  @Test
  public void testCreateDialogNodeOptionsBuilder() {
    String dialogNodeName = "aDialogNode";
    DialogNodeAction action0 =
        new DialogNodeAction.Builder()
            .name(NAME)
            .credentials(CREDENTIALS)
            .resultVariable(RESULT_VARIABLE)
            .build();
    DialogNodeAction action1 =
        new DialogNodeAction.Builder()
            .name(NAME)
            .credentials(CREDENTIALS)
            .resultVariable(RESULT_VARIABLE)
            .build();
    String userLabel = "user_label";

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .dialogNode(dialogNodeName)
            .addActions(action0)
            .addActions(action1)
            .digressIn(CreateDialogNodeOptions.DigressIn.RETURNS)
            .digressOut(CreateDialogNodeOptions.DigressOut.ALLOW_ALL)
            .digressOutSlots(CreateDialogNodeOptions.DigressOutSlots.ALLOW_ALL)
            .userLabel(userLabel)
            .disambiguationOptOut(true)
            .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.dialogNode(), dialogNodeName);
    assertEquals(createOptions.actions().size(), 2);
    assertEquals(createOptions.actions().get(0), action0);
    assertEquals(createOptions.actions().get(0).credentials(), CREDENTIALS);
    assertEquals(createOptions.actions().get(1), action1);
    assertEquals(createOptions.actions().get(1).credentials(), CREDENTIALS);
    assertEquals(createOptions.digressIn(), CreateDialogNodeOptions.DigressIn.RETURNS);
    assertEquals(createOptions.digressOut(), CreateDialogNodeOptions.DigressOut.ALLOW_ALL);
    assertEquals(
        createOptions.digressOutSlots(), CreateDialogNodeOptions.DigressOutSlots.ALLOW_ALL);
    assertEquals(createOptions.userLabel(), userLabel);
    assertTrue(createOptions.disambiguationOptOut());
  }

  /** Test UpdateDialogNodeOptions builder. */
  @Test
  public void testUpdateDialogNodeOptionsBuilder() {
    String dialogNodeName = "aDialogNode";
    String newDialogNodeName = "renamedDialogNode";
    DialogNodeAction action0 =
        new DialogNodeAction.Builder()
            .name(NAME)
            .credentials(CREDENTIALS)
            .resultVariable(RESULT_VARIABLE)
            .build();
    DialogNodeAction action1 =
        new DialogNodeAction.Builder()
            .name(NAME)
            .credentials(CREDENTIALS)
            .resultVariable(RESULT_VARIABLE)
            .build();
    String userLabel = "user_label";

    UpdateDialogNodeOptions updateOptions =
        new UpdateDialogNodeOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .dialogNode(dialogNodeName)
            .newDialogNode(newDialogNodeName)
            .addNewActions(action0)
            .addNewActions(action1)
            .newDigressIn(UpdateDialogNodeOptions.NewDigressIn.RETURNS)
            .newDigressOut(UpdateDialogNodeOptions.NewDigressOut.ALLOW_ALL)
            .newDigressOutSlots(UpdateDialogNodeOptions.NewDigressOutSlots.ALLOW_ALL)
            .newUserLabel(userLabel)
            .newDisambiguationOptOut(true)
            .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.dialogNode(), dialogNodeName);
    assertEquals(updateOptions.newActions().size(), 2);
    assertEquals(updateOptions.newActions().get(0), action0);
    assertEquals(updateOptions.newActions().get(0).credentials(), CREDENTIALS);
    assertEquals(updateOptions.newActions().get(1), action1);
    assertEquals(updateOptions.newActions().get(1).credentials(), CREDENTIALS);
    assertEquals(updateOptions.newDigressIn(), UpdateDialogNodeOptions.NewDigressIn.RETURNS);
    assertEquals(updateOptions.newDigressOut(), UpdateDialogNodeOptions.NewDigressOut.ALLOW_ALL);
    assertEquals(
        updateOptions.newDigressOutSlots(), UpdateDialogNodeOptions.NewDigressOutSlots.ALLOW_ALL);
    assertEquals(updateOptions.newUserLabel(), userLabel);
    assertTrue(updateOptions.newDisambiguationOptOut());
  }

  /** Test ListAllLogsOptions builder. */
  @Test
  public void testListAllLogsOptionsBuilder() {
    String sort = "sort";
    String filter = "filter";
    Long pageLimit = 5L;
    String cursor = "cursor";

    ListAllLogsOptions listOptions =
        new ListAllLogsOptions.Builder()
            .sort(sort)
            .filter(filter)
            .pageLimit(pageLimit)
            .cursor(cursor)
            .build();

    assertEquals(listOptions.sort(), sort);
    assertEquals(listOptions.filter(), filter);
    assertEquals(listOptions.pageLimit(), pageLimit);
    assertEquals(listOptions.cursor(), cursor);
  }

  /** Test DeleteUserDataOptions builder. */
  @Test
  public void testDeleteUserDataOptionsBuilder() {
    String customerId = "customer_id";

    DeleteUserDataOptions deleteOptions =
        new DeleteUserDataOptions.Builder().customerId(customerId).build();

    assertEquals(deleteOptions.customerId(), customerId);
  }

  @Test
  public void testListMentionsBuilder() {
    String entity = "entity";

    ListMentionsOptions listMentionsOptions =
        new ListMentionsOptions.Builder()
            .workspaceId(WORKSPACE_ID)
            .entity(entity)
            .export(true)
            .includeAudit(true)
            .build();

    assertEquals(listMentionsOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(listMentionsOptions.entity(), entity);
    assertEquals(listMentionsOptions.export(), true);
    assertEquals(listMentionsOptions.includeAudit(), true);
  }

  @Test
  public void testMessageContextMetadata() {
    String deployment = "deployment";
    String userId = "user_id";

    MessageContextMetadata messageContextMetadata =
        new MessageContextMetadata.Builder().deployment(deployment).userId(userId).build();

    assertEquals(deployment, messageContextMetadata.deployment());
    assertEquals(userId, messageContextMetadata.userId());
  }

  @Test
  public void testCreateEntityBuilder() {
    String entity = "entity";
    String description = "Entity description";
    Map<String, Object> metadata = new HashMap<>();
    String metadataKey = "metadata_key";
    String metadataValue = "metadata_value";
    metadata.put(metadataKey, metadataValue);
    Date testDate = new Date();
    String value = "value";
    CreateValue createValue = new CreateValue.Builder(value).build();
    CreateValue secondValue = new CreateValue.Builder().value(value).build();
    List<CreateValue> values = new ArrayList<>();
    values.add(createValue);

    CreateEntity createEntity =
        new CreateEntity.Builder()
            .entity(entity)
            .description(description)
            .metadata(metadata)
            .values(values)
            .addValues(secondValue)
            .fuzzyMatch(true)
            .created(testDate)
            .updated(testDate)
            .build();
    createEntity = createEntity.newBuilder().build();

    assertEquals(entity, createEntity.entity());
    assertEquals(description, createEntity.description());
    assertTrue(createEntity.metadata().containsKey(metadataKey));
    assertEquals(metadataValue, createEntity.metadata().get(metadataKey));
    assertNotNull(createEntity.values());
    assertEquals(2, createEntity.values().size());
    assertTrue(createEntity.fuzzyMatch());
    assertEquals(testDate, createEntity.created());
    assertEquals(testDate, createEntity.updated());
  }

  @Test
  public void testCreateIntentBuilder() {
    String intent = "intent";
    String description = "Intent description";
    Date testDate = new Date();
    String text = "text";
    Example example = new Example.Builder(text).build();
    Example secondExample = new Example.Builder().text(text).build();
    List<Example> examples = new ArrayList<>();
    examples.add(example);

    CreateIntent createIntent =
        new CreateIntent.Builder()
            .intent(intent)
            .description(description)
            .examples(examples)
            .addExample(secondExample)
            .created(testDate)
            .updated(testDate)
            .build();
    createIntent = createIntent.newBuilder().build();

    assertEquals(intent, createIntent.intent());
    assertEquals(description, createIntent.description());
    assertNotNull(createIntent.examples());
    assertEquals(2, createIntent.examples().size());
    assertEquals(testDate, createIntent.created());
    assertEquals(testDate, createIntent.updated());
  }
}
