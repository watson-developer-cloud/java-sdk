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

/** Unit test class for the CreateClassificationsModelOptions model. */
public class CreateClassificationsModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateClassificationsModelOptions() throws Throwable {
    ClassificationsTrainingParameters classificationsTrainingParametersModel =
        new ClassificationsTrainingParameters.Builder().modelType("single_label").build();
    assertEquals(classificationsTrainingParametersModel.modelType(), "single_label");

    CreateClassificationsModelOptions createClassificationsModelOptionsModel =
        new CreateClassificationsModelOptions.Builder()
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
    assertEquals(createClassificationsModelOptionsModel.language(), "testString");
    assertEquals(
        IOUtils.toString(createClassificationsModelOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createClassificationsModelOptionsModel.trainingDataContentType(), "json");
    assertEquals(createClassificationsModelOptionsModel.name(), "testString");
    assertEquals(
        createClassificationsModelOptionsModel.userMetadata(),
        java.util.Collections.singletonMap("foo", "unknown type: Object"));
    assertEquals(createClassificationsModelOptionsModel.description(), "testString");
    assertEquals(createClassificationsModelOptionsModel.modelVersion(), "testString");
    assertEquals(createClassificationsModelOptionsModel.workspaceId(), "testString");
    assertEquals(createClassificationsModelOptionsModel.versionDescription(), "testString");
    assertEquals(
        createClassificationsModelOptionsModel.trainingParameters(),
        classificationsTrainingParametersModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClassificationsModelOptionsError() throws Throwable {
    new CreateClassificationsModelOptions.Builder().build();
  }
}
