package icu.repsaj.android.mytrivia.viewmodel

import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.state.CategoriesUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUIState())
    val uiState: StateFlow<CategoriesUIState> = _uiState.asStateFlow()


    init {

    }


    fun selectCategory(categoryId: Int) {

    }

    fun fetchCategories() {

    }


}