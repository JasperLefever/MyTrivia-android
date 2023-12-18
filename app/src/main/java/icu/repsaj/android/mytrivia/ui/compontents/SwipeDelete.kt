package icu.repsaj.android.mytrivia.ui.compontents

import androidx.compose.animation.*
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeToDelete(
    item: T,
    itemContent: @Composable (T) -> Unit,
    onDismiss: (T) -> Unit
) {
    var show by remember { mutableStateOf(true) }
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                show = false
                true
            } else false
        }
    )

    AnimatedVisibility(
        visible = show,
        exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            background = { DismissBackground(dismissState) },
            dismissContent = { itemContent(item) }
        )
    }

    LaunchedEffect(show) {
        if (!show) {
            onDismiss(item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState: DismissState) {
    val color = when (dismissState.dismissDirection) {
        DismissDirection.EndToStart -> Color(0xFFFF1744)
        DismissDirection.StartToEnd -> Color(0xFFFF1744)
        null -> Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (dismissState.dismissDirection == DismissDirection.StartToEnd) {
            Icon(Icons.Default.Delete, contentDescription = null)
        }
        Spacer(modifier = Modifier)
        if (dismissState.dismissDirection == DismissDirection.EndToStart) {
            Icon(Icons.Default.Delete, contentDescription = null)
        }
    }
}
