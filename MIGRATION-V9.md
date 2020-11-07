## v9.0.0 Migration guide
This document should serve as a guide to breaking changes for users moving from code using the v8.x.x version of the SDK to v9.x.x.

### Service changes

### All Services
* The `version` of a service can be retrieved with `getVersion()`
* The `version` of a service can be set with `setVersion()`

### Assistant v1 Instance

* Added function `bulkClassify()`: Identify intents and entities in multiple user utterances.

### Assistant v1 Models

#### Models Added

`BulkClassifyOptions`, `BulkClassifyOutput`, `BulkClassifyResponse`, `BulkClassifyUtterance`, `DialogNodeContext`, `DialogNodeOutputConnectToAgentTransferInfo`, `DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent`, `DialogNodeOutputGenericDialogNodeOutputResponseTypeImage`, `DialogNodeOutputGenericDialogNodeOutputResponseTypeOption`, `DialogNodeOutputGenericDialogNodeOutputResponseTypePause`, `DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill`, `DialogNodeOutputGenericDialogNodeOutputResponseTypeText`, `RuntimeResponseGenericRuntimeResponseTypeConnectToAgent`, `RuntimeResponseGenericRuntimeResponseTypeImage`, `RuntimeResponseGenericRuntimeResponseTypeOption`, `RuntimeResponseGenericRuntimeResponseTypePause`, `RuntimeResponseGenericRuntimeResponseTypeSuggestion`, `RuntimeResponseGenericRuntimeResponseTypeText`

#### Models Removed

`DialogSuggestionOutput`, `DialogSuggestionResponseGeneric`, `SystemResponse`

#### Model Properties Changed

`Context`
* Added Builder
* `System` property type changed from `SystemResponse` to `Map<String, Object>`

`Counterexample`, `CreateEntity`, `CreateIntent`, `CreateValue`, `Example`, `Synonym`, `Value`
* `created`, `updated` properties are read only

`CreateDialogNodeOptions`
* `context` property type changed from `Map<String, Object>` to `DialogNodeContext`

`DialogNode`
* `context` property type changed from `Map<String, Object>` to `DialogNodeContext`
* `disabled`, `created` and `updated` properties are read only

`DialogNodeOutput`
* Added Builder
* Added `integrations` property with getter and setter

`DialogNodeOutputGeneric`,
* Added discriminator
* Removed Builder
* Added read only properties `agentAvailable`, `AgentUnavailable`, and `transferInfo`

`DialogSuggestion`
* `output` property type changed from `DialogSuggestionOutput` to `Map<String, Object>`

`ListCounterExamplesOptions`, `ListDialogNodesOptions`, `ListEntitiesOptions`, `ListExamplesOptions`, `ListIntentsOptions`, `ListSynonymsOptions`, `ListValuesOptions`, `ListWorkspacesOptions`
* `includeCount` property added with setter and getter

`MessageInput`
* Added Builder
* Changed `suggestedText` and `originalText` properties to read only

`MessageRequest`
* Changed `actions` property to read only

`OutputData`
* Added Builder

`RuntimeResponseGeneric`,
* Added discriminator
* Changed `ResponseType` interface use only TEXT
* Removed Builder
* Added read only properties `agentAvailable`, `AgentUnavailable`, and `transferInfo`

`UpdateDialogNodeOptions`
* Changed `newContext` property type from `Map<String, Object>` to `DialogNodeContext`


### Assistant v2 Instance

* Added function `bulkClassify()`: Identify intents and entities in multiple user utterances.

### Assistant v2 Models

#### Models Added

`BulkClassifyOptions`, `BulkClassifyOutput`, `BulkClassifyResponse`, `BulkClassifyUtterance`,
`DialogNodeOutputConnectToAgentTransferInfo`, `RuntimeResponseGenericRuntimeResponseTypeConnectToAgent`, `RuntimeResponseGenericRuntimeResponseTypeImage`, `RuntimeResponseGenericRuntimeResponseTypeOption`, `RuntimeResponseGenericRuntimeResponseTypePause`, `RuntimeResponseGenericRuntimeResponseTypeSearch`, `RuntimeResponseGenericRuntimeResponseTypeSuggestion`, `RuntimeResponseGenericRuntimeResponseTypeText`

#### Models Removed

`MessageContextSkills`

#### Model Properties Changed

`MessageContext`, `MessageContextStateless`
* Changed `skills` property type from `MessageContextSkills` to `Map<String, MessageContextSkill>`

`MessageContextGlobal`
* Changed `sessionId` property to read only

`MessageContextSkill`
* Changed `system` property type from `Map<String, Object>` to `MessageContextSkillSystem`

`MessageContextSkillSystem`
* Added Builder

`RuntimeResponseGeneric`
* Added discriminator
* Removed Builder
* Added read only properties `agentAvailable`, `AgentUnavailable`, and `transferInfo`

