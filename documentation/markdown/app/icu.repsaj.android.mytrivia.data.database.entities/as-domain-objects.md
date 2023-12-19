//[app](../../index.md)/[icu.repsaj.android.mytrivia.data.database.entities](index.md)/[asDomainObjects](as-domain-objects.md)

# asDomainObjects

[androidJvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[DbCategory](-db-category/index.md)
&gt;.[asDomainObjects](as-domain-objects.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[Category](../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;

Extension function on List<[DbCategory](-db-category/index.md)> to convert a list of database
entities into a list of domain objects.

#### Return

A list of [Category](../icu.repsaj.android.mytrivia.model/-category/index.md) objects corresponding
to the [DbCategory](-db-category/index.md) objects in the list.

[androidJvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[DbGameHistoryItem](-db-game-history-item/index.md)
&gt;.[asDomainObjects](as-domain-objects.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md)&gt;

Extension function on List<[DbGameHistoryItem](-db-game-history-item/index.md)> to convert a list of
database entities into a list of domain objects.

#### Return

A list of [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md) objects
corresponding to the [DbGameHistoryItem](-db-game-history-item/index.md) objects in the list.
