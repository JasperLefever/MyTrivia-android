package icu.repsaj.android.mytrivia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import icu.repsaj.android.mytrivia.model.Category
import java.util.UUID

/**
 * Represents a category entity in the database.
 *
 * @property id Unique identifier of the category, represented by a UUID.
 * @property name Name of the category.
 * @property icon Icon associated with the category. This is the icon string from SF Symbols.
 * @property questionCount The number of questions available in this category.
 */
@Entity(tableName = "categories")
data class DbCategory(
    @PrimaryKey
    val id: UUID,
    val name: String,
    val icon: String = "",
    val questionCount: Int = 0
)

/**
 * Converts a database entity [DbCategory] into its domain representation [Category].
 *
 * @return A [Category] object with the same properties as the [DbCategory].
 */
fun DbCategory.asDomainObject(): Category {
    return Category(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}

/**
 * Converts a domain object [Category] into a database entity [DbCategory].
 *
 * @return A [DbCategory] object with the same properties as the [Category].
 */
fun Category.asDbEntity(): DbCategory {
    return DbCategory(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}

/**
 * Extension function on List<[DbCategory]> to convert a list of database entities into a list of domain objects.
 *
 * @return A list of [Category] objects corresponding to the [DbCategory] objects in the list.
 */
fun List<DbCategory>.asDomainObjects(): List<Category> {
    return this.map { it.asDomainObject() }
}
