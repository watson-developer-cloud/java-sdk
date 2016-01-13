package com.ibm.watson.developer_cloud.text_to_speech.v1.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;


/**
 * Utility class to write the data size header in wave(.wav) files synthesized with the
 * {@link TextToSpeech} service
 */
public class WaveUtils {
  /** The WAVE meta-data header size. (value is 8) */
  private static final int WAVE_HEADER_SIZE = 8;

  /** The WAVE meta-data size position. (value is 4) */
  private static final int WAVE_SIZE_POS = 4;

  /** The WAVE meta-data position in bytes. (value is 74) */
  private static final int WAVE_METADATA_POS = 74;

  /**
   * Re-writes the data size in the header(bytes 4-8) of the WAVE(.wav) input stream.<br>
   * It needs to be read in order to calculate the size.
   * 
   * @param is the input stream
   * @return A new input stream that includes the data header in the header
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static InputStream reWriteWaveHeader(InputStream is) throws IOException {
    byte[] audioBytes = toByteArray(is);
    int filesize = audioBytes.length - WAVE_HEADER_SIZE;

    writeInt(filesize, audioBytes, WAVE_SIZE_POS);
    writeInt(filesize - WAVE_HEADER_SIZE, audioBytes, WAVE_METADATA_POS);

    return new ByteArrayInputStream(audioBytes);
  }

  /**
   * Writes an number into an array using 4 bytes
   * 
   * @param value the number to write
   * @param array the byte array
   * @param offset the offset
   */
  private static void writeInt(int value, byte[] array, int offset) {
    for (int i = 0; i < 4; i++) {
      array[offset + i] = (byte) (value >>> (8 * i));
    }
  }

  /**
   * Converts an {@link InputStream} to byte array
   * 
   * @param is the input stream
   * @return the byte array
   * @throws IOException If the first byte cannot be read for any reason other than end of file, or
   *         if the input stream has been closed, or if some other I/O error occurs.
   */
  public static byte[] toByteArray(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int nRead;
    byte[] data = new byte[16384]; // 4 kb

    while ((nRead = is.read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, nRead);
    }

    buffer.flush();
    return buffer.toByteArray();
  }

}
