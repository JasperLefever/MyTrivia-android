package icu.repsaj.android.mytrivia.ui.gameHistory

import icu.repsaj.android.mytrivia.model.HistoryItem


sealed interface HistoryRepoState {
    object Success : HistoryRepoState
    data class Error(val message: String) : HistoryRepoState
    object Loading : HistoryRepoState
}

data class HistoryListState(val history: List<HistoryItem> = listOf())