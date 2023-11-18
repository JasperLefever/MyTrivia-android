package icu.repsaj.android.mytrivia.model

import java.util.Date
import java.util.UUID

data class HistoryItem(
    var id: UUID,
    var category: String = "",
    var date: Date,
    var score: Int = 0
)
