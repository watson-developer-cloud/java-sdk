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
package com.ibm.watson.developer_cloud.relationship_extraction.v1;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.RelationshipExtractionDataset;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Relationship Extraction intelligently finds relationships between sentence components (nouns,
 * verbs, subjects, objects, etc.)
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/relationship-extraction.html">
 *      Relationship Extraction</a>
 */
public class RelationshipExtraction extends WatsonService {

  /** The url. */
  private static final String URL =
      "https://gateway.watsonplatform.net/relationship-extraction-beta/api";

  /** The dataset. */
  private RelationshipExtractionDataset dataset;

  /**
   * Instantiates a new relationship extraction service.
   */
  public RelationshipExtraction() {
    super("relatonship_extraction");
    setEndPoint(URL);
  }

  /**
   * Extract.
   * 
   * @param text the text
   * 
   * 
   * @return the string
   */
  public String extract(final String text) {
    if (dataset == null)
      throw new IllegalArgumentException("dataset cannot be null");
    if (text == null)
      throw new IllegalArgumentException("text cannot be null");

    final Request request =
        RequestBuilder.post("/v1/sire/0")
            .withForm("sid", dataset.getId(), "rt", "xml", "txt", text).build();
    final Response response = execute(request);
    return ResponseUtil.getString(response);
  }

  /**
   * Gets the dataset.
   * 
   * 
   * @return the dataset
   */
  public RelationshipExtractionDataset getDataset() {
    return dataset;
  }

  /**
   * Sets the dataset.
   * 
   * @param dataset the new dataset
   */
  public void setDataset(final RelationshipExtractionDataset dataset) {
    this.dataset = dataset;
  }

}
