package icu.repsaj.android.mytrivia.ui.game

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import icu.repsaj.android.mytrivia.ui.theme.spacing

@Composable
public fun TriviaGameScreen(
    navigateUp: () -> Unit,
    viewModel: GameViewModel,
    modifier: Modifier = Modifier
) {


    val gameUIState by viewModel.uiState.collectAsState()
    val questionsListState by viewModel.questionsListState.collectAsState()

    val apiState = viewModel.apiState

    Column(
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxHeight(),
    ) {
        CategoryTitle(currentCategory = gameUIState.category.name)

        GameCard(
            currentQuestion = gameUIState.currentQuestionIndex + 1,
            totalQuestions = questionsListState.questionsList.count(),
            score = gameUIState.score
        )

        if (gameUIState.isGameOver) {
            ScoreDialog(
                onConfirmation = { /*TODO*/ },
                dialogTitle = stringResource(R.string.game_over),
                dialogText = stringResource(R.string.final_score, gameUIState.score),
                icon = Icons.Filled.Check
            )
        } else {
            NextQuestion(nextQuestion = { viewModel.nextQuestion() })
        }

    }
    /*if (gameUIState.showQuitDialog) {
        ConfirmQuitDialog(
            onDismissRequest = gameUIState.onQuitDismissed,
            onConfirmation = gameUIState.onQuitConfirmed,
            dialogTitle = stringResource(R.string.quit_game),
            dialogText = stringResource(R.string.confirm_quit_game),
            icon = Icons.Filled.Close
        )
    }*/
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
private fun NextQuestion(nextQuestion: () -> Unit) {
    Button(
        onClick = nextQuestion,
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(text = stringResource(R.string.next))
    }
}

@Composable
private fun GameCard(currentQuestion: Int, totalQuestions: Int, score: Int) {
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            QuestionCounter(currentQuestion = currentQuestion, totalQuestions = totalQuestions)
            ScoreCounter(score = score)
        }

        Column(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
        ) {
            Question(question = "What is your favorite food?")

            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.medium))

            AnswerCard(
                answer = "Pasta",
                isSelected = selectedAnswer == "Pasta",
                isCorrect = false,
                onAnswerClick = { selectedAnswer = "Pasta" }
            )

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
    isSelected: Boolean,
    isCorrect: Boolean,
    onAnswerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) {
        if (isSelected && isCorrect) {
            Color.Green
        } else {
            MaterialTheme.colorScheme.error
        }
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small)
            .clickable { onAnswerClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = answer, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            if (isSelected) {
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


@Composable
fun ConfirmQuitDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
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
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(stringResource(R.string.confirm))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(stringResource(R.string.dismiss))
            }
        }
    )
}