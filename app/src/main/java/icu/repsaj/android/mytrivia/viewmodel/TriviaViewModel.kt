package icu.repsaj.android.mytrivia.viewmodel

import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.state.TriviaUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TriviaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TriviaUIState())
    val uiState: StateFlow<TriviaUIState> = _uiState.asStateFlow()


    init {
        reset()

        //set uistate categories to the list of categories

        _uiState.value = TriviaUIState()
    }

    /**
     * Resets the state of the app to its default state
     */
    fun reset() {
        _uiState.value = TriviaUIState()
    }

    fun selectCategory(categoryId: Int) {
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