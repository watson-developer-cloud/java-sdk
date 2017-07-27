/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Conversation used by the {@link DialogService}.
 *
 *
 */
public class Conversation extends GenericModel {
  @SerializedName("client_id")
  private Integer clientId;
  private Double confidence;
  private String dialogId;
  @SerializedName("conversation_id")
  private Integer id;
  private String input;
  private List<String> response;

  /**
   * Gets the client id.
   *
   * @return The clientId
   */
  public Integer getClientId() {
    return clientId;
  }

  /**
   * Gets the confidence.
   *
   * @return The confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the dialog id.
   *
   * @return the dialogId
   */
  public String getDialogId() {
    return dialogId;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Gets the input.
   *
   * @return The input
   */
  public String getInput() {
    return input;
  }

  /**
   * Gets the response.
   *
   * @return The response
   */
  public List<String> getResponse() {
    return response;
  }

  /**
   * Sets the client id.
   *
   * @param clientId The client_id
   */
  public void setClientId(final int clientId) {
    this.clientId = clientId;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence The confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Sets the dialog id.
   *
   * @param dialogId the dialogId to set
   */
  public void setDialogId(String dialogId) {
    this.dialogId = dialogId;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Sets the input.
   *
   * @param input The input
   */
  public void setInput(final String input) {
    this.input = input;
  }

  /**
   * Sets the response.
   *
   * @param response The response
   */
  public void setResponse(final List<String> response) {
    this.response = response;
  }
}
