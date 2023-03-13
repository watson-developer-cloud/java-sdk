/*
 * (C) Copyright IBM Corp. 2018, 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Object describing the current status of the wordlist. */
public class TokenDictStatusResponse extends GenericModel {

  /** Current wordlist status for the specified collection. */
  public interface Status {
    /** active. */
    String ACTIVE = "active";
    /** pending. */
    String PENDING = "pending";
    /** not found. */
    String NOT_FOUND = "not found";
  }

  protected String status;
  protected String type;

  protected TokenDictStatusResponse() {}

  /**
   * Gets the status.
   *
   * <p>Current wordlist status for the specified collection.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the type.
   *
   * <p>The type for this wordlist. Can be `tokenization_dictionary` or `stopwords`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}
