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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createBatch options.
 */
public class CreateBatchOptions extends GenericModel {

  /**
   * The Compare and Comply method to run across the submitted input documents.
   */
  public interface Function {
    /** html_conversion. */
    String HTML_CONVERSION = "html_conversion";
    /** element_classification. */
    String ELEMENT_CLASSIFICATION = "element_classification";
    /** tables. */
    String TABLES = "tables";
  }

  /**
   * The analysis model to be used by the service. For the `/v1/element_classification` and `/v1/comparison` methods,
   * the default is `contracts`. For the `/v1/tables` method, the default is `tables`. These defaults apply to the
   * standalone methods as well as to the methods' use in batch-processing requests.
   */
  public interface ModelId {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  private String function;
  private InputStream inputCredentialsFile;
  private String inputCredentialsFilename;
  private String inputBucketLocation;
  private String inputBucketName;
  private InputStream outputCredentialsFile;
  private String outputCredentialsFilename;
  private String outputBucketLocation;
  private String outputBucketName;
  private String modelId;

  /**
   * Builder.
   */
  public static class Builder {
    private String function;
    private InputStream inputCredentialsFile;
    private String inputCredentialsFilename;
    private String inputBucketLocation;
    private String inputBucketName;
    private InputStream outputCredentialsFile;
    private String outputCredentialsFilename;
    private String outputBucketLocation;
    private String outputBucketName;
    private String modelId;

