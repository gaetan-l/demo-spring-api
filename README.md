# Minimal rest API with Spring

Minimal working code for a deployable API. With the absolute minimal dependencies possible.

## How to use

- Clone git repository
- Build the .war using `.\gradlew assemble`
- Deploy the .war in the Tomcat webapps folder
- Access http://localhost:8080/demo-spring-api-1.0-SNAPSHOT/api/user, results in a 200/OK response with content "ApiController.getUsers() response" defined in ApiController