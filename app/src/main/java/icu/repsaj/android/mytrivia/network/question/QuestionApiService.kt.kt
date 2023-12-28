package icu.repsaj.android.mytrivia.network.question

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException
import java.util.UUID

/**
 * Interface defining the API service for question-related operations.
 * This interface contains methods to interact with the backend API for fetching trivia questions.
 */
interface IQuestionApiService {

    /**
     * Fetches a list of trivia questions for a specific category from the API.
     *
     * @param category The UUID of the category for which questions are to be fetched.
     * @param page The page number for paginated results.
     * @param perPage The number of items per page.
     * @return A [QuestionResponse] containing metadata and a list of trivia questions ([ApiQuestion]).
     */
    @GET("questions/category/{categoryId}")
    suspend fun getQuestions(
        @Path(value = "categoryId") category: UUID,
        @Query(value = "page") page: Int,
        @Query(value = "perPage") perPage: Int
    ): QuestionResponse
}

/**
 * Extension function to convert the API call for fetching questions into a Flow.
 * This function encapsulates the API call within a Flow for reactive data handling.
 * The Flow emits a list of [ApiQuestion] items.
 *
 * @param categoryId The UUID of the category for which questions are to be fetched.
 * @param page The page number for paginated results, with a default value of 1.
 * @param perPage The number of items per page, with a default value of 10.
 * @return A [Flow] emitting a list of [ApiQuestion] items.
 */
fun IQuestionApiService.getQuestionsAsFlow(
    categoryId: UUID,
    page: Int = 1,
    perPage: Int = 10
): Flow<List<ApiQuestion>> = flow {
    try {
        emit(getQuestions(categoryId, page, perPage).items)
    } catch (e: IOException) {
        throw RuntimeException("Unexpected error during refresh: ${e.message}", e)
    }
}
