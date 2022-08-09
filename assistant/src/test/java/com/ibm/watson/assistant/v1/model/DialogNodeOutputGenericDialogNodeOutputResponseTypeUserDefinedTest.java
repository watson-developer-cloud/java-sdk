/*
 * (C) Copyright IBM Corp. 2021, 2022.
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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined()
      throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.Builder()
                .responseType("user_defined")
                .userDefined(
                    new java.util.HashMap<String, Object>() {
                      {
                        put("foo", "testString");
                      }
                    })
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModel.responseType(),
        "user_defined");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModel.userDefined(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(
            dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedModelNew.responseType(),
        "user_defined");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefinedError()
      throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.Builder().build();
  }
}
