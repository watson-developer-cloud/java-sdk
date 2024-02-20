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

/** Unit test class for the ListSynonymsOptions model. */
public class ListSynonymsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListSynonymsOptions() throws Throwable {
    ListSynonymsOptions listSynonymsOptionsModel =
        new ListSynonymsOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("synonym")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listSynonymsOptionsModel.workspaceId(), "testString");
    assertEquals(listSynonymsOptionsModel.entity(), "testString");
    assertEquals(listSynonymsOptionsModel.value(), "testString");
    assertEquals(listSynonymsOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listSynonymsOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listSynonymsOptionsModel.sort(), "synonym");
    assertEquals(listSynonymsOptionsModel.cursor(), "testString");
    assertEquals(listSynonymsOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSynonymsOptionsError() throws Throwable {
    new ListSynonymsOptions.Builder().build();
  }
}
