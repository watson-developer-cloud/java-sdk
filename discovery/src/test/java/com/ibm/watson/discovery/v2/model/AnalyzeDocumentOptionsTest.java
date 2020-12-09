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

/** Unit test class for the AnalyzeDocumentOptions model. */
public class AnalyzeDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAnalyzeDocumentOptions() throws Throwable {
    AnalyzeDocumentOptions analyzeDocumentOptionsModel =
        new AnalyzeDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .build();
    assertEquals(analyzeDocumentOptionsModel.projectId(), "testString");
    assertEquals(analyzeDocumentOptionsModel.collectionId(), "testString");
    assertEquals(
        IOUtils.toString(analyzeDocumentOptionsModel.file()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(analyzeDocumentOptionsModel.filename(), "testString");
    assertEquals(analyzeDocumentOptionsModel.fileContentType(), "application/json");
    assertEquals(analyzeDocumentOptionsModel.metadata(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeDocumentOptionsError() throws Throwable {
    new AnalyzeDocumentOptions.Builder().build();
  }
}
