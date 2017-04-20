package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

public abstract class Value {

  protected String value;
  protected Object metadata;
  protected List<String> synonyms;

  public Value() {
    super();
  }

  /**
   * @return The text of the entity value.
   */
  public String getValue() {
    return value;
  }

  /**
   * @return Any metadata related to the entity value.
   */
  public Object getMetadata() {
    return metadata;
  }

  /**
   * @return An array containing any synonyms for the entity value.
   */
  public List<String> getSynonyms() {
    return synonyms;
  }

}
