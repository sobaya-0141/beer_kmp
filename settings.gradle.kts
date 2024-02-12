enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "beer_kmp"
include(":core")

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
include(":androidbeer")
