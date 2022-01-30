package com.example.myapplication.root.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.root.local.BlogDataBase
import com.example.myapplication.root.local.BlogDio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponentManager::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDataBase {
        return Room.databaseBuilder(
            context,
            BlogDataBase::class.java,
            BlogDataBase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideBlogDao(blogDataBase: BlogDataBase):BlogDio{
        return blogDataBase.blogDio()
    }
}