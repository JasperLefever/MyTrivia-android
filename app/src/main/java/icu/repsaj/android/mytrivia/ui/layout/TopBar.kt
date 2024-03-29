package icu.repsaj.android.mytrivia.ui.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes

/**
 * Composable function that displays the top bar.
 *
 * @param currentScreen The current screen.
 * @param canNavigateBack Whether the user can navigate back.
 * @param navigateUp A function to navigate up.
 * @param navigateHistory A function to navigate to the history screen.
 * @param navigateAddCategory A function to navigate to the add category screen.
 * @param modifier The modifier to be applied to the top bar.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    currentScreen: NavRoutes,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    navigateHistory: () -> Unit,
    navigateAddCategory: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                stringResource(id = currentScreen.title),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        },
        actions = {
            if (currentScreen == NavRoutes.Categories) {
                IconButton(
                    onClick = navigateHistory
                ) {
                    Icon(
                        imageVector = Icons.Filled.History,
                        contentDescription = stringResource(R.string.history),
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = navigateAddCategory) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.add_category)
                    )
                }
            }
        }
    )

}

