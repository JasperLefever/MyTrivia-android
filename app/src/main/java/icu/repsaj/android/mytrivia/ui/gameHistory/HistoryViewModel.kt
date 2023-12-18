package icu.repsaj.android.mytrivia.ui.gameHistory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import icu.repsaj.android.mytrivia.TriviaApplication
import icu.repsaj.android.mytrivia.data.GameHistoryRepo
import icu.repsaj.android.mytrivia.model.HistoryItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

class HistoryViewModel(private val historyRepo: GameHistoryRepo) : ViewModel() {

    lateinit var uiListState: StateFlow<HistoryListState>

    var repoState: HistoryRepoState by mutableStateOf(HistoryRepoState.Loading)
        private set

    init {
        fetchHistory()
    }

    fun fetchHistory() {
        try {
            uiListState = historyRepo.getGameHistory().map { HistoryListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = HistoryListState(),
                )
            repoState = HistoryRepoState.Success
        } catch (e: IOException) {
            //TODO ERROR HANDLING
            repoState = HistoryRepoState.Error(e.message ?: "Unknown error")
        }
    }

    fun deleteHistoryItem(item: HistoryItem) {
        try {
            viewModelScope.launch {
                historyRepo.deleteHistoryItem(item)
            }
        } catch (e: IOException) {
            //TODO ERROR HANDLING
            repoState = HistoryRepoState.Error(e.message ?: "Unknown error")
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TriviaApplication)
                val historyRepo = application.container.historyRepo
                HistoryViewModel(historyRepo = historyRepo)
            }
        }
    }
}