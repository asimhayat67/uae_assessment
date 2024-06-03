// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    alias(libs.plugins.daggerHiltModule) apply false


}

buildscript {
    repositories {
        // ... (existing repositories)
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")

    }
}