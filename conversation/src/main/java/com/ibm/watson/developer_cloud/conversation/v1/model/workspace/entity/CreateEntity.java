package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CreateEntity {

  private String entity;
  private String description;
  private String type;
  private String source;

  @SerializedName("open_list")
  private boolean openList;
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
   * @return The name of the entity.
   */
  public String getEntity() {
    return entity;
  }

  /**
   * @param entity
   *          The name of the entity.
   */
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * @return The description of the entity.
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description
   *          The description of the entity.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the type. Reserved for future use.
   */
  public String getType() {
    return type;
  }

  /**
   * @param type
   *          the type to set. Reserved for future use.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return The source of the entity. For system entities, system.entities is
   *         returned.
   */
  public String getSource() {
    return source;
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
   * @return the openList
   */
  public boolean isOpenList() {
    return openList;
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
   * @return An array of entity values.
   */
  public List<CreateValue> getValues() {
    return values;
  }

  /**
   * @param values
   *          An array of entity values.
   */
  public void setValues(List<CreateValue> values) {
    this.values = values;
  }
}
