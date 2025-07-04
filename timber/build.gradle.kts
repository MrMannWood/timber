plugins {
  id("org.jetbrains.kotlin.multiplatform")
  id("com.android.library")
  id("com.vanniktech.maven.publish")
  id("org.jetbrains.dokka") // Must be applied here for publish plugin.
}

kotlin {
  androidTarget()
  jvmToolchain(17)
}

android {
  namespace = "timber.log"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()
    consumerProguardFiles("consumer-proguard-rules.pro")
  }

  lint {
    textReport = true
  }
}

dependencies {
  implementation(libs.annotations)

  testImplementation(libs.annotations)
  testImplementation(libs.junit)
  testImplementation(libs.truth)
  testImplementation(libs.robolectric)

  lintPublish(project(":timber-lint"))
}
