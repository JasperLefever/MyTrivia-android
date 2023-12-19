//[app](../../../index.md)/[icu.repsaj.android.mytrivia.model](../index.md)/[TriviaQuestion](index.md)

# TriviaQuestion

[androidJvm]\
data class [TriviaQuestion](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
question: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
answers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaAnswer](../-trivia-answer/index.md)&gt; = listOf())

Data class representing a trivia question.

## Constructors

|                                       |                                                                                                                                                                                                                                                                                                                                                                         |
|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [TriviaQuestion](-trivia-question.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), question: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), answers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaAnswer](../-trivia-answer/index.md)&gt; = listOf()) |

## Properties

| Name                    | Summary                                                                                                                                                                                                                                                                  |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [answers](answers.md)   | [androidJvm]<br>val [answers](answers.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaAnswer](../-trivia-answer/index.md)&gt;<br>The list of [TriviaAnswer](../-trivia-answer/index.md) for the trivia question. |
| [id](id.md)             | [androidJvm]<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>The ID of the trivia question.                                                                                                                            |
| [question](question.md) | [androidJvm]<br>val [question](question.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The trivia question itself.                                                                                                             |
