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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ibm.watson.developer_cloud.conversation.v1.model.CounterexampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntity;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateWorkspace;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateWorkspace;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceResponse;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.util.RetryRunner;

/**
 * Integration test for the {@link ConversationService}.
 */
@RunWith(RetryRunner.class)
public class ConversationServiceIT extends WatsonServiceTest {

  private ConversationService service;
  private String workspaceId;
  private String exampleIntent;

  DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("conversation.v1.username");
    String password = getProperty("conversation.v1.password");
    workspaceId = getProperty("conversation.v1.workspace_id");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
    service.setEndPoint(getProperty("conversation.v1.url"));
    service.setUsernameAndPassword(username, password);
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test start a conversation without message.
   */
  @Test()
  public void testStartAConversationWithoutMessage() {
    service.message(workspaceId, null).execute();
  }

  /**
   * Test send messages.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessages() throws InterruptedException {
    final String[] messages = new String[] { "turn ac on", "turn right", "no", "yes" };
    Map<String, Object> context = null;
    for (final String message : messages) {
      MessageRequest request =
          new MessageRequest.Builder().inputText(message).alternateIntents(true).context(context).build();

      if (message.equals("yes")) {
        request = request.newBuilder().intent(new Intent("off_topic", 1.0)).build();
      }
      MessageResponse response = service.message(workspaceId, request).execute();

      assertMessageFromService(response);
      context = response.getContext();
      Thread.sleep(500);
    }
  }

  /**
   * Assert {@link MessageResponse} from service.
   *
   * @param message the message from the {@link ConversationService}
   */
  private void assertMessageFromService(MessageResponse message) {
    assertNotNull(message);
    assertNotNull(message.getEntities());
    assertNotNull(message.getIntents());
  }

  private long tolerance = 2000;  // 2 secs in ms

  /** return `true` if ldate before rdate within tolerance. */
  private boolean fuzzyBefore(Date ldate, Date rdate) {
    return (ldate.getTime() - rdate.getTime()) < tolerance;
  }

  /** return `true` if ldate after rdate within tolerance. */
  private boolean fuzzyAfter(Date ldate, Date rdate) {
    return (rdate.getTime() - ldate.getTime()) < tolerance;
  }

