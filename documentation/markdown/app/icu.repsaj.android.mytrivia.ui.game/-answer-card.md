//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[AnswerCard](-answer-card.md)

# AnswerCard

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [AnswerCard](-answer-card.md)(
answer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
isCorrect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
onAnswerClick: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
isAnswered: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays an answer card.

#### Parameters

androidJvm

|               |                                                        |
|---------------|--------------------------------------------------------|
| answer        | The answer to display.                                 |
| isCorrect     | A boolean that indicates if the answer is correct.     |
| onAnswerClick | A function to execute when the answer is clicked.      |
| isAnswered    | A boolean that indicates if the question was answered. |
| modifier      | The modifier to be applied to the card.                |
