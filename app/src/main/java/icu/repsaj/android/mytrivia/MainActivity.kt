package icu.repsaj.android.mytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import icu.repsaj.android.mytrivia.ui.theme.MyTriviaTheme

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