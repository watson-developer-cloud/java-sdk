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
package com.ibm.watson.developer_cloud.relationship_extraction.v1_beta;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.relationship_extraction.v1_beta.model.Dataset;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.Request;

/**
 * Relationship Extraction intelligently finds relationships between sentence components (nouns,
 * verbs, subjects, objects, etc.)
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/relationship-extraction.html">
 *      Relationship Extraction</a>
 */
public class RelationshipExtraction extends WatsonService {
  private static final String SERVICE_NAME = "relatonship_extraction";
  private static final String JSON = "json";
  private static final String XML = "xml";
  private static final String TEXT = "txt";
  private static final String RETURN_TYPE = "rt";
  private static final String SID = "sid";
  private static final String URL = "https://gateway.watsonplatform.net/relationship-extraction-beta/api";

  private Dataset dataset;
  private String returnType = XML;

  /**
   * Instantiates a new relationship extraction service.
   */
  public RelationshipExtraction() {
    super(SERVICE_NAME);
    setEndPoint(URL);
  }

  /**
   * Instantiates a new relationship extraction service by username and password.
   * @param username the username
   * @param password the password
   */
  public RelationshipExtraction(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
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
  public ServiceCall<String> extract(final String text) {
    Validator.notNull(dataset, "dataset cannot be null");
    Validator.notNull(text, "text cannot be null");

    final Request request =
        RequestBuilder.post("/v1/sire/0").form(SID, dataset.getId(), RETURN_TYPE, returnType, TEXT, text).build();
    return createServiceCall(request, ResponseConverterUtils.getString());
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
      this.returnType = XML;
    } else if (returnType == ReturnType.JSON) {
      this.returnType = JSON;
    }
  }

}
