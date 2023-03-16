# [11.0.0](https://github.com/watson-developer-cloud/java-sdk/compare/v10.1.0...v11.0.0) (2023-03-16)


### Features

* **assistantv1:** update based on api definitions ([d2aebb9](https://github.com/watson-developer-cloud/java-sdk/commit/d2aebb9b0f9428b9ba7673f6e768049df32acac7))
* **assistantv2:** add new assistant, environment, and skills lifecycle methods ([aaf9b77](https://github.com/watson-developer-cloud/java-sdk/commit/aaf9b773317042358240fb62fd369dad69678092))
* **discoveryv1:** update based on latest api definitions ([a810f01](https://github.com/watson-developer-cloud/java-sdk/commit/a810f01ef76b8513f26c0fc1a0e07a06d5bad50c))
* **discoveryv2:** update based on api definitions ([1e2682f](https://github.com/watson-developer-cloud/java-sdk/commit/1e2682f82318500d817c4a9e78493277773780f1))
* **language translator:** update based on api definitions ([d45607b](https://github.com/watson-developer-cloud/java-sdk/commit/d45607b472b5c1899cba393e628c1d632ffcf6f0))
* **natural language understanding:** update based on api definitions ([a743cb7](https://github.com/watson-developer-cloud/java-sdk/commit/a743cb7f774b66790da4e9fbe059602e93cbbf6f))
* **speech to text:** update based on new api definitions ([0a7058b](https://github.com/watson-developer-cloud/java-sdk/commit/0a7058bc169c8d39a7e541b677108e75d2067bbe))
* **text to speech:** update based on api definitions ([54fd47d](https://github.com/watson-developer-cloud/java-sdk/commit/54fd47dd50ea517834c4109a1ecca87785662507))


### BREAKING CHANGES

* **natural language understanding:** removes the 'sentimentModel' functions and models
* **discoveryv2:** enrichmentId is now a required param for 'DocumentClassifierEnrichment' model.
'confidence' property has been removed from 'QueryResponsePassage' and 'QueryResultPassage' models.
Breaking interface changes to handling aggregation discriminators.
* **assistantv2:** 'createSession' param replaced with 'requestAnalytics' param. 'language' property
removed from 'Environment' model. method name changes in environment and release models.
* **assistantv1:** public interface 'Model' in 'WorkspaceSystemSettingsNlp' has been removed

# [10.1.0](https://github.com/watson-developer-cloud/java-sdk/compare/v10.0.1...v10.1.0) (2022-08-10)


### Bug Fixes

* **assistantv2:** add discrim bug hand edit for TurnEvent models ([4f4894f](https://github.com/watson-developer-cloud/java-sdk/commit/4f4894f17197d9bebf138e539758b5c072dcc36a))
* **discov2:** make enrichement_id required and linting changes ([995e687](https://github.com/watson-developer-cloud/java-sdk/commit/995e687a07a1af9806b2f66dbcdeeaac03978d8b))


### Features

* **assistantv1:** update models and add new methods ([64a2622](https://github.com/watson-developer-cloud/java-sdk/commit/64a2622378df1874e3e259c09bceb9978a3a9aba))
* **assistantv2:** update models and add new methods ([2f164cd](https://github.com/watson-developer-cloud/java-sdk/commit/2f164cd0a1f48749044c8b70f5e95ce72a3a69fc))
* **discov2:** update models and add new methods ([a29cb73](https://github.com/watson-developer-cloud/java-sdk/commit/a29cb7311798d7023112773b930bde993be2d804))
* **nlu:** add new parameter to create/updateClassificationsModel ([680d2c0](https://github.com/watson-developer-cloud/java-sdk/commit/680d2c0a94198ca4ec605755a89f47b4f8cca296))
* **stt:** add and remove method parameters ([cdcc228](https://github.com/watson-developer-cloud/java-sdk/commit/cdcc2280e528ac5e2900b032a82dbb3020237b8f))
* **tts:** add method parameters ([2a0c2f3](https://github.com/watson-developer-cloud/java-sdk/commit/2a0c2f3f64c07bed920639daa391e976f75d790f))
* **wss:** add and remove websocket params ([bfd4b0d](https://github.com/watson-developer-cloud/java-sdk/commit/bfd4b0df203f3f0dac51c5b29bcb8895b7847b14))

## [10.0.1](https://github.com/watson-developer-cloud/java-sdk/compare/v10.0.0...v10.0.1) (2022-04-25)


### Bug Fixes

* **language-translator-v3:** add content-type to createModelOptions model properties ([afd1086](https://github.com/watson-developer-cloud/java-sdk/commit/afd1086ccbb30fa1d84b83e19c9d9a7bf472b4bc))

# [10.0.0](https://github.com/watson-developer-cloud/java-sdk/compare/v9.3.1...v10.0.0) (2022-03-21)


### Bug Fixes

* **bumpversion:** update bumpversion file ([ca7b4e8](https://github.com/watson-developer-cloud/java-sdk/commit/ca7b4e87279d63fea920e279de88c80516d3bca3))


### Features

* **assistant-v1:** add new DialogNodeOutputGeneric subclasses & additional properties in workspace ([dfeacca](https://github.com/watson-developer-cloud/java-sdk/commit/dfeacca3201245a1a5902669be9e051dcb320506))
* **assistant-v1:** generated using api-def: master & generator: 3.46.0 ([dc7f6a4](https://github.com/watson-developer-cloud/java-sdk/commit/dc7f6a4acad722a507724732f7e17ffeb992d4ba))
* **assistant-v2:** generated using api-def: master & generator: 3.46.0 ([4fdfb2f](https://github.com/watson-developer-cloud/java-sdk/commit/4fdfb2faca5a047d841de45cba0ca26633618ef3))
* **deprecation:** remove CC, NLC, PI, Tone Analyzer, and Visual Recognition ([1b64285](https://github.com/watson-developer-cloud/java-sdk/commit/1b64285fd5b3d0765e2435627ae65ffcce097136))
* **discovery-v1:** document status & query aggregation update ([776048c](https://github.com/watson-developer-cloud/java-sdk/commit/776048cbc7a2d2938d63bfb6eabcc4fded56a44b))
* **speech-to-text-v1:** add de-de_multimedia & update comments ([0d32576](https://github.com/watson-developer-cloud/java-sdk/commit/0d32576bc7405e6a4c39f01688b41f1e5bab180b))
* **speech-to-text-v1:** add missing import ([029fdfa](https://github.com/watson-developer-cloud/java-sdk/commit/029fdfa9afc51acc3f673daf07aa43dec6dd4691))
* **speech-to-text-v1:** supportedFeatures: customAcousticModel property added & update comments ([62e4f8e](https://github.com/watson-developer-cloud/java-sdk/commit/62e4f8ec354d2746acdcd07bce28dec348214fba))
* **text-to-speech-v1:** add voices and update comments ([40cd035](https://github.com/watson-developer-cloud/java-sdk/commit/40cd0358c131d2e3767b16d9bedf2ddd256e7fd2))


### Reverts

* **pom.xml:** revert change for root pom.xml ([5fecba8](https://github.com/watson-developer-cloud/java-sdk/commit/5fecba83ac663ceb6766061c81878369a46963f7))


### BREAKING CHANGES

* **discovery-v1:** QueryAggregation: BREAKING QueryAggregation subclasses changed.
* **assistant-v2:** MessageOutputDebug: BREAKING nodesVisited type DialogNodesVisited changed to
DialogNodeVisited, RuntimeEntity: BREAKING optional metadata property removed
* **assistant-v1:** OutputData: BREAKING required text property removed, RuntimeEntity: BREAKING
optional metadata property removed

## [9.3.1](https://github.com/watson-developer-cloud/java-sdk/compare/v9.3.0...v9.3.1) (2021-12-02)


### Bug Fixes

* **deploy.yml:** up the version for node to fix semantic-release ([bcda21d](https://github.com/watson-developer-cloud/java-sdk/commit/bcda21d843a55ff81894735c720dc47775890ae4))
* **pom.xml:** update sdk-core version to fix Gson 2.8.9 java.lang.NoSuchFieldError ([40b287e](https://github.com/watson-developer-cloud/java-sdk/commit/40b287ecd79dfb898de3051d673cd406af7364a7))

# [9.3.0](https://github.com/watson-developer-cloud/java-sdk/compare/v9.2.2...v9.3.0) (2021-09-14)


### Bug Fixes

* **assistant-v1:** location is no longer a required parameter for RuntimeEntity ([4014b36](https://github.com/watson-developer-cloud/java-sdk/commit/4014b365cd862ceca885855796fc8595c7662f36))
* **assistant-v2:** add answers to searchResult ([8d53d6c](https://github.com/watson-developer-cloud/java-sdk/commit/8d53d6c71b6ef6fb31119ed5bcd082e1bf6dcbb6))
* **assistant-v2:** location is no longer a required parameter for RuntimeEntity ([2971a3b](https://github.com/watson-developer-cloud/java-sdk/commit/2971a3b22fab6092e5f4c05c6e96f2871c5d4905))
* **discovery-v1:** change authentication to authenticated property in StatusDetails ([e7b3cae](https://github.com/watson-developer-cloud/java-sdk/commit/e7b3caeebc07e53a11421369237c013df6dd1d88))
* **discovery-v1:** status is now deserialized as an object ([c72b497](https://github.com/watson-developer-cloud/java-sdk/commit/c72b497317ca33a9b6017458f8f2fce9ee528748))
* **natural-language-understanding-v1:** listClassificationsModels return type change ([5776b7b](https://github.com/watson-developer-cloud/java-sdk/commit/5776b7b97cedef31420fe88fa59d7e3fce048638))
* **natural-language-understanding-v1:** remove unused models ([8e894dc](https://github.com/watson-developer-cloud/java-sdk/commit/8e894dc16b8aeabf76f9e9c33977188a9f840d16))


### Features

* **assistant-v1:** add altText property to DialogNodeOutputGeneric & RuntimeResponseGeneric ([66acc78](https://github.com/watson-developer-cloud/java-sdk/commit/66acc78bcb3ce1d4fe495c93ca646d4d8741c98a))
* **assistant-v1:** add extra sensitivity values for RuntimeResponseGenericRuntimeResponseTypeImage ([86b331d](https://github.com/watson-developer-cloud/java-sdk/commit/86b331d935b8b1719cb7b1cafff24baaaa423506))
* **assistant-v2:** add altText property to RuntimeResponseGeneric ([798f780](https://github.com/watson-developer-cloud/java-sdk/commit/798f780b71a67ec3e3b13ef19f44dec151d3c22c))
* **assistant-v2:** add SEARCH as a type of the message to MessageInput & MessageInputStateless ([b9a3427](https://github.com/watson-developer-cloud/java-sdk/commit/b9a342794f2594033c5a48b8323610f30eedd527))
* **assistant-v2:** add sessionStartTime & state properties to MessageContextGlobalSystem ([6cd0b2e](https://github.com/watson-developer-cloud/java-sdk/commit/6cd0b2e50079f7435ee935588d2a38cdc7c5bab7))
* **discovery-v2:** add CONVERSATIONAL_SEARCH & CONTENT_INTELLIGENCE as a type of a project ([ec6e753](https://github.com/watson-developer-cloud/java-sdk/commit/ec6e7531d8c39a0c3aa3c4a392071e982a1fba65))
* **speech-to-text-v1:** add more languages supported for next generation models ([2fbd050](https://github.com/watson-developer-cloud/java-sdk/commit/2fbd050306f2912fc7648e4ed70cd48abea54dad))
* **speech-to-text-v1:** add more languages supported for next generation models ([c03ea09](https://github.com/watson-developer-cloud/java-sdk/commit/c03ea099880c06f1717486c226debfede9eeb30b))
* **text-to-speech-v1:** add new voice models ([54d2338](https://github.com/watson-developer-cloud/java-sdk/commit/54d2338a4d216e629db767415d6e066e6e22a45e))

## [9.2.2](https://github.com/watson-developer-cloud/java-sdk/compare/v9.2.1...v9.2.2) (2021-09-01)


### Bug Fixes

* **nlc:** add a deprecation message ([#1185](https://github.com/watson-developer-cloud/java-sdk/issues/1185)) ([b460cdd](https://github.com/watson-developer-cloud/java-sdk/commit/b460cddc4e1b27765441a8cfc1e0139bd92b5ff7))

## [9.2.1](https://github.com/watson-developer-cloud/java-sdk/compare/v9.2.0...v9.2.1) (2021-08-17)


### Bug Fixes

* **deploy:** use bump2version ([d4bbc44](https://github.com/watson-developer-cloud/java-sdk/commit/d4bbc44cd49b4227cd2338f99a0aad58c0019753))
* **deploy:** use python ([03168b4](https://github.com/watson-developer-cloud/java-sdk/commit/03168b48e64780f3d17eb714f2adf6ff8c479d26))
* **deploy.xml:** fix typo on deploy.xml gha ([9136c47](https://github.com/watson-developer-cloud/java-sdk/commit/9136c47c549be29b7b600e844946da928ca42890))
* **pom.xml:** update java-sdk-core version ([c6814a5](https://github.com/watson-developer-cloud/java-sdk/commit/c6814a58a4a271689fa1df8d3dc4772c838bce05))

# [9.2.0](https://github.com/watson-developer-cloud/java-sdk/compare/v9.1.1...v9.2.0) (2021-06-02)


### Bug Fixes

* **text-to-speech-v1:** generated using api def sdk-2021-05-11-rerelease and gen 3.31.0 ([e825419](https://github.com/watson-developer-cloud/java-sdk/commit/e8254194cd199c3039a61a58c65039eadecfb562))


### Features

* **generation:** generated using api def sdk-2021-05-11 & gen 3.31.0 ([82ef647](https://github.com/watson-developer-cloud/java-sdk/commit/82ef647c855b7d226104ab4a3bf56de8dce748c5))
* **generation:** generated using api def: sdk-2021-05-11 and generator: 3.31.0 ([c039886](https://github.com/watson-developer-cloud/java-sdk/commit/c039886481d21e70c2d66bbf3aacb56543ada9a3))
* **natural-language-understanding-v1:** generated using api def 5b4cdff & gen 3.31.0 ([ac51578](https://github.com/watson-developer-cloud/java-sdk/commit/ac515782a0e1e1541b3852d490d0ad8f8d8fce9e))

## [9.1.1](https://github.com/watson-developer-cloud/java-sdk/compare/v9.1.0...v9.1.1) (2021-05-17)


### Bug Fixes

* **bumpversion:** update bumpversion configuration ([e6b97d6](https://github.com/watson-developer-cloud/java-sdk/commit/e6b97d6d13a627290dea54dea14d67d6aab3bdfa))

# [9.1.0](https://github.com/watson-developer-cloud/java-sdk/compare/v9.0.2...v9.1.0) (2021-04-30)


### Bug Fixes

* **assistant-v1:** override toString method to allow null values ([dc0a023](https://github.com/watson-developer-cloud/java-sdk/commit/dc0a023d6b1f6748134d584f71dc804494ade737))


### Features

* **assistant-v1:** add updateDialogNodeNullable as a new function ([90e3ea5](https://github.com/watson-developer-cloud/java-sdk/commit/90e3ea5c7f9036c096721724320e7f4000b91325))

## [9.0.2](https://github.com/watson-developer-cloud/java-sdk/compare/v9.0.1...v9.0.2) (2020-12-21)


### Bug Fixes

* **generation:** api def '8be1cdc78c7998b055bc8ea895dddd7c8496b2a4' gen tag 3.19.0 ([1ddf534](https://github.com/watson-developer-cloud/java-sdk/commit/1ddf534ff0d10481e7246abb37df1b88d9421d9e))

## [9.0.1](https://github.com/watson-developer-cloud/java-sdk/compare/v9.0.0...v9.0.1) (2020-12-11)


### Bug Fixes

* **readme:** add extra line to readme to trigger patch release ([f5d1a06](https://github.com/watson-developer-cloud/java-sdk/commit/f5d1a0696835e079a3349b5a4575a1d1a1658047))

# [9.0.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.6.3...v9.0.0) (2020-12-10)


### Bug Fixes

* **sdk-version:** fix sdk-version ([3019159](https://github.com/watson-developer-cloud/java-sdk/commit/3019159999a36e5065bdfe33f2976e625aec10f4))
* **visual-recognition-v4:** remove trainingStatus as a parameter for create & update Collection ([02e3dfd](https://github.com/watson-developer-cloud/java-sdk/commit/02e3dfd0fb972f3081c91921f6acf61fdcc2f1e6))
* **visual-recognition-v4:** remove trainingStatus as a parameter for create & update Collection ([5568bf9](https://github.com/watson-developer-cloud/java-sdk/commit/5568bf99e47ad92420253c936db7bc8fac13a7f0))
* typo in migration guide ([984a350](https://github.com/watson-developer-cloud/java-sdk/commit/984a3503502a7867470b3e342fe959643ae0a561))
* update version to 9.0.0-rc.2 ([ab57379](https://github.com/watson-developer-cloud/java-sdk/commit/ab573794f351e00f6fb97e3fed0e7d3ad20fb824))


### chore

* update for semantic-release ([22a7d00](https://github.com/watson-developer-cloud/java-sdk/commit/22a7d008c6e333a944c3b0f6a96f142f587e5aed))


### Features

* **generation:** api def tag 'sdk-major-release-2020' gen tag 3.19.0 ([3414833](https://github.com/watson-developer-cloud/java-sdk/commit/3414833807abe8534e6daf838500a5426e9e4e04))
* add bumpversion release candidate support ([b794bb6](https://github.com/watson-developer-cloud/java-sdk/commit/b794bb6407e461af0edd99952e08b98e8d4a95e2))
* **generation:** api def tag 'sdk-major-release-2020-rc01' gen commit '7cc0550' ([3bec20d](https://github.com/watson-developer-cloud/java-sdk/commit/3bec20d5ccae38ba2a1f1d8adf6cf16cdc2c6a18))
* **speech-to-text-v1:** add RecognizeWithWebsocketsOptions model ([d3b7fe9](https://github.com/watson-developer-cloud/java-sdk/commit/d3b7fe91fad17fa6ef6dd00a5ecc38b689dfd016))


### BREAKING CHANGES

* **generation:** api def tag 'sdk-major-release-2020' gen tag 3.19.0
* generated with 3.18.0 of the IBM openapi sdk generator

# [9.0.0-rc.3](https://github.com/watson-developer-cloud/java-sdk/compare/v9.0.0-rc.2...v9.0.0-rc.3) (2020-12-03)


### Features

* **generation:** api def tag 'sdk-major-release-2020' gen tag 3.19.0 ([3414833](https://github.com/watson-developer-cloud/java-sdk/commit/3414833807abe8534e6daf838500a5426e9e4e04))


### BREAKING CHANGES

* **generation:** api def tag 'sdk-major-release-2020' gen tag 3.19.0

# [9.0.0-rc.2](https://github.com/watson-developer-cloud/java-sdk/compare/v9.0.0-rc.1...v9.0.0-rc.2) (2020-11-11)


### Bug Fixes

* typo in migration guide ([984a350](https://github.com/watson-developer-cloud/java-sdk/commit/984a3503502a7867470b3e342fe959643ae0a561))
* update version to 9.0.0-rc.2 ([ab57379](https://github.com/watson-developer-cloud/java-sdk/commit/ab573794f351e00f6fb97e3fed0e7d3ad20fb824))


### Features

* add bumpversion release candidate support ([b794bb6](https://github.com/watson-developer-cloud/java-sdk/commit/b794bb6407e461af0edd99952e08b98e8d4a95e2))

# [9.0.0-rc.1](https://github.com/watson-developer-cloud/java-sdk/compare/v8.6.3...v9.0.0-rc.1) (2020-11-10)


### chore

* update for semantic-release ([22a7d00](https://github.com/watson-developer-cloud/java-sdk/commit/22a7d008c6e333a944c3b0f6a96f142f587e5aed))


### Features

* **generation:** api def tag 'sdk-major-release-2020-rc01' gen commit '7cc0550' ([3bec20d](https://github.com/watson-developer-cloud/java-sdk/commit/3bec20d5ccae38ba2a1f1d8adf6cf16cdc2c6a18))
* **speech-to-text-v1:** add RecognizeWithWebsocketsOptions model ([d3b7fe9](https://github.com/watson-developer-cloud/java-sdk/commit/d3b7fe91fad17fa6ef6dd00a5ecc38b689dfd016))


### BREAKING CHANGES

* generated with 3.18.0 of the IBM openapi sdk generator

## [8.6.3](https://github.com/watson-developer-cloud/java-sdk/compare/v8.6.2...v8.6.3) (2020-10-26)


### Bug Fixes

* **java-sdk-core-version:** update java-sdk-core version to fix serialization error on disco-v2 ([e75e97d](https://github.com/watson-developer-cloud/java-sdk/commit/e75e97d99b98376d568b87ba9747779bf9c8d39f))

## [8.6.2](https://github.com/watson-developer-cloud/java-sdk/compare/v8.6.1...v8.6.2) (2020-10-18)


### Bug Fixes

* **decrpyt-script:** place encrypted file on the right path ([07737f2](https://github.com/watson-developer-cloud/java-sdk/commit/07737f257604defdda795511049b59ab19b8d406))
* **decrypt-script:** update decrypt script ([2a28685](https://github.com/watson-developer-cloud/java-sdk/commit/2a286855dee6c663b9faeffbcae786364bec8e10))
* **readme:** create a patch for latest update on speech-to-text ([b858e48](https://github.com/watson-developer-cloud/java-sdk/commit/b858e481ef9961c69e787652c67a9fcca661c0c4))
* **tests&keys:** update api keys and integration tests ([26049c1](https://github.com/watson-developer-cloud/java-sdk/commit/26049c160b91e23f8f41703f3a90ebfdfb2e778c))

## [8.6.1](https://github.com/watson-developer-cloud/java-sdk/compare/v8.6.0...v8.6.1) (2020-09-28)


### Bug Fixes

* **generation:** api def tag 'sdk-2020-08-20' with disco-v2 passage update gen tag '2.3.1' ([1b8b67c](https://github.com/watson-developer-cloud/java-sdk/commit/1b8b67c194c4cd2d0a6b01c43a4e15da31b9294b))

# [8.6.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.5.0...v8.6.0) (2020-08-25)


### Features

* **generation:** api def tag 'sdk-2020-08-20' and gen tag '2.3.1' ([1129e9b](https://github.com/watson-developer-cloud/java-sdk/commit/1129e9b39e417408dc4cb22f497d7f3bb4361f9e))

# [8.5.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.4.0...v8.5.0) (2020-06-03)


### Features

* june release ([a637c98](https://github.com/watson-developer-cloud/java-sdk/commit/a637c985990f7776a7fec25f6190405991a1cc87))

# [8.4.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.3.1...v8.4.0) (2020-04-23)


### Bug Fixes

* **javadoc:** update links to common classes ([973d153](https://github.com/watson-developer-cloud/java-sdk/commit/973d153fa0b66be2ad486f394e87d1f32b9a836a))


### Features

* **assistant:** auto-generate code ([515fb60](https://github.com/watson-developer-cloud/java-sdk/commit/515fb605e110e3171fcecb1323ae7ccb2ac9a07e))
* **discovery:** auto-generate code ([9812072](https://github.com/watson-developer-cloud/java-sdk/commit/9812072be571d908156b43a508c61dc5057ef10f))
* **language-translator:** auto-generate code ([2676798](https://github.com/watson-developer-cloud/java-sdk/commit/2676798211fe65bb972107907df5c4febe813d27))
* **speech-to-text:** auto-generate code ([2261d67](https://github.com/watson-developer-cloud/java-sdk/commit/2261d67fb350df90bb932c4878edf93001f73dba))
* **text-to-speech:** auto-generate code ([87be679](https://github.com/watson-developer-cloud/java-sdk/commit/87be6796a17402aa03456de37c2510b889e3fe06))

## [8.3.1](https://github.com/watson-developer-cloud/java-sdk/compare/v8.3.0...v8.3.1) (2020-03-06)


### Bug Fixes

* **Discovery v1:** environment document count should use 'available' ([0567073](https://github.com/watson-developer-cloud/java-sdk/commit/0567073cc4e0ed3c83cd095ba9e0bc2c43e8925a))

# [8.3.0](https://github.com/watson-developer-cloud/java-sdk/compare/v8.2.1...v8.3.0) (2020-02-24)


### Features

* **assistant:** generated code ([10108d9](https://github.com/watson-developer-cloud/java-sdk/commit/10108d98767413bc23dfdfc8719e58eec0b1e614))
* **common:** generated code ([cae0d2c](https://github.com/watson-developer-cloud/java-sdk/commit/cae0d2ce1021e6354abc9a7e8b5c71d0bebd934b))
* **compare-comply:** generated code ([e03192f](https://github.com/watson-developer-cloud/java-sdk/commit/e03192f8e4dbcc7a1d3ffc7cafac47ce1593ad0f))
* **discovery:** generated code ([4baea9e](https://github.com/watson-developer-cloud/java-sdk/commit/4baea9eed6cefb3b2d9d8f8986b07266509101e6))
* **examples:** generated code ([2d93247](https://github.com/watson-developer-cloud/java-sdk/commit/2d932472659bc7b53259028062bcaf857ce98b18))
* **language-translator:** generated code ([65f5d55](https://github.com/watson-developer-cloud/java-sdk/commit/65f5d5505994a59d10a460bcfbea1c8586366572))
* **natural-language-classifier:** generated code ([d088954](https://github.com/watson-developer-cloud/java-sdk/commit/d088954520bf9fb8be347212dbe486d629a66341))
* **natural-language-understanding:** generated code ([5d2dd6d](https://github.com/watson-developer-cloud/java-sdk/commit/5d2dd6d75cb6c07c23dd0765b69e605e0efdd170))
* **personality-insights:** generated code ([883b971](https://github.com/watson-developer-cloud/java-sdk/commit/883b9717c42466e050d673acbcccff90429889dd))
* **speech-to-text:** generated code ([d3de7f1](https://github.com/watson-developer-cloud/java-sdk/commit/d3de7f1ef6c16a003f13430207ca23f4c5576789))
* **text-to-speech:** generated code ([f4548f2](https://github.com/watson-developer-cloud/java-sdk/commit/f4548f2d436157fe43b9bcd0ab129948acc70d26))
* **tone-analyzer:** generated code ([a753857](https://github.com/watson-developer-cloud/java-sdk/commit/a753857949d42b4a4dc3c5a4b5e6a05861128ee0))
* **visual-recognition:** generated code ([8d16bf3](https://github.com/watson-developer-cloud/java-sdk/commit/8d16bf3fdc4c7a8715119552dc334336253baa73))

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
