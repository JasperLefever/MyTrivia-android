package icu.repsaj.android.mytrivia.model

import java.util.UUID

data class TriviaAnswer(
    var id: UUID,
    var answer: String = "",
    var isCorrect: Boolean
)