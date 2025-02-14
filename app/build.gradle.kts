import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id ("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.appbajopruebas.vinilos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.appbajopruebas.vinilos"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    java { toolchain.languageVersion.set(JavaLanguageVersion.of(17)) }


    dependencies {

        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.8.0")
        implementation(platform("androidx.compose:compose-bom:2023.10.01"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
        implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
        implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
        implementation("com.google.android.material:material:1.5.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("androidx.gridlayout:gridlayout:1.0.0")
        implementation("com.android.volley:volley:1.2.1")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.google.code.gson:gson:2.8.2")
        implementation("com.squareup.retrofit2:converter-gson:2.3.0")
        implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
        implementation("com.github.bumptech.glide:glide:4.12.0")
        implementation("com.github.bumptech.glide:glide:4.8.0")
        implementation("androidx.room:room-runtime:2.4.0")
        kapt("androidx.room:room-compiler:2.4.0")
        implementation("androidx.room:room-ktx:2.4.0")
        implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
        annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation("androidx.test:core:1.4.0")
        androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-test-manifest")

    }

    tasks.withType<Test> {
        testLogging {
            events(
                TestLogEvent.STARTED,
                TestLogEvent.FAILED,
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.STANDARD_ERROR,
                TestLogEvent.STANDARD_OUT
            )
            exceptionFormat = TestExceptionFormat.FULL
            showStandardStreams = true; showCauses = true; showExceptions = true; showStackTraces =
            true
            debug {
                events(
                    TestLogEvent.STARTED,
                    TestLogEvent.FAILED,
                    TestLogEvent.PASSED,
                    TestLogEvent.SKIPPED,
                    TestLogEvent.STANDARD_ERROR,
                    TestLogEvent.STANDARD_OUT
                )
                exceptionFormat = TestExceptionFormat.FULL
                showStandardStreams = true; showCauses = true; showExceptions =
                true; showStackTraces = true
            }
        }
    }
}
