package icu.repsaj.android.mytrivia.ui.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.GameHistoryRepo
import icu.repsaj.android.mytrivia.data.QuestionRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date

class GameViewModel(
    val category: Category,
    private val questionRepo: QuestionRepo,
    private val historyRepo: GameHistoryRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState(category = category))
    public val uiState = _uiState.asStateFlow();

    var apiState: QuestionsApiState by mutableStateOf(QuestionsApiState.Loading)
        private set


    init {
        fetchQuestions()
    }

    fun nextQuestion() {
        if (_uiState.value.currentQuestionIndex == _uiState.value.questions.size - 1) {
            _uiState.update { currentState ->
                currentState.copy(
                    isGameOver = true,
                )
            }
            return
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentQuestionIndex = currentState.currentQuestionIndex + 1,
                isAnswered = false,
            )
        }
    }

    fun checkAnswer(answer: TriviaAnswer) {
        _uiState.update { currentState ->
            currentState.copy(
                isAnswered = true,
                score = if (answer.isCorrect) currentState.score + 1 else currentState.score,
            )
        }
    }

    fun getCurrentQuestion(): TriviaQuestion {
        return _uiState.value.questions[_uiState.value.currentQuestionIndex]
    }

    fun getAmountOfQuestions(): Int {
        return _uiState.value.questions.size
    }

    fun saveHistoryItem() {
        viewModelScope.launch {
            val historyItem = HistoryItem(
                category = category.name,
                score = _uiState.value.score,
                date = Date()
            )
            historyRepo.insertHistoryItem(historyItem)
        }
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            try {
                // Fetch and flatten the questions list
                val questions = questionRepo.getQuestions(category.id).toList().flatten()

                // Update the UI state with the fetched questions
                _uiState.update { currentState ->
                    currentState.copy(questions = questions)
                }

                // Update the API state to success
                apiState = QuestionsApiState.Success
            } catch (e: Exception) { // Catch broader exceptions
                // Log the error or handle it as needed
                e.printStackTrace()

                // Update the API state to indicate an error
                apiState = QuestionsApiState.Error
            }
        }
    }


    companion object {
        fun factory(category: Category): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                val questionRepo = application.container.questionRepo
                val historyRepo = application.container.historyRepo
                GameViewModel(
                    category = category,
                    questionRepo = questionRepo,
                    historyRepo = historyRepo
                )
            }
        }
    }

}