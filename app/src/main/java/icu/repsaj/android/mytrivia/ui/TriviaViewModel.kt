package icu.repsaj.android.mytrivia.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TriviaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TriviaUIState())
    val uiState: StateFlow<TriviaUIState> = _uiState.asStateFlow()


    init {
        reset()

        //make a list witch mock categories
        val cat = List(10) { index -> Category(index, "Category $index", Icons.Filled.CheckCircle) }


        //set uistate categories to the list of categories

        _uiState.value = TriviaUIState(categories = cat)
    }

    /**
     * Resets the state of the app to its default state
     */
    fun reset() {
        _uiState.value = TriviaUIState()
    }

    fun selectCategory(categoryId: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCategoryId = categoryId,
            )
        }
    }

    fun toggleQuitDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                showQuitDialog = currentState.showQuitDialog.not(),
            )
        }
    }
}