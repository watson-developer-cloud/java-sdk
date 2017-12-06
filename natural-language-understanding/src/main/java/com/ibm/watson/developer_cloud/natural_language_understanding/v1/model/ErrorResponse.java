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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ErrorResponse.
 */
public class ErrorResponse extends GenericModel {

  private Long code;
  private String error;

  /**
   * Gets the code.
   *
   * The HTTP error status code
   *
   * @return the code
   */
  public Long getCode() {
    return code;
  }

  /**
   * Gets the error.
   *
   * A message describing the error
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Sets the code.
   *
   * @param code the new code
   */
  public void setCode(final long code) {
    this.code = code;
  }

  /**
   * Sets the error.
   *
   * @param error the new error
   */
  public void setError(final String error) {
    this.error = error;
  }
}
