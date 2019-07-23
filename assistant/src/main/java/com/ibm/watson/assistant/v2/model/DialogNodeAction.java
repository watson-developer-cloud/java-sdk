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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.Map;

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
    /** web-action. */
    String WEB_ACTION = "web-action";
    /** cloud-function. */
    String CLOUD_FUNCTION = "cloud-function";
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
}
