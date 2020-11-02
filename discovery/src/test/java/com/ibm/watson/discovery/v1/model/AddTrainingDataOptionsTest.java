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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the AddTrainingDataOptions model. */
public class AddTrainingDataOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddTrainingDataOptions() throws Throwable {
    TrainingExample trainingExampleModel =
        new TrainingExample.Builder()
            .documentId("testString")
            .crossReference("testString")
            .relevance(Long.valueOf("26"))
            .build();
    assertEquals(trainingExampleModel.documentId(), "testString");
    assertEquals(trainingExampleModel.crossReference(), "testString");
    assertEquals(trainingExampleModel.relevance(), Long.valueOf("26"));

    AddTrainingDataOptions addTrainingDataOptionsModel =
        new AddTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .naturalLanguageQuery("testString")
            .filter("testString")
            .examples(
                new java.util.ArrayList<TrainingExample>(
                    java.util.Arrays.asList(trainingExampleModel)))
            .build();
    assertEquals(addTrainingDataOptionsModel.environmentId(), "testString");
    assertEquals(addTrainingDataOptionsModel.collectionId(), "testString");
    assertEquals(addTrainingDataOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(addTrainingDataOptionsModel.filter(), "testString");
    assertEquals(
        addTrainingDataOptionsModel.examples(),
        new java.util.ArrayList<TrainingExample>(java.util.Arrays.asList(trainingExampleModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddTrainingDataOptionsError() throws Throwable {
    new AddTrainingDataOptions.Builder().build();
  }
}
