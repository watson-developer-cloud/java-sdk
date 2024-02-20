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

/** Unit test class for the ListWorkspacesOptions model. */
public class ListWorkspacesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListWorkspacesOptions() throws Throwable {
    ListWorkspacesOptions listWorkspacesOptionsModel =
        new ListWorkspacesOptions.Builder()
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("name")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listWorkspacesOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listWorkspacesOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listWorkspacesOptionsModel.sort(), "name");
    assertEquals(listWorkspacesOptionsModel.cursor(), "testString");
    assertEquals(listWorkspacesOptionsModel.includeAudit(), Boolean.valueOf(false));
  }
}
