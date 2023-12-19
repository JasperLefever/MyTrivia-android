//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.categoryOverview](../index.md)/[CategoryApiState](index.md)

# CategoryApiState

interface [CategoryApiState](index.md)

Represents the state of the API call to fetch categories.

#### Inheritors

|                              |
|------------------------------|
| [Success](-success/index.md) |
| [Error](-error/index.md)     |
| [Loading](-loading/index.md) |

## Types

| Name                         | Summary                                                                                                                                                                           |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Error](-error/index.md)     | [androidJvm]<br>data class [Error](-error/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [CategoryApiState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [CategoryApiState](index.md)                                                                                                |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [CategoryApiState](index.md)                                                                                                |
