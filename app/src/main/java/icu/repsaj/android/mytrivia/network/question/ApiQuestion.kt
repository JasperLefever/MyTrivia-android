package icu.repsaj.android.mytrivia.network.question

import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.network.Metadata
import icu.repsaj.android.mytrivia.network.UUIDSerializer
import icu.repsaj.android.mytrivia.network.categroy.ApiCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ApiQuestion(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val questionText: String,
    val answers: List<ApiAnswer> = listOf(),
    val category: ApiCategory
)

@Serializable
data class ApiAnswer(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val answerText: String,
    val isCorrect: Boolean,
    @Serializable(with = UUIDSerializer::class)
    val questionId: UUID
)

fun ApiAnswer.asDomainObject(): TriviaAnswer {
    return TriviaAnswer(
        id = this.id,
        answer = this.answerText,
        isCorrect = this.isCorrect
    )
}


@Serializable
data class QuestionResponse(
    val metadata: Metadata,
    val items: List<ApiQuestion>
)

fun Flow<List<ApiQuestion>>.asDomainObjects(): Flow<List<TriviaQuestion>> {
    return this.map {
        it.asDomainObjects()
    }
}

fun List<ApiQuestion>.asDomainObjects(): List<TriviaQuestion> {
    return this.map {
        TriviaQuestion(
            id = it.id,
            question = it.questionText,
            answers = it.answers.map { answer ->
                TriviaAnswer(
                    id = answer.id,
                    answer = answer.answerText,
                    isCorrect = answer.isCorrect
                )
            },
        )
    }
}