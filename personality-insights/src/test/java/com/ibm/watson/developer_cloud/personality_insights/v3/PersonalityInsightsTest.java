/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.personality_insights.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.UUID;

import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * PersonalityInsights Unit Test v3.
 *
 */
public class PersonalityInsightsTest extends WatsonServiceUnitTest {

  private static final String RESOURCE = "src/test/resources/personality_insights/";
  private static final String PROFILE_PATH = "/v3/profile";
  private static final String VERSION_DATE_2016_10_19 = "2016-10-19";
  private String text;
  private PersonalityInsights service;
  private Profile profile;
  private ContentItem contentItem;

  /**
   * Instantiates a new personality insights test.
   *
   * @throws FileNotFoundException the file not found exception
   */
  public PersonalityInsightsTest() throws FileNotFoundException {
    profile = loadFixture(RESOURCE + "profile.json", Profile.class);
    text = "foo-bar-text";
    contentItem = new ContentItem.Builder().content(text).build();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights(VERSION_DATE_2016_10_19, "<username>", "<password>");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Negative - Test constructor with null version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new PersonalityInsights(null);
  }

  /**
   * Negative - Test constructor with empty version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new PersonalityInsights("");
  }

  /**
   * Test get profile with content.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithContent() throws InterruptedException {
    final Content content = new Content.Builder()
        .addContentItem(contentItem)
        .build();
    final ProfileOptions options = new ProfileOptions.Builder().content(content).build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.profile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH + "?version=2016-10-19", request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(profile);
    assertEquals(this.profile, profile);
  }

  /**
   * Test load a content from a file.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testLoadAContentFromAFile() throws InterruptedException, FileNotFoundException {
    final Content content = loadFixture(RESOURCE + "v3-contentItems.json", Content.class);
    assertNotNull(content);
  }

  /**
   * Test content builders.
   */
  @Test
  public void testContentBuilders() {
    final String content1 = "Wow, I liked @TheRock before , now I really SEE how special he is. "
        + "The daughter story was IT for me. So great! #MasterClass";
    final String content2 = "Wow aren't you loving @TheRock and his candor? #Masterclass";
    Long now = new Date().getTime();
    final ContentItem cItem1 = new ContentItem.Builder(content1)
        .language(ContentItem.Language.EN)
        .contenttype("text/plain")
        .created(now)
        .updated(now)
        .id(UUID.randomUUID().toString())
        .forward(false)
        .reply(false)
        .parentid(null)
        .build();
    ContentItem cItem2 = cItem1.newBuilder()
        .content(content2)
        .id(UUID.randomUUID().toString())
        .build();
    assertEquals(cItem2.contenttype(), "text/plain");
    assertEquals(cItem2.created(), now);
    assertEquals(cItem2.updated(), now);
    assertNotEquals(cItem1.id(), cItem2.id());
    final Content content = new Content.Builder()
        .addContentItem(cItem1)
        .addContentItem(cItem2)
        .build();
    assertEquals(content.contentItems().size(), 2);
    final Content newContent = content.newBuilder().build();
    assertEquals(newContent.contentItems().size(), 2);
  }

  /**
   * Test get profile with English text.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithEnglishText() throws InterruptedException {
    final ProfileOptions options = new ProfileOptions.Builder()
        .text(text)
        .contentLanguage(ProfileOptions.ContentLanguage.EN)
        .build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.profile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH + "?version=2016-10-19", request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("en", request.getHeader(HttpHeaders.CONTENT_LANGUAGE));
    assertEquals(HttpMediaType.TEXT.toString(), request.getHeader(HttpHeaders.CONTENT_TYPE));
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(profile);
    assertEquals(this.profile, profile);
  }

  /**
   * Test get profile with spanish text.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithSpanishText() throws InterruptedException {
    final ProfileOptions options = new ProfileOptions.Builder()
        .text(text)
        .contentLanguage(ProfileOptions.ContentLanguage.ES)
        .consumptionPreferences(true)
        .rawScores(true)
        .build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.profile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH + "?version=2016-10-19&raw_scores=true&consumption_preferences=true", request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("es", request.getHeader(HttpHeaders.CONTENT_LANGUAGE));
    assertEquals(HttpMediaType.TEXT.toString(), request.getHeader(HttpHeaders.CONTENT_TYPE));
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(profile);
    assertEquals(profile, this.profile);
  }

  /**
   * Test profile options builders.
   */
  @Test
  public void testProfileBuilders() {
    final ProfileOptions options = new ProfileOptions.Builder()
        .html(text)
        .contentLanguage(ProfileOptions.ContentLanguage.ES)
        .acceptLanguage(ProfileOptions.AcceptLanguage.EN)
        .csvHeaders(true)
        .build();
    final ProfileOptions newOptions = options.newBuilder().build();
    assertEquals(newOptions.body(), text);
    assertEquals(newOptions.contentLanguage(), ProfileOptions.ContentLanguage.ES);
    assertEquals(newOptions.acceptLanguage(), ProfileOptions.AcceptLanguage.EN);
    assertEquals(newOptions.csvHeaders(), true);
  }

  /**
   * Negative - Test profile options builder without content (of any type).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testProfileOptionsBuilderWithoutContent() {
    final ProfileOptions options = new ProfileOptions.Builder()
        .contentLanguage(ProfileOptions.ContentLanguage.ES)
        .acceptLanguage(ProfileOptions.AcceptLanguage.EN)
        .build();
  }
}
