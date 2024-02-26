/*
 * (C) Copyright IBM Corp. 2021, 2024.
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

/** Unit test class for the QueryCollectionNoticesOptions model. */
public class QueryCollectionNoticesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testQueryCollectionNoticesOptions() throws Throwable {
    QueryCollectionNoticesOptions queryCollectionNoticesOptionsModel =
        new QueryCollectionNoticesOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .count(Long.valueOf("10"))
            .offset(Long.valueOf("26"))
            .build();
    assertEquals(queryCollectionNoticesOptionsModel.projectId(), "testString");
    assertEquals(queryCollectionNoticesOptionsModel.collectionId(), "testString");
    assertEquals(queryCollectionNoticesOptionsModel.filter(), "testString");
    assertEquals(queryCollectionNoticesOptionsModel.query(), "testString");
    assertEquals(queryCollectionNoticesOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(queryCollectionNoticesOptionsModel.count(), Long.valueOf("10"));
    assertEquals(queryCollectionNoticesOptionsModel.offset(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryCollectionNoticesOptionsError() throws Throwable {
    new QueryCollectionNoticesOptions.Builder().build();
  }
}
