//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network](../index.md)/[Metadata](index.md)

# Metadata

[androidJvm]\
@Serializable

data class [Metadata](index.md)(val
page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val
per: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val
total: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

Represents the metadata typically associated with responses from an API. This data class is commonly
used for pagination and total item count information.

## Constructors

|                          |                                                                                                                                                                                                                                                                                   |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Metadata](-metadata.md) | [androidJvm]<br>constructor(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), per: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), total: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name              | Summary                                                                                                                                                                    |
|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [page](page.md)   | [androidJvm]<br>val [page](page.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The current page number in a paginated response.        |
| [per](per.md)     | [androidJvm]<br>val [per](per.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The number of items per page.                             |
| [total](total.md) | [androidJvm]<br>val [total](total.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The total number of items available across all pages. |
