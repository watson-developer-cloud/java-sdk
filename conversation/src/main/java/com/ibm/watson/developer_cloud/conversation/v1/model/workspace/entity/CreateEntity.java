package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

public class CreateEntity extends Entity {

  private List<CreateValue> values;

  /**
   * Constructs a new entity.
   */
  public CreateEntity() {
  }

  /**
   * Constructs a new entity.
   * @param entity
   *          the entity name
   */
  public CreateEntity(String entity) {
    this.entity = entity;
  }

  /**
   * @param entity
   *          The name of the entity.
   */
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * @param description
   *          The description of the entity.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @param type
   *          the type to set. Reserved for future use.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @param source
   *          The source of the entity. For system entities, system.entities is
   *          returned.
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Reserved for future use.
   * @param openList
   *          the openList to set. Reserved for future use.
   */
  public void setOpenList(boolean openList) {
    this.openList = openList;
  }

  /**
   * @param values
   *          An array of entity values.
   */
  public void setValues(List<CreateValue> values) {
    this.values = values;
  }
  
  /**
   * @return An array of entity values.
   */
  public List<CreateValue> getValues() {
    return values;
  }
}
