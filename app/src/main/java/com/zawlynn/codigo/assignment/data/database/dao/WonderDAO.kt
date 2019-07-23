package com.zawlynn.codigo.assignment.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import io.reactivex.Flowable

@Dao
abstract class WonderDAO {
    @Query(" SELECT * FROM Wonder")
    abstract fun getAllData(): Flowable<List<Wonder>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveAllData(movies:List<Wonder>)
}