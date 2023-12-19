//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[GameHistoryRepository](index.md)

# GameHistoryRepository

[androidJvm]\
class [GameHistoryRepository](index.md)(
historyDao: [GameHistoryDao](../../icu.repsaj.android.mytrivia.data.database/-game-history-dao/index.md)) : [IGameHistoryRepo](../-i-game-history-repo/index.md)

Concrete implementation of [IGameHistoryRepo](../-i-game-history-repo/index.md), handling game
history data operations.

## Constructors

|                                                      |                                                                                                                                       |
|------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| [GameHistoryRepository](-game-history-repository.md) | [androidJvm]<br>constructor(historyDao: [GameHistoryDao](../../icu.repsaj.android.mytrivia.data.database/-game-history-dao/index.md)) |

## Functions

| Name                                        | Summary                                                                                                                                                                                                                                                                                                                                                        |
|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [deleteHistoryItem](delete-history-item.md) | [androidJvm]<br>open suspend override fun [deleteHistoryItem](delete-history-item.md)(item: [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md))<br>Deletes a game history item from the database.                                                                                                                                   |
| [getGameHistory](get-game-history.md)       | [androidJvm]<br>open override fun [getGameHistory](get-game-history.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md)&gt;&gt;<br>Retrieves all game history items from the database, converting them to domain objects. |
| [insertHistoryItem](insert-history-item.md) | [androidJvm]<br>open suspend override fun [insertHistoryItem](insert-history-item.md)(item: [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md))<br>Inserts a new game history item into the database.                                                                                                                               |
