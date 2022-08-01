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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill()
      throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder()
                .responseType("search_skill")
                .query("testString")
                .queryType("natural_language")
                .filter("testString")
                .discoveryVersion("2018-12-03")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.responseType(),
        "search_skill");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.query(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.queryType(),
        "natural_language");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.filter(), "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.discoveryVersion(),
        "2018-12-03");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(
            dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew.responseType(),
        "search_skill");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew.query(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew.queryType(),
        "natural_language");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew.filter(),
        "testString");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillModelNew.discoveryVersion(),
        "2018-12-03");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkillError()
      throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.Builder().build();
  }
}
