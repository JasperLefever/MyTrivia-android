package icu.repsaj.android.mytrivia.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import icu.repsaj.android.mytrivia.ui.compontents.formatDateTime
import icu.repsaj.android.mytrivia.ui.theme.spacing
import java.util.Date

@Composable
fun GameHistory() {
    Column(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)) {
        HistoryItemCard(ranking = 1, category = "movies", score = 20, date = Date())
        HistoryItemCard(ranking = 2, category = "movies", score = 20, date = Date())
        HistoryItemCard(ranking = 3, category = "movies", score = 20, date = Date())
        HistoryItemCard(ranking = 4, category = "movies", score = 20, date = Date())
    }
}

//TODO : fix spacing according material vraag docent
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryItemCard(
    ranking: Int,
    category: String,
    score: Int,
    date: Date,
    modifier: Modifier = Modifier
) {
    ListItem(
        leadingContent = {
            Text(
                text = "$ranking",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.medium),
                textAlign = TextAlign.Center
            )
        },
        headlineText = {
            Text(
                text = category,
                style = MaterialTheme.typography.headlineLarge,
            )
        }, supportingText = {
            Text(
                text = formatDateTime(date),
                style = MaterialTheme.typography.bodyLarge,
            )
        }, trailingContent = {
            Text(
                text = "Score: $score",
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    )
    Divider()
}
