/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * CredentialUtils retrieves service credentials from the environment.
 */
public final class CredentialUtils {

  /**
   * A util class to easily store service credentials.
   *
   */
  public static class ServiceCredentials {
    private String username;
    private String oldApiKey;
    private String url;
    private String iamApiKey;
    private String iamUrl;
    private String password;

    private ServiceCredentials(String username, String oldApiKey, String url, String iamApiKey, String iamUrl,
                               String password) {
      this.username = username;
      this.password = password;
      this.oldApiKey = oldApiKey;
      this.url = url;
      this.iamApiKey = iamApiKey;
      this.iamUrl = iamUrl;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
      return username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
      return password;
    }

    /**
     * Gets the API used for older service instances.
     *
     * @return the oldApiKey
     */
    public String getOldApiKey() {
      return oldApiKey;
    }

    /**
     * Gets the API URL.
     *
     * @return the url
     */
    public String getUrl() {
      return url;
    }

    /**
     * Gets the IAM API key.
     *
     * @return the iamApiKey
     */
    public String getIamApiKey() {
      return iamApiKey;
    }

    /**
     * Gets the IAM URL.
     *
     * @return the iamUrl
     */
    public String getIamUrl() {
      return iamUrl;
    }
  }

  /** The Constant VCAP_SERVICES. */
  private static final String VCAP_SERVICES = "VCAP_SERVICES";

  /** The Constant APIKEY. */
  private static final String APIKEY = "apikey";

  /** The Constant CREDENTIALS. */
  private static final String CREDENTIALS = "credentials";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(CredentialUtils.class.getName());

  /** The Constant PASSWORD. */
  private static final String PASSWORD = "password";

  /** The Constant PLAN. */
  private static final String PLAN = "plan";

  /** The services. */
  private static String services;

  /** The context. */
  private static Context context;

  /** The Constant USERNAME. */
  private static final String USERNAME = "username";

  /** The Constant URL. */
  private static final String URL = "url";

  /** The Constant IAM_URL. */
  private static final String IAM_URL = "iam_url";

  /** The Constant PLAN_EXPERIMENTAL. */
  public static final String PLAN_EXPERIMENTAL = "experimental";

  /** The Constant PLAN_FREE. */
  public static final String PLAN_FREE = "free";

  /** The Constant PLAN_STANDARD. */
  public static final String PLAN_STANDARD = "standard";

  /** The Constant API_KEY. */
  private static final String API_KEY = "api_key";

  /** The Constant LOOKUP_NAME_EXTENSION_API_KEY. */
  private static final String LOOKUP_NAME_EXTENSION_API_KEY = "/credentials";

  /** The Constant LOOKUP_NAME_EXTENSION_URL. */
  private static final String LOOKUP_NAME_EXTENSION_URL = "/url";

  private CredentialUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Returns true if the supplied value begins or ends with curly brackets or quotation marks.
   *
   * @param credentialValue the credential value to check
   * @return true if the value starts or ends with these characters and is therefore invalid
   */
  public static boolean hasBadStartOrEndChar(String credentialValue) {
    return credentialValue.startsWith("{")
        || credentialValue.startsWith("\"")
        || credentialValue.endsWith("}")
        || credentialValue.endsWith("\"");
  }

  // VCAP-related methods

  /**
   * Calls methods to parse VCAP_SERVICES and retrieve credential values. For some values, if VCAP_SERVICES aren't
   * present, it'll fall back to checking JDNI.
   *
   * @param serviceName the service name
   * @return ServiceCredentials object containing parsed values
   */
  public static ServiceCredentials getCredentialsFromVcap(String serviceName) {
    String username = getVcapValue(serviceName, USERNAME);
    String password = getVcapValue(serviceName, PASSWORD);
    String oldApiKey = getVcapValue(serviceName, API_KEY);
    if (username == null && password == null && oldApiKey == null) {
      oldApiKey = getJdniValue(serviceName, LOOKUP_NAME_EXTENSION_API_KEY);
    }

    String url = getVcapValue(serviceName, URL);
    if (url == null) {
      url = getJdniValue(serviceName, LOOKUP_NAME_EXTENSION_URL);
    }

    String iamApiKey = getVcapValue(serviceName, APIKEY);
    String iamUrl = getVcapValue(serviceName, IAM_URL);

    return new ServiceCredentials(username, password, oldApiKey, url, iamApiKey, iamUrl);
  }

