Change Log
==========

## Version 3.8.0

_2017-04-24_

* New: Add support for workspaces in Conversation 1b291a5
* New: Update okhttp version to 3.7.0 7912344
* New: Change WAV to WebM in comments in test-to-speech 4535c70
* New: Add support for Customer Care API endpoint for Tone Analyzer 7a5fcfe
* New: Add new audio format to text-to-speech 07a375e
* New: Add new audio format to speech-to-text 1c93196
* Fix: Enable cipher suites 4b51aee
* Fix: Enable all TLS protocols 842383b
* Fix: Use `target` in language translator Fixes #655 999f04c
* Fix: Date deserialization for ISO 8601 dates with Z timezone 6c870dc
* Fix: SerializedName annotation for configuration id and test dd0ec53
* Fix: Fix NLU example 8c33f2b


## Version 3.7.2

_2017-04-07_

  * New: Provide a specific document Id when creating a document			d581c3f
  * New: NLU: Add model for disambiguation and property in EntitiesResults			8acb411
  * New: Add test for disambiguation info			9328c5f
  * Fix: Discovery: create or update a document from an InputStream and optionally spec…  …			ab2f413
  * Fix: Add README.md for Natural Language Understanding			4e53c8f
  * Fix: 👕 Checkstyle	Verified		a95c68d
  * Fix: TTS Synthesize using POST, fixes #635 and #602	Verified		5ae0d24
  * Fix: Language translator, update service name	Verified		37abc86

## Version 3.7.1

_2017-03-31_


 * Fix: Enable all cipher suites		cf58894 74cae1b
 * Fix: `afterEvaluate` source for docs task			0f93ec3
 * Fix: Disable HTML escaping, #532		c6497ed
 * Fix: CheckStyle		d5ccc68 9a7654b 9a7654b
 * Fix: Examples link in README.md 	430f3a6 by @rborer

 * Doc: Exclude tests from javadoc generation 60e80de
 * Doc: Update HTTP logging information #496		85e2424

 * New: Add aggregate Javadocs plugin			b6d1123
 * New: Add tradeoff analytics test case for #306		9f40779
 * New: Adds an HTTPLogging interceptor #496		620d8d9
 * New: Unit tests for Natural Language Understanding 5e89f3a

## Version 3.7.0

_2017-03-19_

 * New: Added Natural Language Understanding
 * Fix: Text-to-Speech failed with combine of special characters, e.g Spanish + ";" bug text-to-speech #602
 * Fix: Alchemy Language - CombinedResults missing Emotion #545


## Version 3.6.0

_2017-03-07_

 * New: Automatic releases
 * Change: Update OkHttp to v3.6.0
 * New: Speech to Text: Add `addCorpus()` method, deprecate `addTextToCustomizationCorpus()` method
 * New: Speech to Text: Add `getCorpus()` method
 * New: Speech to Text: Add sort parameter to `getWords()` method
 * New: Speech to Text: Add `SupportedFeatures` for `SpeechModel` object
 * New: Speech to Text: Add and fix constructors for `Word` object
 * New: Speech to Text: Add `count` to `WordData` object
 * New: Speech to Text: Add `confidence` to `SpeakerLabel` object
 * New: Speech to Text: Add `warnings` to `RecognitionJob` object
 * Fix: Speech to Text: Enable `customization_id` for `recognizeUsingWebSocket()` method
 * Fix: Speech to Text: Fix allowOverwrite parameter of `addTextToCustomizationCorpus()` method
 * Fix: Speech to Text: Fix error field for `WordData` object
 * New: Text to Speech: Add `createCustomVoiceModel()` and `updateCustomVoiceModel()` methods, deprecate `saveCustomVoiceModel()` method
 * New: Text to Speech: Add `addWords()` and `addWord()` methods, deprecate `saveWords()` method
 * New: Text to Speech: Add `getWord()` method
 * New: Text to Speech: Add `getCustomVoiceModel()` method with CustomVoiceModel argument
 * New: Text to Speech: Add `deleteWord()` method with String argument
 * New: Text to Speech: Add `words` to `CustomVoiceModel` object
 * New: Text to Speech: Add `part_of_speech` to `CustomTranslation` object
 * Fix: Text to Speech: Enable customization results for `getVoice()` method
 * New: Tradeoff Analytics: Add findPreferableOptions parameter to `dilemmas()` method
 * New: Tradeoff Analytics: Add `PreferableSolutions` object to `Resolution` object
 * New: Tradeoff Analytics: Add `DominatingOption` object to `Solution` object

