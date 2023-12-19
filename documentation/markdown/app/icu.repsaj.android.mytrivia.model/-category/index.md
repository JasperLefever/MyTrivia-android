//[app](../../../index.md)/[icu.repsaj.android.mytrivia.model](../index.md)/[Category](index.md)

# Category

[androidJvm]\
data class [Category](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, val
questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val
image: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html) =
getImage(icon))

Model class representing a trivia category.

## Constructors

|                          |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Category](-category.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, image: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html) = getImage(icon)) |

## Properties

| Name                               | Summary                                                                                                                                                                                                                                           |
|------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [icon](icon.md)                    | [androidJvm]<br>val [icon](icon.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Icon key representing the category. SF Symbols are used for icons.                                                       |
| [id](id.md)                        | [androidJvm]<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Unique identifier of the category.                                                                                                 |
| [image](image.md)                  | [androidJvm]<br>val [image](image.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)<br>The graphical representation (ImageVector) for the category icon in android compose. |
| [name](name.md)                    | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the category.                                                                                                    |
| [questionCount](question-count.md) | [androidJvm]<br>val [questionCount](question-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>The number of questions available in this category.                                                     |

## Functions

| Name                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                               |
|----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [asDbEntity](../../icu.repsaj.android.mytrivia.data.database.entities/as-db-entity.md) | [androidJvm]<br>fun [Category](index.md).[asDbEntity](../../icu.repsaj.android.mytrivia.data.database.entities/as-db-entity.md)(): [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md)<br>Converts a domain object [Category](index.md) into a database entity [DbCategory](../../icu.repsaj.android.mytrivia.data.database.entities/-db-category/index.md). |
| [asPostCategory](../as-post-category.md)                                               | [androidJvm]<br>fun [Category](index.md).[asPostCategory](../as-post-category.md)(): [CreateCategory](../../icu.repsaj.android.mytrivia.network.categroy/-create-category/index.md)<br>Converts a [Category](index.md) instance to a [CreateCategory](../../icu.repsaj.android.mytrivia.network.categroy/-create-category/index.md) instance for use in network requests.                             |
