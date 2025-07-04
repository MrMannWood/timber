import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
  }

  dependencies {
    classpath(libs.gradlePlugin.android)
    classpath(libs.gradlePlugin.kotlin)
    classpath(libs.gradlePlugin.japicmp)
    classpath(libs.gradlePlugin.mavenPublish)
    classpath(libs.gradlePlugin.dokka)
  }
}

subprojects {
  repositories {
    mavenCentral()
    google()
  }

  tasks.withType<Test>().configureEach {
    testLogging {
      events("failed")
      exceptionFormat = TestExceptionFormat.FULL
      showExceptions = true
      showStackTraces = true
      showCauses = true
    }
  }
}
