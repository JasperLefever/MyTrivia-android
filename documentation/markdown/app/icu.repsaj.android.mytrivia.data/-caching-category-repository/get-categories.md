//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)/[getCategories](get-categories.md)

# getCategories

[androidJvm]\
open override fun [getCategories](get-categories.md)():
Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)
&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;&gt;

Retrieves all categories from the local database, converting them to domain objects.

#### Return

A Flow emitting a list of [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)s.
