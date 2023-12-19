package icu.repsaj.android.mytrivia.ui.providers

import android.content.Context
import androidx.annotation.StringRes

/**
 * Interface for providing resources.
 * For providing resources from the Android framework in the ViewModel.
 */
interface ResourceProvider {
    /**
     * Returns a localized string from the application's package's default string table.
     *
     * @param id The resource ID for the string.
     * @return The string data associated with the resource, stripped of styled text information.
     */
    fun getString(@StringRes id: Int): String
}

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}
