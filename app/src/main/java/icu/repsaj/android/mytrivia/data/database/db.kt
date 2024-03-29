package icu.repsaj.android.mytrivia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import icu.repsaj.android.mytrivia.data.database.convertors.DateConverters
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem

/**
 * The Room database class for the Trivia application.
 *
 * Tables: [DbCategory], [DbGameHistoryItem]
 *
 * @property categoryDao Access point for database operations related to categories.
 * @property gameHistoryDao Access point for database operations related to game history.
 */
@Database(
    entities = [DbCategory::class, DbGameHistoryItem::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class TriviaDb : RoomDatabase() {

    /**
     * Provides the DAO for accessing the 'categories' table in the database.
     *
     * @return Instance of [CategoryDao] for database operations related to categories.
     */
    abstract fun categoryDao(): CategoryDao

    /**
     * Provides the DAO for accessing the 'game_history' table in the database.
     *
     * @return Instance of [GameHistoryDao] for database operations related to game history.
     */
    abstract fun gameHistoryDao(): GameHistoryDao

    companion object {
        @Volatile
        private var Instance: TriviaDb? = null

        /**
         * Gets the singleton instance of [TriviaDb].
         *
         * @param context The context to be used for creating the database instance.
         * @return The singleton instance of [TriviaDb].
         */
        fun getDatabase(context: Context): TriviaDb {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TriviaDb::class.java, "trivia_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
