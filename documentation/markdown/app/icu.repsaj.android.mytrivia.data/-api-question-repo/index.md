//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[ApiQuestionRepo](index.md)

# ApiQuestionRepo

[androidJvm]\
class [ApiQuestionRepo](index.md)(
questionApiService: [IQuestionApiService](../../icu.repsaj.android.mytrivia.network.question/-i-question-api-service/index.md)) : [IQuestionRepo](../-i-question-repo/index.md)

Repository implementation for accessing trivia questions via an API. This repository fetches trivia
questions from a remote data source.

## Constructors

|                                          |                                                                                                                                                             |
|------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ApiQuestionRepo](-api-question-repo.md) | [androidJvm]<br>constructor(questionApiService: [IQuestionApiService](../../icu.repsaj.android.mytrivia.network.question/-i-question-api-service/index.md)) |

## Functions

| Name                             | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [getQuestions](get-questions.md) | [androidJvm]<br>open override fun [getQuestions](get-questions.md)(categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TriviaQuestion](../../icu.repsaj.android.mytrivia.model/-trivia-question/index.md)&gt;&gt;<br>Fetches trivia questions for a given category from the API and converts them to domain objects. |
