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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CaptureGroup model. */
public class CaptureGroupTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCaptureGroup() throws Throwable {
    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();
    assertEquals(captureGroupModel.group(), "testString");
    assertEquals(captureGroupModel.location(), java.util.Arrays.asList(Long.valueOf("26")));

    String json = TestUtilities.serialize(captureGroupModel);

    CaptureGroup captureGroupModelNew = TestUtilities.deserialize(json, CaptureGroup.class);
    assertTrue(captureGroupModelNew instanceof CaptureGroup);
    assertEquals(captureGroupModelNew.group(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCaptureGroupError() throws Throwable {
    new CaptureGroup.Builder().build();
  }
}
