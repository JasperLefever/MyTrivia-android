//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.categoryOverview](../index.md)/[CategoriesOverviewViewModel](index.md)

# CategoriesOverviewViewModel

[androidJvm]\
class [CategoriesOverviewViewModel](index.md)(
categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md),
resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the Categories Overview screen. Manages the UI state and handles the business logic
for the screen.

## Constructors

|                                                                   |                                                                                                                                                                                                                                                |
|-------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [CategoriesOverviewViewModel](-categories-overview-view-model.md) | [androidJvm]<br>constructor(categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md), resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) |

## Types

| Name                             | Summary                                                 |
|----------------------------------|---------------------------------------------------------|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name                                       | Summary                                                                                                                                            |
|--------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| [apiState](api-state.md)                   | [androidJvm]<br>var [apiState](api-state.md): [CategoryApiState](../-category-api-state/index.md)                                                  |
| [isUsingLocalData](is-using-local-data.md) | [androidJvm]<br>var [isUsingLocalData](is-using-local-data.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [uiListState](ui-list-state.md)            | [androidJvm]<br>lateinit var [uiListState](ui-list-state.md): StateFlow&lt;[CategoryListState](../-category-list-state/index.md)&gt;               |

## Functions

| Name                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [deleteCategory](delete-category.md)                                                                                             | [androidJvm]<br>fun [deleteCategory](delete-category.md)(category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))<br>Deletes a category from the repository. If the delete is successful, the UI state is updated with the new categories. If the delete fails, the UI state is updated with an error message.      |
| [refresh](refresh.md)                                                                                                            | [androidJvm]<br>fun [refresh](refresh.md)()<br>Refreshes the categories from the repository. If the refresh is successful, the UI state is updated with the new categories. If the refresh fails, the UI state is updated with an error message.                                                                                             |
