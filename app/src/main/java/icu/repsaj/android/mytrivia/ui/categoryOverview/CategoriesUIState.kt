package icu.repsaj.android.mytrivia.ui.categoryOverview

import icu.repsaj.android.mytrivia.model.Category

sealed interface CategoryApiState {
    object Success : CategoryApiState
    object Error : CategoryApiState
    object Loading : CategoryApiState
}

data class CategoryListState(val categoryList: List<Category> = listOf())