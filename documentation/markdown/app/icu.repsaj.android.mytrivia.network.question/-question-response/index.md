//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.question](../index.md)/[QuestionResponse](index.md)

# QuestionResponse

[androidJvm]\
@Serializable

data class [QuestionResponse](index.md)(val
metadata: [Metadata](../../icu.repsaj.android.mytrivia.network/-metadata/index.md), val
items: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiQuestion](../-api-question/index.md)&gt;)

Represents a response from the API for question requests. This class encapsulates metadata and a
list of [ApiQuestion](../-api-question/index.md) items.

## Constructors

|                                           |                                                                                                                                                                                                                                                                  |
|-------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [QuestionResponse](-question-response.md) | [androidJvm]<br>constructor(metadata: [Metadata](../../icu.repsaj.android.mytrivia.network/-metadata/index.md), items: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiQuestion](../-api-question/index.md)&gt;) |

## Properties

| Name                    | Summary                                                                                                                                                                                                                   |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [items](items.md)       | [androidJvm]<br>val [items](items.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiQuestion](../-api-question/index.md)&gt;<br>List of questions returned by the API. |
| [metadata](metadata.md) | [androidJvm]<br>val [metadata](metadata.md): [Metadata](../../icu.repsaj.android.mytrivia.network/-metadata/index.md)<br>Metadata associated with the API response.                                                       |
