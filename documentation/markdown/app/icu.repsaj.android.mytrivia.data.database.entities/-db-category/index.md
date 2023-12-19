//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data.database.entities](../index.md)/[DbCategory](index.md)

# DbCategory

[androidJvm]\
data class [DbCategory](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) =
&quot;&quot;, val
questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)

Represents a category entity in the database.

## Constructors

|                               |                                                                                                                                                                                                                                                                                                                                                                                                           |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [DbCategory](-db-category.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0) |

## Properties

| Name                               | Summary                                                                                                                                                                                              |
|------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [icon](icon.md)                    | [androidJvm]<br>val [icon](icon.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Icon associated with the category. This is the icon string from SF Symbols. |
| [id](id.md)                        | [androidJvm]<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Unique identifier of the category, represented by a UUID.                             |
| [name](name.md)                    | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the category.                                                       |
| [questionCount](question-count.md) | [androidJvm]<br>val [questionCount](question-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>The number of questions available in this category.        |

## Functions

| Name                                     | Summary                                                                                                                                                                                                                                                                                                                   |
|------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [asDomainObject](../as-domain-object.md) | [androidJvm]<br>fun [DbCategory](index.md).[asDomainObject](../as-domain-object.md)(): [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)<br>Converts a database entity [DbCategory](index.md) into its domain representation [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md). |
