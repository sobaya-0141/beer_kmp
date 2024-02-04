enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "beer_kmp"
include(":core")
includeBuild("convention-plugins")

pluginManagement {
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
