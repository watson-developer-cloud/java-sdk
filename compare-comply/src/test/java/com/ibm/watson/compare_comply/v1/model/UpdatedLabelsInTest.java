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

package com.ibm.watson.compare_comply.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.compare_comply.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the UpdatedLabelsIn model. */
public class UpdatedLabelsInTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdatedLabelsIn() throws Throwable {
    Label labelModel = new Label.Builder().nature("testString").party("testString").build();
    assertEquals(labelModel.nature(), "testString");
    assertEquals(labelModel.party(), "testString");

    TypeLabel typeLabelModel =
        new TypeLabel.Builder()
            .label(labelModel)
            .provenanceIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modification("added")
            .build();
    assertEquals(typeLabelModel.label(), labelModel);
    assertEquals(
        typeLabelModel.provenanceIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(typeLabelModel.modification(), "added");

    Category categoryModel =
        new Category.Builder()
            .label("Amendments")
            .provenanceIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modification("added")
            .build();
    assertEquals(categoryModel.label(), "Amendments");
    assertEquals(
        categoryModel.provenanceIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(categoryModel.modification(), "added");

    UpdatedLabelsIn updatedLabelsInModel =
        new UpdatedLabelsIn.Builder()
            .types(new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)))
            .categories(new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)))
            .build();
    assertEquals(
        updatedLabelsInModel.types(),
        new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)));
    assertEquals(
        updatedLabelsInModel.categories(),
        new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)));

    String json = TestUtilities.serialize(updatedLabelsInModel);

    UpdatedLabelsIn updatedLabelsInModelNew =
        TestUtilities.deserialize(json, UpdatedLabelsIn.class);
    assertTrue(updatedLabelsInModelNew instanceof UpdatedLabelsIn);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdatedLabelsInError() throws Throwable {
    new UpdatedLabelsIn.Builder().build();
  }
}
