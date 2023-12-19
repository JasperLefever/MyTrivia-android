//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.addCategory](../index.md)/[AddCategoryApiState](index.md)

# AddCategoryApiState

interface [AddCategoryApiState](index.md)

Represents the possible states of the API call for adding a new category. This sealed interface is
used to encapsulate the various states of the API interaction, from initialization to completion.

#### Inheritors

|                              |
|------------------------------|
| [Init](-init/index.md)       |
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md)     |

## Types

| Name                         | Summary                                                                                                                                                                              |
|------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Error](-error/index.md)     | [androidJvm]<br>data class [Error](-error/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AddCategoryApiState](index.md) |
| [Init](-init/index.md)       | [androidJvm]<br>object [Init](-init/index.md) : [AddCategoryApiState](index.md)                                                                                                      |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [AddCategoryApiState](index.md)                                                                                                |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [AddCategoryApiState](index.md)                                                                                                |
