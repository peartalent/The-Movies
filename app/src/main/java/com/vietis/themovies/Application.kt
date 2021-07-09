package com.vietis.themovies

import com.vietis.themovies.di.componet.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .build()
}