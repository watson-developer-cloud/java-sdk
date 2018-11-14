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
 * The compareDocuments options.
 */
public class CompareDocumentsOptions extends GenericModel {

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

  private InputStream file1;
  private String file1Filename;
  private InputStream file2;
  private String file2Filename;
  private String file1Label;
  private String file2Label;
  private String modelId;
  private String file1ContentType;
  private String file2ContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream file1;
    private String file1Filename;
    private InputStream file2;
    private String file2Filename;
    private String file1Label;
    private String file2Label;
    private String modelId;
    private String file1ContentType;
    private String file2ContentType;

    private Builder(CompareDocumentsOptions compareDocumentsOptions) {
      file1 = compareDocumentsOptions.file1;
      file1Filename = compareDocumentsOptions.file1Filename;
      file2 = compareDocumentsOptions.file2;
      file2Filename = compareDocumentsOptions.file2Filename;
      file1Label = compareDocumentsOptions.file1Label;
      file2Label = compareDocumentsOptions.file2Label;
      modelId = compareDocumentsOptions.modelId;
      file1ContentType = compareDocumentsOptions.file1ContentType;
      file2ContentType = compareDocumentsOptions.file2ContentType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param file1 the file1
     * @param file2 the file2
     */
    public Builder(InputStream file1, InputStream file2) {
      this.file1 = file1;
      this.file2 = file2;
    }

    /**
     * Builds a CompareDocumentsOptions.
     *
     * @return the compareDocumentsOptions
     */
    public CompareDocumentsOptions build() {
      return new CompareDocumentsOptions(this);
    }

    /**
     * Set the file1.
     *
     * @param file1 the file1
     * @return the CompareDocumentsOptions builder
     */
    public Builder file1(InputStream file1) {
      this.file1 = file1;
      return this;
    }

    /**
     * Set the file1Filename.
     *
     * @param file1Filename the file1Filename
     * @return the CompareDocumentsOptions builder
     */
    public Builder file1Filename(String file1Filename) {
      this.file1Filename = file1Filename;
      return this;
    }

    /**
     * Set the file2.
     *
     * @param file2 the file2
     * @return the CompareDocumentsOptions builder
     */
    public Builder file2(InputStream file2) {
      this.file2 = file2;
      return this;
    }

    /**
     * Set the file2Filename.
     *
     * @param file2Filename the file2Filename
     * @return the CompareDocumentsOptions builder
     */
    public Builder file2Filename(String file2Filename) {
      this.file2Filename = file2Filename;
      return this;
    }

    /**
     * Set the file1Label.
     *
     * @param file1Label the file1Label
     * @return the CompareDocumentsOptions builder
     */
    public Builder file1Label(String file1Label) {
      this.file1Label = file1Label;
      return this;
    }

    /**
     * Set the file2Label.
     *
     * @param file2Label the file2Label
     * @return the CompareDocumentsOptions builder
     */
    public Builder file2Label(String file2Label) {
      this.file2Label = file2Label;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the CompareDocumentsOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the file1ContentType.
     *
     * @param file1ContentType the file1ContentType
     * @return the CompareDocumentsOptions builder
     */
    public Builder file1ContentType(String file1ContentType) {
      this.file1ContentType = file1ContentType;
      return this;
    }

    /**
     * Set the file2ContentType.
     *
     * @param file2ContentType the file2ContentType
     * @return the CompareDocumentsOptions builder
     */
    public Builder file2ContentType(String file2ContentType) {
      this.file2ContentType = file2ContentType;
      return this;
    }

    /**
     * Set the file1.
     *
     * @param file1 the file1
     * @return the CompareDocumentsOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file1(File file1) throws FileNotFoundException {
      this.file1 = new FileInputStream(file1);
      this.file1Filename = file1.getName();
      return this;
    }

    /**
     * Set the file2.
     *
     * @param file2 the file2
     * @return the CompareDocumentsOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file2(File file2) throws FileNotFoundException {
      this.file2 = new FileInputStream(file2);
      this.file2Filename = file2.getName();
      return this;
    }
  }

  private CompareDocumentsOptions(Builder builder) {
    Validator.notNull(builder.file1, "file1 cannot be null");
    Validator.notNull(builder.file2, "file2 cannot be null");
    file1 = builder.file1;
    file1Filename = builder.file1Filename;
    file2 = builder.file2;
    file2Filename = builder.file2Filename;
    file1Label = builder.file1Label;
    file2Label = builder.file2Label;
    modelId = builder.modelId;
    file1ContentType = builder.file1ContentType;
    file2ContentType = builder.file2ContentType;
  }

  /**
   * New builder.
   *
   * @return a CompareDocumentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the file1.
   *
   * The first file to compare.
   *
   * @return the file1
   */
  public InputStream file1() {
    return file1;
  }

  /**
   * Gets the file1Filename.
   *
   * The filename for file1.
   *
   * @return the file1Filename
   */
  public String file1Filename() {
    return file1Filename;
  }

  /**
   * Gets the file2.
   *
   * The second file to compare.
   *
   * @return the file2
   */
  public InputStream file2() {
    return file2;
  }

  /**
   * Gets the file2Filename.
   *
   * The filename for file2.
   *
   * @return the file2Filename
   */
  public String file2Filename() {
    return file2Filename;
  }

  /**
   * Gets the file1Label.
   *
   * A text label for the first file. The label cannot exceed 64 characters in length. The default is `file_1`.
   *
   * @return the file1Label
   */
  public String file1Label() {
    return file1Label;
  }

  /**
   * Gets the file2Label.
   *
   * A text label for the second file. The label cannot exceed 64 characters in length. The default is `file_2`.
   *
   * @return the file2Label
   */
  public String file2Label() {
    return file2Label;
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

  /**
   * Gets the file1ContentType.
   *
   * The content type of file1. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the file1ContentType
   */
  public String file1ContentType() {
    return file1ContentType;
  }

  /**
   * Gets the file2ContentType.
   *
   * The content type of file2. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the file2ContentType
   */
  public String file2ContentType() {
    return file2ContentType;
  }
}
