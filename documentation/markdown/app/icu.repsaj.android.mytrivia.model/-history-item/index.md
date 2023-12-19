//[app](../../../index.md)/[icu.repsaj.android.mytrivia.model](../index.md)/[HistoryItem](index.md)

# HistoryItem

[androidJvm]\
data class [HistoryItem](index.md)(var
id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, var
category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, var date: [Date](https://developer.android.com/reference/kotlin/java/util/Date.html),
var score: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)

Data class representing a history item.

## Constructors

|                                 |                                                                                                                                                                                                                                                                                                                                                                                                         |
|---------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [HistoryItem](-history-item.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, date: [Date](https://developer.android.com/reference/kotlin/java/util/Date.html), score: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0) |

## Properties

| Name                    | Summary                                                                                                                                                                                                                                  |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [category](category.md) | [androidJvm]<br>var [category](category.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The category of the history item.                                                                       |
| [date](date.md)         | [androidJvm]<br>var [date](date.md): [Date](https://developer.android.com/reference/kotlin/java/util/Date.html)<br>The [Date](https://developer.android.com/reference/kotlin/java/util/Date.html) on which the history item was created. |
| [id](id.md)             | [androidJvm]<br>var [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?<br>The ID of the history item.                                                                                              |
| [score](score.md)       | [androidJvm]<br>var [score](score.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The score of the history item.                                                                                      |

## Functions

| Name                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [asDbEntity](../../icu.repsaj.android.mytrivia.data.database.entities/as-db-entity.md) | [androidJvm]<br>fun [HistoryItem](index.md).[asDbEntity](../../icu.repsaj.android.mytrivia.data.database.entities/as-db-entity.md)(): [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md)<br>Converts a domain object [HistoryItem](index.md) into a database entity [DbGameHistoryItem](../../icu.repsaj.android.mytrivia.data.database.entities/-db-game-history-item/index.md). |
