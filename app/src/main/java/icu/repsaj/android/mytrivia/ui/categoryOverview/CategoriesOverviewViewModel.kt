package icu.repsaj.android.mytrivia.ui.categoryOverview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.ICategoryRepo
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * ViewModel for the Categories Overview screen.
 * Manages the UI state and handles the business logic for the screen.
 *
 * @property categoryRepo The repository for category data operations.
 * @property resourceProvider Provides access to resources, such as strings.
 */
class CategoriesOverviewViewModel(
    private val categoryRepo: ICategoryRepo,
    private val resourceProvider: ResourceProvider
) :
    ViewModel() {

    lateinit var uiListState: StateFlow<CategoryListState>

    var apiState: CategoryApiState by mutableStateOf(CategoryApiState.Loading)
        private set

    init {
        fetchCategories()
    }

    /**
     * Fetches the categories from the repository.
     * If the fetch is successful, the UI state is updated with the new categories.
     * If the fetch fails, the UI state is updated with an error message.
     */
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                categoryRepo.refresh()
            } catch (e: RuntimeException) {
                apiState = CategoryApiState.Error(
                    message = e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            }
        }
        try {
            uiListState = categoryRepo.getCategories().map { CategoryListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = CategoryListState(),
                )
            apiState = CategoryApiState.Success
        } catch (e: Exception) {
            apiState = CategoryApiState.Error(
                message = e.message ?: resourceProvider.getString(R.string.unknown_error)
            )
        }

    }

    /**
     * Deletes a category from the repository.
     * If the delete is successful, the UI state is updated with the new categories.
     * If the delete fails, the UI state is updated with an error message.
     *
     * @param category The category to be deleted.
     */
    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            try {
                categoryRepo.deleteCategory(category)
            } catch (e: RuntimeException) {
                apiState = CategoryApiState.Error(
                    message = e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            } catch (e: Exception) {
                apiState = CategoryApiState.Error(
                    message = e.message ?: resourceProvider.getString(R.string.unknown_error)
                )
            }
        }
    }


    /**
     * Refreshes the categories from the repository.
     * If the refresh is successful, the UI state is updated with the new categories.
     * If the refresh fails, the UI state is updated with an error message.
     */
    fun refresh() {
        apiState = CategoryApiState.Loading
        fetchCategories()
    }

    companion object {
        /**
         * Factory for creating the ViewModel.
         * Provides the CategoryRepo and ResourceProvider dependencies to the ViewModel.
         */
        private var Instance: CategoriesOverviewViewModel? = null
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                if (Instance == null) {
                    val application =
                        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                    val categoryRepo = application.container.categoryRepo
                    val resourceProvider = application.container.resourceProvider
                    Instance = CategoriesOverviewViewModel(
                        categoryRepo = categoryRepo,
                        resourceProvider = resourceProvider
                    )
                }
                Instance!!
            }
        }
    }

}