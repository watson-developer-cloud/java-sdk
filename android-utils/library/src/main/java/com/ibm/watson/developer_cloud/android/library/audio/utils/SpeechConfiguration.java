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


package com.ibm.watson.developer_cloud.android.library.audio.utils;

/**
 * Created by mihui on 9/2/15.
 */
public class SpeechConfiguration {

    // PCM format
    public static final String AUDIO_FORMAT_DEFAULT = "audio/l16;rate=16000";
    // OggOpus format
    public static final String AUDIO_FORMAT_OGGOPUS = "audio/ogg;codecs=opus";
    // Audio channels
    public static final int AUDIO_CHANNELS = 1;
    // Frame size
    public static final int FRAME_SIZE = 160;
    // Sample rate
    public static final int SAMPLE_RATE = 16000;
    // Timeout
    public int inactivityTimeout = 600;
    // Data format
    public String audioFormat = AUDIO_FORMAT_DEFAULT;
    // Authentication flag
    public boolean isAuthNeeded = true;
    // SSL flag, this would be detected automatically
    public boolean isSSL = true;
    // Default timeout duration for a connection
    public int connectionTimeout = 30000;
    // Interim results are intermediate hypotheses of a transcription that are likely to change before the service returns the final result. Interim results are useful for real-time transcription, for example, to obtain alternative transcriptions for a dictation application.
    public boolean returnInterimResults = true;
    // An integer value that tells the service to return the n-best alternative hypotheses
    public int maxAlternatives = 1;
    // Reports hypotheses for acoustically similar alternatives for words of the input audio
    public float wordAlternativesThreshold = Float.NaN;
    // Indicates whether multiple final results that represent consecutive phrases separated by long pauses are returned
    public boolean continuous = true;
    // Indicates whether to opt out of data collection for requests sent over the connection
    public boolean learningOptOut = false;

    /**
     * Instantiate default configuration
     */
    public SpeechConfiguration(){}

    /**
     * Constructing configuration by parameters
     *
     * @param audioFormat
     */
    public SpeechConfiguration(String audioFormat){
        this.audioFormat = audioFormat;
    }

    /**
     * Constructing configuration by parameters
     *
     * @param audioFormat
     * @param isAuthNeeded
     */
    public SpeechConfiguration(String audioFormat, boolean isAuthNeeded){
        this.audioFormat = audioFormat;
        this.isAuthNeeded = isAuthNeeded;
    }
}
