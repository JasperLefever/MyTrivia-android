//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[IQuestionRepo](index.md)/[getQuestions](get-questions.md)

# getQuestions

[androidJvm]\
abstract fun [getQuestions](get-questions.md)(
categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)):
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;&gt;

Retrieves trivia questions for a specific category.

#### Return

A Flow emitting a list
of [TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md) for the
specified category.

#### Parameters

androidJvm

|            |                                                                   |
|------------|-------------------------------------------------------------------|
| categoryId | The UUID of the category for which questions are to be retrieved. |
