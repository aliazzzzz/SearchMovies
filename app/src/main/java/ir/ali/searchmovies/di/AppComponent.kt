package ir.ali.searchmovies.di

import dagger.Component
import ir.ali.searchmovies.view.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}