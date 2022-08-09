/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

/** Unit test class for the DialogNodeOutputGenericDialogNodeOutputResponseTypePause model. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypePauseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypePause() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    DialogNodeOutputGenericDialogNodeOutputResponseTypePause
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel =
            new DialogNodeOutputGenericDialogNodeOutputResponseTypePause.Builder()
                .responseType("pause")
                .time(Long.valueOf("26"))
                .typing(true)
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel.responseType(), "pause");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel.time(), Long.valueOf("26"));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel.typing(),
        Boolean.valueOf(true));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json =
        TestUtilities.serialize(dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModel);

    DialogNodeOutputGenericDialogNodeOutputResponseTypePause
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModelNew =
            TestUtilities.deserialize(
                json, DialogNodeOutputGenericDialogNodeOutputResponseTypePause.class);
    assertTrue(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModelNew
            instanceof DialogNodeOutputGenericDialogNodeOutputResponseTypePause);
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModelNew.responseType(), "pause");
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModelNew.time(),
        Long.valueOf("26"));
    assertEquals(
        dialogNodeOutputGenericDialogNodeOutputResponseTypePauseModelNew.typing(),
        Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDialogNodeOutputGenericDialogNodeOutputResponseTypePauseError() throws Throwable {
    new DialogNodeOutputGenericDialogNodeOutputResponseTypePause.Builder().build();
  }
}
