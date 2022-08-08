# Simple platform

This is here to test the platform with Github Packages. 

This only contains the Apache HTTP Components dependencies with centrally controller dependencies and is published with
maven-publish plugin which works with java-platform plugin.

```
plugins {
    `java-platform`
    `maven-publish`
}
```

With following configuration 

```
    publications {
        create<MavenPublication>("<platformName>") {
            from(components["javaPlatform"])
        }
    }
```

```
    constraints {
        api("org.apache.httpcomponents:httpclient:4.5.12")
        api("org.apache.httpcomponents:httpcore:4.4.15")
        api("org.apache.logging.log4j:log4j-core:2.18.0")
    }
```

Platform can be used in another project with. 

```
    api(platform("fi.johannes:kt-simple-platform:<version>"))
    api("org.apache.httpcomponents:httpclient")
```

Due note that consumers can use version > the one defined in this platform but can't go lower(?).