package icu.repsaj.android.mytrivia.ui.navigation

import androidx.annotation.StringRes
import icu.repsaj.android.mytrivia.R

enum class NavRoutes(@StringRes val title: Int) {
    Categories(title = R.string.categories),
    Game(title = R.string.game),
    History(title = R.string.history),
    AddCategory(title = R.string.add_category),
}