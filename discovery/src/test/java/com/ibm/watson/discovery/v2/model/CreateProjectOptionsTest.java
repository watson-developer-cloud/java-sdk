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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateProjectOptions model. */
public class CreateProjectOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateProjectOptions() throws Throwable {
    DefaultQueryParamsPassages defaultQueryParamsPassagesModel =
        new DefaultQueryParamsPassages.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .characters(Long.valueOf("26"))
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .build();
    assertEquals(defaultQueryParamsPassagesModel.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModel.count(), Long.valueOf("26"));
    assertEquals(
        defaultQueryParamsPassagesModel.fields(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(defaultQueryParamsPassagesModel.characters(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsPassagesModel.perDocument(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModel.maxPerDocument(), Long.valueOf("26"));

    DefaultQueryParamsTableResults defaultQueryParamsTableResultsModel =
        new DefaultQueryParamsTableResults.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .perDocument(Long.valueOf("26"))
            .build();
    assertEquals(defaultQueryParamsTableResultsModel.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsTableResultsModel.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsTableResultsModel.perDocument(), Long.valueOf("26"));

    DefaultQueryParamsSuggestedRefinements defaultQueryParamsSuggestedRefinementsModel =
        new DefaultQueryParamsSuggestedRefinements.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .build();
    assertEquals(defaultQueryParamsSuggestedRefinementsModel.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsSuggestedRefinementsModel.count(), Long.valueOf("26"));

    DefaultQueryParams defaultQueryParamsModel =
        new DefaultQueryParams.Builder()
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .passages(defaultQueryParamsPassagesModel)
            .tableResults(defaultQueryParamsTableResultsModel)
            .aggregation("testString")
            .suggestedRefinements(defaultQueryParamsSuggestedRefinementsModel)
            .spellingSuggestions(true)
            .highlight(true)
            .count(Long.valueOf("26"))
            .sort("testString")
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(
        defaultQueryParamsModel.collectionIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(defaultQueryParamsModel.passages(), defaultQueryParamsPassagesModel);
    assertEquals(defaultQueryParamsModel.tableResults(), defaultQueryParamsTableResultsModel);
    assertEquals(defaultQueryParamsModel.aggregation(), "testString");
    assertEquals(
        defaultQueryParamsModel.suggestedRefinements(),
        defaultQueryParamsSuggestedRefinementsModel);
    assertEquals(defaultQueryParamsModel.spellingSuggestions(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsModel.highlight(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsModel.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsModel.sort(), "testString");
    assertEquals(
        defaultQueryParamsModel.xReturn(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CreateProjectOptions createProjectOptionsModel =
        new CreateProjectOptions.Builder()
            .name("testString")
            .type("document_retrieval")
            .defaultQueryParameters(defaultQueryParamsModel)
            .build();
    assertEquals(createProjectOptionsModel.name(), "testString");
    assertEquals(createProjectOptionsModel.type(), "document_retrieval");
    assertEquals(createProjectOptionsModel.defaultQueryParameters(), defaultQueryParamsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProjectOptionsError() throws Throwable {
    new CreateProjectOptions.Builder().build();
  }
}
