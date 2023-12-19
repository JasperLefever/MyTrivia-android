//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database](../index.md)/[CategoryDao](index.md)/[getById](get-by-id.md)

# getById

[androidJvm]\
abstract fun [getById](get-by-id.md)(
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)):
Flow&lt;[DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md)
&gt;

Retrieves a specific category by its ID.

#### Return

A Flow emitting
the [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md)
item with the specified ID.

#### Parameters

androidJvm

|     |                                       |
|-----|---------------------------------------|
| id  | The UUID of the category to retrieve. |
