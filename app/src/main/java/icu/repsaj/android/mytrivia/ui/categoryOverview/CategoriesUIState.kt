package icu.repsaj.android.mytrivia.ui.categoryOverview

import icu.repsaj.android.mytrivia.model.Category

/**
 * Represents the state of the API call to fetch categories.
 */
sealed interface CategoryApiState {
    object Success : CategoryApiState
    data class Error(val message: String) : CategoryApiState
    object Loading : CategoryApiState
}

/**
 * Represents the state of the list of categories.
 */
data class CategoryListState(val categoryList: List<Category> = listOf())