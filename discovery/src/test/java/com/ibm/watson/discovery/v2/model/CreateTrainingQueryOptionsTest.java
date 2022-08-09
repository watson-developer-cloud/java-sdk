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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateTrainingQueryOptions model. */
public class CreateTrainingQueryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTrainingQueryOptions() throws Throwable {
    TrainingExample trainingExampleModel =
        new TrainingExample.Builder()
            .documentId("testString")
            .collectionId("testString")
            .relevance(Long.valueOf("26"))
            .build();
    assertEquals(trainingExampleModel.documentId(), "testString");
    assertEquals(trainingExampleModel.collectionId(), "testString");
    assertEquals(trainingExampleModel.relevance(), Long.valueOf("26"));

    CreateTrainingQueryOptions createTrainingQueryOptionsModel =
        new CreateTrainingQueryOptions.Builder()
            .projectId("testString")
            .naturalLanguageQuery("testString")
            .examples(java.util.Arrays.asList(trainingExampleModel))
            .filter("testString")
            .build();
    assertEquals(createTrainingQueryOptionsModel.projectId(), "testString");
    assertEquals(createTrainingQueryOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(
        createTrainingQueryOptionsModel.examples(), java.util.Arrays.asList(trainingExampleModel));
    assertEquals(createTrainingQueryOptionsModel.filter(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrainingQueryOptionsError() throws Throwable {
    new CreateTrainingQueryOptions.Builder().build();
  }
}
