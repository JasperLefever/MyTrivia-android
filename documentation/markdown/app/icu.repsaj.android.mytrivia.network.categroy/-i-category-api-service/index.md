//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](../index.md)/[ICategoryApiService](index.md)

# ICategoryApiService

[androidJvm]\
interface [ICategoryApiService](index.md)

Interface defining the API service for category-related operations. This interface contains methods
to interact with the backend API for fetching, deleting, and creating categories.

## Functions

| Name                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|-----------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [createCategory](create-category.md)                | [androidJvm]<br>@POST(value = &quot;categories&quot;)<br>abstract suspend fun [createCategory](create-category.md)(@Bodycategory: [CreateCategory](../-create-category/index.md))<br>Creates a new category via the API.                                                                                                                                                                                                                                    |
| [deleteCategory](delete-category.md)                | [androidJvm]<br>@DELETE(value = &quot;categories/{id}&quot;)<br>abstract suspend fun [deleteCategory](delete-category.md)(@Path(value = &quot;id&quot;)id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Response&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Deletes a specific category identified by its UUID from the API.                                                    |
| [getCategories](get-categories.md)                  | [androidJvm]<br>@GET(value = &quot;categories&quot;)<br>abstract suspend fun [getCategories](get-categories.md)(@Query(value = &quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value = &quot;perPage&quot;)perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [CategoryResponse](../-category-response/index.md)<br>Fetches a list of categories from the API. |
| [getCategoriesAsFlow](../get-categories-as-flow.md) | [androidJvm]<br>fun [ICategoryApiService](index.md).[getCategoriesAsFlow](../get-categories-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiCategory](../-api-category/index.md)&gt;&gt;<br>Extension function to convert the API call for fetching categories into a Flow. This function encapsulates the API call within a Flow for reactive data handling.                        |
