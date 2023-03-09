/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

package com.ibm.watson.language_translator.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.language_translator.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the TranslateDocumentOptions model. */
public class TranslateDocumentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTranslateDocumentOptions() throws Throwable {
    TranslateDocumentOptions translateDocumentOptionsModel =
        new TranslateDocumentOptions.Builder()
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/mspowerpoint")
            .modelId("testString")
            .source("testString")
            .target("testString")
            .documentId("testString")
            .build();
    assertEquals(
        IOUtils.toString(translateDocumentOptionsModel.file()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(translateDocumentOptionsModel.filename(), "testString");
    assertEquals(translateDocumentOptionsModel.fileContentType(), "application/mspowerpoint");
    assertEquals(translateDocumentOptionsModel.modelId(), "testString");
    assertEquals(translateDocumentOptionsModel.source(), "testString");
    assertEquals(translateDocumentOptionsModel.target(), "testString");
    assertEquals(translateDocumentOptionsModel.documentId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTranslateDocumentOptionsError() throws Throwable {
    new TranslateDocumentOptions.Builder().build();
  }
}
