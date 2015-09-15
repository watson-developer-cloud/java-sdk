package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Account returned by the {@link ConceptInsights} service.
 * 
 */
public class Account extends GenericModel {

	/** The id. */
	@SerializedName("account_id")
	private String id;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
