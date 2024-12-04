/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A suggested additional query term or terms user to filter results. **Note**: The
 * `suggested_refinements` parameter is deprecated.
 */
public class QuerySuggestedRefinement extends GenericModel {

  protected String text;

  protected QuerySuggestedRefinement() {}

  /**
   * Gets the text.
   *
   * <p>The text used to filter.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }
}
