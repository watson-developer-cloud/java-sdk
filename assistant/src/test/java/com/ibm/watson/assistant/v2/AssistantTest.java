/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.assistant.v2.model.CaptureGroup;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DialogLogMessage;
import com.ibm.watson.assistant.v2.model.DialogNodeAction;
import com.ibm.watson.assistant.v2.model.DialogRuntimeResponseGeneric;
import com.ibm.watson.assistant.v2.model.MessageContext;
import com.ibm.watson.assistant.v2.model.MessageContextGlobal;
import com.ibm.watson.assistant.v2.model.MessageContextGlobalSystem;
import com.ibm.watson.assistant.v2.model.MessageContextSkills;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageOutputDebug;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.RuntimeEntity;
import com.ibm.watson.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.common.WatsonServiceUnitTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Assistant v2.
 */
public class AssistantTest extends WatsonServiceUnitTest {
  private static final String ASSISTANT_ID = "assistant_id";
  private static final String SESSION_ID = "session_id";
  private static final String TIMEZONE = "timezone";
  private static final Long TURN_COUNT = 10L;
  private static final String USER_ID = "user_id";
  private static final String GROUP = "group";
  private static final List<Long> LOCATION = Arrays.asList(1L, 2L);
  private static final Double CONFIDENCE = 0.0;
  private static final String ENTITY = "entity";
  private static final Map<String, Object> MAP = new HashMap<>();
  private static final String VALUE = "value";
  private static final String INTENT = "intent";
  private static final String TEXT = "text";
  private static final String SUGGESTION_ID = "suggestion_id";
  private static final String MESSAGE = "message";
  private static final String CONDITIONS = "conditions";
  private static final String TITLE = "title";
  private static final String DIALOG_NODE = "dialog_node";
  private static final String NAME = "name";
  private static final String RESULT_VARIABLE = "result_variable";
  private static final String CREDENTIALS = "credentials";
  private static final String DESCRIPTION = "description";
  private static final Long TIME = 1234L;
  private static final String SOURCE = "source";
  private static final String TOPIC = "topic";
  private static final String LABEL = "label";

  private static final String VERSION = "2018-09-20";
  private static final String RESOURCE = "src/test/resources/assistant/";
  private static final String MESSAGE_PATH = String.format(
      "/v2/assistants/%s/sessions/%s/message?version=%s",
      ASSISTANT_ID,
      SESSION_ID,
      VERSION
  );
  private static final String CREATE_SESSION_PATH = String.format(
      "/v2/assistants/%s/sessions?version=%s",
      ASSISTANT_ID,
      VERSION
  );
  private static final String DELETE_SESSION_PATH = String.format(
      "/v2/assistants/%s/sessions/%s?version=%s",
      ASSISTANT_ID,
      SESSION_ID,
      VERSION
  );

  private MessageResponse messageResponse;
  private SessionResponse sessionResponse;

  private Assistant service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    MAP.put("key", "value");

    messageResponse = loadFixture(RESOURCE + "message_response.json", MessageResponse.class);
    sessionResponse = loadFixture(RESOURCE + "session_response.json", SessionResponse.class);

