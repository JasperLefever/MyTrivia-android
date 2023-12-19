//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.question](../index.md)/[ApiQuestion](index.md)

# ApiQuestion

[androidJvm]\
@Serializable

data class [ApiQuestion](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
questionText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
answers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiAnswer](../-api-answer/index.md)&gt; = listOf(), val
category: [ApiCategory](../../icu.repsaj.android.mytrivia.network.categroy/-api-category/index.md))

Represents a trivia question as defined in the API. This data class is used for serialization and
deserialization of question data from API responses.

## Constructors

|                                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|---------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ApiQuestion](-api-question.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), questionText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), answers: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAnswer](../-api-answer/index.md)&gt; = listOf(), category: [ApiCategory](../../icu.repsaj.android.mytrivia.network.categroy/-api-category/index.md)) |

## Properties

| Name                             | Summary                                                                                                                                                                                                                                                                                                                                                                               |
|----------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [answers](answers.md)            | [androidJvm]<br>val [answers](answers.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAnswer](../-api-answer/index.md)&gt;<br>A list of possible answers ([ApiAnswer](../-api-answer/index.md)) for the question.                                                                                                                |
| [category](category.md)          | [androidJvm]<br>val [category](category.md): [ApiCategory](../../icu.repsaj.android.mytrivia.network.categroy/-api-category/index.md)<br>The category ([ApiCategory](../../icu.repsaj.android.mytrivia.network.categroy/-api-category/index.md)) to which this question belongs.                                                                                                      |
| [id](id.md)                      | [androidJvm]<br>@Serializable(with = [UUIDSerializer::class](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md))<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Unique identifier of the question, serialized using [UUIDSerializer](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md). |
| [questionText](question-text.md) | [androidJvm]<br>val [questionText](question-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The text of the trivia question.                                                                                                                                                                                                            |
