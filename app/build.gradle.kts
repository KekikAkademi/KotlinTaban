plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace  = "com.keyiflerolsun.kekiktaban"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.keyiflerolsun.kekiktaban"
        minSdk    = 21
        targetSdk = 33

        versionCode = 1
        versionName = "0.1"
    }

    signingConfigs {
        create("release") {
            storeFile     = file("../Kekik.keystore")
            storePassword = "123456"
            keyAlias      = "key0"
            keyPassword   = "123456"
        }
    }

    buildTypes {
        release {
            isDebuggable      = false
            isMinifyEnabled   = false
            isShrinkResources = false
            signingConfig     = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget        = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.github.Blatzar:NiceHttp:0.4.4")                 // HTTP
}

tasks.register("androidSourcesJar", Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}