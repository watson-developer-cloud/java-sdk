/*
 * (C) Copyright IBM Corp. 2021.
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

/** The createValue options. */
public class CreateValueOptions extends GenericModel {

  /** Specifies the type of entity value. */
  public interface Type {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected Map<String, Object> metadata;
  protected String type;
  protected List<String> synonyms;
  protected List<String> patterns;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private Map<String, Object> metadata;
    private String type;
    private List<String> synonyms;
    private List<String> patterns;
    private Boolean includeAudit;

    private Builder(CreateValueOptions createValueOptions) {
      this.workspaceId = createValueOptions.workspaceId;
      this.entity = createValueOptions.entity;
      this.value = createValueOptions.value;
      this.metadata = createValueOptions.metadata;
      this.type = createValueOptions.type;
      this.synonyms = createValueOptions.synonyms;
      this.patterns = createValueOptions.patterns;
      this.includeAudit = createValueOptions.includeAudit;
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
     * Builds a CreateValueOptions.
     *
     * @return the new CreateValueOptions instance
     */
    public CreateValueOptions build() {
      return new CreateValueOptions(this);
    }

    /**
     * Adds an synonym to synonyms.
     *
     * @param synonym the new synonym
     * @return the CreateValueOptions builder
     */
    public Builder addSynonym(String synonym) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(synonym, "synonym cannot be null");
      if (this.synonyms == null) {
        this.synonyms = new ArrayList<String>();
      }
      this.synonyms.add(synonym);
      return this;
    }

    /**
     * Adds an pattern to patterns.
     *
     * @param pattern the new pattern
     * @return the CreateValueOptions builder
     */
    public Builder addPattern(String pattern) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(pattern, "pattern cannot be null");
      if (this.patterns == null) {
        this.patterns = new ArrayList<String>();
      }
      this.patterns.add(pattern);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateValueOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the CreateValueOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the CreateValueOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateValueOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateValueOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the synonyms. Existing synonyms will be replaced.
     *
     * @param synonyms the synonyms
     * @return the CreateValueOptions builder
     */
    public Builder synonyms(List<String> synonyms) {
      this.synonyms = synonyms;
      return this;
    }

    /**
     * Set the patterns. Existing patterns will be replaced.
     *
     * @param patterns the patterns
     * @return the CreateValueOptions builder
     */
    public Builder patterns(List<String> patterns) {
      this.patterns = patterns;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateValueOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected CreateValueOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value, "value cannot be null");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    metadata = builder.metadata;
    type = builder.type;
    synonyms = builder.synonyms;
    patterns = builder.patterns;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a CreateValueOptions builder
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
   * <p>The text of the entity value. This string must conform to the following restrictions: - It
   * cannot contain carriage return, newline, or tab characters. - It cannot consist of only
   * whitespace characters.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the metadata.
   *
   * <p>Any metadata related to the entity value.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the type.
   *
   * <p>Specifies the type of entity value.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the synonyms.
   *
   * <p>An array of synonyms for the entity value. A value can specify either synonyms or patterns
   * (depending on the value type), but not both. A synonym must conform to the following
   * resrictions: - It cannot contain carriage return, newline, or tab characters. - It cannot
   * consist of only whitespace characters.
   *
   * @return the synonyms
   */
  public List<String> synonyms() {
    return synonyms;
  }

  /**
   * Gets the patterns.
   *
   * <p>An array of patterns for the entity value. A value can specify either synonyms or patterns
   * (depending on the value type), but not both. A pattern is a regular expression; for more
   * information about how to specify a pattern, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-entities#entities-create-dictionary-based).
   *
   * @return the patterns
   */
  public List<String> patterns() {
    return patterns;
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
