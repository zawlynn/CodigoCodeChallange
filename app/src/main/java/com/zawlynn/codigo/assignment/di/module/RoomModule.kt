package com.zawlynn.codigo.assignment.di.module


import androidx.room.Room
import com.zawlynn.codigo.assignment.DiApplication
import com.zawlynn.codigo.assignment.data.database.CodigoDatabase
import com.zawlynn.codigo.assignment.data.database.dao.WonderDAO
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provoideDao(database: CodigoDatabase): WonderDAO {
        return database.dao()
    }

    @Provides
    fun provideDatabase(application: DiApplication): CodigoDatabase {
        return Room.databaseBuilder(application, CodigoDatabase::class.java,"data.db").fallbackToDestructiveMigration().build()
    }
}