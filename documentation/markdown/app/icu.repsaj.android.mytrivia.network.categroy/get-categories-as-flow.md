//[app](../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](index.md)/[getCategoriesAsFlow](get-categories-as-flow.md)

# getCategoriesAsFlow

[androidJvm]\
fun [ICategoryApiService](-i-category-api-service/index.md).[getCategoriesAsFlow](get-categories-as-flow.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[ApiCategory](-api-category/index.md)&gt;&gt;

Extension function to convert the API call for fetching categories into a Flow. This function
encapsulates the API call within a Flow for reactive data handling.

#### Return

A Flow emitting a list of [ApiCategory](-api-category/index.md) items.
