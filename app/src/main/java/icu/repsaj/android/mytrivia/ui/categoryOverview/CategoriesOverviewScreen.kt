package icu.repsaj.android.mytrivia.ui.categoryOverview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.ui.theme.spacing

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

    val state = rememberPullRefreshState(
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
                        .pullRefresh(state)
                ) {
                    items(categoryListState.categoryList) { category ->
                        CategoryCard(
                            name = category.name,
                            icon = category.image,
                            enabled = category.questionCount > 0,
                            onClickPlay = {
                                setCategory(category)
                                navigateToGame()
                            })
                    }
                }

                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = state,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        is CategoryApiState.Error -> Text(text = "Error")
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
    // Determine the color based on the enabled state
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
                tint = contentColor // Apply the color here
            )

            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.displayMedium,
                color = contentColor // Apply the color here
            )

            Spacer(modifier = Modifier.weight(1f))

            if (enabled) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = name,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically),
                    tint = contentColor // Apply the color here
                )
            }
        }
    }
}

