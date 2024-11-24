plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.perfumery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.perfumery"
        minSdk = 30
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
}

dependencies {
    // Core Libraries
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.activity)
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler) // Correct syntax for annotationProcessor


    implementation(libs.material)             // Use this OR:
    //implementation(libs.materialBeta)       // Uncomment if using the beta version

    //Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Additional Libraries
    implementation(libs.glide)
    implementation(libs.gson)
}