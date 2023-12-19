package icu.repsaj.android.mytrivia.model

import java.util.UUID

/**
 * Data class representing a trivia question.
 *
 * @property id The ID of the trivia question.
 * @property question The trivia question itself.
 * @property answers The list of [TriviaAnswer] for the trivia question.
 */
data class TriviaQuestion(
    val id: UUID,
    val question: String,
    val answers: List<TriviaAnswer> = listOf()
)
