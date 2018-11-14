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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The extractTables options.
 */
public class ExtractTablesOptions extends GenericModel {

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

  private InputStream file;
  private String filename;
  private String modelId;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream file;
    private String filename;
    private String modelId;

    private Builder(ExtractTablesOptions extractTablesOptions) {
      file = extractTablesOptions.file;
      filename = extractTablesOptions.filename;
      modelId = extractTablesOptions.modelId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param file the file
     */
    public Builder(InputStream file) {
      this.file = file;
    }

    /**
     * Builds a ExtractTablesOptions.
     *
     * @return the extractTablesOptions
     */
    public ExtractTablesOptions build() {
      return new ExtractTablesOptions(this);
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ExtractTablesOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the ExtractTablesOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the ExtractTablesOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ExtractTablesOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  private ExtractTablesOptions(Builder builder) {
    Validator.notNull(builder.file, "file cannot be null");
    file = builder.file;
    filename = builder.filename;
    modelId = builder.modelId;
  }

  /**
   * New builder.
   *
   * @return a ExtractTablesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the file.
   *
   * The PDF file on which to run table extraction.
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
