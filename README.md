# Minimal REST API with Spring (without Boot)

Minimal working code for a deployable API, with the absolute minimal dependencies possible. The Tomcat dependencies and the Application class can even be removed if you are using your own external Tomcat and don't need the embedded one.

## Environment used

- Java 20
- [IntelliJ Idea 2023.2.2 Community Edition](https://www.jetbrains.com/idea/download/)
- Gradle 8.3 (Version 8.3 is required to work with Java 20, by default, ItelliJ included version 8.2, to upgrade to 8.3, use the following command in a terminal: `.\gradlew wrapper --gradle-version 8.3`)
- Dependencies required
  - [org.springframework:spring-webmvc:6.0.12](https://mvnrepository.com/artifact/org.springframework/spring-webmvc)
  - [jakarta.servlet:jakarta.servlet-api:6.0.0](https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api)
- Dependencies for embedded Tomcat
  - [org.apache.tomcat.embed:tomcat-embed-core:10.1.13](https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-core) (Using version 10 as version 11 is meant to work with Java 21)
  - [org.apache.tomcat:tomcat-jasper:10.1.13](https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper)

## How to use

1. Clone git repository
2. Build the .war using `.\gradlew assemble`
3. From there you can
   1. Run `Application.main()` directly in your IDE, the embedded Tomcat will look for the `demo-spring-api-1.0-SNAPSHOT.war` previously built in the `./build/libs` folder and deploy it in the `./tomcat.8080/work/Tomcat/localhost` folder then run on `localhost:8080`
   2. Deploy the `demo-spring-api-1.0-SNAPSHOT.war` manually in your own external Tomcat webapps folder then run Tomcat
4. Access http://localhost:8080/demo-spring-api-1.0-SNAPSHOT/api/user, results in a `200/OK` response with content `ApiController.getUsers() response` as defined in `ApiController`