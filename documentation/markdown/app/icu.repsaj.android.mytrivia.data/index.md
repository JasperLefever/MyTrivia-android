//[app](../../index.md)/[icu.repsaj.android.mytrivia.data](index.md)

# Package-level declarations

## Types

| Name                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|--------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ApiQuestionRepo](-api-question-repo/index.md)                     | [androidJvm]<br>class [ApiQuestionRepo](-api-question-repo/index.md)(questionApiService: [IQuestionApiService](../icu.repsaj.android.mytrivia.network.question/-i-question-api-service/index.md)) : [IQuestionRepo](-i-question-repo/index.md)<br>Repository implementation for accessing trivia questions via an API. This repository fetches trivia questions from a remote data source.                                                                     |
| [AppContainer](-app-container/index.md)                            | [androidJvm]<br>interface [AppContainer](-app-container/index.md)<br>Defines the main components needed throughout the application.                                                                                                                                                                                                                                                                                                                            |
| [CachingCategoryRepository](-caching-category-repository/index.md) | [androidJvm]<br>class [CachingCategoryRepository](-caching-category-repository/index.md)(categoryDao: [CategoryDao](../icu.repsaj.android.mytrivia.data.database/-category-dao/index.md), categoryApi: [ICategoryApiService](../icu.repsaj.android.mytrivia.network.categroy/-i-category-api-service/index.md)) : [ICategoryRepo](-i-category-repo/index.md)<br>A repository implementation that caches categories locally and updates them from a remote API. |
| [DefaultAppContainer](-default-app-container/index.md)             | [androidJvm]<br>class [DefaultAppContainer](-default-app-container/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](-app-container/index.md)<br>The default implementation of [AppContainer](-app-container/index.md) that provides the actual instances of repositories and services required.                                                                                     |
| [GameHistoryRepository](-game-history-repository/index.md)         | [androidJvm]<br>class [GameHistoryRepository](-game-history-repository/index.md)(historyDao: [GameHistoryDao](../icu.repsaj.android.mytrivia.data.database/-game-history-dao/index.md)) : [IGameHistoryRepo](-i-game-history-repo/index.md)<br>Concrete implementation of [IGameHistoryRepo](-i-game-history-repo/index.md), handling game history data operations.                                                                                            |
| [ICategoryRepo](-i-category-repo/index.md)                         | [androidJvm]<br>interface [ICategoryRepo](-i-category-repo/index.md)<br>Repository interface for handling category data operations.                                                                                                                                                                                                                                                                                                                            |
| [IGameHistoryRepo](-i-game-history-repo/index.md)                  | [androidJvm]<br>interface [IGameHistoryRepo](-i-game-history-repo/index.md)<br>Repository interface for handling game history data operations.                                                                                                                                                                                                                                                                                                                 |
| [IQuestionRepo](-i-question-repo/index.md)                         | [androidJvm]<br>interface [IQuestionRepo](-i-question-repo/index.md)<br>Repository interface for accessing trivia questions.                                                                                                                                                                                                                                                                                                                                   |