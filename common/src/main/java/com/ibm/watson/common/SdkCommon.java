package com.ibm.watson.common;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.util.RequestUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SdkCommon {
  private static final Logger LOG = Logger.getLogger(SdkCommon.class.getName());
  private static String userAgent;

  private SdkCommon() { }

  private static String loadSdkVersion() {
    ClassLoader classLoader = SdkCommon.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("java-sdk-version.properties");
    Properties properties = new Properties();

    try {
      properties.load(inputStream);
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Could not load java-sdk-version.properties", e);
    }

    return properties.getProperty("version", "unknown-version");
  }

  private static String getUserAgent() {
    if (userAgent == null) {
      userAgent = "watson-apis-java-sdk/" + loadSdkVersion() + "; " + RequestUtils.getUserAgent();
    }
    return userAgent;
  }

  public static Map<String, String> getDefaultHeaders(String serviceName, String serviceVersion, String operationId) {
    Map<String, String> headers = new HashMap<>();

    String sdkAnalyticsHeaderValue = String.format(
        "service_name=%s;service_version=%s;operation_id=%s",
        serviceName,
        serviceVersion,
        operationId
    );

    headers.put(WatsonHttpHeaders.X_IBMCLOUD_SDK_ANALYTICS, sdkAnalyticsHeaderValue);
    headers.put(HttpHeaders.USER_AGENT, getUserAgent());
    return headers;
  }
}
