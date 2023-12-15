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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class GameViewModel(
    val category: Category,
    private val questionRepo: QuestionRepo,
    private val historyRepo: GameHistoryRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState(category = category))
    public val uiState = _uiState.asStateFlow();

    lateinit var questionsListState: StateFlow<QuestionsListState>

    var apiState: QuestionsApiState by mutableStateOf(QuestionsApiState.Loading)
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
        try {
            questionsListState =
                questionRepo.getQuestions(category.id).map { QuestionsListState(it) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000L),
                        initialValue = QuestionsListState(),
                    )
            apiState = QuestionsApiState.Success
        } catch (e: java.io.IOException) {
            //TODO ERROR HANDLING
            apiState = QuestionsApiState.Error
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