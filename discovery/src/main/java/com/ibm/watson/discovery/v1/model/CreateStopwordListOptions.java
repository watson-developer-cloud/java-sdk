/*
 * (C) Copyright IBM Corp. 2019, 2022.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The createStopwordList options. */
public class CreateStopwordListOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected InputStream stopwordFile;
  protected String stopwordFilename;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private InputStream stopwordFile;
    private String stopwordFilename;

    private Builder(CreateStopwordListOptions createStopwordListOptions) {
      this.environmentId = createStopwordListOptions.environmentId;
      this.collectionId = createStopwordListOptions.collectionId;
      this.stopwordFile = createStopwordListOptions.stopwordFile;
      this.stopwordFilename = createStopwordListOptions.stopwordFilename;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     * @param stopwordFile the stopwordFile
     * @param stopwordFilename the stopwordFilename
     */
    public Builder(
        String environmentId,
        String collectionId,
        InputStream stopwordFile,
        String stopwordFilename) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.stopwordFile = stopwordFile;
      this.stopwordFilename = stopwordFilename;
    }

    /**
     * Builds a CreateStopwordListOptions.
     *
     * @return the new CreateStopwordListOptions instance
     */
    public CreateStopwordListOptions build() {
      return new CreateStopwordListOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateStopwordListOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the CreateStopwordListOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the stopwordFile.
     *
     * @param stopwordFile the stopwordFile
     * @return the CreateStopwordListOptions builder
     */
    public Builder stopwordFile(InputStream stopwordFile) {
      this.stopwordFile = stopwordFile;
      return this;
    }

    /**
     * Set the stopwordFilename.
     *
     * @param stopwordFilename the stopwordFilename
     * @return the CreateStopwordListOptions builder
     */
    public Builder stopwordFilename(String stopwordFilename) {
      this.stopwordFilename = stopwordFilename;
      return this;
    }

    /**
     * Set the stopwordFile.
     *
     * @param stopwordFile the stopwordFile
     * @return the CreateStopwordListOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder stopwordFile(File stopwordFile) throws FileNotFoundException {
      this.stopwordFile = new FileInputStream(stopwordFile);
      this.stopwordFilename = stopwordFile.getName();
      return this;
    }
  }

  protected CreateStopwordListOptions() {}

  protected CreateStopwordListOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.stopwordFile, "stopwordFile cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.stopwordFilename, "stopwordFilename cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    stopwordFile = builder.stopwordFile;
    stopwordFilename = builder.stopwordFilename;
  }

  /**
   * New builder.
   *
   * @return a CreateStopwordListOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the stopwordFile.
   *
   * <p>The content of the stopword list to ingest.
   *
   * @return the stopwordFile
   */
  public InputStream stopwordFile() {
    return stopwordFile;
  }

  /**
   * Gets the stopwordFilename.
   *
   * <p>The filename for stopwordFile.
   *
   * @return the stopwordFilename
   */
  public String stopwordFilename() {
    return stopwordFilename;
  }
}
