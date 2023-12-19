//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](../index.md)/[ICategoryApiService](index.md)/[createCategory](create-category.md)

# createCategory

[androidJvm]\

@POST(value = &quot;categories&quot;)

abstract suspend fun [createCategory](create-category.md)(
@Bodycategory: [CreateCategory](../-create-category/index.md))

Creates a new category via the API.

#### Parameters

androidJvm

|          |                                                                                                                 |
|----------|-----------------------------------------------------------------------------------------------------------------|
| category | The [CreateCategory](../-create-category/index.md) object containing the details of the category to be created. |
