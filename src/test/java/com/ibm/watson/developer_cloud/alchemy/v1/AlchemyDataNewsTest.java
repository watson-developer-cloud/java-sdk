/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.ibm.watson.developer_cloud.alchemy.v1.model.VolumeResult;

/**
 * Created by nizar on 8/25/15.
 */
public class AlchemyDataNewsTest extends WatsonServiceTest {


    /**
     * The Constant log.
     */
    private static final Logger log = Logger.getLogger(AlchemyDataNewsTest.class.getName());

    /**
     * The service.
     */
    private AlchemyDataNews service;


    /* (non-Javadoc)
     * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = new AlchemyDataNews();
        service.setApiKey(prop.getProperty("alchemy.alchemy"));

    }

    /**
     * Test Get testGetCount.
     */
    @Test
    public void testGetCount() {
        VolumeResult result = service.getVolume("now-30", "now", null);
        Assert.assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * Test Get test Count Time Slice.
     */
    @Test
    public void testGetCountTimeSlice() {
        VolumeResult result = service.getVolume("now-7d", "now", "12h");
        Assert.assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * Test Get News.
     */
    @Test
    public void testNews() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(AlchemyDataNews.RETURN, "enriched.url.title,enriched.url.url,enriched.url.author,enriched.url.publicationDate,enriched.url.enrichedTitle.entities,enriched.url.enrichedTitle.docSentiment,enriched.url.enrichedTitle.concepts,enriched.url.enrichedTitle.taxonomy");
        params.put(AlchemyDataNews.START, "1440720000");
        params.put(AlchemyDataNews.END, "1441407600");
        params.put(AlchemyDataNews.COUNT, "7");
        params.put("q.enriched.url.enrichedTitle.entities.entity", "|text=IBM,type=company|");
        params.put("q.enriched.url.enrichedTitle.docSentiment.type", "positive");
        params.put("q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label", "technology%20and%20computing");

        DocumentsResult result = service.getNewsDocuments(params);
        Assert.assertNotNull(result);
        log.info(result.toString());
    }
}
