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

package com.ibm.watson.developer_cloud.question_and_answer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * A POJO class with the question and the answers.
 */
public class WatsonAnswer {

	/** The answers. */
	private List<Answer> answers = new ArrayList<Answer>();
	
	/** The category. */
	private String category;
	
	/** The error notifications. */
	private List<Object> errorNotifications = new ArrayList<Object>();
	
	/** The evidence request. */
	private EvidenceRequest evidenceRequest;
	
	/** The evidencelist. */
	private List<Evidence> evidencelist = new ArrayList<Evidence>();
	
	/** The focuslist. */
	private List<Focus> focuslist = new ArrayList<Focus>();
	
	/** The formatted answer. */
	private boolean formattedAnswer;
	
	/** The id. */
	private String id;
	
	/** The items. */
	private int items;
	
	/** The latlist. */
	private List<Latlist> latlist = new ArrayList<Latlist>();
	
	/** The passthru. */
	private String passthru;
	
	/** The pipelineid. */
	private String pipelineid;
	
	/** The qclasslist. */
	private List<QClassList> qclasslist = new ArrayList<QClassList>();
	
	/** The question text. */
	private String questionText;
	
	/** The status. */
	private String status;
	
	/** The synonym list. */
	private List<SynonymList> synonymList = new ArrayList<SynonymList>();

	/**
	 * Gets the answers.
	 * 
	 * 
	 * @return The answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Gets the category of the question that was submitted with the question.
	 * When no category was submitted with the question, an empty
	 * category element is returned in the response.
	 * 
	 * @return the category of the question
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Gets the error notifications.
	 * 
	 * 
	 * @return The errorNotifications
	 */
	public List<Object> getErrorNotifications() {
		return errorNotifications;
	}

	/**
	 * Gets the evidencelist.
	 * 
	 * 
	 * @return The evidencelist
	 */
	public List<Evidence> getEvidencelist() {
		return evidencelist;
	}

	/**
	 * Gets the evidence request.
	 * 
	 * 
	 * @return The evidenceRequest
	 */
	public EvidenceRequest getEvidenceRequest() {
		return evidenceRequest;
	}

	/**
	 * Gets the container for a list of focus elements that are determined
	 * by the pipeline for the final answer.
	 * 
	 * @return The focus list
	 */
	public List<Focus> getFocuslist() {
		return focuslist;
	}

	/**
	 * Gets an integer that is assigned by the service to identify this question
	 * and its answers.
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the items.
	 * 
	 * 
	 * @return The items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * Gets the latlist.
	 * 
	 * 
	 * @return The latlist
	 */
	public List<Latlist> getLatlist() {
		return latlist;
	}

	/**
	 * Gets the passthru.
	 * 
	 * 
	 * @return The passthru
	 */
	public String getPassthru() {
		return passthru;
	}

	/**
	 * Gets the internal ID that is assigned for the final answer CAS.
	 * This element contains the internal CAS ID that is assigned after
	 * the question is answered. You can use this ID to identify the
	 * question with the internal data structures that Watson uses.
	 * 
	 * 
	 * @return The pipelineid
	 */
	public String getPipelineid() {
		return pipelineid;
	}

	/**
	 * Gets the container for a list of question classes that are
	 * determined by the pipeline for the final answer.
	 * 
	 * 
	 * @return The qclasslist
	 */
	public List<QClassList> getQclasslist() {
		return qclasslist;
	}

	/**
	 * Gets the question text.
	 * 
	 * 
	 * @return The questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * Gets the status.
	 * ['Complete' or 'Timeout' or 'Failed'], the response status of the request
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gets the synonym list.
	 * 
	 * 
	 * @return The synonymList
	 */
	public List<SynonymList> getSynonymList() {
		return synonymList;
	}

	/**
	 * Checks if is formatted answer.
	 * 
	 * 
	 * @return The formattedAnswer
	 */
	public boolean isFormattedAnswer() {
		return formattedAnswer;
	}

	/**
	 * Sets the answers.
	 * 
	 * @param answers
	 *            The answers
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Sets the category of the question that was submitted with the question.
	 * When no category was submitted with the question, an empty
	 * category element is returned in the response.
	 * 
	 * @param category
	 *            the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the error notifications.
	 * 
	 * @param errorNotifications
	 *            The errorNotifications
	 */
	public void setErrorNotifications(List<Object> errorNotifications) {
		this.errorNotifications = errorNotifications;
	}

	/**
	 * Sets the evidencelist.
	 * 
	 * @param evidencelist
	 *            The evidencelist
	 */
	public void setEvidencelist(List<Evidence> evidencelist) {
		this.evidencelist = evidencelist;
	}

	/**
	 * Sets the evidence request.
	 * 
	 * @param evidenceRequest
	 *            The evidenceRequest
	 */
	public void setEvidenceRequest(EvidenceRequest evidenceRequest) {
		this.evidenceRequest = evidenceRequest;
	}

	/**
	 * Sets the container for a list of focus elements that are determined
	 * by the pipeline for the final answer.
	 * 
	 * @param focuslist
	 *            The focuslist
	 */
	public void setFocuslist(List<Focus> focuslist) {
		this.focuslist = focuslist;
	}

	/**
	 * Sets the formatted answer.
	 * 
	 * @param formattedAnswer
	 *            The formattedAnswer
	 */
	public void setFormattedAnswer(boolean formattedAnswer) {
		this.formattedAnswer = formattedAnswer;
	}

	/**
	 * Sets an integer that is assigned by the service to identify this question
	 * and its answers.
	 * 
	 * @param id
	 *            the identifier
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the items.
	 * 
	 * @param items
	 *            The items
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * Sets the latlist.
	 * 
	 * @param latlist
	 *            The latlist
	 */
	public void setLatlist(List<Latlist> latlist) {
		this.latlist = latlist;
	}

	/**
	 * Sets the passthru.
	 * 
	 * @param passthru
	 *            The passthru
	 */
	public void setPassthru(String passthru) {
		this.passthru = passthru;
	}

	/**
	 * Sets the internal ID that is assigned for the final answer CAS.
	 * This element contains the internal CAS ID that is assigned after
	 * the question is answered. You can use this ID to identify the
	 * question with the internal data structures that Watson uses.
	 * 
	 * @param pipelineid
	 *            The pipelineid
	 */
	public void setPipelineid(String pipelineid) {
		this.pipelineid = pipelineid;
	}

	/**
	 * Sets the container for a list of question classes that are
	 * determined by the pipeline for the final answer.
	 * 
	 * @param qclasslist
	 *            The question class list
	 */
	public void setQclasslist(List<QClassList> qclasslist) {
		this.qclasslist = qclasslist;
	}

	/**
	 * Sets the question text.
	 * 
	 * @param questionText
	 *            The questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * Sets the status.
	 * ['Complete' or 'Timeout' or 'Failed'], the response status of the request
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Sets the synonym list.
	 * 
	 * @param synonymList
	 *            The synonymList
	 */
	public void setSynonymList(List<SynonymList> synonymList) {
		this.synonymList = synonymList;
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
