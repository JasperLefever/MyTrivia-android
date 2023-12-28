package icu.repsaj.android.mytrivia

import androidx.activity.ComponentActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import icu.repsaj.android.mytrivia.ui.TriviaApp
import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class AddCategoryUITests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

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
    fun navigateToAddCategoryScreen_navigatesCorrectly() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.AddCategory.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )
    }

    @Test
    fun makeNewCategory_successfully() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithStringId(R.string.category_name)
            .performTextInput("TestCategory")

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithContentDescription(Icons.Filled.Movie.toString())
            .performClick()

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category_button)
            .performClick()
        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.Categories.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )

        composeTestRule
            .onNodeWithText("TestCategory")
            .assertExists()


        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("TestCategory").performTouchInput {
            swipeLeft()
        }

        composeTestRule.waitForIdle()
    }

    @Test
    fun makeNewCategory_noName_fails() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithContentDescription(Icons.Filled.Movie.toString())
            .performClick()

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category_button)
            .assertIsNotEnabled()

        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.AddCategory.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )

        composeTestRule
            .onNodeWithStringId(R.string.category_name_cannot_be_empty)
            .assertExists()

    }

    @Test
    fun makeNewCategory_noIcon_fails() {
        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category)
            .performClick()

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithStringId(R.string.category_name)
            .performTextInput("TestCategory")

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithStringIdDescription(R.string.add_category_button)
            .assertIsNotEnabled()

        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.AddCategory.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )

        composeTestRule
            .onNodeWithStringId(R.string.please_select_an_icon)
            .assertExists()
    }


}