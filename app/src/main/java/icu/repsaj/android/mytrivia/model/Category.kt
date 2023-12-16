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

data class Category(
    val id: UUID,
    val name: String,
    val icon: String = "",
    val questionCount: Int = 0,
    val image: ImageVector = getImage(icon)
)

val iconMap = mapOf(
    "movieclapper" to Icons.Filled.Movie,
    "music.note" to Icons.Filled.MusicNote,
    "sportscourt" to Icons.Filled.SportsFootball,
    "atom" to Icons.Filled.Science,
    "book" to Icons.Filled.Book,
    "map" to Icons.Filled.Map,
    "paintpalette" to Icons.Filled.Palette
)

fun getImage(icon: String): ImageVector {
    return iconMap[icon] ?: Icons.Filled.Error
}

fun getIcon(image: ImageVector): String {
    return iconMap.entries.firstOrNull { it.value == image }?.key ?: "error"
}

fun Category.asPostCategory(): CreateCategory {
    return CreateCategory(
        name = this.name,
        icon = this.icon
    )
}