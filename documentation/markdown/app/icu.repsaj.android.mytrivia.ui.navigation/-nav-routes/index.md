//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.navigation](../index.md)/[NavRoutes](index.md)

# NavRoutes

[androidJvm]\
enum [NavRoutes](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)
&lt;[NavRoutes](index.md)&gt;

Enum defining the navigation routes used in the application

## Entries

|                                       |                                                       |
|---------------------------------------|-------------------------------------------------------|
| [Categories](-categories/index.md)    | [androidJvm]<br>[Categories](-categories/index.md)    |
| [Game](-game/index.md)                | [androidJvm]<br>[Game](-game/index.md)                |
| [History](-history/index.md)          | [androidJvm]<br>[History](-history/index.md)          |
| [AddCategory](-add-category/index.md) | [androidJvm]<br>[AddCategory](-add-category/index.md) |

## Types

| Name                             | Summary                                                 |
|----------------------------------|---------------------------------------------------------|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name                                                                   | Summary                                                                                                                                                                                                                                                                        |
|------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [entries](entries.md)                                                  | [androidJvm]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[NavRoutes](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [icon](icon.md)                                                        | [androidJvm]<br>val [icon](icon.md): [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html)<br>The icon associated with the route, represented as an ImageVector.                                                  |
| [name](-add-category/index.md#-372974862%2FProperties%2F-912451524)    | [androidJvm]<br>val [name](-add-category/index.md#-372974862%2FProperties%2F-912451524): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)                                                                                                      |
| [ordinal](-add-category/index.md#-739389684%2FProperties%2F-912451524) | [androidJvm]<br>val [ordinal](-add-category/index.md#-739389684%2FProperties%2F-912451524): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)                                                                                                         |
| [title](title.md)                                                      | [androidJvm]<br>val [title](title.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The string resource ID for the title of the route.                                                                                                        |

## Functions

| Name                     | Summary                                                                                                                                                                                                                                                                                                                                                                        |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [valueOf](value-of.md)   | [androidJvm]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NavRoutes](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md)      | [androidJvm]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NavRoutes](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared.                                                                                                                          |
| [withArgs](with-args.md) | [androidJvm]<br>fun [withArgs](with-args.md)(vararg args: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Constructs a navigation route string with optional arguments. Useful for creating routes that require parameters.                             |
