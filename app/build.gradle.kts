import com.google.protobuf.gradle.*

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT)
    id(Plugins.KOTLIN_ANDROID_EXTENSIONS)
    id(Plugins.APOLLO).version(Version.APOLLO)
    kotlin(Plugins.KOTLIN_SERIALIZATION).version(Version.SERIALIZATION_PLUGIN)
    id("com.google.protobuf") version "0.8.18"

}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AndroidConfig.APP_ID
        minSdk = AndroidConfig.MIN_SDK_VERSION
        targetSdk = AndroidConfig.TARGET_SDK_VERSION
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    apollo {
        // generate Kotlin models
        generateKotlinModels.set(true)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.google.protobuf:protobuf-javalite:3.18.0")
    androidX()
    compose()
    coroutines()
    hilt()
    apollo()
    coil()
    serialization()
//    moshi()
    dataStore()
    joda()
    featureModules()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.14.0:osx-x86_64"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins{
                create("java") {
                    option("lite")
                }
            }
        }
    }
}