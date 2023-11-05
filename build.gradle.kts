plugins {
    java
    id("org.graalvm.buildtools.native") version "0.9.28" apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
//     testImplementation(platform("org.junit:junit-bom:5.10.0"))
//     testImplementation("org.junit.jupiter:junit-jupiter")
}

// tasks.test {
//     useJUnitPlatform()
// }

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter(libs.versions.junit)
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
    options.compilerArgs.add("--enable-preview")
}
