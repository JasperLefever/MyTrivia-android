package icu.repsaj.android.mytrivia.ui.gameHistory

import icu.repsaj.android.mytrivia.model.HistoryItem


/**
 * Represents the state of the API call to fetch the game history.
 */
sealed interface HistoryRepoState {
    object Success : HistoryRepoState
    data class Error(val message: String) : HistoryRepoState
    object Loading : HistoryRepoState
}

/**
 * Represents the list of history items.
 */
data class HistoryListState(val history: List<HistoryItem> = listOf())