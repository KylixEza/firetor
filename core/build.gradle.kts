plugins {
    id("java")
    kotlin("jvm") version "1.8.20"
    `maven-publish`
}

group = "com.kylix"
version = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.ktor:ktor-server-core-jvm:2.2.4")
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation("com.google.firebase:firebase-admin:9.1.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.kylix.firetor.core"
            artifactId = "firetor-core"
            version = "0.2.0"
            from(components["java"])
        }
    }
}