    private Builder(CreateBatchOptions createBatchOptions) {
      function = createBatchOptions.function;
      inputCredentialsFile = createBatchOptions.inputCredentialsFile;
      inputCredentialsFilename = createBatchOptions.inputCredentialsFilename;
      inputBucketLocation = createBatchOptions.inputBucketLocation;
      inputBucketName = createBatchOptions.inputBucketName;
      outputCredentialsFile = createBatchOptions.outputCredentialsFile;
      outputCredentialsFilename = createBatchOptions.outputCredentialsFilename;
      outputBucketLocation = createBatchOptions.outputBucketLocation;
      outputBucketName = createBatchOptions.outputBucketName;
      modelId = createBatchOptions.modelId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param function the function
     * @param inputCredentialsFile the inputCredentialsFile
     * @param inputBucketLocation the inputBucketLocation
     * @param inputBucketName the inputBucketName
     * @param outputCredentialsFile the outputCredentialsFile
     * @param outputBucketLocation the outputBucketLocation
     * @param outputBucketName the outputBucketName
     */
    public Builder(String function, InputStream inputCredentialsFile, String inputBucketLocation,
        String inputBucketName, InputStream outputCredentialsFile, String outputBucketLocation,
        String outputBucketName) {
      this.function = function;
      this.inputCredentialsFile = inputCredentialsFile;
      this.inputBucketLocation = inputBucketLocation;
      this.inputBucketName = inputBucketName;
      this.outputCredentialsFile = outputCredentialsFile;
      this.outputBucketLocation = outputBucketLocation;
      this.outputBucketName = outputBucketName;
    }

    /**
     * Builds a CreateBatchOptions.
     *
     * @return the createBatchOptions
     */
    public CreateBatchOptions build() {
      return new CreateBatchOptions(this);
    }

    /**
     * Set the function.
     *
     * @param function the function
     * @return the CreateBatchOptions builder
     */
    public Builder function(String function) {
      this.function = function;
      return this;
    }

    /**
     * Set the inputCredentialsFile.
     *
     * @param inputCredentialsFile the inputCredentialsFile
     * @return the CreateBatchOptions builder
     */
    public Builder inputCredentialsFile(InputStream inputCredentialsFile) {
      this.inputCredentialsFile = inputCredentialsFile;
      return this;
    }

    /**
     * Set the inputCredentialsFilename.
     *
     * @param inputCredentialsFilename the inputCredentialsFilename
     * @return the CreateBatchOptions builder
     */
    public Builder inputCredentialsFilename(String inputCredentialsFilename) {
      this.inputCredentialsFilename = inputCredentialsFilename;
      return this;
    }

    /**
     * Set the inputBucketLocation.
     *
     * @param inputBucketLocation the inputBucketLocation
     * @return the CreateBatchOptions builder
     */
    public Builder inputBucketLocation(String inputBucketLocation) {
      this.inputBucketLocation = inputBucketLocation;
      return this;
    }

    /**
     * Set the inputBucketName.
     *
     * @param inputBucketName the inputBucketName
     * @return the CreateBatchOptions builder
     */
    public Builder inputBucketName(String inputBucketName) {
      this.inputBucketName = inputBucketName;
      return this;
    }

    /**
     * Set the outputCredentialsFile.
     *
     * @param outputCredentialsFile the outputCredentialsFile
     * @return the CreateBatchOptions builder
     */
    public Builder outputCredentialsFile(InputStream outputCredentialsFile) {
      this.outputCredentialsFile = outputCredentialsFile;
      return this;
    }

    /**
     * Set the outputCredentialsFilename.
     *
     * @param outputCredentialsFilename the outputCredentialsFilename
     * @return the CreateBatchOptions builder
     */
    public Builder outputCredentialsFilename(String outputCredentialsFilename) {
      this.outputCredentialsFilename = outputCredentialsFilename;
      return this;
    }

    /**
     * Set the outputBucketLocation.
     *
     * @param outputBucketLocation the outputBucketLocation
     * @return the CreateBatchOptions builder
     */
    public Builder outputBucketLocation(String outputBucketLocation) {
      this.outputBucketLocation = outputBucketLocation;
      return this;
    }

    /**
     * Set the outputBucketName.
     *
     * @param outputBucketName the outputBucketName
     * @return the CreateBatchOptions builder
     */
    public Builder outputBucketName(String outputBucketName) {
      this.outputBucketName = outputBucketName;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the CreateBatchOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the inputCredentialsFile.
     *
     * @param inputCredentialsFile the inputCredentialsFile
     * @return the CreateBatchOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder inputCredentialsFile(File inputCredentialsFile) throws FileNotFoundException {
      this.inputCredentialsFile = new FileInputStream(inputCredentialsFile);
      this.inputCredentialsFilename = inputCredentialsFile.getName();
      return this;
    }

    /**
     * Set the outputCredentialsFile.
     *
     * @param outputCredentialsFile the outputCredentialsFile
     * @return the CreateBatchOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder outputCredentialsFile(File outputCredentialsFile) throws FileNotFoundException {
      this.outputCredentialsFile = new FileInputStream(outputCredentialsFile);
      this.outputCredentialsFilename = outputCredentialsFile.getName();
      return this;
    }
  }

  private CreateBatchOptions(Builder builder) {
    Validator.notNull(builder.function, "function cannot be null");
    Validator.notNull(builder.inputCredentialsFile, "inputCredentialsFile cannot be null");
    Validator.notNull(builder.inputBucketLocation, "inputBucketLocation cannot be null");
    Validator.notNull(builder.inputBucketName, "inputBucketName cannot be null");
    Validator.notNull(builder.outputCredentialsFile, "outputCredentialsFile cannot be null");
    Validator.notNull(builder.outputBucketLocation, "outputBucketLocation cannot be null");
    Validator.notNull(builder.outputBucketName, "outputBucketName cannot be null");
    function = builder.function;
    inputCredentialsFile = builder.inputCredentialsFile;
    inputCredentialsFilename = builder.inputCredentialsFilename;
    inputBucketLocation = builder.inputBucketLocation;
    inputBucketName = builder.inputBucketName;
    outputCredentialsFile = builder.outputCredentialsFile;
    outputCredentialsFilename = builder.outputCredentialsFilename;
    outputBucketLocation = builder.outputBucketLocation;
    outputBucketName = builder.outputBucketName;
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a CreateBatchOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the function.
   *
   * The Compare and Comply method to run across the submitted input documents.
   *
   * @return the function
   */
  public String function() {
    return function;
  }

  /**
   * Gets the inputCredentialsFile.
   *
   * A JSON file containing the input Cloud Object Storage credentials. At a minimum, the credentials must enable `READ`
   * permissions on the bucket defined by the `input_bucket_name` parameter.
   *
   * @return the inputCredentialsFile
   */
  public InputStream inputCredentialsFile() {
    return inputCredentialsFile;
  }

  /**
   * Gets the inputCredentialsFilename.
   *
   * The filename for inputCredentialsFile.
   *
   * @return the inputCredentialsFilename
   */
  public String inputCredentialsFilename() {
    return inputCredentialsFilename;
  }

  /**
   * Gets the inputBucketLocation.
   *
   * The geographical location of the Cloud Object Storage input bucket as listed on the **Endpoint** tab of your Cloud
   * Object Storage instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the inputBucketLocation
   */
  public String inputBucketLocation() {
    return inputBucketLocation;
  }

  /**
   * Gets the inputBucketName.
   *
   * The name of the Cloud Object Storage input bucket.
   *
   * @return the inputBucketName
   */
  public String inputBucketName() {
    return inputBucketName;
  }

  /**
   * Gets the outputCredentialsFile.
   *
   * A JSON file that lists the Cloud Object Storage output credentials. At a minimum, the credentials must enable
   * `READ` and `WRITE` permissions on the bucket defined by the `output_bucket_name` parameter.
   *
   * @return the outputCredentialsFile
   */
  public InputStream outputCredentialsFile() {
    return outputCredentialsFile;
  }

  /**
   * Gets the outputCredentialsFilename.
   *
   * The filename for outputCredentialsFile.
   *
   * @return the outputCredentialsFilename
   */
  public String outputCredentialsFilename() {
    return outputCredentialsFilename;
  }

  /**
   * Gets the outputBucketLocation.
   *
   * The geographical location of the Cloud Object Storage output bucket as listed on the **Endpoint** tab of your Cloud
   * Object Storage instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the outputBucketLocation
   */
  public String outputBucketLocation() {
    return outputBucketLocation;
  }

  /**
   * Gets the outputBucketName.
   *
   * The name of the Cloud Object Storage output bucket.
   *
   * @return the outputBucketName
   */
  public String outputBucketName() {
    return outputBucketName;
  }

  /**
   * Gets the modelId.
   *
   * The analysis model to be used by the service. For the `/v1/element_classification` and `/v1/comparison` methods,
   * the default is `contracts`. For the `/v1/tables` method, the default is `tables`. These defaults apply to the
   * standalone methods as well as to the methods' use in batch-processing requests.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }
}
