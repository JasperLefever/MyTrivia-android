package icu.repsaj.android.mytrivia.ui.gameHistory

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.model.HistoryItem
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

    Box(modifier = modifier) {
        if (repoState is HistoryRepoState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (repoState is HistoryRepoState.Error) {
            Text(
                text = repoState.message,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )
        } else if (historyListState.history.isEmpty()) {
            Text(
                text = stringResource(R.string.no_history_items_available),
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = MaterialTheme.spacing.small)
                    .pullRefresh(state)
            ) {
                itemsIndexed(
                    items = historyListState.history,
                    key = { _, item -> item.id!! }) { _, historyItem ->
                    HistoryItem(
                        historyItem = historyItem,
                        onRemove = {
                            viewModel.deleteHistoryItem(it)
                        }
                    )
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
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.medium),
                textAlign = TextAlign.Center
            )
        },
        headlineContent = {
            Text(
                text = category,
                style = MaterialTheme.typography.headlineLarge,
            )
        }, supportingContent = {
            Text(
                text = formatDateTime(date),
                style = MaterialTheme.typography.bodyLarge,
            )
        }, trailingContent = {
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
fun DismissBackground(dismissState: DismissState) {
    val color = when (dismissState.dismissDirection) {
        DismissDirection.EndToStart -> Color(0xFFFF1744)
        DismissDirection.StartToEnd -> Color(0xFFFF1744)
        null -> Color.Transparent
    }
    val direction = dismissState.dismissDirection

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        if (direction == DismissDirection.StartToEnd) Icon(
            Icons.Default.Delete,
            contentDescription = null
        )
        Spacer(modifier = Modifier)
        if (direction == DismissDirection.EndToStart) Icon(
            Icons.Default.Delete,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryItem(
    historyItem: HistoryItem,
    onRemove: (HistoryItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var show by remember { mutableStateOf(true) }
    val currentItem by rememberUpdatedState(historyItem)
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                show = false
                true
            } else false
        }, positionalThreshold = { 150.dp.toPx() }
    )
    AnimatedVisibility(
        show, exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier,
            background = {
                DismissBackground(dismissState)
            },
            dismissContent = {
                HistoryItemCard(
                    ranking = historyItem.id!!,
                    category = historyItem.category,
                    score = historyItem.score,
                    date = historyItem.date
                )
            }
        )
    }

    LaunchedEffect(show) {
        if (!show) {
            onRemove(currentItem)
            Toast.makeText(context, context.getText(R.string.item_removed), Toast.LENGTH_SHORT)
                .show()
        }
    }
}

