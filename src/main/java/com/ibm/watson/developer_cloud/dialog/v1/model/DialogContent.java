package com.ibm.watson.developer_cloud.dialog.v1.model;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Dialog content used by the {@link DialogService}.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class DialogContent {
	
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
	 * With node.
	 *
	 * @param node the node
	 * @return the example
	 */
	public DialogContent withNode(final String node) {
		this.node = node;
		return this;
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

	/**
	 * With content.
	 *
	 * @param content the content
	 * @return the example
	 */
	public DialogContent withContent(final String content) {
		this.content = content;
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ GsonSingleton.getGson().toJson(this);
	}
}
