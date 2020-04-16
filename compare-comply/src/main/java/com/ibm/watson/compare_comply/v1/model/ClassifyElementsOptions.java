/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The classifyElements options. */
public class ClassifyElementsOptions extends GenericModel {

  /**
   * The analysis model to be used by the service. For the **Element classification** and **Compare
   * two documents** methods, the default is `contracts`. For the **Extract tables** method, the
   * default is `tables`. These defaults apply to the standalone methods as well as to the methods'
   * use in batch-processing requests.
   */
  public interface Model {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  protected InputStream file;
  protected String fileContentType;
  protected String model;

  /** Builder. */
  public static class Builder {
    private InputStream file;
    private String fileContentType;
    private String model;

    private Builder(ClassifyElementsOptions classifyElementsOptions) {
      this.file = classifyElementsOptions.file;
      this.fileContentType = classifyElementsOptions.fileContentType;
      this.model = classifyElementsOptions.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param file the file
     */
    public Builder(InputStream file) {
      this.file = file;
    }

    /**
     * Builds a ClassifyElementsOptions.
     *
     * @return the classifyElementsOptions
     */
    public ClassifyElementsOptions build() {
      return new ClassifyElementsOptions(this);
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ClassifyElementsOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the fileContentType.
     *
     * @param fileContentType the fileContentType
     * @return the ClassifyElementsOptions builder
     */
    public Builder fileContentType(String fileContentType) {
      this.fileContentType = fileContentType;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the ClassifyElementsOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the ClassifyElementsOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      return this;
    }
  }

  protected ClassifyElementsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.file, "file cannot be null");
    file = builder.file;
    fileContentType = builder.fileContentType;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a ClassifyElementsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the file.
   *
   * <p>The document to classify.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the fileContentType.
   *
   * <p>The content type of file. Values for this parameter can be obtained from the HttpMediaType
   * class.
   *
   * @return the fileContentType
   */
  public String fileContentType() {
    return fileContentType;
  }

  /**
   * Gets the model.
   *
   * <p>The analysis model to be used by the service. For the **Element classification** and
   * **Compare two documents** methods, the default is `contracts`. For the **Extract tables**
   * method, the default is `tables`. These defaults apply to the standalone methods as well as to
   * the methods' use in batch-processing requests.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
