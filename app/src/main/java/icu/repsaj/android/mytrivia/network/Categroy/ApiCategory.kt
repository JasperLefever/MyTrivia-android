package icu.repsaj.android.mytrivia.network.Categroy

import icu.repsaj.android.mytrivia.model.Category
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ApiCategory(
    val id: UUID,
    val name: String,
    val icon: String,
)

@Serializable
data class CategoryResponse(
    val metadata: Metadata,
    val items: List<ApiCategory>
)

fun CategoryResponse.asDomainObjects(): List<Category> {
    return this.items.map { Category(id = it.id, name = it.name, icon = it.icon) }
}