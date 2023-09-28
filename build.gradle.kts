plugins {
    id("java")
    id("war")
}

group = "gaetanl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webmvc:6.0.12")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // TOMCAT
    // Careful with the chosen version of Tomcat,
    // Version 10 is compiled with/for Java 20,
    // Version 11 is compiled with/for java 21
    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.13")
    implementation("org.apache.tomcat:tomcat-jasper:10.1.13")
}