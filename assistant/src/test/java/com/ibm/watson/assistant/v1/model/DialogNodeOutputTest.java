/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

/** Unit test class for the DialogNodeOutput model. */
public class DialogNodeOutputTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutput() throws Throwable {
    DialogNodeOutputTextValuesElement dialogNodeOutputTextValuesElementModel =
        new DialogNodeOutputTextValuesElement.Builder().text("testString").build();
    assertEquals(dialogNodeOutputTextValuesElementModel.text(), "testString");

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeText dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeText.Builder()
            .responseType("text")
            .values(java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel))
            .selectionPolicy("sequential")
            .delimiter("\\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "text");
    assertEquals(
        dialogNodeOutputGenericModel.values(),
        java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel));
    assertEquals(dialogNodeOutputGenericModel.selectionPolicy(), "sequential");
    assertEquals(dialogNodeOutputGenericModel.delimiter(), "\\n");
    assertEquals(
        dialogNodeOutputGenericModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
        new DialogNodeOutputModifiers.Builder().overwrite(true).build();
    assertEquals(dialogNodeOutputModifiersModel.overwrite(), Boolean.valueOf(true));

    DialogNodeOutput dialogNodeOutputModel =
        new DialogNodeOutput.Builder()
            .generic(java.util.Arrays.asList(dialogNodeOutputGenericModel))
            .integrations(
                java.util.Collections.singletonMap(
                    "key1", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeOutputModel.getGeneric(), java.util.Arrays.asList(dialogNodeOutputGenericModel));
    assertEquals(
        dialogNodeOutputModel.getIntegrations(),
        java.util.Collections.singletonMap(
            "key1", java.util.Collections.singletonMap("anyKey", "anyValue")));
    assertEquals(dialogNodeOutputModel.getModifiers(), dialogNodeOutputModifiersModel);
    assertEquals(dialogNodeOutputModel.get("foo"), "testString");

    String json = TestUtilities.serialize(dialogNodeOutputModel);

    DialogNodeOutput dialogNodeOutputModelNew =
        TestUtilities.deserialize(json, DialogNodeOutput.class);
    assertTrue(dialogNodeOutputModelNew instanceof DialogNodeOutput);
    assertEquals(
        dialogNodeOutputModelNew.getModifiers().toString(),
        dialogNodeOutputModifiersModel.toString());
    assertEquals(dialogNodeOutputModelNew.get("foo"), "testString");
  }
}
