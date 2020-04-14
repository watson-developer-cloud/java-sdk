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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** The analysis of objects returned by the **Element classification** method. */
public class ClassifyReturn extends GenericModel {

  protected Document document;

  @SerializedName("model_id")
  protected String modelId;

  @SerializedName("model_version")
  protected String modelVersion;

  protected List<Element> elements;

  @SerializedName("effective_dates")
  protected List<EffectiveDates> effectiveDates;

  @SerializedName("contract_amounts")
  protected List<ContractAmts> contractAmounts;

  @SerializedName("termination_dates")
  protected List<TerminationDates> terminationDates;

  @SerializedName("contract_types")
  protected List<ContractTypes> contractTypes;

  @SerializedName("contract_terms")
  protected List<ContractTerms> contractTerms;

  @SerializedName("payment_terms")
  protected List<PaymentTerms> paymentTerms;

  @SerializedName("contract_currencies")
  protected List<ContractCurrencies> contractCurrencies;

  protected List<Tables> tables;

  @SerializedName("document_structure")
  protected DocStructure documentStructure;

  protected List<Parties> parties;

  /**
   * Gets the document.
   *
   * <p>Basic information about the input document.
   *
   * @return the document
   */
  public Document getDocument() {
    return document;
  }

  /**
   * Gets the modelId.
   *
   * <p>The analysis model used to classify the input document. For the **Element classification**
   * method, the only valid value is `contracts`.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * <p>The version of the analysis model identified by the value of the `model_id` key.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Gets the elements.
   *
   * <p>Document elements identified by the service.
   *
   * @return the elements
   */
  public List<Element> getElements() {
    return elements;
  }

  /**
   * Gets the effectiveDates.
   *
   * <p>The date or dates on which the document becomes effective.
   *
   * @return the effectiveDates
   */
  public List<EffectiveDates> getEffectiveDates() {
    return effectiveDates;
  }

  /**
   * Gets the contractAmounts.
   *
   * <p>The monetary amounts that identify the total amount of the contract that needs to be paid
   * from one party to another.
   *
   * @return the contractAmounts
   */
  public List<ContractAmts> getContractAmounts() {
    return contractAmounts;
  }

  /**
   * Gets the terminationDates.
   *
   * <p>The dates on which the document is to be terminated.
   *
   * @return the terminationDates
   */
  public List<TerminationDates> getTerminationDates() {
    return terminationDates;
  }

  /**
   * Gets the contractTypes.
   *
   * <p>The contract type as declared in the document.
   *
   * @return the contractTypes
   */
  public List<ContractTypes> getContractTypes() {
    return contractTypes;
  }

  /**
   * Gets the contractTerms.
   *
   * <p>The durations of the contract.
   *
   * @return the contractTerms
   */
  public List<ContractTerms> getContractTerms() {
    return contractTerms;
  }

  /**
   * Gets the paymentTerms.
   *
   * <p>The document's payment durations.
   *
   * @return the paymentTerms
   */
  public List<PaymentTerms> getPaymentTerms() {
    return paymentTerms;
  }

  /**
   * Gets the contractCurrencies.
   *
   * <p>The contract currencies as declared in the document.
   *
   * @return the contractCurrencies
   */
  public List<ContractCurrencies> getContractCurrencies() {
    return contractCurrencies;
  }

  /**
   * Gets the tables.
   *
   * <p>Definition of tables identified in the input document.
   *
   * @return the tables
   */
  public List<Tables> getTables() {
    return tables;
  }

  /**
   * Gets the documentStructure.
   *
   * <p>The structure of the input document.
   *
   * @return the documentStructure
   */
  public DocStructure getDocumentStructure() {
    return documentStructure;
  }

  /**
   * Gets the parties.
   *
   * <p>Definitions of the parties identified in the input document.
   *
   * @return the parties
   */
  public List<Parties> getParties() {
    return parties;
  }
}
