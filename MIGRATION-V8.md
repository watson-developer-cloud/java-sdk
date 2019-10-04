### v8.0.0 Migration guide
This document should serve as a guide to breaking changes for users moving from code using the v7.x.x version of the SDK to v8.x.x.

#### Authentication

##### v7.x.x

Previously, there were different builder objects for authentication. For example:

```java
// username and password
BasicAuthConfig config = new BasicAuthConfig.Builder()
  .username("<username>")
  .password("<password")
  .build();

// IAM
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .url("<iam_url>")
  .build();
```

This could be set multiple ways:

```java
// in the constructor
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .url("<iam_url>")
  .build();
Assistant service = new Assistant("2019-02-28", options);

// after instantiation
service.setAuthenticator(options);

// inline in the constructor (only for username and password!)
Assistant service = new Assistant("2019-02-28", "<username>", "<password>");
```

Overall, it was a little too open-ended and very confusing to follow. For this release, we've decided to standardize things, while developing a pattern that should be more scalable.

##### v8.x.x

There are 5 authentication variants supplied in the SDK (shown below), and it's possible now to create your own authentication implementation if you need something specific by implementing the `Authenticator` implementation.

##### Basic
You can authenticate with basic auth using the `BasicAuthenticator`. This allows you to pass in a username and password.

```java
Authenticator authenticator = new BasicAuthenticator("<username>", "<password>");
```

##### Bearer token
Use the `BearerTokenAuthenticator`. This one accepts just the bearer token.

```java
Authenticator authenticator = new BearerTokenAuthenticator("<bearer_token>");
```

