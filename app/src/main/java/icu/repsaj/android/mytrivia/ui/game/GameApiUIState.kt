package icu.repsaj.android.mytrivia.ui.game

import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.TriviaQuestion


sealed interface QuestionsApiState {
    object Success : QuestionsApiState
    object Error : QuestionsApiState
    object Loading : QuestionsApiState
}

data class QuestionsListState(val questionsList: List<TriviaQuestion> = listOf())


data class GameUIState(
    val showQuitDialog: Boolean = false,
    val category: Category,
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val isGameOver: Boolean = false,
)