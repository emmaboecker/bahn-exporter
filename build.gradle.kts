import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    application
}

group = "net.stckoverflw"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.opennms.org/content/groups/opennms.org-release")
}

dependencies {
    val ktorVersion = "2.1.2"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    implementation("com.influxdb:influxdb-client-kotlin:6.0.0")
    implementation("dev.inmo:krontab:0.7.2")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("io.github.microutils:kotlin-logging:2.1.23")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("net.stckoverflw.bahnexporter.MainKt")
}