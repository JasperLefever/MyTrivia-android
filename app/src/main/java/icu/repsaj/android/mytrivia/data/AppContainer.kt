package icu.repsaj.android.mytrivia.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import icu.repsaj.android.mytrivia.data.database.TriviaDb
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import icu.repsaj.android.mytrivia.network.health.IHealthApiService
import icu.repsaj.android.mytrivia.network.question.IQuestionApiService
import icu.repsaj.android.mytrivia.ui.providers.ResourceProvider
import icu.repsaj.android.mytrivia.ui.providers.ResourceProviderImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Defines the main components needed throughout the application.
 */
interface AppContainer {
    val categoryRepo: ICategoryRepo
    val historyRepo: IGameHistoryRepo
    val questionRepo: IQuestionRepo
    val resourceProvider: ResourceProvider
    val healthRepo: IHealthRepo
}

/**
 * The default implementation of [AppContainer] that provides the actual instances of repositories and services required.
 *
 * @property context The context used for initializing various components that require it, like databases and resource providers.
 */
class DefaultAppContainer(private val context: Context) : AppContainer {

    private val baseUrl = "http://10.0.2.2:8080"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(baseUrl)
        .build()

    /**
     * Lazily initialized instance of [ICategoryApiService] for making network requests related to categories.
     */
    private val categoryApiService: ICategoryApiService by lazy {
        retrofit.create(ICategoryApiService::class.java)
    }

    /**
     * Lazily initialized instance of [IQuestionApiService] for making network requests related to questions.
     */
    private val questionApiService: IQuestionApiService by lazy {
        retrofit.create(IQuestionApiService::class.java)
    }

    /**
     * Lazily initialized instance of [IHealthApiService] for making network requests related to health.
     */
    private val healthApiService: IHealthApiService by lazy {
        retrofit.create(IHealthApiService::class.java)
    }

    /**
     * Lazily initialized instance of [ICategoryRepo], which provides a caching layer for category data.
     */
    override val categoryRepo: ICategoryRepo by lazy {
        CachingCategoryRepository(
            TriviaDb.getDatabase(context = context).categoryDao(),
            categoryApiService
        )
    }

    /**
     * Lazily initialized instance of [IGameHistoryRepo], responsible for managing game history data.
     */
    override val historyRepo: IGameHistoryRepo by lazy {
        GameHistoryRepository(
            TriviaDb.getDatabase(context = context).gameHistoryDao()
        )
    }

    /**
     * Lazily initialized instance of [IQuestionRepo], which manages question-related data through an API.
     */
    override val questionRepo: IQuestionRepo by lazy {
        ApiQuestionRepo(questionApiService)
    }

    /**
     * Lazily initialized instance of [IHealthRepo], which manages health-related data through an API.
     */
    override val healthRepo: IHealthRepo by lazy {
        APIHealthRepo(healthService = healthApiService)
    }

    /**
     * Lazily initialized instance of [ResourceProvider], responsible for providing access to app resources.
     */
    override val resourceProvider: ResourceProvider by lazy {
        ResourceProviderImpl(context)
    }


}
