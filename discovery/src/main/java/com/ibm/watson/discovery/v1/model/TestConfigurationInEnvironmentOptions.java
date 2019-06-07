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
package com.ibm.watson.discovery.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The testConfigurationInEnvironment options.
 */
public class TestConfigurationInEnvironmentOptions extends GenericModel {

  /**
   * Specify to only run the input document through the given step instead of running the input document through the
   * entire ingestion workflow. Valid values are `convert`, `enrich`, and `normalize`.
   */
  public interface Step {
    /** html_input. */
    String HTML_INPUT = "html_input";
    /** html_output. */
    String HTML_OUTPUT = "html_output";
    /** json_output. */
    String JSON_OUTPUT = "json_output";
    /** json_normalizations_output. */
    String JSON_NORMALIZATIONS_OUTPUT = "json_normalizations_output";
    /** enrichments_output. */
    String ENRICHMENTS_OUTPUT = "enrichments_output";
    /** normalizations_output. */
    String NORMALIZATIONS_OUTPUT = "normalizations_output";
  }

  private String environmentId;
  private String configuration;
  private InputStream file;
  private String filename;
  private String fileContentType;
  private String metadata;
  private String step;
  private String configurationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String configuration;
    private InputStream file;
    private String filename;
    private String fileContentType;
    private String metadata;
    private String step;
    private String configurationId;

    private Builder(TestConfigurationInEnvironmentOptions testConfigurationInEnvironmentOptions) {
      this.environmentId = testConfigurationInEnvironmentOptions.environmentId;
      this.configuration = testConfigurationInEnvironmentOptions.configuration;
      this.file = testConfigurationInEnvironmentOptions.file;
      this.filename = testConfigurationInEnvironmentOptions.filename;
      this.fileContentType = testConfigurationInEnvironmentOptions.fileContentType;
      this.metadata = testConfigurationInEnvironmentOptions.metadata;
      this.step = testConfigurationInEnvironmentOptions.step;
      this.configurationId = testConfigurationInEnvironmentOptions.configurationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a TestConfigurationInEnvironmentOptions.
     *
     * @return the testConfigurationInEnvironmentOptions
     */
    public TestConfigurationInEnvironmentOptions build() {
      return new TestConfigurationInEnvironmentOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the configuration.
     *
     * @param configuration the configuration
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder configuration(String configuration) {
      this.configuration = configuration;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the fileContentType.
     *
     * @param fileContentType the fileContentType
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder fileContentType(String fileContentType) {
      this.fileContentType = fileContentType;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder metadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the step.
     *
     * @param step the step
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder step(String step) {
      this.step = step;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the TestConfigurationInEnvironmentOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the TestConfigurationInEnvironmentOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  private TestConfigurationInEnvironmentOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.isTrue((builder.file == null) || (builder.filename != null),
        "filename cannot be null if file is not null.");
    environmentId = builder.environmentId;
    configuration = builder.configuration;
    file = builder.file;
    filename = builder.filename;
    fileContentType = builder.fileContentType;
    metadata = builder.metadata;
    step = builder.step;
    configurationId = builder.configurationId;
  }

  /**
   * New builder.
   *
   * @return a TestConfigurationInEnvironmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the configuration.
   *
   * The configuration to use to process the document. If this part is provided, then the provided configuration is used
   * to process the document. If the **configuration_id** is also provided (both are present at the same time), then
   * request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are
   * rejected.
   * See the `GET /configurations/{configuration_id}` operation for an example configuration.
   *
   * @return the configuration
   */
  public String configuration() {
    return configuration;
  }

  /**
   * Gets the file.
   *
   * The content of the document to ingest. The maximum supported file size when adding a file to a collection is 50
   * megabytes, the maximum supported file size when testing a confiruration is 1 megabyte. Files larger than the
   * supported size are rejected.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the filename.
   *
   * The filename for file.
   *
   * @return the filename
   */
  public String filename() {
    return filename;
  }

  /**
   * Gets the fileContentType.
   *
   * The content type of file. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the fileContentType
   */
  public String fileContentType() {
    return fileContentType;
  }

  /**
   * Gets the metadata.
   *
   * The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected.
   * Example: ``` {
   * "Creator": "Johnny Appleseed",
   * "Subject": "Apples"
   * } ```.
   *
   * @return the metadata
   */
  public String metadata() {
    return metadata;
  }

  /**
   * Gets the step.
   *
   * Specify to only run the input document through the given step instead of running the input document through the
   * entire ingestion workflow. Valid values are `convert`, `enrich`, and `normalize`.
   *
   * @return the step
   */
  public String step() {
    return step;
  }

  /**
   * Gets the configurationId.
   *
   * The ID of the configuration to use to process the document. If the **configuration** form part is also provided
   * (both are present at the same time), then the request will be rejected.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}
