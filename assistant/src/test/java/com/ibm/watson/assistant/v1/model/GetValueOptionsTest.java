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
import org.testng.annotations.Test;

/** Unit test class for the GetValueOptions model. */
public class GetValueOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetValueOptions() throws Throwable {
    GetValueOptions getValueOptionsModel =
        new GetValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .export(false)
            .includeAudit(false)
            .build();
    assertEquals(getValueOptionsModel.workspaceId(), "testString");
    assertEquals(getValueOptionsModel.entity(), "testString");
    assertEquals(getValueOptionsModel.value(), "testString");
    assertEquals(getValueOptionsModel.export(), Boolean.valueOf(false));
    assertEquals(getValueOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetValueOptionsError() throws Throwable {
    new GetValueOptions.Builder().build();
  }
}
