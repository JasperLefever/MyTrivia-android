package icu.repsaj.android.mytrivia.ui.layout

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes

@Composable
fun BottomBar(
    currentScreen: NavRoutes,
    navigateToCategories: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToAddQuestion: () -> Unit,
    modifier: Modifier = Modifier

) {
    val items: List<NavRoutes> by remember {
        mutableStateOf(listOf(NavRoutes.Categories, NavRoutes.AddQuestion, NavRoutes.History))
    }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = item.title))
                },
                selected = currentScreen == item,
                onClick = {
                    when (item) {
                        NavRoutes.Categories -> navigateToCategories()
                        NavRoutes.History -> navigateToHistory()
                        NavRoutes.AddQuestion -> navigateToAddQuestion()
                        else -> {}
                    }
                }
            )
        }
    }
}