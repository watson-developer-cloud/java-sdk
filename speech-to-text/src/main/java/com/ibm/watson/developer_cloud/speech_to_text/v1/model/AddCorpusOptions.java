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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The addCorpus options.
 */
public class AddCorpusOptions extends GenericModel {

  private String customizationId;
  private String corpusName;
  private Boolean allowOverwrite;
  private InputStream corpusFile;
  private String corpusFilename;
  private String corpusFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String corpusName;
    private Boolean allowOverwrite;
    private InputStream corpusFile;
    private String corpusFilename;
    private String corpusFileContentType;

    private Builder(AddCorpusOptions addCorpusOptions) {
      customizationId = addCorpusOptions.customizationId;
      corpusName = addCorpusOptions.corpusName;
      allowOverwrite = addCorpusOptions.allowOverwrite;
      corpusFile = addCorpusOptions.corpusFile;
      corpusFilename = addCorpusOptions.corpusFilename;
      corpusFileContentType = addCorpusOptions.corpusFileContentType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param corpusName the corpusName
     * @param corpusFile the corpusFile
     */
    public Builder(String customizationId, String corpusName, InputStream corpusFile) {
      this.customizationId = customizationId;
      this.corpusName = corpusName;
      this.corpusFile = corpusFile;
    }

    /**
     * Builds a AddCorpusOptions.
     *
     * @return the addCorpusOptions
     */
    public AddCorpusOptions build() {
      return new AddCorpusOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddCorpusOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the corpusName.
     *
     * @param corpusName the corpusName
     * @return the AddCorpusOptions builder
     */
    public Builder corpusName(String corpusName) {
      this.corpusName = corpusName;
      return this;
    }

    /**
     * Set the allowOverwrite.
     *
     * @param allowOverwrite the allowOverwrite
     * @return the AddCorpusOptions builder
     */
    public Builder allowOverwrite(Boolean allowOverwrite) {
      this.allowOverwrite = allowOverwrite;
      return this;
    }

    /**
     * Set the corpusFile.
     *
     * @param corpusFile the corpusFile
     * @return the AddCorpusOptions builder
     */
    public Builder corpusFile(InputStream corpusFile) {
      this.corpusFile = corpusFile;
      return this;
    }

    /**
     * Set the corpusFilename.
     *
     * @param corpusFilename the corpusFilename
     * @return the AddCorpusOptions builder
     */
    public Builder corpusFilename(String corpusFilename) {
      this.corpusFilename = corpusFilename;
      return this;
    }

    /**
     * Set the corpusFileContentType.
     *
     * @param corpusFileContentType the corpusFileContentType
     * @return the AddCorpusOptions builder
     */
    public Builder corpusFileContentType(String corpusFileContentType) {
      this.corpusFileContentType = corpusFileContentType;
      return this;
    }

    /**
     * Set the corpusFile.
     *
     * @param corpusFile the corpusFile
     * @return the AddCorpusOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder corpusFile(File corpusFile) throws FileNotFoundException {
      this.corpusFile = new FileInputStream(corpusFile);
      this.corpusFilename = corpusFile.getName();
      return this;
    }
  }

  private AddCorpusOptions(Builder builder) {
    Validator.notEmpty(builder.customizationId, "customizationId cannot be empty");
    Validator.notEmpty(builder.corpusName, "corpusName cannot be empty");
    Validator.notNull(builder.corpusFile, "corpusFile cannot be null");
    customizationId = builder.customizationId;
    corpusName = builder.corpusName;
    allowOverwrite = builder.allowOverwrite;
    corpusFile = builder.corpusFile;
    corpusFilename = builder.corpusFilename;
    corpusFileContentType = builder.corpusFileContentType;
  }

  /**
   * New builder.
   *
   * @return a AddCorpusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of the custom language model to which a corpus is to be added. You must make the request with service
   * credentials created for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the corpusName.
   *
   * The name of the corpus that is to be added to the custom language model. The name cannot contain spaces and cannot
   * be the string `user`, which is reserved by the service to denote custom words added or modified by the user. Use a
   * localized name that matches the language of the custom model.
   *
   * @return the corpusName
   */
  public String corpusName() {
    return corpusName;
  }

  /**
   * Gets the allowOverwrite.
   *
   * Indicates whether the specified corpus is to overwrite an existing corpus with the same name. If a corpus with the
   * same name already exists, the request fails unless `allow_overwrite` is set to `true`; by default, the parameter is
   * `false`. The parameter has no effect if a corpus with the same name does not already exist.
   *
   * @return the allowOverwrite
   */
  public Boolean allowOverwrite() {
    return allowOverwrite;
  }

  /**
   * Gets the corpusFile.
   *
   * A plain text file that contains the training data for the corpus. Encode the file in UTF-8 if it contains non-ASCII
   * characters; the service assumes UTF-8 encoding if it encounters non-ASCII characters. With cURL, use the
   * `--data-binary` option to upload the file for the request.
   *
   * @return the corpusFile
   */
  public InputStream corpusFile() {
    return corpusFile;
  }

  /**
   * Gets the corpusFilename.
   *
   * The filename for corpusFile.
   *
   * @return the corpusFilename
   */
  public String corpusFilename() {
    return corpusFilename;
  }

  /**
   * Gets the corpusFileContentType.
   *
   * The content type of corpusFile. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the corpusFileContentType
   */
  public String corpusFileContentType() {
    return corpusFileContentType;
  }
}
