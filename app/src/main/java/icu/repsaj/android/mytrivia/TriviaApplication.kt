package icu.repsaj.android.mytrivia

import android.app.Application
import icu.repsaj.android.mytrivia.data.AppContainer
import icu.repsaj.android.mytrivia.data.DefaultAppContainer

/**
 * The [Application] subclass for this app.
 *
 * @property container The [AppContainer] used by this app.
 */
class TriviaApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}
