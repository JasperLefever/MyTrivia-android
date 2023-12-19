//[app](../../index.md)/[icu.repsaj.android.mytrivia.network.question](index.md)/[asDomainObjects](as-domain-objects.md)

# asDomainObjects

[androidJvm]\
fun Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiQuestion](-api-question/index.md)&gt;&gt;.[asDomainObjects](as-domain-objects.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaQuestion](../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;&gt;

Extension function on Flow<List<ApiQuestion>> to convert a flow of API question lists into a flow of
domain object lists.

#### Return

A Flow emitting lists
of [TriviaQuestion](../icu.repsaj.android.mytrivia.model/-trivia-question/index.md) domain objects.

[androidJvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiQuestion](-api-question/index.md)
&gt;.[asDomainObjects](as-domain-objects.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaQuestion](../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;

Extension function to convert a list of [ApiQuestion](-api-question/index.md) to a list
of [TriviaQuestion](../icu.repsaj.android.mytrivia.model/-trivia-question/index.md) domain objects.

#### Return

A list of [TriviaQuestion](../icu.repsaj.android.mytrivia.model/-trivia-question/index.md) domain
objects.
