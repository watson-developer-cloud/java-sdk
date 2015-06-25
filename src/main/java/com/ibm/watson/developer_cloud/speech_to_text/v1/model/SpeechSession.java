package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Speech session used by {@link SpeechToText}
 */
public class SpeechSession {

	/** The cookie session. */
	private String cookieSession;
	
	/** The new session uri. */
	@SerializedName("new_session_uri")
	private String newSessionUri;

	/** The observe result. */
	@SerializedName("observe_result")
	private String observeResult;
	
	/** The recognize. */
	private String recognize;
	
	/** The recognize ws. */
	private String recognizeWS;
	
	/** The session id. */
	@SerializedName("session_id")
	private String sessionId;

	/**
	 * Gets the cookie session.
	 *
	 * @return the cookie session
	 */
	public String getCookieSession() {
		return cookieSession;
	}

	/**
	 * Gets the new session uri.
	 *
	 * @return The newSessionUri
	 */
	public String getNewSessionUri() {
		return newSessionUri;
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
	 * Gets the recognize.
	 *
	 * @return The recognize
	 */
	public String getRecognize() {
		return recognize;
	}

	/**
	 * Gets the recognize ws.
	 *
	 * @return The recognizeWS
	 */
	public String getRecognizeWS() {
		return recognizeWS;
	}

	/**
	 * Gets the session id.
	 *
	 * @return The sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the cookie session.
	 *
	 * @param cookieSession the new cookie session
	 */
	public void setCookieSession(final String cookieSession) {
		this.cookieSession = cookieSession;
	}

	/**
	 * Sets the new session uri.
	 *
	 * @param newSessionUri            The new_session_uri
	 */
	public void setNewSessionUri(final String newSessionUri) {
		this.newSessionUri = newSessionUri;
	}

	/**
	 * Sets the observe result.
	 *
	 * @param observeResult            The observe_result
	 */
	public void setObserveResult(final String observeResult) {
		this.observeResult = observeResult;
	}

	/**
	 * Sets the recognize.
	 *
	 * @param recognize            The recognize
	 */
	public void setRecognize(final String recognize) {
		this.recognize = recognize;
	}

	/**
	 * Sets the recognize ws.
	 *
	 * @param recognizeWS            The recognizeWS
	 */
	public void setRecognizeWS(final String recognizeWS) {
		this.recognizeWS = recognizeWS;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId            The session_id
	 */
	public void setSessionId(final String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * With new session uri.
	 *
	 * @param newSessionUri the new session uri
	 * @return the speech session
	 */
	public SpeechSession withNewSessionUri(final String newSessionUri) {
		this.newSessionUri = newSessionUri;
		return this;
	}

	/**
	 * With observe result.
	 *
	 * @param observeResult the observe result
	 * @return the speech session
	 */
	public SpeechSession withObserveResult(final String observeResult) {
		this.observeResult = observeResult;
		return this;
	}

	/**
	 * With recognize.
	 *
	 * @param recognize the recognize
	 * @return the speech session
	 */
	public SpeechSession withRecognize(final String recognize) {
		this.recognize = recognize;
		return this;
	}

	/**
	 * With recognize ws.
	 *
	 * @param recognizeWS the recognize ws
	 * @return the speech session
	 */
	public SpeechSession withRecognizeWS(final String recognizeWS) {
		this.recognizeWS = recognizeWS;
		return this;
	}

	/**
	 * With session id.
	 *
	 * @param sessionId the session id
	 * @return the speech session
	 */
	public SpeechSession withSessionId(final String sessionId) {
		this.sessionId = sessionId;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " "
				+ new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}