package ir.ali.searchmovies.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.ali.searchmovies.ui.details.DetailsFragment
import ir.ali.searchmovies.ui.search.SearchFragment


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment() : SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailsFragment() : DetailsFragment
}