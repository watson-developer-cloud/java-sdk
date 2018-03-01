/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.developer_cloud.util.Validator;

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
   * Builder.
   */
  public static class Builder {
    private String name;
    private String actionType;
    private Map parameters;
    private String resultVariable;
    private String credentials;

    private Builder(DialogNodeAction dialogNodeAction) {
      name = dialogNodeAction.name;
      actionType = dialogNodeAction.actionType;
      parameters = dialogNodeAction.parameters;
      resultVariable = dialogNodeAction.resultVariable;
      credentials = dialogNodeAction.credentials;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param resultVariable the resultVariable
     */
    public Builder(String name, String resultVariable) {
      this.name = name;
      this.resultVariable = resultVariable;
    }

    /**
     * Builds a DialogNodeAction.
     *
     * @return the dialogNodeAction
     */
    public DialogNodeAction build() {
      return new DialogNodeAction(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the DialogNodeAction builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the actionType.
     *
     * @param actionType the actionType
     * @return the DialogNodeAction builder
     */
    public Builder actionType(String actionType) {
      this.actionType = actionType;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the DialogNodeAction builder
     */
    public Builder parameters(Map parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the resultVariable.
     *
     * @param resultVariable the resultVariable
     * @return the DialogNodeAction builder
     */
    public Builder resultVariable(String resultVariable) {
      this.resultVariable = resultVariable;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the DialogNodeAction builder
     */
    public Builder credentials(String credentials) {
      this.credentials = credentials;
      return this;
    }
  }

  private DialogNodeAction(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.notNull(builder.resultVariable, "resultVariable cannot be null");
    name = builder.name;
    actionType = builder.actionType;
    parameters = builder.parameters;
    resultVariable = builder.resultVariable;
    credentials = builder.credentials;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeAction builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the action.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the actionType.
   *
   * The type of action to invoke.
   *
   * @return the actionType
   */
  public String actionType() {
    return actionType;
  }

  /**
   * Gets the parameters.
   *
   * A map of key/value pairs to be provided to the action.
   *
   * @return the parameters
   */
  public Map parameters() {
    return parameters;
  }

  /**
   * Gets the resultVariable.
   *
   * The location in the dialog context where the result of the action is stored.
   *
   * @return the resultVariable
   */
  public String resultVariable() {
    return resultVariable;
  }

  /**
   * Gets the credentials.
   *
   * The name of the context variable that the client application will use to pass in credentials for the action.
   *
   * @return the credentials
   */
  public String credentials() {
    return credentials;
  }
}
