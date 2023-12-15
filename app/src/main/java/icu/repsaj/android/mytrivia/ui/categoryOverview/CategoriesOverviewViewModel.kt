package icu.repsaj.android.mytrivia.ui.categoryOverview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.CategoryRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

class CategoriesOverviewViewModel(private val categoryRepo: CategoryRepo) :
    ViewModel() {

    lateinit var uiListState: StateFlow<CategoryListState>

    var apiState: CategoryApiState by mutableStateOf(CategoryApiState.Loading)
        private set

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        try {
            viewModelScope.launch { categoryRepo.refresh() }

            uiListState = categoryRepo.getCategories().map { CategoryListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = CategoryListState(),
                )
            apiState = CategoryApiState.Success
        } catch (e: IOException) {
            //TODO ERROR HANDLING
            apiState = CategoryApiState.Error
        }

    }

    fun refresh() {

        apiState = CategoryApiState.Loading

        fetchCategories()

    }

    companion object {
        private var Instance: CategoriesOverviewViewModel? = null
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                if (Instance == null) {
                    val application =
                        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                    val categoryRepo = application.container.categoryRepo
                    Instance = CategoriesOverviewViewModel(categoryRepo = categoryRepo)
                }
                Instance!!
            }
        }
    }

}