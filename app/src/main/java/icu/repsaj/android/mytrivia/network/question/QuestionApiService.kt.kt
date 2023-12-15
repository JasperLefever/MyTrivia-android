package icu.repsaj.android.mytrivia.network.question

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface IQuestionApiService {

    @GET("questions/category/{categoryId}")
    suspend fun getQuestions(
        @Path(value = "categoryId") category: UUID,
        @Query(value = "page") page: Int,
        @Query(value = "perPage") perPage: Int
    ): QuestionResponse

}

fun IQuestionApiService.getQuestionsAsFlow(
    categoryId: UUID,
    page: Int = 1,
    perPage: Int = 10
): Flow<List<ApiQuestion>> = flow {
    emit(getQuestions(categoryId, page, perPage).items)
}