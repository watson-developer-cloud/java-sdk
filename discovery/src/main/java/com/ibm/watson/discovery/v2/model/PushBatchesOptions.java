/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The pushBatches options. */
public class PushBatchesOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String batchId;
  protected InputStream file;
  protected String filename;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String batchId;
    private InputStream file;
    private String filename;

    /**
     * Instantiates a new Builder from an existing PushBatchesOptions instance.
     *
     * @param pushBatchesOptions the instance to initialize the Builder with
     */
    private Builder(PushBatchesOptions pushBatchesOptions) {
      this.projectId = pushBatchesOptions.projectId;
      this.collectionId = pushBatchesOptions.collectionId;
      this.batchId = pushBatchesOptions.batchId;
      this.file = pushBatchesOptions.file;
      this.filename = pushBatchesOptions.filename;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     * @param batchId the batchId
     */
    public Builder(String projectId, String collectionId, String batchId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
      this.batchId = batchId;
    }

    /**
     * Builds a PushBatchesOptions.
     *
     * @return the new PushBatchesOptions instance
     */
    public PushBatchesOptions build() {
      return new PushBatchesOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the PushBatchesOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the PushBatchesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the batchId.
     *
     * @param batchId the batchId
     * @return the PushBatchesOptions builder
     */
    public Builder batchId(String batchId) {
      this.batchId = batchId;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the PushBatchesOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the PushBatchesOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the PushBatchesOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  protected PushBatchesOptions() {}

  protected PushBatchesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.batchId, "batchId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (builder.file == null) || (builder.filename != null),
        "filename cannot be null if file is not null.");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    batchId = builder.batchId;
    file = builder.file;
    filename = builder.filename;
  }

  /**
   * New builder.
   *
   * @return a PushBatchesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the batchId.
   *
   * <p>The Universally Unique Identifier (UUID) of the document batch that is being requested from
   * Discovery.
   *
   * @return the batchId
   */
  public String batchId() {
    return batchId;
  }

  /**
   * Gets the file.
   *
   * <p>A compressed newline-delimited JSON (NDJSON), which is a JSON file with one row of data per
   * line. For example, `{batch_id}.ndjson.gz`. For more information, see [Binary attachment in the
   * push batches
   * method](/docs/discovery-data?topic=discovery-data-external-enrichment#binary-attachment-push-batches).
   *
   * <p>There is no limitation on the name of the file because Discovery does not use the name for
   * processing. The list of features in the document is specified in the `features` object.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the filename.
   *
   * <p>The filename for file.
   *
   * @return the filename
   */
  public String filename() {
    return filename;
  }
}
