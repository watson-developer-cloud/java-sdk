package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent;

/**
 * a request to create an example
 * @author davidbo
 *
 */
public class CreateExample {

	protected String text;

	/**
	 * a request to create an example
	 */
	public CreateExample() {}

	/**
	 * a request to create an example
	 * @param text The text of a user input example.
	 */
	public CreateExample(String text) {
		this.setText(text);
	}

	/**
	 * @return The text of a user input example.
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text The text of a user input example.
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
