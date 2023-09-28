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
}