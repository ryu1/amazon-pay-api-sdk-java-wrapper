plugins {
    id("java")
    id("maven-publish")
    `java-library`
}

group = "com.amazon.pay.api.wrapper"
version = System.getenv("RELEASE_VERSION")


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


repositories {
    mavenCentral()
}

dependencies {
    api("software.amazon.pay:amazon-pay-api-sdk-java:2.3.3")
    api("org.apache.commons:commons-lang3:3.13.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.amazon.pay.api.wrapper"
            artifactId = "amazon-pay-api-sdk-java-wrapper"
            version = System.getenv("RELEASE_VERSION")

            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ryu1/amazon-pay-api-sdk-java-wrapper")
            credentials {
                username = System.getenv("GITHUB_PACKAGE_USER_NAME")
                password = System.getenv("GITHUB_PACKAGE_TOKEN")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}