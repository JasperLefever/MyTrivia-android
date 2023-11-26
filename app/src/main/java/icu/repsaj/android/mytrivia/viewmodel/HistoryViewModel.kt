package icu.repsaj.android.mytrivia.viewmodel

import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.state.HistoryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date
import java.util.UUID

class HistoryViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HistoryUIState())
    val uiState: StateFlow<HistoryUIState> = _uiState.asStateFlow()


    init {
        _uiState.update { currentState ->
            currentState.copy(
                history = fetchHistory()
            )

        }
    }

    fun fetchHistory(): List<HistoryItem> {
        return listOf(
            HistoryItem(UUID.randomUUID(), "Category 1", Date(), 2),
            HistoryItem(UUID.randomUUID(), "Category 54", Date(), 3),
            HistoryItem(UUID.randomUUID(), "Category 59", Date(), 7)
        )
    }

    fun deleteHistoryItem(historyItemId: UUID) {
        _uiState.update { currentState ->
            currentState.copy(
                history = currentState.history.filter { it.id != historyItemId }
            )
        }
    }

    fun addHistoryItem(item: HistoryItem) {

    }

    fun clearHistory() {

    }

    fun saveHistory() {

    }
}