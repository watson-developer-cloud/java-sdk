import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.google.common.base.Stopwatch;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Class SpeechToTextTest.
 */
public class SpeechToTextTest extends WatsonService {

	private static final String AUDIO_FILE_PATH = "src/test/resources/sample1.wav";
	private static final String AUDIO_FORMAT = MediaType.AUDIO_WAV;
	
	private static final String HTTP_ENDPOINT = "https://stream.watsonplatform.net/speech-to-text/api";
	private static final String WSS_ENDPOINT = "wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize";

	// replace this with your service credentials
	private static final String USERNAME = "56419bb4-6372-4720-be87-7befd340f05d";
	private static final String PASSWORD = "CufUhobajsfO";

	/**
	 * Creates the SSL context to be use by the {@link DefaultSSLWebSocketClientFactory}.
	 *
	 * @return the SSL context
	 * @throws RuntimeException if the context can't be initialized
	 */
	private static SSLContext createSSLContext() {
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, null, null);
		} catch (Exception e) {
			throw new RuntimeException("Unable to enable SSL", e);
		}
		return sslContext;
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException,
			InterruptedException, URISyntaxException {
		SpeechToTextTest s2t = new SpeechToTextTest();

		File audio = new File(AUDIO_FILE_PATH);

		// use http
		s2t.transcriptUsingHTTP(audio, AUDIO_FORMAT);

		// use webSockets
		//s2t.transcriptUsingWebSockets(audio, AUDIO_FORMAT);
	}

	/**
	 * Gets the token using the Authorization Service
	 * @return the token
	 * @throws RuntimeException if the token can't be created HTTP response status != 200
	 */
	private String getToken() {
		HttpPost authorizationCall = new HttpPost(HTTP_ENDPOINT + "/v1/token?url=" + HTTP_ENDPOINT);
		String auth = USERNAME + ":" + PASSWORD;
		String apiKey = new String(Base64.encodeBase64(auth.getBytes()));

		authorizationCall.setHeader("Authorization", "Basic " + apiKey);

		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpResponse response = httpclient.execute(authorizationCall);
			String stringResponse = ResponseUtil.getString(response);
			if (response.getStatusLine().getStatusCode() != 200)
				return stringResponse;
			else
				throw new RuntimeException("Error getting the token");
		} catch (Exception e) {
			throw new RuntimeException("Error getting the token");
		}
	}

	/**
	 * Transcript an audio file using the REST API calls.
	 * 
	 * @param audioFile
	 *            the audio file
	 * @param contentType
	 *            the content type: audio/wav or audio/ogg.<br>
	 *            See {@link MediaType}
	 */
	public void transcriptUsingHTTP(File audioFile, String contentType) {
		System.out.println("Transcript using HTTP");

		// create the service and set the username and password
		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword(USERNAME, PASSWORD);
		service.setEndPoint(HTTP_ENDPOINT);

		// 1 create the session
		SpeechSession session = service.createSession(SpeechModel.ES_BROADBAND16K.getName());
		System.out.println("session: " + session.toString());

		// 2 call recognize
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(SpeechToText.AUDIO, audioFile);
		params.put(SpeechToText.CONTENT_TYPE, contentType);
		params.put(SpeechToText.CONTINUOUS, true);
		params.put(SpeechToText.SESSION_ID, session.getSessionId());

		SpeechResults transcript = service.recognize(params);

		// 4 print the transcript
		System.out.println("transcript: " + transcript.toString());

		// 5 delete the created session
		service.deleteSession(session);

	}

	
	/**
	 * Transcript using web sockets.
	 *
	 * @param audioFile the audio file
	 * @param contentType the content type
	 * @throws InterruptedException the interrupted exception
	 * @throws URISyntaxException the URI syntax exception
	 */
	public void transcriptUsingWebSockets(File audioFile, String contentType) throws InterruptedException, URISyntaxException {
		System.out.println("Transcript using WebSockets");

		String token = getToken();
		URI uri = new URI(WSS_ENDPOINT + "?watson-token=" + token);

		final WebSocketClient client = new WebSocketClient(uri) {
			@Override
			public void onClose(int code, String reason, boolean remote) {
				System.out.println("closed connection");
			}

			@Override
			public void onError(Exception ex) {
				ex.printStackTrace();
			}

			@Override
			public void onMessage(String message) {
				SpeechResults result = GsonSingleton.getGson().fromJson(message, SpeechResults.class);
				System.out.println(result);
			}

			@Override
			public void onOpen(ServerHandshake handshake) {
				System.out.println("opened connection");
			}

		};

		client.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(createSSLContext()));

		System.out.println("CONNECTED: " + client.connectBlocking());
		System.out.println("HERE: " + client.getConnection().isOpen());

		JsonObject startMessage = new JsonObject();
		startMessage.addProperty("action", "start");
		startMessage.addProperty("content-type", contentType);
		client.send(startMessage.toString());
		System.out.println("Done");
	}
}