package icu.repsaj.android.mytrivia.state

import icu.repsaj.android.mytrivia.model.Category

sealed interface CategoriesUIState {
    data class Success(val categories: List<Category> = emptyList()) : CategoriesUIState
    object Loading : CategoriesUIState
    data class Error(val message: String) : CategoriesUIState
}