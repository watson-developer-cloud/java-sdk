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

/** Unit test class for the SourceOptionsSiteColl model. */
public class SourceOptionsSiteCollTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSourceOptionsSiteColl() throws Throwable {
    SourceOptionsSiteColl sourceOptionsSiteCollModel =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath("testString")
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(sourceOptionsSiteCollModel.siteCollectionPath(), "testString");
    assertEquals(sourceOptionsSiteCollModel.limit(), Long.valueOf("26"));

    String json = TestUtilities.serialize(sourceOptionsSiteCollModel);

    SourceOptionsSiteColl sourceOptionsSiteCollModelNew =
        TestUtilities.deserialize(json, SourceOptionsSiteColl.class);
    assertTrue(sourceOptionsSiteCollModelNew instanceof SourceOptionsSiteColl);
    assertEquals(sourceOptionsSiteCollModelNew.siteCollectionPath(), "testString");
    assertEquals(sourceOptionsSiteCollModelNew.limit(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSourceOptionsSiteCollError() throws Throwable {
    new SourceOptionsSiteColl.Builder().build();
  }
}
