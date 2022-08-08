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

/** Unit test class for the UpdateDocumentClassifierOptions model. */
public class UpdateDocumentClassifierOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateDocumentClassifierOptions() throws Throwable {
    UpdateDocumentClassifier updateDocumentClassifierModel =
        new UpdateDocumentClassifier.Builder().name("testString").description("testString").build();
    assertEquals(updateDocumentClassifierModel.name(), "testString");
    assertEquals(updateDocumentClassifierModel.description(), "testString");

    UpdateDocumentClassifierOptions updateDocumentClassifierOptionsModel =
        new UpdateDocumentClassifierOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .classifier(updateDocumentClassifierModel)
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .testData(TestUtilities.createMockStream("This is a mock file."))
            .build();
    assertEquals(updateDocumentClassifierOptionsModel.projectId(), "testString");
    assertEquals(updateDocumentClassifierOptionsModel.classifierId(), "testString");
    assertEquals(updateDocumentClassifierOptionsModel.classifier(), updateDocumentClassifierModel);
    assertEquals(
        IOUtils.toString(updateDocumentClassifierOptionsModel.trainingData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(
        IOUtils.toString(updateDocumentClassifierOptionsModel.testData()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentClassifierOptionsError() throws Throwable {
    new UpdateDocumentClassifierOptions.Builder().build();
  }
}
