package icu.repsaj.android.mytrivia.data.database.convertors

import androidx.room.TypeConverter
import java.util.Date

class DateConverters {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }
}
