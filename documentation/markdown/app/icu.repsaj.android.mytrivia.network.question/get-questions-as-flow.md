//[app](../../index.md)/[icu.repsaj.android.mytrivia.network.question](index.md)/[getQuestionsAsFlow](get-questions-as-flow.md)

# getQuestionsAsFlow

[androidJvm]\
fun [IQuestionApiService](-i-question-api-service/index.md).[getQuestionsAsFlow](get-questions-as-flow.md)(
categoryId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html),
page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1,
perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10):
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiQuestion](-api-question/index.md)&gt;&gt;

Extension function to convert the API call for fetching questions into a Flow. This function
encapsulates the API call within a Flow for reactive data handling. The Flow emits a list
of [ApiQuestion](-api-question/index.md) items.

#### Return

A Flow emitting a list of [ApiQuestion](-api-question/index.md) items.

#### Parameters

androidJvm

|            |                                                                   |
|------------|-------------------------------------------------------------------|
| categoryId | The UUID of the category for which questions are to be fetched.   |
| page       | The page number for paginated results, with a default value of 1. |
| perPage    | The number of items per page, with a default value of 10.         |
