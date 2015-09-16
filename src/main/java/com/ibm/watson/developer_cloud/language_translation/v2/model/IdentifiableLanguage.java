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
package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Identifiable language used by the {@link LanguageTranslation} service.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class IdentifiableLanguage extends GenericModel {

	/** The language. */
	private final String language;

	/** The confidence. */
	private final String name;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Instantiates a new identifiable language.
	 * 
	 * @param language
	 *            the language
	 * @param name
	 *            the name
	 */
	public IdentifiableLanguage(final String language, final String name) {
		super();
		this.language = language;
		this.name = name;
	}

	/**
	 * Instantiates a new language.
	 * 
	 * @param language
	 *            the language
	 */
	public IdentifiableLanguage(final String language) {
		this.language = language;
		this.name = null;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
}
