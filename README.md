# Roulette

> Roulette is a casino game named after the French word meaning little wheel. In the game, players may choose to place bets on either a single number, various groupings of numbers, the colors red or black, whether the number is odd or even, or if the numbers are high (19–36) or low (1–18)

This is integrated with Travis for Continuous integration
### CI Status
[![Build Status](https://travis-ci.org/KushalRaichura/roulette.svg?branch=master)](https://travis-ci.org/KushalRaichura/roulette)

## API
- /roulette/v1/placeBet
- /actuator/health - This can be used to check application health. This is provided by SpringBoot out of the box as we have added 'spring-boot-starter-actuator' dependency

## Prerequisites
- Java8
- Maven 3.X
- Editor of your choice (Intellij, Eclipse, etc)
- Internet connectivity to download dependency artifacts from maven repo

## Getting Started
- Clone this project on your system and import using maven. If this is the first time you are importing project, it will take a while to download all dependenies from maven repo
- Once project has been imported you can simply run RouletteApplication.java and start accessing end points
- Alternatively you can run maven command (mvn clean install) to generate artifact (jar) and execute 
java -jar target/roulette-0.0.1-SNAPSHOT.jar (update version as required)
  

## Example
- Sample json requests are available under /src/main/resources/postman. You would need a postman plugin/application. You can simply use import postman collection and get started. 
- Sample jmx file is also available under /src/main/resources/postman. This can be used as a baseline and further extended to perform load test using Jmeter


## TODO
- Implement additional bet validation
- Add more unit tests
- Update logging configuration to redirect logs to files
- Implement logging using AOP
- Secure endpoint
- Implement custom annotation to identify Bet types and use annotations to register bet types as JsonSubTypes of Bet
- Implement Swagger
- Externalize values of bean properties wherever required
- Configure maven release plugin
- Check system performance using Jconsole/Jprofiler
