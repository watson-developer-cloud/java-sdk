package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.entity;

import com.google.gson.annotations.SerializedName;

public abstract class Entity {

  protected String entity;
  protected String description;
  protected String type;
  protected String source;
  @SerializedName("open_list")
  protected boolean openList;

  public Entity() {
    super();
  }

  /**
   * @return The name of the entity.
   */
  public String getEntity() {
    return entity;
  }

  /**
   * @return The description of the entity.
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the type. Reserved for future use.
   */
  public String getType() {
    return type;
  }

  /**
   * @return The source of the entity. For system entities, system.entities is
   *         returned.
   */
  public String getSource() {
    return source;
  }

  /**
   * Reserved for future use.
   * @return the openList
   */
  public boolean isOpenList() {
    return openList;
  }

}
