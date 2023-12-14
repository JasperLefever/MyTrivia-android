package icu.repsaj.android.mytrivia.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.network.question.QuestionApi
import icu.repsaj.android.mytrivia.network.question.asDomainObjects
import icu.repsaj.android.mytrivia.state.GameApiUIState
import icu.repsaj.android.mytrivia.state.GameUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException

class GameViewModel(
    val category: Category
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState(category = category))
    public val uiState = _uiState.asStateFlow();

    var apiState: GameApiUIState by mutableStateOf(GameApiUIState.Loading)
        private set


    init {
        fetchQuestions()
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
                currentQuestionIndex = currentState.currentQuestionIndex + 1,
            )
        }
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            apiState = try {
                val result = QuestionApi.questionService.getQuestions(1, 10, category = category.id)
                GameApiUIState.Success(
                    questions = result.asDomainObjects()
                )
            } catch (e: IOException) {
                GameApiUIState.Error(e.message ?: "Unknown error")
            }
        }
    }
}