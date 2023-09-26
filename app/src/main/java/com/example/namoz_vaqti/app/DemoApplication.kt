package com.example.namoz_vaqti.app

import android.app.Application
import com.example.namoz_vaqti.data.common.MySettings
import com.example.namoz_vaqti.di.AppComponent

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.create(this)
        MySettings.setContext(this)
    }
}