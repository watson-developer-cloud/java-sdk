/**
 * © Copyright IBM Corporation 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.ibm.watson.developer_cloud.android.library.audio.opus;

import com.ibm.watson.developer_cloud.android.library.audio.AudioConsumer;
import com.ibm.watson.developer_cloud.android.library.audio.utils.SpeechConfiguration;
import com.sun.jna.ptr.PointerByReference;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * Ogg Opus Encoder
 */
public class OggOpusEnc extends OpusWriter {
    // Use PROPRIETARY notice if class contains a main() method, otherwise use COPYRIGHT notice.
    public static final String COPYRIGHT_NOTICE = "(c) Copyright IBM Corp. 2015";
    /** Data writer */
    private OpusWriter writer = null;
    /** Opus encoder reference */
    private PointerByReference opusEncoder;

    /**
     * Constructor
     */
    public OggOpusEnc(AudioConsumer ac) throws IOException {
        initEncoder(ac);
    }
    /**
     * For WebSocketClient
     *
     * @throws IOException
     */
    /*public void initEncoderWithUploader(IChunkUploader uploader, Context context) throws IOException{
        writer = new OpusWriter(uploader, context);

        IntBuffer error = IntBuffer.allocate(4);
        this.opusEncoder = JNAOpus.INSTANCE.opus_encoder_create(
                SpeechConfiguration.SAMPLE_RATE,
                SpeechConfiguration.AUDIO_CHANNELS,
                JNAOpus.OPUS_APPLICATION_VOIP,
                error);
    }*/
    public void initEncoder(AudioConsumer ac) throws IOException {
        writer = new OpusWriter(ac);

        IntBuffer error = IntBuffer.allocate(4);
        this.opusEncoder = JNAOpus.INSTANCE.opus_encoder_create(
            SpeechConfiguration.SAMPLE_RATE,
            SpeechConfiguration.AUDIO_CHANNELS,
            JNAOpus.OPUS_APPLICATION_VOIP,
            error);
    }
    /**
     * When the encode begins
     */
    public void onStart() {
        writer.writeHeader("encoder=Lavc56.20.100 libopus");
    }
    /**
     * Encode raw audio data into Opus format then call OpusWriter to write the Ogg packet
     *
     * @param rawAudio
     * @return
     * @throws IOException
     */
    public int encodeAndWrite(byte[] rawAudio) throws IOException {
        int uploadedAudioSize = 0;
        ByteArrayInputStream ios = new ByteArrayInputStream(rawAudio);

        byte[] data = new byte[SpeechConfiguration.FRAME_SIZE*2];
        int bufferSize, read;

        while((read = ios.read(data)) > 0){
            bufferSize = read;
            byte[] pcmBuffer = new byte[read];
            System.arraycopy(data, 0, pcmBuffer, 0, read);

            ShortBuffer shortBuffer = ShortBuffer.allocate(bufferSize);
            for (int i = 0; i < read; i += 2) {
                int b1 = pcmBuffer[i] & 0xff;
                int b2 = pcmBuffer[i+1] << 8;
                shortBuffer.put((short) (b1 | b2));
            }
            shortBuffer.flip();
            ByteBuffer opusBuffer = ByteBuffer.allocate(bufferSize);

            int opus_encoded = JNAOpus.INSTANCE.opus_encode(this.opusEncoder, shortBuffer, SpeechConfiguration.FRAME_SIZE, opusBuffer, bufferSize);

            opusBuffer.position(opus_encoded);
            opusBuffer.flip();

            byte[] opusData = new byte[opusBuffer.remaining()];
            opusBuffer.get(opusData, 0, opusData.length);

            if (opus_encoded > 0) {
                uploadedAudioSize += opusData.length;
                System.out.println("This is where I'd write some data. " + uploadedAudioSize + " to be specific.");
                writer.writePacket(opusData, 0, opusData.length);
            }
        }

        ios.close();

        return uploadedAudioSize;
    }

    /**
     * Close writer
     */
    public void close() {
        try {
            writer.close();
            JNAOpus.INSTANCE.opus_encoder_destroy(this.opusEncoder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
