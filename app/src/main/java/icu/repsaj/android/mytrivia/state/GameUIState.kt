package icu.repsaj.android.mytrivia.state

import icu.repsaj.android.mytrivia.model.TriviaQuestion
import java.util.UUID

data class GameUIState(
    val showQuitDialog: Boolean = false,
    val currentCategoryId: UUID? = null,
    val currentCategory: String = "",
    val questions: List<TriviaQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val isGameOver: Boolean = false,
)
