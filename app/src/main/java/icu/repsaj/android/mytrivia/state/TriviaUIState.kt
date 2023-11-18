package icu.repsaj.android.mytrivia.state

import icu.repsaj.android.mytrivia.model.TriviaQuestion

data class TriviaUIState(
    val showQuitDialog: Boolean = false,
    val currentCategoryId: Int? = null,
    val currentCategory: String = "",
    val questions: List<TriviaQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val isGameOver: Boolean = false,
)
