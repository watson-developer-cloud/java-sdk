package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

public abstract class Intent extends GenericModel {

	protected String intent;
	protected String description;

	public Intent() {
		super();
	}

	/**
	 * Identifier of the intent.
	 *
	 * @return the identifier of the intent
	 */
	public String getIntent() {
	    return intent;
	}

	/**
	 * Returns the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
	    return description;
	}

}