//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.question](../index.md)/[ApiAnswer](index.md)

# ApiAnswer

[androidJvm]\
@Serializable

data class [ApiAnswer](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
answerText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
isCorrect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val
questionId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html))

Represents a possible answer to a trivia question as defined in the API.

## Constructors

|                             |                                                                                                                                                                                                                                                                                                                                                                                                  |
|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ApiAnswer](-api-answer.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), answerText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isCorrect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), questionId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)) |

## Properties

| Name                         | Summary                                                                                                                                                                                                                                                                                                                                                                                                                    |
|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [answerText](answer-text.md) | [androidJvm]<br>val [answerText](answer-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The text of the answer.                                                                                                                                                                                                                                                              |
| [id](id.md)                  | [androidJvm]<br>@Serializable(with = [UUIDSerializer::class](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md))<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Unique identifier of the answer, serialized using [UUIDSerializer](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md).                                        |
| [isCorrect](is-correct.md)   | [androidJvm]<br>val [isCorrect](is-correct.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether this answer is correct.                                                                                                                                                                                                                                            |
| [questionId](question-id.md) | [androidJvm]<br>@Serializable(with = [UUIDSerializer::class](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md))<br>val [questionId](question-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>The identifier of the question this answer belongs to, serialized using [UUIDSerializer](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md). |

## Functions

| Name                                     | Summary                                                                                                                                                                                                                                                                                                        |
|------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [asDomainObject](../as-domain-object.md) | [androidJvm]<br>fun [ApiAnswer](index.md).[asDomainObject](../as-domain-object.md)(): [TriviaAnswer](../../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md)<br>Converts an [ApiAnswer](index.md) to a [TriviaAnswer](../../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md) domain object. |
