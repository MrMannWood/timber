plugins {
  id("org.jetbrains.kotlin.jvm")
  id("org.jetbrains.kotlin.kapt")
  id("com.android.lint")
}

kotlin {
  jvmToolchain(17)
}

lint {
  baseline = file("lint-baseline.xml")
}

dependencies {
  compileOnly(libs.lint.api)
  compileOnly(libs.lint.checks)
  compileOnly(libs.auto.annotations)
  kapt(libs.auto.service)
  testImplementation(libs.junit)
  testImplementation(libs.lint.core)
  testImplementation(libs.lint.tests)
  testImplementation(libs.junit)
}
