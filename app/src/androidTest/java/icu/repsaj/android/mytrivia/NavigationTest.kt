package icu.repsaj.android.mytrivia

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import icu.repsaj.android.mytrivia.ui.TriviaApp
import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//Testen doen soms moeilijk omdat de input te snel wordt gegeven. rerunnen van de test kan helpen.
class NavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    private val category: String = "Music"

    @Before
    fun navHostSetup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            TriviaApp(
                navController = navController,
            )
        }
    }

    @Test
    fun verifyStartDestination() {
        val expectedStartDestination = NavRoutes.Categories.name

        assertEquals(
            expectedStartDestination,
            navController.currentBackStackEntry?.destination?.route
        )
    }


    @Test
    fun navigateToGameScreen_navigatesCorrectly() {
        composeTestRule
            .onNodeWithText(category)
            .performClick()

        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.Game.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )
    }

    @Test
    fun navigateToGameScreen_cannotNavigateToHistory() {
        composeTestRule
            .onNodeWithText(category)
            .performClick()


        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithStringIdDescription(R.string.history)
            .assertDoesNotExist()
    }

    @Test
    fun navigateToGameScreen_cannotNavigateToAddCategory() {
        composeTestRule
            .onNodeWithText(category)
            .performClick()

        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .assertDoesNotExist()
    }

    @Test
    fun navigateToGameScreen_canNavigateBack() {
        composeTestRule
            .onNodeWithText(category)
            .performClick()

        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithStringIdDescription(R.string.back_button)
            .assertIsDisplayed()
    }

    @Test
    fun navigateToAddCategoryScreen_navigatesCorrectly() {
        composeTestRule.onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()
        assertEquals(
            NavRoutes.AddCategory.name,
            navController.currentBackStackEntry?.destination?.route
        )
    }

    @Test
    fun navigateToAddCategoryScreen_correctView() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithStringId(R.string.category_information)
            .assertIsDisplayed()
    }

    @Test
    fun navigateToHistoryScreen_navigatesCorrectly() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.history)
            .performClick()

        composeTestRule.waitForIdle()
        assertEquals(
            NavRoutes.History.name,
            navController.currentBackStackEntry?.destination?.route
        )
    }

}
