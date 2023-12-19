//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database](../index.md)/[GameHistoryDao](index.md)

# GameHistoryDao

[androidJvm]\
interface [GameHistoryDao](index.md)

Data access object for the 'game_history' table.

## Functions

| Name                 | Summary                                                                                                                                                                                                                                                                                                                                                                                                |
|----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [delete](delete.md)  | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md))<br>Deletes a specific [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md) item from the database.                                                                |
| [getAll](get-all.md) | [androidJvm]<br>abstract fun [getAll](get-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md)&gt;&gt;<br>Retrieves all game history entries from the database as a list.                                                       |
| [insert](insert.md)  | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md))<br>Inserts a [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md) item into the database. If a game history item with the same ID already exists, it is replaced. |
