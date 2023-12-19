package icu.repsaj.android.mytrivia.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * Data access object for the 'categories' table.
 */
@Dao
interface CategoryDao {

    /**
     * Inserts a [DbCategory] item into the database.
     * If a category with the same ID already exists, it is replaced.
     *
     * @param item The [DbCategory] item to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DbCategory)

    /**
     * Deletes a specific [DbCategory] item from the database.
     *
     * @param item The [DbCategory] item to be deleted.
     */
    @Delete
    suspend fun delete(item: DbCategory)

    /**
     * Clears all entries from the 'categories' table.
     */
    @Query("DELETE FROM categories")
    suspend fun clear()

    /**
     * Retrieves all category entries from the database as a list.
     *
     * @return A [Flow] emitting a list of [DbCategory] items.
     */
    @Query("SELECT * from categories")
    fun getAll(): Flow<List<DbCategory>>

    /**
     * Retrieves a specific category by its ID.
     *
     * @param id The UUID of the category to retrieve.
     * @return A [Flow] emitting the [DbCategory] item with the specified ID.
     */
    @Query("SELECT * from categories WHERE id = :id")
    fun getById(id: UUID): Flow<DbCategory>
}
