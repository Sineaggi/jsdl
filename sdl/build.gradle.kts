plugins {
    id("java")
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

val deleteGeneratedSources = tasks.register<Delete>("delete") {
    delete(layout.projectDirectory.dir("src/main/java/sdl"))
}

tasks.register<JavaExec>("generate") {
    executable(file(System.getProperty("user.home")).resolve("Source\\jextract\\build\\jextract\\bin\\java.exe").absolutePath)
    mainModule = "org.openjdk.jextract/org.openjdk.jextract.JextractTool"
    // errorOutput = System.err
    // standardOutput = System.err
    args(
        // "--help",
        "C:\\vcpkg\\installed\\x64-windows\\include\\SDL2\\SDL_gamecontroller.h",
        "--source",
        "--target-package", "sdl",
        // "--dump-includes", "${layout.projectDirectory.file("sdl.full.symbols")}",
        "@${layout.projectDirectory.file("sdl.symbols")}",
        "-I", "C:\\vcpkg\\installed\\x64-windows\\include",
        "--output", layout.projectDirectory.dir("src/main/java/").toString(),
        "-l", "sdl",
    )
    dependsOn(deleteGeneratedSources)
}
