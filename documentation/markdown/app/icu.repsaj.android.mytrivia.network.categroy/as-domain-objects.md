//[app](../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](index.md)/[asDomainObjects](as-domain-objects.md)

# asDomainObjects

[androidJvm]\
fun Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiCategory](-api-category/index.md)&gt;&gt;.[asDomainObjects](as-domain-objects.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[Category](../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;&gt;

Extension function on Flow<List<ApiCategory>> to convert a flow of API category lists into a flow of
domain object lists.

#### Return

A Flow emitting lists of [Category](../icu.repsaj.android.mytrivia.model/-category/index.md) domain
objects.

[androidJvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiCategory](-api-category/index.md)
&gt;.[asDomainObjects](as-domain-objects.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[Category](../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;

Extension function to convert a list of [ApiCategory](-api-category/index.md) to a list
of [Category](../icu.repsaj.android.mytrivia.model/-category/index.md) domain objects.

#### Return

A list of [Category](../icu.repsaj.android.mytrivia.model/-category/index.md) domain objects.
