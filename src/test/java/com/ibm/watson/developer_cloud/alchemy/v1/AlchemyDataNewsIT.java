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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.ibm.watson.developer_cloud.alchemy.v1.model.VolumeResult;

/**
 * The Class AlchemyDataNewsTest.
 */
public class AlchemyDataNewsIT extends WatsonServiceTest {

  private AlchemyDataNews service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new AlchemyDataNews();
    service.setApiKey(getValidProperty("alchemy.alchemy"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test Get testGetCount.
   */
  @Test
  public void testGetCount() {
    final VolumeResult result = service.getVolume("now-30", "now", null);
    Assert.assertNotNull(result);
  }

  /**
   * Test Get test Count Time Slice.
   */
  @Test
  public void testGetCountTimeSlice() {
    final VolumeResult result = service.getVolume("now-7d", "now", "12h");
    Assert.assertNotNull(result);
  }

  /**
   * Test Get News.
   */
  @Test
  public void testNews() {
    final Map<String, Object> params = new HashMap<String, Object>();

    final String[] fields =
        new String[] {"enriched.url.title", "enriched.url.url", "enriched.url.author",
            "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
            "enriched.url.enrichedTitle.docSentiment", "enriched.url.enrichedTitle.concepts",
            "enriched.url.enrichedTitle.taxonomy"};
    params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));
    params.put(AlchemyDataNews.START, "1440720000");
    params.put(AlchemyDataNews.END, "1441407600");
    params.put(AlchemyDataNews.COUNT, "7");
    params.put("q.enriched.url.enrichedTitle.entities.entity", "|text=IBM,type=company|");
    params.put("q.enriched.url.enrichedTitle.docSentiment.type", "positive");
    params.put("q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label", "technology and computing");

    final DocumentsResult result = service.getNewsDocuments(params);
    Assert.assertNotNull(result);
  }
}
