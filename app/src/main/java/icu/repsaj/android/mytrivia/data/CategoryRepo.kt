package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.data.database.CategoryDao
import icu.repsaj.android.mytrivia.data.database.entities.asDbEntity
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObjects
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.asPostCategory
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import icu.repsaj.android.mytrivia.network.categroy.asDomainObjects
import icu.repsaj.android.mytrivia.network.categroy.getCategoriesAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.SocketTimeoutException

interface CategoryRepo {
    fun getCategories(): Flow<List<Category>>

    suspend fun insertCategory(category: Category)

    suspend fun createCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    suspend fun refresh()
}

class CachingCategoryRepository(
    private val categoryDao: CategoryDao,
    private val categoryApi: ICategoryApiService
) : CategoryRepo {
    override fun getCategories(): Flow<List<Category>> {
        return categoryDao.getAll().map {
            it.asDomainObjects()
        }
    }

    override suspend fun insertCategory(category: Category) {
        categoryDao.insert(category.asDbEntity())
    }

    override suspend fun createCategory(category: Category) {
        categoryApi.createCategory(category.asPostCategory())
        refresh()
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.delete(category.asDbEntity())
    }

    override suspend fun refresh() {
        try {
            categoryApi.getCategoriesAsFlow().asDomainObjects().collect {
                categoryDao.clear()
                for (category in it) {
                    categoryDao.insert(category.asDbEntity())
                }
            }
        } catch (e: SocketTimeoutException) {
            // log something
        }
    }
}