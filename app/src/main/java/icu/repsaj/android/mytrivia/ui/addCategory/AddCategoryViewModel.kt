package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import icu.repsaj.android.mytrivia.model.Category
import kotlinx.coroutines.launch
import java.util.UUID

class AddCategoryViewModel : ViewModel() {

    var categoryName by mutableStateOf("")
    var selectedIcon by mutableStateOf<ImageVector?>(null)
    var icons by mutableStateOf(
        listOf(
            "movieclapper",
            "music.note",
            "sportscourt",
            "atom",
            "book",
            "map",
            "paintpalette"
        )
    )

    fun addCategory() {
        viewModelScope.launch {
            val category = Category(
                id = UUID.randomUUID(),
                name = categoryName,
                icon = selectedIcon?.name ?: "",
                questionCount = 0
            )
            //TODO implement add category
        }
    }

    fun isValid(): Boolean {
        return categoryName.isNotBlank() && selectedIcon != null
    }

}
