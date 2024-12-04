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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the SearchSettingsConversationalSearch model. */
public class SearchSettingsConversationalSearchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchSettingsConversationalSearch() throws Throwable {
    SearchSettingsConversationalSearchResponseLength
        searchSettingsConversationalSearchResponseLengthModel =
            new SearchSettingsConversationalSearchResponseLength.Builder()
                .option("moderate")
                .build();
    assertEquals(searchSettingsConversationalSearchResponseLengthModel.option(), "moderate");

    SearchSettingsConversationalSearchSearchConfidence
        searchSettingsConversationalSearchSearchConfidenceModel =
            new SearchSettingsConversationalSearchSearchConfidence.Builder()
                .threshold("less_often")
                .build();
    assertEquals(searchSettingsConversationalSearchSearchConfidenceModel.threshold(), "less_often");

    SearchSettingsConversationalSearch searchSettingsConversationalSearchModel =
        new SearchSettingsConversationalSearch.Builder()
            .enabled(true)
            .responseLength(searchSettingsConversationalSearchResponseLengthModel)
            .searchConfidence(searchSettingsConversationalSearchSearchConfidenceModel)
            .build();
    assertEquals(searchSettingsConversationalSearchModel.enabled(), Boolean.valueOf(true));
    assertEquals(
        searchSettingsConversationalSearchModel.responseLength(),
        searchSettingsConversationalSearchResponseLengthModel);
    assertEquals(
        searchSettingsConversationalSearchModel.searchConfidence(),
        searchSettingsConversationalSearchSearchConfidenceModel);

    String json = TestUtilities.serialize(searchSettingsConversationalSearchModel);

    SearchSettingsConversationalSearch searchSettingsConversationalSearchModelNew =
        TestUtilities.deserialize(json, SearchSettingsConversationalSearch.class);
    assertTrue(
        searchSettingsConversationalSearchModelNew instanceof SearchSettingsConversationalSearch);
    assertEquals(searchSettingsConversationalSearchModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(
        searchSettingsConversationalSearchModelNew.responseLength().toString(),
        searchSettingsConversationalSearchResponseLengthModel.toString());
    assertEquals(
        searchSettingsConversationalSearchModelNew.searchConfidence().toString(),
        searchSettingsConversationalSearchSearchConfidenceModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchSettingsConversationalSearchError() throws Throwable {
    new SearchSettingsConversationalSearch.Builder().build();
  }
}
