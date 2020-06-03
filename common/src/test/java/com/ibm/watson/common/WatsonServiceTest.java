/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.common;

import static org.junit.Assert.fail;

import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/** Utility class to test the Watson Services. */
public abstract class WatsonServiceTest {

  private static final String DEFAULT_PROPERTIES = "config.properties";
  private static final String LOCAL_PROPERTIES = ".config.properties";

  private static final Logger LOG = Logger.getLogger(WatsonServiceTest.class.getName());

  /** The Constant CONTENT_TYPE. */
  protected static final String CONTENT_TYPE = "Content-Type";

  /** Instantiates a new watson service test. */
  public WatsonServiceTest() {
    if (properties == null) {
      loadProperties();
    }
    setupLogging();
  }

  /**
   * Gets the default test headers.
   *
   * @return the default headers
   */
  protected Map<String, String> getDefaultHeaders() {
    Map<String, String> headers = new HashMap<>();
    headers.put(WatsonHttpHeaders.X_WATSON_LEARNING_OPT_OUT, "1");
    headers.put(WatsonHttpHeaders.X_WATSON_TEST, "1");
    return headers;
  }

  /**
   * Gets the string from input stream.
   *
   * @param is the input stream
   * @return the string from input stream
   */
  public static String getStringFromInputStream(InputStream is) {
    BufferedReader br = null;
    final StringBuilder sb = new StringBuilder();

    String line;
    try {

      br = new BufferedReader(new InputStreamReader(is));
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }

    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString();
  }

  /** The prop. */
  protected static Properties properties = null;

  /**
   * Gets the valid property.
   *
   * @param property the property
   * @return the valid property
   */
  public String getProperty(String property) {
    return properties.getProperty(property);
  }

  private void loadProperties() {
    properties = new Properties();

    InputStream input =
        Thread.currentThread().getContextClassLoader().getResourceAsStream(LOCAL_PROPERTIES);
    if (input == null) {
      input =
          Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PROPERTIES);
    } else {
      LOG.info("Using " + LOCAL_PROPERTIES);
    }
    if (input == null) {
      LOG.warning(DEFAULT_PROPERTIES + " was not found.");
      return;
    }
    // load a properties file from class path, inside static method
    try {
      properties.load(input);
    } catch (IOException e) {
      LOG.log(Level.SEVERE, "Error loading the config.properties");
    }
  }

  /** Setup logging. */
  private void setupLogging() {
    ch.qos.logback.classic.Logger root =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    root.setLevel(ch.qos.logback.classic.Level.OFF);
    try {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      InputStream configFile = classLoader.getResourceAsStream("logging.properties");
      LogManager.getLogManager().readConfiguration(configFile);
    } catch (IOException ex) {
      System.out.println("WARNING: Could not open configuration file");
      System.out.println("WARNING: Logging not configured (console output only)");
    }
  }

  /**
   * Write input stream to file.
   *
   * @param inputStream the input stream
   * @param file the file
   */
  public static void writeInputStreamToFile(InputStream inputStream, File file) {
    OutputStream outStream = null;
    try {
      outStream = new FileOutputStream(file);

      byte[] buffer = new byte[8 * 1024];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }
    } catch (Exception e) {
      fail();
    } finally {
      try {
        inputStream.close();
        outStream.close();
      } catch (Exception e) {
        fail();
      }
    }
  }

  /**
   * Loads fixture.
   *
   * @param <T> the return type
   * @param filename the file name
   * @param returnType the return type
   * @return the t
   * @throws FileNotFoundException the file not found exception
   */
  public static <T> T loadFixture(String filename, Class<T> returnType)
      throws FileNotFoundException {
    String jsonString = getStringFromInputStream(new FileInputStream(filename));
    return GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(jsonString, returnType);
  }

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  public void setUp() throws Exception {}

  /** Fuzzy date checking. */
  private long tolerance = 5000; // 5 secs in ms

  /**
   * return `true` if ldate before rdate within tolerance.
   *
   * @param ldate the ldate
   * @param rdate the rdate
   * @return true, if successful
   */
  public boolean fuzzyBefore(Date ldate, Date rdate) {
    return (ldate.getTime() - rdate.getTime()) < tolerance;
  }

  /**
   * return `true` if ldate after rdate within tolerance.
   *
   * @param ldate the ldate
   * @param rdate the rdate
   * @return true, if successful
   */
  public boolean fuzzyAfter(Date ldate, Date rdate) {
    return (rdate.getTime() - ldate.getTime()) < tolerance;
  }
}
