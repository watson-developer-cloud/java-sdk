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

package com.ibm.watson.visual_recognition.v4.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v4.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the AddImagesOptions model. */
public class AddImagesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddImagesOptions() throws Throwable {
    AddImagesOptions addImagesOptionsModel =
        new AddImagesOptions.Builder()
            .collectionId("testString")
            .imagesFile(mockListFileWithMetadata)
            .imageUrl(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .trainingData(
                "\"{\"objects\":[{\"object\":\"2018-Fit\",\"location\":{\"left\":33,\"top\":8,\"width\":760,\"height\":419}}]}\"")
            .build();
    assertEquals(addImagesOptionsModel.collectionId(), "testString");
    assertEquals(addImagesOptionsModel.imagesFile(), mockListFileWithMetadata);
    assertEquals(
        addImagesOptionsModel.imageUrl(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        addImagesOptionsModel.trainingData(),
        "\"{\"objects\":[{\"object\":\"2018-Fit\",\"location\":{\"left\":33,\"top\":8,\"width\":760,\"height\":419}}]}\"");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddImagesOptionsError() throws Throwable {
    new AddImagesOptions.Builder().build();
  }
}
