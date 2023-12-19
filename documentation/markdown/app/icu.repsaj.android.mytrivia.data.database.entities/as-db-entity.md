//[app](../../index.md)/[icu.repsaj.android.mytrivia.data.database.entities](index.md)/[asDbEntity](as-db-entity.md)

# asDbEntity

[androidJvm]\
fun [Category](../icu.repsaj.android.mytrivia.model/-category/index.md).[asDbEntity](as-db-entity.md)(): [DbCategory](-db-category/index.md)

Converts a domain object [Category](../icu.repsaj.android.mytrivia.model/-category/index.md) into a
database entity [DbCategory](-db-category/index.md).

#### Return

A [DbCategory](-db-category/index.md) object with the same properties as
the [Category](../icu.repsaj.android.mytrivia.model/-category/index.md).

[androidJvm]\
fun [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md).[asDbEntity](as-db-entity.md)(): [DbGameHistoryItem](-db-game-history-item/index.md)

Converts a domain object [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md)
into a database entity [DbGameHistoryItem](-db-game-history-item/index.md).

If the [HistoryItem.id](../icu.repsaj.android.mytrivia.model/-history-item/id.md) is null, it
defaults to 0 for the database entity.

#### Return

A [DbGameHistoryItem](-db-game-history-item/index.md) object with properties corresponding to
the [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md).
