package com.example.githubstar

import android.app.*
import androidx.viewbinding.*
import dagger.hilt.android.*
import timber.log.*

@HiltAndroidApp
class GitStarApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}