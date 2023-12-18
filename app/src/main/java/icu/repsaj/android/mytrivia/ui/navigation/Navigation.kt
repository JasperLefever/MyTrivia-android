package icu.repsaj.android.mytrivia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import icu.repsaj.android.mytrivia.ui.addCategory.AddCategoryView
import icu.repsaj.android.mytrivia.ui.categoryOverview.CategoryOverviewScreen
import icu.repsaj.android.mytrivia.ui.game.GameViewModel
import icu.repsaj.android.mytrivia.ui.game.TriviaGameScreen
import icu.repsaj.android.mytrivia.ui.gameHistory.GameHistory
import java.util.UUID

@Composable
fun NavComponent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {


    NavHost(
        navController = navController,
        startDestination = NavRoutes.Categories.name,
        modifier = modifier
    ) {
        composable(route = NavRoutes.Categories.name) {
            CategoryOverviewScreen(
                navigateToGame = { categoryId ->
                    navController.navigate("game/$categoryId")
                },
            )
        }
        composable(
            route = "game/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backstackEntry ->
            TriviaGameScreen(
                navigateUp = {
                    navController.navigateUp()
                },
                viewModel = viewModel(
                    factory = GameViewModel.factory(
                        categoryId = UUID.fromString(backstackEntry.arguments?.getString("categoryId"))
                    )
                )
            )

        }
        //TODO fix hardcoded category
        composable(route = NavRoutes.History.name) {
            GameHistory()
        }
        composable(route = NavRoutes.AddCategory.name) {
            AddCategoryView(
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}