package icu.repsaj.android.mytrivia.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.History
import androidx.compose.ui.graphics.vector.ImageVector
import icu.repsaj.android.mytrivia.R

enum class NavRoutes(@StringRes val title: Int, val icon: ImageVector) {
    Categories(title = R.string.categories, icon = Icons.Filled.Category),
    Game(title = R.string.game, icon = Icons.Filled.Gamepad),
    History(title = R.string.history, icon = Icons.Filled.History),
    AddCategory(title = R.string.add_category, icon = Icons.Filled.Add);

    fun withArgs(vararg args: String): String {
        return this.name + args.joinToString(separator = "/", prefix = "/")
    }

    companion object {
        fun getNavRouteFromRoute(route: String?): NavRoutes {
            val baseRoute = route?.substringBefore("/") ?: NavRoutes.Categories.name

            return NavRoutes.values().find { it.name == baseRoute } ?: NavRoutes.Categories
        }
    }
}