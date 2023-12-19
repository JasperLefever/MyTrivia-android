//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[IQuestionRepo](index.md)

# IQuestionRepo

interface [IQuestionRepo](index.md)

Repository interface for accessing trivia questions.

#### Inheritors

|                                                   |
|---------------------------------------------------|
| [ApiQuestionRepo](../-api-question-repo/index.md) |

## Functions

| Name                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                       |
|----------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [getQuestions](get-questions.md) | [androidJvm]<br>abstract fun [getQuestions](get-questions.md)(categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;&gt;<br>Retrieves trivia questions for a specific category. |
