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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Result by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class DocumentsResult extends GenericModel {

    /** The document. */
    @SerializedName("result")
    private Documents documents;

    /** The total transactions. */
    private Integer totalTransactions;

    /**
	 * Gets the document.
	 *
	 * @return the document
	 */
	public Documents getDocuments() {
		return documents;
	}

    /**
     * Gets the total transactions.
     *
     * @return The totalTransactions
     */
    public Integer getTotalTransactions() {
        return totalTransactions;
    }

	/**
	 * Sets the document.
	 *
	 * @param documents the document to set
	 */
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	/**
     * Sets the total transactions.
     *
     * @param totalTransactions The totalTransactions
     */
    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

}
