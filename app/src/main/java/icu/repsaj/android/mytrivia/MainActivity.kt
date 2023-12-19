package icu.repsaj.android.mytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import icu.repsaj.android.mytrivia.ui.TriviaApp
import icu.repsaj.android.mytrivia.ui.theme.MyTriviaTheme

/**
 * The main [ComponentActivity] for this app.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTriviaTheme {
                TriviaApp()
            }
        }
    }
}