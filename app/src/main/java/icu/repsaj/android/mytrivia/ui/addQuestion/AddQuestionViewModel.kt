package icu.repsaj.android.mytrivia.ui.addQuestion


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import java.util.UUID

class AddQuestionViewModel : ViewModel() {
    var triviaQuestion by mutableStateOf(
        TriviaQuestion(
            id = UUID.randomUUID(),
            question = "",
            answers = listOf(
                TriviaAnswer(id = UUID.randomUUID(), answer = "", isCorrect = true),
                TriviaAnswer(id = UUID.randomUUID(), answer = "", isCorrect = false),
                TriviaAnswer(id = UUID.randomUUID(), answer = "", isCorrect = false),
            )
        )
    )

    fun createQuestion() {

    }

    fun isValid(): Boolean {
        return true
    }

}

