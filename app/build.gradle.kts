plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.linecorp.roomcodelab"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
                arg("room.incremental", "true")
                arg("room.expandProjection", "true")
            }
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.activity:activity-ktx:1.2.2")

    // Dependencies for working with Architecture components
    // You'll probably have to update the version numbers in build.gradle (Project)

    // Room components
    implementation("androidx.room:room-ktx:2.2.6")
    kapt("androidx.room:room-compiler:2.2.6")
    androidTestImplementation("androidx.room:room-testing:2.2.5")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1")

    // Kotlin components
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.google.android.material:material:1.3.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.ext:junit:4.13.1")
}