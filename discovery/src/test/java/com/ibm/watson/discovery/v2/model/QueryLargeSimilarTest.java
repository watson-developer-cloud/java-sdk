/*
 * (C) Copyright IBM Corp. 2022.
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

/** Unit test class for the QueryLargeSimilar model. */
public class QueryLargeSimilarTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testQueryLargeSimilar() throws Throwable {
    QueryLargeSimilar queryLargeSimilarModel =
        new QueryLargeSimilar.Builder()
            .enabled(false)
            .documentIds(java.util.Arrays.asList("testString"))
            .fields(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(queryLargeSimilarModel.enabled(), Boolean.valueOf(false));
    assertEquals(queryLargeSimilarModel.documentIds(), java.util.Arrays.asList("testString"));
    assertEquals(queryLargeSimilarModel.fields(), java.util.Arrays.asList("testString"));

    String json = TestUtilities.serialize(queryLargeSimilarModel);

    QueryLargeSimilar queryLargeSimilarModelNew =
        TestUtilities.deserialize(json, QueryLargeSimilar.class);
    assertTrue(queryLargeSimilarModelNew instanceof QueryLargeSimilar);
    assertEquals(queryLargeSimilarModelNew.enabled(), Boolean.valueOf(false));
  }
}
