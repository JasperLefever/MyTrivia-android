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
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * ViewModel for the Add Category screen.
 * Manages the UI state and handles the business logic for adding a new category.
 *
 * @property categoryRepo The repository for category data operations.
 * @property resourceProvider Provides access to resources, such as strings.
 */
class AddCategoryViewModel(
    private val categoryRepo: ICategoryRepo,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddCategoryUiState())
    val uiState = _uiState.asStateFlow()

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    var apiState: AddCategoryApiState by mutableStateOf(AddCategoryApiState.Init)
        private set

    /**
     * Handles the addition of a new category.
     * If the current UI state is valid, it attempts to create a new category and invoke a callback function that navigates back to the previous screen.
     *
     * @param callback A callback function to be executed after successfully adding the category.
     */
    fun addCategory(callback: () -> Unit) {
        if (_uiState.value.isValid.not()) {
            return
        }
        apiState = AddCategoryApiState.Loading
        viewModelScope.launch {
            try {
                val category = Category(
                    id = UUID.randomUUID(),
                    name = _uiState.value.categoryName,
                    icon = getIcon(_uiState.value.selectedIcon!!),
                )
                categoryRepo.createCategory(category)
                _toastMessage.emit(resourceProvider.getString(R.string.category_added_successfully))
                apiState = AddCategoryApiState.Success
                callback()
            } catch (e: RuntimeException) {
                apiState = AddCategoryApiState.Error(
                    message = e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            } catch (e: Exception) {
                apiState = AddCategoryApiState.Error(
                    message = e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            }
        }
    }

    /**
     * Updates the category name in the UI state.
     * Triggers a validation check after updating the name.
     *
     * @param name The new category name to be set.
     */
    fun setCategoryName(name: String) {
        _uiState.update {
            it.copy(categoryName = name.trim())
        }
        isValid()
    }


    /**
     * Updates the selected icon in the UI state.
     * Triggers a validation check after updating the icon.
     *
     * @param icon The new icon to be set.
     */
    fun setSelectedIcon(icon: ImageVector) {
        _uiState.update {
            it.copy(selectedIcon = icon)
        }
        isValid()
    }


    /**
     * Validates the currently entered category name.
     * If the name is blank, it sets the UI state's nameError to a message indicating that the name cannot be blank.
     */
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

    /**
     * Validates the currently selected icon.
     * If no icon is selected, it sets the UI state's iconError to a message indicating that an icon must be selected.
     */
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

    /**
     * Validates the current UI state. If the state is valid, it sets the UI state's isValid flag to true.
     */
    private fun isValid() {
        _uiState.update {
            it.copy(
                isValid = validateCategoryName() && validateIcon()
            )
        }
    }

    /**
     * Clears the UI state and resets the API state to its initial condition.
     * This is typically used to reset the form after an error or upon navigating away.
     */
    fun clear() {
        _uiState.update {
            it.copy(
                categoryName = "",
                selectedIcon = null,
                nameError = "",
                iconError = "",
                isValid = false,
            )
        }
        apiState = AddCategoryApiState.Init
    }

    companion object {
        /**
         * Factory for creating an instance of [AddCategoryViewModel].
         * Provides necessary dependencies like [ICategoryRepo] and [ResourceProvider].
         */
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
