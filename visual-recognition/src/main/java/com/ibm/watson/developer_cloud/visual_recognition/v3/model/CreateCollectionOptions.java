/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createCollection options.
 */
public class CreateCollectionOptions extends GenericModel {

  private String name;
  private InputStream disregard;
  private String disregardFilename;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private InputStream disregard;
    private String disregardFilename;

    private Builder(CreateCollectionOptions createCollectionOptions) {
      name = createCollectionOptions.name;
      disregard = createCollectionOptions.disregard;
      disregardFilename = createCollectionOptions.disregardFilename;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a CreateCollectionOptions.
     *
     * @return the createCollectionOptions
     */
    public CreateCollectionOptions build() {
      return new CreateCollectionOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the disregard.
     *
     * @param disregard the disregard
     * @return the CreateCollectionOptions builder
     */
    public Builder disregard(InputStream disregard) {
      this.disregard = disregard;
      return this;
    }

    /**
     * Set the disregardFilename.
     *
     * @param disregardFilename the disregardFilename
     * @return the CreateCollectionOptions builder
     */
    public Builder disregardFilename(String disregardFilename) {
      this.disregardFilename = disregardFilename;
      return this;
    }

    /**
     * Set the disregard.
     *
     * @param disregard the disregard
     * @return the CreateCollectionOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder disregard(File disregard) throws FileNotFoundException {
      this.disregard = new FileInputStream(disregard);
      this.disregardFilename = disregard.getName();
      return this;
    }
  }

  private CreateCollectionOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    name = builder.name;
    disregard = builder.disregard;
    disregardFilename = builder.disregardFilename;
  }

  /**
   * New builder.
   *
   * @return a CreateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the new collection. The name can be a maximum of 128 UTF8 characters, with no spaces.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the disregard.
   *
   * Disregard this parameter. In order for the swagger spec to work, there needs to be at least one file in a
   * multipart/form-data call. Uploading a file using this parameter has no impact on the collection.
   *
   * @return the disregard
   */
  public InputStream disregard() {
    return disregard;
  }

  /**
   * Gets the disregardFilename.
   *
   * The filename for disregard.
   *
   * @return the disregardFilename
   */
  public String disregardFilename() {
    return disregardFilename;
  }
}
