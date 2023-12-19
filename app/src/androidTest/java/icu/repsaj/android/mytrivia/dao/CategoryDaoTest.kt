package icu.repsaj.android.mytrivia.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import icu.repsaj.android.mytrivia.data.database.CategoryDao
import icu.repsaj.android.mytrivia.data.database.TriviaDb
import icu.repsaj.android.mytrivia.data.database.entities.DbCategory
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class CategoryDaoTest {

    private lateinit var database: TriviaDb
    private lateinit var categoryDao: CategoryDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, TriviaDb::class.java)
            .allowMainThreadQueries()
            .build()
        categoryDao = database.categoryDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    private val category1 = DbCategory(UUID.randomUUID(), "Category 1", "icon1", 5)
    private val category2 = DbCategory(UUID.randomUUID(), "Category 2", "icon2", 10)
    private suspend fun addOneCategoryToDb() {
        categoryDao.insert(category1)
    }

    private suspend fun addTwoCategoriesToDb() {
        categoryDao.insert(category1)
        categoryDao.insert(category2)
    }

    @Test
    fun daoInsert_insertNewCategoryIntoDb() = runBlocking {
        addOneCategoryToDb()

        val retrievedCategory = categoryDao.getById(category1.id).first()
        assertEquals(category1, retrievedCategory)
    }

    @Test
    fun daoDelete_deleteCategoryFromDb() = runBlocking {
        addOneCategoryToDb()

        categoryDao.delete(category1)

        val retrievedCategory = categoryDao.getById(category1.id).firstOrNull()
        assertNull(retrievedCategory)
    }

    @Test
    fun daoClear_deleteAllCategoryFromDb() = runBlocking {
        addTwoCategoriesToDb()

        categoryDao.clear()

        val allCategories = categoryDao.getAll().first()
        assertTrue(allCategories.isEmpty())
    }

    @Test
    fun daoGetAll_getAllCategoriesFromDb() = runBlocking {
        addTwoCategoriesToDb()

        val allCategories = categoryDao.getAll().first()
        assertEquals(2, allCategories.size)
        assertEquals(category1, allCategories[0])
        assertEquals(category2, allCategories[1])
    }

    @Test
    fun daoGetById_getCategoryByIdFromDb() = runBlocking {
        addTwoCategoriesToDb()

        val retrievedCategory = categoryDao.getById(category1.id).first()
        assertEquals(category1, retrievedCategory)
    }
}