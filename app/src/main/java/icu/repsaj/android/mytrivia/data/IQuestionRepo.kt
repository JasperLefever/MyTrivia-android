package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.network.question.IQuestionApiService
import icu.repsaj.android.mytrivia.network.question.asDomainObjects
import icu.repsaj.android.mytrivia.network.question.getQuestionsAsFlow
import kotlinx.coroutines.flow.Flow
import java.util.UUID


interface IQuestionRepo {
    fun getQuestions(categoryId: UUID): Flow<List<TriviaQuestion>>
}

class ApiQuestionRepo(
    private val questionApiService: IQuestionApiService
) : IQuestionRepo {
    override fun getQuestions(categoryId: UUID): Flow<List<TriviaQuestion>> {
        return questionApiService.getQuestionsAsFlow(categoryId = categoryId).asDomainObjects()
    }
}