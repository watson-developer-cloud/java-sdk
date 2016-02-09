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
import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.Dataset;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Relationship Extraction intelligently finds relationships between sentence components (nouns,
 * verbs, subjects, objects, etc.)
 * 
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
  private Dataset dataset;
  
  /** The return type. */
  private String returnType = "xml";

  /**
   * Instantiates a new relationship extraction service.
   */
  public RelationshipExtraction() {
    super("relatonship_extraction");
    setEndPoint(URL);
  }

  /**
   * Extracts relationships between sentence components (nouns, verbs, subjects, objects, etc.)
   * 
   * <br>
   * Here is an example of how to extract sentence components:
   * 
   * <pre>
   * RelationshipExtraction service = new RelationshipExtraction();
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * service.setDataset(Dataset.ENGLISH_NEWS);
   * String response = service.extract(&quot;IBM Watson developer cloud&quot;);
   * 
   * System.out.println(response);
   * </pre>
   * 
   * @param text the text to analyze
   * 
   * @return the result as an XML/JSON string
   */
  public String extract(final String text) {
    Validate.notNull(dataset, "dataset cannot be null");
    Validate.notNull(text, "text cannot be null");

    final Request request =
        RequestBuilder.post("/v1/sire/0")
            .withForm("sid", dataset.getId(), "rt", returnType, "txt", text).build();
    final Response response = execute(request);
    return ResponseUtil.getString(response);
  }

  /**
   * Gets the dataset.
   * 
   * 
   * @return the dataset
   */
  public Dataset getDataset() {
    return dataset;
  }

  /**
   * Sets the dataset.
   * 
   * @param dataset the new dataset
   */
  public void setDataset(final Dataset dataset) {
    this.dataset = dataset;
  }
  
  /**
   * Sets the returnType.
   * 
   * @param returnType the new returnType
   */
  public void setReturnType(final ReturnType returnType) {
    if (returnType == ReturnType.XML) {
      this.returnType = "xml";
    } else if (returnType == ReturnType.JSON) {
      this.returnType = "json";
    }
  } 

}
