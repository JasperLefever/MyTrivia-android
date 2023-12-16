package icu.repsaj.android.mytrivia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import icu.repsaj.android.mytrivia.model.Category
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
    var category: Category? = null


    NavHost(
        navController = navController,
        startDestination = NavRoutes.Categories.name,
        modifier = modifier
    ) {
        composable(route = NavRoutes.Categories.name) {
            CategoryOverviewScreen(
                navigateToGame = {
                    navController.navigate(NavRoutes.Game.name)
                },
                setCategory = {
                    category = it
                }
            )
        }
        composable(route = NavRoutes.Game.name) {
            TriviaGameScreen(
                navigateUp = {
                    navController.navigateUp()
                },
                viewModel = viewModel(
                    factory = GameViewModel.factory(
                        Category(
                            id = UUID.fromString(
                                "F41796BA-84A1-4F63-85FE-6D0D933C8628"
                            ), "Test", "https://www.google.com", 10
                        )
                    )
                )
            )
        }
        //TODO fix hardcoded category
        composable(route = NavRoutes.History.name) {
            GameHistory()
        }
        composable(route = NavRoutes.AddCategory.name) {
            AddCategoryView()
        }
    }
}