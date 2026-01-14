/*
 * (C) Copyright IBM Corp. 2026.
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

/** DtmfCommandInfo. */
public class DtmfCommandInfo extends GenericModel {

  /** Specifies the type of DTMF command for the phone integration. */
  public interface Type {
    /** collect. */
    String COLLECT = "collect";
    /** disable_barge_in. */
    String DISABLE_BARGE_IN = "disable_barge_in";
    /** enable_barge_in. */
    String ENABLE_BARGE_IN = "enable_barge_in";
    /** send. */
    String SEND = "send";
  }

  protected String type;
  protected Map<String, Object> parameters;

  protected DtmfCommandInfo() {}

  /**
   * Gets the type.
   *
   * <p>Specifies the type of DTMF command for the phone integration.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the parameters.
   *
   * <p>Parameters specified by the command type.
   *
   * @return the parameters
   */
  public Map<String, Object> getParameters() {
    return parameters;
  }
}
