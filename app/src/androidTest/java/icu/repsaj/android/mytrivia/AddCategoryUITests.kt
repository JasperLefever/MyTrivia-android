package icu.repsaj.android.mytrivia

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
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
            .onNodeWithStringIdDescription(R.string.history)
            .performClick()

        composeTestRule.waitForIdle()

        assertEquals(
            NavRoutes.AddCategory.name,
            NavRoutes.getNavRouteFromRoute(navController.currentBackStackEntry?.destination?.route).name
        )
    }


}