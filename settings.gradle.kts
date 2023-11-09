pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(
    "sdl",
    "test",
)

project(":sdl").name = "sdl"
project(":test").name = "test"

rootProject.name = "jsdl"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
