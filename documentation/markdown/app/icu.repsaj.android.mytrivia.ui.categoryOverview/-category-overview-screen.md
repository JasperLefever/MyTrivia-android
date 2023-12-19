//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.categoryOverview](index.md)/[CategoryOverviewScreen](-category-overview-screen.md)

# CategoryOverviewScreen

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CategoryOverviewScreen](-category-overview-screen.md)(
navigateToGame: ([UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier, viewModel: [CategoriesOverviewViewModel](-categories-overview-view-model/index.md) =
viewModel(factory = CategoriesOverviewViewModel.Factory))

Composable function that displays the UI for the category overview screen.

#### Parameters

androidJvm

|                |                                                          |
|----------------|----------------------------------------------------------|
| navigateToGame | A function to navigate to the game screen.               |
| modifier       | The modifier to be applied to the screen.                |
| viewModel      | The ViewModel that provides the state and handles logic. |
