/**
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

package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.util.ColumnTypeAdapter;

/**
 * {@link TradeoffAnalytics} column.
 */
@JsonAdapter(ColumnTypeAdapter.class)
public abstract class Column extends GenericModel {

  /**
   * The Enum ColumnType.
   */
  public enum ColumnType {

    /** The categorical. */
    CATEGORICAL("categorical"),

    /** The datetime. */
    DATETIME("datetime"),

    /** The numeric. */
    NUMERIC("numeric"),

    /** The text. */
    TEXT("text");

    /**
     * From string.
     *
     * @param text the text
     * @return the column type, or null if none found
     */
    public static ColumnType fromString(String text) {
      if (text != null) {
        for (final ColumnType col : ColumnType.values()) {
          if (text.equalsIgnoreCase(col.type)) {
            return col;
          }
        }
      }
      return null;
    }

    /** The type. */
    private final String type;

    /**
     * Instantiates a new column type.
     *
     * @param columnType the column type
     */
    ColumnType(String columnType) {
      type = columnType;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return type;
    }
  }

  /**
   * The Enum Goal.
   */
  public enum Goal {

    /** The max. */
    MAX("max"),

    /** The min. */
    MIN("min");

    /**
     * From string.
     *
     * @param text the text
     * @return the goal, or null if none found
     */
    public static Goal fromString(String text) {
      if (text != null) {
        for (final Goal goal : Goal.values()) {
          if (text.equalsIgnoreCase(goal.goal)) {
            return goal;
          }
        }
      }
      return null;
    }

    /** The goal. */
    private final String goal;

    /**
     * Instantiates a new goal.
     *
     * @param goal the goal
     */
    Goal(String goal) {
      this.goal = goal;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return goal;
    }

  }

  /** The description. */
  private String description;

  /** The format. */
  private String format;

  /** The full name. */
  @SerializedName("full_name")
  private String fullName;

  /** The goal. */
  private Goal goal;

  /** The insignificant loss. */
  @SerializedName("insignificant_loss")
  private Double insignificantLoss;

  /** The key. */
  private String key;

  /** The is objective. */
  @SerializedName("is_objective")
  private Boolean objective;

  /** The significant gain. */
  @SerializedName("significant_gain")
  private Double significantGain;

  /** The significant loss. */
  @SerializedName("significant_loss")
  private Double significantLoss;

  /** The type. */
  private ColumnType type;

  /**
   * Instantiates a new column.
   *
   * @param type the type
   */
  public Column(ColumnType type) {
    this.type = type;
  }

  /**
   * Sets the type.
   *
   * @param type The type
   */
  protected void setType(ColumnType type) {
    this.type = type;
  }

  /**
   * Sets the full name.
   *
   * @param fullName the full name
   * @return the column
   */
  public Column fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the format.
   *
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * Gets the full name.
   *
   * @return The fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Gets the goal.
   *
   * @return The goal
   */
  public Goal getGoal() {
    return goal;
  }

  /**
   * Gets the insignificant loss.
   *
   * @return the insignificant loss
   */
  public Double getInsignificantLoss() {
    return insignificantLoss;
  }

  /**
   * Gets the key.
   *
   * @return The key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the significant gain.
   *
   * @return the significant gain
   */
  public Double getSignificantGain() {
    return significantGain;
  }

  /**
   * Gets the significant loss.
   *
   * @return the significant loss
   */
  public Double getSignificantLoss() {
    return significantLoss;
  }

  /**
   * Gets the type.
   *
   * @return The type
   */
  public ColumnType getType() {
    return type;
  }

  /**
   * Sets the goal.
   *
   * @param goal the goal
   * @return the column
   */
  public Column goal(Goal goal) {
    this.goal = goal;
    return this;
  }

  /**
   * Checks if is objective.
   *
   * @return true, if is objective
   */
  public Boolean isObjective() {
    return objective;
  }

  /**
   * Sets the key.
   *
   * @param key the key
   * @return the column
   */
  public Column key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Sets is objective.
   *
   * @param objective the is objective
   * @return the column
   */
  public Column objective(boolean objective) {
    this.objective = objective;
    return this;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the format.
   *
   * @param format the new format
   */
  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * Sets the full name.
   *
   * @param fullName The full_name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Sets the goal.
   *
   * @param goal The goal
   */
  public void setGoal(Goal goal) {
    this.goal = goal;
  }

  /**
   * Sets the insignificant loss.
   *
   * @param insignificantLoss the new insignificant loss
   */
  public void setInsignificantLoss(Double insignificantLoss) {
    this.insignificantLoss = insignificantLoss;
  }

  /**
   * Sets the key.
   *
   * @param key The key
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Sets the checks if is objective.
   *
   * @param objective The is_objective
   */
  public void setObjective(boolean objective) {
    this.objective = objective;
  }

  /**
   * Sets the significant gain.
   *
   * @param significantGain the new significant gain
   */
  public void setSignificantGain(Double significantGain) {
    this.significantGain = significantGain;
  }

  /**
   * Sets the significant loss.
   *
   * @param significantLoss the new significant loss
   */
  public void setSignificantLoss(Double significantLoss) {
    this.significantLoss = significantLoss;
  }
}
