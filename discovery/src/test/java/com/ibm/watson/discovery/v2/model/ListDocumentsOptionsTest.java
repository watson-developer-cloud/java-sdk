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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the ListDocumentsOptions model. */
public class ListDocumentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListDocumentsOptions() throws Throwable {
    ListDocumentsOptions listDocumentsOptionsModel =
        new ListDocumentsOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .count(Long.valueOf("1000"))
            .status("testString")
            .hasNotices(true)
            .isParent(true)
            .parentDocumentId("testString")
            .sha256("testString")
            .build();
    assertEquals(listDocumentsOptionsModel.projectId(), "testString");
    assertEquals(listDocumentsOptionsModel.collectionId(), "testString");
    assertEquals(listDocumentsOptionsModel.count(), Long.valueOf("1000"));
    assertEquals(listDocumentsOptionsModel.status(), "testString");
    assertEquals(listDocumentsOptionsModel.hasNotices(), Boolean.valueOf(true));
    assertEquals(listDocumentsOptionsModel.isParent(), Boolean.valueOf(true));
    assertEquals(listDocumentsOptionsModel.parentDocumentId(), "testString");
    assertEquals(listDocumentsOptionsModel.sha256(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDocumentsOptionsError() throws Throwable {
    new ListDocumentsOptions.Builder().build();
  }
}
