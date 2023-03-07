/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the RequestAnalytics model. */
public class RequestAnalyticsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRequestAnalytics() throws Throwable {
    RequestAnalytics requestAnalyticsModel =
        new RequestAnalytics.Builder()
            .browser("testString")
            .device("testString")
            .pageUrl("testString")
            .build();
    assertEquals(requestAnalyticsModel.browser(), "testString");
    assertEquals(requestAnalyticsModel.device(), "testString");
    assertEquals(requestAnalyticsModel.pageUrl(), "testString");

    String json = TestUtilities.serialize(requestAnalyticsModel);

    RequestAnalytics requestAnalyticsModelNew =
        TestUtilities.deserialize(json, RequestAnalytics.class);
    assertTrue(requestAnalyticsModelNew instanceof RequestAnalytics);
    assertEquals(requestAnalyticsModelNew.browser(), "testString");
    assertEquals(requestAnalyticsModelNew.device(), "testString");
    assertEquals(requestAnalyticsModelNew.pageUrl(), "testString");
  }
}