    service = new Assistant(VERSION);
    service.setUsernameAndPassword("", "");
    service.setEndPoint(getMockWebServerUrl());
  }

  @Test
  public void testCaptureGroup() {
    CaptureGroup captureGroup = new CaptureGroup();
    captureGroup.setGroup(GROUP);
    captureGroup.setLocation(LOCATION);

    assertEquals(GROUP, captureGroup.getGroup());
    assertEquals(LOCATION, captureGroup.getLocation());
  }

  @Test
  public void testCreateSessionOptions() {
    CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .build();
    createSessionOptions = createSessionOptions.newBuilder().build();

    assertEquals(ASSISTANT_ID, createSessionOptions.assistantId());
  }

  @Test
  public void testDeleteSessionOptions() {
    DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .sessionId(SESSION_ID)
        .build();
    deleteSessionOptions = deleteSessionOptions.newBuilder().build();

    assertEquals(ASSISTANT_ID, deleteSessionOptions.assistantId());
    assertEquals(SESSION_ID, deleteSessionOptions.sessionId());
  }

  @Test
  public void testMessageContextGlobalSystem() {
    MessageContextGlobalSystem messageContextGlobalSystem = new MessageContextGlobalSystem();
    messageContextGlobalSystem.setTimezone(TIMEZONE);
    messageContextGlobalSystem.setTurnCount(TURN_COUNT);
    messageContextGlobalSystem.setUserId(USER_ID);

    assertEquals(TIMEZONE, messageContextGlobalSystem.getTimezone());
    assertEquals(TURN_COUNT, messageContextGlobalSystem.getTurnCount());
    assertEquals(USER_ID, messageContextGlobalSystem.getUserId());
  }

  @Test
  public void testMessageContextGlobal() {
    MessageContextGlobalSystem messageContextGlobalSystem = new MessageContextGlobalSystem();

    MessageContextGlobal messageContextGlobal = new MessageContextGlobal();
    messageContextGlobal.setSystem(messageContextGlobalSystem);

    assertEquals(messageContextGlobalSystem, messageContextGlobal.getSystem());
  }

  @Test
  public void testMessageContext() {
    MessageContextGlobal messageContextGlobal = new MessageContextGlobal();
    MessageContextSkills messageContextSkills = new MessageContextSkills();

    MessageContext messageContext = new MessageContext();
    messageContext.setGlobal(messageContextGlobal);
    messageContext.setSkills(messageContextSkills);

    assertEquals(messageContextGlobal, messageContext.getGlobal());
    assertEquals(messageContextSkills, messageContext.getSkills());
  }

  @Test
  public void testMessageInput() {
    RuntimeEntity entity1 = new RuntimeEntity();
    entity1.setEntity(ENTITY);
    entity1.setLocation(LOCATION);
    entity1.setValue(VALUE);
    RuntimeEntity entity2 = new RuntimeEntity();
    entity2.setEntity(ENTITY);
    entity2.setLocation(LOCATION);
    entity2.setValue(VALUE);
    List<RuntimeEntity> entityList = new ArrayList<>();
    entityList.add(entity1);
    RuntimeIntent intent1 = new RuntimeIntent();
    intent1.setConfidence(CONFIDENCE);
    intent1.setIntent(INTENT);
    RuntimeIntent intent2 = new RuntimeIntent();
    intent2.setConfidence(CONFIDENCE);
    intent2.setIntent(INTENT);
    List<RuntimeIntent> intentList = new ArrayList<>();
    intentList.add(intent1);
    MessageInputOptions inputOptions = new MessageInputOptions();

    MessageInput messageInput = new MessageInput.Builder()
        .messageType(MessageInput.MessageType.TEXT)
        .entities(entityList)
        .addEntity(entity2)
        .intents(intentList)
        .addIntent(intent2)
        .options(inputOptions)
        .suggestionId(SUGGESTION_ID)
        .text(TEXT)
        .build();
    messageInput = messageInput.newBuilder().build();

    entityList.add(entity2);
    intentList.add(intent2);
    assertEquals(MessageInput.MessageType.TEXT, messageInput.messageType());
    assertEquals(entityList, messageInput.entities());
    assertEquals(intentList, messageInput.intents());
    assertEquals(inputOptions, messageInput.options());
    assertEquals(SUGGESTION_ID, messageInput.suggestionId());
    assertEquals(TEXT, messageInput.text());
  }

  @Test
  public void testMessageInputOptions() {
    MessageInputOptions inputOptions = new MessageInputOptions();
    inputOptions.setAlternateIntents(true);
    inputOptions.setDebug(true);
    inputOptions.setRestart(true);
    inputOptions.setReturnContext(true);

    assertTrue(inputOptions.isAlternateIntents());
    assertTrue(inputOptions.isDebug());
    assertTrue(inputOptions.isRestart());
    assertTrue(inputOptions.isReturnContext());
  }

  @Test
  public void testMessageOptions() {
    MessageContext messageContext = new MessageContext();
    MessageInput messageInput = new MessageInput.Builder().build();

    MessageOptions messageOptions = new MessageOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .context(messageContext)
        .input(messageInput)
        .sessionId(SESSION_ID)
        .build();
    messageOptions = messageOptions.newBuilder().build();

    assertEquals(ASSISTANT_ID, messageOptions.assistantId());
    assertEquals(messageContext, messageOptions.context());
    assertEquals(messageInput, messageOptions.input());
    assertEquals(SESSION_ID, messageOptions.sessionId());
  }

  @Test
  public void testRuntimeEntity() {
    CaptureGroup captureGroup = new CaptureGroup();
    captureGroup.setGroup(GROUP);
    List<CaptureGroup> captureGroupList = Collections.singletonList(captureGroup);

    RuntimeEntity runtimeEntity = new RuntimeEntity();
    runtimeEntity.setConfidence(CONFIDENCE);
    runtimeEntity.setEntity(ENTITY);
    runtimeEntity.setGroups(captureGroupList);
    runtimeEntity.setLocation(LOCATION);
    runtimeEntity.setMetadata(MAP);
    runtimeEntity.setValue(VALUE);

    assertEquals(CONFIDENCE, runtimeEntity.getConfidence());
    assertEquals(ENTITY, runtimeEntity.getEntity());
    assertEquals(captureGroupList, runtimeEntity.getGroups());
    assertEquals(LOCATION, runtimeEntity.getLocation());
    assertEquals(MAP, runtimeEntity.getMetadata());
    assertEquals(VALUE, runtimeEntity.getValue());
  }

  @Test
  public void testRuntimeIntent() {
    RuntimeIntent runtimeIntent = new RuntimeIntent();
    runtimeIntent.setConfidence(CONFIDENCE);
    runtimeIntent.setIntent(INTENT);

    assertEquals(CONFIDENCE, runtimeIntent.getConfidence());
    assertEquals(INTENT, runtimeIntent.getIntent());
  }

  @Test
  public void testMessage() throws InterruptedException {
    server.enqueue(jsonResponse(messageResponse));

    MessageOptions messageOptions = new MessageOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .sessionId(SESSION_ID)
        .build();
    MessageResponse response = service.message(messageOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(MESSAGE_PATH, request.getPath());
    assertNotNull(response.getContext());
    assertNotNull(response.getOutput());

    assertEquals(DialogNodeAction.ActionType.CLIENT, response.getOutput().getActions().get(0).getActionType());
    assertEquals(NAME, response.getOutput().getActions().get(0).getName());
    assertEquals(MAP, response.getOutput().getActions().get(0).getParameters());
    assertEquals(RESULT_VARIABLE, response.getOutput().getActions().get(0).getResultVariable());
    assertEquals(CREDENTIALS, response.getOutput().getActions().get(0).getCredentials());
    assertEquals(MessageOutputDebug.BranchExitedReason.COMPLETED,
        response.getOutput().getDebug().getBranchExitedReason());
    assertEquals(DialogLogMessage.Level.INFO, response.getOutput().getDebug().getLogMessages().get(0).getLevel());
    assertEquals(MESSAGE, response.getOutput().getDebug().getLogMessages().get(0).getMessage());
    assertEquals(CONDITIONS, response.getOutput().getDebug().getNodesVisited().get(0).getConditions());
    assertEquals(TITLE, response.getOutput().getDebug().getNodesVisited().get(0).getTitle());
    assertEquals(DIALOG_NODE, response.getOutput().getDebug().getNodesVisited().get(0).getDialogNode());
    assertTrue(response.getOutput().getDebug().isBranchExited());
    assertEquals(DESCRIPTION, response.getOutput().getGeneric().get(0).getDescription());
    assertEquals(DialogRuntimeResponseGeneric.ResponseType.TEXT,
        response.getOutput().getGeneric().get(0).getResponseType());
    assertEquals(DialogRuntimeResponseGeneric.Preference.BUTTON,
        response.getOutput().getGeneric().get(0).getPreference());
    assertEquals(TEXT, response.getOutput().getGeneric().get(0).getText());
    assertEquals(TIME, response.getOutput().getGeneric().get(0).getTime());
    assertTrue(response.getOutput().getGeneric().get(0).isTyping());
    assertEquals(SOURCE, response.getOutput().getGeneric().get(0).getSource());
    assertEquals(TITLE, response.getOutput().getGeneric().get(0).getTitle());
    assertEquals(MESSAGE, response.getOutput().getGeneric().get(0).getMessageToHumanAgent());
    assertEquals(TOPIC, response.getOutput().getGeneric().get(0).getTopic());
    assertEquals(LABEL, response.getOutput().getGeneric().get(0).getOptions().get(0).getLabel());
    assertNotNull(response.getOutput().getGeneric().get(0).getOptions().get(0).getValue().getInput());
    assertEquals(LABEL, response.getOutput().getGeneric().get(0).getSuggestions().get(0).getLabel());
    assertNotNull(response.getOutput().getGeneric().get(0).getSuggestions().get(0).getValue());
  }

  @Test
  public void testCreateSession() throws InterruptedException {
    server.enqueue(jsonResponse(sessionResponse));

    CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .build();
    SessionResponse response = service.createSession(createSessionOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertNotNull(response);
    assertEquals(CREATE_SESSION_PATH, request.getPath());

    assertEquals(SESSION_ID, response.getSessionId());
  }

  @Test
  public void testDeleteSession() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder()
        .assistantId(ASSISTANT_ID)
        .sessionId(SESSION_ID)
        .build();
    service.deleteSession(deleteSessionOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE_SESSION_PATH, request.getPath());
  }
}
