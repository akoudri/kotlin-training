plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.akfc.training"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.21")
    implementation("org.xerial:sqlite-jdbc:3.46.1.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}