package icu.repsaj.android.mytrivia.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DbCategory)

    @Delete
    suspend fun delete(item: DbCategory)

    @Query("DELETE FROM categories")
    suspend fun clear()

    @Query("SELECT * from categories")
    fun getAll(): Flow<List<DbCategory>>

    @Query("SELECT * from categories WHERE id = :id")
    fun getById(id: UUID): Flow<DbCategory>
}
