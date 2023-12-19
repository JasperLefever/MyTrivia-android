package icu.repsaj.android.mytrivia.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.History
import androidx.compose.ui.graphics.vector.ImageVector
import icu.repsaj.android.mytrivia.R

/**
 * Enum defining the navigation routes used in the application
 *
 * @property title The string resource ID for the title of the route.
 * @property icon The icon associated with the route, represented as an ImageVector.
 */
enum class NavRoutes(@StringRes val title: Int, val icon: ImageVector) {
    Categories(title = R.string.categories, icon = Icons.Filled.Category),
    Game(title = R.string.game, icon = Icons.Filled.Gamepad),
    History(title = R.string.history, icon = Icons.Filled.History),
    AddCategory(title = R.string.add_category, icon = Icons.Filled.Add);

    /**
     * Constructs a navigation route string with optional arguments.
     * Useful for creating routes that require parameters.
     *
     * @param args Optional arguments to be appended to the route.
     * @return A navigation route string with appended arguments.
     */
    fun withArgs(vararg args: String): String {
        return this.name + if (args.isEmpty()) "" else args.joinToString(
            separator = "/",
            prefix = "/"
        )
    }

    companion object {
        /**
         * Retrieves the [NavRoutes] enum value corresponding to a given route string.
         * If the route string does not match any known routes, defaults to [NavRoutes.Categories].
         *
         * @param route The route string.
         * @return The corresponding [NavRoutes] value.
         */
        fun getNavRouteFromRoute(route: String?): NavRoutes {
            val baseRoute = route?.substringBefore("/") ?: NavRoutes.Categories.name

            return NavRoutes.values().find { it.name == baseRoute } ?: NavRoutes.Categories
        }
    }
}
