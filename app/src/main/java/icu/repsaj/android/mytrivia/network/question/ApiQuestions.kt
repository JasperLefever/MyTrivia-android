package icu.repsaj.android.mytrivia.network.question

import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.network.categroy.ApiCategory
import icu.repsaj.android.mytrivia.network.dto.Metadata
import icu.repsaj.android.mytrivia.network.dto.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ApiQuestions(
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


@Serializable
data class QuestionResponse(
    val metadata: Metadata,
    val items: List<ApiQuestions>
)

fun QuestionResponse.asDomainObjects(): List<TriviaQuestion> {
    return this.items.map {
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