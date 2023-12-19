//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[TriviaGameScreen](-trivia-game-screen.md)

# TriviaGameScreen

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TriviaGameScreen](-trivia-game-screen.md)(navigateUp: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
viewModel: [GameViewModel](-game-view-model/index.md),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the UI for the game screen.

#### Parameters

androidJvm

|            |                                                          |
|------------|----------------------------------------------------------|
| navigateUp | A function to navigate up.                               |
| modifier   | The modifier to be applied to the screen.                |
| viewModel  | The ViewModel that provides the state and handles logic. |
