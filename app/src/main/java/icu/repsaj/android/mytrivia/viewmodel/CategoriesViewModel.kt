package icu.repsaj.android.mytrivia.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import icu.repsaj.android.mytrivia.network.categroy.CategoryApi
import icu.repsaj.android.mytrivia.network.categroy.asDomainObjects
import icu.repsaj.android.mytrivia.state.CategoriesUIState
import kotlinx.coroutines.launch
import java.io.IOException

class CategoriesViewModel : ViewModel() {

    var categoryUIState: CategoriesUIState by mutableStateOf(CategoriesUIState.Loading)
        private set

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        viewModelScope.launch {
            categoryUIState = try {
                val result = CategoryApi.categoryService.getCategories(1, 10)
                CategoriesUIState.Success(result.asDomainObjects())
            } catch (e: IOException) {
                CategoriesUIState.Error(e.message ?: "Unknown error")
            }
        }
    }


}