/*
 * (C) Copyright IBM Corp. 2021, 2022.
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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeChannelTransfer model. */
public class RuntimeResponseGenericRuntimeResponseTypeChannelTransferTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeChannelTransfer() throws Throwable {
    ChannelTransferTargetChat channelTransferTargetChatModel =
        new ChannelTransferTargetChat.Builder().url("testString").build();
    assertEquals(channelTransferTargetChatModel.url(), "testString");

    ChannelTransferTarget channelTransferTargetModel =
        new ChannelTransferTarget.Builder().chat(channelTransferTargetChatModel).build();
    assertEquals(channelTransferTargetModel.chat(), channelTransferTargetChatModel);

    ChannelTransferInfo channelTransferInfoModel =
        new ChannelTransferInfo.Builder().target(channelTransferTargetModel).build();
    assertEquals(channelTransferInfoModel.target(), channelTransferTargetModel);

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeChannelTransfer
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModel =
            new RuntimeResponseGenericRuntimeResponseTypeChannelTransfer.Builder()
                .responseType("channel_transfer")
                .messageToUser("testString")
                .transferInfo(channelTransferInfoModel)
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModel.responseType(),
        "channel_transfer");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModel.messageToUser(),
        "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModel.transferInfo(),
        channelTransferInfoModel);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeChannelTransferModel);

    RuntimeResponseGenericRuntimeResponseTypeChannelTransfer
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModelNew =
            TestUtilities.deserialize(
                json, RuntimeResponseGenericRuntimeResponseTypeChannelTransfer.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeChannelTransfer);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModelNew.responseType(),
        "channel_transfer");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModelNew.messageToUser(),
        "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeChannelTransferModelNew.transferInfo().toString(),
        channelTransferInfoModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeChannelTransferError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeChannelTransfer.Builder().build();
  }
}
