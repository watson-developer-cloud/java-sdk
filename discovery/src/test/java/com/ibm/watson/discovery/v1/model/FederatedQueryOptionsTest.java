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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the FederatedQueryOptions model. */
public class FederatedQueryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testFederatedQueryOptions() throws Throwable {
    FederatedQueryOptions federatedQueryOptionsModel =
        new FederatedQueryOptions.Builder()
            .environmentId("testString")
            .collectionIds("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn("testString")
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(true)
            .passagesFields("testString")
            .passagesCount(Long.valueOf("100"))
            .passagesCharacters(Long.valueOf("50"))
            .deduplicate(true)
            .deduplicateField("testString")
            .similar(true)
            .similarDocumentIds("testString")
            .similarFields("testString")
            .bias("testString")
            .xWatsonLoggingOptOut(true)
            .build();
    assertEquals(federatedQueryOptionsModel.environmentId(), "testString");
    assertEquals(federatedQueryOptionsModel.collectionIds(), "testString");
    assertEquals(federatedQueryOptionsModel.filter(), "testString");
    assertEquals(federatedQueryOptionsModel.query(), "testString");
    assertEquals(federatedQueryOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(federatedQueryOptionsModel.passages(), Boolean.valueOf(true));
    assertEquals(federatedQueryOptionsModel.aggregation(), "testString");
    assertEquals(federatedQueryOptionsModel.count(), Long.valueOf("26"));
    assertEquals(federatedQueryOptionsModel.xReturn(), "testString");
    assertEquals(federatedQueryOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(federatedQueryOptionsModel.sort(), "testString");
    assertEquals(federatedQueryOptionsModel.highlight(), Boolean.valueOf(true));
    assertEquals(federatedQueryOptionsModel.passagesFields(), "testString");
    assertEquals(federatedQueryOptionsModel.passagesCount(), Long.valueOf("100"));
    assertEquals(federatedQueryOptionsModel.passagesCharacters(), Long.valueOf("50"));
    assertEquals(federatedQueryOptionsModel.deduplicate(), Boolean.valueOf(true));
    assertEquals(federatedQueryOptionsModel.deduplicateField(), "testString");
    assertEquals(federatedQueryOptionsModel.similar(), Boolean.valueOf(true));
    assertEquals(federatedQueryOptionsModel.similarDocumentIds(), "testString");
    assertEquals(federatedQueryOptionsModel.similarFields(), "testString");
    assertEquals(federatedQueryOptionsModel.bias(), "testString");
    assertEquals(federatedQueryOptionsModel.xWatsonLoggingOptOut(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryOptionsError() throws Throwable {
    new FederatedQueryOptions.Builder().build();
  }
}
