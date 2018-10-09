# Language Translator

## Deprecation notice
Language Translator v3 is now available. The v2 Language Translator API will no longer be available after July 31, 2018. To take advantage of the latest service enhancements, migrate to the v3 API. View the [Migrating to Language Translator v3](https://console.bluemix.net/docs/services/language-translator/migrating.html) page for more information.

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>language-translator</artifactId>
  <version>6.8.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:language-translator:6.8.0'
```

## Usage
Select a domain, then identify or select the language of text, and then translate the text from one supported language to another.  
Example: Translate 'hello' from English to Spanish using the [Language Translator][language_translator] service.

```java
LanguageTranslator service = new LanguageTranslator();
IamOptions iamOptions = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(iamOptions);

TranslateOptions translateOptions = new TranslateOptions.Builder()
  .addText("hello")
  .source(Language.ENGLISH)
  .target(Language.SPANISH)
  .build();
TranslationResult translationResult = service.translate(translateOptions).execute();

System.out.println(translationResult);
```

[language_translator]: https://console.bluemix.net/docs/services/language-translator/index.html
