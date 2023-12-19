//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.question](../index.md)/[IQuestionApiService](index.md)/[getQuestions](get-questions.md)

# getQuestions

[androidJvm]\

@GET(value = &quot;questions/category/{categoryId}&quot;)

abstract suspend fun [getQuestions](get-questions.md)(@Path(value = &quot;categoryId&quot;)
category: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), @Query(value =
&quot;page&quot;)page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),
@Query(value = &quot;perPage&quot;)
perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [QuestionResponse](../-question-response/index.md)

Fetches a list of trivia questions for a specific category from the API.

#### Return

A [QuestionResponse](../-question-response/index.md) containing metadata and a list of trivia
questions ([ApiQuestion](../-api-question/index.md)).

#### Parameters

androidJvm

|          |                                                                 |
|----------|-----------------------------------------------------------------|
| category | The UUID of the category for which questions are to be fetched. |
| page     | The page number for paginated results.                          |
| perPage  | The number of items per page.                                   |
