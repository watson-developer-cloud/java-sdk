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

/** Unit test class for the SourceOptionsWebCrawl model. */
public class SourceOptionsWebCrawlTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSourceOptionsWebCrawl() throws Throwable {
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

    String json = TestUtilities.serialize(sourceOptionsWebCrawlModel);

    SourceOptionsWebCrawl sourceOptionsWebCrawlModelNew =
        TestUtilities.deserialize(json, SourceOptionsWebCrawl.class);
    assertTrue(sourceOptionsWebCrawlModelNew instanceof SourceOptionsWebCrawl);
    assertEquals(sourceOptionsWebCrawlModelNew.url(), "testString");
    assertEquals(sourceOptionsWebCrawlModelNew.limitToStartingHosts(), Boolean.valueOf(true));
    assertEquals(sourceOptionsWebCrawlModelNew.crawlSpeed(), "normal");
    assertEquals(sourceOptionsWebCrawlModelNew.allowUntrustedCertificate(), Boolean.valueOf(false));
    assertEquals(sourceOptionsWebCrawlModelNew.maximumHops(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModelNew.requestTimeout(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModelNew.overrideRobotsTxt(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSourceOptionsWebCrawlError() throws Throwable {
    new SourceOptionsWebCrawl.Builder().build();
  }
}
