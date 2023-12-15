package icu.repsaj.android.mytrivia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import icu.repsaj.android.mytrivia.model.Category
import java.util.UUID

@Entity(tableName = "categories")
data class DbCategory(
    @PrimaryKey
    val id: UUID,
    val name: String,
    val icon: String = "",
    val questionCount: Int = 0
)

fun DbCategory.asDomainObject(): Category {
    return Category(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}

fun Category.asDbEntity(): DbCategory {
    return DbCategory(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}

fun List<DbCategory>.asDomainObjects(): List<Category> {
    return this.map { it.asDomainObject() }
}
