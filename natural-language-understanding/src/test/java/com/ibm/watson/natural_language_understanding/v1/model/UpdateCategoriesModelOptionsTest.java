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

package com.ibm.watson.natural_language_understanding.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the UpdateCategoriesModelOptions model. */
public class UpdateCategoriesModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateCategoriesModelOptions() throws Throwable {
    UpdateCategoriesModelOptions updateCategoriesModelOptionsModel =
        new UpdateCategoriesModelOptions.Builder()
            .modelId("testString")
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .userMetadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", TestUtilities.createMockMap());
                  }
                })
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();
    assertEquals(updateCategoriesModelOptionsModel.modelId(), "testString");
    assertEquals(updateCategoriesModelOptionsModel.language(), "testString");
    assertEquals(
        IOUtils.toString(updateCategoriesModelOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(updateCategoriesModelOptionsModel.trainingDataContentType(), "json");
    assertEquals(updateCategoriesModelOptionsModel.name(), "testString");
    assertEquals(
        updateCategoriesModelOptionsModel.userMetadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", TestUtilities.createMockMap());
          }
        });
    assertEquals(updateCategoriesModelOptionsModel.description(), "testString");
    assertEquals(updateCategoriesModelOptionsModel.modelVersion(), "testString");
    assertEquals(updateCategoriesModelOptionsModel.workspaceId(), "testString");
    assertEquals(updateCategoriesModelOptionsModel.versionDescription(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCategoriesModelOptionsError() throws Throwable {
    new UpdateCategoriesModelOptions.Builder().build();
  }
}
