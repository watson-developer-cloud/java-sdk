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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.junit.Test;

import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util.ZipUtils;

/**
 * The Class ZipUtilsTest.
 */
public class ZipUtilsTest {
  private static final String CONFIG_PATH = "src/test/resources/retrieve_and_rank/config_dir";
  private static final String CONFIG_NAME = "config_whatever";

  /**
   * Creates_config_zip.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void createsConfigZip() throws IOException {
    final Set<String> configs = new HashSet<String>();
    configs.add("schema.xml");
    configs.add("solrconfig.xml");
    configs.add("words" + File.separator + "stopwords.txt");


    final File configZip = ZipUtils.buildConfigZip(CONFIG_NAME, new File(CONFIG_PATH));
    try {
      final Map<String, String> fileMap = expandZip(configZip);
      assertEquals(configs, fileMap.keySet());

      for (final String config : configs) {
        final String fileString =
            ConversionUtils.writeInputStreamToString(new FileInputStream(CONFIG_PATH + "/" + config));
        assertEquals(fileMap.get(config), fileString);
      }
    } finally {
      configZip.delete();
    }
  }

  private Map<String, String> expandZip(File zipFile) {
    final Map<String, String> fileMap = new HashMap<String, String>();
    try {
      final ZipFile zip = new ZipFile(zipFile);
      final Enumeration<? extends ZipEntry> entries = zip.entries();
      while (entries.hasMoreElements()) {
        final ZipEntry entry = entries.nextElement();
        final InputStream input = zip.getInputStream(entry);
        fileMap.put(entry.getName(), ConversionUtils.writeInputStreamToString(input));
      }
      zip.close();
    } catch (final IOException e) {
      throw new RuntimeException(String.format(Locale.ROOT, "Error expanding config [%s]: ", zipFile.getName()), e);
    }

    return fileMap;
  }
}
