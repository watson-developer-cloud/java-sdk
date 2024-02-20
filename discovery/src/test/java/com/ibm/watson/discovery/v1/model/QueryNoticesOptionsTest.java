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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the QueryNoticesOptions model. */
public class QueryNoticesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testQueryNoticesOptions() throws Throwable {
    QueryNoticesOptions queryNoticesOptionsModel =
        new QueryNoticesOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("10"))
            .xReturn(java.util.Arrays.asList("testString"))
            .offset(Long.valueOf("26"))
            .sort(java.util.Arrays.asList("testString"))
            .highlight(false)
            .passagesFields(java.util.Arrays.asList("testString"))
            .passagesCount(Long.valueOf("10"))
            .passagesCharacters(Long.valueOf("400"))
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(java.util.Arrays.asList("testString"))
            .similarFields(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(queryNoticesOptionsModel.environmentId(), "testString");
    assertEquals(queryNoticesOptionsModel.collectionId(), "testString");
    assertEquals(queryNoticesOptionsModel.filter(), "testString");
    assertEquals(queryNoticesOptionsModel.query(), "testString");
    assertEquals(queryNoticesOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(queryNoticesOptionsModel.passages(), Boolean.valueOf(true));
    assertEquals(queryNoticesOptionsModel.aggregation(), "testString");
    assertEquals(queryNoticesOptionsModel.count(), Long.valueOf("10"));
    assertEquals(queryNoticesOptionsModel.xReturn(), java.util.Arrays.asList("testString"));
    assertEquals(queryNoticesOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(queryNoticesOptionsModel.sort(), java.util.Arrays.asList("testString"));
    assertEquals(queryNoticesOptionsModel.highlight(), Boolean.valueOf(false));
    assertEquals(queryNoticesOptionsModel.passagesFields(), java.util.Arrays.asList("testString"));
    assertEquals(queryNoticesOptionsModel.passagesCount(), Long.valueOf("10"));
    assertEquals(queryNoticesOptionsModel.passagesCharacters(), Long.valueOf("400"));
    assertEquals(queryNoticesOptionsModel.deduplicateField(), "testString");
    assertEquals(queryNoticesOptionsModel.similar(), Boolean.valueOf(false));
    assertEquals(
        queryNoticesOptionsModel.similarDocumentIds(), java.util.Arrays.asList("testString"));
    assertEquals(queryNoticesOptionsModel.similarFields(), java.util.Arrays.asList("testString"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryNoticesOptionsError() throws Throwable {
    new QueryNoticesOptions.Builder().build();
  }
}
