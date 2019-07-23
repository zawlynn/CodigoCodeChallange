package com.zawlynn.codigo.assignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zawlynn.codigo.assignment.data.database.dao.WonderDAO

import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder


@Database(entities = [Wonder::class], version = 2, exportSchema = false)
abstract class CodigoDatabase : RoomDatabase() {
    abstract fun dao(): WonderDAO
}