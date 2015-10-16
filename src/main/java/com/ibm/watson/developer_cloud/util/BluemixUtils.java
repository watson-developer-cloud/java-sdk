package com.ibm.watson.developer_cloud.util;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class BluemixUtils {

	private static final String ALCHEMY_API = "alchemy_api";
	private static final String APIKEY = "apikey";
	private static final String CREDENTIALS = "credentials";
	private static final Logger log = Logger.getLogger(BluemixUtils.class.getName());
	private static final String PASSWORD = "password";
	private static final String PLAN = "plan";
	public static final String PLAN_EXPERIMENTAL = "experimental";

	public static final String PLAN_FREE = "free";
	public static final String PLAN_STANDARD = "standard";
	private static String services;

	private static final String USERNAME = "username";

	/**
	 * Encode base64.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	private static String encodeBase64(String username, String password) {
		String auth = username + ":" + password;
		return new String(Base64.encodeBase64(auth.getBytes()));
	}

	/**
	 * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists.
	 * 
	 * @param serviceName
	 *            the service name
	 * @return the API key or null if the service cannot be found.
	 */
	public static String getAPIKey(String serviceName) {
		return getAPIKey(serviceName, null);
	}

	/**
	 * Returns the apiKey from the VCAP_SERVICES or null if doesn't exists.
	 * If plan is specified, then only credentials for the given plan will be returned.
	 * 
	 * @param serviceName
	 *            the service name
	 * @param plan
	 *            the service plan: standard, free or experimental
	 * @return the API key
	 */
	public static String getAPIKey(String serviceName, String plan) {
		if (serviceName == null || serviceName.isEmpty())
			return null;

		JsonObject services = getVCAPServices();
		if (services == null)
			return null;

		for (Entry<String, JsonElement> entry : services.entrySet()) {
			String key = entry.getKey();
			if (key.startsWith(serviceName)) {
				JsonArray servInstances = services.getAsJsonArray(key);
				for (JsonElement instance : servInstances) {
					JsonObject service = instance.getAsJsonObject();
					String instancePlan = service.get(PLAN).getAsString();
					if (plan == null || plan.equalsIgnoreCase(instancePlan)) {
						JsonObject credentials = instance.getAsJsonObject().getAsJsonObject(CREDENTIALS);
						if (serviceName.equalsIgnoreCase(ALCHEMY_API)) {
							return credentials.get(APIKEY).getAsString();
						} else {
							String username = credentials.get(USERNAME).getAsString();
							String password = credentials.get(PASSWORD).getAsString();
							return encodeBase64(username, password);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the <b>VCAP_SERVICES</b> environment variable and return it as a
	 * {@link JsonObject}.
	 * 
	 * @return the VCAP_SERVICES as a {@link JsonObject}.
	 */
	private static JsonObject getVCAPServices() {
		String envServices = services != null ? services : System.getenv("VCAP_SERVICES");
		if (envServices == null)
			return null;

		JsonObject vcapServices = null;

		try {
			JsonParser parser = new JsonParser();
			vcapServices = (JsonObject) parser.parse(envServices);
		} catch (JsonSyntaxException e) {
			log.log(Level.INFO, "Error parsing VCAP_SERVICES", e);
		}
		return vcapServices;
	}

	/**
	 * Sets the VCAP_SERVICES variable. This is utility variable for testing
	 * 
	 * @param services
	 *            the VCAP_SERVICES
	 */
	public static void setServices(String services) {
		BluemixUtils.services = services;
	}
}
