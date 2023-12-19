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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.ui.compontents.ErrorDialog
import icu.repsaj.android.mytrivia.ui.compontents.RecomposeChecker
import icu.repsaj.android.mytrivia.ui.compontents.SwipeToDelete
import icu.repsaj.android.mytrivia.ui.theme.spacing
import java.util.UUID

/**
 * Composable function that displays the UI for the category overview screen.
 *
 * @param navigateToGame A function to navigate to the game screen.
 * @param modifier The modifier to be applied to the screen.
 * @param viewModel The ViewModel that provides the state and handles logic.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryOverviewScreen(
    navigateToGame: (UUID) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CategoriesOverviewViewModel = viewModel(factory = CategoriesOverviewViewModel.Factory)
) {
    val categoryListState by viewModel.uiListState.collectAsState()
    val apiState = viewModel.apiState

    //everything to keep the refresh state
    val isRefreshing by remember {
        mutableStateOf(false)
    }
    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            viewModel.refresh()
        }
    )
    //end of refresh state

    //Check recomposition
    RecomposeChecker(viewName = "CategoryOverviewScreen")

    when (apiState) {
        is CategoryApiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CategoryApiState.Success -> {
            Box(modifier = modifier) {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.small)
                        .fillMaxSize()
                        .pullRefresh(refreshState)
                ) {
                    if (categoryListState.categoryList.isEmpty()) {
                        item {
                            NoCategoriesFound()
                        }
                    } else {
                        items(
                            items = categoryListState.categoryList,
                            key = { category -> category.id }
                        ) { category ->
                            SwipeToDelete(
                                item = category,
                                onDismiss = { deletedCategory ->
                                    viewModel.deleteCategory(deletedCategory)
                                },
                                itemContent = { category ->
                                    AnimatedCategoryCard(
                                        name = category.name,
                                        icon = category.image,
                                        enabled = category.questionCount > 0,
                                        onClickPlay = {
                                            navigateToGame(category.id)
                                        }
                                    )
                                }
                            )
                        }
                    }
                }

                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = refreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

        }

        is CategoryApiState.Error -> {
            ErrorDialog(
                dialogTitle = stringResource(id = R.string.error),
                dialogText = apiState.message,
                onConfirmation = viewModel::refresh
            )

        }
    }
}

/**
 * Composable function that displays a message when no categories are available.
 */
@Composable
private fun NoCategoriesFound() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = stringResource(R.string.no_categories_available),
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * A card that displays a category's name and icon.
 * The card is animated when it is first displayed.
 *
 * @param name The name of the category.
 * @param enabled Whether the card is enabled or not.
 * @param onClickPlay The callback to be invoked when the card is clicked.
 * @param modifier The modifier to be applied to the card.
 * @param icon The icon to be displayed on the card.
 */
@Composable
fun AnimatedCategoryCard(
    name: String,
    enabled: Boolean,
    onClickPlay: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.QuestionMark
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isVisible = true
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideIn(
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


/**
 * A card that displays a category's name and icon.
 *
 * @param name The name of the category.
 * @param enabled Whether the card is enabled or not.
 * @param onClickPlay The callback to be invoked when the card is clicked.
 * @param modifier The modifier to be applied to the card.
 * @param icon The icon to be displayed on the card.
 */
@Composable
fun CategoryCard(
    name: String,
    enabled: Boolean,
    onClickPlay: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.QuestionMark
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
                contentDescription = null,
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
                    contentDescription = null,
                    modifier = Modifier
                        .size(MaterialTheme.spacing.large)
                        .align(Alignment.CenterVertically),
                    tint = contentColor
                )
            }
        }
    }
}
