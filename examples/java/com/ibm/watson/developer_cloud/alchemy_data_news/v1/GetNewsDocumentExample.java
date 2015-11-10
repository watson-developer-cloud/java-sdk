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
package com.ibm.watson.developer_cloud.alchemy_data_news.v1;


import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;


/**
 * Getting 7 documents between Friday 28th August 2015 and Friday 4th September 2015 using the
 * {@link AlchemyDataNews} API.
 * 
 */
public class GetNewsDocumentExample {

  public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
    final AlchemyDataNews service = new AlchemyDataNews();
    service.setApiKey("<api_key>");

    final Map<String, Object> params = new HashMap<String, Object>();

    String[] fields =
        new String[] {"enriched.url.title", "enriched.url.url", "enriched.url.author",
            "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
            "enriched.url.enrichedTitle.docSentiment"};
    params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));
    params.put(AlchemyDataNews.START, "1440720000");
    params.put(AlchemyDataNews.END, "1441407600");
    params.put(AlchemyDataNews.COUNT, 7);

    final DocumentsResult result = service.getNewsDocuments(params);

    System.out.println(result);
  }

}
