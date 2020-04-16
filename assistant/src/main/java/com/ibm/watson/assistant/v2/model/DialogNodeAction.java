/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** DialogNodeAction. */
public class DialogNodeAction extends GenericModel {

  /** The type of action to invoke. */
  public interface Type {
    /** client. */
    String CLIENT = "client";
    /** server. */
    String SERVER = "server";
    /** web-action. */
    String WEB_ACTION = "web-action";
    /** cloud-function. */
    String CLOUD_FUNCTION = "cloud-function";
  }

  protected String name;
  protected String type;
  protected Map<String, Object> parameters;

  @SerializedName("result_variable")
  protected String resultVariable;

  protected String credentials;

  /**
   * Gets the name.
   *
   * <p>The name of the action.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * <p>The type of action to invoke.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the parameters.
   *
   * <p>A map of key/value pairs to be provided to the action.
   *
   * @return the parameters
   */
  public Map<String, Object> getParameters() {
    return parameters;
  }

  /**
   * Gets the resultVariable.
   *
   * <p>The location in the dialog context where the result of the action is stored.
   *
   * @return the resultVariable
   */
  public String getResultVariable() {
    return resultVariable;
  }

  /**
   * Gets the credentials.
   *
   * <p>The name of the context variable that the client application will use to pass in credentials
   * for the action.
   *
   * @return the credentials
   */
  public String getCredentials() {
    return credentials;
  }
}
