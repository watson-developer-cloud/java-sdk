# Android SDK

Android client library to assist with using the [Watson Developer Cloud][wdc] services, a collection of REST
APIs and SDKs that use cognitive computing to solve complex problems.

## Installation

#### Gradle

```gradle
'com.ibm.watson.developer_cloud:android-sdk:0.2.0'
```

#### AAR

Download the `aar` with dependencies from the Releases page.

## Examples
This SDK is built for use with the [java-sdk][java-sdk].
The examples below are specific for Android as they use the Microphone and Speaker; for actual services refer to the [java-sdk][java-sdk].

More examples [here](./example).

### Microphone Input Stream
Convenience function for creating an `InputStream` from device microphone. You can record raw PCM data or data encoded using the ogg codec.

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

## StreamPlayer
Provides the ability to directly play an InputStream
```java
StreamPlayer player = new StreamPlayer();
player.playStream(yourInputStream);
```

## CameraHelper
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

## GalleryHelper
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

Use [Gradle][] (version 2.x) to build and test the project you can use

Gradle:

  ```sh
  $ cd android-sdk
  $ gradle test # run tests
  ```

[wdc]: http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/
[java-sdk]: https://github.com/watson-developer-cloud/java-sdk
[bluemix]: https://console.ng.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[releases]: https://github.com/watson-developer-cloud/android-sdk/releases
[wiki]: https://github.com/watson-developer-cloud/android-sdk/wiki
