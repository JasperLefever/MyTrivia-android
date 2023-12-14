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
)

fun DbCategory.asDomainObject(): Category {
    return Category(id = this.id, name = this.name, icon = this.icon)
}

fun Category.asDbEntity(): DbCategory {
    return DbCategory(id = this.id, name = this.name, icon = this.icon)
}

fun List<DbCategory>.asDomainObjects(): List<Category> {
    return this.map { it.asDomainObject() }
}
