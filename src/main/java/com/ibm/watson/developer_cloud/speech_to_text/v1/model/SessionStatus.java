package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * SessionStatus Status used by {@link SpeechToText}.
 */
public class SessionStatus extends GenericModel {

	/** The state. */
	private String state;

	/** The model. */
	private String model;

	/** The recognize. */
	private String recognize;

	/** The observe result. */
	@SerializedName("observe_result")
	private String observeResult;

	/**
	 * Gets the state.
	 * 
	 * @return The state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            The state
	 */
	public void setState(final String state) {
		this.state = state;
	}

	/**
	 * Gets the model.
	 * 
	 * @return The model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 * 
	 * @param model
	 *            The model
	 */
	public void setModel(final String model) {
		this.model = model;
	}

	/**
	 * Gets the recognize.
	 * 
	 * @return The recognize
	 */
	public String getRecognize() {
		return recognize;
	}

	/**
	 * Sets the recognize.
	 * 
	 * @param recognize
	 *            The recognize
	 */
	public void setRecognize(final String recognize) {
		this.recognize = recognize;
	}

	/**
	 * Gets the observe result.
	 * 
	 * @return The observeResult
	 */
	public String getObserveResult() {
		return observeResult;
	}

	/**
	 * Sets the observe result.
	 * 
	 * @param observeResult
	 *            The observe result
	 */
	public void setObserveResult(final String observeResult) {
		this.observeResult = observeResult;
	}

}
