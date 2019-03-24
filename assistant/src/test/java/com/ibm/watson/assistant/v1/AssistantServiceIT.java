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
package com.ibm.watson.assistant.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.Counterexample;
import com.ibm.watson.assistant.v1.model.CounterexampleCollection;
import com.ibm.watson.assistant.v1.model.CreateCounterexample;
import com.ibm.watson.assistant.v1.model.CreateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.CreateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.CreateEntity;
import com.ibm.watson.assistant.v1.model.CreateExample;
import com.ibm.watson.assistant.v1.model.CreateExampleOptions;
import com.ibm.watson.assistant.v1.model.CreateIntent;
import com.ibm.watson.assistant.v1.model.CreateIntentOptions;
import com.ibm.watson.assistant.v1.model.CreateValue;
import com.ibm.watson.assistant.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DeleteCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.DeleteExampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteIntentOptions;
import com.ibm.watson.assistant.v1.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v1.model.DeleteWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DialogNode;
import com.ibm.watson.assistant.v1.model.DialogNodeCollection;
import com.ibm.watson.assistant.v1.model.EntityMentionCollection;
import com.ibm.watson.assistant.v1.model.Example;
import com.ibm.watson.assistant.v1.model.ExampleCollection;
import com.ibm.watson.assistant.v1.model.GetCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.GetDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.GetExampleOptions;
import com.ibm.watson.assistant.v1.model.GetIntentOptions;
import com.ibm.watson.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.InputData;
import com.ibm.watson.assistant.v1.model.Intent;
import com.ibm.watson.assistant.v1.model.IntentCollection;
import com.ibm.watson.assistant.v1.model.IntentExport;
import com.ibm.watson.assistant.v1.model.ListCounterexamplesOptions;
import com.ibm.watson.assistant.v1.model.ListDialogNodesOptions;
import com.ibm.watson.assistant.v1.model.ListExamplesOptions;
import com.ibm.watson.assistant.v1.model.ListIntentsOptions;
import com.ibm.watson.assistant.v1.model.ListLogsOptions;
import com.ibm.watson.assistant.v1.model.ListMentionsOptions;
import com.ibm.watson.assistant.v1.model.ListWorkspacesOptions;
import com.ibm.watson.assistant.v1.model.LogCollection;
import com.ibm.watson.assistant.v1.model.LogExport;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.RuntimeIntent;
import com.ibm.watson.assistant.v1.model.UpdateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.UpdateExampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateIntentOptions;
import com.ibm.watson.assistant.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Workspace;
import com.ibm.watson.assistant.v1.model.WorkspaceCollection;
import com.ibm.watson.assistant.v1.model.WorkspaceExport;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettings;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsDisambiguation;
import com.ibm.watson.assistant.v1.model.WorkspaceSystemSettingsTooling;
import com.ibm.watson.common.RetryRunner;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration test for the {@link Assistant}.
 */
@RunWith(RetryRunner.class)
public class AssistantServiceIT extends AssistantServiceTest {

  private String exampleIntent;
  private Assistant service;
  private String workspaceId;

