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

/** Unit test class for the UpdateDialogNodeOptions model. */
public class UpdateDialogNodeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateDialogNodeOptions() throws Throwable {
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

    UpdateDialogNodeOptions updateDialogNodeOptionsModel =
        new UpdateDialogNodeOptions.Builder()
            .workspaceId("testString")
            .dialogNode("testString")
            .newDialogNode("testString")
            .newDescription("testString")
            .newConditions("testString")
            .newParent("testString")
            .newPreviousSibling("testString")
            .newOutput(dialogNodeOutputModel)
            .newContext(dialogNodeContextModel)
            .newMetadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .newNextStep(dialogNodeNextStepModel)
            .newTitle("testString")
            .newType("standard")
            .newEventName("focus")
            .newVariable("testString")
            .newActions(
                new java.util.ArrayList<DialogNodeAction>(
                    java.util.Arrays.asList(dialogNodeActionModel)))
            .newDigressIn("not_available")
            .newDigressOut("allow_returning")
            .newDigressOutSlots("not_allowed")
            .newUserLabel("testString")
            .newDisambiguationOptOut(true)
            .includeAudit(true)
            .build();
    assertEquals(updateDialogNodeOptionsModel.workspaceId(), "testString");
    assertEquals(updateDialogNodeOptionsModel.dialogNode(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newDialogNode(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newDescription(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newConditions(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newParent(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newPreviousSibling(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newOutput(), dialogNodeOutputModel);
    assertEquals(updateDialogNodeOptionsModel.newContext(), dialogNodeContextModel);
    assertEquals(
        updateDialogNodeOptionsModel.newMetadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(updateDialogNodeOptionsModel.newNextStep(), dialogNodeNextStepModel);
    assertEquals(updateDialogNodeOptionsModel.newTitle(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newType(), "standard");
    assertEquals(updateDialogNodeOptionsModel.newEventName(), "focus");
    assertEquals(updateDialogNodeOptionsModel.newVariable(), "testString");
    assertEquals(
        updateDialogNodeOptionsModel.newActions(),
        new java.util.ArrayList<DialogNodeAction>(java.util.Arrays.asList(dialogNodeActionModel)));
    assertEquals(updateDialogNodeOptionsModel.newDigressIn(), "not_available");
    assertEquals(updateDialogNodeOptionsModel.newDigressOut(), "allow_returning");
    assertEquals(updateDialogNodeOptionsModel.newDigressOutSlots(), "not_allowed");
    assertEquals(updateDialogNodeOptionsModel.newUserLabel(), "testString");
    assertEquals(updateDialogNodeOptionsModel.newDisambiguationOptOut(), Boolean.valueOf(true));
    assertEquals(updateDialogNodeOptionsModel.includeAudit(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDialogNodeOptionsError() throws Throwable {
    new UpdateDialogNodeOptions.Builder().build();
  }
}
