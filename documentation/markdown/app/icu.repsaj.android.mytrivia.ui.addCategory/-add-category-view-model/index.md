//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.addCategory](../index.md)/[AddCategoryViewModel](index.md)

# AddCategoryViewModel

[androidJvm]\
class [AddCategoryViewModel](index.md)(
categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md),
resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the Add Category screen. Manages the UI state and handles the business logic for
adding a new category.

## Constructors

|                                                     |                                                                                                                                                                                                                                                |
|-----------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [AddCategoryViewModel](-add-category-view-model.md) | [androidJvm]<br>constructor(categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md), resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) |

## Types

| Name                             | Summary                                                 |
|----------------------------------|---------------------------------------------------------|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name                             | Summary                                                                                                                                                  |
|----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| [apiState](api-state.md)         | [androidJvm]<br>var [apiState](api-state.md): [AddCategoryApiState](../-add-category-api-state/index.md)                                                 |
| [toastMessage](toast-message.md) | [androidJvm]<br>val [toastMessage](toast-message.md): SharedFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [uiState](ui-state.md)           | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[AddCategoryUiState](../-add-category-ui-state/index.md)&gt;                                    |

## Functions

| Name                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                          |
|----------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [addCategory](add-category.md)                                                                                                   | [androidJvm]<br>fun [addCategory](add-category.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Handles the addition of a new category. If the current UI state is valid, it attempts to create a new category and invoke a callback function that navigates back to the previous screen. |
| [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html))     |
| [clear](clear.md)                                                                                                                | [androidJvm]<br>fun [clear](clear.md)()<br>Clears the UI state and resets the API state to its initial condition. This is typically used to reset the form after an error or upon navigating away.                                                                                                                                               |
| [setCategoryName](set-category-name.md)                                                                                          | [androidJvm]<br>fun [setCategoryName](set-category-name.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Updates the category name in the UI state. Triggers a validation check after updating the name.                                                                                           |
| [setSelectedIcon](set-selected-icon.md)                                                                                          | [androidJvm]<br>fun [setSelectedIcon](set-selected-icon.md)(icon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html))<br>Updates the selected icon in the UI state. Triggers a validation check after updating the icon.                                                         |