### Compare Comply v1 Instance

* No changes

### Compare Comply v1 Models

#### Model Properties Changed

`Category`, `TypeLabel`
* Added `modification` property

`ListBatchesOptions`
* Removed Builder

`ListFeedbackOptions`
* Removed `before` and `after` properties

`OriginalLabelsOut`, `UpdatedLabelsOut`
* Removed `modification` property


### Discovery v1 Instance

* No changes

### Discovery v1 Models

#### Models Removed

`NluEnrichmentCategories`

#### Model Properties Changed

`Configuration`
* Changed `configurationId`, `created`, and `updated` properties to read only

`Credentials`
* Changed `credentialId` property to read only

`EventData`
* Changed `queryId` property to read only

`NluEnrichmentFeatures`
* Changed `categories` property type from `NluEnrichmentCategories` to `Map<String, Object>`

### Discovery v2 Instance

* Added function `analyzeDocument()`: Process a document using the specified collection's settings and return it for realtime use. - Currently CP4D only

### Discovery v2 Models

#### Models Added

`AnalyzedDocument`, `AnalyzeDocumentOptions`, `AnalyzedResult`

#### Models Removed

`QueryNoticesResult`

#### Model Properties Changed

`CollectionDetails`
* Changed `collectionId` and `created` properties to read only

`TrainingExample`
* Changed `created` and `updated` properties to read only

`TrainingQuery`
* Changed `created`, `queryId` and `updated` properties to read only

### Language Translator v3 Instance

* No changes

### Language Translator v3 Models

#### Model Properties Changed

`ListDocumentsOptions`, `ListIdentifiableLanguagesOptions`, `ListLanguagesOptions`
* Removed Builder

### Natural Language Classifier v1 Instance

* No changes

### Natural Language Classifier v1 Models

#### Model Properties Changed

`ListClassifiersOptions`
* Removed Builder

### Natural Language Understanding v1 Instance

* No changes

### Natural Language Understanding v1 Models

#### Models Added

`FeaturesResultsMetadata`

#### Models Removed

`MetadataOptions`, `AnalysisResultsMetadata`

#### Model Properties Changed

`AnalysisResults`
* Changed `metadata` property type from `AnalysisResultsMetadata` to `FeaturesResultsMetadata`

`Features`
* Changed `metadata` property type from `MetadataOptions` to `Map<String, Object>`

`ListModelsOptions`
* Remove Builder

### Personality Insights v3 Instance

* No changes

### Personality Insights v3  Models

* No changes

### Speech To Text v1 Instance

* `recognizeUsingWebSocket()`: Changed `recognizeOptions` parameter type from `RecognizeOptions` to `RecognizeWithWebsocketsOptions`


### Speech To Text v1 Models

#### Models Added

`RecognizeWithWebsocketsOptions`

#### Model Properties Changed

`CheckJobsOptions`, `ListModelOptions`
* Removed Builder

`RecognizeOptions`
* Removed `interimResults`, `processingMetrics`, `processingMetricsInterval`
properties (Moved to `RecognizeWithWebsocketsOptions`)

### Text to Speech v1 Instance

* No changes

### Text to Speech v1 Models

#### Models Added

`CreateCustomModelOptions`, `CustomModel`, `CustomModels`, `DeleteCustomModelOptions`, `GetCustomModelOptions`, `ListCustomModelsOptions`, `UpdateCustomModelOptions`

#### Models Removed

`CreateVoiceModelOptions`, `DeleteVoiceModelOptions`, `GetVoiceModelOptions`, `ListVoiceModelsOptions`, `UpdateVoiceModelOptions`, `VoiceModel`, `VoiceModels`

#### Model Properties Changed

`ListVoicesOptions`
* Remove Builder

`Voice`
* Change return type of `getCustomization()` from `VoiceModel` to `CustomModel`

### Tone Analyzer v3 Instance

* No changes

### Tone Analyzer v3 Models

* No changes

### Visual Recognition v3 Instance

* No changes

### Visual Recognition v3 Models

* No changes

### Visual Recognition v4 Instance

* No changes

### Visual Recognition v4 Models

#### Models Added

`CollectionTrainingStatus`, `ObjectDetail`

#### Models Removed

#### Model Properties Changed

`Collection`
* Changed `trainingStatus` property type from `TrainingStatus` to `CollectionTrainingStatus`

`CreateCollectionOptions`, `UpdateCollectionOptions`
* Added `trainingStatus` property

`GetTrainingUsageOptions`
* Changed `startTime` and `endTime` property type from `String` to `Date`

`ListCollectionsOptions`
* Remove Builder

`ObjectDetail`
* Changed `location` property type from `Location` to `ObjectDetailLocation`

`UpdateObjectMetadata`
* Changed `count` property to read only