  private DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
    this.workspaceId = getWorkspaceId();
  }

  /**
   * Test README.
   */
  @Test
  public void testReadme() {
    InputData input = new InputData.Builder("Hi").build();
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
    MessageResponse response = service.message(options).execute().getResult();
    System.out.println(response);
  }

  /**
   * Test Example.
   */
  @Test
  public void testExample() throws InterruptedException {
    InputData input = new InputData.Builder("Hi").build();
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();

    // sync
    MessageResponse response = service.message(options).execute().getResult();
    System.out.println(response);

    // async
    service.message(options).enqueue(new ServiceCallback<MessageResponse>() {
      @Override
      public void onResponse(Response<MessageResponse> response) {
        System.out.println(response.getResult());
      }

      @Override
      public void onFailure(Exception e) {
      }
    });

    // reactive
    Single<Response<MessageResponse>> observableRequest
        = service.message(options).reactiveRequest();
    observableRequest
        .subscribeOn(Schedulers.single())
        .subscribe(new Consumer<Response<MessageResponse>>() {
          @Override
          public void accept(Response<MessageResponse> response) throws Exception {
            System.out.println(response.getResult());
          }
        });

    Thread.sleep(5000);
  }

  @Test(expected = UnauthorizedException.class)
  public void pingBadCredentialsThrowsException() {
    Assistant badService = new Assistant("2018-02-16", "foo", "bar");
    MessageOptions options = new MessageOptions.Builder(workspaceId).build();
    badService.message(options).execute().getResult();
  }

  /**
   * Test start a conversation without message.
   */
  @Test()
  public void testStartAConversationWithoutMessage() {
    MessageOptions options = new MessageOptions.Builder(workspaceId).build();
    service.message(options).execute().getResult();
  }

  /**
   * Test send messages.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSendMessages() throws InterruptedException {
    final String[] messages = new String[] { "turn ac on", "turn right", "no", "yes" };
    Context context = null;
    for (final String message : messages) {
      MessageOptions request = new MessageOptions.Builder(workspaceId)
          .input(new InputData.Builder(message).build())
          .alternateIntents(true)
          .context(context)
          .nodesVisitedDetails(true)
          .build();

      if (message.equals("yes")) {
        RuntimeIntent offTopic = new RuntimeIntent();
        offTopic.setIntent("off_topic");
        offTopic.setConfidence(1.0);
        request = request.newBuilder().addIntent(offTopic).build();
      }
      MessageResponse response = service.message(request).execute().getResult();

      assertMessageFromService(response);
      assertNotNull(response.getOutput().getNodesVisitedDetails());
      context = new Context();
      context.putAll(response.getContext());
      Thread.sleep(500);
    }
  }

  /**
   * Assert {@link MessageResponse} from service.
   *
   * @param message the message from the {@link Assistant}
   */
  private void assertMessageFromService(MessageResponse message) {
    assertNotNull(message);
    assertNotNull(message.getEntities());
    assertNotNull(message.getIntents());
  }

  /**
   * Test message with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMessageWithNull() {
    service.message(null).execute().getResult();
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
    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText)
        .build();
    Counterexample response = service.createCounterexample(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId,
          counterExampleText).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  /**
   * Test deleteCounterexample.
   */
  @Test
  public void testDeleteCounterexample() {

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText)
        .build();
    service.createCounterexample(createOptions).execute().getResult();

    DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText)
        .build();
    service.deleteCounterexample(deleteOptions).execute();

    try {
      GetCounterexampleOptions getOptions = new GetCounterexampleOptions.Builder(workspaceId, counterExampleText)
          .build();
      service.getCounterexample(getOptions).execute();
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

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText)
        .build();
    service.createCounterexample(createOptions).execute().getResult();

    try {
      GetCounterexampleOptions getOptions = new GetCounterexampleOptions.Builder(workspaceId, counterExampleText)
          .includeAudit(true)
          .build();
      Counterexample response = service.getCounterexample(getOptions).execute().getResult();
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
      DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId,
          counterExampleText).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  /**
   * Test listCounterexamples.
   */
  @Test
  public void testListCounterexamples() {

    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique

    try {
      ListCounterexamplesOptions listOptions = new ListCounterexamplesOptions.Builder(workspaceId).build();
      CounterexampleCollection ccResponse = service.listCounterexamples(listOptions).execute().getResult();
      assertNotNull(ccResponse);
      assertNotNull(ccResponse.getCounterexamples());
      assertNotNull(ccResponse.getPagination());
      assertNotNull(ccResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add a counterexample and make sure we get it back
      CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId,
          counterExampleText).build();
      service.createCounterexample(createOptions).execute().getResult();

      long count = ccResponse.getCounterexamples().size();
      CounterexampleCollection ccResponse2 = service.listCounterexamples(listOptions.newBuilder()
          .pageLimit(count + 1)
          .includeAudit(true)
          .build()).execute().getResult();
      assertNotNull(ccResponse2);
      assertNotNull(ccResponse2.getCounterexamples());

      List<Counterexample> counterexamples = ccResponse2.getCounterexamples();
      assertTrue(counterexamples.size() > count);

      Counterexample exResponse = null;
      for (Counterexample resp : counterexamples) {
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
      try {
        DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId,
            counterExampleText).build();
        service.deleteCounterexample(deleteOptions).execute();
      } catch (NotFoundException ex) {
        // Okay
      }
    }
  }

  /**
   * Test listCounterexamples with paging.
   */
  @Test
  public void testListCounterexamplesWithPaging() {

    String counterExampleText1 = "alpha" + UUID.randomUUID().toString(); // gotta be unique
    String counterExampleText2 = "zeta" + UUID.randomUUID().toString(); // gotta be unique

    // Add two counterexamples
    CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId,
        counterExampleText1).build();
    service.createCounterexample(createOptions).execute().getResult();
    service.createCounterexample(createOptions.newBuilder().text(counterExampleText2).build()).execute().getResult();

    try {
      ListCounterexamplesOptions listOptions = new ListCounterexamplesOptions.Builder(workspaceId).pageLimit(1L).sort(
          "text").build();
      CounterexampleCollection response = service.listCounterexamples(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false;
      boolean found2 = false;
      while (true) {
        assertNotNull(response.getCounterexamples());
        assertTrue(response.getCounterexamples().size() == 1);
        found1 |= response.getCounterexamples().get(0).getText().equals(counterExampleText1);
        found2 |= response.getCounterexamples().get(0).getText().equals(counterExampleText2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response = service.listCounterexamples(listOptions.newBuilder().cursor(cursor).build()).execute().getResult();
      }

      assertTrue(found1 && found2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId,
          counterExampleText1).build();
      service.deleteCounterexample(deleteOptions).execute();
      service.deleteCounterexample(deleteOptions.newBuilder().text(counterExampleText2).build()).execute();
    }
  }

  /**
   * Test updateCounterexample.
   */
  @Test
  public void testUpdateCounterexample() {
    String counterExampleText = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    String counterExampleText2 = "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions = new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText)
        .build();
    service.createCounterexample(createOptions).execute().getResult();

    try {
      UpdateCounterexampleOptions updateOptions = new UpdateCounterexampleOptions.Builder(workspaceId,
          counterExampleText).newText(counterExampleText2)
              .build();
      Counterexample response = service.updateCounterexample(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getText());
      assertEquals(response.getText(), counterExampleText2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions = new DeleteCounterexampleOptions.Builder(workspaceId,
          counterExampleText2).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  public void createExampleIntent() {
    exampleIntent = "Hello";
    try {
      CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, exampleIntent).description(
          "Example Intent").build();
      service.createIntent(createOptions).execute().getResult();
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

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
        .build();
    Example response = service.createExample(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getExampleText());
      assertEquals(response.getExampleText(), exampleText);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /**
   * Test deleteExample.
   */
  @Test
  public void testDeleteExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
        .build();
    service.createExample(createOptions).execute().getResult();

    DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
        .build();
    service.deleteExample(deleteOptions).execute();

    try {
      GetExampleOptions getOptions = new GetExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.getExample(getOptions).execute().getResult();
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

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
        .build();
    service.createExample(createOptions).execute().getResult();

    try {
      GetExampleOptions getOptions = new GetExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .includeAudit(true)
          .build();
      Example response = service.getExample(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getExampleText());
      assertEquals(response.getExampleText(), exampleText);
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
      DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /**
   * Test listExamples.
   */
  @Test
  public void testListExamples() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique

    try {
      ListExamplesOptions listOptions = new ListExamplesOptions.Builder(workspaceId, exampleIntent)
          .includeAudit(true)
          .build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());
      assertNotNull(ecResponse.getPagination());
      assertNotNull(ecResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add an example and make sure we get it back
      CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .build();
      service.createExample(createOptions).execute().getResult();

      long count = ecResponse.getExamples().size();
      ExampleCollection ecResponse2 = service.listExamples(listOptions.newBuilder()
          .pageLimit(count + 1)
          .includeAudit(true)
          .build())
          .execute().getResult();
      assertNotNull(ecResponse2);
      assertNotNull(ecResponse2.getExamples());

      List<Example> examples = ecResponse2.getExamples();
      assertTrue(examples.size() > count);

      Example exResponse = null;
      for (Example resp : examples) {
        if (resp.getExampleText().equals(exampleText)) {
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
      DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .build();
      service.deleteExample(deleteOptions).execute();
    }

  }

  /**
   * Test listExamples with paging.
   */
  @Test
  public void testListExamplesWithPaging() {

    createExampleIntent();

    String exampleText1 = "Alpha " + UUID.randomUUID().toString(); // gotta be unique
    String exampleText2 = "Zeta " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText1)
        .build();
    service.createExample(createOptions).execute().getResult();
    service.createExample(createOptions.newBuilder().text(exampleText2).build()).execute().getResult();

    try {
      ListExamplesOptions listOptions = new ListExamplesOptions.Builder(workspaceId, exampleIntent).pageLimit(1L).sort(
          "-text").build();
      ExampleCollection response = service.listExamples(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getExamples());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false;
      boolean found2 = false;
      while (true) {
        assertNotNull(response.getExamples());
        assertTrue(response.getExamples().size() == 1);
        found1 |= response.getExamples().get(0).getExampleText().equals(exampleText1);
        found2 |= response.getExamples().get(0).getExampleText().equals(exampleText2);
        assertTrue(found2 || !found1); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response = service.listExamples(listOptions.newBuilder().cursor(cursor).build()).execute().getResult();
      }
      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText1)
          .build();
      service.deleteExample(deleteOptions).execute();
      service.deleteExample(deleteOptions.newBuilder().text(exampleText2).build()).execute();
    }

  }

  /**
   * Test updateExample.
   */
  @Test
  public void testUpdateExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    String exampleText2 = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions = new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
        .build();
    service.createExample(createOptions).execute().getResult();

    try {
      UpdateExampleOptions updateOptions = new UpdateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
          .newText(exampleText2)
          .build();
      Example response = service.updateExample(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getExampleText());
      assertEquals(response.getExampleText(), exampleText2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions = new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText2)
          .build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /**
   * Test createIntent.
   */
  @Test
  public void testCreateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    Date start = new Date();

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, intentName)
        .description(intentDescription).examples(intentExamples).build();
    Intent response = service.createIntent(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getIntentName());
      assertEquals(response.getIntentName(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription);

      Date now = new Date();

      ListExamplesOptions listOptions = new ListExamplesOptions.Builder(workspaceId, intentName)
          .includeAudit(true)
          .build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<Example> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getExampleText(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /**
   * Test deleteIntent.
   */
  @Test
  public void testDeleteIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, intentName).build();
    service.createIntent(createOptions).execute().getResult();

    DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName).build();
    service.deleteIntent(deleteOptions).execute();

    try {
      GetIntentOptions getOptions = new GetIntentOptions.Builder(workspaceId, intentName).build();
      service.getIntent(getOptions).execute();
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

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    Date start = new Date();

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder().workspaceId(workspaceId).intent(intentName)
        .description(intentDescription).examples(intentExamples).build();
    service.createIntent(createOptions).execute().getResult();

    try {
      GetIntentOptions getOptions = new GetIntentOptions.Builder()
          .workspaceId(workspaceId)
          .intent(intentName)
          .export(true)
          .includeAudit(true)
          .build();
      IntentExport response = service.getIntent(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getIntentName());
      assertEquals(response.getIntentName(), intentName);
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

      List<Example> examples = response.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getExampleText(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /**
   * Test listIntents.
   */
  @Test
  public void testListIntents() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique

    try {
      ListIntentsOptions listOptions = new ListIntentsOptions.Builder(workspaceId)
          .includeAudit(true)
          .build();
      IntentCollection response = service.listIntents(listOptions).execute().getResult();
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

      CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, intentName)
          .description(intentDescription).examples(intentExamples).build();
      service.createIntent(createOptions).execute().getResult();

      long count = response.getIntents().size();
      ListIntentsOptions listOptions2 = new ListIntentsOptions.Builder(workspaceId)
          .export(true)
          .pageLimit(count + 1)
          .includeAudit(true)
          .build();
      IntentCollection response2 = service.listIntents(listOptions2).execute().getResult();
      assertNotNull(response2);
      assertNotNull(response2.getIntents());

      List<IntentExport> intents = response2.getIntents();
      assertTrue(intents.size() > count);

      IntentExport ieResponse = null;
      for (IntentExport resp : intents) {
        if (resp.getIntentName().equals(intentName)) {
          ieResponse = resp;
          break;
        }
      }

      assertNotNull(ieResponse);
      assertNotNull(ieResponse.getDescription());
      assertEquals(ieResponse.getDescription(), intentDescription);
      assertNotNull(ieResponse.getExamples());
      assertTrue(ieResponse.getExamples().size() == 1);
      assertEquals(ieResponse.getExamples().get(0).getExampleText(), intentExample);

      Date now = new Date();
      assertTrue(fuzzyBefore(ieResponse.getCreated(), now));
      assertTrue(fuzzyAfter(ieResponse.getCreated(), start));
      assertTrue(fuzzyBefore(ieResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(ieResponse.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /**
   * Test listIntents with paging.
   */
  @Test
  public void testListIntentsWithPaging() {

    String intentName1 = "First" + UUID.randomUUID().toString(); // gotta be unique
    String intentName2 = "Second" + UUID.randomUUID().toString(); // gotta be unique

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, intentName1).build();
    service.createIntent(createOptions).execute().getResult();
    service.createIntent(createOptions.newBuilder().intent(intentName2).build()).execute().getResult();

    try {
      ListIntentsOptions listOptions = new ListIntentsOptions.Builder()
          .workspaceId(workspaceId)
          .export(true)
          .pageLimit(1L)
          .sort("modified")
          .includeAudit(true)
          .build();
      IntentCollection response = service.listIntents(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getIntents());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false;
      boolean found2 = false;
      while (true) {
        assertNotNull(response.getIntents());
        assertTrue(response.getIntents().size() == 1);
        found1 |= response.getIntents().get(0).getIntentName().equals(intentName1);
        found2 |= response.getIntents().get(0).getIntentName().equals(intentName2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response = service.listIntents(listOptions.newBuilder().cursor(cursor).build()).execute().getResult();

      }
      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName1).build();
      service.deleteIntent(deleteOptions).execute();
      service.deleteIntent(deleteOptions.newBuilder().intent(intentName2).build()).execute();
    }
  }

  /**
   * Test updateIntent.
   */
  @Test
  public void testUpdateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());

    CreateIntentOptions createOptions = new CreateIntentOptions.Builder(workspaceId, intentName)
        .description(intentDescription).examples(intentExamples).build();
    service.createIntent(createOptions).execute().getResult();

    try {
      String intentDescription2 = "Updated description of " + intentName;
      String intentExample2 = "Updated Example of " + intentName;
      List<CreateExample> intentExamples2 = new ArrayList<CreateExample>();
      intentExamples2.add(new CreateExample.Builder().text(intentExample2).build());
      Date start = new Date();
      UpdateIntentOptions updateOptions = new UpdateIntentOptions.Builder(workspaceId, intentName)
          .newDescription(intentDescription2).newExamples(intentExamples2).build();
      Intent response = service.updateIntent(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getIntentName());
      assertEquals(response.getIntentName(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription2);

      Date now = new Date();

      ListExamplesOptions listOptions = new ListExamplesOptions.Builder(workspaceId, intentName)
          .includeAudit(true)
          .build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<Example> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).getExampleText(), intentExample2);
      assertTrue(fuzzyBefore(examples.get(0).getCreated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getCreated(), start));
      assertTrue(fuzzyBefore(examples.get(0).getUpdated(), now));
      assertTrue(fuzzyAfter(examples.get(0).getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions = new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /**
   * Test createWorkspace.
   */
  @Test
  public void testCreateWorkspace() {

    String workspaceName = "API Test " + UUID.randomUUID().toString(); // gotta be unique
    String workspaceDescription = "Description of " + workspaceName;
    String workspaceLanguage = "en";

    // metadata
    Map<String, Object> workspaceMetadata = new HashMap<String, Object>();
    String metadataValue = "value for " + workspaceName;
    workspaceMetadata.put("key", metadataValue);

    // intents
    List<CreateIntent> workspaceIntents = new ArrayList<CreateIntent>();
    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<CreateExample> intentExamples = new ArrayList<CreateExample>();
    intentExamples.add(new CreateExample.Builder().text(intentExample).build());
    workspaceIntents.add(
        new CreateIntent.Builder().intent(intentName).description(intentDescription).examples(intentExamples)
            .build());

    // entities
    List<CreateEntity> workspaceEntities = new ArrayList<CreateEntity>();
    String entityName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String entityDescription = "Description of " + entityName;
    String entityValue = "Value of " + entityName;
    String entityValueSynonym = "Synonym for Value of " + entityName;
    List<CreateValue> entityValues = new ArrayList<CreateValue>();
    entityValues.add(new CreateValue.Builder().value(entityValue).addSynonym(entityValueSynonym).build());
    workspaceEntities
        .add(new CreateEntity.Builder().entity(entityName).description(entityDescription).values(entityValues)
            .build());

    // counterexamples
    List<CreateCounterexample> workspaceCounterExamples = new ArrayList<CreateCounterexample>();
    String counterExampleText = "Counterexample for " + workspaceName;
    workspaceCounterExamples.add(new CreateCounterexample.Builder().text(counterExampleText).build());

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation = new WorkspaceSystemSettingsDisambiguation();
    disambiguation.setEnabled(true);
    disambiguation.setNoneOfTheAbovePrompt("none of the above");
    disambiguation.setPrompt("prompt");
    disambiguation.setSensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH);
    WorkspaceSystemSettingsTooling tooling = new WorkspaceSystemSettingsTooling();
    tooling.setStoreGenericResponses(true);
    WorkspaceSystemSettings systemSettings = new WorkspaceSystemSettings();
    systemSettings.setDisambiguation(disambiguation);
    systemSettings.setTooling(tooling);

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .language(workspaceLanguage)
        .metadata(workspaceMetadata)
        .intents(workspaceIntents)
        .entities(workspaceEntities)
        .counterexamples(workspaceCounterExamples)
        .systemSettings(systemSettings)
        .build();

    String workspaceId = null;
    try {
      Workspace response = service.createWorkspace(createOptions).execute().getResult();

      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      workspaceId = response.getWorkspaceId();
      assertNotNull(response.getName());
      assertEquals(response.getName(), workspaceName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), workspaceDescription);
      assertNotNull(response.getLanguage());
      assertEquals(response.getLanguage(), workspaceLanguage);

      // metadata
      assertNotNull(response.getMetadata());
      assertNotNull(response.getMetadata().get("key"));
      assertEquals(response.getMetadata().get("key"), metadataValue);

      GetWorkspaceOptions getOptions = new GetWorkspaceOptions.Builder(workspaceId).export(true).build();
      WorkspaceExport exResponse = service.getWorkspace(getOptions).execute().getResult();
      assertNotNull(exResponse);

      // intents
      assertNotNull(exResponse.getIntents());
      assertTrue(exResponse.getIntents().size() == 1);
      assertNotNull(exResponse.getIntents().get(0).getIntentName());
      assertEquals(exResponse.getIntents().get(0).getIntentName(), intentName);
      assertNotNull(exResponse.getIntents().get(0).getDescription());
      assertEquals(exResponse.getIntents().get(0).getDescription(), intentDescription);
      assertNotNull(exResponse.getIntents().get(0).getExamples());
      assertTrue(exResponse.getIntents().get(0).getExamples().size() == 1);
      assertNotNull(exResponse.getIntents().get(0).getExamples().get(0));
      assertNotNull(exResponse.getIntents().get(0).getExamples().get(0).getExampleText());
      assertEquals(exResponse.getIntents().get(0).getExamples().get(0).getExampleText(), intentExample);

      // entities
      assertNotNull(exResponse.getEntities());
      assertTrue(exResponse.getEntities().size() == 1);
      assertNotNull(exResponse.getEntities().get(0).getEntityName());
      assertEquals(exResponse.getEntities().get(0).getEntityName(), entityName);
      assertNotNull(exResponse.getEntities().get(0).getDescription());
      assertEquals(exResponse.getEntities().get(0).getDescription(), entityDescription);
      assertNotNull(exResponse.getEntities().get(0).getValues());
      assertTrue(exResponse.getEntities().get(0).getValues().size() == 1);
      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).getValueText());
      assertEquals(exResponse.getEntities().get(0).getValues().get(0).getValueText(), entityValue);
      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).getSynonyms());
      assertTrue(exResponse.getEntities().get(0).getValues().get(0).getSynonyms().size() == 1);
      assertEquals(exResponse.getEntities().get(0).getValues().get(0).getSynonyms().get(0), entityValueSynonym);

      // counterexamples
      assertNotNull(exResponse.getCounterexamples());
      assertTrue(exResponse.getCounterexamples().size() == 1);
      assertNotNull(exResponse.getCounterexamples().get(0).getText());
      assertEquals(exResponse.getCounterexamples().get(0).getText(), counterExampleText);

      // systemSettings
      assertNotNull(exResponse.getSystemSettings());
      assertEquals(exResponse.getSystemSettings().getDisambiguation().getNoneOfTheAbovePrompt(),
          disambiguation.getNoneOfTheAbovePrompt());
      assertEquals(exResponse.getSystemSettings().getDisambiguation().getSensitivity(),
          disambiguation.getSensitivity());
      assertEquals(exResponse.getSystemSettings().getDisambiguation().getPrompt(), disambiguation.getPrompt());
      assertEquals(exResponse.getSystemSettings().getDisambiguation().isEnabled(), disambiguation.isEnabled());
      assertEquals(exResponse.getSystemSettings().getTooling().isStoreGenericResponses(),
          tooling.isStoreGenericResponses());

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions = new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /**
   * Test deleteWorkspace.
   */
  @Test
  public void testDeleteWorkspace() {

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder().build();

    String workspaceId = null;
    try {
      Workspace response = service.createWorkspace(createOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      workspaceId = response.getWorkspaceId();

      DeleteWorkspaceOptions deleteOptions = new DeleteWorkspaceOptions.Builder(workspaceId).build();
      service.deleteWorkspace(deleteOptions).execute();

      GetWorkspaceOptions getOptions = new GetWorkspaceOptions.Builder(workspaceId).export(true).build();
      service.getWorkspace(getOptions).execute().getResult();
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
      workspaceId = null;
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions = new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /**
   * Test getWorkspace.
   */
  @Test
  public void testGetWorkspace() {

    GetWorkspaceOptions getOptions = new GetWorkspaceOptions.Builder(workspaceId)
        .export(false)
        .includeAudit(true)
        .build();
    WorkspaceExport response = service.getWorkspace(getOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      assertEquals(response.getWorkspaceId(), workspaceId);
      assertNotNull(response.getName());
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

    ListWorkspacesOptions listOptions = new ListWorkspacesOptions.Builder().build();
    WorkspaceCollection response = service.listWorkspaces(listOptions).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getWorkspaces());
    assertTrue(response.getWorkspaces().size() > 0);
    assertNotNull(response.getPagination());
    assertNotNull(response.getPagination().getRefreshUrl());

    Workspace wResponse = null;
    for (Workspace resp : response.getWorkspaces()) {
      if (resp.getWorkspaceId().equals(workspaceId)) {
        wResponse = resp;
        break;
      }
    }

    assertNotNull(wResponse);
    assertNotNull(wResponse.getName());
  }

  /**
   * Test listWorkspaces with paging.
   */
  @Test
  public void testListWorkspacesWithPaging() {

    ListWorkspacesOptions listOptions = new ListWorkspacesOptions.Builder().pageLimit(1L).sort("-updated").build();
    WorkspaceCollection response = service.listWorkspaces(listOptions).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getPagination());
    assertNotNull(response.getPagination().getRefreshUrl());

    boolean found = false;
    while (true) {
      assertNotNull(response.getWorkspaces());
      assertTrue(response.getWorkspaces().size() == 1);
      found |= response.getWorkspaces().get(0).getWorkspaceId().equals(workspaceId);
      if (response.getPagination().getNextCursor() == null) {
        break;
      }
      String cursor = response.getPagination().getNextCursor();
      response = service.listWorkspaces(listOptions.newBuilder().cursor(cursor).build()).execute().getResult();
    }

    assertTrue(found);
  }

  /**
   * Test updateWorkspace.
   */
  @Test
  public void testUpdateWorkspace() {

    String workspaceName = "testUpdateWorkspace";
    String workspaceDescription = "Description for testUpdateWorkspace";

    // intents
    CreateIntent intent0 = new CreateIntent.Builder("Hello").build();
    CreateIntent intent1 = new CreateIntent.Builder("Goodbye").build();

    // entities
    CreateEntity entity0 = new CreateEntity.Builder("animal").build();
    CreateEntity entity1 = new CreateEntity.Builder("beverage").build();

    // counterexamples
    CreateCounterexample counterexample0 = new CreateCounterexample.Builder("What are you wearing?").build();
    CreateCounterexample counterexample1 = new CreateCounterexample.Builder("What are you eating?").build();

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder()
        .name(workspaceName)
        .description(workspaceDescription)
        .addIntent(intent0)
        .addIntent(intent1)
        .addEntity(entity0)
        .addEntity(entity1)
        .addCounterexample(counterexample0)
        .addCounterexample(counterexample1)
        .build();

    String workspaceId = null;
    try {
      Workspace createResponse = service.createWorkspace(createOptions).execute().getResult();

      assertNotNull(createResponse);
      assertNotNull(createResponse.getWorkspaceId());
      workspaceId = createResponse.getWorkspaceId();

      String counterExampleText = "What are you drinking";
      CreateCounterexample counterexample2 = new CreateCounterexample.Builder(counterExampleText).build();

      UpdateWorkspaceOptions updateOptions = new UpdateWorkspaceOptions.Builder(workspaceId)
          .addCounterexample(counterexample2)
          .append(false)
          .build();
      Workspace updateResponse = service.updateWorkspace(updateOptions).execute().getResult();

      assertNotNull(updateResponse);

      GetCounterexampleOptions getOptions = new GetCounterexampleOptions.Builder(workspaceId, counterExampleText)
          .build();
      Counterexample eResponse = service.getCounterexample(getOptions).execute().getResult();
      assertNotNull(eResponse);
      assertNotNull(eResponse.getText());
      assertEquals(eResponse.getText(), counterExampleText);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions = new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /**
   * Test listLogs.
   */
  @Test
  public void testListLogs() {

    try {
      ListLogsOptions listOptions = new ListLogsOptions.Builder().workspaceId(workspaceId).build();
      LogCollection response = service.listLogs(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getLogs());
      assertNotNull(response.getPagination());
      // Empirically -- no refresh_url in pagination of listLogs
      // assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null
      if (response.getPagination().getNextUrl() == null) {
        assertNull(response.getPagination().getNextCursor());
      } else {
        assertNotNull(response.getPagination().getNextCursor());
      }
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /**
   * Test listLogs with pagination.
   */
  @Test
  @Ignore("To be run locally until we fix the Rate limitation issue")
  public void testListLogsWithPaging() {

    try {
      ListLogsOptions.Builder listOptionsBuilder = new ListLogsOptions.Builder(workspaceId);
      listOptionsBuilder.sort("-request_timestamp");
      listOptionsBuilder.filter("request.intents:intent:off_topic");
      listOptionsBuilder.pageLimit(1L);

      LogCollection response = service.listLogs(listOptionsBuilder.build()).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getLogs());
      assertNotNull(response.getPagination());
      // Empirically -- no refresh_url in pagination of listLogs
      // assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      assertTrue(response.getLogs().size() == 1);
      LogExport logEntry1 = response.getLogs().get(0);

      String cursor = response.getPagination().getNextCursor();
      response = service.listLogs(listOptionsBuilder.cursor(cursor).build()).execute().getResult();

      assertNotNull(response.getLogs());
      assertTrue(response.getLogs().size() == 1);

      LogExport logEntry2 = response.getLogs().get(0);

      Date requestDate1 = isoDateFormat.parse(logEntry1.getRequestTimestamp());
      Date requestDate2 = isoDateFormat.parse(logEntry2.getRequestTimestamp());

      assertTrue(requestDate2.before(requestDate1));

    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /**
   * Test createDialogNode.
   */
  @Test
  public void testCreateDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
        .description(dialogNodeDescription).build();
    DialogNode response = service.createDialogNode(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getDialogNodeId());
      assertEquals(response.getDialogNodeId(), dialogNodeName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), dialogNodeDescription);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /**
   * Test deleteDialogNode.
   */
  @Test
  public void testDeleteDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString(); // gotta be unique

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
    service.createDialogNode(createOptions).execute().getResult();

    DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
    service.deleteDialogNode(deleteOptions).execute();

    try {
      GetDialogNodeOptions getOptions = new GetDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.getDialogNode(getOptions).execute();
      fail("deleteDialogNode failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /**
   * Test getDialogNode.
   */
  @Test
  public void testGetDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    Date start = new Date();

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
        .description(dialogNodeDescription).build();
    service.createDialogNode(createOptions).execute().getResult();

    try {
      GetDialogNodeOptions getOptions = new GetDialogNodeOptions.Builder()
          .workspaceId(workspaceId)
          .dialogNode(dialogNodeName)
          .includeAudit(true)
          .build();
      DialogNode response = service.getDialogNode(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getDialogNodeId());
      assertEquals(response.getDialogNodeId(), dialogNodeName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), dialogNodeDescription);
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
      DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /**
   * Test listDialogNodes.
   */
  @Test
  public void testListDialogNodes() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();

    try {
      ListDialogNodesOptions listOptions = new ListDialogNodesOptions.Builder(workspaceId).build();
      DialogNodeCollection response = service.listDialogNodes(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getDialogNodes());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null

      // Now add a dialog node and make sure we get it back
      String dialogNodeDescription = "Description of " + dialogNodeName;

      Date start = new Date();

      CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
          .description(dialogNodeDescription)
          .build();
      service.createDialogNode(createOptions).execute().getResult();

      long count = response.getDialogNodes().size();
      ListDialogNodesOptions listOptions2 = new ListDialogNodesOptions.Builder(workspaceId)
          .pageLimit(count + 1)
          .includeAudit(true)
          .build();
      DialogNodeCollection response2 = service.listDialogNodes(listOptions2).execute().getResult();
      assertNotNull(response2);
      assertNotNull(response2.getDialogNodes());

      List<DialogNode> dialogNodes = response2.getDialogNodes();
      assertTrue(dialogNodes.size() > count);

      DialogNode dialogResponse = null;
      for (DialogNode node : dialogNodes) {
        if (node.getDialogNodeId().equals(dialogNodeName)) {
          dialogResponse = node;
          break;
        }
      }

      assertNotNull(dialogResponse);
      assertNotNull(dialogResponse.getDescription());
      assertEquals(dialogResponse.getDescription(), dialogNodeDescription);

      Date now = new Date();
      assertTrue(fuzzyBefore(dialogResponse.getCreated(), now));
      assertTrue(fuzzyAfter(dialogResponse.getCreated(), start));
      assertTrue(fuzzyBefore(dialogResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(dialogResponse.getUpdated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /**
   * Test listDialogNodes with pagination.
   */
  @Test
  public void testListDialogNodesWithPaging() {
    String dialogNodeName1 = "First" + UUID.randomUUID().toString();
    String dialogNodeName2 = "Second" + UUID.randomUUID().toString();

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName1).build();
    service.createDialogNode(createOptions).execute().getResult();
    service.createDialogNode(createOptions.newBuilder().dialogNode(dialogNodeName2).build()).execute().getResult();

    try {
      ListDialogNodesOptions listOptions = new ListDialogNodesOptions.Builder().workspaceId(workspaceId).pageLimit(1L)
          .sort("dialog_node").build();
      DialogNodeCollection response = service.listDialogNodes(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getDialogNodes());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      assertNotNull(response.getPagination().getNextUrl());
      assertNotNull(response.getPagination().getNextCursor());

      boolean found1 = false, found2 = false;
      while (true) {
        assertNotNull(response.getDialogNodes());
        assertTrue(response.getDialogNodes().size() == 1);
        found1 |= response.getDialogNodes().get(0).getDialogNodeId().equals(dialogNodeName1);
        found2 |= response.getDialogNodes().get(0).getDialogNodeId().equals(dialogNodeName2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response = service.listDialogNodes(listOptions.newBuilder().cursor(cursor).build()).execute().getResult();

      }
      assertTrue(found1 && found2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName1).build();
      service.deleteDialogNode(deleteOptions).execute();
      service.deleteDialogNode(deleteOptions.newBuilder().dialogNode(dialogNodeName2).build()).execute();
    }
  }

  /**
   * Test updateDialogNode.
   */
  @Test
  public void testUpdateDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    CreateDialogNodeOptions createOptions = new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
        .description(dialogNodeDescription).build();
    service.createDialogNode(createOptions).execute().getResult();

    String dialogNodeName2 = "Test2" + UUID.randomUUID().toString();

    try {
      String dialogNodeDescription2 = "Updated description of " + dialogNodeName;
      UpdateDialogNodeOptions updateOptions = new UpdateDialogNodeOptions.Builder()
          .workspaceId(workspaceId)
          .dialogNode(dialogNodeName)
          .newDialogNode(dialogNodeName2)
          .newDescription(dialogNodeDescription2)
          .build();
      DialogNode response = service.updateDialogNode(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getDialogNodeId());
      assertEquals(response.getDialogNodeId(), dialogNodeName2);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), dialogNodeDescription2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions = new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName2).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /**
   * Test deleteUserData.
   */
  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
          .customerId(customerId)
          .build();
      service.deleteUserData(deleteOptions).execute();
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  @Test
  public void testListMentions() {
    String entity = "amenity";

    ListMentionsOptions listMentionsOptions = new ListMentionsOptions.Builder()
        .workspaceId(workspaceId)
        .entity(entity)
        .build();
    EntityMentionCollection collection = service.listMentions(listMentionsOptions).execute().getResult();
    assertNotNull(collection);
    assertTrue(!collection.getExamples().isEmpty());
  }
}
