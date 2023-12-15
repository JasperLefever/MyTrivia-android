package icu.repsaj.android.mytrivia.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import icu.repsaj.android.mytrivia.data.database.TriviaDb
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import icu.repsaj.android.mytrivia.network.question.IQuestionApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val categoryRepo: CategoryRepo
    val historyRepo: GameHistoryRepo
    val questionRepo: QuestionRepo
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val baseUrl = "http://10.0.2.2:8080"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(baseUrl)
        .build()

    private val categoryApiService: ICategoryApiService by lazy {
        retrofit.create(ICategoryApiService::class.java)
    }

    private val questionApiService: IQuestionApiService by lazy {
        retrofit.create(IQuestionApiService::class.java)
    }

    override val categoryRepo: CategoryRepo by lazy {
        CachingCategoryRepository(
            TriviaDb.getDatabase(context = context).CategoryDao(),
            categoryApiService
        )
    }

    override val historyRepo: GameHistoryRepo by lazy {
        GameHistoryRepository(
            TriviaDb.getDatabase(context = context).GameHistoryDao()
        )
    }

    override val questionRepo: QuestionRepo by lazy {
        ApiQuestionRepo(questionApiService)
    }

}
