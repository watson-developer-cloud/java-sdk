/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCallback;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import com.ibm.watson.assistant.v1.model.*;
import com.ibm.watson.common.RetryRunner;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Integration test for the {@link Assistant}. */
@RunWith(RetryRunner.class)
public class AssistantServiceIT extends AssistantServiceTest {

  private String exampleIntent;
  private Assistant service;
  private String workspaceId;

  private DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
    this.workspaceId = getWorkspaceId();
  }

  /** Test README. */
  @Test
  public void testReadme() {
    MessageInput input = new MessageInput();
    input.setText("Hi");
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
    MessageResponse response = service.message(options).execute().getResult();

    assertNotNull(response);
  }

  /** Test RuntimeResponseGenericRuntimeResponseTypeText. */
  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeText() {
    MessageInput input = new MessageInput();
    input.setText("Hi");
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
    MessageResponse response = service.message(options).execute().getResult();
    // System.out.println(response);

    RuntimeResponseGeneric runtimeResponseGenericRuntimeResponseTypeText =
        response.getOutput().getGeneric().get(0);

    assertNotNull(runtimeResponseGenericRuntimeResponseTypeText);
  }

  /** Test RuntimeResponseGenericRuntimeResponseTypeChannelTransfer. */
  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeChannelTransfer() {
    MessageInput input = new MessageInput();
    input.setText("test sdk");
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
    MessageResponse response = service.message(options).execute().getResult();
    // System.out.println(response);

    RuntimeResponseGenericRuntimeResponseTypeChannelTransfer
        runtimeResponseGenericRuntimeResponseTypeChannelTransfer =
            (RuntimeResponseGenericRuntimeResponseTypeChannelTransfer)
                response.getOutput().getGeneric().get(0);
    ChannelTransferInfo channelTransferInfo =
        runtimeResponseGenericRuntimeResponseTypeChannelTransfer.transferInfo();

    assertNotNull(channelTransferInfo);
  }

  /**
   * Test Example.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testExample() throws InterruptedException {
    MessageInput input = new MessageInput();
    input.setText("Hi");
    MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();

    // sync
    MessageResponse response = service.message(options).execute().getResult();
    // System.out.println(response);

    // async
    service
        .message(options)
        .enqueue(
            new ServiceCallback<MessageResponse>() {
              @Override
              public void onResponse(Response<MessageResponse> response) {
                 /*System.out.println(response.getResult()); */
              }

              @Override
              public void onFailure(Exception e) {}
            });

    // reactive
    Single<Response<MessageResponse>> observableRequest =
        service.message(options).reactiveRequest();
    observableRequest
        .subscribeOn(Schedulers.single())
        .subscribe(
            new Consumer<Response<MessageResponse>>() {
              @Override
              public void accept(Response<MessageResponse> response) throws Exception {
                // System.out.println(response.getResult());
              }
            });

    Thread.sleep(5000);
  }

  /** Ping bad credentials throws exception. */
  @Test(expected = UnauthorizedException.class)
  public void pingBadCredentialsThrowsException() {
    Assistant badService = new Assistant("2019-02-28", new BasicAuthenticator("foo", "bar"));
    MessageOptions options = new MessageOptions.Builder(workspaceId).build();
    badService.message(options).execute().getResult();
  }

  /** Test start a conversation without message. */
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
    final String[] messages = new String[] {"turn ac on", "turn right", "no", "yes"};
    Context context = null;
    MessageInput input = new MessageInput();
    for (final String message : messages) {
      input.setText(message);
      MessageOptions request =
          new MessageOptions.Builder(workspaceId)
              .input(input)
              .alternateIntents(true)
              .context(context)
              .nodesVisitedDetails(true)
              .build();

      if (message.equals("yes")) {
        RuntimeIntent offTopic =
            new RuntimeIntent.Builder().intent("off_topic").confidence(1.0).build();
        request = request.newBuilder().addIntent(offTopic).build();
      }
      MessageResponse response = service.message(request).execute().getResult();

      assertMessageFromService(response);
      assertNotNull(response.getOutput().getNodesVisitedDetails());
      context = new Context();
      for (String propName : response.getContext().getPropertyNames()) {
        context.put(propName, response.getContext().get(propName));
      }
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

  /** Test message with null. */
  @Test(expected = IllegalArgumentException.class)
  public void testMessageWithNull() {
    service.message(null).execute().getResult();
  }

  /** Test to string. */
  @Test
  public void testToString() {
    assertNotNull(service.toString());
  }

  /** Test createCounterexample. */
  @Test
  public void testCreateCounterexample() {
    String counterExampleText =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions =
        new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
    Counterexample response = service.createCounterexample(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), counterExampleText);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions =
          new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  /** Test deleteCounterexample. */
  @Test
  public void testDeleteCounterexample() {

    String counterExampleText =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions =
        new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
    service.createCounterexample(createOptions).execute().getResult();

    DeleteCounterexampleOptions deleteOptions =
        new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
    service.deleteCounterexample(deleteOptions).execute();

    try {
      GetCounterexampleOptions getOptions =
          new GetCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
      service.getCounterexample(getOptions).execute();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /** Test getCounterexample. */
  @Test
  public void testGetCounterexample() {

    Date start = new Date();

    String counterExampleText =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions =
        new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
    service.createCounterexample(createOptions).execute().getResult();

    try {
      GetCounterexampleOptions getOptions =
          new GetCounterexampleOptions.Builder(workspaceId, counterExampleText)
              .includeAudit(true)
              .build();
      Counterexample response = service.getCounterexample(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), counterExampleText);
      assertNotNull(response.created());
      assertNotNull(response.updated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.created(), now));
      assertTrue(fuzzyAfter(response.created(), start));
      assertTrue(fuzzyBefore(response.updated(), now));
      assertTrue(fuzzyAfter(response.updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions =
          new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  /** Test listCounterexamples. */
  @Test
  public void testListCounterexamples() {

    String counterExampleText =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique

    try {
      ListCounterexamplesOptions listOptions =
          new ListCounterexamplesOptions.Builder(workspaceId).build();
      CounterexampleCollection ccResponse =
          service.listCounterexamples(listOptions).execute().getResult();
      assertNotNull(ccResponse);
      assertNotNull(ccResponse.getCounterexamples());
      assertNotNull(ccResponse.getPagination());
      assertNotNull(ccResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add a counterexample and make sure we get it back
      CreateCounterexampleOptions createOptions =
          new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
      service.createCounterexample(createOptions).execute().getResult();

      long count = ccResponse.getCounterexamples().size();
      CounterexampleCollection ccResponse2 =
          service
              .listCounterexamples(
                  listOptions.newBuilder().pageLimit(count + 1).includeAudit(true).build())
              .execute()
              .getResult();
      assertNotNull(ccResponse2);
      assertNotNull(ccResponse2.getCounterexamples());

      List<Counterexample> counterexamples = ccResponse2.getCounterexamples();
      assertTrue(counterexamples.size() > count);

      Counterexample exResponse = null;
      for (Counterexample resp : counterexamples) {
        if (resp.text().equals(counterExampleText)) {
          exResponse = resp;
          break;
        }
      }

      assertNotNull(exResponse);
      Date now = new Date();
      assertTrue(fuzzyBefore(exResponse.created(), now));
      assertTrue(fuzzyAfter(exResponse.created(), start));
      assertTrue(fuzzyBefore(exResponse.updated(), now));
      assertTrue(fuzzyAfter(exResponse.updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      try {
        DeleteCounterexampleOptions deleteOptions =
            new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
        service.deleteCounterexample(deleteOptions).execute();
      } catch (NotFoundException ex) {
        // Okay
      }
    }
  }

  /** Test listCounterexamples with paging. */
  @Test
  public void testListCounterexamplesWithPaging() {

    String counterExampleText1 = "alpha" + UUID.randomUUID().toString(); // gotta be unique
    String counterExampleText2 = "zeta" + UUID.randomUUID().toString(); // gotta be unique

    // Add two counterexamples
    CreateCounterexampleOptions createOptions =
        new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText1).build();
    service.createCounterexample(createOptions).execute().getResult();
    service
        .createCounterexample(createOptions.newBuilder().text(counterExampleText2).build())
        .execute()
        .getResult();

    try {
      ListCounterexamplesOptions listOptions =
          new ListCounterexamplesOptions.Builder(workspaceId).pageLimit(1L).sort("text").build();
      CounterexampleCollection response =
          service.listCounterexamples(listOptions).execute().getResult();
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
        found1 |= response.getCounterexamples().get(0).text().equals(counterExampleText1);
        found2 |= response.getCounterexamples().get(0).text().equals(counterExampleText2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response =
            service
                .listCounterexamples(listOptions.newBuilder().cursor(cursor).build())
                .execute()
                .getResult();
      }

      assertTrue(found1 && found2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions =
          new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText1).build();
      service.deleteCounterexample(deleteOptions).execute();
      service
          .deleteCounterexample(deleteOptions.newBuilder().text(counterExampleText2).build())
          .execute();
    }
  }

  /** Test updateCounterexample. */
  @Test
  public void testUpdateCounterexample() {
    String counterExampleText =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    String counterExampleText2 =
        "Make me a " + UUID.randomUUID().toString() + " sandwich"; // gotta be unique
    CreateCounterexampleOptions createOptions =
        new CreateCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
    service.createCounterexample(createOptions).execute().getResult();

    try {
      UpdateCounterexampleOptions updateOptions =
          new UpdateCounterexampleOptions.Builder(workspaceId, counterExampleText)
              .newText(counterExampleText2)
              .build();
      Counterexample response = service.updateCounterexample(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), counterExampleText2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteCounterexampleOptions deleteOptions =
          new DeleteCounterexampleOptions.Builder(workspaceId, counterExampleText2).build();
      service.deleteCounterexample(deleteOptions).execute();
    }
  }

  /** Creates the example intent. */
  public void createExampleIntent() {
    exampleIntent = "Hello";
    try {
      CreateIntentOptions createOptions =
          new CreateIntentOptions.Builder(workspaceId, exampleIntent)
              .description("Example Intent")
              .build();
      service.createIntent(createOptions).execute().getResult();
    } catch (Exception ex) {
      // Exception is okay if is for Unique Violation
      assertTrue(ex.getLocalizedMessage().startsWith("Unique Violation"));
    }
  }

  /** Test createExample. */
  @Test
  public void testCreateExample() {
    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions =
        new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
    Example response = service.createExample(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), exampleText);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions =
          new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /** Test deleteExample. */
  @Test
  public void testDeleteExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions =
        new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
    service.createExample(createOptions).execute().getResult();

    DeleteExampleOptions deleteOptions =
        new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
    service.deleteExample(deleteOptions).execute();

    try {
      GetExampleOptions getOptions =
          new GetExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.getExample(getOptions).execute().getResult();
      fail("deleteCounterexample failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /** Test getExample. */
  @Test
  public void testGetExample() {

    createExampleIntent();

    Date start = new Date();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions =
        new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
    service.createExample(createOptions).execute().getResult();

    try {
      GetExampleOptions getOptions =
          new GetExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
              .includeAudit(true)
              .build();
      Example response = service.getExample(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), exampleText);
      assertNotNull(response.created());
      assertNotNull(response.updated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.created(), now));
      assertTrue(fuzzyAfter(response.created(), start));
      assertTrue(fuzzyBefore(response.updated(), now));
      assertTrue(fuzzyAfter(response.updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions =
          new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /** Test listExamples. */
  @Test
  public void testListExamples() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique

    try {
      ListExamplesOptions listOptions =
          new ListExamplesOptions.Builder(workspaceId, exampleIntent).includeAudit(true).build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());
      assertNotNull(ecResponse.getPagination());
      assertNotNull(ecResponse.getPagination().getRefreshUrl());
      // nextUrl may be null

      Date start = new Date();

      // Now add an example and make sure we get it back
      CreateExampleOptions createOptions =
          new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.createExample(createOptions).execute().getResult();

      long count = ecResponse.getExamples().size();
      ExampleCollection ecResponse2 =
          service
              .listExamples(
                  listOptions.newBuilder().pageLimit(count + 1).includeAudit(true).build())
              .execute()
              .getResult();
      assertNotNull(ecResponse2);
      assertNotNull(ecResponse2.getExamples());

      List<Example> examples = ecResponse2.getExamples();
      assertTrue(examples.size() > count);

      Example exResponse = null;
      for (Example resp : examples) {
        if (resp.text().equals(exampleText)) {
          exResponse = resp;
          break;
        }
      }

      assertNotNull(exResponse);
      Date now = new Date();
      assertTrue(fuzzyBefore(exResponse.created(), now));
      assertTrue(fuzzyAfter(exResponse.created(), start));
      assertTrue(fuzzyBefore(exResponse.updated(), now));
      assertTrue(fuzzyAfter(exResponse.updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions =
          new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /** Test listExamples with paging. */
  @Test
  public void testListExamplesWithPaging() {

    createExampleIntent();

    String exampleText1 = "Alpha " + UUID.randomUUID().toString(); // gotta be unique
    String exampleText2 = "Zeta " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions =
        new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText1).build();
    service.createExample(createOptions).execute().getResult();
    service
        .createExample(createOptions.newBuilder().text(exampleText2).build())
        .execute()
        .getResult();

    try {
      ListExamplesOptions listOptions =
          new ListExamplesOptions.Builder(workspaceId, exampleIntent)
              .pageLimit(1L)
              .sort("-text")
              .build();
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
        found1 |= response.getExamples().get(0).text().equals(exampleText1);
        found2 |= response.getExamples().get(0).text().equals(exampleText2);
        assertTrue(found2 || !found1); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response =
            service
                .listExamples(listOptions.newBuilder().cursor(cursor).build())
                .execute()
                .getResult();
      }
      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions =
          new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText1).build();
      service.deleteExample(deleteOptions).execute();
      service.deleteExample(deleteOptions.newBuilder().text(exampleText2).build()).execute();
    }
  }

  /** Test updateExample. */
  @Test
  public void testUpdateExample() {

    createExampleIntent();

    String exampleText = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    String exampleText2 = "Howdy " + UUID.randomUUID().toString(); // gotta be unique
    CreateExampleOptions createOptions =
        new CreateExampleOptions.Builder(workspaceId, exampleIntent, exampleText).build();
    service.createExample(createOptions).execute().getResult();

    try {
      UpdateExampleOptions updateOptions =
          new UpdateExampleOptions.Builder(workspaceId, exampleIntent, exampleText)
              .newText(exampleText2)
              .build();
      Example response = service.updateExample(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.text());
      assertEquals(response.text(), exampleText2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteExampleOptions deleteOptions =
          new DeleteExampleOptions.Builder(workspaceId, exampleIntent, exampleText2).build();
      service.deleteExample(deleteOptions).execute();
    }
  }

  /** Test createIntent. */
  @Test
  public void testCreateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<Example> intentExamples = new ArrayList<>();
    intentExamples.add(new Example.Builder().text(intentExample).build());

    Date start = new Date();

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder(workspaceId, intentName)
            .description(intentDescription)
            .examples(intentExamples)
            .build();
    Intent response = service.createIntent(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.getIntent());
      assertEquals(response.getIntent(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription);

      Date now = new Date();

      ListExamplesOptions listOptions =
          new ListExamplesOptions.Builder(workspaceId, intentName).includeAudit(true).build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<Example> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).text(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).created(), now));
      assertTrue(fuzzyAfter(examples.get(0).created(), start));
      assertTrue(fuzzyBefore(examples.get(0).updated(), now));
      assertTrue(fuzzyAfter(examples.get(0).updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions =
          new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /** Test deleteIntent. */
  @Test
  public void testDeleteIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder(workspaceId, intentName).build();
    service.createIntent(createOptions).execute().getResult();

    DeleteIntentOptions deleteOptions =
        new DeleteIntentOptions.Builder(workspaceId, intentName).build();
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

  /** Test getIntent. */
  @Test
  public void testGetIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<Example> intentExamples = new ArrayList<>();
    intentExamples.add(new Example.Builder().text(intentExample).build());

    Date start = new Date();

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder()
            .workspaceId(workspaceId)
            .intent(intentName)
            .description(intentDescription)
            .examples(intentExamples)
            .build();
    service.createIntent(createOptions).execute().getResult();

    try {
      GetIntentOptions getOptions =
          new GetIntentOptions.Builder()
              .workspaceId(workspaceId)
              .intent(intentName)
              .export(true)
              .includeAudit(true)
              .build();
      Intent response = service.getIntent(getOptions).execute().getResult();
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

      List<Example> examples = response.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).text(), intentExample);
      assertTrue(fuzzyBefore(examples.get(0).created(), now));
      assertTrue(fuzzyAfter(examples.get(0).created(), start));
      assertTrue(fuzzyBefore(examples.get(0).updated(), now));
      assertTrue(fuzzyAfter(examples.get(0).updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions =
          new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /** Test listIntents. */
  @Test
  public void testListIntents() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique

    try {
      ListIntentsOptions listOptions =
          new ListIntentsOptions.Builder(workspaceId).includeAudit(true).build();
      IntentCollection response = service.listIntents(listOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getIntents());
      assertNotNull(response.getPagination());
      assertNotNull(response.getPagination().getRefreshUrl());
      // nextUrl may be null

      // Now add an intent and make sure we get it back
      String intentDescription = "Description of " + intentName;
      String intentExample = "Example of " + intentName;
      List<Example> intentExamples = new ArrayList<>();
      intentExamples.add(new Example.Builder().text(intentExample).build());

      Date start = new Date();

      CreateIntentOptions createOptions =
          new CreateIntentOptions.Builder(workspaceId, intentName)
              .description(intentDescription)
              .examples(intentExamples)
              .build();
      service.createIntent(createOptions).execute().getResult();

      long count = response.getIntents().size();
      ListIntentsOptions listOptions2 =
          new ListIntentsOptions.Builder(workspaceId)
              .export(true)
              .pageLimit(count + 1)
              .includeAudit(true)
              .build();
      IntentCollection response2 = service.listIntents(listOptions2).execute().getResult();
      assertNotNull(response2);
      assertNotNull(response2.getIntents());

      List<Intent> intents = response2.getIntents();
      assertTrue(intents.size() > count);

      Intent ieResponse = null;
      for (Intent resp : intents) {
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
      assertEquals(ieResponse.getExamples().get(0).text(), intentExample);

      Date now = new Date();
      assertTrue(fuzzyBefore(ieResponse.getCreated(), now));
      assertTrue(fuzzyAfter(ieResponse.getCreated(), start));
      assertTrue(fuzzyBefore(ieResponse.getUpdated(), now));
      assertTrue(fuzzyAfter(ieResponse.getUpdated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions =
          new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /** Test listIntents with paging. */
  @Test
  public void testListIntentsWithPaging() {

    String intentName1 = "First" + UUID.randomUUID().toString(); // gotta be unique
    String intentName2 = "Second" + UUID.randomUUID().toString(); // gotta be unique

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder(workspaceId, intentName1).build();
    service.createIntent(createOptions).execute().getResult();
    service
        .createIntent(createOptions.newBuilder().intent(intentName2).build())
        .execute()
        .getResult();

    try {
      ListIntentsOptions listOptions =
          new ListIntentsOptions.Builder()
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
        found1 |= response.getIntents().get(0).getIntent().equals(intentName1);
        found2 |= response.getIntents().get(0).getIntent().equals(intentName2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response =
            service
                .listIntents(listOptions.newBuilder().cursor(cursor).build())
                .execute()
                .getResult();
      }
      assertTrue(found1 && found2);

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions =
          new DeleteIntentOptions.Builder(workspaceId, intentName1).build();
      service.deleteIntent(deleteOptions).execute();
      service.deleteIntent(deleteOptions.newBuilder().intent(intentName2).build()).execute();
    }
  }

  /** Test updateIntent. */
  @Test
  public void testUpdateIntent() {

    String intentName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String intentDescription = "Description of " + intentName;
    String intentExample = "Example of " + intentName;
    List<Example> intentExamples = new ArrayList<>();
    intentExamples.add(new Example.Builder().text(intentExample).build());

    CreateIntentOptions createOptions =
        new CreateIntentOptions.Builder(workspaceId, intentName)
            .description(intentDescription)
            .examples(intentExamples)
            .build();
    service.createIntent(createOptions).execute().getResult();

    try {
      String intentDescription2 = "Updated description of " + intentName;
      String intentExample2 = "Updated Example of " + intentName;
      List<Example> intentExamples2 = new ArrayList<>();
      intentExamples2.add(new Example.Builder().text(intentExample2).build());
      Date start = new Date();
      UpdateIntentOptions updateOptions =
          new UpdateIntentOptions.Builder(workspaceId, intentName)
              .newDescription(intentDescription2)
              .newExamples(intentExamples2)
              .build();
      Intent response = service.updateIntent(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getIntent());
      assertEquals(response.getIntent(), intentName);
      assertNotNull(response.getDescription());
      assertEquals(response.getDescription(), intentDescription2);

      Date now = new Date();

      ListExamplesOptions listOptions =
          new ListExamplesOptions.Builder(workspaceId, intentName).includeAudit(true).build();
      ExampleCollection ecResponse = service.listExamples(listOptions).execute().getResult();
      assertNotNull(ecResponse);
      assertNotNull(ecResponse.getExamples());

      List<Example> examples = ecResponse.getExamples();
      assertTrue(examples.size() == 1);
      assertEquals(examples.get(0).text(), intentExample2);
      assertTrue(fuzzyBefore(examples.get(0).created(), now));
      assertTrue(fuzzyAfter(examples.get(0).created(), start));
      assertTrue(fuzzyBefore(examples.get(0).updated(), now));
      assertTrue(fuzzyAfter(examples.get(0).updated(), start));

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteIntentOptions deleteOptions =
          new DeleteIntentOptions.Builder(workspaceId, intentName).build();
      service.deleteIntent(deleteOptions).execute();
    }
  }

  /** Test createWorkspace. */
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
    List<Example> intentExamples = new ArrayList<>();
    intentExamples.add(new Example.Builder().text(intentExample).build());
    workspaceIntents.add(
        new CreateIntent.Builder()
            .intent(intentName)
            .description(intentDescription)
            .examples(intentExamples)
            .build());

    // entities
    List<CreateEntity> workspaceEntities = new ArrayList<CreateEntity>();
    String entityName = "Hello" + UUID.randomUUID().toString(); // gotta be unique
    String entityDescription = "Description of " + entityName;
    String entityValue = "Value of " + entityName;
    String entityValueSynonym = "Synonym for Value of " + entityName;
    List<CreateValue> entityValues = new ArrayList<CreateValue>();
    entityValues.add(
        new CreateValue.Builder().value(entityValue).addSynonym(entityValueSynonym).build());
    workspaceEntities.add(
        new CreateEntity.Builder()
            .entity(entityName)
            .description(entityDescription)
            .values(entityValues)
            .build());

    // counterexamples
    List<Counterexample> workspaceCounterExamples = new ArrayList<>();
    String counterExampleText = "Counterexample for " + workspaceName;
    workspaceCounterExamples.add(new Counterexample.Builder().text(counterExampleText).build());

    // systemSettings
    WorkspaceSystemSettingsDisambiguation disambiguation =
        new WorkspaceSystemSettingsDisambiguation.Builder()
            .enabled(true)
            .noneOfTheAbovePrompt("none of the above")
            .prompt("prompt")
            .sensitivity(WorkspaceSystemSettingsDisambiguation.Sensitivity.HIGH)
            .build();
    WorkspaceSystemSettingsTooling tooling =
        new WorkspaceSystemSettingsTooling.Builder().storeGenericResponses(true).build();
    WorkspaceSystemSettings systemSettings =
        new WorkspaceSystemSettings.Builder()
            .disambiguation(disambiguation)
            .tooling(tooling)
            .build();

    // webhooks
    String webhookHeaderName = "Webhook-Header";
    String webhookHeaderValue = "webhook_header_value";
    String webhookName = "java-sdk-test-webhook";
    String webhookUrl = "https://github.com/watson-developer-cloud/java-sdk";
    WebhookHeader webhookHeader =
        new WebhookHeader.Builder().name(webhookHeaderName).value(webhookHeaderValue).build();
    Webhook webhook =
        new Webhook.Builder().name(webhookName).url(webhookUrl).addHeaders(webhookHeader).build();

    CreateWorkspaceOptions createOptions =
        new CreateWorkspaceOptions.Builder()
            .name(workspaceName)
            .description(workspaceDescription)
            .language(workspaceLanguage)
            .metadata(workspaceMetadata)
            .intents(workspaceIntents)
            .entities(workspaceEntities)
            .counterexamples(workspaceCounterExamples)
            .systemSettings(systemSettings)
            .addWebhooks(webhook)
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

      GetWorkspaceOptions getOptions =
          new GetWorkspaceOptions.Builder(workspaceId).export(true).build();
      Workspace exResponse = service.getWorkspace(getOptions).execute().getResult();
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
      assertNotNull(exResponse.getIntents().get(0).getExamples().get(0).text());
      assertEquals(exResponse.getIntents().get(0).getExamples().get(0).text(), intentExample);

      // entities
      assertNotNull(exResponse.getEntities());
      assertTrue(exResponse.getEntities().size() == 1);
      assertNotNull(exResponse.getEntities().get(0).getEntity());
      assertEquals(exResponse.getEntities().get(0).getEntity(), entityName);
      assertNotNull(exResponse.getEntities().get(0).getDescription());
      assertEquals(exResponse.getEntities().get(0).getDescription(), entityDescription);
      assertNotNull(exResponse.getEntities().get(0).getValues());
      assertTrue(exResponse.getEntities().get(0).getValues().size() == 1);
      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).value());
      assertEquals(exResponse.getEntities().get(0).getValues().get(0).value(), entityValue);
      assertNotNull(exResponse.getEntities().get(0).getValues().get(0).synonyms());
      assertTrue(exResponse.getEntities().get(0).getValues().get(0).synonyms().size() == 1);
      assertEquals(
          exResponse.getEntities().get(0).getValues().get(0).synonyms().get(0), entityValueSynonym);

      // counterexamples
      assertNotNull(exResponse.getCounterexamples());
      assertTrue(exResponse.getCounterexamples().size() == 1);
      assertNotNull(exResponse.getCounterexamples().get(0).text());
      assertEquals(exResponse.getCounterexamples().get(0).text(), counterExampleText);

      // systemSettings
      assertNotNull(exResponse.getSystemSettings());
      assertEquals(
          exResponse.getSystemSettings().disambiguation().noneOfTheAbovePrompt(),
          disambiguation.noneOfTheAbovePrompt());
      assertEquals(
          exResponse.getSystemSettings().disambiguation().sensitivity(),
          disambiguation.sensitivity());
      assertEquals(
          exResponse.getSystemSettings().disambiguation().prompt(), disambiguation.prompt());
      assertEquals(
          exResponse.getSystemSettings().disambiguation().enabled(), disambiguation.enabled());
      assertEquals(
          exResponse.getSystemSettings().tooling().storeGenericResponses(),
          tooling.storeGenericResponses());

      // webhooks
      assertNotNull(exResponse.getWebhooks());
      assertEquals(webhookName, exResponse.getWebhooks().get(0).name());
      assertEquals(webhookUrl, exResponse.getWebhooks().get(0).url());
      assertEquals(webhookHeaderName, exResponse.getWebhooks().get(0).headers().get(0).name());
      assertEquals(webhookHeaderValue, exResponse.getWebhooks().get(0).headers().get(0).value());

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions =
            new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /** Test deleteWorkspace. */
  @Test
  public void testDeleteWorkspace() {

    CreateWorkspaceOptions createOptions = new CreateWorkspaceOptions.Builder().build();

    String workspaceId = null;
    try {
      Workspace response = service.createWorkspace(createOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.getWorkspaceId());
      workspaceId = response.getWorkspaceId();

      DeleteWorkspaceOptions deleteOptions =
          new DeleteWorkspaceOptions.Builder(workspaceId).build();
      service.deleteWorkspace(deleteOptions).execute();

      GetWorkspaceOptions getOptions =
          new GetWorkspaceOptions.Builder(workspaceId).export(true).build();
      service.getWorkspace(getOptions).execute().getResult();
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
      workspaceId = null;
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions =
            new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /** Test getWorkspace. */
  @Test
  public void testGetWorkspace() {

    GetWorkspaceOptions getOptions =
        new GetWorkspaceOptions.Builder(workspaceId).export(false).includeAudit(true).build();
    Workspace response = service.getWorkspace(getOptions).execute().getResult();

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

  /** Test listWorkspaces. */
  @Test
  public void testListWorkspaces() {

    ListWorkspacesOptions listOptions = new ListWorkspacesOptions.Builder().build();
    WorkspaceCollection response = service.listWorkspaces(listOptions).execute().getResult();
    /** System.out.println(response);
    DeleteWorkspaceOptions deleteOptions = new DeleteWorkspaceOptions.Builder("5b586426-c587-4775-950c-59b58db84b14").build();
    service.deleteWorkspace(deleteOptions).execute();
    DeleteWorkspaceOptions deleteOptions1 = new DeleteWorkspaceOptions.Builder("661d9f74-9d3a-4655-bee4-84e16bd25d00").build();
    service.deleteWorkspace(deleteOptions1).execute(); **/

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

  /** Test listWorkspaces with paging. */
  @Test
  public void testListWorkspacesWithPaging() {

    ListWorkspacesOptions listOptions =
        new ListWorkspacesOptions.Builder().pageLimit(1L).sort("-updated").build();
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
      response =
          service
              .listWorkspaces(listOptions.newBuilder().cursor(cursor).build())
              .execute()
              .getResult();
    }

    assertTrue(found);
  }

  /** Test updateWorkspace. */
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
    Counterexample counterexample0 = new Counterexample.Builder("What are you wearing?").build();
    Counterexample counterexample1 = new Counterexample.Builder("What are you eating?").build();

    CreateWorkspaceOptions createOptions =
        new CreateWorkspaceOptions.Builder()
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
      Counterexample counterexample2 = new Counterexample.Builder(counterExampleText).build();

      // webhooks
      String webhookHeaderName = "Webhook-Header";
      String webhookHeaderValue = "webhook_header_value";
      String webhookName = "java-sdk-test-webhook";
      String webhookUrl = "https://github.com/watson-developer-cloud/java-sdk";
      WebhookHeader webhookHeader =
          new WebhookHeader.Builder().name(webhookHeaderName).value(webhookHeaderValue).build();
      Webhook webhook =
          new Webhook.Builder().name(webhookName).url(webhookUrl).addHeaders(webhookHeader).build();

      UpdateWorkspaceOptions updateOptions =
          new UpdateWorkspaceOptions.Builder(workspaceId)
              .addCounterexample(counterexample2)
              .append(false)
              .addWebhooks(webhook)
              .build();
      Workspace updateResponse = service.updateWorkspace(updateOptions).execute().getResult();

      assertNotNull(updateResponse);

      GetCounterexampleOptions getOptions =
          new GetCounterexampleOptions.Builder(workspaceId, counterExampleText).build();
      Counterexample eResponse = service.getCounterexample(getOptions).execute().getResult();
      assertNotNull(eResponse);
      assertNotNull(eResponse.text());
      assertEquals(eResponse.text(), counterExampleText);

      // webhooks
      assertNotNull(updateResponse.getWebhooks());
      assertEquals(webhookName, updateResponse.getWebhooks().get(0).name());
      assertEquals(webhookUrl, updateResponse.getWebhooks().get(0).url());
      assertEquals(webhookHeaderName, updateResponse.getWebhooks().get(0).headers().get(0).name());
      assertEquals(
          webhookHeaderValue, updateResponse.getWebhooks().get(0).headers().get(0).value());

    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      if (workspaceId != null) {
        DeleteWorkspaceOptions deleteOptions =
            new DeleteWorkspaceOptions.Builder(workspaceId).build();
        service.deleteWorkspace(deleteOptions).execute();
      }
    }
  }

  /** Test listLogs. */
  @Test
  @Ignore
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

  /** Test listLogs with pagination. */
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
      Log logEntry1 = response.getLogs().get(0);

      String cursor = response.getPagination().getNextCursor();
      response = service.listLogs(listOptionsBuilder.cursor(cursor).build()).execute().getResult();

      assertNotNull(response.getLogs());
      assertTrue(response.getLogs().size() == 1);

      Log logEntry2 = response.getLogs().get(0);

      Date requestDate1 = isoDateFormat.parse(logEntry1.getRequestTimestamp());
      Date requestDate2 = isoDateFormat.parse(logEntry2.getRequestTimestamp());

      assertTrue(requestDate2.before(requestDate1));

    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /** Test createDialogNode. */
  @Test
  public void testCreateDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
            .description(dialogNodeDescription)
            .build();
    DialogNode response = service.createDialogNode(createOptions).execute().getResult();

    try {
      assertNotNull(response);
      assertNotNull(response.dialogNode());
      assertEquals(response.dialogNode(), dialogNodeName);
      assertNotNull(response.description());
      assertEquals(response.description(), dialogNodeDescription);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /** Test deleteDialogNode. */
  @Test
  public void testDeleteDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString(); // gotta be unique

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
    service.createDialogNode(createOptions).execute().getResult();

    DeleteDialogNodeOptions deleteOptions =
        new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
    service.deleteDialogNode(deleteOptions).execute();

    try {
      GetDialogNodeOptions getOptions =
          new GetDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.getDialogNode(getOptions).execute();
      fail("deleteDialogNode failed");
    } catch (Exception ex) {
      // Expected result
      assertTrue(ex instanceof NotFoundException);
    }
  }

  /** Test getDialogNode. */
  @Test
  public void testGetDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    Date start = new Date();

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
            .description(dialogNodeDescription)
            .build();
    service.createDialogNode(createOptions).execute().getResult();

    try {
      GetDialogNodeOptions getOptions =
          new GetDialogNodeOptions.Builder()
              .workspaceId(workspaceId)
              .dialogNode(dialogNodeName)
              .includeAudit(true)
              .build();
      DialogNode response = service.getDialogNode(getOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.dialogNode());
      assertEquals(response.dialogNode(), dialogNodeName);
      assertNotNull(response.description());
      assertEquals(response.description(), dialogNodeDescription);
      assertNotNull(response.created());
      assertNotNull(response.updated());

      Date now = new Date();
      assertTrue(fuzzyBefore(response.created(), now));
      assertTrue(fuzzyAfter(response.created(), start));
      assertTrue(fuzzyBefore(response.updated(), now));
      assertTrue(fuzzyAfter(response.updated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /** Test listDialogNodes. */
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

      CreateDialogNodeOptions createOptions =
          new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
              .description(dialogNodeDescription)
              .build();
      service.createDialogNode(createOptions).execute().getResult();

      long count = response.getDialogNodes().size();
      ListDialogNodesOptions listOptions2 =
          new ListDialogNodesOptions.Builder(workspaceId)
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
        if (node.dialogNode().equals(dialogNodeName)) {
          dialogResponse = node;
          break;
        }
      }

      assertNotNull(dialogResponse);
      assertNotNull(dialogResponse.description());
      assertEquals(dialogResponse.description(), dialogNodeDescription);

      Date now = new Date();
      assertTrue(fuzzyBefore(dialogResponse.created(), now));
      assertTrue(fuzzyAfter(dialogResponse.created(), start));
      assertTrue(fuzzyBefore(dialogResponse.updated(), now));
      assertTrue(fuzzyAfter(dialogResponse.updated(), start));
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /** Test listDialogNodes with pagination. */
  @Test
  public void testListDialogNodesWithPaging() {
    String dialogNodeName1 = "First" + UUID.randomUUID().toString();
    String dialogNodeName2 = "Second" + UUID.randomUUID().toString();

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName1).build();
    service.createDialogNode(createOptions).execute().getResult();
    service
        .createDialogNode(createOptions.newBuilder().dialogNode(dialogNodeName2).build())
        .execute()
        .getResult();

    try {
      ListDialogNodesOptions listOptions =
          new ListDialogNodesOptions.Builder()
              .workspaceId(workspaceId)
              .pageLimit(1L)
              .sort("dialog_node")
              .build();
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
        found1 |= response.getDialogNodes().get(0).dialogNode().equals(dialogNodeName1);
        found2 |= response.getDialogNodes().get(0).dialogNode().equals(dialogNodeName2);
        assertTrue(found1 || !found2); // verify sort
        if (response.getPagination().getNextCursor() == null) {
          break;
        }
        String cursor = response.getPagination().getNextCursor();
        response =
            service
                .listDialogNodes(listOptions.newBuilder().cursor(cursor).build())
                .execute()
                .getResult();
      }
      assertTrue(found1 && found2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName1).build();
      service.deleteDialogNode(deleteOptions).execute();
      service
          .deleteDialogNode(deleteOptions.newBuilder().dialogNode(dialogNodeName2).build())
          .execute();
    }
  }

  /** Test updateDialogNode. */
  @Test
  public void testUpdateDialogNode() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
            .description(dialogNodeDescription)
            .build();
    service.createDialogNode(createOptions).execute().getResult();

    String dialogNodeName2 = "Test2" + UUID.randomUUID().toString();

    try {
      String dialogNodeDescription2 = "Updated description of " + dialogNodeName;
      UpdateDialogNodeOptions updateOptions =
          new UpdateDialogNodeOptions.Builder()
              .workspaceId(workspaceId)
              .dialogNode(dialogNodeName)
              .newDialogNode(dialogNodeName2)
              .newDescription(dialogNodeDescription2)
              .build();
      DialogNode response = service.updateDialogNode(updateOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.dialogNode());
      assertEquals(response.dialogNode(), dialogNodeName2);
      assertNotNull(response.description());
      assertEquals(response.description(), dialogNodeDescription2);
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName2).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /** Test updateDialogNodeNullable. */
  @Test
  public void testUpdateDialogNodeNullable() {
    String dialogNodeName = "Test" + UUID.randomUUID().toString();
    String dialogNodeDescription = "Description of " + dialogNodeName;

    DialogNodeNextStep dialogNodeNextStep =
        new DialogNodeNextStep.Builder()
            .behavior(DialogNodeNextStep.Behavior.SKIP_USER_INPUT)
            .build();
    CreateDialogNodeOptions createOptions =
        new CreateDialogNodeOptions.Builder(workspaceId, dialogNodeName)
            .description(dialogNodeDescription)
            .nextStep(dialogNodeNextStep)
            .build();
    service.createDialogNode(createOptions).execute().getResult();

    String dialogNodeName2 = "Test2" + UUID.randomUUID().toString();

    try {
      String dialogNodeDescription2 = "Updated description of " + dialogNodeName;

      UpdateDialogNode updateDialogNode =
          new UpdateDialogNode.Builder()
              .description(dialogNodeDescription2)
              .nextStep(null)
              .dialogNode(dialogNodeName2)
              .build();
      Map<String, Object> body = updateDialogNode.asPatch();

      UpdateDialogNodeNullableOptions updateDialogNodeNullableOptions =
          new UpdateDialogNodeNullableOptions.Builder()
              .workspaceId(workspaceId)
              .dialogNode(dialogNodeName)
              .body(body)
              .build();
      DialogNode response =
          service.updateDialogNodeNullable(updateDialogNodeNullableOptions).execute().getResult();
      assertNotNull(response);
      assertNotNull(response.dialogNode());
      assertEquals(response.dialogNode(), dialogNodeName2);
      assertNotNull(response.description());
      assertEquals(response.description(), dialogNodeDescription2);
      assertNull(response.nextStep());
    } catch (Exception ex) {
      fail(ex.getMessage());
    } finally {
      // Clean up
      DeleteDialogNodeOptions deleteOptions =
          new DeleteDialogNodeOptions.Builder(workspaceId, dialogNodeName2).build();
      service.deleteDialogNode(deleteOptions).execute();
    }
  }

  /** Test deleteUserData. */
  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions =
          new DeleteUserDataOptions.Builder().customerId(customerId).build();
      service.deleteUserData(deleteOptions).execute();
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /** Test list mentions. */
  @Test
  public void testListMentions() {
    String entity = "beverage";

    ListMentionsOptions listMentionsOptions =
        new ListMentionsOptions.Builder().workspaceId(workspaceId).entity(entity).build();
    EntityMentionCollection collection =
        service.listMentions(listMentionsOptions).execute().getResult();
    assertNotNull(collection);
  }

  /** Test bulk classify */
  @Ignore
  @Test
  public void testBulkClassify() {
    BulkClassifyUtterance bulkClassifyUtterance =
        new BulkClassifyUtterance.Builder().text("help I need help").build();
    BulkClassifyOptions bulkClassifyOptions =
        new BulkClassifyOptions.Builder()
            .addInput(bulkClassifyUtterance)
            .workspaceId("{workspaceId}")
            .build();
    BulkClassifyResponse response = service.bulkClassify(bulkClassifyOptions).execute().getResult();

    assertNotNull(response);
  }
}
