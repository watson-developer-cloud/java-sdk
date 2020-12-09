# Personality Insights

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>personality-insights</artifactId>
  <version>8.6.3</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:personality-insights:8.6.3'
```

## Usage

Use linguistic analytics to infer personality and social characteristics, including Big Five, Needs, and Values, from text.
Example: Analyze text and get a personality profile using the [Personality Insights][personality_insights] service.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
PersonalityInsights service = new PersonalityInsights("2017-10-13", authenticator);

// Demo content from Moby Dick by Hermann Melville (Chapter 1)
String text = "Call me Ishmael. Some years ago-never mind how long precisely-having "
    + "little or no money in my purse, and nothing particular to interest me on shore, "
    + "I thought I would sail about a little and see the watery part of the world. "
    + "It is a way I have of driving off the spleen and regulating the circulation. "
    + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
    + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
    + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
    + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
    + "principle to prevent me from deliberately stepping into the street, and methodically "
    + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
    + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
    + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
    + "If they but knew it, almost all men in their degree, some time or other, cherish "
    + "very nearly the same feelings towards the ocean with me. There now is your insular "
    + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
    + "it with her surf. Right and left, the streets take you waterward.";

ProfileOptions options = new ProfileOptions.Builder()
  .text(text)
  .build();

Profile profile = service.profile(options).execute().getResult();
System.out.println(profile);
```

[personality_insights]: https://cloud.ibm.com/docs/personality-insights?topic=personality-insights-about
