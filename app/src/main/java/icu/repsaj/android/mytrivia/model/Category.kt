package icu.repsaj.android.mytrivia.model

import androidx.compose.ui.graphics.vector.ImageVector
import java.util.UUID

data class Category(
    val id: UUID,
    val name: String,
    val image: ImageVector
)
