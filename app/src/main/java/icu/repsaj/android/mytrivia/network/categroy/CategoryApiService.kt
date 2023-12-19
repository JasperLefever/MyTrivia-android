package icu.repsaj.android.mytrivia.network.categroy

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

/**
 * Interface defining the API service for category-related operations.
 * This interface contains methods to interact with the backend API for fetching, deleting, and creating categories.
 */
interface ICategoryApiService {

    /**
     * Fetches a list of categories from the API.
     *
     * @param page The page number for paginated results.
     * @param perPage The number of items per page.
     * @return A [CategoryResponse] containing metadata and a list of categories ([ApiCategory]).
     */
    @GET("categories")
    suspend fun getCategories(
        @Query(value = "page") page: Int,
        @Query(value = "perPage") perPage: Int
    ): CategoryResponse

    /**
     * Deletes a specific category identified by its UUID from the API.
     *
     * @param id The UUID of the category to be deleted.
     * @return A empty [Response] object.
     */
    @DELETE("categories/{id}")
    suspend fun deleteCategory(@Path(value = "id") id: UUID): Response<Unit>

    /**
     * Creates a new category via the API.
     *
     * @param category The [CreateCategory] object containing the details of the category to be created.
     */
    @POST("categories")
    suspend fun createCategory(@Body category: CreateCategory)
}

/**
 * Extension function to convert the API call for fetching categories into a Flow.
 * This function encapsulates the API call within a Flow for reactive data handling.
 *
 * @return A [Flow] emitting a list of [ApiCategory] items.
 */
fun ICategoryApiService.getCategoriesAsFlow(): Flow<List<ApiCategory>> = flow {
    emit(getCategories(1, 100).items)
}
