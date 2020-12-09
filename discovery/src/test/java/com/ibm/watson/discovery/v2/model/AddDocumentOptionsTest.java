/*
 * (C) Copyright IBM Corp. 2020.
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

/** Unit test class for the AddDocumentOptions model. */
public class AddDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddDocumentOptions() throws Throwable {
    AddDocumentOptions addDocumentOptionsModel =
        new AddDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .xWatsonDiscoveryForce(true)
            .build();
    assertEquals(addDocumentOptionsModel.projectId(), "testString");
    assertEquals(addDocumentOptionsModel.collectionId(), "testString");
    assertEquals(
        IOUtils.toString(addDocumentOptionsModel.file()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(addDocumentOptionsModel.filename(), "testString");
    assertEquals(addDocumentOptionsModel.fileContentType(), "application/json");
    assertEquals(addDocumentOptionsModel.metadata(), "testString");
    assertEquals(addDocumentOptionsModel.xWatsonDiscoveryForce(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDocumentOptionsError() throws Throwable {
    new AddDocumentOptions.Builder().build();
  }
}
