/******************************************************************************
 *                                                                            *
 * Copyright (c) 1999-2004 Wimba S.A., All Rights Reserved.                   *
 *                                                                            *
 * COPYRIGHT:                                                                 *
 *      This software is the property of Wimba S.A.                           *
 *      This software is redistributed under the Xiph.org variant of          *
 *      the BSD license.                                                      *
 *      Redistribution and use in source and binary forms, with or without    *
 *      modification, are permitted provided that the following conditions    *
 *      are met:                                                              *
 *      - Redistributions of source code must retain the above copyright      *
 *      notice, this list of conditions and the following disclaimer.         *
 *      - Redistributions in binary form must reproduce the above copyright   *
 *      notice, this list of conditions and the following disclaimer in the   *
 *      documentation and/or other materials provided with the distribution.  *
 *      - Neither the name of Wimba, the Xiph.org Foundation nor the names of *
 *      its contributors may be used to endorse or promote products derived   *
 *      from this software without specific prior written permission.         *
 *                                                                            *
 * WARRANTIES:                                                                *
 *      This software is made available by the authors in the hope            *
 *      that it will be useful, but without any warranty.                     *
 *      Wimba S.A. is not liable for any consequence related to the           *
 *      use of the provided software.                                         *
 *                                                                            *
 * Class: AudioFileWriter.java                                                      *
 *                                                                            *
 * Author: Marc GIMPEL                                                        *
 *                                                                            *
 * Date: 6th January 2004                                                     *
 *                                                                            *
 ******************************************************************************/

/* $Id: AudioFileWriter.java,v 1.2 2004/10/21 16:21:57 mgimpel Exp $ */

package com.ibm.watson.developer_cloud.android.library.audio;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Abstract Class that defines an Audio File Writer.
 * 
 * @author Marc Gimpel, Wimba S.A. (mgimpel@horizonwimba.com)
 * @version $Revision: 1.2 $
 */
public abstract class AudioFileWriter{
    /**
     * Closes the output file.
     * @exception IOException if there was an exception closing the Audio Writer.
     */
    public abstract void close() throws IOException;

    /**
     * Open the output file.
     * @param file - file to open.
     * @exception IOException if there was an exception opening the Audio Writer.
     */
    public abstract void open(File file) throws IOException;

    /**
     * Open the output file.
     * @param filename - file to open.
     * @exception IOException if there was an exception opening the Audio Writer.
     */
    public abstract void open(String filename) throws IOException;

    /**
     * Writes the header pages that start the Ogg Opus file.
     * Prepares file for data to be written.
     * @param comment description to be included in the header.
     * @exception IOException
     */
    public abstract void writeHeader(String comment) throws IOException;

    /**
     * Writes a packet of audio.
     * @param data audio data
     * @param offset the offset from which to start reading the data.
     * @param len the length of data to read.
     * @exception IOException
     */
    public abstract void writePacket(byte[] data, int offset, int len) throws IOException;

    /**
     * Writes an Ogg Page Header to the given byte array.
     * @param buf     the buffer to write to.
     * @param offset  the from which to start writing.
     * @param headerType the header type flag
     *          (0=normal, 2=bos: beginning of stream, 4=eos: end of stream).
     * @param granulepos the absolute granule position.
     * @param streamSerialNumber
     * @param pageCount
     * @param packetCount
     * @param packetSizes
     * @return the amount of data written to the buffer.
     */
    public static int writeOggPageHeader(byte[] buf, int offset, int headerType,
                                         long granulepos, int streamSerialNumber,
                                         int pageCount, int packetCount,
                                         byte[] packetSizes)
    {
        writeString(buf, offset, "OggS");             //  0 -  3: capture_pattern
        buf[offset+4] = 0;                            //       4: stream_structure_version
        buf[offset+5] = (byte) headerType;            //       5: header_type_flag
        writeLong(buf, offset+6, granulepos);         //  6 - 13: absolute granule position
        writeInt(buf, offset+14, streamSerialNumber); // 14 - 17: stream serial number
        writeInt(buf, offset+18, pageCount);          // 18 - 21: page sequence no
        writeInt(buf, offset+22, 0);                  // 22 - 25: page checksum
        buf[offset+26] = (byte) packetCount;          //      26: page_segments
        System.arraycopy(packetSizes, 0,              // 27 -  x: segment_table
                buf, offset + 27, packetCount);
        return packetCount+27;
    }

