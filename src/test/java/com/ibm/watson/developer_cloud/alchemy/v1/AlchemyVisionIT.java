/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.alchemy.v1;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneTextLine;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneTextLine.Word;
import com.squareup.okhttp.HttpUrl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * The Class AlchemyVisionTest.
 */
public class AlchemyVisionIT extends WatsonServiceTest {

  private static final String IMAGE_OBAMA = "src/test/resources/alchemy/obama.jpg";
  private static final String IMAGE_COLORADO = "src/test/resources/alchemy/colorado.jpg";
  private static final String IMAGE_COLORADO_URL = "http://vision.alchemy.ai/img/demo/1754836.jpg";
  private static final String BABY_IMAGE =
      "https://visual-recognition-demo.mybluemix.net/images/samples/1.jpg";

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
    service = new AlchemyVision();
    service.setApiKey(getValidProperty("alchemy.alchemy"));
    service.setDefaultHeaders(getDefaultHeaders());
    htmlExample =
        getStringFromInputStream(new FileInputStream("src/test/resources/alchemy/example.html"));
  }

  /**
   * Test get image from URL.
   */
  @Test
  public void testGetImageFromURL() {
    final ImageLink image = service.getImageLink(HttpUrl.parse("http://www.techcrunch.com/").url());
    Assert.assertNotNull(image);
  }

  /**
   * Test get image with HTML.
   */
  @Test
  public void testGetImageWithHTML() {
    final ImageLink image = service.getImageLink(htmlExample);
    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image scene text from image.
   */
  @Test
  public void testGetRankedImageSceneTextFromImage() {
    final File imageFile = new File(IMAGE_COLORADO);
    final ImageSceneText image = service.getImageSceneText(imageFile);

    Assert.assertEquals("colorado\n1\nl", image.getSceneText());
    Assert.assertEquals(3, image.getSceneTextLines().size());
    
    ImageSceneTextLine first = image.getSceneTextLines().get(0);
    Assert.assertEquals("colorado", first.getText());
    Assert.assertEquals(24, (int)first.getRegion().getHeight());
    Assert.assertEquals(104, (int)first.getRegion().getWidth());
    Assert.assertEquals(484, (int)first.getRegion().getX());
    Assert.assertEquals(216, (int)first.getRegion().getY());
    Assert.assertEquals(new Double(0.984956), first.getConfidence());
    Assert.assertNotNull(image);
    
    Assert.assertEquals(1, first.getWords().size());
    Word word = first.getWords().get(0);
    Assert.assertEquals("colorado", word.getText());
    Assert.assertEquals(24, (int)word.getRegion().getHeight());
    Assert.assertEquals(104, (int)word.getRegion().getWidth());
    Assert.assertEquals(484, (int)word.getRegion().getX());
    Assert.assertEquals(216, (int)word.getRegion().getY());
    Assert.assertEquals(new Double(0.984956), word.getConfidence());
  }
  
  /**
   * Test get ranked image scene text from URL.
   */
  @Test
  public void testGetRankedImageSceneTextFromURL() {
    final ImageSceneText image =
        service.getImageSceneText(HttpUrl.parse(IMAGE_COLORADO_URL).url());

    Assert.assertEquals("colorado\n1\nl", image.getSceneText());
    Assert.assertEquals(3, image.getSceneTextLines().size());
    Assert.assertNotNull(image);
  }
  
  /**
   * Test get ranked image keywords from image.
   */
  @Test
  public void testGetRankedImageKeywordsFromImage() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageKeywords image = service.getImageKeywords(imageFile, null, null);

    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image keywords from image with knowledge graph data included.
   */
  @Test
  public void testGetRankedImageKeywordsFromImageWithKnowledgeGraph() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageKeywords image = service.getImageKeywords(imageFile, null, true);

    Assert.assertNotNull(image);
    if (image.getImageKeywords() != null && !image.getImageKeywords().isEmpty()) {
      for (ImageKeyword keyword : image.getImageKeywords()) {
        Assert.assertNotNull(keyword.getHierarchy());
      }
    }
  }

  /**
   * Test get ranked image keywords from URL.
   */
  @Test
  public void testGetRankedImageKeywordsFromURL() {
    final ImageKeywords image =
        service.getImageKeywords(HttpUrl.parse(BABY_IMAGE).url(), true, true);

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from image.
   */
  @Test
  public void testRecognizeFacesFromImage() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageFaces image = service.recognizeFaces(imageFile, true);

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from URL.
   */
  @Test
  public void testRecognizeFacesFromURL() {
    final ImageFaces image = service.recognizeFaces(HttpUrl.parse(BABY_IMAGE).url(), false);

    Assert.assertNotNull(image);
  }
}
