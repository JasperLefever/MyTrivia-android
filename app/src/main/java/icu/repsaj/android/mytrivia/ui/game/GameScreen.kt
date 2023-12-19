package icu.repsaj.android.mytrivia.ui.game

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import icu.repsaj.android.mytrivia.ui.compontents.RecomposeChecker
import icu.repsaj.android.mytrivia.ui.theme.spacing
import kotlinx.coroutines.delay

@Composable
public fun TriviaGameScreen(
    navigateUp: () -> Unit,
    viewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    val gameUIState by viewModel.uiState.collectAsState()
    val apiState = viewModel.apiState

    var animateQuestionChange by remember { mutableStateOf(false) }

    val category by viewModel.uiCategory.collectAsState()
    RecomposeChecker(viewName = "GameScreen")

    Column(
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxHeight(),
    ) {
        if (apiState is QuestionsApiState.Loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            CategoryTitle(currentCategory = category.name)

            AnimatedGameCard(
                currentQuestion = viewModel.getCurrentQuestion(),
                currentQuestionIndex = gameUIState.currentQuestionIndex + 1,
                totalQuestions = viewModel.getAmountOfQuestions(),
                score = gameUIState.score,
                checkAnswer = viewModel::checkAnswer,
                isAnswered = gameUIState.isAnswered,
                animateQuestionChange = animateQuestionChange,
                onAnimationEnd = {
                    animateQuestionChange = false
                    viewModel.nextQuestion()
                }
            )

            if (viewModel.showScoreDialog()) {
                ScoreDialog(
                    onConfirmation = {
                        viewModel.saveHistoryItem()
                        navigateUp()
                    },
                    dialogTitle = stringResource(R.string.game_over),
                    dialogText = stringResource(R.string.final_score, gameUIState.score),
                    icon = Icons.Filled.Check
                )
            }
            if (!viewModel.isLastQuestion()) {
                NextQuestion(
                    nextQuestion = {
                        if (!animateQuestionChange) {
                            animateQuestionChange = true
                        }
                    },
                    isEnabled = gameUIState.isAnswered
                )
            }
        }
    }
}

@Composable
private fun AnimatedGameCard(
    currentQuestion: TriviaQuestion,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    score: Int,
    checkAnswer: (TriviaAnswer) -> Unit,
    isAnswered: Boolean,
    animateQuestionChange: Boolean,
    onAnimationEnd: () -> Unit
) {
    val showQuestion = remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = showQuestion.value,
        enter = slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(150)),
        exit = slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(150))
    ) {
        GameCard(
            currentQuestion = currentQuestion,
            currentQuestionIndex = currentQuestionIndex,
            totalQuestions = totalQuestions,
            score = score,
            checkAnswer = checkAnswer,
            isAnswered = isAnswered
        )
    }

    LaunchedEffect(animateQuestionChange) {
        if (animateQuestionChange) {
            showQuestion.value = false
            delay(150)
            onAnimationEnd()
            showQuestion.value = true
        }
    }
}

@Composable
private fun NextQuestion(nextQuestion: () -> Unit, isEnabled: Boolean) {
    Button(
        onClick = nextQuestion,
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(text = stringResource(R.string.next))
    }
}

@Composable
fun ScoreDialog(
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = null)
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(stringResource(R.string.confirm))
            }
        },
    )
}


@Composable
private fun GameCard(
    currentQuestion: TriviaQuestion,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    score: Int,
    checkAnswer: (TriviaAnswer) -> Unit,
    isAnswered: Boolean
) {
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            QuestionCounter(currentQuestion = currentQuestionIndex, totalQuestions = totalQuestions)
            ScoreCounter(score = score)
        }

        Column(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
        ) {
            Question(question = currentQuestion.question)

            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.medium))

            currentQuestion.answers.forEach { answer ->
                AnswerCard(
                    answer = answer.answer,
                    isCorrect = answer.isCorrect,
                    onAnswerClick = {
                        checkAnswer(answer)
                    },
                    isAnswered = isAnswered
                )
            }

        }
    }
}

@Composable
private fun CategoryTitle(currentCategory: String) {
    Text(
        text = currentCategory,
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.medium)
    )
}

@Composable
fun Question(
    question: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = question,
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AnswerCard(
    answer: String,
    isCorrect: Boolean,
    onAnswerClick: () -> Unit,
    isAnswered: Boolean,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when {
        isAnswered && isCorrect -> Color.Green
        isAnswered -> MaterialTheme.colorScheme.error
        else -> MaterialTheme.colorScheme.secondaryContainer
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small)
            .then(modifier)
            // Disable clicking if an answer is already selected
            .clickable(enabled = !isAnswered) {
                if (!isAnswered) {
                    onAnswerClick()
                }
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = answer, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            if (isAnswered) {
                if (isCorrect) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = null,
                        tint = Color.White
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun ScoreCounter(
    score: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.gamescreen_score, score),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        )
    }
}

@Composable
fun QuestionCounter(
    currentQuestion: Int,
    totalQuestions: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(
                R.string.gamescreen_question_counter,
                currentQuestion,
                totalQuestions
            ),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(MaterialTheme.spacing.small)
        )
    }
}
