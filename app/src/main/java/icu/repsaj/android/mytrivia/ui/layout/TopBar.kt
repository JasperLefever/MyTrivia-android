package icu.repsaj.android.mytrivia.ui.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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

@Composable
@OptIn(ExperimentalMaterial3Api::class)
public fun TopBar(
    currentScreen: NavRoutes,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    navigateHistory: () -> Unit,
    showQuitDialog: () -> Unit,
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
                    onClick = { if (currentScreen != NavRoutes.Game) navigateUp() else showQuitDialog() }
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
            }
        }
    )

}
