package ir.ali.searchmovies.di

import ir.ali.searchmovies.data.MovieRepository
import ir.ali.searchmovies.data.mapper.MovieMapper
import ir.ali.searchmovies.ui.details.DetailsViewModel
import ir.ali.searchmovies.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MovieMapper() }
    single { MovieRepository(get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailsViewModel(get())}
}