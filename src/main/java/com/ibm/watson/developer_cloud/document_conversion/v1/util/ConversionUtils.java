package com.ibm.watson.developer_cloud.document_conversion.v1.util;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.util.MediaType;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Util for DocumentConversion
 *
 * @see DocumentConversion
 */
public class ConversionUtils {
    /**
     * Returns the media type for a given file
     *
     * @param file the file object for which media type needs to be provided
     * @return Internet media type for the file
     */
    public static String getMediaTypeFromFile(final File file) {
        if (file != null) {
            String fileName = file.getName();
            String[] supportedExtensions = {".htm", ".html", ".dot", ".doc", ".docx", ".xml", ".xhtml", ".pdf"};
            String[] supportedMediaTypes = {MediaType.TEXT_HTML, MediaType.TEXT_HTML,
                    MediaType.APPLICATION_MS_WORD, MediaType.APPLICATION_MS_WORD,
                    MediaType.APPLICATION_MS_WORD_DOCX, MediaType.APPLICATION_XHTML_XML,
                    MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_PDF};

            for (int i = 0; i < supportedMediaTypes.length; i++) {
                if (fileName.endsWith(supportedExtensions[i])) {
                    return supportedMediaTypes[i];
                }
            }
        }
        return null;
    }

    /**
     * Converts the date to ISO 8601 format
     *
     * @param date the date to be converted to DateTime
     * @return the date time string for a given date
     */
    public static String convertToISO(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String dtAsISO = df.format(date);
        return dtAsISO;
    }
}
