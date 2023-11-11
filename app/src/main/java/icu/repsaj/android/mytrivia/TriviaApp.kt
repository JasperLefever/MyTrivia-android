package icu.repsaj.android.mytrivia

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import icu.repsaj.android.mytrivia.ui.CategoryOverviewScreen
import icu.repsaj.android.mytrivia.ui.NavRoutes
import icu.repsaj.android.mytrivia.ui.TopBar

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen =
        NavRoutes.valueOf(backStackEntry?.destination?.route ?: NavRoutes.Categories.name)

    Scaffold(
        topBar = {
            TopBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                navigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NavRoutes.Categories.name) {
                CategoryOverviewScreen()
            }
        }
    }
}

