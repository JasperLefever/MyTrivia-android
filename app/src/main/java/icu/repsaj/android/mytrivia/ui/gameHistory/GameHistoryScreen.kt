package icu.repsaj.android.mytrivia.ui.gameHistory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.ui.compontents.RecomposeChecker
import icu.repsaj.android.mytrivia.ui.compontents.SwipeToDelete
import icu.repsaj.android.mytrivia.ui.compontents.formatDateTime
import icu.repsaj.android.mytrivia.ui.theme.spacing
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameHistory(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = viewModel(factory = HistoryViewModel.Factory)
) {
    val isRefreshing by remember {
        mutableStateOf(false)
    }

    val historyListState by viewModel.uiListState.collectAsState()
    val repoState = viewModel.repoState

    val state = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            viewModel.fetchHistory()
        }
    )

    RecomposeChecker(viewName = "HistoryScreen")

    Box(modifier = modifier) {
        when (repoState) {
            is HistoryRepoState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )

            is HistoryRepoState.Error -> Text(
                text = repoState.message,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )

            is HistoryRepoState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.small)
                        .pullRefresh(state)
                ) {
                    if (historyListState.history.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.no_history_items_available),
                                    modifier = Modifier.align(Alignment.Center),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                        }
                    } else {
                        itemsIndexed(
                            items = historyListState.history,
                            key = { _, item -> item.id!! }
                        ) { _, historyItem ->
                            HistoryItem(
                                historyItem = historyItem,
                                onRemove = {
                                    viewModel.deleteHistoryItem(it)
                                }
                            )
                        }
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

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
                modifier = Modifier.padding(end = MaterialTheme.spacing.medium),
                textAlign = TextAlign.Center
            )
        },
        headlineContent = {
            Text(
                text = category,
                style = MaterialTheme.typography.headlineLarge,
            )
        },
        supportingContent = {
            Text(
                text = formatDateTime(date),
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        trailingContent = {
            Text(
                text = stringResource(id = R.string.gamescreen_score, score),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    )
    Divider()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryItem(
    historyItem: HistoryItem,
    onRemove: (HistoryItem) -> Unit,
    modifier: Modifier = Modifier
) {
    SwipeToDelete(
        item = historyItem,
        itemContent = { item ->
            HistoryItemCard(
                ranking = item.id!!,
                category = item.category,
                score = item.score,
                date = item.date
            )
        },
        onDismiss = onRemove
    )
}