//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)/[deleteCategory](delete-category.md)

# deleteCategory

[androidJvm]\
open suspend override fun [deleteCategory](delete-category.md)(
category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))

Deletes a category via the API. After a successful deletion, it refreshes the local database.

#### Parameters

androidJvm

|          |                                                                                           |
|----------|-------------------------------------------------------------------------------------------|
| category | The [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md) to be deleted. |

#### Throws

|                                                                                                       |                     |
|-------------------------------------------------------------------------------------------------------|---------------------|
| [RuntimeException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html) | if an error occurs. |
