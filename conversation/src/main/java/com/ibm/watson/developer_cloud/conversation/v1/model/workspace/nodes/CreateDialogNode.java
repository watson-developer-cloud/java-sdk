package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes;

public class CreateDialogNode {
	private String dialog_node;
//	The dialog node ID.
	
	private String description;
//	The description of the dialog node.
	
	private String conditions;
//	The condition that will trigger the dialog node.
	
	private String parent;
//	The ID of the parent dialog node.
	
	private String previous_sibling ;
//	The ID of the previous sibling dialog node.
	
	private DialogNodeOutput output	;
//	The output from the dialog node.
	
	private Object context;
//	The context for the dialog node.
	
	private Object metadata;
//	The metadata for the dialog node.
	
	private DialogNodeGoTo go_to;
//	The location to go to when the dialog node is triggered.

	/**
	 * @return the dialog_node
	 */
	public String getDialog_node() {
		return dialog_node;
	}

	/**
	 * @param dialog_node the dialog_node to set
	 */
	public void setDialog_node(String dialog_node) {
		this.dialog_node = dialog_node;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the previous_sibling
	 */
	public String getPrevious_sibling() {
		return previous_sibling;
	}

	/**
	 * @param previous_sibling the previous_sibling to set
	 */
	public void setPrevious_sibling(String previous_sibling) {
		this.previous_sibling = previous_sibling;
	}

	/**
	 * @return the output
	 */
	public DialogNodeOutput getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(DialogNodeOutput output) {
		this.output = output;
	}

	/**
	 * @return the context
	 */
	public Object getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Object context) {
		this.context = context;
	}

	/**
	 * @return the metadata
	 */
	public Object getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the go_to
	 */
	public DialogNodeGoTo getGo_to() {
		return go_to;
	}

	/**
	 * @param go_to the go_to to set
	 */
	public void setGo_to(DialogNodeGoTo go_to) {
		this.go_to = go_to;
	}
}
