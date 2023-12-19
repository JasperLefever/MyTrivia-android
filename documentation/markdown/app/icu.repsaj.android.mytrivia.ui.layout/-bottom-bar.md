//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.layout](index.md)/[BottomBar](-bottom-bar.md)

# BottomBar

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [BottomBar](-bottom-bar.md)(
currentScreen: [NavRoutes](../icu.repsaj.android.mytrivia.ui.navigation/-nav-routes/index.md),
navigateToCategories: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
navigateToHistory: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the bottom bar.

#### Parameters

androidJvm

|                      |                                                  |
|----------------------|--------------------------------------------------|
| currentScreen        | The current screen.                              |
| navigateToCategories | A function to navigate to the categories screen. |
| navigateToHistory    | A function to navigate to the history screen.    |
| modifier             | The modifier to be applied to the bottom bar.    |
