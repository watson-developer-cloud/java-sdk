/*
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DialogNodeAction.
 */
public class DialogNodeAction extends GenericModel {

  /**
   * The type of action to invoke.
   */
  public interface ActionType {
    /** client. */
    String CLIENT = "client";
    /** server. */
    String SERVER = "server";
  }

  private String name;
  @SerializedName("type")
  private String actionType;
  private Map parameters;
  @SerializedName("result_variable")
  private String resultVariable;
  private String credentials;

  /**
   * Gets the name.
   *
   * The name of the action.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the actionType.
   *
   * The type of action to invoke.
   *
   * @return the actionType
   */
  public String getActionType() {
    return actionType;
  }

  /**
   * Gets the parameters.
   *
   * A map of key/value pairs to be provided to the action.
   *
   * @return the parameters
   */
  public Map getParameters() {
    return parameters;
  }

  /**
   * Gets the resultVariable.
   *
   * The location in the dialog context where the result of the action is stored.
   *
   * @return the resultVariable
   */
  public String getResultVariable() {
    return resultVariable;
  }

  /**
   * Gets the credentials.
   *
   * The name of the context variable that the client application will use to pass in credentials for the action.
   *
   * @return the credentials
   */
  public String getCredentials() {
    return credentials;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the actionType.
   *
   * @param actionType the new actionType
   */
  public void setActionType(final String actionType) {
    this.actionType = actionType;
  }

  /**
   * Sets the parameters.
   *
   * @param parameters the new parameters
   */
  public void setParameters(final Map parameters) {
    this.parameters = parameters;
  }

  /**
   * Sets the resultVariable.
   *
   * @param resultVariable the new resultVariable
   */
  public void setResultVariable(final String resultVariable) {
    this.resultVariable = resultVariable;
  }

  /**
   * Sets the credentials.
   *
   * @param credentials the new credentials
   */
  public void setCredentials(final String credentials) {
    this.credentials = credentials;
  }
}
