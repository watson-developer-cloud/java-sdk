package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

public class CreateValue extends Value {

  /**
   * @param value
   *          The text of the entity value.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @param metadata
   *          Any metadata related to the entity value.
   */
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   * @param synonyms
   *          An array containing any synonyms for the entity value.
   */
  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }

}
