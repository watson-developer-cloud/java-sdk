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

/** Unit test class for the ClassifyInput model. */
public class ClassifyInputTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testClassifyInput() throws Throwable {
    ClassifyInput classifyInputModel = new ClassifyInput.Builder().text("testString").build();
    assertEquals(classifyInputModel.text(), "testString");

    String json = TestUtilities.serialize(classifyInputModel);

    ClassifyInput classifyInputModelNew = TestUtilities.deserialize(json, ClassifyInput.class);
    assertTrue(classifyInputModelNew instanceof ClassifyInput);
    assertEquals(classifyInputModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testClassifyInputError() throws Throwable {
    new ClassifyInput.Builder().build();
  }
}