## Version 3.5.3

_2016-12-15_

 * New: Added Discovery v1

## Version 3.5.2

_2016-12-08_

 * New: Added Speaker Labeling (diarization) added
 * New: Added Conversation + Tone Analyzer example
 * New: Added byte array support to classify an in memory image
 * Fix: Text to Speech: `getPronunciation()` and `getVoice` now accept a `customizationId` parameter.

## Version 3.5.1

_2016-11-01_

 * Fix: Remove limitation when creating a Solr cluster

## Version 3.5.0

_2016-10-19_

 * New: Personality Insights v3
 * New: Speech to Text Customizations
 * New: Conversation version date 2016-09-19
 * Fix: Calling `synthesize` in Text to Speech now accepts a `rate`  for PCM. #454
 * Fix: READMEs now point to the right maven dependency #459
 * Fix: AlchemyLanguage now has anchor dates for combine calls
 * Fix: Retrieve and Rank `topAnswer` bug #456

## Version 3.4.1

_2016-09-30_

 * New: Add Language Translator

## Version 3.4.0

_2016-09-29_

 The SDK 3.4.0 is the first step into moving from one maven module into a multi-module project.
 This change will allow users to specify the service they want to use skipping the other services.
 For example, in order to use Retrieve and Rank in Gradle you need:

 ```gradle
 'com.ibm.watson.developer_cloud:retrieve-and-rank:3.4.0'
 ```

 * New: Move to a maven multi-module project
 * Fix: Send default headers in WebSocket connections #422
 * Fix: Skip token creation if `skipAuthentication=true` #440

## Version 3.3.1

_2016-09-07_

 * New: AlchemyLanguage now returns the `sourceText` in the `combined` call.
 * New: Add french broadband model to Speech to Text
 * Fix: Add extracted dates to Alchemy Language combined call #436
 * Fix: Speech to text example close the connection when finish the extracted dates to Alchemy Language combined call #436
 * Fix: removed deprecated services: Concept Insights and Relationship Extraction.
 * Fix: Add missing parameter in document conversation. #428
 * Fix: Add `smart_formatting` to Speech to Text

## Version 3.3.0

_2016-08-08_

 * New: Tests are ignored if `config.properties` doesn't have valid credentials
 * New: Document Conversion can index documents directly into Retrieve and Rank
 * New: Visual Recognition Re-training
 * New: Conversation v1: `MessageRequest` now supports entities and intents
 * New: AlchemyLanguage `typedRelations` entities and intents
 * New: Speech to Text `keyword_spotting`
 * Fix: Remove Relationship extraction v1 Beta
 * Fix: Remove Tone Analyzer v3 Beta
 * Fix: :fire: update `version_date` for Visual Recognition to be `2016-05-20`
 * Fix: Remove warning when JDNI can't find credentials

## Version 3.2.0

_2016-08-02_

 * New: Conversation v1
 * New: Text To Speech now supports `audio/basic`, `audio/i16` and `ogg/vorgis`
 * New: AlchemyLanguage now has a TypedRelation method that extract relationships and entities from text
 * Fix: Speech to Text now returns the voice description when calling `getVoices()`
 * Fix: url from `VCAP_SERVICES` take precedence over the default url
 * Fix: Removed Relationship Extraction v1-beta
 * Fix: Removed Tone Analyzer v3-beta

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
