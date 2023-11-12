package icu.repsaj.android.mytrivia.ui

import icu.repsaj.android.mytrivia.model.Category

data class TriviaUIState(
    val currentCategoryId: Int? = null,
    val categories: List<Category> = emptyList(),
    val showQuitDialog: Boolean = false,
)