  /**
   * Test message with nulls.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMessageWithNulls() {
    service.message(null, null).execute();
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertNotNull(service.toString());
  }

  /**
   * Test createCounterexample.
   */
  @Test
  public void testCreateCounterexample() {

    Date start = new Date();

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique
    ExampleResponse response = service.createCounterexample(workspaceId, counterExampleText).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteCounterexample(workspaceId, counterExampleText).execute();
    }
  }

  /**
   * Test deleteCounterexample.
   */
  @Test
  public void testDeleteCounterexample() {

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique
    service.createCounterexample(workspaceId, counterExampleText).execute();

    service.deleteCounterexample(workspaceId, counterExampleText).execute();

    try {
      service.getCounterexample(workspaceId, counterExampleText).execute();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getCounterexample.
   */
  @Test
  public void testGetCounterexample() {

    Date start = new Date();

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique
    service.createCounterexample(workspaceId, counterExampleText).execute();

    try {
      ExampleResponse response = service.getCounterexample(workspaceId, counterExampleText).execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteCounterexample(workspaceId, counterExampleText).execute();
    }
  }

  /**
   * Test listCounterexamples.
   */
  @Test
  public void testListCounterexamples() {

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique

    try {
      CounterexampleCollectionResponse ccResponse = service.listCounterexamples(workspaceId, null, null, null, null)
          .execute();
      assertNotNull(ccResponse);
      assertNotNull(ccResponse.getCounterexamples());
      assertNotNull(ccResponse.getPagination());
      assertNotNull(ccResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add a counterexample and make sure we get it back
      service.createCounterexample(workspaceId, counterExampleText).execute();

      long count = ccResponse.getCounterexamples().size();
      CounterexampleCollectionResponse ccResponse2 = service.listCounterexamples(workspaceId, count + 1, null, null,
          null).execute();
      assertNotNull(ccResponse2);
      assertNotNull(ccResponse2.getCounterexamples());

      List<ExampleResponse> counterexamples = ccResponse2.getCounterexamples();
      assertTrue(counterexamples.size() > count);

      ExampleResponse exResponse = null;
      for (ExampleResponse resp : counterexamples) {
        if (resp.getText().equals(counterExampleText)) {
          exResponse = resp;
          break;
        }
      }

      assertNotNull(exResponse);
      Date now = new Date();
      assertTrue(fuzzyBefore(exResponse.getCreated(), now));
      assertTrue(fuzzyAfter(exResponse.getCreated(), start));
      assertTrue(fuzzyBefore(exResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(exResponse.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteCounterexample(workspaceId, counterExampleText).execute();
    }
  }

  /**
   * Test updateCounterexample.
   */
  @Test
  public void testUpdateCounterexample() {

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique
    String counterExampleText2 = "Make me a " + UUID.randomUUID().toString() + " sandwich";  // gotta be unique
    service.createCounterexample(workspaceId, counterExampleText).execute();

    try {
      Date start = new Date();
      ExampleResponse response = service.updateCounterexample(workspaceId, counterExampleText, counterExampleText2)
          .execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
      assertNotEquals(response.getCreated(), response.getUpdated());
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteCounterexample(workspaceId, counterExampleText2).execute();
    }
  }

  public void createExampleIntent() {
    exampleIntent = "Hello";
    try {
      service.createIntent(workspaceId, exampleIntent, "Example Intent", null).execute();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }
  }

  /**
   * Test createExample.
   */
  @Test
  public void testCreateExample() {

    createExampleIntent();

    Date start = new Date();

    String exampleText = "Howdy " + UUID.randomUUID().toString();  // gotta be unique
    ExampleResponse response = service.createExample(workspaceId, exampleIntent, exampleText).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), exampleText);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteExample(workspaceId, exampleIntent, exampleText).execute();
    }
  }

  /**
   * Test deleteExample.
   */
  @Test
  public void testDeleteExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString();  // gotta be unique
    service.createExample(workspaceId, exampleIntent, exampleText).execute();

    service.deleteExample(workspaceId, exampleIntent, exampleText).execute();

    try {
      service.getExample(workspaceId, exampleIntent, exampleText).execute();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getExample.
   */
  @Test
  public void testGetExample() {

    createExampleIntent();

    Date start = new Date();

    String exampleText = "Howdy " + UUID.randomUUID().toString();  // gotta be unique
    service.createExample(workspaceId, exampleIntent, exampleText).execute();

    try {
      ExampleResponse response = service.getExample(workspaceId, exampleIntent, exampleText).execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), exampleText);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteExample(workspaceId, exampleIntent, exampleText).execute();
    }
  }

  /**
   * Test listExamples.
   */
  @Test
  public void testListExamples() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString();  // gotta be unique

    try {
      ExampleCollectionResponse ecResponse = service.listExamples(workspaceId, exampleIntent, null, null, null, null)
          .execute();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());
      assertNotNull(ecResponse.getPagination());
      assertNotNull(ecResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add an example and make sure we get it back
      service.createExample(workspaceId, exampleIntent, exampleText).execute();

      long count = ecResponse.getExamples().size();
      ExampleCollectionResponse ecResponse2 = service.listExamples(workspaceId, exampleIntent, count + 1, null, null,
          null).execute();
      assertNotNull(ecResponse2);
      assertNotNull(ecResponse2.getExamples());

      List<ExampleResponse> examples = ecResponse2.getExamples();
      assertTrue(examples.size() > count);

      ExampleResponse exResponse = null;
      for (ExampleResponse resp : examples) {
        if (resp.getText().equals(exampleText)) {
          exResponse = resp;
          break;
        }
      }

      assertNotNull(exResponse);
      Date now = new Date();
      assertTrue(fuzzyBefore(exResponse.getCreated(), now));
      assertTrue(fuzzyAfter(exResponse.getCreated(), start));
      assertTrue(fuzzyBefore(exResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(exResponse.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteExample(workspaceId, exampleIntent, exampleText).execute();
    }

  }

  /**
   * Test updateExample.
   */
  @Test
  public void testUpdateExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString();  // gotta be unique
    String exampleText2 = "Howdy " + UUID.randomUUID().toString();  // gotta be unique
    service.createExample(workspaceId, exampleIntent, exampleText).execute();

    try {
      Date start = new Date();
      ExampleResponse response = service.updateExample(workspaceId, exampleIntent, exampleText, exampleText2).execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), exampleText2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));
      assertNotEquals(response.getCreated(), response.getUpdated());
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteExample(workspaceId, exampleIntent, exampleText2).execute();
    }
  }

  /**
   * Test createIntent.
   */
  @Test
  public void testCreateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    Date start = new Date();

    IntentResponse response = service.createIntent(workspaceId, intentName, intentDescription, intentExamples)
        .execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getIntent());
      assertEquals(response.getIntent(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      ExampleCollectionResponse ecResponse = service.listExamples(workspaceId, intentName, null, null, null, null)
          .execute();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<ExampleResponse> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getText(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteIntent(workspaceId, intentName).execute();
    }
  }

  /**
   * Test deleteIntent.
   */
  @Test
  public void testDeleteIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String intentDescription = "Description of " + intentName;

    service.createIntent(workspaceId, intentName, intentDescription, null).execute();

    service.deleteIntent(workspaceId, intentName).execute();

    try {
      service.getIntent(workspaceId, intentName, false).execute();
      fail("deleteIntent failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getIntent.
   */
  @Test
  public void testGetIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    Date start = new Date();

    service.createIntent(workspaceId, intentName, intentDescription, intentExamples).execute();

    try {
      IntentExportResponse response = service.getIntent(workspaceId, intentName, true).execute();
      assertNotNull(response);
      assertNotNull(response.getIntent());
      assertEquals(response.getIntent(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription);
      assertNotNull(response.getExamples());
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      List<ExampleResponse> examples = response.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getText(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteIntent(workspaceId, intentName).execute();
    }
  }

  /**
   * Test listIntents.
   */
  @Test
  public void testListIntents() {

    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique

    try {
      IntentCollectionResponse response = service.listIntents(workspaceId, false, null, null, null, null).execute();
      assertNotNull(response);
      assertNotNull(response.getIntents());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null

      // Now add an intent and make sure we get it back
      String intentDescription = "Description of " + intentName;
      String intentExample = "Example of " + intentName;
      List<CreateExample> intentExamples = new ArrayList<CreateExample>();
      intentExamples.add(new CreateExample.Builder().text(intentExample).build());

      Date start = new Date();

      service.createIntent(workspaceId, intentName, intentDescription, intentExamples).execute();

      long count = response.getIntents().size();
      IntentCollectionResponse response2 = service.listIntents(workspaceId, true, count + 1, null, null, null)
          .execute();
      assertNotNull(response2);
      assertNotNull(response2.getIntents());

      List<IntentExportResponse> intents = response2.getIntents();
      assertTrue(intents.size() > count);

      IntentExportResponse ieResponse = null;
      for (IntentExportResponse resp : intents) {
        if (resp.getIntent().equals(intentName)) {
          ieResponse = resp;
          break;
        }
      }

      assertNotNull(ieResponse);
      assertNotNull(ieResponse.getDescription());
      assertEquals(ieResponse.getDescription(), intentDescription);
      assertNotNull(ieResponse.getExamples());
      assertTrue(ieResponse.getExamples().size() == 1);
      assertEquals(ieResponse.getExamples().get(0).getText(), intentExample);

      Date now = new Date();
      assertTrue(fuzzyBefore(ieResponse.getCreated(), now));
      assertTrue(fuzzyAfter(ieResponse.getCreated(), start));
      assertTrue(fuzzyBefore(ieResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(ieResponse.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteIntent(workspaceId, intentName).execute();
    }
  }

  /**
   * Test updateIntent.
   */
  @Test
  public void testUpdateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    service.createIntent(workspaceId, intentName, intentDescription, intentExamples).execute();

    try {
      String intentDescription2 = "Updated description of " + intentName;
      String intentExample2 = "Updated Example of " + intentName;
      List<CreateExample> intentExamples2 = new ArrayList<CreateExample>();
      intentExamples2.add(new CreateExample.Builder().text(intentExample2).build());
      Date start = new Date();
      IntentResponse response = service.updateIntent(workspaceId, intentName, null, intentDescription2,
          intentExamples2).execute();
      assertNotNull(response);
      assertNotNull(response.getIntent());
      assertEquals(response.getIntent(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      ExampleCollectionResponse ecResponse = service.listExamples(workspaceId, intentName, null, null, null, null)
          .execute();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<ExampleResponse> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getText(), intentExample2);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteIntent(workspaceId, intentName).execute();
    }
  }

  /**
   * Test createWorkspace.
   */
  @Test
  public void testCreateWorkspace() {

    String workspaceName = "API Test " + UUID.randomUUID().toString();  // gotta be unique
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // intents
    List<CreateIntent> workspaceIntents = new ArrayList<CreateIntent>();
    String intentName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());
    workspaceIntents.add(new CreateIntent.Builder()
        .intent(intentName)
        .description(intentDescription)
        .examples(intentExamples)
        .build());

    // entities
    List<CreateEntity> workspaceEntities = new ArrayList<CreateEntity>();
//    String entityName = "Hello" + UUID.randomUUID().toString();  // gotta be unique
//    String entityDescription = "Description of " + entityName;
//    String entitySource = "Source for " + entityName;
//    String entityValue = "Value of " + entityName;
//    String entityValueSynonym = "Synonym for Value of " + entityName;
//    List<CreateValue> entityValues = new ArrayList<CreateValue>();
//    entityValues.add(new CreateValue.Builder()
//        .value(entityValue)
//        .synonyms(entityValueSynonym)
//        .build());
//    workspaceEntities.add(new CreateEntity.Builder()
//        .entity(entityName)
//        .description(entityDescription)
//        .source(entitySource)
//        .values(entityValues)
//        .build());

    // counterexamples
    List<CreateExample> workspaceCounterExamples = new ArrayList<CreateExample>();
    String counterExampleText = "Counterexample for " + workspaceName;
    workspaceCounterExamples.add(new CreateExample.Builder().text(counterExampleText).build());

    CreateWorkspace request = new CreateWorkspace.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .language(workspaceLanguage)
        .metadata(workspaceMetadata)
        .intents(workspaceIntents)
        .entities(workspaceEntities)
        .counterexamples(workspaceCounterExamples)
        .build();

    String workspaceId = null;
    try {
      Date start = new Date();

      WorkspaceResponse response = service.createWorkspace(request).execute();

      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      workspaceId = response.getWorkspaceId();
      assertNotNull(response.getName());
      assertEquals(response.getName(), workspaceName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), workspaceDescription);
      assertNotNull(response.getLanguage());
      assertEquals(response.getLanguage(), workspaceLanguage);

      Date now = new Date();

      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyAfter(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      // metadata
      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue);

      WorkspaceExportResponse exResponse = service.getWorkspace(workspaceId, true).execute();
      assertNotNull(exResponse);

      // intents
      assertNotNull(exResponse.getIntents());
      assertTrue(exResponse.getIntents().size() == 1);
      assertNotNull(exResponse.getIntents().get(0).getIntent());
      assertEquals(exResponse.getIntents().get(0).getIntent(), intentName);
      assertNotNull(exResponse.getIntents().get(0).getDescription());
      assertEquals(exResponse.getIntents().get(0).getDescription(), intentDescription);
      assertNotNull(exResponse.getIntents().get(0).getExamples());
      assertTrue(exResponse.getIntents().get(0).getExamples().size() == 1);
      assertNotNull(exResponse.getIntents().get(0).getExamples().get(0));
      assertNotNull(exResponse.getIntents().get(0).getExamples().get(0).getText());
      assertEquals(exResponse.getIntents().get(0).getExamples().get(0).getText(), intentExample);

      // entities
      assertNotNull(exResponse.getEntities());
//      assertTrue(exResponse.getEntities().size() == 1);
//      assertNotNull(exResponse.getEntities().get(0).getEntity());
//      assertEquals(exResponse.getEntities().get(0).getEntity(), entityName);
//      assertNotNull(exResponse.getEntities().get(0).getDescription());
//      assertEquals(exResponse.getEntities().get(0).getDescription(), entityDescription);
//      assertNotNull(exResponse.getEntities().get(0).getSource());
//      assertEquals(exResponse.getEntities().get(0).getSource(),entitySource);
//      assertNotNull(exResponse.getEntities().get(0).getValues());
//      assertTrue(exResponse.getEntities().get(0).getValues().size() == 1);
//      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).getValue());
//      assertEquals(exResponse.getEntities().get(0).getValues().get(0).getValue(),entityValue);
//      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).getSynonyms());
//      assertTrue(exResponse.getEntities().get(0).getValues().get(0).getSynonyms().size() == 1);
//      assertEquals(exResponse.getEntities().get(0).getValues().get(0).getSynonyms().get(0),entityValueSynonym);

      // counterexamples
      assertNotNull(exResponse.getCounterexamples());
      assertTrue(exResponse.getCounterexamples().size() == 1);
      assertNotNull(exResponse.getCounterexamples().get(0).getText());
      assertEquals(exResponse.getCounterexamples().get(0).getText(), counterExampleText);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      if (workspaceId != null) {
        service.deleteWorkspace(workspaceId).execute();
      }
    }
  }

  /**
   * Test deleteWorkspace.
   */
  @Test
  public void testDeleteWorkspace() {

    String workspaceName = "API Test " + UUID.randomUUID().toString();  // gotta be unique
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    CreateWorkspace request = new CreateWorkspace.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .language(workspaceLanguage)
        .build();

    String workspaceId = null;
    try {
      WorkspaceResponse response = service.createWorkspace(request).execute();
      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      workspaceId = response.getWorkspaceId();

      service.deleteWorkspace(workspaceId).execute();

      service.getWorkspace(workspaceId, true).execute();
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
      workspaceId = null;
    } finally {
      // Clean up
      if (workspaceId != null) {
        service.deleteWorkspace(workspaceId).execute();
      }
    }
  }

  /**
   * Test getWorkspace.
   */
  @Test
  public void testGetWorkspace() {

    WorkspaceExportResponse response = service.getWorkspace(workspaceId, false).execute();

    try {
      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      assertEquals(response.getWorkspaceId(), workspaceId);
      assertNotNull(response.getName());
      assertNotNull(response.getDescription());
      assertNotNull(response.getLanguage());

      Date now = new Date();

      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());
      assertTrue(fuzzyBefore(response.getCreated(), now));
      assertTrue(fuzzyBefore(response.getUpdated(), now));

      // metadata, intents, entities, dialogNodes, and counterexamples could be null

    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /**
   * Test listWorkspaces.
   */
  @Test
  public void testListWorkspaces() {

    WorkspaceCollectionResponse response = service.listWorkspaces(null, null, null, null).execute();

    assertNotNull(response);
    assertNotNull(response.getWorkspaces());
    assertTrue(response.getWorkspaces().size() > 0);
    assertNotNull(response.getPagination());
    assertNotNull(response.getPagination().getRefreshUrl());

    WorkspaceResponse wResponse = null;
    for (WorkspaceResponse resp : response.getWorkspaces()) {
      if (resp.getWorkspaceId().equals(workspaceId)) {
        wResponse = resp;
        break;
      }
    }

    assertNotNull(wResponse);
    assertNotNull(wResponse.getName());
    assertNotNull(wResponse.getDescription());
  }

  /**
   * Test updateWorkspace.
   */
  @Test
  public void testUpdateWorkspace() {

    String counterExampleText = "Counterexample " + UUID.randomUUID().toString();  // gotta be unique
    UpdateWorkspace request = new UpdateWorkspace.Builder()
        .counterexamples(new CreateExample.Builder().text(counterExampleText).build())
        .build();

    Date start = new Date();

    WorkspaceResponse response = service.updateWorkspace(workspaceId, request).execute();

    try {
      Date now = new Date();

      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());
      assertTrue(fuzzyBefore(response.getCreated(), start));
      assertTrue(fuzzyBefore(response.getUpdated(), now));
      assertTrue(fuzzyAfter(response.getUpdated(), start));

      ExampleResponse eResponse = service.getCounterexample(workspaceId, counterExampleText).execute();
      assertNotNull(eResponse);
      assertNotNull(eResponse.getText());
      assertEquals(eResponse.getText(), counterExampleText);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      service.deleteCounterexample(workspaceId, counterExampleText).execute();
    }
  }
}
