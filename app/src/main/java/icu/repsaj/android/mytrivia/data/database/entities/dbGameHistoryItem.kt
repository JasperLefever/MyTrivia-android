package icu.repsaj.android.mytrivia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import icu.repsaj.android.mytrivia.model.HistoryItem
import java.util.Date
import java.util.UUID

@Entity(tableName = "game_history")
data class DbGameHistoryItem(
    @PrimaryKey(autoGenerate = true)
    var id: UUID,
    var category: String = "",
    var date: Date,
    var score: Int = 0
)

fun DbGameHistoryItem.asDomainObject(): HistoryItem {
    return HistoryItem(
        id = this.id,
        category = this.category,
        date = this.date,
        score = this.score
    )
}

fun HistoryItem.asDbEntity(): DbGameHistoryItem {
    return DbGameHistoryItem(
        id = this.id,
        category = this.category,
        date = this.date,
        score = this.score
    )
}

fun List<DbGameHistoryItem>.asDomainObjects(): List<HistoryItem> {
    return this.map { it.asDomainObject() }
}