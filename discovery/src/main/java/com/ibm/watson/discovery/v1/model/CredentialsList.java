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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Object containing array of credential definitions. */
public class CredentialsList extends GenericModel {

  protected List<Credentials> credentials;

  protected CredentialsList() {}

  /**
   * Gets the credentials.
   *
   * <p>An array of credential definitions that were created for this instance.
   *
   * @return the credentials
   */
  public List<Credentials> getCredentials() {
    return credentials;
  }
}
