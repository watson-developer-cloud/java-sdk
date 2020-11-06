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

package com.ibm.watson.natural_language_classifier.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_classifier.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the ClassifyCollectionOptions model. */
public class ClassifyCollectionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testClassifyCollectionOptions() throws Throwable {
    ClassifyInput classifyInputModel =
        new ClassifyInput.Builder().text("How hot will it be today?").build();
    assertEquals(classifyInputModel.text(), "How hot will it be today?");

    ClassifyCollectionOptions classifyCollectionOptionsModel =
        new ClassifyCollectionOptions.Builder()
            .classifierId("testString")
            .collection(
                new java.util.ArrayList<ClassifyInput>(java.util.Arrays.asList(classifyInputModel)))
            .build();
    assertEquals(classifyCollectionOptionsModel.classifierId(), "testString");
    assertEquals(
        classifyCollectionOptionsModel.collection(),
        new java.util.ArrayList<ClassifyInput>(java.util.Arrays.asList(classifyInputModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testClassifyCollectionOptionsError() throws Throwable {
    new ClassifyCollectionOptions.Builder().build();
  }
}
