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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeVideoTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeVideo() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.Builder()
                .responseType("video")
                .source("testString")
                .title("testString")
                .description("testString")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .channelOptions(
                    new java.util.HashMap<String, Object>() {
                      {
                        put("foo", "testString");
                      }
                    })
                .altText("testString")
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.responseType(), "video");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.description(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.channelOptions(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel.altText(), "testString");

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew.responseType(), "video");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew.description(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew
            .channelOptions()
            .toString(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        }.toString());
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeVideoModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeVideoError() throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeVideo.Builder().build();
  }
}
