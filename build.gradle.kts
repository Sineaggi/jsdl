plugins {
    java
    alias(libs.plugins.buildtools.native) apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

dependencies {
}

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter(libs.versions.junit)
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(22)
    options.compilerArgs.add("--enable-preview")
}
