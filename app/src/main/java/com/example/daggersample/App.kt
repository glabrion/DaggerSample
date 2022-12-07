package com.example.daggersample

import android.app.Application
import android.content.Context
import com.example.daggersample.di.AppComponent
import com.example.daggersample.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComp: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComp
    }