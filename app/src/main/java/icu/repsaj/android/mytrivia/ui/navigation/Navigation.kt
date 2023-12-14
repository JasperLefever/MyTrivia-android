package icu.repsaj.android.mytrivia.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import icu.repsaj.android.mytrivia.ui.categoryOverview.CategoryOverviewScreen
import icu.repsaj.android.mytrivia.ui.game.TriviaGameScreen
import icu.repsaj.android.mytrivia.ui.gameHistory.GameHistory

@@Composable
fun NavComponent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Categories.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = NavRoutes.Categories.name) {
            CategoryOverviewScreen(
                navigateToGame = {
                    navController.navigate(NavRoutes.Game.name)
                },
            )
        }
        composable(route = NavRoutes.Game.name) {
            TriviaGameScreen(
                currentCategory = triviaUiState.currentCategory,
                showQuitDialog = triviaUiState.showQuitDialog,
                onQuitConfirmed = {
                    viewModel.reset()
                    navController.navigateUp()
                },
                onQuitDismissed = { viewModel.toggleQuitDialog() },
                isGameOver = triviaUiState.isGameOver,
                score = triviaUiState.score,
                nextQuestion = { viewModel.nextQuestion() },
                currentQuestionIndex = triviaUiState.currentQuestionIndex,
                totalQuestions = triviaUiState.questions.size,
            )
        }
        composable(route = NavRoutes.History.name) {
            GameHistory()
        }
    }
}