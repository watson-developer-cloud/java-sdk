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
package com.ibm.watson.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addCorpus options.
 */
public class AddCorpusOptions extends GenericModel {

  protected String customizationId;
  protected String corpusName;
  protected InputStream corpusFile;
  protected Boolean allowOverwrite;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String corpusName;
    private InputStream corpusFile;
    private Boolean allowOverwrite;

    private Builder(AddCorpusOptions addCorpusOptions) {
      this.customizationId = addCorpusOptions.customizationId;
      this.corpusName = addCorpusOptions.corpusName;
      this.corpusFile = addCorpusOptions.corpusFile;
      this.allowOverwrite = addCorpusOptions.allowOverwrite;
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
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder corpusFile(File corpusFile) throws FileNotFoundException {
      this.corpusFile = new FileInputStream(corpusFile);
      return this;
    }
  }

  protected AddCorpusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
        "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpusName,
        "corpusName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.corpusFile,
        "corpusFile cannot be null");
    customizationId = builder.customizationId;
    corpusName = builder.corpusName;
    corpusFile = builder.corpusFile;
    allowOverwrite = builder.allowOverwrite;
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
   * The customization ID (GUID) of the custom language model that is to be used for the request. You must make the
   * request with credentials for the instance of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the corpusName.
   *
   * The name of the new corpus for the custom language model. Use a localized name that matches the language of the
   * custom model and reflects the contents of the corpus.
   * * Include a maximum of 128 characters in the name.
   * * Do not use characters that need to be URL-encoded. For example, do not use spaces, slashes, backslashes, colons,
   * ampersands, double quotes, plus signs, equals signs, questions marks, and so on in the name. (The service does not
   * prevent the use of these characters. But because they must be URL-encoded wherever used, their use is strongly
   * discouraged.)
   * * Do not use the name of an existing corpus or grammar that is already defined for the custom model.
   * * Do not use the name `user`, which is reserved by the service to denote custom words that are added or modified by
   * the user.
   * * Do not use the name `base_lm` or `default_lm`. Both names are reserved for future use by the service.
   *
   * @return the corpusName
   */
  public String corpusName() {
    return corpusName;
  }

  /**
   * Gets the corpusFile.
   *
   * A plain text file that contains the training data for the corpus. Encode the file in UTF-8 if it contains non-ASCII
   * characters; the service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * Make sure that you know the character encoding of the file. You must use that encoding when working with the words
   * in the custom language model. For more information, see [Character
   * encoding](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-corporaWords#charEncoding).
   *
   * With the `curl` command, use the `--data-binary` option to upload the file for the request.
   *
   * @return the corpusFile
   */
  public InputStream corpusFile() {
    return corpusFile;
  }

  /**
   * Gets the allowOverwrite.
   *
   * If `true`, the specified corpus overwrites an existing corpus with the same name. If `false`, the request fails if
   * a corpus with the same name already exists. The parameter has no effect if a corpus with the same name does not
   * already exist.
   *
   * @return the allowOverwrite
   */
  public Boolean allowOverwrite() {
    return allowOverwrite;
  }
}
