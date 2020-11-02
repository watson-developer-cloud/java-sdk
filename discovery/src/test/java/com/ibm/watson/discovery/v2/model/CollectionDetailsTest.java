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

/** Unit test class for the CollectionDetails model. */
public class CollectionDetailsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCollectionDetails() throws Throwable {
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(collectionEnrichmentModel.enrichmentId(), "testString");
    assertEquals(
        collectionEnrichmentModel.fields(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CollectionDetails collectionDetailsModel =
        new CollectionDetails.Builder()
            .name("testString")
            .description("testString")
            .language("testString")
            .enrichments(
                new java.util.ArrayList<CollectionEnrichment>(
                    java.util.Arrays.asList(collectionEnrichmentModel)))
            .build();
    assertEquals(collectionDetailsModel.name(), "testString");
    assertEquals(collectionDetailsModel.description(), "testString");
    assertEquals(collectionDetailsModel.language(), "testString");
    assertEquals(
        collectionDetailsModel.enrichments(),
        new java.util.ArrayList<CollectionEnrichment>(
            java.util.Arrays.asList(collectionEnrichmentModel)));

    String json = TestUtilities.serialize(collectionDetailsModel);

    CollectionDetails collectionDetailsModelNew =
        TestUtilities.deserialize(json, CollectionDetails.class);
    assertTrue(collectionDetailsModelNew instanceof CollectionDetails);
    assertEquals(collectionDetailsModelNew.name(), "testString");
    assertEquals(collectionDetailsModelNew.description(), "testString");
    assertEquals(collectionDetailsModelNew.language(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCollectionDetailsError() throws Throwable {
    new CollectionDetails.Builder().build();
  }
}
