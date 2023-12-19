//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[GameHistoryRepository](index.md)/[getGameHistory](get-game-history.md)

# getGameHistory

[androidJvm]\
open override fun [getGameHistory](get-game-history.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md)&gt;&gt;

Retrieves all game history items from the database, converting them to domain objects.

#### Return

A Flow emitting a list
of [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md)s.
