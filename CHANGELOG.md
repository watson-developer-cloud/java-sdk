## [8.2.1](https://github.com/watson-developer-cloud/java-sdk/compare/v8.2.0...v8.2.1) (2020-01-18)


### Bug Fixes

* **Natural Language Understanding:** Add back model parameter in CategoriesOptions which was mistake ([58111ff](https://github.com/watson-developer-cloud/java-sdk/commit/58111ff5e14dca1cea3e8eaca53404a2a6dbcb85))

# [8.2.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.1.0...v8.2.0) (2020-01-16)


### Bug Fixes

* **Discovery v1:** Ensure collectionIds are supplied to avoid service error ([955742b](https://github.com/watson-developer-cloud/java-sdk/commit/955742b4bd41640a86c8f2eee9b89231068b0654))
* **Discovery v2:** Ensure all required props are sent to prevent service errors ([aab26b7](https://github.com/watson-developer-cloud/java-sdk/commit/aab26b738cf8c0778afd0fda493147ea49407b75))


### Features

* **Assistant v2:** Add system prop to MessageContentSkill ([b95388a](https://github.com/watson-developer-cloud/java-sdk/commit/b95388a9196a152a1cc5d86fc5ee803a6389def2))
* **Speech to Text:** Add endOfPhraseSilenceTime and splitTranscriptAtPhraseEnd props to CreateJobOp ([be54f7f](https://github.com/watson-developer-cloud/java-sdk/commit/be54f7fe80d7eccb8af40912905759202940715f))
* **Speech to Text:** Add endOfUtterance prop to SpeechRecognitionResult ([42f6ec6](https://github.com/watson-developer-cloud/java-sdk/commit/42f6ec65b1536d578f7464822d94db7639a9df81))
* **Speech to Text:** Add support for Italian and Dutch models ([6f707da](https://github.com/watson-developer-cloud/java-sdk/commit/6f707da5120a870cc6fa2d84df5f70bfb7993f23))
* **Text to Speech:** Add Argentinean, Dutch, and Chinese voices ([62259ca](https://github.com/watson-developer-cloud/java-sdk/commit/62259ca1bead8e97bb3a037b39d0699ade5e166a))

# [8.1.0](https://github.com/watson-developer-cloud/java-sdk/compare/java-sdk-8.0.1...java-sdk-8.1.0) (2019-11-27)


### Bug Fixes

* **Discovery:** Add GenericQueryAggregation classes ([11f04fb](https://github.com/watson-developer-cloud/java-sdk/commit/11f04fb3329781f1ffc159755086882b7805aff9))
* **Discovery v1:** Remove incorrectly-defined title prop from QuertResult and QueryNoticesResult ([28d4f5c](https://github.com/watson-developer-cloud/java-sdk/commit/28d4f5c9d08d0ab18cfe41f28fe942b69dc76d35))
* **Visual Recognition:** Fix incorrectly-defined errors property in Image and ImageDetails ([5ce250b](https://github.com/watson-developer-cloud/java-sdk/commit/5ce250b54fb6705636c494be5bdaf3716fd7e15b))


### Features

* **Assistant v1:** Add disambiguationOptOut prop to dialog nodes ([38c610c](https://github.com/watson-developer-cloud/java-sdk/commit/38c610c2184b84d1a8350ee30744df147fb4566e))
* **Assistant v1:** Add offTopic prop to WorkspaceSystemSettings ([34809d3](https://github.com/watson-developer-cloud/java-sdk/commit/34809d3c5175799fca1a100dec6ecf71da411581))
* **Assistant v1:** Add randomize and maxSuggestions props to WorkspaceSystemSettingsDisambiguation ([8db7136](https://github.com/watson-developer-cloud/java-sdk/commit/8db7136c345bcd333b648b2f506000c99a12811b))
* **Assistant v1:** Add suggestionTextPolicy prop to WorkspaceSystemSettingsDisambiguation ([2741942](https://github.com/watson-developer-cloud/java-sdk/commit/27419420cc8b150440dbf1758a163b5e5fe3ebca))
* **Assistant v1:** Add webhook functionality ([252f385](https://github.com/watson-developer-cloud/java-sdk/commit/252f3850fbf0b853d3cf18dda13945a1acf11237))
* **Discovery v2:** Add custom deserializer for aggregations ([a6dec27](https://github.com/watson-developer-cloud/java-sdk/commit/a6dec27245c7675c1619763bbb874516323c8999))
* **Discovery v2:** Add initial generation of service ([ac17067](https://github.com/watson-developer-cloud/java-sdk/commit/ac17067ea1493f1afca6d5f813980533af6b4534))
* **Visual Recognition v4:** Add getTrainingUsage method ([14fefbd](https://github.com/watson-developer-cloud/java-sdk/commit/14fefbd74572d6dcc72e895961a50485697fa166))
* **Visual Recognition v4:** Add THUMBNAIL size constant to GetJpegImageOptions ([ee3298d](https://github.com/watson-developer-cloud/java-sdk/commit/ee3298d46f86e172a2f92eee8debcab34c35fb47))

## [8.0.1](https://github.com/watson-developer-cloud/java-sdk/compare/java-sdk-8.0.0...java-sdk-8.0.1) (2019-11-12)


### Bug Fixes

* Update core dependency to remove unwanted transitive dependencies ([95c759a](https://github.com/watson-developer-cloud/java-sdk/commit/95c759a625187430d09bd564ddc4f73988afbc34))
