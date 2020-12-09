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

package com.ibm.watson.visual_recognition.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the ClassifyOptions model. */
public class ClassifyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testClassifyOptions() throws Throwable {
    ClassifyOptions classifyOptionsModel =
        new ClassifyOptions.Builder()
            .imagesFile(TestUtilities.createMockStream("This is a mock file."))
            .imagesFilename("testString")
            .imagesFileContentType("testString")
            .url("testString")
            .threshold(Float.valueOf("36.0"))
            .owners(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .classifierIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .acceptLanguage("en")
            .build();
    assertEquals(
        IOUtils.toString(classifyOptionsModel.imagesFile()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(classifyOptionsModel.imagesFilename(), "testString");
    assertEquals(classifyOptionsModel.imagesFileContentType(), "testString");
    assertEquals(classifyOptionsModel.url(), "testString");
    assertEquals(classifyOptionsModel.threshold(), Float.valueOf("36.0"));
    assertEquals(
        classifyOptionsModel.owners(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        classifyOptionsModel.classifierIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(classifyOptionsModel.acceptLanguage(), "en");
  }
}
