//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.game](../index.md)/[QuestionsApiState](index.md)

# QuestionsApiState

interface [QuestionsApiState](index.md)

Represents the state of the API call to fetch questions.

#### Inheritors

|                              |
|------------------------------|
| [Success](-success/index.md) |
| [Error](-error/index.md)     |
| [Loading](-loading/index.md) |

## Types

| Name                         | Summary                                                                                                                                                                            |
|------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Error](-error/index.md)     | [androidJvm]<br>data class [Error](-error/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [QuestionsApiState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [QuestionsApiState](index.md)                                                                                                |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [QuestionsApiState](index.md)                                                                                                |
