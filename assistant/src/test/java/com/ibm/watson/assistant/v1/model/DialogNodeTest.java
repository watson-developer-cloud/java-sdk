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

/** Unit test class for the DialogNode model. */
public class DialogNodeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNode() throws Throwable {
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
            .delimiter("\n")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "text");
    assertEquals(
        dialogNodeOutputGenericModel.values(),
        java.util.Arrays.asList(dialogNodeOutputTextValuesElementModel));
    assertEquals(dialogNodeOutputGenericModel.selectionPolicy(), "sequential");
    assertEquals(dialogNodeOutputGenericModel.delimiter(), "\n");
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
                    "foo", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .modifiers(dialogNodeOutputModifiersModel)
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeOutputModel.getGeneric(), java.util.Arrays.asList(dialogNodeOutputGenericModel));
    assertEquals(
        dialogNodeOutputModel.getIntegrations(),
        java.util.Collections.singletonMap(
            "foo", java.util.Collections.singletonMap("anyKey", "anyValue")));
    assertEquals(dialogNodeOutputModel.getModifiers(), dialogNodeOutputModifiersModel);
    assertEquals(dialogNodeOutputModel.get("foo"), "testString");

    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                java.util.Collections.singletonMap(
                    "foo", java.util.Collections.singletonMap("anyKey", "anyValue")))
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeContextModel.getIntegrations(),
        java.util.Collections.singletonMap(
            "foo", java.util.Collections.singletonMap("anyKey", "anyValue")));
    assertEquals(dialogNodeContextModel.get("foo"), "testString");

    DialogNodeNextStep dialogNodeNextStepModel =
        new DialogNodeNextStep.Builder()
            .behavior("get_user_input")
            .dialogNode("testString")
            .selector("condition")
            .build();
    assertEquals(dialogNodeNextStepModel.behavior(), "get_user_input");
    assertEquals(dialogNodeNextStepModel.dialogNode(), "testString");
    assertEquals(dialogNodeNextStepModel.selector(), "condition");

    DialogNodeAction dialogNodeActionModel =
        new DialogNodeAction.Builder()
            .name("testString")
            .type("client")
            .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .resultVariable("testString")
            .credentials("testString")
            .build();
    assertEquals(dialogNodeActionModel.name(), "testString");
    assertEquals(dialogNodeActionModel.type(), "client");
    assertEquals(
        dialogNodeActionModel.parameters(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(dialogNodeActionModel.resultVariable(), "testString");
    assertEquals(dialogNodeActionModel.credentials(), "testString");

    DialogNode dialogNodeModel =
        new DialogNode.Builder()
            .dialogNode("testString")
            .description("testString")
            .conditions("testString")
            .parent("testString")
            .previousSibling("testString")
            .output(dialogNodeOutputModel)
            .context(dialogNodeContextModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .nextStep(dialogNodeNextStepModel)
            .title("testString")
            .type("standard")
            .eventName("focus")
            .variable("testString")
            .actions(java.util.Arrays.asList(dialogNodeActionModel))
            .digressIn("not_available")
            .digressOut("allow_returning")
            .digressOutSlots("not_allowed")
            .userLabel("testString")
            .disambiguationOptOut(false)
            .build();
    assertEquals(dialogNodeModel.dialogNode(), "testString");
    assertEquals(dialogNodeModel.description(), "testString");
    assertEquals(dialogNodeModel.conditions(), "testString");
    assertEquals(dialogNodeModel.parent(), "testString");
    assertEquals(dialogNodeModel.previousSibling(), "testString");
    assertEquals(dialogNodeModel.output(), dialogNodeOutputModel);
    assertEquals(dialogNodeModel.context(), dialogNodeContextModel);
    assertEquals(
        dialogNodeModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(dialogNodeModel.nextStep(), dialogNodeNextStepModel);
    assertEquals(dialogNodeModel.title(), "testString");
    assertEquals(dialogNodeModel.type(), "standard");
    assertEquals(dialogNodeModel.eventName(), "focus");
    assertEquals(dialogNodeModel.variable(), "testString");
    assertEquals(dialogNodeModel.actions(), java.util.Arrays.asList(dialogNodeActionModel));
    assertEquals(dialogNodeModel.digressIn(), "not_available");
    assertEquals(dialogNodeModel.digressOut(), "allow_returning");
    assertEquals(dialogNodeModel.digressOutSlots(), "not_allowed");
    assertEquals(dialogNodeModel.userLabel(), "testString");
    assertEquals(dialogNodeModel.disambiguationOptOut(), Boolean.valueOf(false));

    String json = TestUtilities.serialize(dialogNodeModel);

    DialogNode dialogNodeModelNew = TestUtilities.deserialize(json, DialogNode.class);
    assertTrue(dialogNodeModelNew instanceof DialogNode);
    assertEquals(dialogNodeModelNew.dialogNode(), "testString");
    assertEquals(dialogNodeModelNew.description(), "testString");
    assertEquals(dialogNodeModelNew.conditions(), "testString");
    assertEquals(dialogNodeModelNew.parent(), "testString");
    assertEquals(dialogNodeModelNew.previousSibling(), "testString");
    assertEquals(dialogNodeModelNew.output().toString(), dialogNodeOutputModel.toString());
    assertEquals(dialogNodeModelNew.context().toString(), dialogNodeContextModel.toString());
    assertEquals(
        dialogNodeModelNew.metadata().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(dialogNodeModelNew.nextStep().toString(), dialogNodeNextStepModel.toString());
    assertEquals(dialogNodeModelNew.title(), "testString");
    assertEquals(dialogNodeModelNew.type(), "standard");
    assertEquals(dialogNodeModelNew.eventName(), "focus");
    assertEquals(dialogNodeModelNew.variable(), "testString");
    assertEquals(dialogNodeModelNew.digressIn(), "not_available");
    assertEquals(dialogNodeModelNew.digressOut(), "allow_returning");
    assertEquals(dialogNodeModelNew.digressOutSlots(), "not_allowed");
    assertEquals(dialogNodeModelNew.userLabel(), "testString");
    assertEquals(dialogNodeModelNew.disambiguationOptOut(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeError() throws Throwable {
    new DialogNode.Builder().build();
  }
}
