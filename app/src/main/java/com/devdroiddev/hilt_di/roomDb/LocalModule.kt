package com.devdroiddev.hilt_di.roomDb

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(context,
            AppDatabase::class.java
            ,"Product_Db").build()
    }

    @Singleton
    @Provides
    fun provideProductDao(appDatabase: AppDatabase) : ProductDao {
        return appDatabase.productDao()
    }
}