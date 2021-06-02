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
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateEventOptions model. */
public class CreateEventOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateEventOptions() throws Throwable {
    EventData eventDataModel =
        new EventData.Builder()
            .environmentId("testString")
            .sessionToken("testString")
            .clientTimestamp(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .displayRank(Long.valueOf("26"))
            .collectionId("testString")
            .documentId("testString")
            .build();
    assertEquals(eventDataModel.environmentId(), "testString");
    assertEquals(eventDataModel.sessionToken(), "testString");
    assertEquals(
        eventDataModel.clientTimestamp(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(eventDataModel.displayRank(), Long.valueOf("26"));
    assertEquals(eventDataModel.collectionId(), "testString");
    assertEquals(eventDataModel.documentId(), "testString");

    CreateEventOptions createEventOptionsModel =
        new CreateEventOptions.Builder().type("click").data(eventDataModel).build();
    assertEquals(createEventOptionsModel.type(), "click");
    assertEquals(createEventOptionsModel.data(), eventDataModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEventOptionsError() throws Throwable {
    new CreateEventOptions.Builder().build();
  }
}
