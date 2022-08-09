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

/**
 * Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer model.
 */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer()
      throws Throwable {
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

    DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.Builder()
                .responseType("channel_transfer")
                .messageToUser("testString")
                .transferInfo(channelTransferInfoModel)
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel.responseType(),
        "channel_transfer");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel.messageToUser(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel.transferInfo(),
        channelTransferInfoModel);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(
            dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModelNew.responseType(),
        "channel_transfer");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModelNew.messageToUser(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferModelNew
            .transferInfo()
            .toString(),
        channelTransferInfoModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransferError()
      throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.Builder().build();
  }
}
