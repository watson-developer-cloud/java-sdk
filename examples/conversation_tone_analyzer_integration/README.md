# Conversation and Tone Analyzer Integration Example

This example provides sample code for integrating [Tone Analyzer][tone_analyzer] and [Conversation][conversation].

  * [ToneDetection.java][tone_conversation_integration_example_tone_detection] - sample code to initialize a user object in the conversation payload's context (initUser), to call Tone Analyzer to retrieve tone for a user's input (invokeToneAsync), and to update tone in the user object in the conversation payload's context (updateUserTone).

  * [ToneConversationIntegrationV1.java][tone_conversation_integration_example] - sample code to use ToneDetection.java to add tone to the payload and send a request to the Conversation Service's message endpoint in an asynchronous manner.


Requirements to run the sample code

  * [Tone Analyzer Service credentials][bluemix_tone_analyzer_service]
  * [Conversation Service credentials][bluemix_conversation_service]
  * [Conversation Workspace ID][conversation_simple_workspace]

Credentials & the Workspace ID can be set in a properties, tone_conversation_integration.properties, or directly in the code.

Dependencies provided in 
`build.gradle`

## To run the example

To run the code, use the provided [gradle](http://gradle.org/) build file and wrapper configuration.

On Mac or Linux:

    ./gradlew run


[conversation]: https://console.bluemix.net/docs/services/conversation/index.html
[tone_analyzer]: https://console.bluemix.net/docs/services/tone-analyzer/index.html
[bluemix_conversation_service]: https://console.ng.bluemix.net/catalog/services/conversation/
[bluemix_tone_analyzer_service]: https://console.ng.bluemix.net/catalog/services/tone-analyzer/
[conversation_simple_workspace]: https://github.com/watson-developer-cloud/conversation-simple#workspace
[tone_conversation_integration_example]: https://github.com/aprilwebster/java-sdk/blob/master/examples/java/com/ibm/watson/developer_cloud/conversation_tone_analyzer_integration/src/main/java/com/ibm/watson/developer_cloud/conversation_tone_analyzer_integration/v1/ToneConversationIntegrationV1.java
[tone_conversation_integration_example_tone_detection]: https://github.com/aprilwebster/java-sdk/blob/master/examples/java/com/ibm/watson/developer_cloud/conversation_tone_analyzer_integration/src/main/java/com/ibm/watson/developer_cloud/conversation_tone_analyzer_integration/v1/ToneDetection.java 