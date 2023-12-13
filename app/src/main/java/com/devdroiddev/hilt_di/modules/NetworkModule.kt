package com.devdroiddev.hilt_di.modules

import com.devdroiddev.hilt_di.network.StoreApi
import com.devdroiddev.hilt_di.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides // -> This method provides the instance that's why annotated it with @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesStoreApi(retrofit: Retrofit) : StoreApi {
        return retrofit.create(StoreApi::class.java)
    }

}