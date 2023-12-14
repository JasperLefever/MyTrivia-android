package icu.repsaj.android.mytrivia.model

import java.util.UUID

data class TriviaQuestion(
    val id: UUID,
    val question: String,
    val answers: List<TriviaAnswer> = listOf()
)
