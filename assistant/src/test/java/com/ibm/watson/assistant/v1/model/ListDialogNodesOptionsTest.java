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

/** Unit test class for the ListDialogNodesOptions model. */
public class ListDialogNodesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListDialogNodesOptions() throws Throwable {
    ListDialogNodesOptions listDialogNodesOptionsModel =
        new ListDialogNodesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("dialog_node")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listDialogNodesOptionsModel.workspaceId(), "testString");
    assertEquals(listDialogNodesOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listDialogNodesOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listDialogNodesOptionsModel.sort(), "dialog_node");
    assertEquals(listDialogNodesOptionsModel.cursor(), "testString");
    assertEquals(listDialogNodesOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDialogNodesOptionsError() throws Throwable {
    new ListDialogNodesOptions.Builder().build();
  }
}
