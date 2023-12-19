//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[TriviaGameScreenPortrait](-trivia-game-screen-portrait.md)

# TriviaGameScreenPortrait

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [TriviaGameScreenPortrait](-trivia-game-screen-portrait.md)(
viewModel: [GameViewModel](-game-view-model/index.md),
gameUIState: [GameUIState](-game-u-i-state/index.md),
animateQuestionChange: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
setAnimateQuestionChange: ([Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
category: [Category](../icu.repsaj.android.mytrivia.model/-category/index.md), navigateUp: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the UI for the game screen in portrait mode.

#### Parameters

androidJvm

|                          |                                                                                          |
|--------------------------|------------------------------------------------------------------------------------------|
| viewModel                | The ViewModel that provides the state and handles logic.                                 |
| gameUIState              | The state of the game.                                                                   |
| animateQuestionChange    | A boolean that indicates if the question should be animated.                             |
| setAnimateQuestionChange | A function to set the value of [animateQuestionChange](-trivia-game-screen-portrait.md). |
| category                 | The category of the game.                                                                |
| navigateUp               | A function to navigate up.                                                               |
| modifier                 | The modifier to be applied to the screen.                                                |
