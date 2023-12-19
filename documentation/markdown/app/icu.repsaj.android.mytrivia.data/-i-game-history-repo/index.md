//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[IGameHistoryRepo](index.md)

# IGameHistoryRepo

interface [IGameHistoryRepo](index.md)

Repository interface for handling game history data operations.

#### Inheritors

|                                                               |
|---------------------------------------------------------------|
| [GameHistoryRepository](../-game-history-repository/index.md) |

## Functions

| Name                                        | Summary                                                                                                                                                                                                                                                                                                                                                                                   |
|---------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [deleteHistoryItem](delete-history-item.md) | [androidJvm]<br>abstract suspend fun [deleteHistoryItem](delete-history-item.md)(item: [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md))<br>Deletes a [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md) from the game history.                                                                                                   |
| [getGameHistory](get-game-history.md)       | [androidJvm]<br>abstract fun [getGameHistory](get-game-history.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md)&gt;&gt;<br>Retrieves the game history as a list of [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md). |
| [insertHistoryItem](insert-history-item.md) | [androidJvm]<br>abstract suspend fun [insertHistoryItem](insert-history-item.md)(item: [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md))<br>Inserts a new [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md) into the game history.                                                                                               |
