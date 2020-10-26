package ir.ali.searchmovies

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.ali.searchmovies.di.DaggerAppComponent

class SearchMoviesApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}