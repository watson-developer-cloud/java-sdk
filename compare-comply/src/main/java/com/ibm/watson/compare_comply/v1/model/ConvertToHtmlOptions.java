/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.compare_comply.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The convertToHtml options.
 */
public class ConvertToHtmlOptions extends GenericModel {

  /**
   * The analysis model to be used by the service. For the **Element classification** and **Compare two documents**
   * methods, the default is `contracts`. For the **Extract tables** method, the default is `tables`. These defaults
   * apply to the standalone methods as well as to the methods' use in batch-processing requests.
   */
  public interface Model {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  private InputStream file;
  private String filename;
  private String fileContentType;
  private String model;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream file;
    private String filename;
    private String fileContentType;
    private String model;

    private Builder(ConvertToHtmlOptions convertToHtmlOptions) {
      this.file = convertToHtmlOptions.file;
      this.filename = convertToHtmlOptions.filename;
      this.fileContentType = convertToHtmlOptions.fileContentType;
      this.model = convertToHtmlOptions.model;
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
     * @param filename the filename
     */
    public Builder(InputStream file, String filename) {
      this.file = file;
      this.filename = filename;
    }

    /**
     * Builds a ConvertToHtmlOptions.
     *
     * @return the convertToHtmlOptions
     */
    public ConvertToHtmlOptions build() {
      return new ConvertToHtmlOptions(this);
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ConvertToHtmlOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the ConvertToHtmlOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the fileContentType.
     *
     * @param fileContentType the fileContentType
     * @return the ConvertToHtmlOptions builder
     */
    public Builder fileContentType(String fileContentType) {
      this.fileContentType = fileContentType;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the ConvertToHtmlOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ConvertToHtmlOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  private ConvertToHtmlOptions(Builder builder) {
    Validator.notNull(builder.file, "file cannot be null");
    Validator.notNull(builder.filename, "filename cannot be null");
    file = builder.file;
    filename = builder.filename;
    fileContentType = builder.fileContentType;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a ConvertToHtmlOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the file.
   *
   * The document to convert.
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
   * Gets the model.
   *
   * The analysis model to be used by the service. For the **Element classification** and **Compare two documents**
   * methods, the default is `contracts`. For the **Extract tables** method, the default is `tables`. These defaults
   * apply to the standalone methods as well as to the methods' use in batch-processing requests.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
