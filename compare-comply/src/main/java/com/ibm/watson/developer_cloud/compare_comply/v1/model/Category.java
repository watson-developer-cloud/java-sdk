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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information defining an element's subject matter.
 */
public class Category extends GenericModel {

  /**
   * The category of the associated element.
   */
  public interface Label {
    /** Amendments. */
    String AMENDMENTS = "Amendments";
    /** Asset Use. */
    String ASSET_USE = "Asset Use";
    /** Assignments. */
    String ASSIGNMENTS = "Assignments";
    /** Audits. */
    String AUDITS = "Audits";
    /** Business Continuity. */
    String BUSINESS_CONTINUITY = "Business Continuity";
    /** Communication. */
    String COMMUNICATION = "Communication";
    /** Confidentiality. */
    String CONFIDENTIALITY = "Confidentiality";
    /** Deliverables. */
    String DELIVERABLES = "Deliverables";
    /** Delivery. */
    String DELIVERY = "Delivery";
    /** Dispute Resolution. */
    String DISPUTE_RESOLUTION = "Dispute Resolution";
    /** Force Majeure. */
    String FORCE_MAJEURE = "Force Majeure";
    /** Indemnification. */
    String INDEMNIFICATION = "Indemnification";
    /** Insurance. */
    String INSURANCE = "Insurance";
    /** Intellectual Property. */
    String INTELLECTUAL_PROPERTY = "Intellectual Property";
    /** Liability. */
    String LIABILITY = "Liability";
    /** Payment Terms & Billing. */
    String PAYMENT_TERMS_BILLING = "Payment Terms & Billing";
    /** Pricing & Taxes. */
    String PRICING_TAXES = "Pricing & Taxes";
    /** Privacy. */
    String PRIVACY = "Privacy";
    /** Responsibilities. */
    String RESPONSIBILITIES = "Responsibilities";
    /** Safety and Security. */
    String SAFETY_AND_SECURITY = "Safety and Security";
    /** Scope of Work. */
    String SCOPE_OF_WORK = "Scope of Work";
    /** Subcontracts. */
    String SUBCONTRACTS = "Subcontracts";
    /** Term & Termination. */
    String TERM_TERMINATION = "Term & Termination";
    /** Warranties. */
    String WARRANTIES = "Warranties";
  }

  private String label;
  @SerializedName("provenance_ids")
  private List<String> provenanceIds;

  /**
   * Gets the label.
   *
   * The category of the associated element.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Gets the provenanceIds.
   *
   * One or more hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> getProvenanceIds() {
    return provenanceIds;
  }

  /**
   * Sets the label.
   *
   * @param label the new label
   */
  public void setLabel(final String label) {
    this.label = label;
  }

  /**
   * Sets the provenanceIds.
   *
   * @param provenanceIds the new provenanceIds
   */
  public void setProvenanceIds(final List<String> provenanceIds) {
    this.provenanceIds = provenanceIds;
  }
}
