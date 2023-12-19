package icu.repsaj.android.mytrivia.model

import java.util.Date

/**
 * Data class representing a history item.
 *
 * @property id The ID of the history item.
 * @property category The category of the history item.
 * @property date The [Date] on which the history item was created.
 * @property score The score of the history item.
 */
data class HistoryItem(
    var id: Int? = null,
    var category: String = "",
    var date: Date,
    var score: Int = 0
)
