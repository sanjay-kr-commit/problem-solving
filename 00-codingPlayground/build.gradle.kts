plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // https://mvnrepository.com/artifact/org.jsoup/jsoup
    implementation("org.jsoup:jsoup:1.17.2")
    // https://mvnrepository.com/artifact/com.squareup.okhttp/okhttp
    implementation("com.squareup.okhttp:okhttp:2.7.5")
    // https://mvnrepository.com/artifact/khttp/khttp
   // runtimeOnly("khttp:khttp:1.0.0")



}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}