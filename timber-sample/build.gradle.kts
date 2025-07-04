plugins {
  id("com.android.application")
}

android {
  namespace = "com.example.timber"
  compileSdk = libs.versions.compileSdk.get().toInt()

  buildFeatures {
    buildConfig = true
    viewBinding = true
  }

  defaultConfig {
    applicationId = "com.example.timber"
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.compileSdk.get().toInt()
    versionCode = 1
    versionName = "1.0.0"
  }

  lint {
    textReport = true
    disable += listOf("InvalidPackage", "ExpiredTargetSdkVersion")
  }
}

dependencies {
  implementation(project(":timber"))
}
