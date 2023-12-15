package icu.repsaj.android.mytrivia

import android.app.Application
import icu.repsaj.android.mytrivia.data.AppContainer
import icu.repsaj.android.mytrivia.data.DefaultAppContainer

class TriviaApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}
