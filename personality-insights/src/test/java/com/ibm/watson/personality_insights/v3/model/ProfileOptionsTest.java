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

package com.ibm.watson.personality_insights.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.personality_insights.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the ProfileOptions model. */
public class ProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfileOptions() throws Throwable {
    ContentItem contentItemModel =
        new ContentItem.Builder()
            .content("testString")
            .id("testString")
            .created(Long.valueOf("26"))
            .updated(Long.valueOf("26"))
            .contenttype("text/plain")
            .language("ar")
            .parentid("testString")
            .reply(true)
            .forward(true)
            .build();
    assertEquals(contentItemModel.content(), "testString");
    assertEquals(contentItemModel.id(), "testString");
    assertEquals(contentItemModel.created(), Long.valueOf("26"));
    assertEquals(contentItemModel.updated(), Long.valueOf("26"));
    assertEquals(contentItemModel.contenttype(), "text/plain");
    assertEquals(contentItemModel.language(), "ar");
    assertEquals(contentItemModel.parentid(), "testString");
    assertEquals(contentItemModel.reply(), Boolean.valueOf(true));
    assertEquals(contentItemModel.forward(), Boolean.valueOf(true));

    Content contentModel =
        new Content.Builder()
            .contentItems(
                new java.util.ArrayList<ContentItem>(java.util.Arrays.asList(contentItemModel)))
            .build();
    assertEquals(
        contentModel.contentItems(),
        new java.util.ArrayList<ContentItem>(java.util.Arrays.asList(contentItemModel)));

    ProfileOptions profileOptionsModel =
        new ProfileOptions.Builder()
            .content(contentModel)
            .contentLanguage("ar")
            .acceptLanguage("ar")
            .rawScores(true)
            .csvHeaders(true)
            .consumptionPreferences(true)
            .build();
    assertEquals(profileOptionsModel.content(), contentModel);
    assertEquals(profileOptionsModel.contentLanguage(), "ar");
    assertEquals(profileOptionsModel.acceptLanguage(), "ar");
    assertEquals(profileOptionsModel.rawScores(), Boolean.valueOf(true));
    assertEquals(profileOptionsModel.csvHeaders(), Boolean.valueOf(true));
    assertEquals(profileOptionsModel.consumptionPreferences(), Boolean.valueOf(true));
  }
}
