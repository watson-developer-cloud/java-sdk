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
import java.util.Date;
import java.util.List;

/** Example. */
public class Example extends GenericModel {

  protected String text;
  protected List<Mention> mentions;
  protected Date created;
  protected Date updated;

  /** Builder. */
  public static class Builder {
    private String text;
    private List<Mention> mentions;

    /**
     * Instantiates a new Builder from an existing Example instance.
     *
     * @param example the instance to initialize the Builder with
     */
    private Builder(Example example) {
      this.text = example.text;
      this.mentions = example.mentions;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a Example.
     *
     * @return the new Example instance
     */
    public Example build() {
      return new Example(this);
    }

    /**
     * Adds a new element to mentions.
     *
     * @param mentions the new element to be added
     * @return the Example builder
     */
    public Builder addMentions(Mention mentions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(mentions, "mentions cannot be null");
      if (this.mentions == null) {
        this.mentions = new ArrayList<Mention>();
      }
      this.mentions.add(mentions);
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the Example builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the mentions. Existing mentions will be replaced.
     *
     * @param mentions the mentions
     * @return the Example builder
     */
    public Builder mentions(List<Mention> mentions) {
      this.mentions = mentions;
      return this;
    }
  }

  protected Example() {}

  protected Example(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    mentions = builder.mentions;
  }

  /**
   * New builder.
   *
   * @return a Example builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The text of a user input example. This string must conform to the following restrictions: -
   * It cannot contain carriage return, newline, or tab characters. - It cannot consist of only
   * whitespace characters.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the mentions.
   *
   * <p>An array of contextual entity mentions.
   *
   * @return the mentions
   */
  public List<Mention> mentions() {
    return mentions;
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
