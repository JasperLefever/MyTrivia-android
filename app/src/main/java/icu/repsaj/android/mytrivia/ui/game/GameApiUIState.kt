package icu.repsaj.android.mytrivia.ui.game

import icu.repsaj.android.mytrivia.model.TriviaQuestion


/**
 * Represents the state of the API call to fetch questions.
 */
sealed interface QuestionsApiState {
    object Success : QuestionsApiState
    data class Error(val message: String) : QuestionsApiState
    object Loading : QuestionsApiState
}

/**
 * Represents the state of the game UI.
 */
data class GameUIState(
    val questions: List<TriviaQuestion> = listOf(),
    val showQuitDialog: Boolean = false,
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val isAnswered: Boolean = false,
)