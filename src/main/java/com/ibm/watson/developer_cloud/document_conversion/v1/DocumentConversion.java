/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionTarget;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The IBM Watson Document Conversion service converts provided source documents (HTML,
 * Word, PDF) into JSON Answer Units, Normalized HTML, or Normalized Text.
 * 
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/document-conversion.html">
 *      Document Conversion</a>
 */
public class DocumentConversion extends WatsonService {

	/** The Constant CONFIG. */
	private static final String CONFIG = "config";

	/** The Constant CONVERSION_TARGET. */
	private static final String CONVERSION_TARGET = "conversion_target";

	/**
	 * The CONVERT_DOCUMENT_PATH. (value is "/v1/convert_document")
	 **/
	private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";

	/** The Constant FILE. */
	private static final String FILE = "file";

	/** The default URL for the service. */
	private static final String URL = "https://gateway.watsonplatform.net/document-conversion-experimental/api";

	/**
	 * Sets the endpoint url for the service.
	 */
	public DocumentConversion() {
		setEndPoint(URL);
	}

	/**
	 * Converts a document and returns an {@link InputStream}
	 * 
	 * @param document
	 *            The file to convert
	 * @param mediaType
	 *            Internet media type of the file
	 * @param conversionTarget
	 *            The conversion target to use
	 * @return Converted document in the specified format
	 */
	private InputStream convertDocument(final File document, final String mediaType,
			final ConversionTarget conversionTarget) {

		if (document == null || !document.exists())
			throw new IllegalArgumentException("document cannot be null and must exist");

		String type = mediaType != null ? mediaType : ConversionUtils.getMediaTypeFromFile(document);
		if (type == null)
			throw new RuntimeException("mediaType cannot be null or empty");
		else if (!ConversionUtils.isValidMediaType(type))
			throw new IllegalArgumentException("file with the given media type is not supported");

		try {
			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart(FILE, new FileBody(document, type));
			JsonObject configJson = new JsonObject();
			configJson.addProperty(CONVERSION_TARGET, conversionTarget.toString());
			String json = configJson.toString();
			reqEntity.addPart(CONFIG, new StringBody(json, MediaType.APPLICATION_JSON, Charset.forName("UTF-8")));

			HttpRequestBase request = Request.Post(CONVERT_DOCUMENT_PATH).withEntity(reqEntity).build();

			HttpResponse response = execute(request);
			InputStream is = ResponseUtil.getInputStream(response);
			return is;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Converts a document to Answer Units.
	 * 
	 * @param document
	 *            the document
	 * @param mediaType
	 *            the document media type. It will use the file extension if not provided
	 * @return Converted document as {@link Answers}
	 */
	public Answers convertDocumentToAnswer(File document, String mediaType) {
		InputStream is = convertDocument(document, mediaType, ConversionTarget.ANSWER_UNITS);
		String convertedDocument = ConversionUtils.writeInputStreamToString(is);
		return GsonSingleton.getGson().fromJson(convertedDocument, Answers.class);
	}

	/**
	 * Converts a document to Answer Units.
	 * 
	 * @param document
	 *            the document
	 * @param mediaType
	 *            document the document media type. It will use the file extension if not
	 *            provided
	 * @return Converted document as {@link Answers}
	 */
	public String convertDocumentToText(File document, String mediaType) {
		InputStream is = convertDocument(document, mediaType, ConversionTarget.NORMALIZED_TEXT);
		return ConversionUtils.writeInputStreamToString(is);
	}

	/**
	 * Converts a document to Answer Units.
	 * 
	 * @param document
	 *            the document
	 * @param mediaType
	 *            document the document media type. It will use the file extension if not
	 *            provided
	 * @return Converted document as {@link Answers}
	 */
	public String convertDocumentToHTML(File document, String mediaType) {
		InputStream is = convertDocument(document, mediaType, ConversionTarget.NORMALIZED_HTML);
		return ConversionUtils.writeInputStreamToString(is);
	}

}
