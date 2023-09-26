package com.example.namoz_vaqti.di

import android.app.Application
import com.example.namoz_vaqti.ui.SplashFragment
import com.example.restaurant_test.di.networkmodule.NetworkModule

import dagger.BindsInstance
import dagger.Component
import uz.demo.dana.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject (fragment : SplashFragment)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    companion object {
        private var instance: AppComponent? = null
        lateinit var application: Application

        fun create(application: Application):AppComponent{
            instance = DaggerAppComponent.factory().create(application)
            return instance!!
        }

        fun get(): AppComponent {
            return requireNotNull(instance) {"AppComponent  must be initialized"}
        }

    }


}