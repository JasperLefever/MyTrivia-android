//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.game](../index.md)/[GameViewModel](index.md)

# GameViewModel

[androidJvm]\
class [GameViewModel](index.md)(val
categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html),
questionRepo: [IQuestionRepo](../../icu.repsaj.android.mytrivia.data/-i-question-repo/index.md),
historyRepo: [IGameHistoryRepo](../../icu.repsaj.android.mytrivia.data/-i-game-history-repo/index.md),
categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md),
resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the Game screen. Manages the UI state and handles the business logic for the screen.

## Constructors

|                                      |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
|--------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [GameViewModel](-game-view-model.md) | [androidJvm]<br>constructor(categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), questionRepo: [IQuestionRepo](../../icu.repsaj.android.mytrivia.data/-i-question-repo/index.md), historyRepo: [IGameHistoryRepo](../../icu.repsaj.android.mytrivia.data/-i-game-history-repo/index.md), categoryRepo: [ICategoryRepo](../../icu.repsaj.android.mytrivia.data/-i-category-repo/index.md), resourceProvider: [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)) |

## Types

| Name                             | Summary                                                 |
|----------------------------------|---------------------------------------------------------|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name                         | Summary                                                                                                                                                                       |
|------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [apiState](api-state.md)     | [androidJvm]<br>var [apiState](api-state.md): [QuestionsApiState](../-questions-api-state/index.md)                                                                           |
| [categoryId](category-id.md) | [androidJvm]<br>val [categoryId](category-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>The ID of the category to play the game with. |
| [uiCategory](ui-category.md) | [androidJvm]<br>lateinit var [uiCategory](ui-category.md): StateFlow&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;                            |
| [uiState](ui-state.md)       | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[GameUIState](../-game-u-i-state/index.md)&gt;                                                                       |

## Functions

| Name                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../icu.repsaj.android.mytrivia.ui.gameHistory/-history-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [checkAnswer](check-answer.md)                                                                                                   | [androidJvm]<br>fun [checkAnswer](check-answer.md)(answer: [TriviaAnswer](../../icu.repsaj.android.mytrivia.model/-trivia-answer/index.md))<br>Checks the answer and updates the UI state accordingly.                                                                                                                                       |
| [fetchQuestions](fetch-questions.md)                                                                                             | [androidJvm]<br>fun [fetchQuestions](fetch-questions.md)()<br>Fetches the questions from the repository. If the fetch is successful, the UI state is updated with the new questions. If the fetch fails, the UI state is updated with an error message.                                                                                      |
| [getAmountOfQuestions](get-amount-of-questions.md)                                                                               | [androidJvm]<br>fun [getAmountOfQuestions](get-amount-of-questions.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)                                                                                                                                                                                         |
| [getCurrentQuestion](get-current-question.md)                                                                                    | [androidJvm]<br>fun [getCurrentQuestion](get-current-question.md)(): [TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)                                                                                                                                                                                     |
| [isLastQuestion](is-last-question.md)                                                                                            | [androidJvm]<br>fun [isLastQuestion](is-last-question.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)                                                                                                                                                                                              |
| [nextQuestion](next-question.md)                                                                                                 | [androidJvm]<br>fun [nextQuestion](next-question.md)()<br>moves the game to the next question.                                                                                                                                                                                                                                               |
| [saveHistoryItem](save-history-item.md)                                                                                          | [androidJvm]<br>fun [saveHistoryItem](save-history-item.md)()<br>Saves the current game to the history.                                                                                                                                                                                                                                      |
| [showScoreDialog](show-score-dialog.md)                                                                                          | [androidJvm]<br>fun [showScoreDialog](show-score-dialog.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)                                                                                                                                                                                            |
