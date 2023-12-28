package icu.repsaj.android.mytrivia.viewmodels

import icu.repsaj.android.mytrivia.data.ICategoryRepo
import icu.repsaj.android.mytrivia.data.IGameHistoryRepo
import icu.repsaj.android.mytrivia.data.IQuestionRepo
import icu.repsaj.android.mytrivia.fakes.FakeDataSource
import icu.repsaj.android.mytrivia.network.categroy.asDomainObject
import icu.repsaj.android.mytrivia.network.question.asDomainObject
import icu.repsaj.android.mytrivia.network.question.asDomainObjects
import icu.repsaj.android.mytrivia.ui.game.GameViewModel
import icu.repsaj.android.mytrivia.ui.game.QuestionsApiState
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.anyOrNull

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GameViewModelTest {

    @get:Rule
    val testCoroutineRule = TestDispatcherRule()

    @Mock
    private lateinit var questionRepo: IQuestionRepo

    @Mock
    private lateinit var historyRepo: IGameHistoryRepo

    @Mock
    private lateinit var categoryRepo: ICategoryRepo

    @Mock
    private lateinit var resourceProvider: ResourceProvider

    private lateinit var viewModel: GameViewModel

    private val categoryId = FakeDataSource.category.id
    private val sampleQuestions = FakeDataSource.questions.asDomainObjects()
    private val correctAnswer = FakeDataSource.correctAnswer.asDomainObject()
    private val incorrectAnswer = FakeDataSource.incorrectAnswer.asDomainObject()


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        `when`(categoryRepo.getCategoryById(categoryId)).thenReturn(flowOf(FakeDataSource.category.asDomainObject()))
        `when`(questionRepo.getQuestions(categoryId)).thenReturn(flowOf(sampleQuestions))
        viewModel =
            GameViewModel(categoryId, questionRepo, historyRepo, categoryRepo, resourceProvider)
    }

    @Test
    fun `fetches questions on init`() = runTest {
        viewModel.fetchQuestions()

        assertEquals(sampleQuestions, viewModel.uiState.value.questions)
        assertEquals(QuestionsApiState.Success, viewModel.apiState)
    }

    // Next question
    @Test
    fun `next question updates current question index`() = runTest {
        viewModel.nextQuestion()
        assertEquals(1, viewModel.uiState.value.currentQuestionIndex)
    }

    @Test
    fun `is last question returns true when current question index is last index`() = runTest {
        viewModel.nextQuestion()
        assertEquals(true, viewModel.isLastQuestion())
    }

    //show dialog
    @Test
    fun `show score score dialog returns true when is answered and last question`() = runTest {
        viewModel.nextQuestion()
        viewModel.checkAnswer(correctAnswer)
        assertEquals(true, viewModel.showScoreDialog())
    }

    @Test
    fun `show score score dialog returns false when is answered and not last question`() = runTest {
        viewModel.checkAnswer(correctAnswer)
        assertEquals(false, viewModel.showScoreDialog())
    }

    @Test
    fun `show score score dialog returns false when is not answered and last question`() = runTest {
        viewModel.nextQuestion()
        assertEquals(false, viewModel.showScoreDialog())
    }

    @Test
    fun `show score score dialog returns false when is not answered and not last question`() =
        runTest {
            assertEquals(false, viewModel.showScoreDialog())
        }

    //get current question
    @Test
    fun `get current question returns correct question`() = runTest {
        assertEquals(sampleQuestions[0], viewModel.getCurrentQuestion())
    }

    //get amount of questions
    @Test
    fun `get amount of questions returns correct amount`() = runTest {
        assertEquals(sampleQuestions.size, viewModel.getAmountOfQuestions())
    }


    // Check answer
    @Test
    fun `correct answer check answer updates score correctly`() = runTest {
        viewModel.checkAnswer(correctAnswer)
        assertEquals(1, viewModel.uiState.value.score)
    }

    @Test
    fun `incorrect answer check answer updates score correctly`() = runTest {
        viewModel.checkAnswer(incorrectAnswer)
        assertEquals(0, viewModel.uiState.value.score)
    }

    @Test
    fun `save history item saves correct data`() = runTest {
        viewModel.saveHistoryItem()
        verify(historyRepo, times(1)).insertHistoryItem(anyOrNull())
    }

    @Test
    fun `fetchQuestions updates state on success`() = runTest {
        viewModel.fetchQuestions()
        advanceUntilIdle()

        assertEquals(QuestionsApiState.Success, viewModel.apiState)
        assertEquals(sampleQuestions, viewModel.uiState.value.questions)
    }

    @Test
    fun `fetchQuestions sets error state when no questions found`() = runTest {
        `when`(questionRepo.getQuestions(any())).thenReturn(null)
        `when`(resourceProvider.getString(any())).thenReturn("No questions found for this category")

        viewModel.fetchQuestions()
        advanceUntilIdle()

        assertTrue(viewModel.apiState is QuestionsApiState.Error)
        assertEquals(
            "No questions found for this category",
            (viewModel.apiState as QuestionsApiState.Error).message
        )
    }

    @Test
    fun `fetchQuestions sets error state on exception`() = runTest {
        val runtimeException = RuntimeException("Test exception")
        `when`(questionRepo.getQuestions(any())).thenThrow(runtimeException)
        `when`(resourceProvider.getString(any())).thenReturn("Unknown error")

        viewModel.fetchQuestions()
        advanceUntilIdle()

        assertTrue(viewModel.apiState is QuestionsApiState.Error)
        assertEquals("Test exception", (viewModel.apiState as QuestionsApiState.Error).message)
    }

}

class TestDispatcherRule @OptIn(ExperimentalCoroutinesApi::class) constructor(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}
