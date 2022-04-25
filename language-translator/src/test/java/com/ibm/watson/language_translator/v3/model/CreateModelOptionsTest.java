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

package com.ibm.watson.language_translator.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.language_translator.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CreateModelOptions model. */
public class CreateModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateModelOptions() throws Throwable {
    CreateModelOptions createModelOptionsModel =
        new CreateModelOptions.Builder()
            .baseModelId("testString")
            .forcedGlossary(TestUtilities.createMockStream("This is a mock file."))
            .forcedGlossaryContentType("application/x-tmx+xml")
            .parallelCorpus(TestUtilities.createMockStream("This is a mock file."))
            .parallelCorpusContentType("application/x-tmx+xml")
            .name("testString")
            .build();
    assertEquals(createModelOptionsModel.baseModelId(), "testString");
    assertEquals(
        IOUtils.toString(createModelOptionsModel.forcedGlossary()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createModelOptionsModel.forcedGlossaryContentType(), "application/x-tmx+xml");
    assertEquals(
        IOUtils.toString(createModelOptionsModel.parallelCorpus()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createModelOptionsModel.parallelCorpusContentType(), "application/x-tmx+xml");
    assertEquals(createModelOptionsModel.name(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateModelOptionsError() throws Throwable {
    new CreateModelOptions.Builder().build();
  }
}
