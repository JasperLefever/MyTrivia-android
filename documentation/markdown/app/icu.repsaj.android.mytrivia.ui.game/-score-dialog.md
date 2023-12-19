//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.game](index.md)/[ScoreDialog](-score-dialog.md)

# ScoreDialog

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ScoreDialog](-score-dialog.md)(onConfirmation: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
dialogTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
dialogText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
icon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that displays an error dialog.

#### Parameters

androidJvm

|                |                                                          |
|----------------|----------------------------------------------------------|
| dialogTitle    | The title of the dialog.                                 |
| dialogText     | The text of the dialog.                                  |
| onConfirmation | A function to execute when the user confirms the dialog. |
| icon           | The icon to be displayed in the dialog.                  |
