package icu.repsaj.android.mytrivia.model

data class TriviaAnswer(
    var questionId: Int = 0,
    var answer: String = "",
    var isCorrect: Boolean = false
)