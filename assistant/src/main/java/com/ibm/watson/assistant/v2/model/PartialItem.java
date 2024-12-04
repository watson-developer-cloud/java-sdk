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

/** Message response partial item content. */
public class PartialItem extends GenericModel {

  @SerializedName("response_type")
  protected String responseType;

  protected String text;

  @SerializedName("streaming_metadata")
  protected Metadata streamingMetadata;

  protected PartialItem() {}

  /**
   * Gets the responseType.
   *
   * <p>The type of response returned by the dialog node. The specified response type must be
   * supported by the client application or channel.
   *
   * @return the responseType
   */
  public String getResponseType() {
    return responseType;
  }

  /**
   * Gets the text.
   *
   * <p>The text within the partial chunk of the message stream response.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the streamingMetadata.
   *
   * <p>Contains meta-information about the item(s) being streamed.
   *
   * @return the streamingMetadata
   */
  public Metadata getStreamingMetadata() {
    return streamingMetadata;
  }
}
