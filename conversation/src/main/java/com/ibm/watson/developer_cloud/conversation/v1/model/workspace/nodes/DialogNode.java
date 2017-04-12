package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes;

import com.google.gson.annotations.SerializedName;

public abstract class DialogNode {

  @SerializedName("dialog_node")
  protected String dialogNode;
  protected String description;
  protected String conditions;
  protected String parent;
  @SerializedName("previous_sibling")
  protected String previousSibling;
  protected DialogNodeOutput output;
  protected Object context;
  protected Object metadata;
  @SerializedName("goTo")
  protected DialogNodeGoTo goTo;

  public DialogNode() {
    super();
  }

  /**
   * @return The dialog node ID.
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * @return The description of the dialog node.
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return The condition that will trigger the dialog node.
   */
  public String getConditions() {
    return conditions;
  }

  /**
   * @return The ID of the parent dialog node.
   */
  public String getParent() {
    return parent;
  }

  /**
   * @return The ID of the previous sibling dialog node.
   */
  public String getPreviousSibling() {
    return previousSibling;
  }

  /**
   * @return The output from the dialog node.
   */
  public DialogNodeOutput getOutput() {
    return output;
  }

  /**
   * @return The context for the dialog node.
   */
  public Object getContext() {
    return context;
  }

  /**
   * @return The metadata for the dialog node.
   */
  public Object getMetadata() {
    return metadata;
  }

  /**
   * @return The location to go to when the dialog node is triggered.
   */
  public DialogNodeGoTo getGoTo() {
    return goTo;
  }

}
