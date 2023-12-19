package icu.repsaj.android.mytrivia

import icu.repsaj.android.mytrivia.ui.navigation.NavRoutes
import org.junit.Assert.assertEquals
import org.junit.Test

class NavRoutesTest {

    @Test
    fun testWithArgs_NoArgs() {
        assertEquals("Categories", NavRoutes.Categories.withArgs())
    }

    @Test
    fun testWithArgs_SingleArg() {
        assertEquals("Game/arg1", NavRoutes.Game.withArgs("arg1"))
    }

    @Test
    fun testWithArgs_MultipleArgs() {
        assertEquals("History/arg1/arg2", NavRoutes.History.withArgs("arg1", "arg2"))
    }

    // testen voor getNavRouteFromRoute
    @Test
    fun testGetNavRouteFromRoute_NullRoute() {
        assertEquals(NavRoutes.Categories, NavRoutes.getNavRouteFromRoute(null))
    }

    @Test
    fun testGetNavRouteFromRoute_ValidRoute() {
        NavRoutes.values().forEach { route ->
            assertEquals(route, NavRoutes.getNavRouteFromRoute(route.name))
        }
    }

    @Test
    fun testGetNavRouteFromRoute_InvalidRoute() {
        assertEquals(NavRoutes.Categories, NavRoutes.getNavRouteFromRoute("InvalidRoute"))
    }

    @Test
    fun testGetNavRouteFromRoute_RouteWithAdditionalPath() {
        assertEquals(NavRoutes.AddCategory, NavRoutes.getNavRouteFromRoute("AddCategory/OtherPath"))
    }
}