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

import com.google.gson.GsonBuilder;

public class Voice {

	public static final Voice ES_ENRIQUE = new Voice("VoiceEsEsEnrique", "male", "es-ES");
	public static final Voice EN_MICHAEL = new Voice("VoiceEnUsMichael", "male", "es-US");
	public static final Voice EN_LISA = new Voice("VoiceEnUsLisa", "female", "es-US");
	public static final Voice EN_ALLISON = new Voice("VoiceEnUsAllison", "female", "es-US");

	private String name;
	private String language;
	private String gender;
	private String url;

	/**
	 * Instantiates a new voice.
	 */
	public Voice() {}

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
	public Voice(String name, String gender, String language) {
		this.name = name;
		this.gender = gender;
		this.language = language;
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
	public void setName(String name) {
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
	public void setLanguage(String language) {
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
	public void setGender(String gender) {
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
	public void setUrl(String url) {
		this.url = url;
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
