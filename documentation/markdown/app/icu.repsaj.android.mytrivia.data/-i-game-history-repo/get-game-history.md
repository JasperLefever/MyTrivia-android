//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[IGameHistoryRepo](index.md)/[getGameHistory](get-game-history.md)

# getGameHistory

[androidJvm]\
abstract fun [getGameHistory](get-game-history.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md)&gt;&gt;

Retrieves the game history as a list
of [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md).

#### Return

A Flow emitting a list
of [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md), representing the
game history.
