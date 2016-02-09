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

package com.ibm.watson.developer_cloud.visual_insights.v1;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.service.BadRequestException;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Summary;

/**
 * The Class VisualInsightsTest.
 * 
 */
@FixMethodOrder(MethodSorters.JVM)
public class VisualInsightsIT extends WatsonServiceTest {

  private static final String RESOURCES = "src/test/resources/visual_insights/";
  /** The service. */
  private VisualInsights service;


  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new VisualInsights();
    service.setUsernameAndPassword(getValidProperty("visual_insights.username"),
        getValidProperty("visual_insights.password"));
    service.setEndPoint(getValidProperty("visual_insights.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test get GetClassifiersFilterByName.
   */
  @Test
  public void testGetClassifiers() {
    final Classifiers classifiers = service.getClassifiers();
    Assert.assertNotNull(classifiers);
  }

  /**
   * Test get GetClassifiersFilterByName.
   */
  @Test
  public void testGetClassifiersFilterByName() {
    final Classifiers classifiers = service.getClassifiers("animal");
    Assert.assertNotNull(classifiers);
  }

  /**
   * Test get uploading images.
   */
  @Test
  public void testGetSummary() {
    final File images = new File(RESOURCES + "images.zip");
    final Summary summary = service.getSummary(images);
    Assert.assertNotNull(summary);
  }

  /**
   * Test to try to upload text files - not supported.
   */
  @Test
  public void testGetSummaryTextFiles() {

    final File images = new File(RESOURCES + "text_files.zip");

    boolean didItHappen = false;
    try {
      service.getSummary(images);
    } catch (final BadRequestException e) {
      didItHappen = true;
    }
    Assert.assertTrue("Text files are not allowed.", didItHappen);
  }

  /**
   * Test for unsupported compression format - 7zip, not supported.
   */
  @Test
  public void testGetSummaryUnsupported7zFormat() {

    final File images = new File(RESOURCES + "tiger_woods.7z");

    boolean didItHappen = false;
    try {
      service.getSummary(images);
    } catch (final BadRequestException e) {
      didItHappen = true;
    }
    Assert.assertTrue("7zip compression format not supported.", didItHappen);
  }


}
