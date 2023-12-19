//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)/[getCategoryById](get-category-by-id.md)

# getCategoryById

[androidJvm]\
open override fun [getCategoryById](get-category-by-id.md)(
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)):
Flow&lt;[Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)&gt;

Retrieves a specific category by its ID from the local database.

#### Return

A Flow emitting the [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md) with the
specified ID.

#### Parameters

androidJvm

|     |                                       |
|-----|---------------------------------------|
| id  | The UUID of the category to retrieve. |
