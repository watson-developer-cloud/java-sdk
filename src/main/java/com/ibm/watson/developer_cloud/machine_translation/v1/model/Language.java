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
package com.ibm.watson.developer_cloud.machine_translation.v1.model;

import com.ibm.watson.developer_cloud.machine_translation.v1.MachineTranslation;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Language utilized by the {@link MachineTranslation} service.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class Language {

	/** The Constant ARABIC. */
	public static final Language ARABIC = new Language("arar");
	
	/** The Constant ENGLISH. */
	public static final Language ENGLISH = new Language("enus");
	
	/** The Constant PORTUGUESE. */
	public static final Language PORTUGUESE = new Language("ptbr");
	
	/** The Constant FRENCH. */
	public static final Language FRENCH = new Language("frfr");
	
	/** The Constant SIMPLIFIED_CHINESE. */
	public static final Language SIMPLIFIED_CHINESE = new Language("zhcn");
	
	/** The Constant SPANISH. */
	public static final Language SPANISH = new Language("eses");


	/** The id. */
	private final String id;

	/**
	 * Instantiates a new language.
	 * 
	 * @param id
	 *            the identifier
	 */
	public Language(final String id) {
		this.id = id;
	}

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public String getId() {
		return id;
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