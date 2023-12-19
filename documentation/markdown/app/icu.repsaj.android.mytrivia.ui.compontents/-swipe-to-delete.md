//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.compontents](index.md)/[SwipeToDelete](-swipe-to-delete.md)

# SwipeToDelete

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](-swipe-to-delete.md)&gt; [SwipeToDelete](-swipe-to-delete.md)(
item: [T](-swipe-to-delete.md),
itemContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)([T](-swipe-to-delete.md))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
onDismiss: ([T](-swipe-to-delete.md))
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable function that displays a swipe to delete item.

#### Parameters

androidJvm

|             |                                                   |
|-------------|---------------------------------------------------|
| item        | The item to be displayed.                         |
| itemContent | The content of the item.                          |
| onDismiss   | A function to execute when the item is dismissed. |
