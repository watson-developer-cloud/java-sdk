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
import java.util.Date;

/** The getMetricsEventRate options. */
public class GetMetricsEventRateOptions extends GenericModel {

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

    /**
     * Instantiates a new Builder from an existing GetMetricsEventRateOptions instance.
     *
     * @param getMetricsEventRateOptions the instance to initialize the Builder with
     */
    private Builder(GetMetricsEventRateOptions getMetricsEventRateOptions) {
      this.startTime = getMetricsEventRateOptions.startTime;
      this.endTime = getMetricsEventRateOptions.endTime;
      this.resultType = getMetricsEventRateOptions.resultType;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a GetMetricsEventRateOptions.
     *
     * @return the new GetMetricsEventRateOptions instance
     */
    public GetMetricsEventRateOptions build() {
      return new GetMetricsEventRateOptions(this);
    }

    /**
     * Set the startTime.
     *
     * @param startTime the startTime
     * @return the GetMetricsEventRateOptions builder
     */
    public Builder startTime(Date startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * Set the endTime.
     *
     * @param endTime the endTime
     * @return the GetMetricsEventRateOptions builder
     */
    public Builder endTime(Date endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * Set the resultType.
     *
     * @param resultType the resultType
     * @return the GetMetricsEventRateOptions builder
     */
    public Builder resultType(String resultType) {
      this.resultType = resultType;
      return this;
    }
  }

  protected GetMetricsEventRateOptions() {}

  protected GetMetricsEventRateOptions(Builder builder) {
    startTime = builder.startTime;
    endTime = builder.endTime;
    resultType = builder.resultType;
  }

  /**
   * New builder.
   *
   * @return a GetMetricsEventRateOptions builder
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
