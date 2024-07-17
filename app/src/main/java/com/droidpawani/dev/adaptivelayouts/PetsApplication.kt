package com.droidpawani.dev.adaptivelayouts

import android.app.Application
import com.droidpawani.dev.adaptivelayouts.data.AppContainer
import com.droidpawani.dev.adaptivelayouts.data.AppContainerImpl

class PetsApplication : Application() {

    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}