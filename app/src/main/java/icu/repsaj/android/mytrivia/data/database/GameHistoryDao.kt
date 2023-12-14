package icu.repsaj.android.mytrivia.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface GameHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DbGameHistoryItem)

    @Delete
    suspend fun delete(item: DbGameHistoryItem)

    @Query("SELECT * from game_history")
    fun getAll(): Flow<List<DbGameHistoryItem>>
}
