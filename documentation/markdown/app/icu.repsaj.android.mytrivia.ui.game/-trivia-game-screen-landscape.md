//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[TriviaGameScreenLandscape](-trivia-game-screen-landscape.md)

# TriviaGameScreenLandscape

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TriviaGameScreenLandscape](-trivia-game-screen-landscape.md)(
viewModel: [GameViewModel](-game-view-model/index.md),
gameUIState: [GameUIState](-game-u-i-state/index.md),
category: [Category](../icu.repsaj.android.mytrivia.model/-category/index.md), navigateUp: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the UI for the game screen in landscape mode.

#### Parameters

androidJvm

|             |                                                          |
|-------------|----------------------------------------------------------|
| viewModel   | The ViewModel that provides the state and handles logic. |
| gameUIState | The state of the game.                                   |
| category    | The category of the game.                                |
| navigateUp  | A function to navigate up.                               |
| modifier    | The modifier to be applied to the screen.                |
