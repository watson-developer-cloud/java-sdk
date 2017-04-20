package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes;

import com.google.gson.annotations.SerializedName;

public class DialogNodeGoTo {

  @SerializedName("dialog_node")
  private String dialogNode;

  private String selector;

  @SerializedName("return")
  private boolean isReturn;

  /**
   * @return The ID of the dialog node to go to.
   */
  public String getDialogNode() {
    return dialogNode;
  }

  /**
   * @param dialogNode
   *          The ID of the dialog node to go to.
   */
  public void setDialogNode(String dialogNode) {
    this.dialogNode = dialogNode;
  }

  /**
   * @return Where in the target node focus is to be passed to.
   */
  public String getSelector() {
    return selector;
  }

  /**
   * @param selector
   *          Where in the target node focus is to be passed to.
   */
  public void setSelector(String selector) {
    this.selector = selector;
  }

  /**
   * @return Reserved for future use.
   */
  public boolean isReturn() {
    return isReturn;
  }

  /**
   * @param isReturn
   *          Reserved for future use.
   */
  public void setReturn(boolean isReturn) {
    this.isReturn = isReturn;
  }

}
