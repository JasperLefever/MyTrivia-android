//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database](../index.md)/[GameHistoryDao](index.md)/[getAll](get-all.md)

# getAll

[androidJvm]\
abstract fun [getAll](get-all.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md)
&gt;&gt;

Retrieves all game history entries from the database as a list.

#### Return

A Flow emitting a list
of [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md)
items.
