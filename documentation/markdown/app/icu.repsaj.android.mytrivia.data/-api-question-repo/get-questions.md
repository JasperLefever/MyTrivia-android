//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[ApiQuestionRepo](index.md)/[getQuestions](get-questions.md)

# getQuestions

[androidJvm]\
open override fun [getQuestions](get-questions.md)(
categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)):
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;&gt;

Fetches trivia questions for a given category from the API and converts them to domain objects.

#### Return

A Flow emitting a list
of [TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)s for the
specified category.

#### Parameters

androidJvm

|            |                                                                 |
|------------|-----------------------------------------------------------------|
| categoryId | The UUID of the category for which questions are to be fetched. |
