# Language Translator

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>language-translator</artifactId>
  <version>12.0.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:language-translator:12.0.0'
```

## Usage

Select a domain, then identify or select the language of text, and then translate the text from one supported language to another.  
Example: Translate 'hello' from English to Spanish using the [Language Translator][language_translator] service.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
LanguageTranslator service = new LanguageTranslator("2018-05-01", authenticator);

TranslateOptions translateOptions = new TranslateOptions.Builder()
  .addText("hello")
  .source(Language.ENGLISH)
  .target(Language.SPANISH)
  .build();
TranslationResult translationResult = service.translate(translateOptions).execute().getResult();

System.out.println(translationResult);
```

[language_translator]: https://cloud.ibm.com/docs/language-translator?topic=language-translator-about
