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

@Composable
public fun ErrorDialog(
    icon: ImageVector = Icons.Filled.Error,
    dialogTitle: String,
    dialogText: String,
    onConfirmation: () -> Unit,
    modifier: Modifier = Modifier
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
    )
}

@Composable
public fun LoadingIndicator() {
    LoadingIndicator()
}