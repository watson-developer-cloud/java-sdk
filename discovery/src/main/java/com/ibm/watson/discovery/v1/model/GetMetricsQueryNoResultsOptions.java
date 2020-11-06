/*
 * (C) Copyright IBM Corp. 2020.
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
import java.util.Date;

/** The getMetricsQueryNoResults options. */
public class GetMetricsQueryNoResultsOptions extends GenericModel {

  /** The type of result to consider when calculating the metric. */
  public interface ResultType {
    /** document. */
    String DOCUMENT = "document";
  }

  protected Date startTime;
  protected Date endTime;
  protected String resultType;

  /** Builder. */
  public static class Builder {
    private Date startTime;
    private Date endTime;
    private String resultType;

    private Builder(GetMetricsQueryNoResultsOptions getMetricsQueryNoResultsOptions) {
      this.startTime = getMetricsQueryNoResultsOptions.startTime;
      this.endTime = getMetricsQueryNoResultsOptions.endTime;
      this.resultType = getMetricsQueryNoResultsOptions.resultType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a GetMetricsQueryNoResultsOptions.
     *
     * @return the new GetMetricsQueryNoResultsOptions instance
     */
    public GetMetricsQueryNoResultsOptions build() {
      return new GetMetricsQueryNoResultsOptions(this);
    }

    /**
     * Set the startTime.
     *
     * @param startTime the startTime
     * @return the GetMetricsQueryNoResultsOptions builder
     */
    public Builder startTime(Date startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * Set the endTime.
     *
     * @param endTime the endTime
     * @return the GetMetricsQueryNoResultsOptions builder
     */
    public Builder endTime(Date endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * Set the resultType.
     *
     * @param resultType the resultType
     * @return the GetMetricsQueryNoResultsOptions builder
     */
    public Builder resultType(String resultType) {
      this.resultType = resultType;
      return this;
    }
  }

  protected GetMetricsQueryNoResultsOptions(Builder builder) {
    startTime = builder.startTime;
    endTime = builder.endTime;
    resultType = builder.resultType;
  }

  /**
   * New builder.
   *
   * @return a GetMetricsQueryNoResultsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the startTime.
   *
   * <p>Metric is computed from data recorded after this timestamp; must be in
   * `YYYY-MM-DDThh:mm:ssZ` format.
   *
   * @return the startTime
   */
  public Date startTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * <p>Metric is computed from data recorded before this timestamp; must be in
   * `YYYY-MM-DDThh:mm:ssZ` format.
   *
   * @return the endTime
   */
  public Date endTime() {
    return endTime;
  }

  /**
   * Gets the resultType.
   *
   * <p>The type of result to consider when calculating the metric.
   *
   * @return the resultType
   */
  public String resultType() {
    return resultType;
  }
}
