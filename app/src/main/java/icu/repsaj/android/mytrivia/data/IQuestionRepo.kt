package icu.repsaj.android.mytrivia.data

import android.util.Log
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.network.question.IQuestionApiService
import icu.repsaj.android.mytrivia.network.question.asDomainObjects
import icu.repsaj.android.mytrivia.network.question.getQuestionsAsFlow
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.util.UUID


/**
 * Repository interface for accessing trivia questions.
 */
interface IQuestionRepo {
    /**
     * Retrieves trivia questions for a specific category.
     *
     * @param categoryId The UUID of the category for which questions are to be retrieved.
     * @return A [Flow] emitting a list of [TriviaQuestion] for the specified category.
     */
    fun getQuestions(categoryId: UUID): Flow<List<TriviaQuestion>>
}

/**
 * Repository implementation for accessing trivia questions via an API.
 * This repository fetches trivia questions from a remote data source.
 *
 * @property questionApiService The API service for accessing trivia question data.
 */
class ApiQuestionRepo(
    private val questionApiService: IQuestionApiService
) : IQuestionRepo {

    /**
     * Fetches trivia questions for a given category from the API and converts them to domain objects.
     *
     * @param categoryId The UUID of the category for which questions are to be fetched.
     * @throws RuntimeException if an error occurs during the network request.
     * @return A [Flow] emitting a list of [TriviaQuestion]s for the specified category.
     */
    override fun getQuestions(categoryId: UUID): Flow<List<TriviaQuestion>> {
        try {
            Log.d("ApiQuestionRepo", "Fetching questions for category $categoryId")
            return questionApiService.getQuestionsAsFlow(categoryId = categoryId).asDomainObjects()
        } catch (e: IOException) {
            // Handle network errors
            throw RuntimeException("Network error during refresh: ${e.message}", e)
        } catch (e: Exception) {
            // Handle other unexpected errors
            throw RuntimeException("Unexpected error during refresh: ${e.message}", e)
        }
    }
}
