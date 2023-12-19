//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.addCategory](../index.md)/[AddCategoryUiState](index.md)

# AddCategoryUiState

[androidJvm]\
data class [AddCategoryUiState](index.md)(val
categoryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, val
selectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)? =
null, val
nameError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, val
iconError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, val
isValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Represents the UI state for adding a new category. This data class is used to track the current
state of the UI elements involved in adding a category.

## Constructors

|                                                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
|-------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [AddCategoryUiState](-add-category-ui-state.md) | [androidJvm]<br>constructor(categoryName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, selectedIcon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)? = null, nameError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, iconError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, isValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name                             | Summary                                                                                                                                                                                                                                                            |
|----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [categoryName](category-name.md) | [androidJvm]<br>val [categoryName](category-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The current text entered for the category name.                                                                          |
| [iconError](icon-error.md)       | [androidJvm]<br>val [iconError](icon-error.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Error message related to the icon selection, if any.                                                                           |
| [isValid](is-valid.md)           | [androidJvm]<br>val [isValid](is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Flag indicating whether the current state is valid for submitting the new category.                                      |
| [nameError](name-error.md)       | [androidJvm]<br>val [nameError](name-error.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Error message related to the category name input, if any.                                                                      |
| [selectedIcon](selected-icon.md) | [androidJvm]<br>val [selectedIcon](selected-icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)? = null<br>The currently selected icon as an ImageVector, or null if no icon is selected. |
