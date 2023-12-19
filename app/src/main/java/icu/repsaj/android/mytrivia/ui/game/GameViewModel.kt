package icu.repsaj.android.mytrivia.ui.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.ICategoryRepo
import icu.repsaj.android.mytrivia.data.IGameHistoryRepo
import icu.repsaj.android.mytrivia.data.IQuestionRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
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

/**
 * ViewModel for the Game screen.
 * Manages the UI state and handles the business logic for the screen.
 *
 * @property categoryId The ID of the category to play the game with.
 * @property questionRepo The repository for question data operations.
 * @property historyRepo The repository for game history data operations.
 * @property categoryRepo The repository for category data operations.
 * @property resourceProvider Provides access to resources, such as strings.
 */
class GameViewModel(
    val categoryId: UUID,
    private val questionRepo: IQuestionRepo,
    private val historyRepo: IGameHistoryRepo,
    private val categoryRepo: ICategoryRepo,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUIState())
    val uiState = _uiState.asStateFlow()

    lateinit var uiCategory: StateFlow<Category>

    var apiState: QuestionsApiState by mutableStateOf(QuestionsApiState.Loading)
        private set


    init {
        getCategory()
        fetchQuestions()
    }

    /**
     * moves the game to the next question.
     */
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

    /**
     * @return True if the score dialog should be shown.
     */
    fun showScoreDialog(): Boolean {
        return _uiState.value.isAnswered && isLastQuestion()
    }

    /**
     * @return True if the current question is the last question.
     */
    fun isLastQuestion(): Boolean {
        return _uiState.value.currentQuestionIndex == _uiState.value.questions.size - 1
    }

    /**
     * Checks the answer and updates the UI state accordingly.
     *
     * @param answer The [TriviaAnswer] to check.
     */
    fun checkAnswer(answer: TriviaAnswer) {
        _uiState.update { currentState ->
            currentState.copy(
                isAnswered = true,
                score = if (answer.isCorrect) currentState.score + 1 else currentState.score,
            )
        }
    }

    /**
     * @return The current [TriviaQuestion].
     */
    fun getCurrentQuestion(): TriviaQuestion {
        return _uiState.value.questions[_uiState.value.currentQuestionIndex]
    }

    /**
     * @return The amount([Int]) of questions in the game.
     */
    fun getAmountOfQuestions(): Int {
        return _uiState.value.questions.size
    }

    /**
     * Saves the current game to the history.
     */
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

    /**
     * Fetches the questions from the repository.
     * If the fetch is successful, the UI state is updated with the new questions.
     * If the fetch fails, the UI state is updated with an error message.
     */
    fun fetchQuestions() {
        viewModelScope.launch {
            apiState = try {
                val questionsFlow = questionRepo.getQuestions(categoryId)
                if (questionsFlow != null) {
                    val questions = questionsFlow.toList().flatten()
                    _uiState.update { currentState ->
                        currentState.copy(questions = questions)
                    }
                    QuestionsApiState.Success
                } else {
                    QuestionsApiState.Error(resourceProvider.getString(R.string.no_questions_found))
                }
            } catch (e: RuntimeException) {
                e.printStackTrace()
                QuestionsApiState.Error(
                    e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            }
        }

    }

    /**
     * Fetches the category from the repository.
     * If the fetch is successful, the UI state is updated with the new category.
     * If the fetch fails, the UI state is updated with an error message.
     */
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
            } catch (e: RuntimeException) {
                e.printStackTrace()
                apiState = QuestionsApiState.Error(
                    e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            }
        }
    }


    companion object {
        /**
         * Factory for creating [GameViewModel].
         *
         * @param categoryId The ID of the category to play the game with.
         */
        fun factory(categoryId: UUID): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                val questionRepo = application.container.questionRepo
                val historyRepo = application.container.historyRepo
                val categoryRepo = application.container.categoryRepo
                val resourceProvider = application.container.resourceProvider
                GameViewModel(
                    categoryId = categoryId,
                    questionRepo = questionRepo,
                    historyRepo = historyRepo,
                    categoryRepo = categoryRepo,
                    resourceProvider = resourceProvider
                )
            }
        }
    }

}