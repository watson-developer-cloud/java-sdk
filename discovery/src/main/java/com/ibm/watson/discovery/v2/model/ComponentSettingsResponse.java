/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** The default component settings for this project. */
public class ComponentSettingsResponse extends GenericModel {

  @SerializedName("fields_shown")
  protected ComponentSettingsFieldsShown fieldsShown;

  protected Boolean autocomplete;

  @SerializedName("structured_search")
  protected Boolean structuredSearch;

  @SerializedName("results_per_page")
  protected Long resultsPerPage;

  protected List<ComponentSettingsAggregation> aggregations;

  protected ComponentSettingsResponse() {}

  /**
   * Gets the fieldsShown.
   *
   * <p>Fields shown in the results section of the UI.
   *
   * @return the fieldsShown
   */
  public ComponentSettingsFieldsShown getFieldsShown() {
    return fieldsShown;
  }

  /**
   * Gets the autocomplete.
   *
   * <p>Whether or not autocomplete is enabled.
   *
   * @return the autocomplete
   */
  public Boolean isAutocomplete() {
    return autocomplete;
  }

  /**
   * Gets the structuredSearch.
   *
   * <p>Whether or not structured search is enabled.
   *
   * @return the structuredSearch
   */
  public Boolean isStructuredSearch() {
    return structuredSearch;
  }

  /**
   * Gets the resultsPerPage.
   *
   * <p>Number or results shown per page.
   *
   * @return the resultsPerPage
   */
  public Long getResultsPerPage() {
    return resultsPerPage;
  }

  /**
   * Gets the aggregations.
   *
   * <p>a list of component setting aggregations.
   *
   * @return the aggregations
   */
  public List<ComponentSettingsAggregation> getAggregations() {
    return aggregations;
  }
}
