buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath (BuildPlugins.androidPlugin)
        classpath (Libs.kotlinPlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
