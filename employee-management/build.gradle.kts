plugins {
    id("java")
    id("war")
}

repositories {
    mavenCentral()
}

dependencies {
// https://mvnrepository.com/artifact/javax/javaee-api
    compileOnly("javax:javaee-api:7.0")
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}
