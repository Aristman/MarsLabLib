// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    // плагин для автоматизации публикации нашей либы
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

apply {
    from("$rootDir/scripts/publish-root.gradle")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
