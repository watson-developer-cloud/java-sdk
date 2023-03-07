/*
 * (C) Copyright IBM Corp. 2023.
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

/** Unit test class for the UpdateClassificationsModelOptions model. */
public class UpdateClassificationsModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateClassificationsModelOptions() throws Throwable {
    ClassificationsTrainingParameters classificationsTrainingParametersModel =
        new ClassificationsTrainingParameters.Builder().modelType("single_label").build();
    assertEquals(classificationsTrainingParametersModel.modelType(), "single_label");

    UpdateClassificationsModelOptions updateClassificationsModelOptionsModel =
        new UpdateClassificationsModelOptions.Builder()
            .modelId("testString")
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .userMetadata(java.util.Collections.singletonMap("foo", "unknown type: Object"))
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .trainingParameters(classificationsTrainingParametersModel)
            .build();
    assertEquals(updateClassificationsModelOptionsModel.modelId(), "testString");
    assertEquals(updateClassificationsModelOptionsModel.language(), "testString");
    assertEquals(
        IOUtils.toString(updateClassificationsModelOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(updateClassificationsModelOptionsModel.trainingDataContentType(), "json");
    assertEquals(updateClassificationsModelOptionsModel.name(), "testString");
    assertEquals(
        updateClassificationsModelOptionsModel.userMetadata(),
        java.util.Collections.singletonMap("foo", "unknown type: Object"));
    assertEquals(updateClassificationsModelOptionsModel.description(), "testString");
    assertEquals(updateClassificationsModelOptionsModel.modelVersion(), "testString");
    assertEquals(updateClassificationsModelOptionsModel.workspaceId(), "testString");
    assertEquals(updateClassificationsModelOptionsModel.versionDescription(), "testString");
    assertEquals(
        updateClassificationsModelOptionsModel.trainingParameters(),
        classificationsTrainingParametersModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClassificationsModelOptionsError() throws Throwable {
    new UpdateClassificationsModelOptions.Builder().build();
  }
}
