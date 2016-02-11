/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Utility class to test the Watson Services.
 * 
 */
public abstract class WatsonServiceTest {

  private static final Logger log = Logger.getLogger(WatsonServiceTest.class.getName());

  /**
   * Instantiates a new watson service test.
   */
  public WatsonServiceTest() {
    if (prop == null)
      loadProperties();
    setupLogging();
  }

  protected Map<String, String> getDefaultHeaders() {
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(HttpHeaders.X_WATSON_LEARNING_OPT_OUT, String.valueOf(true));
    return headers;
  }

  /**
   * The Class EmptyPropertyException.
   */
  private class EmptyPropertyException extends IllegalStateException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new empty property exception.
     * 
     * @param property the property
     */
    EmptyPropertyException(String property) {
      super("Property " + property + " is empty. It's probably unset.");
    }
  }

  /**
   * The Class MissingPropertyException.
   */
  private class MissingPropertyException extends IllegalStateException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new missing property exception.
     * 
     * @param property the property
     */
    MissingPropertyException(String property) {
      super("A property expected to exist does not exist: " + property);
    }
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
  protected static Properties prop = null;

  /**
   * Gets the existing property.
   * 
   * @param property the property
   * @return the existing property
   */
  public String getExistingProperty(String property) {
    final String value = prop.getProperty(property);
    if (value == null)
      throw new MissingPropertyException(property);
    return value;
  }

  /**
   * Gets the existing property if exists, otherwise it returns the defaultValue.
   *
   * @param property the property
   * @param defaultValue the default value
   * @return the existing property
   */
  public String getExistingProperty(String property, String defaultValue) {
    try {
      return getExistingProperty(property);
    } catch (MissingPropertyException me) {
      return defaultValue;
    }
  }

  /**
   * Gets the valid property.
   * 
   * @param property the property
   * @return the valid property
   */
  public String getValidProperty(String property) {
    final String value = getExistingProperty(property);
    if ("".equals(value))
      throw new EmptyPropertyException(property);
    return value;
  }

  private void loadProperties() {
    prop = new Properties();
    final String filename = "config.properties";
    final InputStream input =
        WatsonServiceTest.class.getClassLoader().getResourceAsStream(filename);
    if (input == null)
      throw new RuntimeException(filename + " was not found.");

    // load a properties file from class path, inside static method
    try {
      prop.load(input);
    } catch (IOException e) {
      log.log(Level.SEVERE, "Error loading the config.properties");
    }

  }

  /**
   * Setup logging.
   */
  private void setupLogging() {
    // set logging level
    ch.qos.logback.classic.Logger root =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    root.setLevel(ch.qos.logback.classic.Level.OFF);
  }

  /**
   * Write input stream to file.
   * 
   * @param inputStream the input stream
   * @param audio the audio
   */
  public static void writeInputStreamToFile(InputStream inputStream, File audio) {
    OutputStream outStream = null;
    try {
      outStream = new FileOutputStream(audio);

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
    return GsonSingleton.getGson().fromJson(jsonString, returnType);
  }

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  public void setUp() throws Exception {}

}
