package icu.repsaj.android.mytrivia.ui.compontents

import java.text.SimpleDateFormat
import java.util.Date

fun formatDateTime(date: Date): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
    return formatter.format(date)
}