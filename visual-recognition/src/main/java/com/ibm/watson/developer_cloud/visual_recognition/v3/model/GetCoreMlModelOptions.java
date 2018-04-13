/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getCoreMlModel options.
 */
public class GetCoreMlModelOptions extends GenericModel {

  private String classifierId;

  /**
   * Builder.
   */
  public static class Builder {
    private String classifierId;

    private Builder(GetCoreMlModelOptions getCoreMlModelOptions) {
      classifierId = getCoreMlModelOptions.classifierId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param classifierId the classifierId
     */
    public Builder(String classifierId) {
      this.classifierId = classifierId;
    }

    /**
     * Builds a GetCoreMlModelOptions.
     *
     * @return the getCoreMlModelOptions
     */
    public GetCoreMlModelOptions build() {
      return new GetCoreMlModelOptions(this);
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the GetCoreMlModelOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }
  }

  private GetCoreMlModelOptions(Builder builder) {
    Validator.notEmpty(builder.classifierId, "classifierId cannot be empty");
    classifierId = builder.classifierId;
  }

  /**
   * New builder.
   *
   * @return a GetCoreMlModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the classifierId.
   *
   * The ID of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }
}
