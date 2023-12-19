package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.ui.graphics.vector.ImageVector

data class AddCategoryUiState(
    val categoryName: String = "",
    val selectedIcon: ImageVector? = null,
    val nameError: String = "",
    val iconError: String = "",
    val isValid: Boolean = false,
)

sealed interface AddCategoryApiState {
    object Init : AddCategoryApiState
    object Loading : AddCategoryApiState
    object Success : AddCategoryApiState
    data class Error(val message: String) : AddCategoryApiState
}