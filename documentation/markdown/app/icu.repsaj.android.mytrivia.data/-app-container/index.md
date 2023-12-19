//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[AppContainer](index.md)

# AppContainer

interface [AppContainer](index.md)

Defines the main components needed throughout the application.

#### Inheritors

|                                                           |
|-----------------------------------------------------------|
| [DefaultAppContainer](../-default-app-container/index.md) |

## Properties

| Name                                     | Summary                                                                                                                                                               |
|------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [categoryRepo](category-repo.md)         | [androidJvm]<br>abstract val [categoryRepo](category-repo.md): [ICategoryRepo](../-i-category-repo/index.md)                                                          |
| [historyRepo](history-repo.md)           | [androidJvm]<br>abstract val [historyRepo](history-repo.md): [IGameHistoryRepo](../-i-game-history-repo/index.md)                                                     |
| [questionRepo](question-repo.md)         | [androidJvm]<br>abstract val [questionRepo](question-repo.md): [IQuestionRepo](../-i-question-repo/index.md)                                                          |
| [resourceProvider](resource-provider.md) | [androidJvm]<br>abstract val [resourceProvider](resource-provider.md): [ResourceProvider](../../icu.repsaj.android.mytrivia.ui.providers/-resource-provider/index.md) |
