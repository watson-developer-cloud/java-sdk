/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

/** Unit test class for the QueryLargePassages model. */
public class QueryLargePassagesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testQueryLargePassages() throws Throwable {
    QueryLargePassages queryLargePassagesModel =
        new QueryLargePassages.Builder()
            .enabled(true)
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .fields(java.util.Arrays.asList("testString"))
            .count(Long.valueOf("400"))
            .characters(Long.valueOf("50"))
            .findAnswers(false)
            .maxAnswersPerPassage(Long.valueOf("26"))
            .build();
    assertEquals(queryLargePassagesModel.enabled(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModel.perDocument(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModel.maxPerDocument(), Long.valueOf("26"));
    assertEquals(queryLargePassagesModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(queryLargePassagesModel.count(), Long.valueOf("400"));
    assertEquals(queryLargePassagesModel.characters(), Long.valueOf("50"));
    assertEquals(queryLargePassagesModel.findAnswers(), Boolean.valueOf(false));
    assertEquals(queryLargePassagesModel.maxAnswersPerPassage(), Long.valueOf("26"));

    String json = TestUtilities.serialize(queryLargePassagesModel);

    QueryLargePassages queryLargePassagesModelNew =
        TestUtilities.deserialize(json, QueryLargePassages.class);
    assertTrue(queryLargePassagesModelNew instanceof QueryLargePassages);
    assertEquals(queryLargePassagesModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModelNew.perDocument(), Boolean.valueOf(true));
    assertEquals(queryLargePassagesModelNew.maxPerDocument(), Long.valueOf("26"));
    assertEquals(queryLargePassagesModelNew.count(), Long.valueOf("400"));
    assertEquals(queryLargePassagesModelNew.characters(), Long.valueOf("50"));
    assertEquals(queryLargePassagesModelNew.findAnswers(), Boolean.valueOf(false));
    assertEquals(queryLargePassagesModelNew.maxAnswersPerPassage(), Long.valueOf("26"));
  }
}
