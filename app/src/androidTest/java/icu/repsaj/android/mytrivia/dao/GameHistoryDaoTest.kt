package icu.repsaj.android.mytrivia.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import icu.repsaj.android.mytrivia.data.database.GameHistoryDao
import icu.repsaj.android.mytrivia.data.database.TriviaDb
import icu.repsaj.android.mytrivia.data.database.entities.DbGameHistoryItem
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class GameHistoryDaoTest {

    private lateinit var database: TriviaDb
    private lateinit var gameHistoryDao: GameHistoryDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, TriviaDb::class.java)
            .allowMainThreadQueries()
            .build()
        gameHistoryDao = database.gameHistoryDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    private val item1 = DbGameHistoryItem(
        id = 1,
        category = "category1",
        date = Date(),
        score = 5
    )
    private val item2 = DbGameHistoryItem(
        id = 2,
        category = "category2",
        date = Date(),
        score = 10
    )

    private suspend fun addOneItemToDb() {
        gameHistoryDao.insert(item1)
    }

    private suspend fun addTwoItemsToDb() {
        gameHistoryDao.insert(item1)
        gameHistoryDao.insert(item2)
    }

    @Test
    fun daoInsert_insertNewItemIntoDb() = runBlocking {
        addOneItemToDb()

        val retrievedItems = gameHistoryDao.getAll().first()
        assertEquals(item1, retrievedItems[0])
    }

    @Test
    fun daoDelete_deleteItemFromDb() = runBlocking {
        addOneItemToDb()

        gameHistoryDao.delete(item1)

        val retrievedItems = gameHistoryDao.getAll().first()
        assertTrue(retrievedItems.isEmpty())
    }

    @Test
    fun daoGetAll_getAllItemsFromDb() = runBlocking {
        addTwoItemsToDb()

        val retrievedItems = gameHistoryDao.getAll().first()
        assertEquals(item1, retrievedItems[0])
        assertEquals(item2, retrievedItems[1])
    }

}