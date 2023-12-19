//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database](../index.md)/[GameHistoryDao](index.md)/[insert](insert.md)

# insert

[androidJvm]\
abstract suspend fun [insert](insert.md)(
item: [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md))

Inserts
a [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md)
item into the database. If a game history item with the same ID already exists, it is replaced.

#### Parameters

androidJvm

|      |                                                                                                                                       |
|------|---------------------------------------------------------------------------------------------------------------------------------------|
| item | The [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md) item to be inserted. |
