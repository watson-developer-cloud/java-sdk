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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeAudioTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeAudio() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio.Builder()
                .responseType("audio")
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
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.responseType(), "audio");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.description(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.channelOptions(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel.altText(), "testString");

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew.responseType(), "audio");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew.description(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew
            .channelOptions()
            .toString(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        }.toString());
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeAudioModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeAudioError() throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeAudio.Builder().build();
  }
}
