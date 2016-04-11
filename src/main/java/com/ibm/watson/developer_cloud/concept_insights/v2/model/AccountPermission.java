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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class AccountPermission.
 */
public class AccountPermission extends GenericModel {

  public enum Permission {

    @SerializedName("Read") READ,

    @SerializedName("Write") WRITE,

    @SerializedName("Admin") ADMIN,

    @SerializedName("ReadWriteAdmin") READ_WRITE_ADMIN;

  }

  /**
   * The account id.
   */
  @SerializedName("account_id")
  private String accountId;

  /**
   * The permission.
   */
  private Permission permission;

  /**
   * The uid.
   */
  private String uid;

  /**
   * Instantiates a new account permission.
   */
  public AccountPermission() {

  }

  /**
   * Instantiates a new account permission.
   *
   * @param accountId the account id
   * @param permission the permission
   */
  public AccountPermission(String accountId, Permission permission) {
    super();
    this.accountId = accountId;
    this.permission = permission;
  }

  /**
   * Gets the account id.
   * 
   * @return The accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the permission.
   * 
   * @return The permission
   */
  public Permission getPermission() {
    return permission;
  }

  /**
   * Gets the uid.
   * 
   * @return The uid
   */
  public String getUid() {
    return uid;
  }

  /**
   * Sets the account id.
   * 
   * @param accountId The account_id
   */
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  /**
   * Sets the permission.
   * 
   * @param permission The permission
   */
  public void setPermission(Permission permission) {
    this.permission = permission;
  }

  /**
   * Sets the uid.
   * 
   * @param uid The uid
   */
  public void setUid(String uid) {
    this.uid = uid;
  }
}
