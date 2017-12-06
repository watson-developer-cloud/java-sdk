# Alchemy Services

## Installation

##### Maven

```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>alchemy</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson.developer_cloud:alchemy:4.1.0'
```

## Alchemy Language

[Alchemy Language][alchemy_language] offers 12 API functions as part of its text analysis service, each of which uses sophisticated natural language processing techniques to analyze your content and add high-level semantic information.

Use the [Sentiment Analysis][sentiment_analysis] endpoint to identify positive/negative sentiment within a sample text document.

```java
AlchemyLanguage service = new AlchemyLanguage();
service.setApiKey("<api_key>");

Map<String,Object> params = new HashMap<String, Object>();
params.put(AlchemyLanguage.TEXT, "IBM Watson won the Jeopardy television show hosted by Alex Trebek");
DocumentSentiment sentiment = service.getSentiment(params).execute();

System.out.println(sentiment);
```

We also offer a cognitive client which makes use of this API to provide enhanced features for applications using our natural language understanding services such as AlchemyLanguage and NaturalLanguageUnderstanding:
https://github.com/watson-developer-cloud/cognitive-client-java

## Alchemy Vision

[Alchemy Vision][alchemy_vision] uses deep learning innovations to understand a picture's content and context. It sees complex visual scenes in their entirety —without needing any textual clues— leveraging a holistic approach to understand the objects, faces, and words in an image.

Example: Extract keywords from an image.

```java
AlchemyVision service = new AlchemyVision();
service.setApiKey("<api_key>");

File image = new File("src/test/resources/alchemy/obama.jpg");
Boolean forceShowAll = false;
Boolean knowledgeGraph = false;
ImageKeywords keywords =  service.getImageKeywords(image, forceShowAll, knowledgeGraph).execute();

System.out.println(keywords);
```

## Alchemy Data News

[Alchemy Data News][alchemy_data_news] indexes 250k to 300k English language news and
blog articles every day with historical search available for the past 60 days.  
Example: Get 7 documents between Friday 28th August 2015 and Friday 4th September 2015.

```java
AlchemyDataNews service = new AlchemyDataNews();
service.setApiKey("<api_key>");

Map<String, Object> params = new HashMap<String, Object>();

String[] fields =
    new String[] {"enriched.url.title", "enriched.url.url", "enriched.url.author",
        "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
        "enriched.url.enrichedTitle.docSentiment"};
params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));
params.put(AlchemyDataNews.START, "1440720000");
params.put(AlchemyDataNews.END, "1441407600");
params.put(AlchemyDataNews.COUNT, 7);

DocumentsResult result = service.getNewsDocuments(params).execute();

System.out.println(result);
```

## Concept Insights

The Concept Insights service has been deprecated, AlchemyLanguage's concept function can be used as a replacement for most Concept Insights use cases; therefore, we encourage existing Concept Insights service users to migrate to AlchemyLanguage.

[alchemy_language]: http://www.alchemyapi.com/products/alchemylanguage
[alchemy_data_news]: http://www.alchemyapi.com/products/alchemydata-news
[alchemy_vision]: http://www.alchemyapi.com/products/
[sentiment_analysis]: http://www.alchemyapi.com/products/alchemylanguage/sentiment-analysis
