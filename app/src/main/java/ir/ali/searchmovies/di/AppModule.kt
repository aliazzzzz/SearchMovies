package ir.ali.searchmovies.di

import ir.ali.searchmovies.data.MovieRepository
import ir.ali.searchmovies.data.mapper.SearchMovieMapper
import ir.ali.searchmovies.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { SearchMovieMapper() }
    single { MovieRepository(get(), get()) }
    viewModel { SearchViewModel(get()) }
}