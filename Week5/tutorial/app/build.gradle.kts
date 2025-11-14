plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("log4j:log4j:1.2.17")       // Log4j 1.x
    testImplementation("junit:junit:4.13.2")   // JUnit 4 for tests
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

application {
    mainClass.set("org.example.App") // <-- use your actual main class
}
