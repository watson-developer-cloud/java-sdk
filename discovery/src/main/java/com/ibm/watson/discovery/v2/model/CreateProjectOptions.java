/*
 * (C) Copyright IBM Corp. 2022.
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

/** The createProject options. */
public class CreateProjectOptions extends GenericModel {

  /**
   * The type of project.
   *
   * <p>The `content_intelligence` type is a *Document Retrieval for Contracts* project and the
   * `other` type is a *Custom* project.
   *
   * <p>The `content_mining` and `content_intelligence` types are available with Premium plan
   * managed deployments and installed deployments only.
   */
  public interface Type {
    /** document_retrieval. */
    String DOCUMENT_RETRIEVAL = "document_retrieval";
    /** conversational_search. */
    String CONVERSATIONAL_SEARCH = "conversational_search";
    /** content_intelligence. */
    String CONTENT_INTELLIGENCE = "content_intelligence";
    /** content_mining. */
    String CONTENT_MINING = "content_mining";
    /** other. */
    String OTHER = "other";
  }

  protected String name;
  protected String type;
  protected DefaultQueryParams defaultQueryParameters;

  /** Builder. */
  public static class Builder {
    private String name;
    private String type;
    private DefaultQueryParams defaultQueryParameters;

    private Builder(CreateProjectOptions createProjectOptions) {
      this.name = createProjectOptions.name;
      this.type = createProjectOptions.type;
      this.defaultQueryParameters = createProjectOptions.defaultQueryParameters;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param type the type
     */
    public Builder(String name, String type) {
      this.name = name;
      this.type = type;
    }

    /**
     * Builds a CreateProjectOptions.
     *
     * @return the new CreateProjectOptions instance
     */
    public CreateProjectOptions build() {
      return new CreateProjectOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProjectOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateProjectOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the defaultQueryParameters.
     *
     * @param defaultQueryParameters the defaultQueryParameters
     * @return the CreateProjectOptions builder
     */
    public Builder defaultQueryParameters(DefaultQueryParams defaultQueryParameters) {
      this.defaultQueryParameters = defaultQueryParameters;
      return this;
    }
  }

  protected CreateProjectOptions() {}

  protected CreateProjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type, "type cannot be null");
    name = builder.name;
    type = builder.type;
    defaultQueryParameters = builder.defaultQueryParameters;
  }

  /**
   * New builder.
   *
   * @return a CreateProjectOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>The human readable name of this project.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * <p>The type of project.
   *
   * <p>The `content_intelligence` type is a *Document Retrieval for Contracts* project and the
   * `other` type is a *Custom* project.
   *
   * <p>The `content_mining` and `content_intelligence` types are available with Premium plan
   * managed deployments and installed deployments only.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the defaultQueryParameters.
   *
   * <p>Default query parameters for this project.
   *
   * @return the defaultQueryParameters
   */
  public DefaultQueryParams defaultQueryParameters() {
    return defaultQueryParameters;
  }
}
