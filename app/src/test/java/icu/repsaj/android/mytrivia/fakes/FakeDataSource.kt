package icu.repsaj.android.mytrivia.fakes

import icu.repsaj.android.mytrivia.network.categroy.ApiCategory
import icu.repsaj.android.mytrivia.network.question.ApiAnswer
import icu.repsaj.android.mytrivia.network.question.ApiQuestion
import java.util.UUID

object FakeDataSource {
    val category: ApiCategory = ApiCategory(
        id = UUID.fromString("7f307959-ee19-4b0a-ac4a-c5c9005ed29d"),
        name = "Geography",
        icon = "plus",
    )

    val correctAnswer = ApiAnswer(
        id = UUID.randomUUID(),
        answerText = "Canberra",
        isCorrect = true,
        questionId = UUID.fromString("4c5ca6e5-a67a-4755-b2be-370a70f2d89e")
    )

    val incorrectAnswer = ApiAnswer(
        id = UUID.randomUUID(),
        answerText = "Melbourne",
        isCorrect = false,
        questionId = UUID.fromString("4c5ca6e5-a67a-4755-b2be-370a70f2d89e")
    )

    val questions = listOf(
        ApiQuestion(
            id = UUID.fromString("4c5ca6e5-a67a-4755-b2be-370a70f2d89e"),
            questionText = "What is the capital of Australia?",
            answers = listOf(
                ApiAnswer(
                    id = UUID.randomUUID(),
                    answerText = "Sydney",
                    isCorrect = false,
                    questionId = UUID.fromString("4c5ca6e5-a67a-4755-b2be-370a70f2d89e")
                ),
                incorrectAnswer, correctAnswer
            ),
            category = category,
        ),
    )
}