    /**
     * Builds and returns an Ogg Page Header.
     * @param headerType the header type flag
     *          (0=normal, 2=bos: beginning of stream, 4=eos: end of stream).
     * @param granulepos the absolute granule position.
     * @param streamSerialNumber
     * @param pageCount
     * @param packetCount
     * @param packetSizes
     * @return an Ogg Page Header.
     */
    public static byte[] buildOggPageHeader(int headerType, long granulepos,
                                            int streamSerialNumber, int pageCount,
                                            int packetCount, byte[] packetSizes)
    {
        byte[] data = new byte[packetCount+27];
        writeOggPageHeader(data, 0, headerType, granulepos, streamSerialNumber,
                pageCount, packetCount, packetSizes);
        return data;
    }

    /**
     * Builds a Opus Header.
     *
     * @param sampleRate
     * @return Opus Header data
     */
    public static byte[] buildOpusHeader(int sampleRate) {
        byte[] data = new byte[19];
        writeOpusHeader(data, 0, sampleRate);
        return data;
    }

    /**
     * Write Opus header
     *
     * @param buf
     * @param offset
     * @param sampleRate
     *
     * @link https://tools.ietf.org/html/draft-ietf-codec-oggopus-08#section-5.1
     */
    public static void writeOpusHeader(byte[] buf, int offset, int sampleRate) {
        // Magic Signature
        writeString(buf, offset, "OpusHead");
        buf[offset + 8] = 1;                        // Version, MUST The version number MUST always be '1' for this version of the encapsulation specification.
        buf[offset + 9] = 1;                        // Output Channel Count
        writeShort(buf, offset + 10, 0);            // Pre-skip
        writeInt(buf, offset + 12, sampleRate);     // Input Sample Rate (Hz)
        writeShort(buf, offset + 16, 0);            // Output Gain (Q7.8 in dB), +/- 128 dB
        buf[offset + 18] = 0; // Mapping Family (For channel mapping family 0, this value defaults to C-1 (i.e., 0 for mono and 1 for stereo), and is not coded.)
    }

    /**
     * Writes a Opus Comment to the given byte array.
     *
     * @param buf
     *            the buffer to write to.
     * @param offset
     *            the from which to start writing.
     * @param comment
     *            the comment.
     * @return the amount of data written to the buffer.
     */
    public static void writeOpusComment(byte[] buf, int offset, String comment) {
        // Magic Signature
        writeString(buf, offset, "OpusTags");
        String vendorString = "IBM";
        writeInt(buf, offset + 8, vendorString.length());  // Vendor String Length
        writeString(buf, offset + 12, vendorString);       // Vendor String
        writeInt(buf, offset + 20, 1);                     // User Comment List Length
        writeInt(buf, offset + 24, comment.length());      // User Comment #0 String Length
        writeString(buf, offset + 28, comment);            // User Comment #0 String
    }

    /**
     * Builds and returns a Opus Comment.
     *
     * @param comment
     *            the comment.
     * @return a Opus Comment.
     */
    public static byte[] buildOpusComment(String comment) {
        byte[] data = new byte[28+comment.length()];
        writeOpusComment(data, 0, comment);
        return data;
    }

    /**
     * Writes a Little-endian short.
     * @param out the data output to write to.
     * @param v value to write.
     * @exception IOException
     */
    public static void writeShort(DataOutput out, short v)
            throws IOException
    {
        out.writeByte((0xff & v));
        out.writeByte((0xff & (v >>> 8)));
    }

