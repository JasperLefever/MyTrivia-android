package icu.repsaj.android.mytrivia.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for the 'game_history' table.
 */
@Dao
interface GameHistoryDao {

    /**
     * Inserts a [DbGameHistoryItem] item into the database.
     * If a game history item with the same ID already exists, it is replaced.
     *
     * @param item The [DbGameHistoryItem] item to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DbGameHistoryItem)

    /**
     * Deletes a specific [DbGameHistoryItem] item from the database.
     *
     * @param item The [DbGameHistoryItem] item to be deleted.
     */
    @Delete
    suspend fun delete(item: DbGameHistoryItem)

    /**
     * Retrieves all game history entries from the database as a list.
     *
     * @return A [Flow] emitting a list of [DbGameHistoryItem] items.
     */
    @Query("SELECT * from game_history")
    fun getAll(): Flow<List<DbGameHistoryItem>>
}
