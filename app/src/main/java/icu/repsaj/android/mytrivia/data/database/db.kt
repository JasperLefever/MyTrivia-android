package icu.repsaj.android.mytrivia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem

@Database(
    entities = [DbCategory::class, DbGameHistoryItem::class /*,DbQuestion::class,  DbAnswer::class*/],
    version = 1,
    exportSchema = false
)
abstract class TriviaDb : RoomDatabase() {

    abstract fun CategoryDao(): CategoryDao

    //abstract fun QuestionDao(): QuestionDao
    //abstract fun AnswerDao(): AnswerDao
    abstract fun GameHistoryDao(): GameHistoryDao

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
