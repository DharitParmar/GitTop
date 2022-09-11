package deps

object Names {
    const val applicationId = "com.example.githubstar"
}

object Versions {

    // Application
    const val buildToolsVersion = "33.0.0"
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33

    // MajorVersion.MinorVersion.HotFix
    const val appVersionName = "1.0.0"

    // JVM
    const val jvmTarget = "11"

    // Android
    const val gradle = "7.2.2"
    const val uiAutomator = "2.1.3"

    // Androidx
    const val activity = "1.5.1"
    const val appcompat = "1.5.0"
    const val browser = "1.4.0"
    const val compose = "1.2.1"
    const val composeCompiler = "1.3.0"
    const val constraintLayout = "2.1.4"
    const val coreKtx = "1.8.0"
    const val datastore = "1.0.0"
    const val espresso = "3.4.0"
    const val ext = "1.1.3"
    const val fragment = "1.5.2"
    const val hiltCompiler = "1.0.0"
    const val lifecycle = "2.5.1"
    const val navigation = "2.5.1"
    const val orchestrator = "1.2.0"
    const val preferences = "1.2.0"
    const val room = "2.4.3"
    const val runner = "1.4.0"
    const val rules = "1.4.0"
    const val supportV4 = "1.0.0"
    const val testCore = "1.4.0"
    const val viewPager2 = "1.0.0"
    const val webkit = "1.3.0"
    const val workManager = "2.7.1"

    // Coil
    const val coil = "2.2.0"

    // Dagger
    const val hilt = "2.43.2"

    // Google
    const val material = "1.6.1"

    // JUnit
    const val junit = "5.9.0"

    // Kotlin
    const val android = "1.5.31"
    const val coroutines = "1.6.4"
    const val kotlin = "1.7.10"

    // Mockk
    const val mockk = "1.12.7"

    // Squareup
    const val leakCanary = "2.9.1"
    const val moshi = "1.13.0"
    const val okhttp = "4.10.0"
    const val retrofit = "2.9.0"

    // Timber
    const val timber = "5.0.1"
}

object Libraries {

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    object Android {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val uiAutomator =
            "com.android.support.test.uiautomator:uiautomator-v18:${Versions.uiAutomator}"
    }

    object Androidx {

        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val browser = "androidx.browser:browser:${Versions.browser}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
        const val legacySupportV4 = "androidx.legacy:legacy-support-v4:${Versions.supportV4}"
        const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
        const val webKit = "androidx.webkit:webkit:${Versions.webkit}"

        object Activity {
            const val compose = "androidx.activity:activity-compose:${Versions.activity}"
            const val ktx = "androidx.activity:activity-ktx:${Versions.activity}"
        }

        object Compose {
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val runtime = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val uiToolingPreview =
                "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
            const val uiUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
        }

        object DataStore {
            const val datastore = "androidx.datastore:datastore:${Versions.datastore}"
            const val preferences = "androidx.datastore:datastore-preferences:${Versions.datastore}"
        }

        object Lifecycle {

            const val compose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        }

        object Navigation {

            const val compose = "androidx.navigation:navigation-compose:${Versions.navigation}"
            const val fragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val safeArgsPlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
            const val safeArgsPluginId = "androidx.navigation.safeargs.kotlin"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }

        object Preference {

            const val ktx = "androidx.preference:preference-ktx:${Versions.preferences}"
            const val preference = "androidx.preference:preference:${Versions.preferences}"
        }

        object Room {

            const val runtime = "androidx.room:room-runtime:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
            const val ktx = "androidx.room:room-ktx:${Versions.room}"
            const val test = "androidx.room:room-testing:${Versions.room}"
        }

        object Test {

            const val core = "androidx.test:core:${Versions.testCore}"
            const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
            const val ext = "androidx.test.ext:junit:${Versions.ext}"
            const val orchestrator = "androidx.test:orchestrator:${Versions.orchestrator}"
            const val rules = "androidx.test:rules:${Versions.rules}"
            const val runner = "androidx.test:runner:${Versions.runner}"
            const val runnerJUnit = "androidx.test.runner.AndroidJUnitRunner"
        }

        object WorkManager {

            const val runtimeKtx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
            const val multiprocess = "androidx.work:work-multiprocess:${Versions.workManager}"
            const val test = "androidx.work:work-testing:${Versions.workManager}"
        }
    }

    object Google {

        const val applicationPlugin = "com.android.application"
        const val library = "com.android.library"
        const val material = "com.google.android.material:material:${Versions.material}"

        object Kotlin {

            const val androidPlugin = "kotlin-android"
            const val parcelizePlugin = "kotlin-parcelize"
            const val kaptPlugin = "kotlin-kapt"
            const val jetbrainsKotlinAndroidPlugin = "org.jetbrains.kotlin.android"
        }

        object Hilt {
            const val pluginId = "dagger.hilt.android.plugin"
            const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
            const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        }
    }

    object JUnit {

        const val api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
        const val params = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    }

    object Kotlin {
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val reflect = "\"org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}\"org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
        const val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

        object Coroutine {
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        }
    }

    object Squareup {

        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

        object Moshi {

            const val adapter = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
            const val kotlin = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
            const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        }

        object OkHttp {

            const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
            const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
            const val urlConnection = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp}"
            const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
        }

        object Retrofit {

            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
            const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
            const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        }
    }
}
