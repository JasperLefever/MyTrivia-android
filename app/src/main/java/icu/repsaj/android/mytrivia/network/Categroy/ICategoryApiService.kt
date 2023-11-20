package icu.repsaj.android.mytrivia.network.Categroy

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import icu.repsaj.android.mytrivia.network.baseUrl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface ICategoryApiService {

    @GET("categories")
    suspend fun getCategories(page: Int, perPage: Int): CategoryResponse
}

private var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType()),
    )
    .baseUrl(baseUrl)
    .build()

object CategoryApi {
    val categoryService: ICategoryApiService by lazy {
        retrofit.create(ICategoryApiService::class.java)
    }
}