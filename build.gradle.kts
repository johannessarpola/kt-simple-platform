plugins {
    `java-platform`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        api("commons-httpclient:commons-httpclient:3.1")
        api("org.apache.logging.log4j:log4j-core:2.18.0")
    }
}


publishing {
    publications {
        create<MavenPublication>("simplePlatform") {
            from(components["javaPlatform"])
        }
    }
}

