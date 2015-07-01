package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * SessionStatus Status used by {@link SpeechToText}.
 */
public class SessionStatus {

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
	 * With state.
	 * 
	 * @param state
	 *            the state
	 * @return the session
	 */
	public SessionStatus withState(final String state) {
		this.state = state;
		return this;
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
	 * With model.
	 * 
	 * @param model
	 *            the model
	 * @return the session
	 */
	public SessionStatus withModel(final String model) {
		this.model = model;
		return this;
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
	 * With recognize.
	 * 
	 * @param recognize
	 *            the recognize
	 * @return the session
	 */
	public SessionStatus withRecognize(final String recognize) {
		this.recognize = recognize;
		return this;
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

	/**
	 * With observe result.
	 * 
	 * @param observeResult
	 *            the observe result
	 * @return the session status
	 */
	public SessionStatus withObserveResult(final String observeResult) {
		this.observeResult = observeResult;
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
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}
