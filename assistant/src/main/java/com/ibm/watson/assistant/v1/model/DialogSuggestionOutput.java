/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.assistant.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * The dialog output that will be returned from the Watson Assistant service if the user selects the corresponding
 * option.
 */
public class DialogSuggestionOutput extends DynamicModel<Object> {

  @SerializedName("nodes_visited")
  protected List<String> nodesVisited;
  @SerializedName("nodes_visited_details")
  protected List<DialogNodeVisitedDetails> nodesVisitedDetails;
  @SerializedName("text")
  protected List<String> text;
  @SerializedName("generic")
  protected List<DialogSuggestionResponseGeneric> generic;

  public DialogSuggestionOutput() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Gets the nodesVisited.
   *
   * An array of the nodes that were triggered to create the response, in the order in which they were visited. This
   * information is useful for debugging and for tracing the path taken through the node tree.
   *
   * @return the nodesVisited
   */
  public List<String> getNodesVisited() {
    return this.nodesVisited;
  }

  /**
   * Sets the nodesVisited.
   *
   * @param nodesVisited the new nodesVisited
   */
  public void setNodesVisited(final List<String> nodesVisited) {
    this.nodesVisited = nodesVisited;
  }

  /**
   * Gets the nodesVisitedDetails.
   *
   * An array of objects containing detailed diagnostic information about the nodes that were triggered during
   * processing of the input message. Included only if **nodes_visited_details** is set to `true` in the message
   * request.
   *
   * @return the nodesVisitedDetails
   */
  public List<DialogNodeVisitedDetails> getNodesVisitedDetails() {
    return this.nodesVisitedDetails;
  }

  /**
   * Sets the nodesVisitedDetails.
   *
   * @param nodesVisitedDetails the new nodesVisitedDetails
   */
  public void setNodesVisitedDetails(final List<DialogNodeVisitedDetails> nodesVisitedDetails) {
    this.nodesVisitedDetails = nodesVisitedDetails;
  }

  /**
   * Gets the text.
   *
   * An array of responses to the user.
   *
   * @return the text
   */
  public List<String> getText() {
    return this.text;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final List<String> text) {
    this.text = text;
  }

  /**
   * Gets the generic.
   *
   * Output intended for any channel. It is the responsibility of the client application to implement the supported
   * response types.
   *
   * @return the generic
   */
  public List<DialogSuggestionResponseGeneric> getGeneric() {
    return this.generic;
  }

  /**
   * Sets the generic.
   *
   * @param generic the new generic
   */
  public void setGeneric(final List<DialogSuggestionResponseGeneric> generic) {
    this.generic = generic;
  }
}
