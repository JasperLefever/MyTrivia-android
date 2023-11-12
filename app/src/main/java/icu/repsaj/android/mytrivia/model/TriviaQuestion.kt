package icu.repsaj.android.mytrivia.model

data class TriviaQuestion(
    val id: Int,
    val categoryId: Int,
    val question: String,
    val answers: List<TriviaAnswer>,
)