  /**
   * Builds the lookup name to be searched for in JDNI
   * and uses it to call the overloaded JDNI method.
   *
   * @param serviceName Name of the bluemix service
   * @param lookupNameExtension Extension to determine which value should be retrieved through JDNI
   * @return The encoded desired value
   */
  private static String getJdniValue(String serviceName, String lookupNameExtension) {
    return getJdniValue("watson-developer-cloud/" + serviceName + lookupNameExtension);
  }

  /**
   * Attempt to get the Base64-encoded value through JNDI.
   *
   * This method should always return null on Android due to the javax functions being unsupported
   *
   * @param lookupName Key to lookup in JDNI
   * @return The encoded desired value
   */
  private static String getJdniValue(String lookupName) {
    if (!isClassAvailable("javax.naming.Context") || !isClassAvailable("javax.naming.InitialContext")) {
      log.info("JNDI string lookups is not available.");
      return null;
    }

    try {
      if (context == null) {
        context = new InitialContext();
      }
      return (String) context.lookup(lookupName);
    } catch (Exception e) {
      log.fine("JNDI " + lookupName + " not found.");
      return null;
    }
  }

  private static boolean isClassAvailable(String className) {
    try {
      Class.forName(className);
      return true;
    } catch (Throwable e) {
      return false;
    }
  }

  /**
   * Gets the <b>VCAP_SERVICES</b> environment variable and return it as a {@link JsonObject}.
   *
   * @return the VCAP_SERVICES as a {@link JsonObject}.
   */
  private static JsonObject getVcapServices() {
    final String envServices = services != null ? services : System.getenv(VCAP_SERVICES);
    if (envServices == null) {
      return null;
    }

    JsonObject vcapServices = null;

    try {
      final JsonParser parser = new JsonParser();
      vcapServices = (JsonObject) parser.parse(envServices);
    } catch (final JsonSyntaxException e) {
      log.log(Level.INFO, "Error parsing VCAP_SERVICES", e);
    }
    return vcapServices;
  }

  /**
   * A helper method to retrieve the appropriate 'credentials' JSON property value from the VCAP_SERVICES.
   *
   * @param vcapServices JSON object representing the VCAP_SERVICES
   * @param serviceName the name of the service whose credentials are sought
   * @param plan the name of the plan for which the credentials are sought, e.g. 'standard', 'beta' etc, may be null
   * @return the first set of credentials that match the search criteria, service name and plan. May return null
   */
  private static JsonObject getCredentialsObject(JsonObject vcapServices, String serviceName, String plan) {
    for (final Entry<String, JsonElement> entry : vcapServices.entrySet()) {
      final String key = entry.getKey();
      if (key.startsWith(serviceName)) {
        final JsonArray servInstances = vcapServices.getAsJsonArray(key);
        for (final JsonElement instance : servInstances) {
          final JsonObject service = instance.getAsJsonObject();
          final String instancePlan = service.get(PLAN).getAsString();
          if ((plan == null) || plan.equalsIgnoreCase(instancePlan)) {
            return instance.getAsJsonObject().getAsJsonObject(CREDENTIALS);
          }
        }
      }
    }
    return null;
  }

  static String getVcapValue(String serviceName, String key) {
    return getVcapValue(serviceName, key, null);
  }

  /**
   * Returns the value associated with the provided key from the VCAP_SERVICES, or null if it doesn't exist. In the
   * case of the API URL, if VCAP_SERVICES aren't present, this method will also search in JDNI.
   *
   * @param serviceName the service name
   * @param key the key whose value should be returned
   * @param plan the plan name
   * @return the value of the provided key
   */
  static String getVcapValue(String serviceName, String key, String plan) {
    if ((serviceName == null) || serviceName.isEmpty()) {
      return null;
    }

    final JsonObject services = getVcapServices();
    if (services == null) {
      return null;
    }

    JsonObject jsonCredentials = getCredentialsObject(services, serviceName, plan);
    if (jsonCredentials != null) {
      if (jsonCredentials.has(key)) {
        return jsonCredentials.get(key).getAsString();
      }
    }
    return null;
  }

  /**
   * Sets the VCAP_SERVICES variable. This is utility variable for testing
   *
   * @param services the VCAP_SERVICES
   */
  public static void setServices(String services) {
    CredentialUtils.services = services;
  }

  /**
   * Sets the context variable for JDNI. This is a utility method for testing.
   *
   * @param env Configuration options for the context
   */
  public static void setContext(Hashtable<String, String> env) {
    try {
      CredentialUtils.context = new InitialContext(env);
    } catch (Exception e) {
      log.fine("Error setting up JDNI context: " + e.getMessage());
    }
  }
}
