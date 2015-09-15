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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class Voice.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Voice extends GenericModel {

	/** The Constant ES_ENRIQUE. */
	public static final Voice ES_ENRIQUE = new Voice("es-ES_EnriqueVoice", "male", "es-ES");
	
	/** The Constant ES_LAURA. */
	public static final Voice ES_LAURA = new Voice("es-ES_LauraVoice", "female", "es-US");
	
	/** The Constant ES_SOFIA. */
	public static final Voice ES_SOFIA = new Voice("es-US_SofiaVoice", "female", "es-US");

	/** The Constant EN_MICHAEL. */
	public static final Voice EN_MICHAEL = new Voice("en-US_MichaelVoice", "male", "en-US");
	
	/** The Constant EN_LISA. */
	public static final Voice EN_LISA = new Voice("en-US_LisaVoice", "female", "en-US");
	
	/** The Constant EN_ALLISON. */
	public static final Voice EN_ALLISON = new Voice("en-US_AllisonVoice", "female", "en-US");

	/** The Constant IT_FRANCESCA. */
	public static final Voice IT_FRANCESCA = new Voice("it-IT_FrancescaVoice", "female", "it-IT");
	
	/** The Constant FR_RENEE. */
	public static final Voice FR_RENEE = new Voice("fr-FR_ReneeVoice", "female", "fr-FR");
	
	/** The Constant DE_DIETER. */
	public static final Voice DE_DIETER = new Voice("de-DE_DieterVoice", "male", "de-DE");
	
	/** The Constant DE_GIRGIT. */
	public static final Voice DE_GIRGIT = new Voice("de-DE_BirgitVoice", "female", "de-DE");
	
	/** The Constant GB_KATE. */
	public static final Voice GB_KATE = new Voice("en-GB_KateVoice", "female", "en-GB");

	
	/** The name. */
	private String name;
	
	/** The language. */
	private String language;
	
	/** The gender. */
	private String gender;
	
	/** The url. */
	private String url;
	
	/** The description. */
	private String description;
	/**
	 * Instantiates a new voice.
	 */
	public Voice() {
	}

	/**
	 * Instantiates a new voice.
	 * 
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param language
	 *            the language
	 */
	public Voice(final String name, final String gender, final String language) {
		this.name = name;
		this.gender = gender;
		this.language = language;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(final String language) {
		this.language = language;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(final String url) {
		this.url = url;
	}
}
