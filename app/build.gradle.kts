plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)


    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.prabhat.introduction"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.prabhat.introduction"
        minSdk = 26
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dagger Hilt
 /*   implementation ("com.google.dagger:hilt-android:2.51.1")
//    kapt ("com.google.dagger:hilt-compiler:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
//    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

//    ksp("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")*/


    implementation ("com.google.dagger:hilt-android:2.50")
//    kapt ("com.google.dagger:hilt-compiler:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")



    //Room
  /*  implementation ("androidx.room:room-ktx:$room_version")
    implementation ("androidx.room:room-runtime:$room_version")
    ksp ("androidx.room:room-compiler:$room_version")*/

    // ViewModel
  /*  implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"*/


    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")



    //kotlin Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // android ktx
    implementation ("androidx.activity:activity-ktx:1.9.0")

    //hilt viewmodel
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    //pager
  /*  implementation ("com.google.accompanist:accompanist-pager:$accompanist_version")
    implementation ("com.google.accompanist:accompanist-pager-indicators:$accompanist_version")*/

    //navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")


}