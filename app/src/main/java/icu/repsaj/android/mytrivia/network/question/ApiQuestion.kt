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

/**
 * Represents a trivia question as defined in the API.
 * This data class is used for serialization and deserialization of question data from API responses.
 *
 * @property id Unique identifier of the question, serialized using [UUIDSerializer].
 * @property questionText The text of the trivia question.
 * @property answers A list of possible answers ([ApiAnswer]) for the question.
 * @property category The category ([ApiCategory]) to which this question belongs.
 */
@Serializable
data class ApiQuestion(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val questionText: String,
    val answers: List<ApiAnswer> = listOf(),
    val category: ApiCategory
)

/**
 * Represents a possible answer to a trivia question as defined in the API.
 *
 * @property id Unique identifier of the answer, serialized using [UUIDSerializer].
 * @property answerText The text of the answer.
 * @property isCorrect Indicates whether this answer is correct.
 * @property questionId The identifier of the question this answer belongs to, serialized using [UUIDSerializer].
 */
@Serializable
data class ApiAnswer(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val answerText: String,
    val isCorrect: Boolean,
    @Serializable(with = UUIDSerializer::class)
    val questionId: UUID
)

/**
 * Converts an [ApiAnswer] to a [TriviaAnswer] domain object.
 *
 * @return A [TriviaAnswer] domain object.
 */
fun ApiAnswer.asDomainObject(): TriviaAnswer {
    return TriviaAnswer(
        id = this.id,
        answer = this.answerText,
        isCorrect = this.isCorrect
    )
}

/**
 * Represents a response from the API for question requests.
 * This class encapsulates metadata and a list of [ApiQuestion] items.
 *
 * @property metadata Metadata associated with the API response.
 * @property items List of questions returned by the API.
 */
@Serializable
data class QuestionResponse(
    val metadata: Metadata,
    val items: List<ApiQuestion>
)

/**
 * Extension function on Flow<List<ApiQuestion>> to convert a flow of API question lists into a flow of domain object lists.
 *
 * @return A [Flow] emitting lists of [TriviaQuestion] domain objects.
 */
fun Flow<List<ApiQuestion>>.asDomainObjects(): Flow<List<TriviaQuestion>> {
    return this.map { it.asDomainObjects() }
}

/**
 * Extension function to convert a list of [ApiQuestion] to a list of [TriviaQuestion] domain objects.
 *
 * @return A list of [TriviaQuestion] domain objects.
 */
fun List<ApiQuestion>.asDomainObjects(): List<TriviaQuestion> {
    return this.map {
        TriviaQuestion(
            id = it.id,
            question = it.questionText,
            answers = it.answers.map(ApiAnswer::asDomainObject),
        )
    }
}
