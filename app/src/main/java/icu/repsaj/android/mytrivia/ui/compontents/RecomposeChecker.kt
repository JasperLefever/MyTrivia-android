package icu.repsaj.android.mytrivia.ui.compontents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * A composable function that prints the number of times it recomposes.
 *
 * @param viewName The name of the view to be printed.
 */
@Composable
fun RecomposeChecker(viewName: String = "") {
    var recomposeCount by remember { mutableIntStateOf(0) }

    SideEffect {
        recomposeCount++
        println("$viewName recomposed $recomposeCount times")
    }
}