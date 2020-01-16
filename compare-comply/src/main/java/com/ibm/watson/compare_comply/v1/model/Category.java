/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

import java.util.ArrayList;
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
    /** Order of Precedence. */
    String ORDER_OF_PRECEDENCE = "Order of Precedence";
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

  protected String label;
  @SerializedName("provenance_ids")
  protected List<String> provenanceIds;

  /**
   * Builder.
   */
  public static class Builder {
    private String label;
    private List<String> provenanceIds;

    private Builder(Category category) {
      this.label = category.label;
      this.provenanceIds = category.provenanceIds;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Category.
     *
     * @return the category
     */
    public Category build() {
      return new Category(this);
    }

    /**
     * Adds an provenanceIds to provenanceIds.
     *
     * @param provenanceIds the new provenanceIds
     * @return the Category builder
     */
    public Builder addProvenanceIds(String provenanceIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(provenanceIds,
          "provenanceIds cannot be null");
      if (this.provenanceIds == null) {
        this.provenanceIds = new ArrayList<String>();
      }
      this.provenanceIds.add(provenanceIds);
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the Category builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the provenanceIds.
     * Existing provenanceIds will be replaced.
     *
     * @param provenanceIds the provenanceIds
     * @return the Category builder
     */
    public Builder provenanceIds(List<String> provenanceIds) {
      this.provenanceIds = provenanceIds;
      return this;
    }
  }

  protected Category(Builder builder) {
    label = builder.label;
    provenanceIds = builder.provenanceIds;
  }

  /**
   * New builder.
   *
   * @return a Category builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the label.
   *
   * The category of the associated element.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the provenanceIds.
   *
   * Hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> provenanceIds() {
    return provenanceIds;
  }
}
