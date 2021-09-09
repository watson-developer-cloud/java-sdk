/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.watson.compare_comply.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.compare_comply.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CompareDocumentsOptions model. */
public class CompareDocumentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCompareDocumentsOptions() throws Throwable {
    CompareDocumentsOptions compareDocumentsOptionsModel =
        new CompareDocumentsOptions.Builder()
            .file1(TestUtilities.createMockStream("This is a mock file."))
            .file2(TestUtilities.createMockStream("This is a mock file."))
            .file1ContentType("application/pdf")
            .file2ContentType("application/pdf")
            .file1Label("file_1")
            .file2Label("file_2")
            .model("contracts")
            .build();
    assertEquals(
        IOUtils.toString(compareDocumentsOptionsModel.file1()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(
        IOUtils.toString(compareDocumentsOptionsModel.file2()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(compareDocumentsOptionsModel.file1ContentType(), "application/pdf");
    assertEquals(compareDocumentsOptionsModel.file2ContentType(), "application/pdf");
    assertEquals(compareDocumentsOptionsModel.file1Label(), "file_1");
    assertEquals(compareDocumentsOptionsModel.file2Label(), "file_2");
    assertEquals(compareDocumentsOptionsModel.model(), "contracts");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCompareDocumentsOptionsError() throws Throwable {
    new CompareDocumentsOptions.Builder().build();
  }
}
