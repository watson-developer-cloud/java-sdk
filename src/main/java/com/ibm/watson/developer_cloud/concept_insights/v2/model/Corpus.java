/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * Graphs returned by the {@link ConceptInsights} service.
 * 
 */
public class Corpus extends GenericModel {

  /** The Constant IBM_RESEARCHERS. */
  public final static Corpus IBM_RESEARCHERS = new Corpus("public", "ibmresearcher");

  /** The Constant TED_TALKS. */
  public final static Corpus TED_TALKS = new Corpus("public", "TEDTalks");

  /** The access. */
  private String access;

  /** The accountPermissions. */
  @SerializedName("users")
  private List<AccountPermission> accountPermissions;

  /** The id. */
  private String id;

  /** The corpus name. */
  private String name;

  /**
   * Instantiates a new corpus.
   */
  public Corpus() {}

  /**
   * Instantiates a new corpus.
   * 
   * @param accountId the account id
   * @param name the corpus name
   */
  public Corpus(String accountId, String name) {
    Validate.notEmpty(accountId, "accountId cannot be empty");
    Validate.notEmpty(name, "name cannot be empty");
    setName(name);
    setId("/corpora/" + accountId + "/" + name);
  }

  /**
   * Gets the access.
   * 
   * @return The access
   */
  public String getAccess() {
    return access;
  }

  /**
   * Gets the accountPermissions.
   * 
   * @return The accountPermissions
   */
  public List<AccountPermission> getAccountPermissions() {
    return accountPermissions;
  }

  /**
   * Gets the id.
   * 
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   * 
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the access.
   * 
   * @param access The access
   */
  public void setAccess(String access) {
    this.access = access;
  }

  /**
   * Sets the accountPermissions.
   * 
   * @param accountPermissions The accountPermissions
   */
  public void setAccountPermissions(List<AccountPermission> accountPermissions) {
    this.accountPermissions = accountPermissions;
  }

  /**
   * Sets the id.
   * 
   * @param id The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the name.
   * 
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * With name.
   * 
   * @param name the name
   * @return the corpus
   */
  public Corpus withName(String name) {
    setName(name);
    return this;
  }
}
