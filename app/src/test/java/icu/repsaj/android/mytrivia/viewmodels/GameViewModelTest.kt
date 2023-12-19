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
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
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
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.anyOrNull

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GameViewModelTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var questionRepo: IQuestionRepo

    @Mock
    private lateinit var historyRepo: IGameHistoryRepo

    @Mock
    private lateinit var categoryRepo: ICategoryRepo

    private lateinit var viewModel: GameViewModel

    private val categoryId = FakeDataSource.category.id
    private val sampleQuestions = FakeDataSource.questions.asDomainObjects()
    private val correctAnswer = FakeDataSource.correctAnswer.asDomainObject()
    private val incorrectAnswer = FakeDataSource.incorrectAnswer.asDomainObject()


    @Before
    fun setUp() {
        `when`(categoryRepo.getCategoryById(categoryId)).thenReturn(flowOf(FakeDataSource.category.asDomainObject()))
        viewModel = GameViewModel(categoryId, questionRepo, historyRepo, categoryRepo)
    }

    @Test
    fun `fetches questions on init`() = testCoroutineRule.runBlockingTest {
        `when`(questionRepo.getQuestions(categoryId)).thenReturn(flowOf(sampleQuestions))

        viewModel.fetchQuestions()

        assertEquals(sampleQuestions, viewModel.uiState.value.questions)
        assertEquals(QuestionsApiState.Success, viewModel.apiState)
    }

    @Test
    fun `next question updates current question index`() = testCoroutineRule.runBlockingTest {
        viewModel.nextQuestion()
        assertEquals(1, viewModel.uiState.value.currentQuestionIndex)
    }

    @Test
    fun `correct answer check answer updates score correctly`() =
        testCoroutineRule.runBlockingTest {
            viewModel.checkAnswer(correctAnswer)
            assertEquals(1, viewModel.uiState.value.score)
        }

    @Test
    fun `incorrect answer check answer updates score correctly`() =
        testCoroutineRule.runBlockingTest {
            viewModel.checkAnswer(incorrectAnswer)
            assertEquals(0, viewModel.uiState.value.score)
        }

    @Test
    fun `save history item saves correct data`() = testCoroutineRule.runBlockingTest {
        viewModel.saveHistoryItem()
        verify(historyRepo, times(1)).insertHistoryItem(anyOrNull())
    }

    @Test
    fun `handle api error state correctly`() = testCoroutineRule.runBlockingTest {
        `when`(questionRepo.getQuestions(categoryId)).thenThrow(RuntimeException("API Error"))
        viewModel.fetchQuestions()
        assertEquals(QuestionsApiState.Error, viewModel.apiState)
    }
}

@ExperimentalCoroutinesApi
class TestCoroutineRule : TestWatcher() {
    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testCoroutineScope.cleanupTestCoroutines()
    }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) =
        testCoroutineScope.runBlockingTest { block() }
}