# IBM Watson Developer Cloud Android SDK [![Build Status](https://travis-ci.org/watson-developer-cloud/android-sdk.svg?branch=master)](https://travis-ci.org/watson-developer-cloud/android-sdk)

Android client library to assist with using the [Watson Developer Cloud][wdc] services, a collection of REST
APIs and SDKs that use cognitive computing to solve complex problems.


## Table of Contents
  * [Installation](#installation)
    * [Gradle](#gradle)
  * [Usage](#usage)
  * [Getting the Service Credentials](#getting-the-service-credentials)
  * [Questions](#questions)
  * [Examples](#examples)
  * [Testing](#testing)
  * [License](#license)
  * [Contributing](#contributing)

## Installation

##### Gradle

```gradle
'com.ibm.watson.developer_cloud:android-sdk:0.2.0'
```

##### AAR

Download the aar with dependencies [here][aar].

-----
Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/android-sdk/tree/master/example).

## Usage

The examples below assume that you already have service credentials. If not,
you will have to create a service in [Bluemix][bluemix].

## Getting the Service Credentials
You will need the `username` and `password` (`api_key` for AlchemyAPI) credentials for each service. Service credentials are different from your Bluemix account username and password.

To get your service credentials, follow these steps:
 1. Log in to Bluemix at https://bluemix.net.

 1. Create an instance of the service:
     1. In the Bluemix **Catalog**, select the service you want to use.
     1. Under **Add Service**, type a unique name for the service instance in the Service name field. For example, type `my-service-name`. Leave the default values for the other options.
     1. Click **Create**.

 1. Copy your credentials:
     1. On the left side of the page, click **Service Credentials** to view your service credentials.
     1. Copy `username` and `password`(`api_key` for AlchemyAPI).


## Questions

If you are having difficulties using the APIs or have a question about the IBM
Watson Services, please ask a question on
[dW Answers](https://developer.ibm.com/answers/questions/ask/?topics=watson)
or [Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-watson).

You can also check out the [wiki][wiki] for some additional information.

## Examples
This SDK is built for use with the [java-sdk][java-sdk].
The examples below are specific for Android as they use the Microphone and Speaker; for actual services refer to the [java-sdk][java-sdk].

#### Microphone Input Stream
Convience function for creating an `InputStream` from device microphone. You can record raw PCM data or data encoded using the ogg codec.

```java
// record PCM data
InputStream myInputStream = new MicrophoneInputStream();

// record PCM data and encode it with the ogg codec
InputStream myOggStream = new MicrophoneInputStream(true);
```

An example using a Watson Developer Cloud service would look like

```java
speechService.recognizeUsingWebSocket(new MicrophoneInputStream(),
getRecognizeOptions(), new BaseRecognizeCallback() {
  @Override
  public void onTranscription(SpeechResults speechResults){
    String text = speechResults.getResults().get(0).getAlternatives().get(0).getTranscript();
    System.out.println(text);
  }

  @Override
  public void onError(Exception e) {
  }

  @Override public void onDisconnected() {
  }

});
```

##StreamPlayer
Provides the ability to directly play an InputStream
```java
StreamPlayer player = new StreamPlayer();
player.playStream(yourInputStream);
```

##CameraHelper
Provides simple camera access within an activity.

```java
CameraHelper cameraHelper = new CameraHelper(this);
cameraHelper.dispatchTakePictureIntent();

@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CameraHelper.REQUEST_IMAGE_CAPTURE) {
      System.out.println(cameraHelper.getFile(resultCode));
    }
  }
```

##GalleryHelper
Like the CameraHelper, but allows for selection of images already on the device.

To open the gallery:
```java
GalleryHelper galleryHelper = new GalleryHelper(this);
galleryHelper.dispatchGalleryIntent();

@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == GalleryHelper.PICK_IMAGE_REQUEST) {
      System.out.println(galleryHelper.getFile(resultCode, data));
    }
  }
```

## Testing

Testing in this SDK is accomplished with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/).

To run the tests, in Android Studio:

Within the example package, right-click the androidTest/java folder and click Run 'All Tests'.

## Build + Test

Use [Gradle][] (version 1.x) to build and test the project you can use

Gradle:

  ```sh
  $ cd android-sdk
  $ gradle test # run tests
  ```

## Open Source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## License

This library is licensed under Apache 2.0. Full license text is
available in [LICENSE](LICENSE).

## Contributing
See [CONTRIBUTING.md](.github/CONTRIBUTING.md).

[personality_insights]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/personality-insights/
[language_identification]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/lidapi/
[machine_translation]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/mtapi/
[document_conversion]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/document-conversion/
[relationship_extraction]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/sireapi/
[language_translation]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/language-translation/
[visual_recognition]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/visual-recognition/
[tradeoff_analytics]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/tradeoff-analytics/
[text_to_speech]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/text-to-speech/
[speech_to_text]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/speech-to-text/
[tone_analyzer]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/tone-analyzer/
[dialog]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/dialog/
[concept_insights]: https://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/concept-insights/
[visual_insights]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/visual-insights/
[retrieve_and_rank]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/retrieve-rank/
[concept_expansion]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/concept-expansion/

[alchemy_language]: http://www.alchemyapi.com/products/alchemylanguage
[sentiment_analysis]: http://www.alchemyapi.com/products/alchemylanguage/sentiment-analysis
[alchemy_vision]: http://www.alchemyapi.com/products/alchemyvision
[alchemy_data_news]: http://www.alchemyapi.com/products/alchemydata-news

[wdc]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/
[java-sdk]: https://github.com/watson-developer-cloud/java-sdk
[bluemix]: https://console.ng.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[releases]: https://github.com/watson-developer-cloud/android-sdk/releases
[wiki]: https://github.com/watson-developer-cloud/android-sdk/wiki

[aar]: https://github.com/watson-developer-cloud/android-sdk/blob/master/releases/download/android-sdk-0.2.1-aar-with-dependencies.aar