##### Cloud Pak for Data
This class helps you authenticate with your services on (Cloud Pak for Data)[https://www.ibm.com/analytics/cloud-pak-for-data).

```java
// constructor with required parameters
Authenticator authenticator = new CloudPakForDataAuthenticator(
  "<url>", 
  "<test_username>",
  "<test_password>"
);
```

There's also another constructor to disable SSL verification or send request headers on the token exchange.

##### IAM
Like the `CloudPakForDataAuthenticator`, there's a basic constructor

```java
Authenticator authenticator = new IamAuthenticator("<token>");
```

and another one to supply additional arguments like a particular token exchange URL, a client ID and secret, and the same options to disable SSL verification and send headers.

##### None
Finally, there's the `NoAuthAuthenticator`, which is pretty self-explanatory. Pass this when you don't need any authentication to happen.

```java
Assistant service = new Assistant("2019-02-28", new NoAuthAuthenticator());
```

#### Supplying credentials

As before, you can supply credentials to your service using external `ibm-credentials.env` files.

```java
Assistant service = new Assistant("2019-02-28");
WorkspaceCollection response = service.listWorkspaces().execute().getResult();
```

##### v7.x.x

Previously we would look for these files first in the system `home` directory, followed by the current project directory.

##### v8.x.x

Now in order to allow developers to have different configurations for each project we look first in the current project directory, followed by the home directory.

#### Setting the service url

##### v7.x.x

For a while now, we've allowed users to set the service URL with `setEndPoint()`:

```java
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .url("<iam_url>")
  .build();
Assistant service = new Assistant("2019-02-28", options);
service.setEndPoint("<service_url>");
```

##### v8.x.x

To align with our other SDKs and be a bit more clear, that method has been renamed to `setServiceUrl()`:

```java
Authenticator authenticator = new IamAuthenticator("<token>");
Assistant service = new Assistant("2019-02-28", authenticator);
service.setServiceUrl("<service_url>");
```

#### More model builders
If you've used the SDK before, you're probably familiar with the use of the builder pattern across the board. With this release, we've tweaked the generation process to capture better which are models that are being constructed to be sent to the service. These are models we'd prefer to have builders, making it easier to put them together.

There are unfortunately a decent number of models which move to this pattern, but it's one we expect to use well into the future. Here's the comprehensive list of models that now use this:

##### Assistant v1
- `CaptureGroup`
- `DialogNodeAction`
- `DialogNodeNextStep`
- `DialogNodeOutputGeneric`
- `DialogNodeOutputModifiers`
- `DialogNodeOutputOptionsElement`
- `DialogNodeOutputOptionsElementValue`
- `DialogNodeOutputTextValuesElement`
- `DialogNodeVisitedDetails`
- `DialogSuggestion`
- `DialogSuggestionValue`
- `LogMessage`
- `Mention`
- `MessageContextMetadata`
- `MessageRequest`
- `RuntimeEntity`
- `RuntimeIntent`
- `WorkspaceSystemSettings`
- `WorkspaceSystemSettingsDisambiguation`
- `WorkspaceSystemSettingsTooling`
##### Assistant v2
- `CaptureGroup`
- `MessageContext`
- `MessageContextGlobal`
- `MessageContextGlobalSystem`
- `MessageContextSkill`
- `MessageInputOptions`
- `RuntimeEntity`
- `RuntimeIntent`
##### Compare and Comply
- `Category`
- `FeedbackDataInput`
- `Label`
- `Location`
- `OriginalLabelsIn`
- `ShortDoc`
- `TypeLabel`
- `UpdatedLabelsIn`
##### Discovery
- `Configuration`
- `Conversions`
- `CredentialDetails`
- `Credentials`
- `Enrichment`
- `EventData`
- `Expansion`
- `Expansions`
- `FontSetting`
- `HtmlSettings`
- `NluEnrichmentConcepts`
- `NluEnrichmentRelations`
- `NormalizationOperation`
- `PdfHeadingDetection`
- `PdfSettings`
- `SegmentSettings`
- `Source`
- `SourceOptions`
- `SourceOptionsBuckets`
- `SourceOptionsFolder`
- `SourceOptionsObject`
- `SourceOptionsSiteColl`
- `SourceOptionsWebCrawl`
- `SourceSchedule`
- `TokenDictRule`
- `TrainingExample`
- `WordHeadingDetection`
- `WordSettings`
- `WordStyle`
- `XPathPatterns`
##### Natural Language Classifier
- `ClassifyInput`
##### Natural Language Understanding
- `MetadataOptions`
- `SyntaxOptionsTokens`
##### Speech to Text
- `CustomWord`
##### Text to Speech
- `Translation`
- `Word`
- `Words`

#### Removed `ContentType` constant from models

Previously, options models which accepted a `contentType` parameter would typically contain a set of constants for possible values. For example:

```java
RecognizeOptions.ContentType.AUDIO_WAV
```

These have been removed. You can use the `HttpMediaType` helper class to achieve the same thing:
```java
// equivalent to above
HttpMediaType.AUDIO_WAV
```

#### Service changes

##### Assistant v1

* `includeCount` is no longer a parameter of the `listWorkspaces()` method
* `includeCount` is no longer a parameter of the `listIntents()` method
* `includeCount` is no longer a parameter of the `listExamples()` method
* `includeCount` is no longer a parameter of the `listCounterexamples()` method
* `includeCount` is no longer a parameter of the `listEntities()` method
* `includeCount` is no longer a parameter of the `listValues()` method
* `includeCount` is no longer a parameter of the `listSynonyms()` method
* `includeCount` is no longer a parameter of the `listDialogNodes()` method
* `valueType` was renamed to `type` in the `createValue()` method
* `newValueType` was renamed to `newType` in the `updateValue()` method
* `nodeType` was renamed to `type` in the `createDialogNode()` method
* `nodeType` was renamed to `type` in the `createDialogNode()` method
* `newNodeType` was renamed to `newType` in the `updateDialogNode()` method
* `ValueType` was renamed to `Type` in the `CreateValue` model
* `NodeType` was renamed to `Type` in the `DialogNode` model
* `ActionType` was renamed to `Type` in the `DialogNodeAction` model
* `SEARCH_SKILL` constant was added to the `DialogNodeOutputGeneric` model
* `QueryType` constants were added to the `DialogNodeOutputGeneric` model
* `queryType` property was added to the `DialogNodeOutputGeneric` model
* `query` property was added to the `DialogNodeOutputGeneric` model
* `filter` property was added to the `DialogNodeOutputGeneric` model
* `discoveryVersion` property was added to the `DialogNodeOutputGeneric` model
* `output` property type was converted from `Map` to `DialogSuggestionOutput` in the `DialogSuggestion` model
* `LogMessage` model no longer has `additionalProperties`
* `DialogRuntimeResponseGeneric` was renamed to `RuntimeResponseGeneric`
* `RuntimeEntity` model no longer has `additionalProperties`
* `RuntimeIntent` model no longer has `additionalProperties`
* `ValueType` was renamed to `Type` in the `Value` model

##### Assistant v2

* `ActionType` was renamed to `Type` in the `DialogNodeAction` model
* `DialogRuntimeResponseGeneric` was renamed to `RuntimeResponseGeneric`

##### Compare Comply v1

* `convertToHtml()` method does not require a `filename` parameter

##### Discovery v1

* `returnFields` was renamed to `xReturn` in the `query()` method
* `loggingOptOut` was renamed to `xWatsonLoggingOptOut` in the `query()` method
* `spellingSuggestions` was added to the `query()` method
* `collectionIds` is no longer a parameter of the `query()` method
* `returnFields` was renamed to `xReturn` in the `QueryNotices()` method
* `loggingOptOut` was renamed to `xWatsonLoggingOptOut` in the `federatedQuery()` method
* `collectionIds` is now required in the `federatedQuery()` method
* `returnFields` was renamed to `xReturn` in the `federatedQuery()` method
* `returnFields` was renamed to `xReturn` in the `federatedQueryNotices()` method
* `enrichmentName` was renamed to `enrichment` in the `Enrichment` model
* `FieldTypeEnumValue` was renamed to `TypeEnumValue` in the `Field` model
* `FieldType` was renamed to `Type` in the `Field` model
* `fieldName` was renamed to `field` in the `Field` model
* `testConfigurationInEnvironment()` method was removed
* `queryEntities()` method was removed
* `queryRelations()` method was removed

##### Language Translator v3

* `defaultModels` was renamed to `xDefault` in the `listModels()` method
* `translationOutput` was renamed to `translation` in the `Translation` model

##### Natural Language Classifier v1

* `metadata` was renamed to `trainingMetadata` in the `createClassifier()` method

##### Speech to Text v1

* `finalResults` was renamed to `xFinal` in the `SpeakerLabelsResult` model
* `finalResults` was renamed to `xFinal` in the `SpeechRecognitionResult` model

##### Visual Recognition v3

* `detectFaces()` method was removed
* `className` was renamed to `xClass` in the `Class` model
* `className` was renamed to `xClass` in the `ClassResult` model
