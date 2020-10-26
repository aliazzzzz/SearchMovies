package ir.ali.searchmovies.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.ali.searchmovies.SearchMoviesApp
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApiModule::class,
    ViewModelModule::class,
    AndroidSupportInjectionModule::class,
    FragmentBuildersModule::class
])
interface AppComponent : AndroidInjector<SearchMoviesApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }
}