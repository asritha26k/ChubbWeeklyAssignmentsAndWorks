plugins {
    application
    java
    id("org.sonarqube") version "7.0.1.6134"
}

repositories {
    mavenCentral()
}

dependencies {
    // ✅ Log4j2 dependencies
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")

    // ✅ JUnit dependencies for testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

application {
    // Replace with your actual main class
    mainClass.set("com.example.LoggingExample")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "asritha26k_LoggingApp")
        property("sonar.organization", "asritha26k")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
