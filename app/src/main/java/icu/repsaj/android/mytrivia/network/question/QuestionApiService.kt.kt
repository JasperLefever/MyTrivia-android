package icu.repsaj.android.mytrivia.network.question

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import icu.repsaj.android.mytrivia.network.baseUrl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.UUID

interface IQuestionApiService {

    @GET("questions/category")
    suspend fun getQuestions(
        @Query(value = "page") page: Int,
        @Query(value = "perPage") perPage: Int,
        @Query(value = "categoryId") category: UUID
    ): QuestionResponse
}

private var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType()),
    )
    .baseUrl(baseUrl)
    .build()

object QuestionApi {
    val questionService: IQuestionApiService by lazy {
        retrofit.create(IQuestionApiService::class.java)
    }
}