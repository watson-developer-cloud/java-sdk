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
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ibm.watson.developer_cloud.conversation.v1.model.CounterexampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateExample;
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
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));
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
      ExampleResponse response = service.getCounterexample(workspaceId, counterExampleText).execute();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
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
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));

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
      CounterexampleCollectionResponse ccResponse = service.listCounterexamples(workspaceId, null, null, null, null).execute();
      assertNotNull(ccResponse);
      assertNotNull(ccResponse.getCounterexamples());
      assertNotNull(ccResponse.getPagination());
      assertNotNull(ccResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add a counterexample and make sure we get it back
      service.createCounterexample(workspaceId, counterExampleText).execute();

      double count = ccResponse.getCounterexamples().size();
      CounterexampleCollectionResponse ccResponse2 = service.listCounterexamples(workspaceId, count + 1, null, null, null).execute();
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
      Date created = isoDateFormat.parse(exResponse.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(exResponse.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));

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
      UpdateExample update = new UpdateExample.Builder().text(counterExampleText2).build();
      ExampleResponse response = service.updateCounterexample(workspaceId, counterExampleText, update).execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));
      assertNotEquals(created, updated);
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
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));
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
      ExampleResponse response = service.getExample(workspaceId, exampleIntent, exampleText).execute();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
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
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));

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
      ExampleCollectionResponse ecResponse = service.listExamples(workspaceId, exampleIntent, null, null, null, null).execute();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());
      assertNotNull(ecResponse.getPagination());
      assertNotNull(ecResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add a counterexample and make sure we get it back
      service.createExample(workspaceId, exampleIntent, exampleText).execute();

      double count = ecResponse.getExamples().size();
      ExampleCollectionResponse ecResponse2 = service.listExamples(workspaceId, exampleIntent, count + 1, null, null, null).execute();
      assertNotNull(ecResponse2);
      assertNotNull(ecResponse2.getExamples());

      List<ExampleResponse> counterexamples = ecResponse2.getExamples();
      assertTrue(counterexamples.size() > count);

      ExampleResponse exResponse = null;
      for (ExampleResponse resp : counterexamples) {
        if (resp.getText().equals(exampleText)) {
          exResponse = resp;
          break;
        }
      }

      assertNotNull(exResponse);
      Date now = new Date();
      Date created = isoDateFormat.parse(exResponse.getCreated());
      assertTrue(created.before(now));
      assertTrue(created.after(start));
      Date updated = isoDateFormat.parse(exResponse.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));

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
      UpdateExample update = new UpdateExample.Builder().text(exampleText2).build();
      ExampleResponse response = service.updateExample(workspaceId, exampleIntent, exampleText, update).execute();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), exampleText2);
      assertNotNull(response.getCreated());
      assertNotNull(response.getUpdated());

      Date now = new Date();
      Date created = isoDateFormat.parse(response.getCreated());
      assertTrue(created.before(now));
      Date updated = isoDateFormat.parse(response.getUpdated());
      assertTrue(updated.before(now));
      assertTrue(updated.after(start));
      assertNotEquals(created, updated);
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
    // TODO: make test
    fail("Test for createIntent not yet implemented");
  }

  /**
   * Test deleteIntent.
   */
  @Test
  public void testDeleteIntent() {
    // TODO: make test
    fail("Test for deleteIntent not yet implemented");
  }

  /**
   * Test getIntent.
   */
  @Test
  public void testGetIntent() {
    // TODO: make test
    fail("Test for getIntent not yet implemented");
  }

  /**
   * Test listIntents.
   */
  @Test
  public void testListIntents() {
    // TODO: make test
    fail("Test for listIntents not yet implemented");
  }

  /**
   * Test updateIntent.
   */
  @Test
  public void testUpdateIntent() {
    // TODO: make test
    fail("Test for updateIntent not yet implemented");
  }

  /**
   * Test createWorkspace.
   */
  @Test
  public void testCreateWorkspace() {
    // TODO: make test
    fail("Test for createWorkspace not yet implemented");
  }

  /**
   * Test deleteWorkspace.
   */
  @Test
  public void testDeleteWorkspace() {
    // TODO: make test
    fail("Test for deleteWorkspace not yet implemented");
  }

  /**
   * Test getWorkspace.
   */
  @Test
  public void testGetWorkspace() {
    // TODO: make test
    fail("Test for getWorkspace not yet implemented");
  }

  /**
   * Test listWorkspaces.
   */
  @Test
  public void testListWorkspaces() {
    // TODO: make test
    fail("Test for listWorkspaces not yet implemented");
  }

  /**
   * Test updateWorkspace.
   */
  @Test
  public void testUpdateWorkspace() {
    // TODO: make test
    fail("Test for updateWorkspace not yet implemented");
  }
}
