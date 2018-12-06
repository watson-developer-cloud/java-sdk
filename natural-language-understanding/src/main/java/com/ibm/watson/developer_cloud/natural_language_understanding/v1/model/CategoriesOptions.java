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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Returns a five-level taxonomy of the content. The top three categories are returned.
 *
 * Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
 */
public class CategoriesOptions extends GenericModel {

  private Long limit;

  /**
   * Gets the limit.
   *
   * Maximum number of categories to return.
   * Maximum value: **10**.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }
}
