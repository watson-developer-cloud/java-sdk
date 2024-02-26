/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

/** Unit test class for the ListEntitiesOptions model. */
public class ListEntitiesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListEntitiesOptions() throws Throwable {
    ListEntitiesOptions listEntitiesOptionsModel =
        new ListEntitiesOptions.Builder()
            .workspaceId("testString")
            .export(false)
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("entity")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listEntitiesOptionsModel.workspaceId(), "testString");
    assertEquals(listEntitiesOptionsModel.export(), Boolean.valueOf(false));
    assertEquals(listEntitiesOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listEntitiesOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listEntitiesOptionsModel.sort(), "entity");
    assertEquals(listEntitiesOptionsModel.cursor(), "testString");
    assertEquals(listEntitiesOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEntitiesOptionsError() throws Throwable {
    new ListEntitiesOptions.Builder().build();
  }
}
