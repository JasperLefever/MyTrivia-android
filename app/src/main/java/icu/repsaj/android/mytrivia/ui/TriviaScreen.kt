package icu.repsaj.android.mytrivia.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
fun TriviaGameScreen(
    showQuitDialog: Boolean,
    onQuitConfirmed: () -> Unit,
    onQuitDismissed: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxHeight(),
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                QuestionCounter(1, 10)
                ScoreCounter(1)
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

                AnswerCard(
                    answer = "Pizza",
                    isSelected = selectedAnswer == "Pizza",
                    isCorrect = true,
                    onAnswerClick = { selectedAnswer = "Pizza" }
                )

                AnswerCard(
                    answer = "Broodje",
                    isSelected = selectedAnswer == "Broodje",
                    isCorrect = false,
                    onAnswerClick = { selectedAnswer = "Broodje" }
                )

            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small)
        ) {
            Text(text = stringResource(R.string.next))
        }

    }
    if (showQuitDialog) {
        ConfirmQuitDialog(
            onDismissRequest = onQuitDismissed,
            onConfirmation = onQuitConfirmed,
            dialogTitle = stringResource(R.string.quit_game),
            dialogText = stringResource(R.string.confirm_quit_game),
            icon = Icons.Filled.Close
        )
    }
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