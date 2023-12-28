//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](../index.md)/[ICategoryApiService](index.md)/[deleteCategory](delete-category.md)

# deleteCategory

[androidJvm]\

@DELETE(value = &quot;categories/{id}&quot;)

abstract suspend fun [deleteCategory](delete-category.md)(@Path(value = &quot;id&quot;)
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)):
Response&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;

Deletes a specific category identified by its UUID from the API.

#### Return

A empty Response object.

#### Parameters

androidJvm

|    |                                         |
|----|-----------------------------------------|
| id | The UUID of the category to be deleted. |
