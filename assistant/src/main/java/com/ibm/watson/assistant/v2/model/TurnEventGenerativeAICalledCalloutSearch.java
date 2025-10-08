/*
 * (C) Copyright IBM Corp. 2025.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** TurnEventGenerativeAICalledCalloutSearch. */
public class TurnEventGenerativeAICalledCalloutSearch extends GenericModel {

  protected String engine;
  protected String index;
  protected String query;
  protected TurnEventGenerativeAICalledCalloutRequest request;
  protected TurnEventGenerativeAICalledCalloutResponse response;

  protected TurnEventGenerativeAICalledCalloutSearch() {}

  /**
   * Gets the engine.
   *
   * <p>The search engine that was used to scan the documents.
   *
   * @return the engine
   */
  public String getEngine() {
    return engine;
  }

  /**
   * Gets the index.
   *
   * <p>The name of the Elasticsearch index being used. This field is only available if the engine
   * being used is Elasticsearch.
   *
   * @return the index
   */
  public String getIndex() {
    return index;
  }

  /**
   * Gets the query.
   *
   * <p>The query that will be used by the system to initiate search on the document search engine.
   *
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * Gets the request.
   *
   * @return the request
   */
  public TurnEventGenerativeAICalledCalloutRequest getRequest() {
    return request;
  }

  /**
   * Gets the response.
   *
   * @return the response
   */
  public TurnEventGenerativeAICalledCalloutResponse getResponse() {
    return response;
  }
}
