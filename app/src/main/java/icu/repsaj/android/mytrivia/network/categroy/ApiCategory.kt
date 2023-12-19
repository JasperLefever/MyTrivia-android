package icu.repsaj.android.mytrivia.network.categroy

import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.network.Metadata
import icu.repsaj.android.mytrivia.network.UUIDSerializer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Represents a category as defined in the API.
 * This data class is used for serialization and deserialization of category data from API responses.
 *
 * @property id Unique identifier of the category, serialized using [UUIDSerializer].
 * @property name Name of the category.
 * @property icon Icon key representing the category.
 * @property questionCount The number of questions available in this category, with a default value of 0.
 */
@Serializable
data class ApiCategory(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val icon: String,
    var questionCount: Int = 0
)

/**
 * Represents a response from the API for category requests.
 * This class encapsulates metadata and a list of [ApiCategory] items.
 *
 * @property metadata Metadata associated with the API response.
 * @property items List of categories returned by the API.
 */
@Serializable
data class CategoryResponse(
    val metadata: Metadata,
    val items: List<ApiCategory>
)

/**
 * Represents the data necessary to create a new category through the API.
 *
 * @property name Name of the new category.
 * @property icon Icon key for the new category.
 */
@Serializable
data class CreateCategory(
    val name: String,
    val icon: String
)

/**
 * Extension function on Flow<List<ApiCategory>> to convert a flow of API category lists into a flow of domain object lists.
 *
 * @return A [Flow] emitting lists of [Category] domain objects.
 */
fun Flow<List<ApiCategory>>.asDomainObjects(): Flow<List<Category>> {
    return this.map { it.asDomainObjects() }
}

/**
 * Extension function to convert a list of [ApiCategory] to a list of [Category] domain objects.
 *
 * @return A list of [Category] domain objects.
 */
fun List<ApiCategory>.asDomainObjects(): List<Category> {
    return this.map {
        Category(
            id = it.id,
            name = it.name,
            icon = it.icon,
            questionCount = it.questionCount
        )
    }
}

/**
 * Converts an individual [ApiCategory] to a [Category] domain object.
 *
 * @return A [Category] domain object.
 */
fun ApiCategory.asDomainObject(): Category {
    return Category(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}
