import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id(GradlePlugins.android)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinExt)
    kotlin(GradlePlugins.kotlinApt)
}

android {
    compileSdkVersion(Android.targetSdk)
    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = Libs.testRunnerJunit
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.openweathermap.org/data/2.5/\"")
            buildConfigField ("String", "API_KEY", "\"f379cbdb9874a4eb73071829c180eea1\"")
        }

        getByName(BuildType.debug) {
            buildConfigField("String", "BASE_URL", "\"https://api.openweathermap.org/data/2.5/\"")
            buildConfigField ("String", "API_KEY", "\"f379cbdb9874a4eb73071829c180eea1\"")
        }
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

androidExtensions {
    configure(delegateClosureOf<AndroidExtensionsExtension> {
        isExperimental = true
    })
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //KotlinLib
    implementation(Libs.kotlinJDK)

    //Appcompat
    implementation(Libs.appcompat)

    //ConstraintLayout
    implementation(Libs.constraintLayout)

    //Test
    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.testRunner)
    androidTestImplementation(Libs.espressoCore)

    //Material
    implementation(Libs.material)

    //RecyclerView
    implementation(Libs.recyclerView)

    //CardView
    implementation(Libs.cardView)

    //Navigation
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    //Lifecycle
    implementation(Libs.lifecycleJava)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.lifecycleExtensions)
    kapt(Libs.lifecycleComplier)

    //Rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)
    implementation(Libs.rxKotlin)

    //Koin
    implementation(Libs.koinAndroid)
    implementation(Libs.koinCore)
    implementation(Libs.koinViewModel)

    //Glide
    implementation(Libs.glide)

    //Gson
    implementation(Libs.gson)

    //Retrofit2
    implementation(Libs.retrofit)
    implementation(Libs.retrofitConveter)
    implementation(Libs.retrofitRx)
    implementation(Libs.logging)

    //Room
    implementation(Libs.roomRx)
    implementation(Libs.roomRunTime)
    kapt(Libs.roomCompiler)

    //Annotation
    implementation(Libs.annotation)
}
