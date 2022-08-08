/*
 * (C) Copyright IBM Corp. 2022.
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
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CreateDocumentClassifierOptions model. */
public class CreateDocumentClassifierOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateDocumentClassifierOptions() throws Throwable {
    DocumentClassifierEnrichment documentClassifierEnrichmentModel =
        new DocumentClassifierEnrichment.Builder()
            .enrichmentId("testString")
            .fields(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(documentClassifierEnrichmentModel.enrichmentId(), "testString");
    assertEquals(documentClassifierEnrichmentModel.fields(), java.util.Arrays.asList("testString"));

    ClassifierFederatedModel classifierFederatedModelModel =
        new ClassifierFederatedModel.Builder().field("testString").build();
    assertEquals(classifierFederatedModelModel.field(), "testString");

    CreateDocumentClassifier createDocumentClassifierModel =
        new CreateDocumentClassifier.Builder()
            .name("testString")
            .description("testString")
            .language("en")
            .answerField("testString")
            .enrichments(java.util.Arrays.asList(documentClassifierEnrichmentModel))
            .federatedClassification(classifierFederatedModelModel)
            .build();
    assertEquals(createDocumentClassifierModel.name(), "testString");
    assertEquals(createDocumentClassifierModel.description(), "testString");
    assertEquals(createDocumentClassifierModel.language(), "en");
    assertEquals(createDocumentClassifierModel.answerField(), "testString");
    assertEquals(
        createDocumentClassifierModel.enrichments(),
        java.util.Arrays.asList(documentClassifierEnrichmentModel));
    assertEquals(
        createDocumentClassifierModel.federatedClassification(), classifierFederatedModelModel);

    CreateDocumentClassifierOptions createDocumentClassifierOptionsModel =
        new CreateDocumentClassifierOptions.Builder()
            .projectId("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .classifier(createDocumentClassifierModel)
            .testData(TestUtilities.createMockStream("This is a mock file."))
            .build();
    assertEquals(createDocumentClassifierOptionsModel.projectId(), "testString");
    assertEquals(
        IOUtils.toString(createDocumentClassifierOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createDocumentClassifierOptionsModel.classifier(), createDocumentClassifierModel);
    assertEquals(
        IOUtils.toString(createDocumentClassifierOptionsModel.testData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDocumentClassifierOptionsError() throws Throwable {
    new CreateDocumentClassifierOptions.Builder().build();
  }
}
