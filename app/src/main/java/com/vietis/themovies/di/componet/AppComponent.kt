package com.vietis.themovies.di.componet

import com.vietis.themovies.Application
import com.vietis.themovies.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidSupportInjectionModule::class, NetworkModule::class)
)
interface AppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}