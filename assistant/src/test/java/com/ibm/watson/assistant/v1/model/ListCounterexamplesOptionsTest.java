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

/** Unit test class for the ListCounterexamplesOptions model. */
public class ListCounterexamplesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListCounterexamplesOptions() throws Throwable {
    ListCounterexamplesOptions listCounterexamplesOptionsModel =
        new ListCounterexamplesOptions.Builder()
            .workspaceId("testString")
            .pageLimit(Long.valueOf("100"))
            .includeCount(false)
            .sort("text")
            .cursor("testString")
            .includeAudit(false)
            .build();
    assertEquals(listCounterexamplesOptionsModel.workspaceId(), "testString");
    assertEquals(listCounterexamplesOptionsModel.pageLimit(), Long.valueOf("100"));
    assertEquals(listCounterexamplesOptionsModel.includeCount(), Boolean.valueOf(false));
    assertEquals(listCounterexamplesOptionsModel.sort(), "text");
    assertEquals(listCounterexamplesOptionsModel.cursor(), "testString");
    assertEquals(listCounterexamplesOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCounterexamplesOptionsError() throws Throwable {
    new ListCounterexamplesOptions.Builder().build();
  }
}
