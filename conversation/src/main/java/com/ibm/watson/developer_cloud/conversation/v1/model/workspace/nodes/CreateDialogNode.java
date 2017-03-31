package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.nodes;

import com.google.gson.annotations.SerializedName;

public class CreateDialogNode {

    @SerializedName("dialog_node")
    private String dialogNode;

    private String description;

    private String conditions;

    private String parent;

    @SerializedName("previous_sibling")
    private String previousSibling;

    private DialogNodeOutput output;

    private Object context;

    private Object metadata;

    @SerializedName("goTo")
    private DialogNodeGoTo goTo;

    public CreateDialogNode() {
    }

    public CreateDialogNode(String dialogNode) {
        this.dialogNode = dialogNode;
    }

    /**
     * @return The dialog node ID.
     */
    public String getDialogNode() {
        return dialogNode;
    }

    /**
     * @param dialogNode
     *            The dialog node ID.
     */
    public void setDialogNode(String dialogNode) {
        this.dialogNode = dialogNode;
    }

    /**
     * @return The description of the dialog node.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            The description of the dialog node.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The condition that will trigger the dialog node.
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * @param conditions
     *            The condition that will trigger the dialog node.
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * @return The ID of the parent dialog node.
     */
    public String getParent() {
        return parent;
    }

    /**
     * @param parent
     *            The ID of the parent dialog node.
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * @return The ID of the previous sibling dialog node.
     */
    public String getPreviousSibling() {
        return previousSibling;
    }

    /**
     * @param previousSibling
     *            The ID of the previous sibling dialog node.
     */
    public void setPreviousSibling(String previousSibling) {
        this.previousSibling = previousSibling;
    }

    /**
     * @return The output from the dialog node.
     */
    public DialogNodeOutput getOutput() {
        return output;
    }

    /**
     * @param output
     *            The output from the dialog node.
     */
    public void setOutput(DialogNodeOutput output) {
        this.output = output;
    }

    /**
     * @return The context for the dialog node.
     */
    public Object getContext() {
        return context;
    }

    /**
     * @param context
     *            The context for the dialog node.
     */
    public void setContext(Object context) {
        this.context = context;
    }

    /**
     * @return The metadata for the dialog node.
     */
    public Object getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            The metadata for the dialog node.
     */
    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The location to go to when the dialog node is triggered.
     */
    public DialogNodeGoTo getGoTo() {
        return goTo;
    }

    /**
     * @param goTo
     *            The location to go to when the dialog node is triggered.
     */
    public void setGoTo(DialogNodeGoTo goTo) {
        this.goTo = goTo;
    }
}
