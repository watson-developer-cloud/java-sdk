/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CreateValue.
 */
public class CreateValue extends GenericModel {

  /**
   * Specifies the type of entity value.
   */
  public interface Type {
    /** synonyms. */
    String SYNONYMS = "synonyms";
    /** patterns. */
    String PATTERNS = "patterns";
  }

  protected String value;
  protected Map<String, Object> metadata;
  protected String type;
  protected List<String> synonyms;
  protected List<String> patterns;
  protected Date created;
  protected Date updated;

  /**
   * Builder.
   */
  public static class Builder {
    private String value;
    private Map<String, Object> metadata;
    private String type;
    private List<String> synonyms;
    private List<String> patterns;
    private Date created;
    private Date updated;

    private Builder(CreateValue createValue) {
      this.value = createValue.value;
      this.metadata = createValue.metadata;
      this.type = createValue.type;
      this.synonyms = createValue.synonyms;
      this.patterns = createValue.patterns;
      this.created = createValue.created;
      this.updated = createValue.updated;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param value the value
     */
    public Builder(String value) {
      this.value = value;
    }

    /**
     * Builds a CreateValue.
     *
     * @return the createValue
     */
    public CreateValue build() {
      return new CreateValue(this);
    }

    /**
     * Adds an synonym to synonyms.
     *
     * @param synonym the new synonym
     * @return the CreateValue builder
     */
    public Builder addSynonym(String synonym) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(synonym,
          "synonym cannot be null");
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
     * @return the CreateValue builder
     */
    public Builder addPattern(String pattern) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(pattern,
          "pattern cannot be null");
      if (this.patterns == null) {
        this.patterns = new ArrayList<String>();
      }
      this.patterns.add(pattern);
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the CreateValue builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateValue builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateValue builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the synonyms.
     * Existing synonyms will be replaced.
     *
     * @param synonyms the synonyms
     * @return the CreateValue builder
     */
    public Builder synonyms(List<String> synonyms) {
      this.synonyms = synonyms;
      return this;
    }

    /**
     * Set the patterns.
     * Existing patterns will be replaced.
     *
     * @param patterns the patterns
     * @return the CreateValue builder
     */
    public Builder patterns(List<String> patterns) {
      this.patterns = patterns;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the CreateValue builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the CreateValue builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }
  }

  protected CreateValue(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
        "value cannot be null");
    value = builder.value;
    metadata = builder.metadata;
    type = builder.type;
    synonyms = builder.synonyms;
    patterns = builder.patterns;
    created = builder.created;
    updated = builder.updated;
  }

  /**
   * New builder.
   *
   * @return a CreateValue builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the value.
   *
   * The text of the entity value. This string must conform to the following restrictions:
   * - It cannot contain carriage return, newline, or tab characters.
   * - It cannot consist of only whitespace characters.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the entity value.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the type.
   *
   * Specifies the type of entity value.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the synonyms.
   *
   * An array of synonyms for the entity value. A value can specify either synonyms or patterns (depending on the value
   * type), but not both. A synonym must conform to the following resrictions:
   * - It cannot contain carriage return, newline, or tab characters.
   * - It cannot consist of only whitespace characters.
   *
   * @return the synonyms
   */
  public List<String> synonyms() {
    return synonyms;
  }

  /**
   * Gets the patterns.
   *
   * An array of patterns for the entity value. A value can specify either synonyms or patterns (depending on the value
   * type), but not both. A pattern is a regular expression; for more information about how to specify a pattern, see
   * the
   * [documentation](https://cloud.ibm.com/docs/services/assistant?topic=assistant-entities#entities-create-dictionary-based).
   *
   * @return the patterns
   */
  public List<String> patterns() {
    return patterns;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}
