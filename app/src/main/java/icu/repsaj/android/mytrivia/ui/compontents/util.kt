package icu.repsaj.android.mytrivia.ui.compontents

import android.icu.text.SimpleDateFormat
import java.util.Date

fun formatDateTime(date: Date): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
    return formatter.format(date)
}