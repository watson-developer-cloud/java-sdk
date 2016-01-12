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

  /** The WAVE header byte size. (value is 44) */
  private static final int WAVE_HEADER_BYTE_SIZE = 44;

  /**
   * Adds the data size to the header(bytes 4-8) of the WAVE(.wav) input stream.<br>
   * It needs to be read in order to calculate the size.
   * 
   * @param is the input stream
   * @return A new input stream that includes the data header in the header
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static InputStream addDataSizeToInputStream(InputStream is) throws IOException {
    byte[] audioBytes = toByteArray(is);
    int filesize = audioBytes.length - 8;
    audioBytes[4] = (byte) (filesize);
    audioBytes[5] = (byte) (filesize >>> 8);
    audioBytes[6] = (byte) (filesize >>> 16);
    audioBytes[7] = (byte) (filesize >>> 24);

    int datasize = filesize + 8 - WAVE_HEADER_BYTE_SIZE;
    audioBytes[40] = (byte) (datasize);
    audioBytes[41] = (byte) (datasize >>> 8);
    audioBytes[42] = (byte) (datasize >>> 16);
    audioBytes[43] = (byte) (datasize >>> 24);


    return new ByteArrayInputStream(audioBytes);
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
