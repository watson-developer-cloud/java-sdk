package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.example;

public abstract class Example {

  protected String text;

  public Example() {
    super();
  }

  /**
   * @return The text of a user input example.
   */
  public String getText() {
    return text;
  }

}
