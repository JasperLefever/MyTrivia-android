package icu.repsaj.android.mytrivia.ui.categoryOverview

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.ui.theme.spacing
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryOverviewScreen(
    navigateToGame: () -> Unit,
    setCategory: (Category) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CategoriesOverviewViewModel = viewModel(factory = CategoriesOverviewViewModel.Factory)
) {
    val categoryListState by viewModel.uiListState.collectAsState()
    val apiState = viewModel.apiState

    val isRefreshing by remember {
        mutableStateOf(false)
    }

    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            viewModel.fetchCategories()
        }
    )

    when (apiState) {
        is CategoryApiState.Loading -> CircularProgressIndicator()
        is CategoryApiState.Success -> {
            Box {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.small)
                        .pullRefresh(refreshState)
                ) {
                    items(
                        categoryListState.categoryList,
                        key = { category -> category.id }) { category ->
                        var isVisible by remember { mutableStateOf(false) }
                        LaunchedEffect(key1 = category) {
                            delay(150L * categoryListState.categoryList.indexOf(category))
                            isVisible = true
                        }

                        AnimatedCategoryCard(
                            name = category.name,
                            icon = category.image,
                            enabled = category.questionCount > 0,
                            onClickPlay = {
                                setCategory(category)
                                navigateToGame()
                            },
                            isVisible = isVisible
                        )
                    }
                }

                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = refreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        is CategoryApiState.Error -> Text(text = "Error")
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCategoryCard(
    name: String = "",
    icon: ImageVector = Icons.Filled.QuestionMark,
    enabled: Boolean,
    onClickPlay: () -> Unit = {},
    modifier: Modifier = Modifier,
    isVisible: Boolean = true
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideIn(
            // Slide in from left to right
            initialOffset = { fullSize -> IntOffset(-fullSize.width, 0) },
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        CategoryCard(
            name = name,
            icon = icon,
            enabled = enabled,
            onClickPlay = onClickPlay,
            modifier = modifier
        )
    }
}

@Composable
fun CategoryCard(
    name: String = "",
    icon: ImageVector = Icons.Filled.QuestionMark,
    enabled: Boolean,
    onClickPlay: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val contentColor = if (enabled) MaterialTheme.colorScheme.onSurface
    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)

    ElevatedCard(
        modifier = modifier
            .padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.extraSmall
            )
            .fillMaxWidth()
            .clickable(enabled = enabled) { onClickPlay() },
    ) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = MaterialTheme.spacing.medium)
                    .align(Alignment.CenterVertically),
                tint = contentColor
            )

            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.displayMedium,
                color = contentColor
            )

            Spacer(modifier = Modifier.weight(1f))

            if (enabled) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Play",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically),
                    tint = contentColor
                )
            }
        }
    }
}
