package icu.repsaj.android.mytrivia.state

import icu.repsaj.android.mytrivia.model.HistoryItem

data class HistoryUIState(
    val history: List<HistoryItem> = emptyList()
)