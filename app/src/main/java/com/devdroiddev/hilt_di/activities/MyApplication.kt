package com.devdroiddev.hilt_di.activities

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Entry-point for hilt all setup, initialization, and code generation process start from there
@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}