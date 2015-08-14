package com.ibm.watson.developer_cloud.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Class GsonSingleton.
 */
public class GsonSingleton {

	/** The gson. */
	private static Gson gson;
	
	/**
	 * Gets the gson.
	 *
	 * @return the gson
	 */
	public static Gson getGson() {
		if (gson == null) {
			gson = createGson();
		}
		return gson;
	}

	/**
	 * Creates a {@link com.google.gson.Gson} object that can be use to serialize 
	 * and deserialize Java objects}
	 *
	 * @return the gson
	 */
	private static Gson createGson() {
		return new GsonBuilder()
			.setPrettyPrinting()
			.create();
	};
}
