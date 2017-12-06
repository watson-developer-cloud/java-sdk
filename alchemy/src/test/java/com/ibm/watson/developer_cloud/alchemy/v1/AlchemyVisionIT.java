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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneTextLine;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneTextLine.Word;
import com.ibm.watson.developer_cloud.util.RetryRunner;

import okhttp3.HttpUrl;

/**
 * The Class AlchemyVisionTest.
 */
@RunWith(RetryRunner.class)
public class AlchemyVisionIT extends WatsonServiceTest {

  private static final String IMAGE_OBAMA = "src/test/resources/alchemy/obama.jpg";
  private static final String IMAGE_COLORADO = "src/test/resources/alchemy/colorado.jpg";
  private static final String IMAGE_COLORADO_URL = "https://raw.githubusercontent.com/watson-developer-cloud/"
      + "doc-tutorial-downloads/master/visual-recognition/colorado.jpg";
  private static final String VR_IMAGE = "https://visual-recognition-demo.mybluemix.net/images/samples/3.jpg";

  /** The html example. */
  private String htmlExample;

  /** The service. */
  private AlchemyVision service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    String apiKey = getProperty("alchemy.alchemy");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (apiKey == null) || apiKey.equals("API_KEY"));

    service = new AlchemyVision();
    service.setApiKey(apiKey);
    service.setDefaultHeaders(getDefaultHeaders());
    htmlExample = getStringFromInputStream(new FileInputStream("src/test/resources/alchemy/example.html"));
  }

  /**
   * Test get image from URL.
   */
  @Test
  public void testGetImageFromURL() {
    final ImageLink image = service.getImageLink(HttpUrl.parse("http://www.techcrunch.com/").url()).execute();
    Assert.assertNotNull(image);
  }

  /**
   * Test get image with HTML.
   */
  @Ignore
  @Test
  public void testGetImageWithHTML() {
    final ImageLink image = service.getImageLink(htmlExample).execute();
    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image scene text from image.
   */
  @Ignore
  @Test(timeout = 180000)
  public void testGetRankedImageSceneTextFromImage() {
    final File imageFile = new File(IMAGE_COLORADO);
    final ImageSceneText image = service.getImageSceneText(imageFile).execute();

    Assert.assertEquals("colorado", image.getSceneText());
    Assert.assertEquals(1, image.getSceneTextLines().size());

    ImageSceneTextLine first = image.getSceneTextLines().get(0);
    Assert.assertEquals("colorado", first.getText());
    Assert.assertEquals(25, (int) first.getRegion().getHeight());
    Assert.assertEquals(104, (int) first.getRegion().getWidth());
    Assert.assertEquals(484, (int) first.getRegion().getX());
    Assert.assertEquals(215, (int) first.getRegion().getY());
    Assert.assertNotNull(first.getConfidence());
    Assert.assertNotNull(image);

    Assert.assertEquals(1, first.getWords().size());
    Word word = first.getWords().get(0);
    Assert.assertEquals("colorado", word.getText());
    Assert.assertEquals(25, (int) word.getRegion().getHeight());
    Assert.assertEquals(104, (int) word.getRegion().getWidth());
    Assert.assertEquals(484, (int) word.getRegion().getX());
    Assert.assertEquals(215, (int) word.getRegion().getY());
    Assert.assertNotNull(word.getConfidence());
  }

  /**
   * Test get ranked image scene text from URL.
   */
  @Ignore
  @Test
  public void testGetRankedImageSceneTextFromURL() {
    final ImageSceneText image = service.getImageSceneText(HttpUrl.parse(IMAGE_COLORADO_URL).url()).execute();

    Assert.assertEquals("colorado", image.getSceneText());
    Assert.assertEquals(1, image.getSceneTextLines().size());
    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image keywords from image.
   */
  @Ignore
  @Test
  public void testGetRankedImageKeywordsFromImage() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageKeywords image = service.getImageKeywords(imageFile, null, null).execute();

    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image keywords from image with knowledge graph data included.
   */
  @Ignore
  @Test
  public void testGetRankedImageKeywordsFromImageWithKnowledgeGraph() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageKeywords image = service.getImageKeywords(imageFile, null, true).execute();

    Assert.assertNotNull(image);
    if ((image.getImageKeywords() != null) && !image.getImageKeywords().isEmpty()) {
      for (ImageKeyword keyword : image.getImageKeywords()) {
        Assert.assertNotNull(keyword.getHierarchy());
      }
    }
  }

  /**
   * Test get ranked image keywords from URL.
   */
  @Ignore
  @Test
  public void testGetRankedImageKeywordsFromURL() {
    final ImageKeywords image = service.getImageKeywords(HttpUrl.parse(VR_IMAGE).url(), true, true).execute();

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from image.
   */
  @Ignore
  @Test
  public void testRecognizeFacesFromImage() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageFaces image = service.recognizeFaces(imageFile, true).execute();

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from URL.
   */
  @Ignore
  @Test
  public void testRecognizeFacesFromURL() {
    final ImageFaces image = service.recognizeFaces(HttpUrl.parse(VR_IMAGE).url(), false).execute();

    Assert.assertNotNull(image);
  }
}
