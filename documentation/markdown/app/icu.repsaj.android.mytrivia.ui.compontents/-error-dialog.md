//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.compontents](index.md)/[ErrorDialog](-error-dialog.md)

# ErrorDialog

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [ErrorDialog](-error-dialog.md)(
dialogTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
dialogText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
onConfirmation: ()
-&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier,
icon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html) =
Icons.Filled.Error)

Composable function that displays an error dialog.

#### Parameters

androidJvm

|                |                                                          |
|----------------|----------------------------------------------------------|
| dialogTitle    | The title of the dialog.                                 |
| dialogText     | The text of the dialog.                                  |
| onConfirmation | A function to execute when the user confirms the dialog. |
| modifier       | The modifier to be applied to the dialog.                |
| icon           | The icon to be displayed in the dialog.                  |
