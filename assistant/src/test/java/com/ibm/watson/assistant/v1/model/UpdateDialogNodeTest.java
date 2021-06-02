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
import java.util.Map;
import org.testng.annotations.Test;

/** Unit test class for the UpdateDialogNode model. */
public class UpdateDialogNodeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
          TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateDialogNode() throws Throwable {
    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
                    .responseType("search_skill")
                    .query("testString")
                    .queryType("natural_language")
                    .filter("testString")
                    .discoveryVersion("testString")
                    .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "search_skill");
    assertEquals(dialogNodeOutputGenericModel.query(), "testString");
    assertEquals(dialogNodeOutputGenericModel.queryType(), "natural_language");
    assertEquals(dialogNodeOutputGenericModel.filter(), "testString");
    assertEquals(dialogNodeOutputGenericModel.discoveryVersion(), "testString");

    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
            new DialogNodeOutputModifiers.Builder().overwrite(true).build();
    assertEquals(dialogNodeOutputModifiersModel.overwrite(), Boolean.valueOf(true));

    DialogNodeOutput dialogNodeOutputModel =
            new DialogNodeOutput.Builder()
                    .generic(
                            new java.util.ArrayList<DialogNodeOutputGeneric>(
                                    java.util.Arrays.asList(dialogNodeOutputGenericModel)))
                    .integrations(
                            new java.util.HashMap<String, Map<String, Object>>() {
                              {
                                put(
                                        "foo",
                                        new java.util.HashMap<String, Object>() {
                                          {
                                            put("foo", "testString");
                                          }
                                        });
                              }
                            })
                    .modifiers(dialogNodeOutputModifiersModel)
                    .add("foo", "testString")
                    .build();
    assertEquals(
            dialogNodeOutputModel.getGeneric(),
            new java.util.ArrayList<DialogNodeOutputGeneric>(
                    java.util.Arrays.asList(dialogNodeOutputGenericModel)));
    assertEquals(
            dialogNodeOutputModel.getIntegrations(),
            new java.util.HashMap<String, Map<String, Object>>() {
              {
                put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
              }
            });
    assertEquals(dialogNodeOutputModel.getModifiers(), dialogNodeOutputModifiersModel);
    assertEquals(dialogNodeOutputModel.get("foo"), "testString");

    DialogNodeContext dialogNodeContextModel =
            new DialogNodeContext.Builder()
                    .integrations(
                            new java.util.HashMap<String, Map<String, Object>>() {
                              {
                                put(
                                        "foo",
                                        new java.util.HashMap<String, Object>() {
                                          {
                                            put("foo", "testString");
                                          }
                                        });
                              }
                            })
                    .add("foo", "testString")
                    .build();
    assertEquals(
            dialogNodeContextModel.getIntegrations(),
            new java.util.HashMap<String, Map<String, Object>>() {
              {
                put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
              }
            });
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
                    .parameters(
                            new java.util.HashMap<String, Object>() {
                              {
                                put("foo", "testString");
                              }
                            })
                    .resultVariable("testString")
                    .credentials("testString")
                    .build();
    assertEquals(dialogNodeActionModel.name(), "testString");
    assertEquals(dialogNodeActionModel.type(), "client");
    assertEquals(
            dialogNodeActionModel.parameters(),
            new java.util.HashMap<String, Object>() {
              {
                put("foo", "testString");
              }
            });
    assertEquals(dialogNodeActionModel.resultVariable(), "testString");
    assertEquals(dialogNodeActionModel.credentials(), "testString");

    UpdateDialogNode updateDialogNodeModel =
            new UpdateDialogNode.Builder()
                    .dialogNode("testString")
                    .description("testString")
                    .conditions("testString")
                    .parent("testString")
                    .previousSibling("testString")
                    .output(dialogNodeOutputModel)
                    .context(dialogNodeContextModel)
                    .metadata(
                            new java.util.HashMap<String, Object>() {
                              {
                                put("foo", "testString");
                              }
                            })
                    .nextStep(dialogNodeNextStepModel)
                    .title("testString")
                    .type("standard")
                    .eventName("focus")
                    .variable("testString")
                    .actions(
                            new java.util.ArrayList<DialogNodeAction>(
                                    java.util.Arrays.asList(dialogNodeActionModel)))
                    .digressIn("not_available")
                    .digressOut("allow_returning")
                    .digressOutSlots("not_allowed")
                    .userLabel("testString")
                    .disambiguationOptOut(true)
                    .build();
    assertEquals(updateDialogNodeModel.dialogNode(), "testString");
    assertEquals(updateDialogNodeModel.description(), "testString");
    assertEquals(updateDialogNodeModel.conditions(), "testString");
    assertEquals(updateDialogNodeModel.parent(), "testString");
    assertEquals(updateDialogNodeModel.previousSibling(), "testString");
    assertEquals(updateDialogNodeModel.output(), dialogNodeOutputModel);
    assertEquals(updateDialogNodeModel.context(), dialogNodeContextModel);
    assertEquals(
            updateDialogNodeModel.metadata(),
            new java.util.HashMap<String, Object>() {
              {
                put("foo", "testString");
              }
            });
    assertEquals(updateDialogNodeModel.nextStep(), dialogNodeNextStepModel);
    assertEquals(updateDialogNodeModel.title(), "testString");
    assertEquals(updateDialogNodeModel.type(), "standard");
    assertEquals(updateDialogNodeModel.eventName(), "focus");
    assertEquals(updateDialogNodeModel.variable(), "testString");
    assertEquals(
            updateDialogNodeModel.actions(),
            new java.util.ArrayList<DialogNodeAction>(java.util.Arrays.asList(dialogNodeActionModel)));
    assertEquals(updateDialogNodeModel.digressIn(), "not_available");
    assertEquals(updateDialogNodeModel.digressOut(), "allow_returning");
    assertEquals(updateDialogNodeModel.digressOutSlots(), "not_allowed");
    assertEquals(updateDialogNodeModel.userLabel(), "testString");
    assertEquals(updateDialogNodeModel.disambiguationOptOut(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(updateDialogNodeModel);

    UpdateDialogNode updateDialogNodeModelNew =
            TestUtilities.deserialize(json, UpdateDialogNode.class);
    assertTrue(updateDialogNodeModelNew instanceof UpdateDialogNode);
    assertEquals(updateDialogNodeModelNew.dialogNode(), "testString");
    assertEquals(updateDialogNodeModelNew.description(), "testString");
    assertEquals(updateDialogNodeModelNew.conditions(), "testString");
    assertEquals(updateDialogNodeModelNew.parent(), "testString");
    assertEquals(updateDialogNodeModelNew.previousSibling(), "testString");
    assertEquals(updateDialogNodeModelNew.output().toString(), dialogNodeOutputModel.toString());
    assertEquals(updateDialogNodeModelNew.context().toString(), dialogNodeContextModel.toString());
    assertEquals(
            updateDialogNodeModelNew.nextStep().toString(), dialogNodeNextStepModel.toString());
    assertEquals(updateDialogNodeModelNew.title(), "testString");
    assertEquals(updateDialogNodeModelNew.type(), "standard");
    assertEquals(updateDialogNodeModelNew.eventName(), "focus");
    assertEquals(updateDialogNodeModelNew.variable(), "testString");
    assertEquals(updateDialogNodeModelNew.digressIn(), "not_available");
    assertEquals(updateDialogNodeModelNew.digressOut(), "allow_returning");
    assertEquals(updateDialogNodeModelNew.digressOutSlots(), "not_allowed");
    assertEquals(updateDialogNodeModelNew.userLabel(), "testString");
    assertEquals(updateDialogNodeModelNew.disambiguationOptOut(), Boolean.valueOf(true));
  }

  @Test
  public void testUpdateDialogNodeNullable() throws Throwable {

    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
                    .responseType("search_skill")
                    .query("testString")
                    .queryType("natural_language")
                    .filter("testString")
                    .discoveryVersion("testString")
                    .build();

    DialogNodeOutputModifiers dialogNodeOutputModifiersModel =
            new DialogNodeOutputModifiers.Builder().overwrite(true).build();

    DialogNodeOutput dialogNodeOutputModel =
            new DialogNodeOutput.Builder()
                    .generic(
                            new java.util.ArrayList<DialogNodeOutputGeneric>(
                                    java.util.Arrays.asList(dialogNodeOutputGenericModel)))
                    .integrations(
                            new java.util.HashMap<String, Map<String, Object>>() {
                              {
                                put(
                                        "foo",
                                        new java.util.HashMap<String, Object>() {
                                          {
                                            put("foo", "testString");
                                          }
                                        });
                              }
                            })
                    .modifiers(dialogNodeOutputModifiersModel)
                    .add("foo", "testString")
                    .build();

    DialogNodeContext dialogNodeContextModel =
            new DialogNodeContext.Builder()
                    .integrations(
                            new java.util.HashMap<String, Map<String, Object>>() {
                              {
                                put(
                                        "foo",
                                        new java.util.HashMap<String, Object>() {
                                          {
                                            put("foo", "testString");
                                          }
                                        });
                              }
                            })
                    .add("foo", "testString")
                    .build();

    DialogNodeNextStep dialogNodeNextStepModel =
            new DialogNodeNextStep.Builder()
                    .behavior("get_user_input")
                    .dialogNode("testString")
                    .selector("condition")
                    .build();

    DialogNodeAction dialogNodeActionModel =
            new DialogNodeAction.Builder()
                    .name("testString")
                    .type("client")
                    .parameters(
                            new java.util.HashMap<String, Object>() {
                              {
                                put("foo", "testString");
                              }
                            })
                    .resultVariable("testString")
                    .credentials("testString")
                    .build();

    UpdateDialogNode updateDialogNodeModel =
            new UpdateDialogNode.Builder()
                    .dialogNode("testString")
                    .description("testString")
                    .conditions("testString")
                    .parent("testString")
                    .previousSibling("testString")
                    .output(dialogNodeOutputModel)
                    .context(dialogNodeContextModel)
                    .metadata(
                            new java.util.HashMap<String, Object>() {
                              {
                                put("foo", "testString");
                              }
                            })
                    .nextStep(dialogNodeNextStepModel)
                    .title("testString")
                    .type("standard")
                    .eventName("focus")
                    .variable("testString")
                    .actions(
                            new java.util.ArrayList<DialogNodeAction>(
                                    java.util.Arrays.asList(dialogNodeActionModel)))
                    .digressIn("not_available")
                    .digressOut("allow_returning")
                    .digressOutSlots("not_allowed")
                    .userLabel("testString")
                    .disambiguationOptOut(true)
                    .build();

    Map<String, Object> mergePatch = updateDialogNodeModel.asPatch();

    assertEquals(mergePatch.get("dialog_node"), "testString");
    assertEquals(mergePatch.get("description"), "testString");
    assertEquals(mergePatch.get("conditions"), "testString");
    assertEquals(mergePatch.get("parent"), "testString");
    assertEquals(mergePatch.get("previous_sibling"), "testString");
    assertTrue(mergePatch.containsKey("output"));
    assertTrue(mergePatch.containsKey("context"));
    assertTrue(mergePatch.containsKey("metadata"));
    assertTrue(mergePatch.containsKey("next_step"));
    assertEquals(mergePatch.get("title"), "testString");
    assertEquals(mergePatch.get("type"), "standard");
    assertEquals(mergePatch.get("event_name"), "focus");
    assertEquals(mergePatch.get("variable"), "testString");
    assertTrue(mergePatch.containsKey("actions"));
    assertEquals(mergePatch.get("digress_in"), "not_available");
    assertEquals(mergePatch.get("digress_out"), "allow_returning");
    assertEquals(mergePatch.get("digress_out_slots"), "not_allowed");
    assertEquals(mergePatch.get("user_label"), "testString");
    assertTrue(mergePatch.containsKey("disambiguation_opt_out"));
  }
}