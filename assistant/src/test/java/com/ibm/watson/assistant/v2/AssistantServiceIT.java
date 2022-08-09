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
package com.ibm.watson.assistant.v2;

import static org.junit.Assert.*;

import com.ibm.cloud.sdk.core.security.*;
import com.ibm.watson.assistant.v2.model.*;
import com.ibm.watson.assistant.v2.model.ListLogsOptions.Builder;
import com.ibm.watson.common.RetryRunner;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Integration tests for Assistant v2. */
@RunWith(RetryRunner.class)
public class AssistantServiceIT extends AssistantServiceTest {
  private Assistant service;
  private String assistantId;

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
    this.assistantId = getAssistantId();
  }

  /** Test send messages. */
  @Test
  public void testSendMessages() {
    // get session ID
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(assistantId).build();
    SessionResponse sessionResponse =
        service.createSession(createSessionOptions).execute().getResult();
    String sessionId = sessionResponse.getSessionId();

    final List<String> messages = Arrays.asList("Hello");
    MessageContext context = new MessageContext.Builder().build();

    try {
      // send messages
      for (String message : messages) {
        MessageInputOptions inputOptions = new MessageInputOptions.Builder().debug(true).build();
        MessageInput input =
            new MessageInput.Builder()
                .text(message)
                .messageType(MessageInput.MessageType.TEXT)
                .options(inputOptions)
                .build();
        MessageOptions messageOptions =
            new MessageOptions.Builder()
                .assistantId(assistantId)
                .sessionId(sessionId)
                .input(input)
                .context(context)
                .build();
        MessageResponse messageResponse = service.message(messageOptions).execute().getResult();

        // message assertions
        List<RuntimeResponseGeneric> genericResponses = messageResponse.getOutput().getGeneric();
        assertNotNull(genericResponses);
        boolean foundTextResponse = false;
        for (RuntimeResponseGeneric generic : genericResponses) {
          if (generic.responseType().equals("text")) {
            foundTextResponse = true;
            break;
          }
        }
        assertTrue(foundTextResponse);
        assertNotNull(messageResponse.getOutput().getEntities());
        assertNotNull(messageResponse.getOutput().getIntents());
        assertNotNull(messageResponse.getOutput().getDebug());

        context = messageResponse.getContext();
      }
    } finally {
      // delete session
      DeleteSessionOptions deleteSessionOptions =
          new DeleteSessionOptions.Builder().assistantId(assistantId).sessionId(sessionId).build();
      service.deleteSession(deleteSessionOptions).execute();
    }
  }

  /** Test send message stateless. */
  @Test
  public void testSendMessageStateless() {
    // get session ID
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(assistantId).build();
    SessionResponse sessionResponse =
        service.createSession(createSessionOptions).execute().getResult();
    String sessionId = sessionResponse.getSessionId();

    final List<String> messages = Arrays.asList("Hello");
    MessageContextStateless context = new MessageContextStateless.Builder().build();

    try {
      // send messages
      for (String message : messages) {
        MessageInputOptionsStateless inputOptions =
            new MessageInputOptionsStateless.Builder().debug(true).build();
        MessageInputStateless input =
            new MessageInputStateless.Builder()
                .text(message)
                .messageType(MessageInput.MessageType.TEXT)
                .options(inputOptions)
                .build();
        MessageStatelessOptions messageOptions =
            new MessageStatelessOptions.Builder()
                .assistantId(assistantId)
                .input(input)
                .context(context)
                .build();
        MessageResponseStateless messageResponse =
            service.messageStateless(messageOptions).execute().getResult();

        // message assertions
        List<RuntimeResponseGeneric> genericResponses = messageResponse.getOutput().getGeneric();
        assertNotNull(genericResponses);
        boolean foundTextResponse = false;
        for (RuntimeResponseGeneric generic : genericResponses) {
          if (generic.responseType().equals("text")) {
            foundTextResponse = true;
            break;
          }
        }
        assertTrue(foundTextResponse);
        assertNotNull(messageResponse.getOutput().getEntities());
        assertNotNull(messageResponse.getOutput().getIntents());
        assertNotNull(messageResponse.getOutput().getDebug());

        context = messageResponse.getContext();
      }
    } finally {
      // delete session
      DeleteSessionOptions deleteSessionOptions =
          new DeleteSessionOptions.Builder().assistantId(assistantId).sessionId(sessionId).build();
      service.deleteSession(deleteSessionOptions).execute();
    }
  }

  /** Test List Logs. */
  // @Test
  public void testListLogs() {
    // list logs sorted by timestamp and that contain the text Hello
    Builder builder = new ListLogsOptions.Builder();
    builder.assistantId(assistantId);
    builder.sort("request_timestamp");
    builder.filter("request.input.text::\"Hello\"");
    builder.pageLimit(5);

    LogCollection logCollection = service.listLogs(builder.build()).execute().getResult();

    assertNotNull(logCollection);
    assertTrue(logCollection.getLogs().get(0).getRequest().input().text().contains("Hello"));
    assertTrue(logCollection.getLogs().get(0).getLanguage().equals("en"));
  }

  /** Test bulk classify */
  @Ignore
  @Test
  public void testBulkClassify() {
    BulkClassifyUtterance bulkClassifyUtterance =
        new BulkClassifyUtterance.Builder().text("text text").build();
    BulkClassifyOptions bulkClassifyOptions =
        new BulkClassifyOptions.Builder()
            .addInput(bulkClassifyUtterance)
            .skillId("{skillId}")
            .build();
    BulkClassifyResponse response = service.bulkClassify(bulkClassifyOptions).execute().getResult();

    assertNotNull(response);
  }

  /** Test RuntimeResponseGenericRuntimeResponseTypeChannelTransfer. */
  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeChannelTransfer() {

    // get session ID
    CreateSessionOptions createSessionOptions =
        new CreateSessionOptions.Builder().assistantId(assistantId).build();
    SessionResponse sessionResponse =
        service.createSession(createSessionOptions).execute().getResult();
    String sessionId = sessionResponse.getSessionId();

    final List<String> messages = Arrays.asList("test sdk");
    MessageContext context = new MessageContext.Builder().build();

    MessageInputOptions inputOptions = new MessageInputOptions.Builder().debug(true).build();
    MessageInput input =
        new MessageInput.Builder()
            .text("test sdk")
            .messageType(MessageInput.MessageType.TEXT)
            .options(inputOptions)
            .build();
    MessageOptions messageOptions =
        new MessageOptions.Builder()
            .assistantId(assistantId)
            .sessionId(sessionId)
            .input(input)
            .context(context)
            .build();
    MessageResponse response = service.message(messageOptions).execute().getResult();

    RuntimeResponseGenericRuntimeResponseTypeChannelTransfer
        runtimeResponseGenericRuntimeResponseTypeChannelTransfer =
            (RuntimeResponseGenericRuntimeResponseTypeChannelTransfer)
                response.getOutput().getGeneric().get(0);

    assertNotNull(runtimeResponseGenericRuntimeResponseTypeChannelTransfer.transferInfo());
  }

  /** Test List Environments and Get Environment */
  @Test
  public void testGettingEnvironments() {
    ListEnvironmentsOptions listEnvironmentOptions =
        new ListEnvironmentsOptions.Builder().assistantId(assistantId).build();

    EnvironmentCollection environments =
        service.listEnvironments(listEnvironmentOptions).execute().getResult();

    assertNotNull(environments);
    assertNotNull(environments.getEnvironments().get(1).getName());
    assertNotNull(environments.getEnvironments().get(1).getEnvironmentId());

    String environmentId = environments.getEnvironments().get(1).getEnvironmentId();

    GetEnvironmentOptions getEnvironmentOptions =
            new GetEnvironmentOptions.Builder()
                    .assistantId(assistantId)
                    .environmentId(environmentId)
                    .build();

    Environment environment = service.getEnvironment(getEnvironmentOptions).execute().getResult();

    assertNotNull(environment);
    assertNotNull(environment.getName());
    assertNotNull(environment.getEnvironmentId());
  }

  /** Test List Releases and Get Release */
  @Test
  public void testGettingReleases() {
    ListReleasesOptions listReleasesOptions =
        new ListReleasesOptions.Builder().assistantId(assistantId).build();

    ReleaseCollection releases = service.listReleases(listReleasesOptions).execute().getResult();

    assertNotNull(releases);
    assertNotNull(releases.getReleases().get(0).getStatus());
    assertNotNull(releases.getReleases().get(0).getRelease());

    String releaseId = releases.getReleases().get(0).getRelease();

    GetReleaseOptions getReleasesOptions =
            new GetReleaseOptions.Builder().assistantId(assistantId).release(releaseId).build();

    Release release = service.getRelease(getReleasesOptions).execute().getResult();

    assertNotNull(release);
    assertEquals("Available", release.getStatus());
  }

  /** Test Deploy Releases. */
  // @Test
  public void testDeployRelease() {
    String environmentId = "TBD";
    String releaseId = "TBD";

    DeployReleaseOptions deployReleasesOptions =
        new DeployReleaseOptions.Builder()
            .assistantId(assistantId)
            .release(releaseId)
            .environmentId(environmentId)
            .build();

    Environment release = service.deployRelease(deployReleasesOptions).execute().getResult();

    assertNotNull(release);
    assertNotNull(release);
    assertNotNull(release.getName());
    assertNotNull(release.getEnvironmentId());
  }

  /** Test Delete User Data. */
  /*
  @Test
  public void testDeleteUserData(){
    String customerIdExample = "";
    Response<Void> deleteUserDataResponse = service.deleteUserData(new DeleteUserDataOptions.Builder().customerId(customerIdExample).build()).execute();

    assertTrue(deleteUserDataResponse.getStatusCode() == 204);
  }
  */
}
