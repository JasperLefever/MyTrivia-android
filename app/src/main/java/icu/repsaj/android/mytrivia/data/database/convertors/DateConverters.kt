package icu.repsaj.android.mytrivia.data.database.convertors

import androidx.room.TypeConverter
import java.util.Date

/**
 * A utility class providing type converters for handling date and time conversions in the database.
 */
class DateConverters {

    /**
     * Converts a [Date] object to a [Long] timestamp.
     *
     * @param date The [Date] object to convert.
     * @return The corresponding [Long] timestamp, or null if [date] is null.
     */
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    /**
     * Converts a [Long] timestamp to a [Date] object.
     *
     * @param timestamp The [Long] timestamp to convert.
     * @return The corresponding [Date] object, or null if [timestamp] is null.
     */
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }
}
