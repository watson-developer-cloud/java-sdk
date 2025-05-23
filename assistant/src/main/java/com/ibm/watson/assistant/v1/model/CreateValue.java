/*
 * (C) Copyright IBM Corp. 2017, 2024.
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/** CreateValue. */
public class CreateValue extends GenericModel {

  /** Specifies the type of entity value. */
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

  /** Builder. */
  public static class Builder {
    private String value;
    private Map<String, Object> metadata;
    private String type;
    private List<String> synonyms;
    private List<String> patterns;

    /**
     * Instantiates a new Builder from an existing CreateValue instance.
     *
     * @param createValue the instance to initialize the Builder with
     */
    private Builder(CreateValue createValue) {
      this.value = createValue.value;
      this.metadata = createValue.metadata;
      this.type = createValue.type;
      this.synonyms = createValue.synonyms;
      this.patterns = createValue.patterns;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new CreateValue instance
     */
    public CreateValue build() {
      return new CreateValue(this);
    }

    /**
     * Adds a new element to synonyms.
     *
     * @param synonym the new element to be added
     * @return the CreateValue builder
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
     * Adds a new element to patterns.
     *
     * @param pattern the new element to be added
     * @return the CreateValue builder
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
     * Set the synonyms. Existing synonyms will be replaced.
     *
     * @param synonyms the synonyms
     * @return the CreateValue builder
     */
    public Builder synonyms(List<String> synonyms) {
      this.synonyms = synonyms;
      return this;
    }

    /**
     * Set the patterns. Existing patterns will be replaced.
     *
     * @param patterns the patterns
     * @return the CreateValue builder
     */
    public Builder patterns(List<String> patterns) {
      this.patterns = patterns;
      return this;
    }
  }

  protected CreateValue() {}

  protected CreateValue(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value, "value cannot be null");
    value = builder.value;
    metadata = builder.metadata;
    type = builder.type;
    synonyms = builder.synonyms;
    patterns = builder.patterns;
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
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}
