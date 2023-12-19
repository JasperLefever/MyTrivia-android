//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[AnswerCardsLandscape](-answer-cards-landscape.md)

# AnswerCardsLandscape

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [AnswerCardsLandscape](-answer-cards-landscape.md)(
answers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaAnswer](../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md)&gt;,
isAnswered: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
checkAnswer: ([TriviaAnswer](../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays the answers in landscape mode.

#### Parameters

androidJvm

|             |                                                                                                       |
|-------------|-------------------------------------------------------------------------------------------------------|
| answers     | The list of [TriviaAnswer](../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md)s to display. |
| isAnswered  | A boolean that indicates if the question was answered.                                                |
| checkAnswer | A function to check the answer.                                                                       |
