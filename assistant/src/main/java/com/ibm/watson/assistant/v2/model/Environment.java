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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;

/** Environment. */
public class Environment extends GenericModel {

  protected String name;
  protected String description;
  protected String language;

  @SerializedName("assistant_id")
  protected String assistantId;

  @SerializedName("environment_id")
  protected String environmentId;

  protected String environment;

  @SerializedName("release_reference")
  protected EnvironmentReleaseReference releaseReference;

  protected EnvironmentOrchestration orchestration;

  @SerializedName("session_timeout")
  protected Long sessionTimeout;

  @SerializedName("integration_references")
  protected List<IntegrationReference> integrationReferences;

  @SerializedName("skill_references")
  protected List<SkillReference> skillReferences;

  protected Date created;
  protected Date updated;

  /**
   * Gets the name.
   *
   * <p>The name of the environment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the environment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the environment. An environment is always created with the same language as
   * the assistant it is associated with.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID of the assistant the environment is associated with.
   *
   * @return the assistantId
   */
  public String getAssistantId() {
    return assistantId;
  }

  /**
   * Gets the environmentId.
   *
   * <p>The environment ID of the environment.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the environment.
   *
   * <p>The type of the environment. All environments other than the draft and live environments
   * have the type `staging`.
   *
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * Gets the releaseReference.
   *
   * <p>An object describing the release that is currently deployed in the environment.
   *
   * @return the releaseReference
   */
  public EnvironmentReleaseReference getReleaseReference() {
    return releaseReference;
  }

  /**
   * Gets the orchestration.
   *
   * <p>The search skill orchestration settings for message API.
   *
   * @return the orchestration
   */
  public EnvironmentOrchestration getOrchestration() {
    return orchestration;
  }

  /**
   * Gets the sessionTimeout.
   *
   * <p>The session inactivity timeout setting of for the environment.
   *
   * @return the sessionTimeout
   */
  public Long getSessionTimeout() {
    return sessionTimeout;
  }

  /**
   * Gets the integrationReferences.
   *
   * <p>An array of objects describing the integrations that exist in the environment.
   *
   * @return the integrationReferences
   */
  public List<IntegrationReference> getIntegrationReferences() {
    return integrationReferences;
  }

  /**
   * Gets the skillReferences.
   *
   * <p>An array of objects describing the skills (such as actions and dialog) that exist in the
   * environment.
   *
   * @return the skillReferences
   */
  public List<SkillReference> getSkillReferences() {
    return skillReferences;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
