# SpringBoot-RabbitMQApp

RabbitMQApplication using SpringBoot (Java 17)

# Spring Initilizer

The project was generated using the Spring Initializer.
Dependencies:

1. Spring Web
2. Spring for RabbitMQ
3. Spring for RabbitMQ Streams
4. RabbitMQ Java Client (Maven Repositories)

# Manual Configuration

The queues and bindings were created in the RabbiutMQ Console.
Queues:
Direct-Exchange
Fanout-Exchange
Topic-Exchange
Headers-Exchange

# Testing

The testing was done using PostMan. Example for Headers-Exchange:

Select POST request type
URL: http://localhost:8080/api/headers-exchange/messages
Headers: Content-Type: application/json
Body: "raw" "json"
{
"messages": ["Hello RabbitMQ"],
"headers": {
"x-match": "any",
"item1": "tv",
"item2": "tv"
}
}

Example for Topic-Exchange:
Select POST request type
URL: http://localhost:8080/api/topic-exchange/messages?key=mobile.news
Headers: Content-Type: application/json
Body: "raw" "json"
{
"messages": ["Hello RabbitMQ"]
}
