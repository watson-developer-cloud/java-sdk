/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
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
    QueryOptions queryOptionsModel =
        new QueryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("10"))
            .xReturn("testString")
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(false)
            .passagesFields("testString")
            .passagesCount(Long.valueOf("10"))
            .passagesCharacters(Long.valueOf("400"))
            .deduplicate(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds("testString")
            .similarFields("testString")
            .bias("testString")
            .spellingSuggestions(false)
            .xWatsonLoggingOptOut(false)
            .build();
    assertEquals(queryOptionsModel.environmentId(), "testString");
    assertEquals(queryOptionsModel.collectionId(), "testString");
    assertEquals(queryOptionsModel.filter(), "testString");
    assertEquals(queryOptionsModel.query(), "testString");
    assertEquals(queryOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(queryOptionsModel.passages(), Boolean.valueOf(true));
    assertEquals(queryOptionsModel.aggregation(), "testString");
    assertEquals(queryOptionsModel.count(), Long.valueOf("10"));
    assertEquals(queryOptionsModel.xReturn(), "testString");
    assertEquals(queryOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(queryOptionsModel.sort(), "testString");
    assertEquals(queryOptionsModel.highlight(), Boolean.valueOf(false));
    assertEquals(queryOptionsModel.passagesFields(), "testString");
    assertEquals(queryOptionsModel.passagesCount(), Long.valueOf("10"));
    assertEquals(queryOptionsModel.passagesCharacters(), Long.valueOf("400"));
    assertEquals(queryOptionsModel.deduplicate(), Boolean.valueOf(false));
    assertEquals(queryOptionsModel.deduplicateField(), "testString");
    assertEquals(queryOptionsModel.similar(), Boolean.valueOf(false));
    assertEquals(queryOptionsModel.similarDocumentIds(), "testString");
    assertEquals(queryOptionsModel.similarFields(), "testString");
    assertEquals(queryOptionsModel.bias(), "testString");
    assertEquals(queryOptionsModel.spellingSuggestions(), Boolean.valueOf(false));
    assertEquals(queryOptionsModel.xWatsonLoggingOptOut(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryOptionsError() throws Throwable {
    new QueryOptions.Builder().build();
  }
}
