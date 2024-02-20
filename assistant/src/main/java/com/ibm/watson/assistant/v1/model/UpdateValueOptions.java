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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** The updateValue options. */
public class UpdateValueOptions extends GenericModel {

  /** Specifies the type of entity value. */
  public interface NewType {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected String newValue;
  protected Map<String, Object> newMetadata;
  protected String newType;
  protected List<String> newSynonyms;
  protected List<String> newPatterns;
  protected Boolean append;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private String newValue;
    private Map<String, Object> newMetadata;
    private String newType;
    private List<String> newSynonyms;
    private List<String> newPatterns;
    private Boolean append;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing UpdateValueOptions instance.
     *
     * @param updateValueOptions the instance to initialize the Builder with
     */
    private Builder(UpdateValueOptions updateValueOptions) {
      this.workspaceId = updateValueOptions.workspaceId;
      this.entity = updateValueOptions.entity;
      this.value = updateValueOptions.value;
      this.newValue = updateValueOptions.newValue;
      this.newMetadata = updateValueOptions.newMetadata;
      this.newType = updateValueOptions.newType;
      this.newSynonyms = updateValueOptions.newSynonyms;
      this.newPatterns = updateValueOptions.newPatterns;
      this.append = updateValueOptions.append;
      this.includeAudit = updateValueOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     * @param value the value
     */
    public Builder(String workspaceId, String entity, String value) {
      this.workspaceId = workspaceId;
      this.entity = entity;
      this.value = value;
    }

    /**
     * Builds a UpdateValueOptions.
     *
     * @return the new UpdateValueOptions instance
     */
    public UpdateValueOptions build() {
      return new UpdateValueOptions(this);
    }

    /**
     * Adds a new element to newSynonyms.
     *
     * @param synonym the new element to be added
     * @return the UpdateValueOptions builder
     */
    public Builder addSynonym(String synonym) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(synonym, "synonym cannot be null");
      if (this.newSynonyms == null) {
        this.newSynonyms = new ArrayList<String>();
      }
      this.newSynonyms.add(synonym);
      return this;
    }

    /**
     * Adds a new element to newPatterns.
     *
     * @param pattern the new element to be added
     * @return the UpdateValueOptions builder
     */
    public Builder addPattern(String pattern) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(pattern, "pattern cannot be null");
      if (this.newPatterns == null) {
        this.newPatterns = new ArrayList<String>();
      }
      this.newPatterns.add(pattern);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateValueOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the UpdateValueOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the UpdateValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the newValue.
     *
     * @param newValue the newValue
     * @return the UpdateValueOptions builder
     */
    public Builder newValue(String newValue) {
      this.newValue = newValue;
      return this;
    }

    /**
     * Set the newMetadata.
     *
     * @param newMetadata the newMetadata
     * @return the UpdateValueOptions builder
     */
    public Builder newMetadata(Map<String, Object> newMetadata) {
      this.newMetadata = newMetadata;
      return this;
    }

    /**
     * Set the newType.
     *
     * @param newType the newType
     * @return the UpdateValueOptions builder
     */
    public Builder newType(String newType) {
      this.newType = newType;
      return this;
    }

    /**
     * Set the newSynonyms. Existing newSynonyms will be replaced.
     *
     * @param newSynonyms the newSynonyms
     * @return the UpdateValueOptions builder
     */
    public Builder newSynonyms(List<String> newSynonyms) {
      this.newSynonyms = newSynonyms;
      return this;
    }

    /**
     * Set the newPatterns. Existing newPatterns will be replaced.
     *
     * @param newPatterns the newPatterns
     * @return the UpdateValueOptions builder
     */
    public Builder newPatterns(List<String> newPatterns) {
      this.newPatterns = newPatterns;
      return this;
    }

    /**
     * Set the append.
     *
     * @param append the append
     * @return the UpdateValueOptions builder
     */
    public Builder append(Boolean append) {
      this.append = append;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the UpdateValueOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected UpdateValueOptions() {}

  protected UpdateValueOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.value, "value cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    newValue = builder.newValue;
    newMetadata = builder.newMetadata;
    newType = builder.newType;
    newSynonyms = builder.newSynonyms;
    newPatterns = builder.newPatterns;
    append = builder.append;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a UpdateValueOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the entity.
   *
   * <p>The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the value.
   *
   * <p>The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the newValue.
   *
   * <p>The text of the entity value. This string must conform to the following restrictions: - It
   * cannot contain carriage return, newline, or tab characters. - It cannot consist of only
   * whitespace characters.
   *
   * @return the newValue
   */
  public String newValue() {
    return newValue;
  }

  /**
   * Gets the newMetadata.
   *
   * <p>Any metadata related to the entity value.
   *
   * @return the newMetadata
   */
  public Map<String, Object> newMetadata() {
    return newMetadata;
  }

  /**
   * Gets the newType.
   *
   * <p>Specifies the type of entity value.
   *
   * @return the newType
   */
  public String newType() {
    return newType;
  }

  /**
   * Gets the newSynonyms.
   *
   * <p>An array of synonyms for the entity value. A value can specify either synonyms or patterns
   * (depending on the value type), but not both. A synonym must conform to the following
   * resrictions: - It cannot contain carriage return, newline, or tab characters. - It cannot
   * consist of only whitespace characters.
   *
   * @return the newSynonyms
   */
  public List<String> newSynonyms() {
    return newSynonyms;
  }

  /**
   * Gets the newPatterns.
   *
   * <p>An array of patterns for the entity value. A value can specify either synonyms or patterns
   * (depending on the value type), but not both. A pattern is a regular expression; for more
   * information about how to specify a pattern, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-entities#entities-create-dictionary-based).
   *
   * @return the newPatterns
   */
  public List<String> newPatterns() {
    return newPatterns;
  }

  /**
   * Gets the append.
   *
   * <p>Whether the new data is to be appended to the existing data in the entity value. If
   * **append**=`false`, elements included in the new data completely replace the corresponding
   * existing elements, including all subelements. For example, if the new data for the entity value
   * includes **synonyms** and **append**=`false`, all existing synonyms for the entity value are
   * discarded and replaced with the new synonyms.
   *
   * <p>If **append**=`true`, existing elements are preserved, and the new elements are added. If
   * any elements in the new data collide with existing elements, the update request fails.
   *
   * @return the append
   */
  public Boolean append() {
    return append;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}
