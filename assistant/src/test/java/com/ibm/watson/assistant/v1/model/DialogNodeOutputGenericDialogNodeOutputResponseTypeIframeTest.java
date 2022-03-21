/*
 * (C) Copyright IBM Corp. 2022.
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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeIframeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeIframe() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.Builder()
                .responseType("iframe")
                .source("testString")
                .title("testString")
                .description("testString")
                .imageUrl("testString")
                .channels(
                    new java.util.ArrayList<ResponseGenericChannel>(
                        java.util.Arrays.asList(responseGenericChannelModel)))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.responseType(), "iframe");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.description(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.imageUrl(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew.responseType(), "iframe");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew.description(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeIframeModelNew.imageUrl(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeIframeError()
      throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeIframe.Builder().build();
  }
}
