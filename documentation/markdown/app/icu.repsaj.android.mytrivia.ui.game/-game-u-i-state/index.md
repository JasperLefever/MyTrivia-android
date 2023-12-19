//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.game](../index.md)/[GameUIState](index.md)

# GameUIState

[androidJvm]\
data class [GameUIState](index.md)(val
questions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt; =
listOf(), val
showQuitDialog: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) =
false, val
currentQuestionIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) =
0, val score: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val
isAnswered: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) =
false)

Represents the state of the game UI.

## Constructors

|                                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
|-----------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [GameUIState](-game-u-i-state.md) | [androidJvm]<br>constructor(questions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt; = listOf(), showQuitDialog: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, currentQuestionIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, score: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, isAnswered: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name                                              | Summary                                                                                                                                                                                                                            |
|---------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [currentQuestionIndex](current-question-index.md) | [androidJvm]<br>val [currentQuestionIndex](current-question-index.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0                                                                              |
| [isAnswered](is-answered.md)                      | [androidJvm]<br>val [isAnswered](is-answered.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false                                                                                       |
| [questions](questions.md)                         | [androidJvm]<br>val [questions](questions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt; |
| [score](score.md)                                 | [androidJvm]<br>val [score](score.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0                                                                                                              |
| [showQuitDialog](show-quit-dialog.md)             | [androidJvm]<br>val [showQuitDialog](show-quit-dialog.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false                                                                              |
