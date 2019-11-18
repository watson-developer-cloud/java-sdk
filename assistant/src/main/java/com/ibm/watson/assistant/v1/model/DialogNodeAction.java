/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DialogNodeAction.
 */
public class DialogNodeAction extends GenericModel {

  /**
   * The type of action to invoke.
   */
  public interface Type {
    /** client. */
    String CLIENT = "client";
    /** server. */
    String SERVER = "server";
    /** cloud_function. */
    String CLOUD_FUNCTION = "cloud_function";
    /** web_action. */
    String WEB_ACTION = "web_action";
    /** webhook. */
    String WEBHOOK = "webhook";
  }

  private String name;
  private String type;
  private Map<String, Object> parameters;
  @SerializedName("result_variable")
  private String resultVariable;
  private String credentials;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String type;
    private Map<String, Object> parameters;
    private String resultVariable;
    private String credentials;

    private Builder(DialogNodeAction dialogNodeAction) {
      this.name = dialogNodeAction.name;
      this.type = dialogNodeAction.type;
      this.parameters = dialogNodeAction.parameters;
      this.resultVariable = dialogNodeAction.resultVariable;
      this.credentials = dialogNodeAction.credentials;
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
     * Set the type.
     *
     * @param type the type
     * @return the DialogNodeAction builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the DialogNodeAction builder
     */
    public Builder parameters(Map<String, Object> parameters) {
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
        "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resultVariable,
        "resultVariable cannot be null");
    name = builder.name;
    type = builder.type;
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
   * Gets the type.
   *
   * The type of action to invoke.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the parameters.
   *
   * A map of key/value pairs to be provided to the action.
   *
   * @return the parameters
   */
  public Map<String, Object> parameters() {
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
