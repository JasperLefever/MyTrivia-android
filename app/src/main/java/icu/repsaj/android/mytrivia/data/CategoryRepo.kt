package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.data.database.CategoryDao
import icu.repsaj.android.mytrivia.data.database.entities.asDbEntity
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObject
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObjects
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import icu.repsaj.android.mytrivia.network.categroy.asDomainObjects
import icu.repsaj.android.mytrivia.network.categroy.getCategoriesAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException
import java.util.UUID

interface CategoryRepo {
    fun getCategories(): Flow<List<Category>>

    fun getCategory(id: UUID): Flow<Category?>

    suspend fun insertCategory(category: Category)

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
        }.onEach {
            // todo: check when refresh is called (why duplicates??)
            if (it.isEmpty()) {
                refresh()
            }
        }
    }

    override fun getCategory(id: UUID): Flow<Category?> {
        return categoryDao.getItem(id).map {
            it.asDomainObject()
        }
    }

    override suspend fun insertCategory(category: Category) {
        categoryDao.insert(category.asDbEntity())
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.delete(category.asDbEntity())
    }

    override suspend fun refresh() {
        try {
            categoryApi.getCategoriesAsFlow().asDomainObjects().collect { value ->
                for (category in value) {
                    insertCategory(category)
                }
            }
        } catch (e: SocketTimeoutException) {
            // log something
        }
    }
}