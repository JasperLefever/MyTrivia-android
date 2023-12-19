//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[CachingCategoryRepository](index.md)/[refresh](refresh.md)

# refresh

[androidJvm]\
open suspend override fun [refresh](refresh.md)()

Refreshes the local category database by fetching the latest data from the API. It clears the
current data and repopulates it with the latest data. In case of a network timeout, an appropriate
action such as logging can be implemented.

#### Throws

|                                                                                                       |                     |
|-------------------------------------------------------------------------------------------------------|---------------------|
| [RuntimeException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html) | if an error occurs. |
