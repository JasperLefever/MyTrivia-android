//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](../index.md)/[ICategoryApiService](index.md)/[getCategories](get-categories.md)

# getCategories

[androidJvm]\

@GET(value = &quot;categories&quot;)

abstract suspend fun [getCategories](get-categories.md)(@Query(value = &quot;page&quot;)
page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Query(value =
&quot;perPage&quot;)
perPage: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [CategoryResponse](../-category-response/index.md)

Fetches a list of categories from the API.

#### Return

A [CategoryResponse](../-category-response/index.md) containing metadata and a list of
categories ([ApiCategory](../-api-category/index.md)).

#### Parameters

androidJvm

|         |                                        |
|---------|----------------------------------------|
| page    | The page number for paginated results. |
| perPage | The number of items per page.          |
