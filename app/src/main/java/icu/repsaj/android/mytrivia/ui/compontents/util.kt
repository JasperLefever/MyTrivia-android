package icu.repsaj.android.mytrivia.ui.compontents

import android.icu.text.SimpleDateFormat
import java.util.Date

/**
 * Formats a [Date] to a string in the format "dd/MM/yyyy HH:mm".
 */
fun formatDateTime(date: Date): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
    return formatter.format(date)
}