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

import java.io.File;
import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.squareup.okhttp.HttpUrl;

/**
 * The Class AlchemyVisionTest.
 */
public class AlchemyVisionIT extends WatsonServiceTest {

  private static final String IMAGE_OBAMA = "src/test/resources/alchemy/obama.jpg";
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
   * Test get ranked image keywords from image.
   */
  @Test
  public void testGetRankedImageKeywordsFromImage() {
    final File imageFile = new File(IMAGE_OBAMA);
    final ImageKeywords image = service.getImageKeywords(imageFile, null, null);

    Assert.assertNotNull(image);

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
