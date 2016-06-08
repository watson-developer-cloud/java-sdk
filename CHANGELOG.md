Change Log
==========

## Version 3.0.1

_2016-06-08_

The SDK 3.0.1 introduced support for react( use `rx()`).
Services can now be combined using react in a synchronous or asynchronous
calls and calls more efficiently.

 * New: The `User-Agent` can be customized
 * New: Services added:
   * Visual Recognition v3
   * Conversation v1-experimental
   * Tone Analyzer v3
 * New: `profanity_filter` added to Speech to Text
 * New: Introduce reactive API calls (use `rx()`)
 * New: Added new voices to Speech to Text
 * New: `getVoice()` in Speech to Text and Text to Speech
 * New: `keyword_spotting` in Speech to Text
 * New: AlchemyLanguage now provides `typedRelations()` from Relationship Extraction
 * Fix: Error when running in Android and using `JDNI`
 * Fix: Error when loading `ContentItems` from a file in Personality Insights
 * Fix: Conceptual search in Concept Insights now return the `user_fields`
 * Fix: `Content-Type` in Speech to text when using `flac` files
 * Fix: Warning when calling Alchemy services regarding connections being leaked
 * Fix: Added missing fields in AlchemyDataNews
 * Fix: SSL certificate issues when running in Bluemix and using the IBM JDK


## Version 3.0.0-RC1

_2016-04-22_

The SDK 3.0 is designed around a new API that offers asynchronous callbacks
in addition to synchronous blocking calls. It uses modern Java patterns like
immutability and chained builders.

 * New: Deprecated methods were removed
 * Fix: Websockets issues during a recognition using Speech to Text
 * New: Automatic snapshot deployments to Sonatype
 * New: Chained builders for Speech to text and Tradeoff Analytics


## Version 2.10.0

_2016-04-18_

 * Fix: Switch from String to Integer in AlchemyVision face recognition
 * New: Enumerations for Languages in Language Translation
 * Fix: Error in AlchemyLanguage when language wasn't specified
