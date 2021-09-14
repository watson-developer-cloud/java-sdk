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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the UpdateDocumentOptions model. */
public class UpdateDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateDocumentOptions() throws Throwable {
    UpdateDocumentOptions updateDocumentOptionsModel =
        new UpdateDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .documentId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .xWatsonDiscoveryForce(false)
            .build();
    assertEquals(updateDocumentOptionsModel.projectId(), "testString");
    assertEquals(updateDocumentOptionsModel.collectionId(), "testString");
    assertEquals(updateDocumentOptionsModel.documentId(), "testString");
    assertEquals(
        IOUtils.toString(updateDocumentOptionsModel.file()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(updateDocumentOptionsModel.filename(), "testString");
    assertEquals(updateDocumentOptionsModel.fileContentType(), "application/json");
    assertEquals(updateDocumentOptionsModel.metadata(), "testString");
    assertEquals(updateDocumentOptionsModel.xWatsonDiscoveryForce(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentOptionsError() throws Throwable {
    new UpdateDocumentOptions.Builder().build();
  }
}
