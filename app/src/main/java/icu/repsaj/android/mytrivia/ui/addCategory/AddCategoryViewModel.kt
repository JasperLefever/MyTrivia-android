package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.CategoryRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.getIcon
import icu.repsaj.android.mytrivia.model.iconMap
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
import kotlinx.coroutines.launch
import java.util.UUID

class AddCategoryViewModel(
    private val categoryRepo: CategoryRepo,
    private val resourceProvider: ResourceProvider
) : ViewModel() {
    var categoryName = mutableStateOf("")
    var selectedIcon = mutableStateOf<ImageVector?>(null)
    var icons = mutableStateOf(
        iconMap.values.toList()
    )
    var errors: List<String> by mutableStateOf(emptyList())

    fun addCategory(callback: () -> Unit) {
        try {
            if (!isValid()) {
                return
            }
            viewModelScope.launch {
                val category = Category(
                    id = UUID.randomUUID(),
                    name = categoryName.value,
                    icon = getIcon(selectedIcon.value!!),
                )
                categoryRepo.createCategory(category)
            }
            callback()
        } catch (e: Exception) {
            //TODO ERROR HANDLING
        }
    }

    fun isValid(): Boolean {
        errors = emptyList()
        if (categoryName.value.isBlank()) {
            errors =
                errors + listOf(resourceProvider.getString(R.string.category_name_cannot_be_empty))
        }
        if (selectedIcon == null) {
            errors = errors + listOf(resourceProvider.getString(R.string.please_select_an_icon))
        }
        return categoryName.value.isNotBlank() && selectedIcon != null
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                val categoryRepo = application.container.categoryRepo
                val resourceProvider = application.container.resourceProvider
                AddCategoryViewModel(categoryRepo, resourceProvider)
            }
        }
    }
}
