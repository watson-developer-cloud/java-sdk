/*
 * (C) Copyright IBM Corp. 2021.
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

/** Unit test class for the SourceOptions model. */
public class SourceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSourceOptions() throws Throwable {
    SourceOptionsFolder sourceOptionsFolderModel =
        new SourceOptionsFolder.Builder()
            .ownerUserId("testString")
            .folderId("testString")
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(sourceOptionsFolderModel.ownerUserId(), "testString");
    assertEquals(sourceOptionsFolderModel.folderId(), "testString");
    assertEquals(sourceOptionsFolderModel.limit(), Long.valueOf("26"));

    SourceOptionsObject sourceOptionsObjectModel =
        new SourceOptionsObject.Builder().name("testString").limit(Long.valueOf("26")).build();
    assertEquals(sourceOptionsObjectModel.name(), "testString");
    assertEquals(sourceOptionsObjectModel.limit(), Long.valueOf("26"));

    SourceOptionsSiteColl sourceOptionsSiteCollModel =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath("testString")
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(sourceOptionsSiteCollModel.siteCollectionPath(), "testString");
    assertEquals(sourceOptionsSiteCollModel.limit(), Long.valueOf("26"));

    SourceOptionsWebCrawl sourceOptionsWebCrawlModel =
        new SourceOptionsWebCrawl.Builder()
            .url("testString")
            .limitToStartingHosts(true)
            .crawlSpeed("normal")
            .allowUntrustedCertificate(false)
            .maximumHops(Long.valueOf("26"))
            .requestTimeout(Long.valueOf("26"))
            .overrideRobotsTxt(false)
            .blacklist(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(sourceOptionsWebCrawlModel.url(), "testString");
    assertEquals(sourceOptionsWebCrawlModel.limitToStartingHosts(), Boolean.valueOf(true));
    assertEquals(sourceOptionsWebCrawlModel.crawlSpeed(), "normal");
    assertEquals(sourceOptionsWebCrawlModel.allowUntrustedCertificate(), Boolean.valueOf(false));
    assertEquals(sourceOptionsWebCrawlModel.maximumHops(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.requestTimeout(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.overrideRobotsTxt(), Boolean.valueOf(false));
    assertEquals(
        sourceOptionsWebCrawlModel.blacklist(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();
    assertEquals(sourceOptionsBucketsModel.name(), "testString");
    assertEquals(sourceOptionsBucketsModel.limit(), Long.valueOf("26"));

    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(
                new java.util.ArrayList<SourceOptionsFolder>(
                    java.util.Arrays.asList(sourceOptionsFolderModel)))
            .objects(
                new java.util.ArrayList<SourceOptionsObject>(
                    java.util.Arrays.asList(sourceOptionsObjectModel)))
            .siteCollections(
                new java.util.ArrayList<SourceOptionsSiteColl>(
                    java.util.Arrays.asList(sourceOptionsSiteCollModel)))
            .urls(
                new java.util.ArrayList<SourceOptionsWebCrawl>(
                    java.util.Arrays.asList(sourceOptionsWebCrawlModel)))
            .buckets(
                new java.util.ArrayList<SourceOptionsBuckets>(
                    java.util.Arrays.asList(sourceOptionsBucketsModel)))
            .crawlAllBuckets(true)
            .build();
    assertEquals(
        sourceOptionsModel.folders(),
        new java.util.ArrayList<SourceOptionsFolder>(
            java.util.Arrays.asList(sourceOptionsFolderModel)));
    assertEquals(
        sourceOptionsModel.objects(),
        new java.util.ArrayList<SourceOptionsObject>(
            java.util.Arrays.asList(sourceOptionsObjectModel)));
    assertEquals(
        sourceOptionsModel.siteCollections(),
        new java.util.ArrayList<SourceOptionsSiteColl>(
            java.util.Arrays.asList(sourceOptionsSiteCollModel)));
    assertEquals(
        sourceOptionsModel.urls(),
        new java.util.ArrayList<SourceOptionsWebCrawl>(
            java.util.Arrays.asList(sourceOptionsWebCrawlModel)));
    assertEquals(
        sourceOptionsModel.buckets(),
        new java.util.ArrayList<SourceOptionsBuckets>(
            java.util.Arrays.asList(sourceOptionsBucketsModel)));
    assertEquals(sourceOptionsModel.crawlAllBuckets(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(sourceOptionsModel);

    SourceOptions sourceOptionsModelNew = TestUtilities.deserialize(json, SourceOptions.class);
    assertTrue(sourceOptionsModelNew instanceof SourceOptions);
    assertEquals(sourceOptionsModelNew.crawlAllBuckets(), Boolean.valueOf(true));
  }
}
