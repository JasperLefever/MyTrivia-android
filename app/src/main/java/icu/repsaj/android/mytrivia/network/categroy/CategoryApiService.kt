package icu.repsaj.android.mytrivia.network.categroy

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ICategoryApiService {

    @GET("categories")
    suspend fun getCategories(
        @Query(value = "page") page: Int, @Query(value = "perPage") perPage: Int
    ): CategoryResponse

    @POST("categories")
    suspend fun createCategory(@Body category: CreateCategory)
}

fun ICategoryApiService.getCategoriesAsFlow(): Flow<List<ApiCategory>> = flow {
    emit(getCategories(1, 100).items)
}
