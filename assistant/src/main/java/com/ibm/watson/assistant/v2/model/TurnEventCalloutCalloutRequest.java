/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Map;

/** TurnEventCalloutCalloutRequest. */
public class TurnEventCalloutCalloutRequest extends GenericModel {

  /** The REST method of the request. */
  public interface Method {
    /** get. */
    String GET = "get";
    /** post. */
    String POST = "post";
    /** put. */
    String PUT = "put";
    /** delete. */
    String DELETE = "delete";
    /** patch. */
    String PATCH = "patch";
  }

  protected String method;
  protected String url;
  protected String path;

  @SerializedName("query_parameters")
  protected String queryParameters;

  protected Map<String, Object> headers;
  protected Map<String, Object> body;

  protected TurnEventCalloutCalloutRequest() {}

  /**
   * Gets the method.
   *
   * <p>The REST method of the request.
   *
   * @return the method
   */
  public String getMethod() {
    return method;
  }

  /**
   * Gets the url.
   *
   * <p>The host URL of the request call.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the path.
   *
   * <p>The URL path of the request call.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Gets the queryParameters.
   *
   * <p>Any query parameters appended to the URL of the request call.
   *
   * @return the queryParameters
   */
  public String getQueryParameters() {
    return queryParameters;
  }

  /**
   * Gets the headers.
   *
   * <p>Any headers included in the request call.
   *
   * @return the headers
   */
  public Map<String, Object> getHeaders() {
    return headers;
  }

  /**
   * Gets the body.
   *
   * <p>Contains the response of the external server or an object. In cases like timeouts or
   * connections errors, it will contain details of why the callout to the external server failed.
   *
   * @return the body
   */
  public Map<String, Object> getBody() {
    return body;
  }
}
