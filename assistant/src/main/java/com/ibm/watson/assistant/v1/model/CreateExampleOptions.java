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

/** The createExample options. */
public class CreateExampleOptions extends GenericModel {

  protected String workspaceId;
  protected String intent;
  protected String text;
  protected List<Mention> mentions;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String intent;
    private String text;
    private List<Mention> mentions;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing CreateExampleOptions instance.
     *
     * @param createExampleOptions the instance to initialize the Builder with
     */
    private Builder(CreateExampleOptions createExampleOptions) {
      this.workspaceId = createExampleOptions.workspaceId;
      this.intent = createExampleOptions.intent;
      this.text = createExampleOptions.text;
      this.mentions = createExampleOptions.mentions;
      this.includeAudit = createExampleOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param intent the intent
     * @param text the text
     */
    public Builder(String workspaceId, String intent, String text) {
      this.workspaceId = workspaceId;
      this.intent = intent;
      this.text = text;
    }

    /**
     * Builds a CreateExampleOptions.
     *
     * @return the new CreateExampleOptions instance
     */
    public CreateExampleOptions build() {
      return new CreateExampleOptions(this);
    }

    /**
     * Adds a new element to mentions.
     *
     * @param mentions the new element to be added
     * @return the CreateExampleOptions builder
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
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the CreateExampleOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the CreateExampleOptions builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CreateExampleOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the mentions. Existing mentions will be replaced.
     *
     * @param mentions the mentions
     * @return the CreateExampleOptions builder
     */
    public Builder mentions(List<Mention> mentions) {
      this.mentions = mentions;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateExampleOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }

    /**
     * Set the example.
     *
     * @param example the example
     * @return the CreateExampleOptions builder
     */
    public Builder example(Example example) {
      this.text = example.text();
      this.mentions = example.mentions();
      return this;
    }
  }

  protected CreateExampleOptions() {}

  protected CreateExampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.intent, "intent cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    workspaceId = builder.workspaceId;
    intent = builder.intent;
    text = builder.text;
    mentions = builder.mentions;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a CreateExampleOptions builder
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
   * Gets the intent.
   *
   * <p>The intent name.
   *
   * @return the intent
   */
  public String intent() {
    return intent;
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
