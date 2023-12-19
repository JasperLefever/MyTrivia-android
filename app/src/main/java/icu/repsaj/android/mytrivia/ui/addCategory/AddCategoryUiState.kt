package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents the UI state for adding a new category.
 * This data class is used to track the current state of the UI elements involved in adding a category.
 *
 * @property categoryName The current text entered for the category name.
 * @property selectedIcon The currently selected icon as an ImageVector, or null if no icon is selected.
 * @property nameError Error message related to the category name input, if any.
 * @property iconError Error message related to the icon selection, if any.
 * @property isValid Flag indicating whether the current state is valid for submitting the new category.
 */
data class AddCategoryUiState(
    val categoryName: String = "",
    val selectedIcon: ImageVector? = null,
    val nameError: String = "",
    val iconError: String = "",
    val isValid: Boolean = false,
)

/**
 * Represents the possible states of the API call for adding a new category.
 * This sealed interface is used to encapsulate the various states of the API interaction, from initialization to completion.
 */
sealed interface AddCategoryApiState {
    object Init : AddCategoryApiState
    object Loading : AddCategoryApiState
    object Success : AddCategoryApiState
    data class Error(val message: String) : AddCategoryApiState
}