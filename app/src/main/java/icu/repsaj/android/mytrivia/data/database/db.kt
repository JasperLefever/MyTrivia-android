package icu.repsaj.android.mytrivia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import icu.repsaj.android.mytrivia.data.database.convertors.DateConverters
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem

@Database(
    entities = [DbCategory::class, DbGameHistoryItem::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class TriviaDb : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun gameHistoryDao(): GameHistoryDao

    companion object {
        @Volatile
        private var Instance: TriviaDb? = null

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
