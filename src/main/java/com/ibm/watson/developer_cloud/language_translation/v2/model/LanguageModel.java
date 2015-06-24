package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

/**
 * Language Model used by the {@link LanguageTranslation}
 * 
 * @author German Attanasio Ruiz <germanatt@us.ibm.com>
 */
public class LanguageModel {

	/** The model id. */
	@SerializedName("model_id")
	private String modelId;
	
	/** The source. */
	private String source;
	
	/** The target. */
	private String target;
	
	/** The base model id. */
	@SerializedName("base_model_id")
	private String baseModelId;
	
	/** The domain. */
	private String domain;
	
	/** The customizable. */
	private boolean customizable;
	
	/** The default model. */
	@SerializedName("default_model")
	private boolean defaultModel;
	
	/** The owner. */
	private String owner;
	
	/** The status. */
	private String status;
	
	/** The name. */
	private String name;

	/**
	 * Gets the model id.
	 *
	 * @return The modelId
	 */
	public String getModelId() {
		return modelId;
	}

	/**
	 * Sets the model id.
	 *
	 * @param modelId            The model_id
	 */
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	/**
	 * With model id.
	 *
	 * @param modelId the model id
	 * @return the language model set
	 */
	public LanguageModel withModelId(String modelId) {
		this.modelId = modelId;
		return this;
	}

	/**
	 * Gets the source.
	 *
	 * @return The source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source            The source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * With source.
	 *
	 * @param source the source
	 * @return the language model set
	 */
	public LanguageModel withSource(String source) {
		this.source = source;
		return this;
	}

	/**
	 * Gets the target.
	 *
	 * @return The target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Sets the target.
	 *
	 * @param target            The target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * With target.
	 *
	 * @param target the target
	 * @return the language model set
	 */
	public LanguageModel withTarget(String target) {
		this.target = target;
		return this;
	}

	/**
	 * Gets the base model id.
	 *
	 * @return The baseModelId
	 */
	public String getBaseModelId() {
		return baseModelId;
	}

	/**
	 * Sets the base model id.
	 *
	 * @param baseModelId            The base_model_id
	 */
	public void setBaseModelId(String baseModelId) {
		this.baseModelId = baseModelId;
	}

	/**
	 * With base model id.
	 *
	 * @param baseModelId the base model id
	 * @return the language model set
	 */
	public LanguageModel withBaseModelId(String baseModelId) {
		this.baseModelId = baseModelId;
		return this;
	}

	/**
	 * Gets the domain.
	 *
	 * @return The domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Sets the domain.
	 *
	 * @param domain            The domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * With domain.
	 *
	 * @param domain the domain
	 * @return the language model set
	 */
	public LanguageModel withDomain(String domain) {
		this.domain = domain;
		return this;
	}

	/**
	 * Checks if is customizable.
	 *
	 * @return The customizable
	 */
	public boolean isCustomizable() {
		return customizable;
	}

	/**
	 * Sets the customizable.
	 *
	 * @param customizable            The customizable
	 */
	public void setCustomizable(boolean customizable) {
		this.customizable = customizable;
	}

	/**
	 * With customizable.
	 *
	 * @param customizable the customizable
	 * @return the language model set
	 */
	public LanguageModel withCustomizable(boolean customizable) {
		this.customizable = customizable;
		return this;
	}

	/**
	 * Checks if is default model.
	 *
	 * @return The defaultModel
	 */
	public boolean isDefaultModel() {
		return defaultModel;
	}

	/**
	 * Sets the default model.
	 *
	 * @param defaultModel            The default_model
	 */
	public void setDefaultModel(boolean defaultModel) {
		this.defaultModel = defaultModel;
	}

	/**
	 * With default model.
	 *
	 * @param defaultModel the default model
	 * @return the language model set
	 */
	public LanguageModel withDefaultModel(boolean defaultModel) {
		this.defaultModel = defaultModel;
		return this;
	}

	/**
	 * Gets the owner.
	 *
	 * @return The owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner            The owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * With owner.
	 *
	 * @param owner the owner
	 * @return the language model set
	 */
	public LanguageModel withOwner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * Gets the status.
	 *
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * With status.
	 *
	 * @param status the status
	 * @return the language model set
	 */
	public LanguageModel withStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Gets the name.
	 *
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * With name.
	 *
	 * @param name the name
	 * @return the language model set
	 */
	public LanguageModel withName(String name) {
		this.name = name;
		return this;
	}

}
