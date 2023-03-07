/*
 * (C) Copyright IBM Corp. 2023.
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

/** Display settings for aggregations. */
public class ComponentSettingsAggregation extends GenericModel {

  /** Type of visualization to use when rendering the aggregation. */
  public interface VisualizationType {
    /** auto. */
    String AUTO = "auto";
    /** facet_table. */
    String FACET_TABLE = "facet_table";
    /** word_cloud. */
    String WORD_CLOUD = "word_cloud";
    /** map. */
    String MAP = "map";
  }

  protected String name;
  protected String label;

  @SerializedName("multiple_selections_allowed")
  protected Boolean multipleSelectionsAllowed;

  @SerializedName("visualization_type")
  protected String visualizationType;

  protected ComponentSettingsAggregation() {}

  /**
   * Gets the name.
   *
   * <p>Identifier used to map aggregation settings to aggregation configuration.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the label.
   *
   * <p>User-friendly alias for the aggregation.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the multipleSelectionsAllowed.
   *
   * <p>Whether users is allowed to select more than one of the aggregation terms.
   *
   * @return the multipleSelectionsAllowed
   */
  public Boolean isMultipleSelectionsAllowed() {
    return multipleSelectionsAllowed;
  }

  /**
   * Gets the visualizationType.
   *
   * <p>Type of visualization to use when rendering the aggregation.
   *
   * @return the visualizationType
   */
  public String getVisualizationType() {
    return visualizationType;
  }
}
