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
import icu.repsaj.android.mytrivia.data.ICategoryRepo
import icu.repsaj.android.mytrivia.data.IQuestionRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class GameViewModel(
    val categoryId: UUID,
    private val questionRepo: IQuestionRepo,
    private val historyRepo: GameHistoryRepo,
    private val categoryRepo: ICategoryRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState())
    public val uiState = _uiState.asStateFlow();

    lateinit var uiCategory: StateFlow<Category>

    var apiState: QuestionsApiState by mutableStateOf(QuestionsApiState.Loading)
        private set


    init {
        getCategory()
        fetchQuestions()
    }

    fun nextQuestion() {
        if (isLastQuestion()) {
            return
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentQuestionIndex = currentState.currentQuestionIndex + 1,
                isAnswered = false,
            )
        }
    }

    fun showScoreDialog(): Boolean {
        return _uiState.value.isAnswered && isLastQuestion()
    }

    fun isLastQuestion(): Boolean {
        return _uiState.value.currentQuestionIndex == _uiState.value.questions.size - 1
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
                category = uiCategory.value.name,
                score = _uiState.value.score,
                date = Date()
            )
            historyRepo.insertHistoryItem(historyItem)
        }
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            try {
                val questionsFlow = questionRepo.getQuestions(categoryId)
                if (questionsFlow != null) {
                    val questions = questionsFlow.toList().flatten()
                    _uiState.update { currentState ->
                        currentState.copy(questions = questions)
                    }
                    apiState = QuestionsApiState.Success
                } else {
                    apiState = QuestionsApiState.Error
                }
            } catch (e: Exception) {
                e.printStackTrace()
                apiState = QuestionsApiState.Error
            }
        }

    }

    private fun getCategory() {
        viewModelScope.launch {
            try {

                uiCategory = categoryRepo.getCategoryById(categoryId)
                    .map { it }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000L),
                        initialValue = Category(UUID.randomUUID(), "Loading", "loading", 0),
                    )

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    companion object {
        fun factory(categoryId: UUID): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                val questionRepo = application.container.questionRepo
                val historyRepo = application.container.historyRepo
                val categoryRepo = application.container.categoryRepo
                GameViewModel(
                    categoryId = categoryId,
                    questionRepo = questionRepo,
                    historyRepo = historyRepo,
                    categoryRepo = categoryRepo
                )
            }
        }
    }

}