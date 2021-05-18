/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** Unit test class for the CreateDialogNodeOptions model. */
public class CreateDialogNodeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateDialogNodeOptions() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill dialogNodeOutputGenericModel =
        new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
            .responseType("search_skill")
            .query("testString")
            .queryType("natural_language")
            .filter("testString")
            .discoveryVersion("testString")
            .channels(
                new java.util.ArrayList<ResponseGenericChannel>(
                    java.util.Arrays.asList(responseGenericChannelModel)))
            .build();
    assertEquals(dialogNodeOutputGenericModel.responseType(), "search_skill");
    assertEquals(dialogNodeOutputGenericModel.query(), "testString");
    assertEquals(dialogNodeOutputGenericModel.queryType(), "natural_language");
    assertEquals(dialogNodeOutputGenericModel.filter(), "testString");
    assertEquals(dialogNodeOutputGenericModel.discoveryVersion(), "testString");
    assertEquals(
        dialogNodeOutputGenericModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));

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

    CreateDialogNodeOptions createDialogNodeOptionsModel =
        new CreateDialogNodeOptions.Builder()
            .workspaceId("testString")
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
            .includeAudit(true)
            .build();
    assertEquals(createDialogNodeOptionsModel.workspaceId(), "testString");
    assertEquals(createDialogNodeOptionsModel.dialogNode(), "testString");
    assertEquals(createDialogNodeOptionsModel.description(), "testString");
    assertEquals(createDialogNodeOptionsModel.conditions(), "testString");
    assertEquals(createDialogNodeOptionsModel.parent(), "testString");
    assertEquals(createDialogNodeOptionsModel.previousSibling(), "testString");
    assertEquals(createDialogNodeOptionsModel.output(), dialogNodeOutputModel);
    assertEquals(createDialogNodeOptionsModel.context(), dialogNodeContextModel);
    assertEquals(
        createDialogNodeOptionsModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createDialogNodeOptionsModel.nextStep(), dialogNodeNextStepModel);
    assertEquals(createDialogNodeOptionsModel.title(), "testString");
    assertEquals(createDialogNodeOptionsModel.type(), "standard");
    assertEquals(createDialogNodeOptionsModel.eventName(), "focus");
    assertEquals(createDialogNodeOptionsModel.variable(), "testString");
    assertEquals(
        createDialogNodeOptionsModel.actions(),
        new java.util.ArrayList<DialogNodeAction>(java.util.Arrays.asList(dialogNodeActionModel)));
    assertEquals(createDialogNodeOptionsModel.digressIn(), "not_available");
    assertEquals(createDialogNodeOptionsModel.digressOut(), "allow_returning");
    assertEquals(createDialogNodeOptionsModel.digressOutSlots(), "not_allowed");
    assertEquals(createDialogNodeOptionsModel.userLabel(), "testString");
    assertEquals(createDialogNodeOptionsModel.disambiguationOptOut(), Boolean.valueOf(true));
    assertEquals(createDialogNodeOptionsModel.includeAudit(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDialogNodeOptionsError() throws Throwable {
    new CreateDialogNodeOptions.Builder().build();
  }
}
