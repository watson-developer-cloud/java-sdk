/*
 * (C) Copyright IBM Corp. 2021, 2024.
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

package com.ibm.watson.natural_language_understanding.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CreateCategoriesModelOptions model. */
public class CreateCategoriesModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateCategoriesModelOptions() throws Throwable {
    CreateCategoriesModelOptions createCategoriesModelOptionsModel =
        new CreateCategoriesModelOptions.Builder()
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .userMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();
    assertEquals(createCategoriesModelOptionsModel.language(), "testString");
    assertEquals(
        IOUtils.toString(createCategoriesModelOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createCategoriesModelOptionsModel.trainingDataContentType(), "json");
    assertEquals(createCategoriesModelOptionsModel.name(), "testString");
    assertEquals(
        createCategoriesModelOptionsModel.userMetadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createCategoriesModelOptionsModel.description(), "testString");
    assertEquals(createCategoriesModelOptionsModel.modelVersion(), "testString");
    assertEquals(createCategoriesModelOptionsModel.workspaceId(), "testString");
    assertEquals(createCategoriesModelOptionsModel.versionDescription(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCategoriesModelOptionsError() throws Throwable {
    new CreateCategoriesModelOptions.Builder().build();
  }
}
