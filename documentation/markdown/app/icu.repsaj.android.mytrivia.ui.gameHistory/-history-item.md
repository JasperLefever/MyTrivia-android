//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.gameHistory](index.md)/[HistoryItem](-history-item.md)

# HistoryItem

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [HistoryItem](-history-item.md)(
historyItem: [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md),
onRemove: ([HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

A card that displays a history item.

#### Parameters

androidJvm

|             |                                                                                                 |
|-------------|-------------------------------------------------------------------------------------------------|
| historyItem | The [HistoryItem](../icu.repsaj.android.mytrivia.model/-history-item/index.md) to be displayed. |
| onRemove    | The callback to be invoked when the card is swiped away.                                        |
| modifier    | The modifier to be applied to the card.                                                         |
