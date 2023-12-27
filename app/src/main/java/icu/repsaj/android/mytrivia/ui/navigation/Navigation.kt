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
import icu.repsaj.android.mytrivia.ui.compontents.NoConnectionScreen
import icu.repsaj.android.mytrivia.ui.game.GameViewModel
import icu.repsaj.android.mytrivia.ui.game.TriviaGameScreen
import icu.repsaj.android.mytrivia.ui.gameHistory.GameHistory
import java.util.UUID

/**
 * Composable function that sets up the navigation graph for the application.
 * It defines the navigation routes and associates them with corresponding screens.
 *
 * @param navController The NavHostController that controls the navigation.
 * @param modifier The Modifier to be applied to the NavHost.
 */
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
                    navController.navigate(NavRoutes.Game.name + "/$categoryId")
                },
            )
        }
        composable(
            route = NavRoutes.Game.withArgs("{categoryId}"),
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backstackEntry ->
            NoConnectionScreen {
                TriviaGameScreen(
                    navigateUp = {
                        navController.popBackStack()
                    },
                    viewModel = viewModel(
                        factory = GameViewModel.factory(
                            categoryId = UUID.fromString(backstackEntry.arguments?.getString("categoryId"))
                        )
                    )
                )
            }
        }
        composable(route = NavRoutes.History.name) {
            GameHistory()
        }
        composable(route = NavRoutes.AddCategory.name) {
            NoConnectionScreen {
                AddCategoryView(
                    navigateUp = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}