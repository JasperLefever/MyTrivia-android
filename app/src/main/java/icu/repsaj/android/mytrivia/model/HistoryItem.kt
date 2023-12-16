package icu.repsaj.android.mytrivia.model

import java.util.Date

data class HistoryItem(
    var id: Int? = null,
    var category: String = "",
    var date: Date,
    var score: Int = 0
)
