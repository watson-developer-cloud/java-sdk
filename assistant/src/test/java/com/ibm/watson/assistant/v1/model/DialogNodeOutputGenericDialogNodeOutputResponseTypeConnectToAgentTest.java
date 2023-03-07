/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/**
 * Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent model.
 */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent()
      throws Throwable {
    AgentAvailabilityMessage agentAvailabilityMessageModel =
        new AgentAvailabilityMessage.Builder().message("testString").build();
    assertEquals(agentAvailabilityMessageModel.message(), "testString");

    DialogNodeOutputConnectToAgentTransferInfo dialogNodeOutputConnectToAgentTransferInfoModel =
        new DialogNodeOutputConnectToAgentTransferInfo.Builder()
            .target(
                java.util.Collections.singletonMap(
                    "foo", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .build();
    assertEquals(
        dialogNodeOutputConnectToAgentTransferInfoModel.target(),
        java.util.Collections.singletonMap(
            "foo", java.util.Collections.singletonMap("anyKey", "anyValue")));

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.Builder()
                .responseType("connect_to_agent")
                .messageToHumanAgent("testString")
                .agentAvailable(agentAvailabilityMessageModel)
                .agentUnavailable(agentAvailabilityMessageModel)
                .transferInfo(dialogNodeOutputConnectToAgentTransferInfoModel)
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel.responseType(),
        "connect_to_agent");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel
            .messageToHumanAgent(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel.agentAvailable(),
        agentAvailabilityMessageModel);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel.agentUnavailable(),
        agentAvailabilityMessageModel);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel.transferInfo(),
        dialogNodeOutputConnectToAgentTransferInfoModel);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(
            dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew.responseType(),
        "connect_to_agent");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew
            .messageToHumanAgent(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew
            .agentAvailable()
            .toString(),
        agentAvailabilityMessageModel.toString());
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew
            .agentUnavailable()
            .toString(),
        agentAvailabilityMessageModel.toString());
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentModelNew
            .transferInfo()
            .toString(),
        dialogNodeOutputConnectToAgentTransferInfoModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgentError()
      throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.Builder().build();
  }
}
