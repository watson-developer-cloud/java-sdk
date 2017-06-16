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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateCounterexample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeIntent;
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
    assertEquals(expected, request.getBody().readUtf8());
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
   * Test UpdateWorkspace builder.
   *
   */
  @Test
  public void testUpdateWorkspaceBuilder() {

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
    Map<String, Object> testDialogNode = new HashMap<String, Object>();
    testDialogNode.put("name", "testDialogNode");

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
    Map<String, Object> testDialogNode2 = new HashMap<String, Object>();
    testDialogNode2.put("name", "dialogNode2");

    builder2.intents(new ArrayList<CreateIntent>());
    builder2.addIntent(testIntent2);
    builder2.entities(new ArrayList<CreateEntity>());
    builder2.addEntity(testEntity2);
    builder2.counterexamples(new ArrayList<CreateCounterexample>());
    builder2.addCounterexample(testCounterexample2);
    builder2.dialogNodes(new ArrayList<Object>());
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
}
