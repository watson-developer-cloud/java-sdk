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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Returns a five-level taxonomy of the content. The top three categories are returned.
 *
 * Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
 *
 * NOTE: This model will be changed to extend GenericModel in the next release, meaning that it won't support Map
 * functions like get and put. In the meantime, any additional properties added to this model will not be supported
 * by the service.
 */
public class CategoriesOptions extends DynamicModel {

  private Long limit;

  /**
   * Gets the limit.
   *
   * Maximum number of categories to return.
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
