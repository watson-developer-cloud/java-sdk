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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Utility class to manage Solr ZIP configuration files.
 */
public final class ZipUtils {
  private static final MessageFormatter MSGS = new MessageFormatter(Messages.bundleName());

  private ZipUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Builds the configuration ZIP file.
   *
   * @param configName the configuration name
   * @param parentDir the parent directory
   * @return the file
   */
  public static File buildConfigZip(final String configName, final File parentDir) {
    if (!parentDir.isDirectory()) {
      throw new RuntimeException(MSGS.format(Messages.CONFIG_NOT_DIR_1, parentDir.toString()));
    }

    final File zipFile = createEmptyZipFile(configName);
    final ZipOutputStream out;
    try {
      out = new ZipOutputStream(new FileOutputStream(zipFile));
    } catch (final FileNotFoundException e) {
      throw new RuntimeException(MSGS.format(Messages.ERROR_ZIPPING_1, parentDir.toString()), e);
    }


    try {
      addFilesToZip(parentDir, out, parentDir);
      return zipFile;
    } catch (final IOException e) {
      throw new RuntimeException(MSGS.format(Messages.ERROR_ZIPPING_1, parentDir.toString()), e);
    } finally {
      try {
        out.close();
      } catch (final IOException e) {
        // do nothing
      }
    }
  }

  /**
   * Creates the empty ZIP file.
   *
   * @param prefix file name prefix
   * @return the file
   */
  public static File createEmptyZipFile(String prefix) {
    try {
      return File.createTempFile(prefix, ".zip");
    } catch (final IOException e) {
      throw new RuntimeException(MSGS.format(Messages.ERROR_CREATING_ZIP_1, prefix + ".zip"), e);
    }
  }

  private static void writeZipEntry(ZipOutputStream out, String name, byte[] data) throws IOException {
    final String cleanedName;

    if ((name == null) || name.isEmpty() || !name.startsWith("/")) {
      cleanedName = name;
    } else {
      cleanedName = name.substring(1);
    }

    final ZipEntry entry = new ZipEntry(cleanedName);
    out.putNextEntry(entry);
    out.write(data, 0, data.length);
    out.closeEntry();
  }

  private static void addFilesToZip(final File currentParentDir, final ZipOutputStream out, final File globalParentDir)
      throws IOException {
    for (final File child : currentParentDir.listFiles()) {
      if (child.isDirectory()) {
        addFilesToZip(child, out, globalParentDir);
      } else if (child.isFile()) {
        writeZipEntry(out, globalParentDir.toURI().relativize(child.toURI()).toString(), readBytes(child));
      }
    }
  }

  private static byte[] readBytes(File file) {
    FileInputStream in = null;
    final byte[] buffer = new byte[(int) file.length()];
    try {
      in = new FileInputStream(file);
      in.read(buffer);
    } catch (final IOException e) {
      MSGS.format(Messages.ERROR_READING_FILE_1, file.toString(), e);
    }
    if (in != null) {
      try {
        in.close();
      } catch (final IOException e) {
        // fail quietly
      }
    }
    return buffer;
  }
}
