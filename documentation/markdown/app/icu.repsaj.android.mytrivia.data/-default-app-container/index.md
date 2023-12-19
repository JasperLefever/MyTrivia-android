//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[DefaultAppContainer](index.md)

# DefaultAppContainer

[androidJvm]\
class [DefaultAppContainer](index.md)(
context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](../-app-container/index.md)

The default implementation of [AppContainer](../-app-container/index.md) that provides the actual
instances of repositories and services required.

## Constructors

|                                                  |                                                                                                                              |
|--------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| [DefaultAppContainer](-default-app-container.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name                                     | Summary                                                                                                                                                                                                                                                                                                                                                         |
|------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [categoryRepo](category-repo.md)         | [androidJvm]<br>open override val [categoryRepo](category-repo.md): [ICategoryRepo](../-i-category-repo/index.md)<br>Lazily initialized instance of [ICategoryRepo](../-i-category-repo/index.md), which provides a caching layer for category data.                                                                                                            |
| [historyRepo](history-repo.md)           | [androidJvm]<br>open override val [historyRepo](history-repo.md): [IGameHistoryRepo](../-i-game-history-repo/index.md)<br>Lazily initialized instance of [IGameHistoryRepo](../-i-game-history-repo/index.md), responsible for managing game history data.                                                                                                      |
| [questionRepo](question-repo.md)         | [androidJvm]<br>open override val [questionRepo](question-repo.md): [IQuestionRepo](../-i-question-repo/index.md)<br>Lazily initialized instance of [IQuestionRepo](../-i-question-repo/index.md), which manages question-related data through an API.                                                                                                          |
| [resourceProvider](resource-provider.md) | [androidJvm]<br>open override val [resourceProvider](resource-provider.md): [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md)<br>Lazily initialized instance of [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md), responsible for providing access to app resources. |
