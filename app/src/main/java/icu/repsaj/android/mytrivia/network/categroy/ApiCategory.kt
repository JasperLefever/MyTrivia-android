package icu.repsaj.android.mytrivia.network.categroy

import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.network.Metadata
import icu.repsaj.android.mytrivia.network.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ApiCategory(
    @Serializable(with = UUIDSerializer::class)
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