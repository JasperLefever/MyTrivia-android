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
import icu.repsaj.android.mytrivia.data.ICategoryRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.model.getIcon
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class AddCategoryViewModel(
    private val categoryRepo: ICategoryRepo,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddCategoryUiState())
    val uiState = _uiState.asStateFlow()

    var apiState: AddCategoryApiState by mutableStateOf(AddCategoryApiState.Init)
        private set

    fun addCategory(callback: () -> Unit) {
        try {
            if (_uiState.value.isValid.not()) {
                return
            }
            viewModelScope.launch {
                val category = Category(
                    id = UUID.randomUUID(),
                    name = _uiState.value.categoryName,
                    icon = getIcon(_uiState.value.selectedIcon!!),
                )
                categoryRepo.createCategory(category)
            }
            callback()
        } catch (e: Exception) {
            //TODO ERROR HANDLING
        }
    }

    fun setCategoryName(name: String) {
        _uiState.update {
            it.copy(categoryName = name.trim())
        }
        isValid()
    }


    fun setSelectedIcon(icon: ImageVector) {
        _uiState.update {
            it.copy(selectedIcon = icon)
        }
        isValid()
    }


    private fun validateCategoryName(): Boolean {
        return if (_uiState.value.categoryName.isBlank()) {
            _uiState.update {
                it.copy(nameError = resourceProvider.getString(R.string.category_name_cannot_be_empty))
            }
            false
        } else {
            _uiState.update {
                it.copy(nameError = "")
            }
            true
        }
    }

    private fun validateIcon(): Boolean {
        return if (_uiState.value.selectedIcon == null) {
            _uiState.update {
                it.copy(iconError = resourceProvider.getString(R.string.please_select_an_icon))
            }
            false
        } else {
            _uiState.update {
                it.copy(iconError = "")
            }
            true
        }
    }

    private fun isValid() {
        _uiState.update {
            it.copy(
                isValid = validateCategoryName() && validateIcon()
            )
        }
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
