plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android") version "2.44" apply false// Исправлено здесь
}

android {
    namespace = "com.loc.mypexelapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.loc.mypexelapp"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
    implementation(libs.androidx.paging.common.android)
    testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)

        // Splashscreen
        implementation(libs.androidx.core.splashscreen)

        //Retrofit
        implementation(libs.retrofit)
        implementation(libs.converter.gson)

        //Coil
        implementation(libs.coil.compose)

        //Room
        var room_version = "2.6.1"
        implementation("androidx.room:room-runtime:$room_version")
        kapt("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:2.6.1")

        val paging_version = "2.1.2"

        implementation("androidx.paging:paging-runtime:$paging_version") // For Kotlin use paging-runtime-ktx

        // alternatively - without Android dependencies for testing
        testImplementation("androidx.paging:paging-common:$paging_version") // For Kotlin use paging-common-ktx

}