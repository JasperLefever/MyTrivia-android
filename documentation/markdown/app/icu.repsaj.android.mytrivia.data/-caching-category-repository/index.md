//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)

# CachingCategoryRepository

[androidJvm]\
class [CachingCategoryRepository](index.md)(
categoryDao: [CategoryDao](../../icu.repsaj.android.mytrivia.data.database/-category-dao/index.md),
categoryApi: [ICategoryApiService](../../icu.repsaj.android.mytrivia.network.categroy/-i-category-api-service/index.md),
healthRepo: [IHealthRepo](../-i-health-repo/index.md)) : [ICategoryRepo](../-i-category-repo/index.md)

A repository implementation that caches categories locally and updates them from a remote API.

## Constructors

|                                                              |                                                                                                                                                                                                                                                                                                                 |
|--------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [CachingCategoryRepository](-caching-category-repository.md) | [androidJvm]<br>constructor(categoryDao: [CategoryDao](../../icu.repsaj.android.mytrivia.data.database/-category-dao/index.md), categoryApi: [ICategoryApiService](../../icu.repsaj.android.mytrivia.network.categroy/-i-category-api-service/index.md), healthRepo: [IHealthRepo](../-i-health-repo/index.md)) |

## Functions

| Name                                     | Summary                                                                                                                                                                                                                                                                                                                                            |
|------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [createCategory](create-category.md)     | [androidJvm]<br>open suspend override fun [createCategory](create-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Creates a new category via the API. After a successful creation, it refreshes the local database.                                                                              |
| [deleteCategory](delete-category.md)     | [androidJvm]<br>open suspend override fun [deleteCategory](delete-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Deletes a category via the API. After a successful deletion, it refreshes the local database.                                                                                  |
| [getCategories](get-categories.md)       | [androidJvm]<br>open override fun [getCategories](get-categories.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;&gt;<br>Retrieves all categories from the local database, converting them to domain objects. |
| [getCategoryById](get-category-by-id.md) | [androidJvm]<br>open override fun [getCategoryById](get-category-by-id.md)(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Flow&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;<br>Retrieves a specific category by its ID from the local database.                                 |
| [insertCategory](insert-category.md)     | [androidJvm]<br>open suspend override fun [insertCategory](insert-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Inserts a new category into the local database.                                                                                                                                |
| [refresh](refresh.md)                    | [androidJvm]<br>open suspend override fun [refresh](refresh.md)()<br>Refreshes the local category database by fetching the latest data from the API. It clears the current data and repopulates it with the latest data. In case of a network timeout, an appropriate action such as logging can be implemented.                                   |
