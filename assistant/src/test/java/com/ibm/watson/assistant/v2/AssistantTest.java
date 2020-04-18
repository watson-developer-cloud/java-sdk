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
package com.ibm.watson.assistant.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.assistant.v2.model.CaptureGroup;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DialogLogMessage;
import com.ibm.watson.assistant.v2.model.DialogNodeAction;
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
import com.ibm.watson.assistant.v2.model.RuntimeResponseGeneric;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.common.WatsonServiceUnitTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

/** Unit tests for Assistant v2. */
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
  private static final String MESSAGE_PATH =
      String.format(
          "/v2/assistants/%s/sessions/%s/message?version=%s", ASSISTANT_ID, SESSION_ID, VERSION);
  private static final String CREATE_SESSION_PATH =
      String.format("/v2/assistants/%s/sessions?version=%s", ASSISTANT_ID, VERSION);
  private static final String DELETE_SESSION_PATH =
      String.format("/v2/assistants/%s/sessions/%s?version=%s", ASSISTANT_ID, SESSION_ID, VERSION);

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

    service = new Assistant(VERSION, new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());
  }

  @Test
  public void testCaptureGroup() {
    CaptureGroup captureGroup = new CaptureGroup.Builder().group(GROUP).location(LOCATION).build();

    assertEquals(GROUP, captureGroup.group());
    assertEquals(LOCATION, captureGroup.location());
  }

  @Test
  public void testCreateSessionOptions() {
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(ASSISTANT_ID).build();
    createSessionOptions = createSessionOptions.newBuilder().build();

    assertEquals(ASSISTANT_ID, createSessionOptions.assistantId());
  }

  @Test
  public void testDeleteSessionOptions() {
    DeleteSessionOptions deleteSessionOptions =
        new DeleteSessionOptions.Builder().assistantId(ASSISTANT_ID).sessionId(SESSION_ID).build();
    deleteSessionOptions = deleteSessionOptions.newBuilder().build();

    assertEquals(ASSISTANT_ID, deleteSessionOptions.assistantId());
    assertEquals(SESSION_ID, deleteSessionOptions.sessionId());
  }

  @Test
  public void testMessageContextGlobalSystem() {
    MessageContextGlobalSystem messageContextGlobalSystem =
        new MessageContextGlobalSystem.Builder()
            .timezone(TIMEZONE)
            .turnCount(TURN_COUNT)
            .userId(USER_ID)
            .build();

    assertEquals(TIMEZONE, messageContextGlobalSystem.timezone());
    assertEquals(TURN_COUNT, messageContextGlobalSystem.turnCount());
    assertEquals(USER_ID, messageContextGlobalSystem.userId());
  }

  @Test
  public void testMessageContextGlobal() {
    MessageContextGlobalSystem messageContextGlobalSystem =
        new MessageContextGlobalSystem.Builder().build();

    MessageContextGlobal messageContextGlobal =
        new MessageContextGlobal.Builder().system(messageContextGlobalSystem).build();

    assertEquals(messageContextGlobalSystem, messageContextGlobal.system());
  }

  @Test
  public void testMessageContext() {
    MessageContextGlobal messageContextGlobal = new MessageContextGlobal.Builder().build();
    MessageContextSkills messageContextSkills = new MessageContextSkills();

    MessageContext messageContext =
        new MessageContext.Builder()
            .global(messageContextGlobal)
            .skills(messageContextSkills)
            .build();

    assertEquals(messageContextGlobal, messageContext.global());
    assertEquals(messageContextSkills, messageContext.skills());
  }

  @Test
  public void testMessageInput() {
    RuntimeEntity entity1 =
        new RuntimeEntity.Builder().entity(ENTITY).location(LOCATION).value(VALUE).build();
    RuntimeEntity entity2 =
        new RuntimeEntity.Builder().entity(ENTITY).location(LOCATION).value(VALUE).build();
    List<RuntimeEntity> entityList = new ArrayList<>();
    entityList.add(entity1);
    RuntimeIntent intent1 =
        new RuntimeIntent.Builder().confidence(CONFIDENCE).intent(INTENT).build();
    RuntimeIntent intent2 =
        new RuntimeIntent.Builder().confidence(CONFIDENCE).intent(INTENT).build();
    List<RuntimeIntent> intentList = new ArrayList<>();
    intentList.add(intent1);
    MessageInputOptions inputOptions = new MessageInputOptions.Builder().build();

    MessageInput messageInput =
        new MessageInput.Builder()
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
    MessageInputOptions inputOptions =
        new MessageInputOptions.Builder()
            .alternateIntents(true)
            .debug(true)
            .restart(true)
            .returnContext(true)
            .build();

    assertTrue(inputOptions.alternateIntents());
    assertTrue(inputOptions.debug());
    assertTrue(inputOptions.restart());
    assertTrue(inputOptions.returnContext());
  }

  @Test
  public void testMessageOptions() {
    MessageContext messageContext = new MessageContext.Builder().build();
    MessageInput messageInput = new MessageInput.Builder().build();

    MessageOptions messageOptions =
        new MessageOptions.Builder()
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
    CaptureGroup captureGroup = new CaptureGroup.Builder().group(GROUP).build();
    List<CaptureGroup> captureGroupList = Collections.singletonList(captureGroup);

    RuntimeEntity runtimeEntity =
        new RuntimeEntity.Builder()
            .confidence(CONFIDENCE)
            .entity(ENTITY)
            .groups(captureGroupList)
            .location(LOCATION)
            .metadata(MAP)
            .value(VALUE)
            .build();

    assertEquals(CONFIDENCE, runtimeEntity.confidence());
    assertEquals(ENTITY, runtimeEntity.entity());
    assertEquals(captureGroupList, runtimeEntity.groups());
    assertEquals(LOCATION, runtimeEntity.location());
    assertEquals(MAP, runtimeEntity.metadata());
    assertEquals(VALUE, runtimeEntity.value());
  }

  @Test
  public void testRuntimeIntent() {
    RuntimeIntent runtimeIntent =
        new RuntimeIntent.Builder().confidence(CONFIDENCE).intent(INTENT).build();

    assertEquals(CONFIDENCE, runtimeIntent.confidence());
    assertEquals(INTENT, runtimeIntent.intent());
  }

  @Test
  public void testMessage() throws InterruptedException {
    server.enqueue(jsonResponse(messageResponse));

    MessageOptions messageOptions =
        new MessageOptions.Builder().assistantId(ASSISTANT_ID).sessionId(SESSION_ID).build();
    MessageResponse response = service.message(messageOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(MESSAGE_PATH, request.getPath());
    assertNotNull(response.getContext());
    assertNotNull(response.getOutput());

    assertEquals(DialogNodeAction.Type.CLIENT, response.getOutput().getActions().get(0).getType());
    assertEquals(NAME, response.getOutput().getActions().get(0).getName());
    assertEquals(MAP, response.getOutput().getActions().get(0).getParameters());
    assertEquals(RESULT_VARIABLE, response.getOutput().getActions().get(0).getResultVariable());
    assertEquals(CREDENTIALS, response.getOutput().getActions().get(0).getCredentials());
    assertEquals(
        MessageOutputDebug.BranchExitedReason.COMPLETED,
        response.getOutput().getDebug().getBranchExitedReason());
    assertEquals(
        DialogLogMessage.Level.INFO,
        response.getOutput().getDebug().getLogMessages().get(0).getLevel());
    assertEquals(MESSAGE, response.getOutput().getDebug().getLogMessages().get(0).getMessage());
    assertEquals(
        CONDITIONS, response.getOutput().getDebug().getNodesVisited().get(0).getConditions());
    assertEquals(TITLE, response.getOutput().getDebug().getNodesVisited().get(0).getTitle());
    assertEquals(
        DIALOG_NODE, response.getOutput().getDebug().getNodesVisited().get(0).getDialogNode());
    assertTrue(response.getOutput().getDebug().isBranchExited());
    assertEquals(DESCRIPTION, response.getOutput().getGeneric().get(0).description());
    assertEquals(
        RuntimeResponseGeneric.ResponseType.TEXT,
        response.getOutput().getGeneric().get(0).responseType());
    assertEquals(
        RuntimeResponseGeneric.Preference.BUTTON,
        response.getOutput().getGeneric().get(0).preference());
    assertEquals(TEXT, response.getOutput().getGeneric().get(0).text());
    assertEquals(TIME, response.getOutput().getGeneric().get(0).time());
    assertTrue(response.getOutput().getGeneric().get(0).typing());
    assertEquals(SOURCE, response.getOutput().getGeneric().get(0).source());
    assertEquals(TITLE, response.getOutput().getGeneric().get(0).title());
    assertEquals(MESSAGE, response.getOutput().getGeneric().get(0).messageToHumanAgent());
    assertEquals(TOPIC, response.getOutput().getGeneric().get(0).topic());
    assertEquals(LABEL, response.getOutput().getGeneric().get(0).options().get(0).getLabel());
    assertNotNull(response.getOutput().getGeneric().get(0).options().get(0).getValue().getInput());
    assertEquals(LABEL, response.getOutput().getGeneric().get(0).suggestions().get(0).getLabel());
    assertNotNull(response.getOutput().getGeneric().get(0).suggestions().get(0).getValue());
  }

  @Test
  public void testCreateSession() throws InterruptedException {
    server.enqueue(jsonResponse(sessionResponse));

    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(ASSISTANT_ID).build();
    SessionResponse response = service.createSession(createSessionOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertNotNull(response);
    assertEquals(CREATE_SESSION_PATH, request.getPath());

    assertEquals(SESSION_ID, response.getSessionId());
  }

  @Test
  public void testDeleteSession() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteSessionOptions deleteSessionOptions =
        new DeleteSessionOptions.Builder().assistantId(ASSISTANT_ID).sessionId(SESSION_ID).build();
    service.deleteSession(deleteSessionOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE_SESSION_PATH, request.getPath());
  }
}
