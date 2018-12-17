object Versions {
    val kotlin = "1.3.11"
    val androidPlugin = "3.2.1"
    val appcompat = "1.1.0-alpha01"
    val constraintLayout = "2.0.0-alpha2"
    val jUnit = "4.12"
    val testRunner = "1.1.1"
    val espressoCore = "3.1.1"
    val material = "1.1.0-alpha02"
    val recyclerView = "1.1.0-alpha01"
    val cardView = "1.0.0"
    val navigation = "1.0.0-alpha08"
    val lifecycle = "2.1.0-alpha01"
    val rxJava = "2.2.2"
    val rxAndroid = "2.1.0"
    val rxKotlin = "2.3.0"
    val koin = "1.0.1"
    val glide = "4.8.0"
    val room = "2.0.0"
    val retrofit = "2.4.0"
    val retrofitRx = "1.0.0"
    val annotation = "1.0.0"
    val logging = "3.9.1"
}

object BuildPlugins {
    val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
}

object Android {
    val minSdk = 15
    val targetSdk = 28
    val applicationId = "com.example.framgianguyenthanhtungh.collapsingtoolbar"
    val versionCode = 1
    val versionName = "1.0"
}

object GradlePlugins {
    val android = "com.android.application"
    val kotlin = "kotlin"
    val kotlinAndroid = "android"
    val kotlinExt = "android.extensions"
    val kotlinApt = "kapt"
    val javaLib = "java-library"
    val androidLib = "com.android.library"
}

object Modules {
    val app = ":app"
}

object AndroidJUnit {
    val runner = "android.support.test.runner.AndroidJUnitRunner"
}

object BuildType {
    val debug = "debug"
    val release = "release"
}

object Libs {
    //TestRunner
    val testRunner = "androidx.test:runner:${Versions.testRunner}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //Kotlin
    val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    //Junit
    val testRunnerJunit = "androidx.test.runner.AndroidJUnitRunner"
    val jUnit = "junit:junit:${Versions.jUnit}"

    //Appcompat
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    //ConstraintLayout
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //Material
    val material = "com.google.android.material:material:${Versions.material}"

    //RecyclerView
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    //CardView
    val cardView = "androidx.cardview:cardview:${Versions.cardView}"

    //Navigation
    val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Lifecycle
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleJava = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    val lifecycleComplier = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    //Rx
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

    //Koin
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    //Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    //Gson
    val gson =  "com.google.code.gson:gson:2.8.2"

    //Retrofit2
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConveter  = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitRx  = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofitRx}"
    val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.logging}"

    //Room
    val roomRunTime  = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler  = "androidx.room:room-compiler:${Versions.room}"
    val roomRx  = "androidx.room:room-rxjava2:${Versions.room}"

    //Annotation
    val annotation =  "androidx.annotation:annotation:${Versions.annotation}"
}
