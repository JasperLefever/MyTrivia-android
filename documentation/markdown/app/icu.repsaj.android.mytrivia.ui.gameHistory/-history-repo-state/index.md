//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.gameHistory](../index.md)/[HistoryRepoState](index.md)

# HistoryRepoState

interface [HistoryRepoState](index.md)

Represents the state of the API call to fetch the game history.

#### Inheritors

|                              |
|------------------------------|
| [Success](-success/index.md) |
| [Error](-error/index.md)     |
| [Loading](-loading/index.md) |

## Types

| Name                         | Summary                                                                                                                                                                           |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Error](-error/index.md)     | [androidJvm]<br>data class [Error](-error/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [HistoryRepoState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [HistoryRepoState](index.md)                                                                                                |
| [Success](-success/index.md) | [androidJvm]<br>object [Success](-success/index.md) : [HistoryRepoState](index.md)                                                                                                |
