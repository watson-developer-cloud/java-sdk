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

/** Unit test class for the QueryOptions model. */
public class QueryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testQueryOptions() throws Throwable {
    QueryLargeTableResults queryLargeTableResultsModel =
        new QueryLargeTableResults.Builder().enabled(true).count(Long.valueOf("26")).build();
    assertEquals(queryLargeTableResultsModel.enabled(), Boolean.valueOf(true));
    assertEquals(queryLargeTableResultsModel.count(), Long.valueOf("26"));

    QueryLargeSuggestedRefinements queryLargeSuggestedRefinementsModel =
        new QueryLargeSuggestedRefinements.Builder().enabled(true).count(Long.valueOf("1")).build();
    assertEquals(queryLargeSuggestedRefinementsModel.enabled(), Boolean.valueOf(true));
    assertEquals(queryLargeSuggestedRefinementsModel.count(), Long.valueOf("1"));

    QueryLargePassages queryLargePassagesModel =
        new QueryLargePassages.Builder()
            .enabled(true)
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .fields(java.util.Arrays.asList("testString"))
            .count(Long.valueOf("400"))
            .characters(Long.valueOf("50"))
            .findAnswers(false)
            .maxAnswersPerPassage(Long.valueOf("1"))
            .build();
    assertEquals(queryLargePassagesModel.enabled(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModel.perDocument(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModel.maxPerDocument(), Long.valueOf("26"));
    assertEquals(queryLargePassagesModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(queryLargePassagesModel.count(), Long.valueOf("400"));
    assertEquals(queryLargePassagesModel.characters(), Long.valueOf("50"));
    assertEquals(queryLargePassagesModel.findAnswers(), Boolean.valueOf(false));
    assertEquals(queryLargePassagesModel.maxAnswersPerPassage(), Long.valueOf("1"));

    QueryLargeSimilar queryLargeSimilarModel =
        new QueryLargeSimilar.Builder()
            .enabled(false)
            .documentIds(java.util.Arrays.asList("testString"))
            .fields(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(queryLargeSimilarModel.enabled(), Boolean.valueOf(false));
    assertEquals(queryLargeSimilarModel.documentIds(), java.util.Arrays.asList("testString"));
    assertEquals(queryLargeSimilarModel.fields(), java.util.Arrays.asList("testString"));

    QueryOptions queryOptionsModel =
        new QueryOptions.Builder()
            .projectId("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(java.util.Arrays.asList("testString"))
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(true)
            .spellingSuggestions(true)
            .tableResults(queryLargeTableResultsModel)
            .suggestedRefinements(queryLargeSuggestedRefinementsModel)
            .passages(queryLargePassagesModel)
            .similar(queryLargeSimilarModel)
            .build();
    assertEquals(queryOptionsModel.projectId(), "testString");
    assertEquals(queryOptionsModel.collectionIds(), java.util.Arrays.asList("testString"));
    assertEquals(queryOptionsModel.filter(), "testString");
    assertEquals(queryOptionsModel.query(), "testString");
    assertEquals(queryOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(queryOptionsModel.aggregation(), "testString");
    assertEquals(queryOptionsModel.count(), Long.valueOf("26"));
    assertEquals(queryOptionsModel.xReturn(), java.util.Arrays.asList("testString"));
    assertEquals(queryOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(queryOptionsModel.sort(), "testString");
    assertEquals(queryOptionsModel.highlight(), Boolean.valueOf(true));
    assertEquals(queryOptionsModel.spellingSuggestions(), Boolean.valueOf(true));
    assertEquals(queryOptionsModel.tableResults(), queryLargeTableResultsModel);
    assertEquals(queryOptionsModel.suggestedRefinements(), queryLargeSuggestedRefinementsModel);
    assertEquals(queryOptionsModel.passages(), queryLargePassagesModel);
    assertEquals(queryOptionsModel.similar(), queryLargeSimilarModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryOptionsError() throws Throwable {
    new QueryOptions.Builder().build();
  }
}
