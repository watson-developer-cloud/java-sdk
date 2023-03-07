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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeConnectToAgent model. */
public class RuntimeResponseGenericRuntimeResponseTypeConnectToAgentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeConnectToAgent() throws Throwable {
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

    RuntimeResponseGenericRuntimeResponseTypeConnectToAgent
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel =
            new RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.Builder()
                .responseType("connect_to_agent")
                .messageToHumanAgent("testString")
                .agentAvailable(agentAvailabilityMessageModel)
                .agentUnavailable(agentAvailabilityMessageModel)
                .transferInfo(dialogNodeOutputConnectToAgentTransferInfoModel)
                .topic("testString")
                .dialogNode("testString")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.responseType(),
        "connect_to_agent");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.messageToHumanAgent(),
        "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.agentAvailable(),
        agentAvailabilityMessageModel);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.agentUnavailable(),
        agentAvailabilityMessageModel);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.transferInfo(),
        dialogNodeOutputConnectToAgentTransferInfoModel);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.topic(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.dialogNode(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeConnectToAgentModel);

    RuntimeResponseGenericRuntimeResponseTypeConnectToAgent
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew =
            TestUtilities.deserialize(
                json, RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeConnectToAgent);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.responseType(),
        "connect_to_agent");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.messageToHumanAgent(),
        "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.agentAvailable().toString(),
        agentAvailabilityMessageModel.toString());
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew
            .agentUnavailable()
            .toString(),
        agentAvailabilityMessageModel.toString());
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.transferInfo().toString(),
        dialogNodeOutputConnectToAgentTransferInfoModel.toString());
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.topic(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeConnectToAgentModelNew.dialogNode(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeConnectToAgentError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeConnectToAgent.Builder().build();
  }
}
