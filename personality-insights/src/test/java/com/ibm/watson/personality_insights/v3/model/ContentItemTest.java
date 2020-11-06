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

/** Unit test class for the ContentItem model. */
public class ContentItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testContentItem() throws Throwable {
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

    String json = TestUtilities.serialize(contentItemModel);

    ContentItem contentItemModelNew = TestUtilities.deserialize(json, ContentItem.class);
    assertTrue(contentItemModelNew instanceof ContentItem);
    assertEquals(contentItemModelNew.content(), "testString");
    assertEquals(contentItemModelNew.id(), "testString");
    assertEquals(contentItemModelNew.created(), Long.valueOf("26"));
    assertEquals(contentItemModelNew.updated(), Long.valueOf("26"));
    assertEquals(contentItemModelNew.contenttype(), "text/plain");
    assertEquals(contentItemModelNew.language(), "ar");
    assertEquals(contentItemModelNew.parentid(), "testString");
    assertEquals(contentItemModelNew.reply(), Boolean.valueOf(true));
    assertEquals(contentItemModelNew.forward(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testContentItemError() throws Throwable {
    new ContentItem.Builder().build();
  }
}
