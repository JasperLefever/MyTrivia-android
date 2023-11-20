package icu.repsaj.android.mytrivia.viewmodel

import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.state.GameUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState())
    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()


    init {
        reset()

        //set uistate categories to the list of categories

        _uiState.value = GameUIState()
    }

    /**
     * Resets the state of the app to its default state
     */
    fun reset() {
        _uiState.value = GameUIState()
    }

    fun selectCategory(categoryId: UUID) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCategoryId = categoryId,
            )
        }
    }

    fun toggleQuitDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                showQuitDialog = currentState.showQuitDialog.not(),
            )
        }
    }

    fun nextQuestion() {
        _uiState.update { currentState ->
            currentState.copy(
                currentQuestionIndex = currentState.currentQuestionIndex.inc(),
            )
        }
    }
}