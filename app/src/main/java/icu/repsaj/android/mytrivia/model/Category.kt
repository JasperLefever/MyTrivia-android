package icu.repsaj.android.mytrivia.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.SportsFootball
import androidx.compose.ui.graphics.vector.ImageVector
import icu.repsaj.android.mytrivia.network.categroy.CreateCategory
import java.util.UUID

/**
 * Model class representing a trivia category.
 *
 * @property id Unique identifier of the category.
 * @property name Name of the category.
 * @property icon Icon key representing the category. SF Symbols are used for icons.
 * @property questionCount The number of questions available in this category.
 * @property image The graphical representation (ImageVector) for the category icon in android compose.
 */
data class Category(
    val id: UUID,
    val name: String,
    val icon: String = "",
    val questionCount: Int = 0,
    val image: ImageVector = getImage(icon)
)

/**
 * Maps icon keys to their corresponding ImageVector representations.
 */
val iconMap = mapOf(
    "movieclapper" to Icons.Filled.Movie,
    "music.note" to Icons.Filled.MusicNote,
    "sportscourt" to Icons.Filled.SportsFootball,
    "atom" to Icons.Filled.Science,
    "book" to Icons.Filled.Book,
    "map" to Icons.Filled.Map,
    "paintpalette" to Icons.Filled.Palette
)

/**
 * Retrieves the ImageVector representation of an icon for a given key.
 *
 * @param icon The key representing the icon.
 * @return The corresponding ImageVector, or a default error icon if the key is not found.
 */
fun getImage(icon: String): ImageVector {
    return iconMap[icon] ?: Icons.Filled.Error
}

/**
 * Retrieves the icon key for a given ImageVector.
 *
 * @param image The ImageVector representation of an icon.
 * @return The corresponding icon key, or "error" if the ImageVector is not found.
 */
fun getIcon(image: ImageVector): String {
    return iconMap.entries.firstOrNull { it.value == image }?.key ?: "error"
}

/**
 * Converts a [Category] instance to a [CreateCategory] instance for use in network requests.
 *
 * @return A [CreateCategory] object with the same name and icon as the [Category].
 */
fun Category.asPostCategory(): CreateCategory {
    return CreateCategory(
        name = this.name,
        icon = this.icon
    )
}
