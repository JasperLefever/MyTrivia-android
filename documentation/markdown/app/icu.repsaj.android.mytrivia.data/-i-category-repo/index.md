//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[ICategoryRepo](index.md)

# ICategoryRepo

interface [ICategoryRepo](index.md)

Repository interface for handling category data operations.

#### Inheritors

|                                                                       |
|-----------------------------------------------------------------------|
| [CachingCategoryRepository](../-caching-category-repository/index.md) |

## Functions

| Name                                     | Summary                                                                                                                                                                                                                                                                               |
|------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [createCategory](create-category.md)     | [androidJvm]<br>abstract suspend fun [createCategory](create-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Creates a new category via the API.                                                                                    |
| [deleteCategory](delete-category.md)     | [androidJvm]<br>abstract suspend fun [deleteCategory](delete-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Deletes a category                                                                                                     |
| [getCategories](get-categories.md)       | [androidJvm]<br>abstract fun [getCategories](get-categories.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;&gt;<br>Retrieves all categories.    |
| [getCategoryById](get-category-by-id.md) | [androidJvm]<br>abstract fun [getCategoryById](get-category-by-id.md)(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Flow&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;<br>Retrieves a specific category by its ID. |
| [insertCategory](insert-category.md)     | [androidJvm]<br>abstract suspend fun [insertCategory](insert-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Inserts a new category into the local database.                                                                        |
| [refresh](refresh.md)                    | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)()<br>Refreshes the local categories database.                                                                                                                                                                              |
