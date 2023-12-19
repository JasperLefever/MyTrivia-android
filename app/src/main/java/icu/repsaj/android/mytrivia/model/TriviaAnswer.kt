package icu.repsaj.android.mytrivia.model

import java.util.UUID

/**
 * Data class representing a trivia answer.
 *
 * @property id The ID of the trivia answer.
 * @property answer The trivia answer.
 * @property isCorrect Whether the trivia answer is correct.
 */
data class TriviaAnswer(
    var id: UUID,
    var answer: String = "",
    var isCorrect: Boolean
)