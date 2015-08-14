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
package com.ibm.watson.developer_cloud.concept_expansion.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_expansion.v1.ConceptExpansion;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Job created by the {@link ConceptExpansion} service. It contains and id and a
 * {@link Job.Status}
 */
public class Job {

	/**
	 * The Enum Status.
	 */
	public enum Status {
		
		/** The awaiting work. */
		AWAITING_WORK("Awaiting Work", "A"), 
 /** The in flight. */
 IN_FLIGHT("In Flight", "G"), 
 /** The failed. */
 FAILED(
				"Failed", "F"), 
 /** The retrieved. */
 RETRIEVED("Retrieved", "R"), 
 /** The done. */
 DONE("Done", "D");

		/**
		 * Returns the job status that match the given id.
		 * 
		 * @param id
		 *            the id
		 * @return the status
		 */
		public static Status fromString(final String id) {
			for (Status st : values()) {
				if (id.equals(st.getId()))
					return st;
			}
			return null;
		}

		/** The id. */
		private String id;
		
		/** The name. */
		private String name;

		/**
		 * Instantiates a new status.
		 * 
		 * @param name
		 *            the name
		 * @param id
		 *            the id
		 */
		private Status(String name, String id) {
			this.name = name;
			this.id = id;
		}

		/**
		 * Gets the id.
		 * 
		 * 
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * Gets the name.
		 * 
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}
	}

	/** The status. */
	private Status status;
	
	/** The id. */
	@SerializedName("jobid")
	private String id;

	/**
	 * Instantiates a new job.
	 * 
	 * @param id
	 *            the id
	 */
	public Job(String id) {
		this.id = id;
		status = Status.AWAITING_WORK;
	}

	/**
	 * Instantiates a new job.
	 */
	public Job() {

	}

	/**
	 * Gets the id.
	 * 
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the status.
	 * 
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
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
