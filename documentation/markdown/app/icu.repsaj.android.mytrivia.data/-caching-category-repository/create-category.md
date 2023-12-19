//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)/[createCategory](create-category.md)

# createCategory

[androidJvm]\
open suspend override fun [createCategory](create-category.md)(
category: [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md))

Creates a new category via the API. After a successful creation, it refreshes the local database.

#### Parameters

androidJvm

|          |                                                                                                    |
|----------|----------------------------------------------------------------------------------------------------|
| category | The [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md) to be created remotely. |

#### Throws

|                                                                                                       |                     |
|-------------------------------------------------------------------------------------------------------|---------------------|
| [RuntimeException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html) | if an error occurs. |
