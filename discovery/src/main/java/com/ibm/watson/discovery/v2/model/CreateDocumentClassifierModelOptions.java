/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.ArrayList;
import java.util.List;

/** The createDocumentClassifierModel options. */
public class CreateDocumentClassifierModelOptions extends GenericModel {

  protected String projectId;
  protected String classifierId;
  protected String name;
  protected String description;
  protected Double learningRate;
  protected List<Double> l1RegularizationStrengths;
  protected List<Double> l2RegularizationStrengths;
  protected Long trainingMaxSteps;
  protected Double improvementRatio;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String classifierId;
    private String name;
    private String description;
    private Double learningRate;
    private List<Double> l1RegularizationStrengths;
    private List<Double> l2RegularizationStrengths;
    private Long trainingMaxSteps;
    private Double improvementRatio;

    /**
     * Instantiates a new Builder from an existing CreateDocumentClassifierModelOptions instance.
     *
     * @param createDocumentClassifierModelOptions the instance to initialize the Builder with
     */
    private Builder(CreateDocumentClassifierModelOptions createDocumentClassifierModelOptions) {
      this.projectId = createDocumentClassifierModelOptions.projectId;
      this.classifierId = createDocumentClassifierModelOptions.classifierId;
      this.name = createDocumentClassifierModelOptions.name;
      this.description = createDocumentClassifierModelOptions.description;
      this.learningRate = createDocumentClassifierModelOptions.learningRate;
      this.l1RegularizationStrengths =
          createDocumentClassifierModelOptions.l1RegularizationStrengths;
      this.l2RegularizationStrengths =
          createDocumentClassifierModelOptions.l2RegularizationStrengths;
      this.trainingMaxSteps = createDocumentClassifierModelOptions.trainingMaxSteps;
      this.improvementRatio = createDocumentClassifierModelOptions.improvementRatio;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param classifierId the classifierId
     * @param name the name
     */
    public Builder(String projectId, String classifierId, String name) {
      this.projectId = projectId;
      this.classifierId = classifierId;
      this.name = name;
    }

    /**
     * Builds a CreateDocumentClassifierModelOptions.
     *
     * @return the new CreateDocumentClassifierModelOptions instance
     */
    public CreateDocumentClassifierModelOptions build() {
      return new CreateDocumentClassifierModelOptions(this);
    }

    /**
     * Adds an l1RegularizationStrengths to l1RegularizationStrengths.
     *
     * @param l1RegularizationStrengths the new l1RegularizationStrengths
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder addL1RegularizationStrengths(Double l1RegularizationStrengths) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          l1RegularizationStrengths, "l1RegularizationStrengths cannot be null");
      if (this.l1RegularizationStrengths == null) {
        this.l1RegularizationStrengths = new ArrayList<Double>();
      }
      this.l1RegularizationStrengths.add(l1RegularizationStrengths);
      return this;
    }

    /**
     * Adds an l2RegularizationStrengths to l2RegularizationStrengths.
     *
     * @param l2RegularizationStrengths the new l2RegularizationStrengths
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder addL2RegularizationStrengths(Double l2RegularizationStrengths) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          l2RegularizationStrengths, "l2RegularizationStrengths cannot be null");
      if (this.l2RegularizationStrengths == null) {
        this.l2RegularizationStrengths = new ArrayList<Double>();
      }
      this.l2RegularizationStrengths.add(l2RegularizationStrengths);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the learningRate.
     *
     * @param learningRate the learningRate
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder learningRate(Double learningRate) {
      this.learningRate = learningRate;
      return this;
    }

    /**
     * Set the l1RegularizationStrengths. Existing l1RegularizationStrengths will be replaced.
     *
     * @param l1RegularizationStrengths the l1RegularizationStrengths
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder l1RegularizationStrengths(List<Double> l1RegularizationStrengths) {
      this.l1RegularizationStrengths = l1RegularizationStrengths;
      return this;
    }

    /**
     * Set the l2RegularizationStrengths. Existing l2RegularizationStrengths will be replaced.
     *
     * @param l2RegularizationStrengths the l2RegularizationStrengths
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder l2RegularizationStrengths(List<Double> l2RegularizationStrengths) {
      this.l2RegularizationStrengths = l2RegularizationStrengths;
      return this;
    }

    /**
     * Set the trainingMaxSteps.
     *
     * @param trainingMaxSteps the trainingMaxSteps
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder trainingMaxSteps(long trainingMaxSteps) {
      this.trainingMaxSteps = trainingMaxSteps;
      return this;
    }

    /**
     * Set the improvementRatio.
     *
     * @param improvementRatio the improvementRatio
     * @return the CreateDocumentClassifierModelOptions builder
     */
    public Builder improvementRatio(Double improvementRatio) {
      this.improvementRatio = improvementRatio;
      return this;
    }
  }

  protected CreateDocumentClassifierModelOptions() {}

  protected CreateDocumentClassifierModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    projectId = builder.projectId;
    classifierId = builder.classifierId;
    name = builder.name;
    description = builder.description;
    learningRate = builder.learningRate;
    l1RegularizationStrengths = builder.l1RegularizationStrengths;
    l2RegularizationStrengths = builder.l2RegularizationStrengths;
    trainingMaxSteps = builder.trainingMaxSteps;
    improvementRatio = builder.improvementRatio;
  }

  /**
   * New builder.
   *
   * @return a CreateDocumentClassifierModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the classifierId.
   *
   * <p>The ID of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the document classifier model.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the document classifier model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the learningRate.
   *
   * <p>A tuning parameter in an optimization algorithm that determines the step size at each
   * iteration of the training process. It influences how much of any newly acquired information
   * overrides the existing information, and therefore is said to represent the speed at which a
   * machine learning model learns. The default value is `0.1`.
   *
   * @return the learningRate
   */
  public Double learningRate() {
    return learningRate;
  }

  /**
   * Gets the l1RegularizationStrengths.
   *
   * <p>Avoids overfitting by shrinking the coefficient of less important features to zero, which
   * removes some features altogether. You can specify many values for hyper-parameter optimization.
   * The default value is `[0.000001]`.
   *
   * @return the l1RegularizationStrengths
   */
  public List<Double> l1RegularizationStrengths() {
    return l1RegularizationStrengths;
  }

  /**
   * Gets the l2RegularizationStrengths.
   *
   * <p>A method you can apply to avoid overfitting your model on the training data. You can specify
   * many values for hyper-parameter optimization. The default value is `[0.000001]`.
   *
   * @return the l2RegularizationStrengths
   */
  public List<Double> l2RegularizationStrengths() {
    return l2RegularizationStrengths;
  }

  /**
   * Gets the trainingMaxSteps.
   *
   * <p>Maximum number of training steps to complete. This setting is useful if you need the
   * training process to finish in a specific time frame to fit into an automated process. The
   * default value is ten million.
   *
   * @return the trainingMaxSteps
   */
  public Long trainingMaxSteps() {
    return trainingMaxSteps;
  }

  /**
   * Gets the improvementRatio.
   *
   * <p>Stops the training run early if the improvement ratio is not met by the time the process
   * reaches a certain point. The default value is `0.00001`.
   *
   * @return the improvementRatio
   */
  public Double improvementRatio() {
    return improvementRatio;
  }
}
