plugins {
    `java-library`
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
    // options.compilerArgs.add("--enable-preview")
}

val deleteGeneratedSources = tasks.register<Delete>("delete") {
    delete(layout.projectDirectory.dir("src/main/java/sdl/jextract"))
}

tasks.register<JavaExec>("generate") {
    executable(file(System.getProperty("user.home")).resolve("Source\\jextract\\build\\jextract\\bin\\java.exe").absolutePath)
    mainModule = "org.openjdk.jextract/org.openjdk.jextract.JextractTool"
    // errorOutput = System.err
    // standardOutput = System.err
    args(
        // "--help",
        "sdl.h",
        "--source",
        "--target-package", "sdl.jextract",
        // "--dump-includes", "${layout.projectDirectory.file("sdl.full.symbols")}",
        "@${layout.projectDirectory.file("sdl.symbols")}",
        "-I", "C:\\vcpkg\\installed\\x64-windows\\include",
        //"-D", "WIN32_LEAN_AND_MEAN",
        "-D", "__INTRIN_H_",
        "-D", "__INTRIN_H",
        "--output", layout.projectDirectory.dir("src/main/java").toString(),
        "-l", "SDL2",
    )
    dependsOn(deleteGeneratedSources)
}