    /**
     * Writes a Little-endian int.
     * @param out the data output to write to.
     * @param v value to write.
     * @exception IOException
     */
    public static void writeInt(DataOutput out, int v)
            throws IOException
    {
        out.writeByte(0xff & v);
        out.writeByte(0xff & (v >>>  8));
        out.writeByte(0xff & (v >>> 16));
        out.writeByte(0xff & (v >>> 24));
    }

    /**
     * Writes a Little-endian short.
     * @param os - the output stream to write to.
     * @param v - the value to write.
     * @exception IOException
     */
    public static void writeShort(OutputStream os, short v)
            throws IOException
    {
        os.write((0xff & v));
        os.write((0xff & (v >>> 8)));
    }

    /**
     * Writes a Little-endian int.
     * @param os - the output stream to write to.
     * @param v - the value to write.
     * @exception IOException
     */
    public static void writeInt(OutputStream os, int v)
            throws IOException
    {
        os.write(0xff & v);
        os.write(0xff & (v >>> 8));
        os.write(0xff & (v >>> 16));
        os.write(0xff & (v >>> 24));
    }

    /**
     * Writes a Little-endian long.
     * @param os - the output stream to write to.
     * @param v - the value to write.
     * @exception IOException
     */
    public static void writeLong(OutputStream os, long v)
            throws IOException
    {
        os.write((int)(0xff & v));
        os.write((int)(0xff & (v >>>  8)));
        os.write((int)(0xff & (v >>> 16)));
        os.write((int)(0xff & (v >>> 24)));
        os.write((int)(0xff & (v >>> 32)));
        os.write((int)(0xff & (v >>> 40)));
        os.write((int)(0xff & (v >>> 48)));
        os.write((int) (0xff & (v >>> 56)));
    }

    /**
     * Writes a Little-endian short.
     * @param data   the array into which the data should be written.
     * @param offset the offset from which to start writing in the array.
     * @param v      the value to write.
     */
    public static void writeShort(byte[] data, int offset, int v)
    {
        data[offset]   = (byte) (0xff & v);
        data[offset+1] = (byte) (0xff & (v >>>  8));
    }

    /**
     * Writes a Little-endian int.
     * @param data   the array into which the data should be written.
     * @param offset the offset from which to start writing in the array.
     * @param v      the value to write.
     */
    public static void writeInt(byte[] data, int offset, int v)
    {
        data[offset]   = (byte) (0xff & v);
        data[offset+1] = (byte) (0xff & (v >>>  8));
        data[offset+2] = (byte) (0xff & (v >>> 16));
        data[offset+3] = (byte) (0xff & (v >>> 24));
    }

    /**
     * Writes a Little-endian long.
     * @param data   the array into which the data should be written.
     * @param offset the offset from which to start writing in the array.
     * @param v      the value to write.
     */
    public static void writeLong(byte[] data, int offset, long v)
    {
        data[offset]   = (byte) (0xff & v);
        data[offset+1] = (byte) (0xff & (v >>>  8));
        data[offset+2] = (byte) (0xff & (v >>> 16));
        data[offset+3] = (byte) (0xff & (v >>> 24));
        data[offset+4] = (byte) (0xff & (v >>> 32));
        data[offset+5] = (byte) (0xff & (v >>> 40));
        data[offset+6] = (byte) (0xff & (v >>> 48));
        data[offset+7] = (byte) (0xff & (v >>> 56));
    }

    /**
     * Writes a String.
     * @param data   the array into which the data should be written.
     * @param offset the offset from which to start writing in the array.
     * @param v      the value to write.
     */
    public static void writeString(byte[] data, int offset, String v)
    {
        byte[] str = v.getBytes();
        System.arraycopy(str, 0, data, offset, str.length);
    }
}
