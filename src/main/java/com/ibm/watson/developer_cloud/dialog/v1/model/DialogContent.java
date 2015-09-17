/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
