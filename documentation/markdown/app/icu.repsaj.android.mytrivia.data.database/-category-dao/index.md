//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database](../index.md)/[CategoryDao](index.md)

# CategoryDao

[androidJvm]\
interface [CategoryDao](index.md)

Data access object for the 'categories' table.

## Functions

| Name                    | Summary                                                                                                                                                                                                                                                                                                                                                       |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [clear](clear.md)       | [androidJvm]<br>abstract suspend fun [clear](clear.md)()<br>Clears all entries from the 'categories' table.                                                                                                                                                                                                                                                   |
| [delete](delete.md)     | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md))<br>Deletes a specific [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md) item from the database.                                                       |
| [getAll](get-all.md)    | [androidJvm]<br>abstract fun [getAll](get-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md)&gt;&gt;<br>Retrieves all category entries from the database as a list.                                  |
| [getById](get-by-id.md) | [androidJvm]<br>abstract fun [getById](get-by-id.md)(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): Flow&lt;[DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md)&gt;<br>Retrieves a specific category by its ID.                                                                    |
| [insert](insert.md)     | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md))<br>Inserts a [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md) item into the database. If a category with the same ID already exists, it is replaced. |
