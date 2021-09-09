/*
 * (C) Copyright IBM Corp. 2021.
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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeImage model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeImageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeImage() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeImage
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeImage.Builder()
                .responseType("image")
                .source("testString")
                .title("testString")
                .description("testString")
                .channels(
                    new java.util.ArrayList<ResponseGenericChannel>(
                        java.util.Arrays.asList(responseGenericChannelModel)))
                .altText("testString")
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.responseType(), "image");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.description(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel.altText(), "testString");

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeImage
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeImage.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeImage);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew.responseType(), "image");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew.source(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew.title(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew.description(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeImageModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeImageError() throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeImage.Builder().build();
  }
}
