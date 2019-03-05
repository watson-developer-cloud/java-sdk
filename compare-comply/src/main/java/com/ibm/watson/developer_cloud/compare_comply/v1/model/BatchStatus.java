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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The batch-request status.
 */
public class BatchStatus extends GenericModel {

  /**
   * The method to be run against the documents. Possible values are `html_conversion`, `element_classification`, and
   * `tables`.
   */
  public interface Function {
    /** element_classification. */
    String ELEMENT_CLASSIFICATION = "element_classification";
    /** html_conversion. */
    String HTML_CONVERSION = "html_conversion";
    /** tables. */
    String TABLES = "tables";
  }

  private String function;
  @SerializedName("input_bucket_location")
  private String inputBucketLocation;
  @SerializedName("input_bucket_name")
  private String inputBucketName;
  @SerializedName("output_bucket_location")
  private String outputBucketLocation;
  @SerializedName("output_bucket_name")
  private String outputBucketName;
  @SerializedName("batch_id")
  private String batchId;
  @SerializedName("document_counts")
  private DocCounts documentCounts;
  private String status;
  private Date created;
  private Date updated;

  /**
   * Gets the function.
   *
   * The method to be run against the documents. Possible values are `html_conversion`, `element_classification`, and
   * `tables`.
   *
   * @return the function
   */
  public String getFunction() {
    return function;
  }

  /**
   * Gets the inputBucketLocation.
   *
   * The geographical location of the Cloud Object Storage input bucket as listed on the **Endpoint** tab of your COS
   * instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the inputBucketLocation
   */
  public String getInputBucketLocation() {
    return inputBucketLocation;
  }

  /**
   * Gets the inputBucketName.
   *
   * The name of the Cloud Object Storage input bucket.
   *
   * @return the inputBucketName
   */
  public String getInputBucketName() {
    return inputBucketName;
  }

  /**
   * Gets the outputBucketLocation.
   *
   * The geographical location of the Cloud Object Storage output bucket as listed on the **Endpoint** tab of your COS
   * instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the outputBucketLocation
   */
  public String getOutputBucketLocation() {
    return outputBucketLocation;
  }

  /**
   * Gets the outputBucketName.
   *
   * The name of the Cloud Object Storage output bucket.
   *
   * @return the outputBucketName
   */
  public String getOutputBucketName() {
    return outputBucketName;
  }

  /**
   * Gets the batchId.
   *
   * The unique identifier for the batch request.
   *
   * @return the batchId
   */
  public String getBatchId() {
    return batchId;
  }

  /**
   * Gets the documentCounts.
   *
   * Document counts.
   *
   * @return the documentCounts
   */
  public DocCounts getDocumentCounts() {
    return documentCounts;
  }

  /**
   * Gets the status.
   *
   * The status of the batch request.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * The creation time of the batch request.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The time of the most recent update to the batch request.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
