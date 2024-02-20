/*
 * (C) Copyright IBM Corp. 2024.
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

/** Unit test class for the CreateDocumentClassifierModelOptions model. */
public class CreateDocumentClassifierModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateDocumentClassifierModelOptions() throws Throwable {
    CreateDocumentClassifierModelOptions createDocumentClassifierModelOptionsModel =
        new CreateDocumentClassifierModelOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .name("testString")
            .description("testString")
            .learningRate(Double.valueOf("0.1"))
            .l1RegularizationStrengths(java.util.Arrays.asList(Double.valueOf("1.0E-6")))
            .l2RegularizationStrengths(java.util.Arrays.asList(Double.valueOf("1.0E-6")))
            .trainingMaxSteps(Long.valueOf("10000000"))
            .improvementRatio(Double.valueOf("0.000010"))
            .build();
    assertEquals(createDocumentClassifierModelOptionsModel.projectId(), "testString");
    assertEquals(createDocumentClassifierModelOptionsModel.classifierId(), "testString");
    assertEquals(createDocumentClassifierModelOptionsModel.name(), "testString");
    assertEquals(createDocumentClassifierModelOptionsModel.description(), "testString");
    assertEquals(createDocumentClassifierModelOptionsModel.learningRate(), Double.valueOf("0.1"));
    assertEquals(
        createDocumentClassifierModelOptionsModel.l1RegularizationStrengths(),
        java.util.Arrays.asList(Double.valueOf("1.0E-6")));
    assertEquals(
        createDocumentClassifierModelOptionsModel.l2RegularizationStrengths(),
        java.util.Arrays.asList(Double.valueOf("1.0E-6")));
    assertEquals(
        createDocumentClassifierModelOptionsModel.trainingMaxSteps(), Long.valueOf("10000000"));
    assertEquals(
        createDocumentClassifierModelOptionsModel.improvementRatio(), Double.valueOf("0.000010"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDocumentClassifierModelOptionsError() throws Throwable {
    new CreateDocumentClassifierModelOptions.Builder().build();
  }
}
