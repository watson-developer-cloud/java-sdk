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
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;

/**
 * The Class AlchemyVisionTest.
 */
public class AlchemyVisionTest extends WatsonServiceTest {

  /** The Constant BABY_IMAGE. */
  private static final String BABY_IMAGE =
      "http://visual-recognition-demo.mybluemix.net/images/4068.jpg";

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
    htmlExample = getStringFromInputStream(new FileInputStream("src/test/resources/example.html"));
  }

  /**
   * Test get image from url.
   */
  @Test
  public void testGetImageFromURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.URL, "http://www.techcrunch.com/");
    final ImageLink image = service.getImageLink(params);
    Assert.assertNotNull(image);
  }

  /**
   * Test get image with html.
   */
  @Test
  public void testGetImageWithHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.HTML, htmlExample);
    final ImageLink image = service.getImageLink(params);
    Assert.assertNotNull(image);
  }

  /**
   * Test get ranked image keywords from image.
   */
  @Test
  public void testGetRankedImageKeywordsFromImage() {
    final File imageFile = new File("src/test/resources/car.png");
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.IMAGE, imageFile);
    final ImageKeywords image = service.getImageKeywords(params);

    Assert.assertNotNull(image);

  }

  /**
   * Test get ranked image keywords from url.
   */
  @Test
  public void testGetRankedImageKeywordsFromURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.URL, BABY_IMAGE);
    final ImageKeywords image = service.getImageKeywords(params);

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from image.
   */
  @Test
  public void testRecognizeFacesFromImage() {
    final File imageFile = new File("src/test/resources/obama.jpg");
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.IMAGE, imageFile);
    final ImageFaces image = service.recognizeFaces(params);

    Assert.assertNotNull(image);
  }

  /**
   * Test recognize faces from url.
   */
  @Test
  public void testRecognizeFacesFromURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyVision.URL, BABY_IMAGE);
    final ImageFaces image = service.recognizeFaces(params);

    Assert.assertNotNull(image);
  }
}
