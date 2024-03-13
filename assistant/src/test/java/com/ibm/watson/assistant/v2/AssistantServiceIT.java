/*
 * (C) Copyright IBM Corp. 2019, 2024.
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
import java.util.ArrayList;
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
        StatefulMessageResponse messageResponse =
            service.message(messageOptions).execute().getResult();

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
        assertNotNull(messageResponse.getContext().skills().actionsSkill());

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
    StatelessMessageContext context = new StatelessMessageContext.Builder().build();

    try {
      // send messages
      for (String message : messages) {
        StatelessMessageInputOptions inputOptions =
            new StatelessMessageInputOptions.Builder().debug(true).build();
        StatelessMessageInput input =
            new StatelessMessageInput.Builder()
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
        StatelessMessageResponse messageResponse =
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
    assertTrue(logCollection.getLogs().get(0).getRequest().getInput().text().contains("Hello"));
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
    StatefulMessageResponse response = service.message(messageOptions).execute().getResult();

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
    assertNotNull(releases.getReleases().get(0).status());
    assertNotNull(releases.getReleases().get(0).release());

    String releaseId = releases.getReleases().get(0).release();

    GetReleaseOptions getReleasesOptions =
        new GetReleaseOptions.Builder().assistantId(assistantId).release(releaseId).build();

    Release release = service.getRelease(getReleasesOptions).execute().getResult();

    assertNotNull(release);
    assertEquals("Available", release.status());
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

  /** Test Assistant CRUD operations */
  // @Test
  public void testAssistantCRUDOperations() {
    // Create Assistant

    CreateAssistantOptions createAssistantOptions =
        new CreateAssistantOptions.Builder()
            .name("Java SDK Test Assistant")
            .description("Created by the Integration Test suite for the Java SDK")
            .language("en")
            .build();

    AssistantData createAssistantResult =
        service.createAssistant(createAssistantOptions).execute().getResult();

    assertNotNull(createAssistantResult);
    assertNotNull(createAssistantResult.assistantId());
    assertEquals("Java SDK Test Assistant", createAssistantResult.name());
    assertNotNull(createAssistantResult.assistantSkills());
    assertNotNull(createAssistantResult.assistantEnvironments());
    assertEquals(
        "Created by the Integration Test suite for the Java SDK",
        createAssistantResult.description());
    assertEquals("en", createAssistantResult.language());

    // List Assistants

    ListAssistantsOptions listAssistantsOptions =
        new ListAssistantsOptions.Builder()
            .pageLimit(5)
            .includeCount(true)
            .sort("name")
            .includeAudit(true)
            .build();

    AssistantCollection listAssistantsResponse =
        service.listAssistants(listAssistantsOptions).execute().getResult();

    assertNotNull(listAssistantsResponse);
    assertNotNull(listAssistantsResponse.getAssistants());
    assertNotNull(listAssistantsResponse.getPagination());

    // Delete Assistant

    DeleteAssistantOptions deleteAssistantOptions =
        new DeleteAssistantOptions.Builder()
            .assistantId(createAssistantResult.assistantId())
            .build();

    int deleteResponseCode =
        service.deleteAssistant(deleteAssistantOptions).execute().getStatusCode();

    assertEquals(200, deleteResponseCode);
  }

  /** Test Skills CRUD operations */
  // @Test
  public void testSkillsCRUDOperations() {
    // Bootstrap new assistant and get default skill

    CreateAssistantOptions createAssistantOptions =
        new CreateAssistantOptions.Builder()
            .name("Java SDK Test Assistant")
            .description("Created by the Integration Test suite for the Java SDK")
            .language("en")
            .build();

    AssistantData createAssistantResult =
        service.createAssistant(createAssistantOptions).execute().getResult();

    String assistantId = createAssistantResult.assistantId();
    String skillId = createAssistantResult.assistantSkills().get(0).skillId();

    // Get skill

    GetSkillOptions getSkillOptions =
        new GetSkillOptions.Builder().assistantId(assistantId).skillId(skillId).build();

    Skill getSkillResult = service.getSkill(getSkillOptions).execute().getResult();

    assertNotNull(getSkillResult);
    assertEquals(skillId, getSkillResult.getSkillId());
    assertEquals(assistantId, getSkillResult.getAssistantId());

    // Update skill

    UpdateSkillOptions updateSkillOptions =
        new UpdateSkillOptions.Builder()
            .assistantId(assistantId)
            .skillId(skillId)
            .name("Updated Java SDK Skill")
            .description("Updated by the Skill CRUD integration tests")
            .build();

    Skill updateSkillResult = service.updateSkill(updateSkillOptions).execute().getResult();

    assertNotNull(updateSkillResult);
    assertEquals(assistantId, updateSkillResult.getAssistantId());
    assertEquals(skillId, updateSkillResult.getSkillId());
    assertEquals("Updated Java SDK Skill", updateSkillResult.getName());
    assertEquals("Updated by the Skill CRUD integration tests", updateSkillResult.getDescription());

    // Import skill

    SkillImport skillImport =
        new SkillImport.Builder()
            .name("Watson Java SDK Import Skill")
            .description("Testing the import skill endpoint")
            .language("en")
            .type("action")
            .build();

    List<SkillImport> skillsToImport = new ArrayList<SkillImport>();
    skillsToImport.add(skillImport);

    ImportSkillsOptions importSkillsOptions =
        new ImportSkillsOptions.Builder()
            .assistantId(assistantId)
            .assistantSkills(skillsToImport)
            .build();

    SkillsAsyncRequestStatus skillImportResult =
        service.importSkills(importSkillsOptions).execute().getResult();

    assertNotNull(skillImportResult);
    assertEquals(assistantId, skillImportResult.getAssistantId());
    assertNotNull(skillImportResult.getStatus());

    String importStatus = skillImportResult.getStatus();

    // poll for available status

    ImportSkillsStatusOptions importSkillsStatusOptions =
        new ImportSkillsStatusOptions.Builder().assistantId(assistantId).build();

    while (importStatus != SkillsAsyncRequestStatus.Status.COMPLETED) {
      skillImportResult =
          service.importSkillsStatus(importSkillsStatusOptions).execute().getResult();
      importStatus = skillImportResult.getStatus();

      assertNotEquals(SkillsAsyncRequestStatus.Status.FAILED, importStatus);
    }

    assertEquals(SkillsAsyncRequestStatus.Status.COMPLETED, importStatus);

    // Export skill

    ExportSkillsOptions exportSkillsOptions =
        new ExportSkillsOptions.Builder().assistantId(assistantId).includeAudit(true).build();

    SkillsExport skillsExportResult =
        service.exportSkills(exportSkillsOptions).execute().getResult();

    assertNotNull(skillsExportResult);
    assertNotNull(skillsExportResult.getAssistantSkills());
    assertNotNull(skillsExportResult.getAssistantState());

    // Tear down created assistant

    DeleteAssistantOptions deleteAssistantOptions =
        new DeleteAssistantOptions.Builder().assistantId(assistantId).build();

    int deleteResponseCode =
        service.deleteAssistant(deleteAssistantOptions).execute().getStatusCode();

    assertEquals(200, deleteResponseCode);
  }
}
