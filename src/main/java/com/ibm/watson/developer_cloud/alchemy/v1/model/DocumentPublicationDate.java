package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

/**
 * Publication date returned by {@link AlchemyLanguage#getPublicationDate(java.util.Map)}.
 * 
 */
public class DocumentPublicationDate extends AlchemyLanguageGenericModel {

  private PublicationDate publicationDate;

  /**
   * Gets the publication date.
   * 
   * @return the publication date
   */
  public PublicationDate getPublicationDate() {
    return publicationDate;
  }

  /**
   * Sets the publication date.
   * 
   * @param publicationDate the publicationDate to set
   */
  public void setPublicationDate(PublicationDate publicationDate) {
    this.publicationDate = publicationDate;
  }

}
