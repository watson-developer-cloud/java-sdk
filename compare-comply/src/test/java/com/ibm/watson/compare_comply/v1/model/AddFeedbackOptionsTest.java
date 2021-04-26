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

/** Unit test class for the AddFeedbackOptions model. */
public class AddFeedbackOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddFeedbackOptions() throws Throwable {
    ShortDoc shortDocModel = new ShortDoc.Builder().title("testString").hash("testString").build();
    assertEquals(shortDocModel.title(), "testString");
    assertEquals(shortDocModel.hash(), "testString");

    Location locationModel =
        new Location.Builder().begin(Long.valueOf("26")).end(Long.valueOf("26")).build();
    assertEquals(locationModel.begin(), Long.valueOf("26"));
    assertEquals(locationModel.end(), Long.valueOf("26"));

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

    OriginalLabelsIn originalLabelsInModel =
        new OriginalLabelsIn.Builder()
            .types(new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)))
            .categories(new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)))
            .build();
    assertEquals(
        originalLabelsInModel.types(),
        new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)));
    assertEquals(
        originalLabelsInModel.categories(),
        new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)));

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

    FeedbackDataInput feedbackDataInputModel =
        new FeedbackDataInput.Builder()
            .feedbackType("testString")
            .document(shortDocModel)
            .modelId("testString")
            .modelVersion("testString")
            .location(locationModel)
            .text("testString")
            .originalLabels(originalLabelsInModel)
            .updatedLabels(updatedLabelsInModel)
            .build();
    assertEquals(feedbackDataInputModel.feedbackType(), "testString");
    assertEquals(feedbackDataInputModel.document(), shortDocModel);
    assertEquals(feedbackDataInputModel.modelId(), "testString");
    assertEquals(feedbackDataInputModel.modelVersion(), "testString");
    assertEquals(feedbackDataInputModel.location(), locationModel);
    assertEquals(feedbackDataInputModel.text(), "testString");
    assertEquals(feedbackDataInputModel.originalLabels(), originalLabelsInModel);
    assertEquals(feedbackDataInputModel.updatedLabels(), updatedLabelsInModel);

    AddFeedbackOptions addFeedbackOptionsModel =
        new AddFeedbackOptions.Builder()
            .feedbackData(feedbackDataInputModel)
            .userId("testString")
            .comment("testString")
            .build();
    assertEquals(addFeedbackOptionsModel.feedbackData(), feedbackDataInputModel);
    assertEquals(addFeedbackOptionsModel.userId(), "testString");
    assertEquals(addFeedbackOptionsModel.comment(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddFeedbackOptionsError() throws Throwable {
    new AddFeedbackOptions.Builder().build();
  }
}
