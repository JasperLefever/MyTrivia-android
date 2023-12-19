package icu.repsaj.android.mytrivia.ui.compontents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import icu.repsaj.android.mytrivia.R

/**
 * Composable function that displays an error dialog.
 *
 * @param dialogTitle The title of the dialog.
 * @param dialogText The text of the dialog.
 * @param onConfirmation A function to execute when the user confirms the dialog.
 * @param modifier The modifier to be applied to the dialog.
 * @param icon The icon to be displayed in the dialog.
 */
@Composable
fun ErrorDialog(
    dialogTitle: String,
    dialogText: String,
    onConfirmation: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.Error
) {
    AlertDialog(
        icon = {
            Icon(imageVector = icon, contentDescription = null)
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(stringResource(R.string.retry))
            }
        },
        modifier = modifier
    )
}