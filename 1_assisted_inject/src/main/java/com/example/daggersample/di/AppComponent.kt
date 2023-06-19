package com.example.daggersample.di

import com.example.daggersample.MainActivity
import com.example.daggersample.screens.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)
}