package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Dialog content used by the {@link DialogService}.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class DialogContent  extends GenericModel {
	
	/** The node. */
	private String node;
	
	/** The content. */
	private String content;

	/**
	 * Gets the node.
	 *
	 * @return The node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * Sets the node.
	 *
	 * @param node The node
	 */
	public void setNode(final String node) {
		this.node = node;
	}

	/**
	 * Gets the content.
	 *
	 * @return The content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content            The content
	 */
	public void setContent(final String content) {
		this.content = content;
	}
}
