package ir.ali.searchmovies.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.ali.searchmovies.ui.search.SearchFragment


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment() : SearchFragment
}