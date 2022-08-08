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
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/johannessarpola/kt-simple-platform")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("simplePlatform") {
            from(components["javaPlatform"])
        }
    }
}

