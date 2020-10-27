package ir.ali.searchmovies.di

import ir.ali.searchmovies.data.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { bindApiService(get()) }
}

fun bindApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}