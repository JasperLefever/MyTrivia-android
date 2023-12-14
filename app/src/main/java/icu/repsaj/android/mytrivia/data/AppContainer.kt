package icu.repsaj.android.mytrivia.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import icu.repsaj.android.mytrivia.data.database.TriviaDb
import icu.repsaj.android.mytrivia.network.categroy.ICategoryApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val categoryRepo: CategoryRepo
    val historyRepo: GameHistoryRepo
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val baseUrl = "http://10.0.2.2:3000"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: ICategoryApiService by lazy {
        retrofit.create(ICategoryApiService::class.java)
    }

    override val categoryRepo: CategoryRepo by lazy {
        CachingCategoryRepository(
            TriviaDb.getDatabase(context = context).CategoryDao(),
            retrofitService
        )
    }

    override val historyRepo: GameHistoryRepo by lazy {
        GameHistoryRepository(
            TriviaDb.getDatabase(context = context).GameHistoryDao()
        )
    }
}
