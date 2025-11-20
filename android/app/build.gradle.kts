plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dev.flutter.flutter-gradle-plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "ir.masoodfx.alertx"
    compileSdk = 36       // ارتقا به SDK 36

    defaultConfig {
        applicationId = "ir.masoodfx.alertx"
        minSdk = 21
        targetSdk = 36   // ارتقا به SDK 36
        versionCode = 1
        versionName = "1.0"
    }

    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles("proguard-android.txt")
        }
    }

    // اجازه می‌دهد همه پلاگین‌ها به درستی با Gradle جدید کار کنند
    buildFeatures {
        compose = false
    }
}

flutter {
    source = "../.."
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-messaging")
}
