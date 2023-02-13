package com.example.month5_lesson6.di

import android.content.Context
import androidx.room.Room
import com.example.month5_lesson6.data.AppDataBase
import com.example.month5_lesson6.data.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Room {
    @Provides
    fun databaseDao(appDataBase: AppDataBase): TaskDao = appDataBase.taskDao()
    @Provides
    @Singleton
     fun init(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java,"TODO").allowMainThreadQueries().build()
    }

}