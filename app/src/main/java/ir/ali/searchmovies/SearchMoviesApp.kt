package ir.ali.searchmovies

import android.app.Application
import ir.ali.searchmovies.di.apiModule
import ir.ali.searchmovies.di.appModule
import ir.ali.searchmovies.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class SearchMoviesApp : Application() {
    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidContext(this@SearchMoviesApp)
            modules(appModule, networkModule, apiModule)
        }
    }
}