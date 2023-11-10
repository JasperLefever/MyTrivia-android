package icu.repsaj.android.mytrivia.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TriviaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TriviaUIState())
    public val uiState: StateFlow<TriviaUIState> = _uiState.asStateFlow()
}