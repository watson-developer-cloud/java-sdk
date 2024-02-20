/*
 * (C) Copyright IBM Corp. 2024.
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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeText model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeTextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeText() throws Throwable {
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();
    assertEquals(dialogNodeOutputTextValuesElementModel.text(), "testString");

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeText
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
                .responseType("text")
                .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
                .selectionPolicy("sequential")
                .delimiter("\\n")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel.responseType(), "text");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel.values(),
        java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel.selectionPolicy(),
        "sequential");
    assertEquals(dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel.delimiter(), "\\n");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeText
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeText.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeText);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModelNew.responseType(), "text");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModelNew.selectionPolicy(),
        "sequential");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeTextModelNew.delimiter(), "\\n");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeTextError() throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder().build();
  }
}
