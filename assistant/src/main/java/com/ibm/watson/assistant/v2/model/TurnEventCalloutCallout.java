/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Map;

/** TurnEventCalloutCallout. */
public class TurnEventCalloutCallout extends GenericModel {

  /** callout type. */
  public interface Type {
    /** integration_interaction. */
    String INTEGRATION_INTERACTION = "integration_interaction";
  }

  protected String type;
  protected Map<String, Object> internal;

  /**
   * Gets the type.
   *
   * <p>callout type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the internal.
   *
   * <p>For internal use only.
   *
   * @return the internal
   */
  public Map<String, Object> getInternal() {
    return internal;
  }
}
