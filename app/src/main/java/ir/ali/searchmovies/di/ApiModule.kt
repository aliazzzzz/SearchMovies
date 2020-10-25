package ir.ali.searchmovies.di

import dagger.Module
import dagger.Provides
import ir.ali.searchmovies.data.ApiService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun bindApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}