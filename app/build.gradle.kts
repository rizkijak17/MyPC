plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.mypc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mypc"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true // Tetap aktifkan jika Anda membutuhkan ViewBinding
    }
}

dependencies {
    // Material Design 2
    implementation("com.google.android.material:material:1.9.0")

    // AppCompat dan ConstraintLayout
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Kotlin Standard Library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    // Lottie Splash Screen
    implementation ("com.airbnb.android:lottie:5.0.3")

    implementation ("androidx.recyclerview:recyclerview:1.2.0")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
