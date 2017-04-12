package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes;

public class CreateDialogNode extends DialogNode {

  public CreateDialogNode() {
  }

  public CreateDialogNode(String dialogNode) {
    this.dialogNode = dialogNode;
  }

  /**
   * @param dialogNode
   *          The dialog node ID.
   */
  public void setDialogNode(String dialogNode) {
    this.dialogNode = dialogNode;
  }

  /**
   * @param description
   *          The description of the dialog node.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @param conditions
   *          The condition that will trigger the dialog node.
   */
  public void setConditions(String conditions) {
    this.conditions = conditions;
  }

  /**
   * @param parent
   *          The ID of the parent dialog node.
   */
  public void setParent(String parent) {
    this.parent = parent;
  }

  /**
   * @param previousSibling
   *          The ID of the previous sibling dialog node.
   */
  public void setPreviousSibling(String previousSibling) {
    this.previousSibling = previousSibling;
  }

  /**
   * @param output
   *          The output from the dialog node.
   */
  public void setOutput(DialogNodeOutput output) {
    this.output = output;
  }

  /**
   * @param context
   *          The context for the dialog node.
   */
  public void setContext(Object context) {
    this.context = context;
  }

  /**
   * @param metadata
   *          The metadata for the dialog node.
   */
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   * @param goTo
   *          The location to go to when the dialog node is triggered.
   */
  public void setGoTo(DialogNodeGoTo goTo) {
    this.goTo = goTo;
  }
}
