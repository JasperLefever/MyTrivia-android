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
import java.util.UUID

data class Category(
    val id: UUID,
    val name: String,
    val icon: String = "",
    val questionCount: Int,
    val image: ImageVector = getImage(icon)
)

fun getImage(icon: String): ImageVector {
    return when (icon) {
        "movieclapper" -> {
            Icons.Filled.Movie
        }

        "music.note" -> {
            Icons.Filled.MusicNote
        }

        "sportscourt" -> {
            Icons.Filled.SportsFootball
        }

        "atom" -> {
            Icons.Filled.Science
        }

        "book" -> {
            Icons.Filled.Book
        }

        "map" -> {
            Icons.Filled.Map
        }

        "paintpalette" -> {
            Icons.Filled.Palette
        }

        else -> {
            Icons.Filled.Error
        }
    }
}
