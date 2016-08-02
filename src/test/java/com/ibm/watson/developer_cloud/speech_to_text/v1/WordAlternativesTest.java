package com.ibm.watson.developer_cloud.speech_to_text.v1;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import org.junit.Test;

import java.io.File;


/**
 * Created by Focuson on 16-8-2.
 */
public class WordAlternativesTest {

    @Test
    public void test() {
        SpeechToText service = new SpeechToText();
        service.setUsernameAndPassword("b6a4a9a2-a1d9-4e16-9c65-2358d1c436cb", "FKoBpuhK7dGI");

        RecognizeOptions.Builder builder = new RecognizeOptions.Builder();
        builder.contentType("audio/wav").model("zh-CN_NarrowbandModel").continuous(true).wordAlternativesThreshold(0.9).continuous(true);
        RecognizeOptions options = builder.build();
        String[] files = {"/home/dianrong/workdir/wav/convert_to_ibm.wav"};
        for (String file : files) {
            ServiceCall<SpeechResults> results = service.recognize(new File(file), options);
            SpeechResults result = results.execute();

            System.out.println(result.getResults());
        }
    }
}
