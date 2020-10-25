package ir.ali.searchmovies

import android.app.Application
import ir.ali.searchmovies.di.DaggerAppComponent

class SearchMoviesApp: Application() {

    val appComponent = DaggerAppComponent.create()
}