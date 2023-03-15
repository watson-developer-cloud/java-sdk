# v11.0.0 Migration Guide

### Breaking changes by service

#### Assistant v2
- Model `MessageContext` property `skills` type changed to new `MessageContextSkills`
- Model `Environment` property `language` removed
- Model `EnvironmentReleaseReference` renamed to `BaseEnvironmentReleaseReference`
- Model `EnvironmentOrchestration` renamed to `BaseEnvironmentOrchestration`
- Model `SkillReference` renamed to `EnvironmentSkill`

#### Discovery v2
- Parameter `smartDocumentUnderstanding` removed from `CreateCollectionOptions`
- Model `QueryResponsePassage` and `QueryResultPassage` property `confidence` removed
- QueryAggregation models restructured

#### Natural Language Understanding
- All `sentimentModel` functions removed

#### Speech to Text
- `AR_AR_BROADBANDMODEL` model removed in favor of `AR_MS_BROADBANDMODEL` model


### New Features by Service

#### Assistant v2
- `createAssistant` function
- `listAssistants` function
- `deleteAssistant` function
- `updateEnvironment` function
- `createRelease` function
- `deleteRelease` function
- `getSkill` function
- `updateSkill` function
- `exportSkills` function
- `importSkills` function
- `importSkillsStatus` function
- Improved typing for `message` function call
See details of these functions on IBM's documentation site [here](https://cloud.ibm.com/apidocs/assistant-v2?code=node)

#### Discovery v2
- Aggregation types `QueryTopicAggregation` and `QueryTrendAggregation` added

#### Speech to Text
- added `FR_CA_MULTIMEDIA`, `JA_JP_TELEPHONY`, `NL_NL_MULTIMEDIA`, `SV_SE_TELEPHONY` models

#### Text to Speech
- added `EN_AU_HEIDIEXPRESSIVE`, `EN_AU_JACKEXPRESSIVE`, `EN_US_ALLISONEXPRESSIVE`, `EN_US_EMMAEXPRESSIVE`, `EN_US_LISAEXPRESSIVE`, `EN_US_MICHAELEXPRESSIVE`, `KO_KR_JINV3VOICE`
- Parameters `ratePercentage` and `pitchPercentage` added to `synthesize` function
See details of these new parameters on IBM's documentation site [here](https://cloud.ibm.com/apidocs/text-to-speech?code=node#synthesize)
