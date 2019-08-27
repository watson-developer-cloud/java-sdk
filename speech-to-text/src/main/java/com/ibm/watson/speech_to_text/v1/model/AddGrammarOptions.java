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
package com.ibm.watson.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addGrammar options.
 */
public class AddGrammarOptions extends GenericModel {

  /**
   * The format (MIME type) of the grammar file:
   * * `application/srgs` for Augmented Backus-Naur Form (ABNF), which uses a plain-text representation that is similar
   * to traditional BNF grammars.
   * * `application/srgs+xml` for XML Form, which uses XML elements to represent the grammar.
   */
  public interface ContentType {
    /** application/srgs. */
    String APPLICATION_SRGS = "application/srgs";
    /** application/srgs+xml. */
    String APPLICATION_SRGS_XML = "application/srgs+xml";
  }

  private String customizationId;
  private String grammarName;
  private InputStream grammarFile;
  private String contentType;
  private Boolean allowOverwrite;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private String grammarName;
    private InputStream grammarFile;
    private String contentType;
    private Boolean allowOverwrite;

    private Builder(AddGrammarOptions addGrammarOptions) {
      this.customizationId = addGrammarOptions.customizationId;
      this.grammarName = addGrammarOptions.grammarName;
      this.grammarFile = addGrammarOptions.grammarFile;
      this.contentType = addGrammarOptions.contentType;
      this.allowOverwrite = addGrammarOptions.allowOverwrite;
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
     * @param grammarName the grammarName
     * @param grammarFile the grammarFile
     * @param contentType the contentType
     */
    public Builder(String customizationId, String grammarName, InputStream grammarFile, String contentType) {
      this.customizationId = customizationId;
      this.grammarName = grammarName;
      this.grammarFile = grammarFile;
      this.contentType = contentType;
    }

    /**
     * Builds a AddGrammarOptions.
     *
     * @return the addGrammarOptions
     */
    public AddGrammarOptions build() {
      return new AddGrammarOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddGrammarOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the grammarName.
     *
     * @param grammarName the grammarName
     * @return the AddGrammarOptions builder
     */
    public Builder grammarName(String grammarName) {
      this.grammarName = grammarName;
      return this;
    }

    /**
     * Set the grammarFile.
     *
     * @param grammarFile the grammarFile
     * @return the AddGrammarOptions builder
     */
    public Builder grammarFile(InputStream grammarFile) {
      this.grammarFile = grammarFile;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the AddGrammarOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the allowOverwrite.
     *
     * @param allowOverwrite the allowOverwrite
     * @return the AddGrammarOptions builder
     */
    public Builder allowOverwrite(Boolean allowOverwrite) {
      this.allowOverwrite = allowOverwrite;
      return this;
    }

    /**
     * Set the grammarFile.
     *
     * @param grammarFile the grammarFile
     * @return the AddGrammarOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder grammarFile(File grammarFile) throws FileNotFoundException {
      this.grammarFile = new FileInputStream(grammarFile);
      return this;
    }
  }

  private AddGrammarOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
        "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.grammarName,
        "grammarName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.grammarFile,
        "grammarFile cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.contentType,
        "contentType cannot be null");
    customizationId = builder.customizationId;
    grammarName = builder.grammarName;
    grammarFile = builder.grammarFile;
    contentType = builder.contentType;
    allowOverwrite = builder.allowOverwrite;
  }

  /**
   * New builder.
   *
   * @return a AddGrammarOptions builder
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
   * Gets the grammarName.
   *
   * The name of the new grammar for the custom language model. Use a localized name that matches the language of the
   * custom model and reflects the contents of the grammar.
   * * Include a maximum of 128 characters in the name.
   * * Do not use characters that need to be URL-encoded. For example, do not use spaces, slashes, backslashes, colons,
   * ampersands, double quotes, plus signs, equals signs, questions marks, and so on in the name. (The service does not
   * prevent the use of these characters. But because they must be URL-encoded wherever used, their use is strongly
   * discouraged.)
   * * Do not use the name of an existing grammar or corpus that is already defined for the custom model.
   * * Do not use the name `user`, which is reserved by the service to denote custom words that are added or modified by
   * the user.
   * * Do not use the name `base_lm` or `default_lm`. Both names are reserved for future use by the service.
   *
   * @return the grammarName
   */
  public String grammarName() {
    return grammarName;
  }

  /**
   * Gets the grammarFile.
   *
   * A plain text file that contains the grammar in the format specified by the `Content-Type` header. Encode the file
   * in UTF-8 (ASCII is a subset of UTF-8). Using any other encoding can lead to issues when compiling the grammar or to
   * unexpected results in decoding. The service ignores an encoding that is specified in the header of the grammar.
   *
   * With the `curl` command, use the `--data-binary` option to upload the file for the request.
   *
   * @return the grammarFile
   */
  public InputStream grammarFile() {
    return grammarFile;
  }

  /**
   * Gets the contentType.
   *
   * The format (MIME type) of the grammar file:
   * * `application/srgs` for Augmented Backus-Naur Form (ABNF), which uses a plain-text representation that is similar
   * to traditional BNF grammars.
   * * `application/srgs+xml` for XML Form, which uses XML elements to represent the grammar.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the allowOverwrite.
   *
   * If `true`, the specified grammar overwrites an existing grammar with the same name. If `false`, the request fails
   * if a grammar with the same name already exists. The parameter has no effect if a grammar with the same name does
   * not already exist.
   *
   * @return the allowOverwrite
   */
  public Boolean allowOverwrite() {
    return allowOverwrite;
  }
}
