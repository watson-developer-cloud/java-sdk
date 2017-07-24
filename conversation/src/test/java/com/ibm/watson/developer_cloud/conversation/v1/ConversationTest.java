/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateCounterexample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateDialogNode;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValue;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the {@link ConversationService}.
 */
public class ConversationTest extends WatsonServiceUnitTest {
  private ConversationService service;
  private static final String FIXTURE = "src/test/resources/conversation/conversation.json";
  private static final String WORKSPACE_ID = "123";
  private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID + "/message";
  private static final String EMPTY = "";
  private static final String VERSION = "version";


  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ConversationService(ConversationService.VERSION_DATE_2017_05_26);
    service.setApiKey(EMPTY);
    service.setEndPoint(getMockWebServerUrl());

  }

  /**
   * Negative - Test constructor with null version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new ConversationService(null);
  }

  /**
   * Negative - Test constructor with empty version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new ConversationService("");
  }

  /**
   * Negative - Test conversation with null options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConversationWithNullOptions() {
    service.message(null).execute();
  }

  /**
   * Negative - Test conversation with null workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConversationWithNullWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder().build();
    service.message(options).execute();
  }

  /**
   * Negative - Test conversation with empty workspaceId.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConversationWithEmptyWorkspaceId() {
    MessageOptions options = new MessageOptions.Builder("").build();
    service.message(options).execute();
  }

  /**
   * Test send message.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessage() throws IOException, InterruptedException {
    String text = "I'd like to get insurance to for my home";

    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    InputData input = new InputData.Builder(text).build();
    RuntimeIntent intent = new RuntimeIntent();
    intent.setIntent("turn_off");
    intent.setConfidence(0.0);
    RuntimeEntity entity = new RuntimeEntity();
    entity.setEntity("car");
    entity.setValue("ford");
    MessageOptions options = new MessageOptions.Builder(WORKSPACE_ID)
        .input(input)
        .addIntent(intent)
        .addEntity(entity)
        .alternateIntents(true)
        .build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_05_26);
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] { "Do you want to get a quote?" },
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    String expected = "{" + "\"input\":{\"text\":\"I'd like to get insurance to for my home\"},"
                          + "\"intents\":[{\"confidence\":0.0,\"intent\":\"turn_off\"}],"
                          + "\"entities\":[{\"value\":\"ford\",\"entity\":\"car\"}],"
                          + "\"alternate_intents\":true" + "}";
    JsonParser parser = new JsonParser();
    JsonObject expectedObj = parser.parse(expected).getAsJsonObject();
    JsonObject actualObj = parser.parse(request.getBody().readUtf8()).getAsJsonObject();
    assertTrue(expectedObj.equals(actualObj));
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test send message. use some different MessageOptions options like context and other public methods
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessageWithAlternateIntents() throws IOException, InterruptedException {
    MessageResponse mockResponse = loadFixture(FIXTURE, MessageResponse.class);
    server.enqueue(jsonResponse(mockResponse));

    Context contextTemp = new Context();
    contextTemp.put("name", "Myname");
    InputData inputTemp = new InputData.Builder("My text").build();

    MessageOptions options = new MessageOptions.Builder(WORKSPACE_ID)
        .input(inputTemp)
        .alternateIntents(false)
        .context(contextTemp)
        .entities(null).intents(null).build();

    // execute first request
    MessageResponse serviceResponse = service.message(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=", ConversationService.VERSION_DATE_2017_05_26);
    assertEquals(path, request.getPath());
    assertArrayEquals(new String[] { "Do you want to get a quote?" },
        serviceResponse.getOutput().getText().toArray(new String[0]));
    assertEquals(request.getMethod(), "POST");
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(
        "{\"input\":{\"text\":\"My text\"},\"alternate_intents\":false," + "\"context\":{\"name\":\"Myname\"}}",
        request.getBody().readUtf8());
    assertEquals(serviceResponse, mockResponse);
  }


  /**
   * Negative - Test message with null workspace id.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithNullWorkspaceId() throws InterruptedException {
    String text = "I'd like to get insurance to for my home";

    InputData input = new InputData.Builder(text).build();
    MessageOptions options = new MessageOptions.Builder().input(input).alternateIntents(true).build();

    service.message(options).execute();
  }

  /**
   * Test CreateWorkspace builder.
   *
   */
  @Test
  public void testCreateWorkspaceBuilder() {

    String workspaceName = "Builder Test";
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // intents
    CreateIntent testIntent0 = new CreateIntent.Builder("testIntent0").build();
    CreateIntent testIntent1 = new CreateIntent.Builder("testIntent1").build();

    // entities
    CreateEntity testEntity0 = new CreateEntity.Builder("testEntity0").build();
    CreateEntity testEntity1 = new CreateEntity.Builder("testEntity1").build();

    // counterexamples
    CreateCounterexample testCounterexample0 = new CreateCounterexample.Builder("testCounterexample0").build();
    CreateCounterexample testCounterexample1 = new CreateCounterexample.Builder("testCounterexample1").build();

    // dialognodes
    CreateDialogNode testDialogNode0 = new CreateDialogNode.Builder("dialogNode0").build();
    CreateDialogNode testDialogNode1 = new CreateDialogNode.Builder("dialogNode1").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .language(workspaceLanguage)
        .addIntent(testIntent0).addIntent(testIntent1)
        .addEntity(testEntity0).addEntity(testEntity1)
        .addCounterexample(testCounterexample0).addCounterexample(testCounterexample1)
        .addDialogNode(testDialogNode0).addDialogNode(testDialogNode1)
        .metadata(workspaceMetadata)
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
    assertEquals(createOptions.dialogNodes().get(1), testDialogNode1);

    CreateWorkspaceOptions.Builder builder = createOptions.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    CreateCounterexample testCounterexample2 = new CreateCounterexample.Builder("testCounterexample2").build();
    CreateDialogNode testDialogNode2 = new CreateDialogNode.Builder("dialogNode2").build();

    builder.intents(Arrays.asList(testIntent2));
    builder.entities(Arrays.asList(testEntity2));
    builder.counterexamples(Arrays.asList(testCounterexample2));
    builder.dialogNodes(Arrays.asList(testDialogNode2));

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

  /**
   * Test UpdateWorkspaceOptions builder.
   *
   */
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
    CreateCounterexample testCounterexample = new CreateCounterexample.Builder("testCounterexample").build();

    // dialognodes
    CreateDialogNode testDialogNode = new CreateDialogNode.Builder("dialogNode").build();

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    UpdateWorkspaceOptions.Builder builder = new UpdateWorkspaceOptions.Builder(WORKSPACE_ID);
    builder.name(workspaceName);
    builder.description(workspaceDescription);
    builder.language(workspaceLanguage);
    builder.addIntent(testIntent);
    builder.addEntity(testEntity);
    builder.addCounterexample(testCounterexample);
    builder.addDialogNode(testDialogNode);
    builder.metadata(workspaceMetadata);

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

    UpdateWorkspaceOptions.Builder builder2 = options.newBuilder();

    CreateIntent testIntent2 = new CreateIntent.Builder("testIntent2").build();
    CreateEntity testEntity2 = new CreateEntity.Builder("testEntity2").build();
    CreateCounterexample testCounterexample2 = new CreateCounterexample.Builder("testCounterexample2").build();
    CreateDialogNode testDialogNode2 = new CreateDialogNode.Builder("dialogNode2").build();

    builder2.intents(new ArrayList<CreateIntent>());
    builder2.addIntent(testIntent2);
    builder2.entities(new ArrayList<CreateEntity>());
    builder2.addEntity(testEntity2);
    builder2.counterexamples(new ArrayList<CreateCounterexample>());
    builder2.addCounterexample(testCounterexample2);
    builder2.dialogNodes(new ArrayList<CreateDialogNode>());
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

  /**
   * Test CreateIntentOptions builder.
   *
   */
  @Test
  public void testCreateIntentOptionsBuilder() {
    String intent = "anIntent";
    CreateExample intentExample0 = new CreateExample.Builder().text("intentExample0").build();
    CreateExample intentExample1 = new CreateExample.Builder().text("intentExample1").build();

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .intent(intent)
        .addExample(intentExample0).addExample(intentExample1)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.intent(), intent);
    assertEquals(createOptions.examples().size(), 2);
    assertEquals(createOptions.examples().get(0), intentExample0);
    assertEquals(createOptions.examples().get(1), intentExample1);

    CreateIntentOptions.Builder builder = createOptions.newBuilder();

    CreateExample intentExample2 = new CreateExample.Builder().text("intentExample2").build();
    builder.examples(Arrays.asList(intentExample2));

    CreateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.examples().size(), 1);
    assertEquals(options2.examples().get(0), intentExample2);
  }

  /**
   * Test UpdateIntentOptions builder.
   *
   */
  @Test
  public void testUpdateIntentOptionsBuilder() {
    String intent = "anIntent";
    String newIntent = "renamedIntent";
    CreateExample intentExample0 = new CreateExample.Builder().text("intentExample0").build();
    CreateExample intentExample1 = new CreateExample.Builder().text("intentExample1").build();

    UpdateIntentOptions updateOptions = new UpdateIntentOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .intent(intent)
        .newIntent(newIntent)
        .addExample(intentExample0).addExample(intentExample1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.intent(), intent);
    assertEquals(updateOptions.newIntent(), newIntent);
    assertEquals(updateOptions.newExamples().size(), 2);
    assertEquals(updateOptions.newExamples().get(0), intentExample0);
    assertEquals(updateOptions.newExamples().get(1), intentExample1);

    UpdateIntentOptions.Builder builder = updateOptions.newBuilder();

    CreateExample intentExample2 = new CreateExample.Builder().text("intentExample2").build();
    builder.newExamples(Arrays.asList(intentExample2));

    UpdateIntentOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.intent(), intent);
    assertEquals(options2.newIntent(), newIntent);
    assertEquals(options2.newExamples().size(), 1);
    assertEquals(options2.newExamples().get(0), intentExample2);
  }

  /**
   * Test CreateEntityOptions builder.
   *
   */
  @Test
  public void testCreateEntityOptionsBuilder() {
    String entity = "anEntity";
    CreateValue entityValue0 = new CreateValue.Builder().value("entityValue0").build();
    CreateValue entityValue1 = new CreateValue.Builder().value("entityValue1").build();

    CreateEntityOptions createOptions = new CreateEntityOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .addValue(entityValue0).addValue(entityValue1)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.values().size(), 2);
    assertEquals(createOptions.values().get(0), entityValue0);
    assertEquals(createOptions.values().get(1), entityValue1);

    CreateEntityOptions.Builder builder = createOptions.newBuilder();

    CreateValue entityValue2 = new CreateValue.Builder().value("entityValue2").build();
    builder.values(Arrays.asList(entityValue2));

    CreateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.values().size(), 1);
    assertEquals(options2.values().get(0), entityValue2);
  }

  /**
   * Test UpdateEntityOptions builder.
   *
   */
  @Test
  public void testUpdateEntityOptionsBuilder() {
    String entity = "anEntity";
    String newEntity = "renamedEntity";
    CreateValue entityValue0 = new CreateValue.Builder().value("entityValue0").build();
    CreateValue entityValue1 = new CreateValue.Builder().value("entityValue1").build();

    UpdateEntityOptions updateOptions = new UpdateEntityOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .newEntity(newEntity)
        .addValue(entityValue0).addValue(entityValue1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newEntity(), newEntity);
    assertEquals(updateOptions.newValues().size(), 2);
    assertEquals(updateOptions.newValues().get(0), entityValue0);
    assertEquals(updateOptions.newValues().get(1), entityValue1);

    UpdateEntityOptions.Builder builder = updateOptions.newBuilder();

    CreateValue entityValue2 = new CreateValue.Builder().value("entityValue2").build();
    builder.newValues(Arrays.asList(entityValue2));

    UpdateEntityOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newEntity(), newEntity);
    assertEquals(options2.newValues().size(), 1);
    assertEquals(options2.newValues().get(0), entityValue2);
  }

  /**
   * Test CreateValueOptions builder.
   *
   */
  @Test
  public void testCreateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";

    CreateValueOptions createOptions = new CreateValueOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .value(value)
        .addSynonym(valueSynonym0).addSynonym(valueSynonym1)
        .build();

    assertEquals(createOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(createOptions.entity(), entity);
    assertEquals(createOptions.value(), value);
    assertEquals(createOptions.synonyms().size(), 2);
    assertEquals(createOptions.synonyms().get(0), valueSynonym0);
    assertEquals(createOptions.synonyms().get(1), valueSynonym1);

    CreateValueOptions.Builder builder = createOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    builder.synonyms(Arrays.asList(valueSynonym2));

    CreateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.value(), value);
    assertEquals(options2.synonyms().size(), 1);
    assertEquals(options2.synonyms().get(0), valueSynonym2);
  }

  /**
   * Test UpdateValueOptions builder.
   *
   */
  @Test
  public void testUpdateValueOptionsBuilder() {
    String entity = "anEntity";
    String value = "aValue";
    String newValue = "renamedValue";
    String valueSynonym0 = "valueSynonym0";
    String valueSynonym1 = "valueSynonym1";

    UpdateValueOptions updateOptions = new UpdateValueOptions.Builder()
        .workspaceId(WORKSPACE_ID)
        .entity(entity)
        .value(value)
        .newValue(newValue)
        .addSynonym(valueSynonym0).addSynonym(valueSynonym1)
        .build();

    assertEquals(updateOptions.workspaceId(), WORKSPACE_ID);
    assertEquals(updateOptions.entity(), entity);
    assertEquals(updateOptions.newValue(), newValue);
    assertEquals(updateOptions.newSynonyms().size(), 2);
    assertEquals(updateOptions.newSynonyms().get(0), valueSynonym0);
    assertEquals(updateOptions.newSynonyms().get(1), valueSynonym1);

    UpdateValueOptions.Builder builder = updateOptions.newBuilder();

    String valueSynonym2 = "valueSynonym2";
    builder.newSynonyms(Arrays.asList(valueSynonym2));

    UpdateValueOptions options2 = builder.build();

    assertEquals(options2.workspaceId(), WORKSPACE_ID);
    assertEquals(options2.entity(), entity);
    assertEquals(options2.newValue(), newValue);
    assertEquals(options2.newSynonyms().size(), 1);
    assertEquals(options2.newSynonyms().get(0), valueSynonym2);
  }
}
