package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.data.database.CategoryDao
import icu.repsaj.android.mytrivia.data.database.entities.asDbEntity
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObject
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObjects
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.asPostCategory
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import icu.repsaj.android.mytrivia.network.categroy.asDomainObjects
import icu.repsaj.android.mytrivia.network.categroy.getCategoriesAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.SocketTimeoutException
import java.util.UUID

/**
 * Repository interface for handling category data operations.
 */
interface ICategoryRepo {
    /**
     * Retrieves all categories.
     *
     * @return A [Flow] emitting a list of [Category].
     */
    fun getCategories(): Flow<List<Category>>

    /**
     * Retrieves a specific category by its ID.
     *
     * @param id The UUID of the category.
     * @return A [Flow] emitting the [Category] with the specified ID.
     */
    fun getCategoryById(id: UUID): Flow<Category>

    /**
     * Inserts a new category into the local database.
     *
     * @param category The [Category] to be inserted.
     */
    suspend fun insertCategory(category: Category)

    /**
     * Creates a new category via the API.
     *
     * @param category The [Category] to be created remotely.
     */
    suspend fun createCategory(category: Category)

    /**
     * Deletes a category
     *
     * @param category The [Category] to be deleted.
     */
    suspend fun deleteCategory(category: Category)

    /**
     * Refreshes the local categories database.
     */
    suspend fun refresh()
}

/**
 * A repository implementation that caches categories locally and updates them from a remote API.
 *
 * @property categoryDao The DAO for accessing category data from the local database.
 * @property categoryApi The API service for accessing category data remotely.
 */
class CachingCategoryRepository(
    private val categoryDao: CategoryDao,
    private val categoryApi: ICategoryApiService
) : ICategoryRepo {

    /**
     * Retrieves all categories from the local database, converting them to domain objects.
     *
     * @return A [Flow] emitting a list of [Category]s.
     */
    override fun getCategories(): Flow<List<Category>> {
        return categoryDao.getAll().map { it.asDomainObjects() }
    }

    /**
     * Retrieves a specific category by its ID from the local database.
     *
     * @param id The UUID of the category to retrieve.
     * @return A [Flow] emitting the [Category] with the specified ID.
     */
    override fun getCategoryById(id: UUID): Flow<Category> {
        return categoryDao.getById(id).map { it.asDomainObject() }
    }

    /**
     * Inserts a new category into the local database.
     *
     * @param category The [Category] to be inserted.
     */
    override suspend fun insertCategory(category: Category) {
        categoryDao.insert(category.asDbEntity())
    }

    /**
     * Creates a new category via the API. After a successful creation, it refreshes the local database.
     *
     * @param category The [Category] to be created remotely.
     */
    override suspend fun createCategory(category: Category) {
        categoryApi.createCategory(category.asPostCategory())
        refresh()
    }

    /**
     * Deletes a category via the API. After a successful deletion, it refreshes the local database.
     *
     * @param category The [Category] to be deleted.
     */
    override suspend fun deleteCategory(category: Category) {
        categoryApi.deleteCategory(category.id)
        refresh()
    }


    //TODO: fix error handling
    /**
     * Refreshes the local category database by fetching the latest data from the API.
     * It clears the current data and repopulates it with the latest data.
     * In case of a network timeout, an appropriate action such as logging can be implemented.
     */
    override suspend fun refresh() {
        try {
            categoryApi.getCategoriesAsFlow().asDomainObjects().collect {
                categoryDao.clear()
                for (category in it) {
                    categoryDao.insert(category.asDbEntity())
                }
            }
        } catch (e: SocketTimeoutException) {
            // Implement logging or error handling here
        }
    }
}
