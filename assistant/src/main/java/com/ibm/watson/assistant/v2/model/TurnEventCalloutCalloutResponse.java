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

/** TurnEventCalloutCalloutResponse. */
public class TurnEventCalloutCalloutResponse extends GenericModel {

  protected String body;

  @SerializedName("status_code")
  protected Long statusCode;

  @SerializedName("last_event")
  protected Map<String, Object> lastEvent;

  protected TurnEventCalloutCalloutResponse() {}

  /**
   * Gets the body.
   *
   * <p>The final response string. This response is a composition of every partial chunk received
   * from the stream.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Gets the statusCode.
   *
   * <p>The final status code of the response.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the lastEvent.
   *
   * <p>The response from the last chunk received from the response stream.
   *
   * @return the lastEvent
   */
  public Map<String, Object> getLastEvent() {
    return lastEvent;
  }
}
