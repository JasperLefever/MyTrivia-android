package icu.repsaj.android.mytrivia.network.categroy

import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.network.Metadata
import icu.repsaj.android.mytrivia.network.UUIDSerializer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ApiCategory(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val icon: String,
    var questionCount: Int = 0
)

@Serializable
data class CategoryResponse(
    val metadata: Metadata,
    val items: List<ApiCategory>
)

@Serializable
data class CreateCategory(
    val name: String,
    val icon: String
)


fun Flow<List<ApiCategory>>.asDomainObjects(): Flow<List<Category>> {
    return this.map {
        it.asDomainObjects()
    }
}

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

fun ApiCategory.asDomainObject(): Category {
    return Category(
        id = this.id,
        name = this.name,
        icon = this.icon,
        questionCount = this.questionCount
    )
}