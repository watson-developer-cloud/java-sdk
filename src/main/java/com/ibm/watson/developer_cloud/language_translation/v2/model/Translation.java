package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Translation result used as POJO by the {@link LanguageTranslation}.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Translation extends GenericModel {

	/** The translation. */
	@Expose
	private String translation;

	/**
	 * Gets the translation.
	 * 
	 * @return The translation
	 */
	public String getTranslation() {
		return translation;
	}

	/**
	 * Sets the translation.
	 * 
	 * @param translation
	 *            The translation
	 */
	public void setTranslation(final String translation) {
		this.translation = translation;
	}
}
