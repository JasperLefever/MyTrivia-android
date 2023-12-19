//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.layout](index.md)/[TopBar](-top-bar.md)

# TopBar

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TopBar](-top-bar.md)(
currentScreen: [NavRoutes](../icu.repsaj.android.mytrivia.ui.navigation/-nav-routes/index.md),
canNavigateBack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
navigateUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
navigateHistory: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
navigateAddCategory: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the top bar.

#### Parameters

androidJvm

|                     |                                                    |
|---------------------|----------------------------------------------------|
| currentScreen       | The current screen.                                |
| canNavigateBack     | Whether the user can navigate back.                |
| navigateUp          | A function to navigate up.                         |
| navigateHistory     | A function to navigate to the history screen.      |
| navigateAddCategory | A function to navigate to the add category screen. |
| modifier            | The modifier to be applied to the top bar.         |
