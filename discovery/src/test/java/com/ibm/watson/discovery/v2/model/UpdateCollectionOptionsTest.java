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

/** Unit test class for the UpdateCollectionOptions model. */
public class UpdateCollectionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateCollectionOptions() throws Throwable {
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(collectionEnrichmentModel.enrichmentId(), "testString");
    assertEquals(
        collectionEnrichmentModel.fields(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .enrichments(
                new java.util.ArrayList<CollectionEnrichment>(
                    java.util.Arrays.asList(collectionEnrichmentModel)))
            .build();
    assertEquals(updateCollectionOptionsModel.projectId(), "testString");
    assertEquals(updateCollectionOptionsModel.collectionId(), "testString");
    assertEquals(updateCollectionOptionsModel.name(), "testString");
    assertEquals(updateCollectionOptionsModel.description(), "testString");
    assertEquals(
        updateCollectionOptionsModel.enrichments(),
        new java.util.ArrayList<CollectionEnrichment>(
            java.util.Arrays.asList(collectionEnrichmentModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCollectionOptionsError() throws Throwable {
    new UpdateCollectionOptions.Builder().build();
  }
}
