//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.gameHistory](index.md)/[HistoryItemCard](-history-item-card.md)

# HistoryItemCard

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [HistoryItemCard](-history-item-card.md)(
ranking: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),
category: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
score: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),
date: [Date](https://developer.android.com/reference/kotlin/java/util/Date.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

A card that displays a history item.

#### Parameters

androidJvm

|          |                                                                     |
|----------|---------------------------------------------------------------------|
| ranking  | The ranking of the history item. First game is 1, second is 2, etc. |
| category | The category of the history item.                                   |
| score    | The score of the history item.                                      |
| date     | The date of the history item.                                       |
| modifier | The modifier to be applied to the card.                             |
