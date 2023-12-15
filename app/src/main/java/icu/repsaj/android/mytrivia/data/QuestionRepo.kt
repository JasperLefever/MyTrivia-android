package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.network.question.IQuestionApiService
import kotlinx.coroutines.flow.Flow


interface QuestionRepo {
    fun getQuestions(): Flow<List<TriviaQuestion>>

    suspend fun insertQuestion(category: TriviaQuestion)

}

class ApiQuestionRepo(
    private val questionApiService: IQuestionApiService
) : QuestionRepo {
    override fun getQuestions(): Flow<List<TriviaQuestion>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertQuestion(category: TriviaQuestion) {
        TODO("Not yet implemented")
    }

}