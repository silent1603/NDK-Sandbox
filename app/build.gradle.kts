plugins {

    alias(libs.plugins.android.application)
}

android {
    namespace = "com.et.ndk_sandbox"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.et.ndk_sandbox"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
                arguments += "-DANDROID_STL=c++_shared"
            }
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
    buildFeatures {
        prefab = true
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}



dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime:2.2.0")
    implementation("androidx.core:core:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.fragment:fragment:1.2.5")
    implementation("com.google.oboe:oboe:1.5.0" )
    implementation("androidx.games:games-frame-pacing:2.0.0")
    implementation("androidx.games:games-performance-tuner:1.5.0")
    implementation("androidx.games:games-activity:2.0.2")
    implementation("androidx.games:games-controller:2.0.0")

    // Dependency for using APIs wrapped using library wrapper
    implementation("com.google.android.gms:play-services-gni-native-c:1.0.0-beta2")

    // Google Play Games dependencies
    implementation("com.google.android.gms:play-services-games-v2:17.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.games.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}