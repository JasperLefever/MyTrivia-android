package icu.repsaj.android.mytrivia.state

import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.TriviaQuestion


sealed interface GameApiUIState {
    data class Success(
        val questions: List<TriviaQuestion> = emptyList(),
    ) : GameApiUIState

    object Loading : GameApiUIState
    data class Error(val message: String) : GameApiUIState
}


data class GameUIState(
    val showQuitDialog: Boolean = false,
    val category: Category,
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val isGameOver: Boolean = false,
)