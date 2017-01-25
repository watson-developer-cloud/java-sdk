/**
 * Copyright IBM Corporation 2016
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

package com.ibm.watson.developer_cloud.android.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
import com.ibm.watson.developer_cloud.android.library.camera.CameraHelper;
import com.ibm.watson.developer_cloud.android.library.camera.GalleryHelper;
import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeDelegate;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class MainActivity extends AppCompatActivity {
  private final String TAG = "MainActivity";

  private RadioGroup targetLanguage;
  private EditText input;
  private ImageButton mic;
  private Button translate;
  private ImageButton play;
  private TextView translatedText;
  private Button gallery;
  private Button camera;
  private ImageView loadedImage;

  private SpeechToText speechService;
  private TextToSpeech textService;
  private LanguageTranslation translationService;
  private Language selectedTargetLanguage = Language.SPANISH;

  private StreamPlayer player = new StreamPlayer();
  private CameraHelper cameraHelper;
  private GalleryHelper galleryHelper;

  private MicrophoneInputStream capture;
  private boolean listening = false;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    cameraHelper = new CameraHelper(this);
    galleryHelper = new GalleryHelper(this);

    speechService = initSpeechToTextService();
    textService = initTextToSpeechService();
    translationService = initLanguageTranslationService();

    targetLanguage = (RadioGroup) findViewById(R.id.target_language);
    input = (EditText) findViewById(R.id.input);
    mic = (ImageButton) findViewById(R.id.mic);
    translate = (Button) findViewById(R.id.translate);
    play = (ImageButton) findViewById(R.id.play);
    translatedText = (TextView) findViewById(R.id.translated_text);
    gallery = (Button) findViewById(R.id.gallery_button);
    camera = (Button) findViewById(R.id.camera_button);
    loadedImage = (ImageView) findViewById(R.id.loaded_image);

    targetLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
          case R.id.spanish:
            selectedTargetLanguage = Language.SPANISH;
            break;
          case R.id.french:
            selectedTargetLanguage = Language.FRENCH;
            break;
          case R.id.italian:
            selectedTargetLanguage = Language.ITALIAN;
            break;
        }
      }
    });

    input.addTextChangedListener(new EmptyTextWatcher() {
      @Override public void onEmpty(boolean empty) {
        if (empty) {
          translate.setEnabled(false);
        } else {
          translate.setEnabled(true);
        }
      }
    });

    mic.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //mic.setEnabled(false);

        if(listening != true) {
          capture = new MicrophoneInputStream(true);
          new Thread(new Runnable() {
            @Override public void run() {
              try {
                speechService.recognizeUsingWebSockets(capture, getRecognizeOptions(), new MicrophoneRecognizeDelegate());
              } catch (Exception e) {
                showError(e);
              }
            }
          }).start();
          listening = true;
        } else {
          try {
            capture.close();
            listening = false;
          } catch (Exception e) {
            e.printStackTrace();
          }

        }
      }
    });

    translate.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        new TranslationTask().execute(input.getText().toString());
      }
    });

    translatedText.addTextChangedListener(new EmptyTextWatcher() {
      @Override public void onEmpty(boolean empty) {
        if (empty) {
          play.setEnabled(false);
        } else {
          play.setEnabled(true);
        }
      }
    });

    play.setEnabled(false);

    play.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        new SynthesisTask().execute(translatedText.getText().toString());
      }
    });

    gallery.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        galleryHelper.dispatchGalleryIntent();
      }
    });

    camera.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        cameraHelper.dispatchTakePictureIntent();
      }
    });
  }


  private void showTranslation(final String translation) {
    runOnUiThread(new Runnable() {
      @Override public void run() {
        translatedText.setText(translation);
      }
    });
  }

  private void showError(final Exception e) {
    runOnUiThread(new Runnable() {
      @Override public void run() {
        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        e.printStackTrace();
      }
    });
  }

  private void showMicText(final String text) {
    runOnUiThread(new Runnable() {
      @Override public void run() {
        input.setText(text);
      }
    });
  }

  private void enableMicButton() {
    runOnUiThread(new Runnable() {
      @Override public void run() {
        mic.setEnabled(true);
      }
    });
  }

  private SpeechToText initSpeechToTextService() {
    SpeechToText service = new SpeechToText();
    String username = getString(R.string.speech_text_username);
    String password = getString(R.string.speech_text_password);
    service.setUsernameAndPassword(username, password);
    service.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
    return service;
  }

  private TextToSpeech initTextToSpeechService() {
    TextToSpeech service = new TextToSpeech();
    String username = getString(R.string.text_speech_username);
    String password = getString(R.string.text_speech_password);
    service.setUsernameAndPassword(username, password);
    return service;
  }

  private LanguageTranslation initLanguageTranslationService() {
    LanguageTranslation service = new LanguageTranslation();
    String username = getString(R.string.language_translation_username);
    String password = getString(R.string.language_translation_password);
    service.setUsernameAndPassword(username, password);
    return service;
  }

  private RecognizeOptions getRecognizeOptions() {
    RecognizeOptions options = new RecognizeOptions();
    options.continuous(true);
    options.contentType(ContentType.OPUS.toString());
    options.model("en-US_BroadbandModel");
    options.interimResults(true);
    options.inactivityTimeout(2000);
    return options;
  }

  private abstract class EmptyTextWatcher implements TextWatcher {
    private boolean isEmpty = true; // assumes text is initially empty

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
      if (s.length() == 0) {
        isEmpty = true;
        onEmpty(true);
      } else if (isEmpty) {
        isEmpty = false;
        onEmpty(false);
      }
    }

    @Override public void afterTextChanged(Editable s) {}

    public abstract void onEmpty(boolean empty);
  }

  private class MicrophoneRecognizeDelegate implements RecognizeDelegate {

    @Override public void onMessage(SpeechResults speechResults) {
      System.out.println(speechResults);
      String text = speechResults.getResults().get(0).getAlternatives().get(0).getTranscript();
      showMicText(text);
    }

    @Override public void onConnected() {

    }

    @Override public void onError(Exception e) {
      showError(e);
      enableMicButton();
    }

    @Override public void onDisconnected() {
      enableMicButton();
    }
  }

  private class TranslationTask extends AsyncTask<String, Void, String> {

    @Override protected String doInBackground(String... params) {
      showTranslation(translationService.translate(params[0], Language.ENGLISH, selectedTargetLanguage).getFirstTranslation());
      return "Did translate";
    }
  }

  private class SynthesisTask extends AsyncTask<String, Void, String> {

    @Override protected String doInBackground(String... params) {
      player.playStream(textService.synthesize(params[0], Voice.EN_LISA));
      return "Did synthesize";
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    switch (requestCode) {
      case CameraHelper.REQUEST_PERMISSION: {
        // permission granted
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          cameraHelper.dispatchTakePictureIntent();
        }
      }
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CameraHelper.REQUEST_IMAGE_CAPTURE) {
      loadedImage.setImageBitmap(cameraHelper.getBitmap(resultCode));
    }

    if (requestCode == GalleryHelper.PICK_IMAGE_REQUEST) {
      loadedImage.setImageBitmap(galleryHelper.getBitmap(resultCode, data));
    }
  }

}
