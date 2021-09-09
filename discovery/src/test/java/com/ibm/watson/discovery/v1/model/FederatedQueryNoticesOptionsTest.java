/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** Unit test class for the FederatedQueryNoticesOptions model. */
public class FederatedQueryNoticesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testFederatedQueryNoticesOptions() throws Throwable {
    FederatedQueryNoticesOptions federatedQueryNoticesOptionsModel =
        new FederatedQueryNoticesOptions.Builder()
            .environmentId("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .offset(Long.valueOf("26"))
            .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .highlight(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .similarFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(federatedQueryNoticesOptionsModel.environmentId(), "testString");
    assertEquals(
        federatedQueryNoticesOptionsModel.collectionIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(federatedQueryNoticesOptionsModel.filter(), "testString");
    assertEquals(federatedQueryNoticesOptionsModel.query(), "testString");
    assertEquals(federatedQueryNoticesOptionsModel.naturalLanguageQuery(), "testString");
    assertEquals(federatedQueryNoticesOptionsModel.aggregation(), "testString");
    assertEquals(federatedQueryNoticesOptionsModel.count(), Long.valueOf("26"));
    assertEquals(
        federatedQueryNoticesOptionsModel.xReturn(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(federatedQueryNoticesOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(
        federatedQueryNoticesOptionsModel.sort(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(federatedQueryNoticesOptionsModel.highlight(), Boolean.valueOf(false));
    assertEquals(federatedQueryNoticesOptionsModel.deduplicateField(), "testString");
    assertEquals(federatedQueryNoticesOptionsModel.similar(), Boolean.valueOf(false));
    assertEquals(
        federatedQueryNoticesOptionsModel.similarDocumentIds(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        federatedQueryNoticesOptionsModel.similarFields(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryNoticesOptionsError() throws Throwable {
    new FederatedQueryNoticesOptions.Builder().build();
  }
}
