plugins {
    id("java")
    id("application")
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
    implementation(projects.sdl)
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

application {
    mainClass = "org.example.TestGameController"
    mainModule = "org.example"
    applicationDefaultJvmArgs = listOf(
        "--enable-preview",
        "-Djava.library.path=C:\\vcpkg\\installed\\x64-windows\\bin",
        "--enable-native-access=jsdl.sdl",
    )
}
