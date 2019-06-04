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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Options that modify how specified output is handled.
 */
public class DialogNodeOutputModifiers extends GenericModel {

  private Boolean overwrite;

  /**
   * Gets the overwrite.
   *
   * Whether values in the output will overwrite output values in an array specified by previously executed dialog
   * nodes. If this option is set to `false`, new values will be appended to previously specified values.
   *
   * @return the overwrite
   */
  public Boolean isOverwrite() {
    return overwrite;
  }

  /**
   * Sets the overwrite.
   *
   * @param overwrite the new overwrite
   */
  public void setOverwrite(final Boolean overwrite) {
    this.overwrite = overwrite;
  }
}
