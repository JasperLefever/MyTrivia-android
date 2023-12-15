package icu.repsaj.android.mytrivia.ui.gameHistory

import icu.repsaj.android.mytrivia.model.HistoryItem

data class HistoryUIState(
    val history: List<HistoryItem> = emptyList()
)