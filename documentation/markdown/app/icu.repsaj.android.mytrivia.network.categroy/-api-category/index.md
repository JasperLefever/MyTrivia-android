//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.categroy](../index.md)/[ApiCategory](index.md)

# ApiCategory

[androidJvm]\
@Serializable

data class [ApiCategory](index.md)(val
id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val
name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val
icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var
questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)

Represents a category as defined in the API. This data class is used for serialization and
deserialization of category data from API responses.

## Constructors

|                                 |                                                                                                                                                                                                                                                                                                                                                                                            |
|---------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ApiCategory](-api-category.md) | [androidJvm]<br>constructor(id: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), questionCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0) |

## Properties

| Name                               | Summary                                                                                                                                                                                                                                                                                                                                                                               |
|------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [icon](icon.md)                    | [androidJvm]<br>val [icon](icon.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Icon key representing the category.                                                                                                                                                                                                                          |
| [id](id.md)                        | [androidJvm]<br>@Serializable(with = [UUIDSerializer::class](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md))<br>val [id](id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Unique identifier of the category, serialized using [UUIDSerializer](../../icu.repsaj.android.mytrivia.network/-u-u-i-d-serializer/index.md). |
| [name](name.md)                    | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the category.                                                                                                                                                                                                                                        |
| [questionCount](question-count.md) | [androidJvm]<br>var [questionCount](question-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The number of questions available in this category, with a default value of 0.                                                                                                                                                                  |

## Functions

| Name                                     | Summary                                                                                                                                                                                                                                                                                                     |
|------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [asDomainObject](../as-domain-object.md) | [androidJvm]<br>fun [ApiCategory](index.md).[asDomainObject](../as-domain-object.md)(): [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md)<br>Converts an individual [ApiCategory](index.md) to a [Category](../../icu.repsaj.android.mytrivia.model/-category/index.md) domain object. |
