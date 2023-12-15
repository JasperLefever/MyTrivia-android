package icu.repsaj.android.mytrivia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import icu.repsaj.android.mytrivia.ui.layout.TopBar
import icu.repsaj.android.mytrivia.ui.navigation.NavComponent
import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen =
        NavRoutes.valueOf(backStackEntry?.destination?.route ?: NavRoutes.Categories.name)

    Scaffold(
        topBar = {
            TopBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                navigateUp = { navController.navigateUp() },
                navigateHistory = { navController.navigate(NavRoutes.History.name) },
            )
        }
    ) { innerPadding ->
        NavComponent(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

