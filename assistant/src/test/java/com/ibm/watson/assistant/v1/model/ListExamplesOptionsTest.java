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

/** Unit test class for the ListExamplesOptions model. */
public class ListExamplesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListExamplesOptions() throws Throwable {
    ListExamplesOptions listExamplesOptionsModel =
        new ListExamplesOptions.Builder()
            .workspaceId("testString")
            .intent("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("text")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listExamplesOptionsModel.workspaceId(), "testString");
    assertEquals(listExamplesOptionsModel.intent(), "testString");
    assertEquals(listExamplesOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listExamplesOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listExamplesOptionsModel.sort(), "text");
    assertEquals(listExamplesOptionsModel.cursor(), "testString");
    assertEquals(listExamplesOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListExamplesOptionsError() throws Throwable {
    new ListExamplesOptions.Builder().build();
  }
}
