package icu.repsaj.android.mytrivia.ui.gameHistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.GameHistoryRepo
import icu.repsaj.android.mytrivia.model.HistoryItem
import icu.repsaj.android.mytrivia.state.HistoryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyRepo: GameHistoryRepo) : ViewModel() {

    private val _uiState = MutableStateFlow(HistoryUIState())
    val uiState: StateFlow<HistoryUIState> = _uiState.asStateFlow()

    init {
        fetchHistory()
    }

    fun fetchHistory() {
        viewModelScope.launch {
            historyRepo.getGameHistory().collect { historyItems ->
                _uiState.update { currentState ->
                    currentState.copy(history = historyItems)
                }
            }
        }
    }

    fun addHistoryItem(item: HistoryItem) {
        viewModelScope.launch {
            historyRepo.insertHistoryItem(item)
            fetchHistory()
        }
    }

    fun deleteHistoryItem(historyItemId: Int) {
        viewModelScope.launch {
            val itemToDelete = _uiState.value.history.find { it.id == historyItemId }
            itemToDelete?.let {
                historyRepo.deleteHistoryItem(it)
                fetchHistory()
            }
        }
    }

    companion object {
        private var Instance: HistoryViewModel? = null
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                if (Instance == null) {
                    val application =
                        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                    val historyRepo = application.container.historyRepo
                    Instance = HistoryViewModel(historyRepo = historyRepo)
                }
                Instance!!
            }
        }
    }
}