//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.addCategory](index.md)/[AddCategoryView](-add-category-view.md)

# AddCategoryView

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [AddCategoryView](-add-category-view.md)(
viewModel: [AddCategoryViewModel](-add-category-view-model/index.md) = viewModel(factory =
AddCategoryViewModel.Factory), navigateUp: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable function that displays the UI for adding a new category.

#### Parameters

androidJvm

|            |                                                          |
|------------|----------------------------------------------------------|
| viewModel  | The ViewModel that provides the state and handles logic. |
| navigateUp | A function to navigate back to the previous screen.      |
