//[app](../../../index.md)/[icu.repsaj.android.mytrivia.ui.gameHistory](../index.md)/[HistoryViewModel](index.md)

# HistoryViewModel

[androidJvm]\
class [HistoryViewModel](index.md)(
historyRepo: [IGameHistoryRepo](../../icu.repsaj.android.mytrivia.data/-i-game-history-repo/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

|                                            |                                                                                                                                    |
|--------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| [HistoryViewModel](-history-view-model.md) | [androidJvm]<br>constructor(historyRepo: [IGameHistoryRepo](../../icu.repsaj.android.mytrivia.data/-i-game-history-repo/index.md)) |

## Types

| Name                             | Summary                                                 |
|----------------------------------|---------------------------------------------------------|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name                            | Summary                                                                                                                            |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| [repoState](repo-state.md)      | [androidJvm]<br>var [repoState](repo-state.md): [HistoryRepoState](../-history-repo-state/index.md)                                |
| [uiListState](ui-list-state.md) | [androidJvm]<br>lateinit var [uiListState](ui-list-state.md): StateFlow&lt;[HistoryListState](../-history-list-state/index.md)&gt; |

## Functions

| Name                                                        | Summary                                                                                                                                                                                                                                                                 |
|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [deleteHistoryItem](delete-history-item.md)                 | [androidJvm]<br>fun [deleteHistoryItem](delete-history-item.md)(item: [HistoryItem](../../icu.repsaj.android.mytrivia.model/-history-item/index.md))<br>Deletes a history item from the database.                                                                       |
| [fetchHistory](fetch-history.md)                            | [androidJvm]<br>fun [fetchHistory](fetch-history.md)()<br>Fetches the game history from the database.                                                                                                                                                                   |
