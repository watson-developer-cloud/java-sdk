/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** A party and its corresponding role, including address and contact information if identified. */
public class Parties extends GenericModel {

  /** A string that identifies the importance of the party. */
  public interface Importance {
    /** Primary. */
    String PRIMARY = "Primary";
    /** Unknown. */
    String UNKNOWN = "Unknown";
  }

  protected String party;
  protected String role;
  protected String importance;
  protected List<Address> addresses;
  protected List<Contact> contacts;
  protected List<Mention> mentions;

  /**
   * Gets the party.
   *
   * <p>The normalized form of the party's name.
   *
   * @return the party
   */
  public String getParty() {
    return party;
  }

  /**
   * Gets the role.
   *
   * <p>A string identifying the party's role.
   *
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * Gets the importance.
   *
   * <p>A string that identifies the importance of the party.
   *
   * @return the importance
   */
  public String getImportance() {
    return importance;
  }

  /**
   * Gets the addresses.
   *
   * <p>A list of the party's address or addresses.
   *
   * @return the addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  /**
   * Gets the contacts.
   *
   * <p>A list of the names and roles of contacts identified in the input document.
   *
   * @return the contacts
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Gets the mentions.
   *
   * <p>A list of the party's mentions in the input document.
   *
   * @return the mentions
   */
  public List<Mention> getMentions() {
    return mentions;
  }
}
