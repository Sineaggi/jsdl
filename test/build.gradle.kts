plugins {
    java
    application
    alias(libs.plugins.buildtools.native)
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
    compileOnly("org.graalvm.sdk:nativeimage:23.1.1")
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

graalvmNative {
    binaries {
        named("main") {
            imageName = "my-app"
            mainClass = "org.example.TestGameController"
            // mainClass = "jsdl.nativetest2.main/org.example.nativetest2.TestGameController"
            // mainClass = "jsdl.nativetest.main"
            //buildArgs.add("--module")
            //buildArgs.add("jsdl.nativetest2.main")
            //buildArgs.add("--version")
            //buildArgs.add("-O4")
            buildArgs(
                "-O4",
                "--features=org.example.ForeignRegistrationFeature",
            )
            runtimeArgs(
                "--enable-preview",
                "-Djava.library.path=C:\\vcpkg\\installed\\x64-windows\\bin",
                "--enable-native-access=jsdl.sdl",
            )
        }
        // test {
        //     buildArgs.add("-O0")
        // }
    }
    binaries.all {
        buildArgs.addAll("--verbose", "--enable-preview")
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.javaModuleMainClass = "org.example.TestGameController"
    options.release = 21
    options.compilerArgs = listOf("--enable-preview")
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
